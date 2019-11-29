package com.example.crudConAjax.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.crudConAjax.entidades.Especialidad;
import com.example.crudConAjax.repositorios.IEspecialidad;

@Controller
@RequestMapping("especialidades")
public class EspecialidadController {

	@Autowired
	IEspecialidad respecialidad;


	@GetMapping(value="index")
    public String index() {
        return new String("/views/especialidad");
    }

	// LISTAR LOS REGISTROS
	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Especialidad> getAllEspecialidad() {
		return (List<Especialidad>) respecialidad.findAll();
	}

// GUARDAR
	@GetMapping(value = "save")
	@ResponseBody
	public HashMap<String, String> save(

			@RequestParam String especialidad) {

		Especialidad especial = new Especialidad(); // creando el objeto especialidad

		HashMap<String, String> jsonReturn = new HashMap<>();

		// ASIGNANDO DATOS AL OBJETO ESPECIALIDAD
		especial.setEspecialidad(especialidad);

		// MANEJANDO CUALQUIER EXEPCION DE ERROR

		try {
			respecialidad.save(especial); // GUARDANDO EL REGISTRO DE ESPECIALIDAD

			jsonReturn.put("estado", "ok");
			jsonReturn.put("mensaje", "registro guardado");

			return jsonReturn;

		} catch (Exception e) {

			jsonReturn.put("estado", "error");
			jsonReturn.put("mensaje", "registro no guardado" + e.getMessage());

			return jsonReturn;
		}

	}

	// ACTUALIZAR

	@GetMapping(value = "update/{id}")
	@ResponseBody
	public HashMap<String, String> update(@RequestParam Integer id, @RequestParam String especialidad) {

		HashMap<String, String> jsonReturn = new HashMap<>();

		Especialidad especial = new Especialidad();
		especial.setId(id);
		especial.setEspecialidad(especialidad);

		try {
			respecialidad.save(especial); // GUARDANDO EL REGISTRO ESPECIALIDAD

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
			Especialidad especial = respecialidad.findById(id).get();
			respecialidad.delete(especial); // GUARDANDO EL REGISTRO ESPECIALIDAD

			jsonReturn.put("estado", "ok");
			jsonReturn.put("mensaje", "registro actualizado");

			return jsonReturn;

		} catch (Exception e) {

			jsonReturn.put("estado", "error");
			jsonReturn.put("mensaje", "registro no actualizado" + e.getMessage());

			return jsonReturn;
		}

	}

}
