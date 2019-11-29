package com.example.crudConAjax.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.crudConAjax.entidades.Consulta;
import com.example.crudConAjax.service.ConsultaService;

@Controller
@RequestMapping(value = "consulta")
public class ConsultaController {
	@Autowired
	/* IConsulta rconsulta; */
	ConsultaService daoconsulta;


	@GetMapping(value="index")
    public String index() {
        return new String("/views/consulta");
    }

	// LISTAR LOS REGISTROS Y en SERVICE
	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Consulta> getDoctor() {
		return (List<Consulta>) daoconsulta.getAll();
	}

	// PARA GUARDAR LOS REGISTROS Y EN SERVICE
	@GetMapping(value = "save")
	public HashMap<String, String> save(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,

			@RequestParam String sintomas, @RequestParam String diagnostico, @RequestParam Integer iddoctor,
			@RequestParam Integer idpaciente) {

		Consulta consulta = new Consulta();

		HashMap<String, String> jsonReturn = new HashMap<>();

		// ASIGNANDO VALOR AL OBJETO
		consulta.setFecha(fecha);
		consulta.setSintomas(sintomas);
		consulta.setDiagnostico(diagnostico);
		consulta.setDoctor(daoconsulta.getDoctor(iddoctor));
		consulta.setPaciente(daoconsulta.getPaciente(idpaciente));

		try {
			daoconsulta.SaveOrUpdate(consulta); // GUARDANDO EL REGISTRO CONSULTA

			jsonReturn.put("estado", "ok");
			jsonReturn.put("mensaje", "registro guardado");

			return jsonReturn;

		} catch (Exception e) {

			jsonReturn.put("estado", "error");
			jsonReturn.put("mensaje", "registro no guardado" + e.getMessage());

			return jsonReturn;
		}

	}

	///

	// ACTUALIZAR

	@GetMapping(value = "update/{id}")
	@ResponseBody
	public HashMap<String, String> save(@RequestParam Integer id,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha, @RequestParam String sintomas,
			@RequestParam String diagnostico, @RequestParam Integer iddoctor, @RequestParam Integer idpaciente) {

		HashMap<String, String> jsonReturn = new HashMap<>();

		Consulta consulta = new Consulta();
		consulta.setId(id);
		consulta.setFecha(fecha);
		consulta.setSintomas(sintomas);
		consulta.setDiagnostico(diagnostico);
		consulta.setDoctor(daoconsulta.getDoctor(iddoctor));
		consulta.setPaciente(daoconsulta.getPaciente(idpaciente));
		try {
			daoconsulta.SaveOrUpdate(consulta); // GUARDANDO EL REGISTRO CONSULTA

			jsonReturn.put("estado", "ok");
			jsonReturn.put("mensaje", "registro actualizado");

			return jsonReturn;

		} catch (Exception e) {

			jsonReturn.put("estado", "error");
			jsonReturn.put("mensaje", "registro no actualizado" + e.getMessage());

			return jsonReturn;
		}

	}

	// ELIMINAR
	@GetMapping(value = "delete/{id}")
	@ResponseBody
	public HashMap<String, String> delete(@PathVariable Integer id) {

		HashMap<String, String> jsonReturn = new HashMap<>();

		/**/

		try {

			Consulta consulta = daoconsulta.getConsulta(id);
			daoconsulta.delete(consulta); // GUARDANDO EL REGISTRO DE CONSULTA

			jsonReturn.put("estado", "ok");
			jsonReturn.put("mensaje", "registro eliminado");

			return jsonReturn;

		} catch (Exception e) {

			jsonReturn.put("estado", "error");
			jsonReturn.put("mensaje", "registro no eliminado" + e.getMessage());

			return jsonReturn;
		}

	}

}