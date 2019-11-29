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

import com.example.crudConAjax.entidades.Doctor;
import com.example.crudConAjax.service.DoctorService;

@Controller

@RequestMapping("doctores")
public class DoctorController {

	@Autowired
//	IDoctor rdoctor;
	DoctorService daodoctor;
	
	
	@GetMapping(value="index")
    public String index() {
        return new String("/views/doctor");
    }

	// LISTAR LOS REGISTROS
	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)

	@ResponseBody
	public List<Doctor> getAllDoctor() {

		return (List<Doctor>) daodoctor.getAll();
	}

	// GUARDAR

	@GetMapping(value = "save")
	@ResponseBody
	public HashMap<String, String> save(@RequestParam String nombre,

			@RequestParam String direccion, @RequestParam Integer idEspecialidad) {

		Doctor doctor = new Doctor(); // creando el objeto doctor

		HashMap<String, String> jsonReturn = new HashMap<>();

		// ASIGNANDO DATOS AL OBJETO DOCTOR
		doctor.setNombre(nombre);
		doctor.setDireccion(direccion);
		doctor.setEspecialidad(daodoctor.getEspecialidad(idEspecialidad));

		// MANEJANDO CUALQUIER EXEPCION DE ERROR

		try {
			daodoctor.SaveOrUpdate(doctor); // GUARDANDO EL REGISTRO DOCTOR

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
	public HashMap<String, String> save(@RequestParam Integer id, @RequestParam String nombre,

			@RequestParam String direccion, @RequestParam Integer idEspecialidad) {

		HashMap<String, String> jsonReturn = new HashMap<>();

		Doctor doctor = new Doctor();
		doctor.setId(id);
		doctor.setNombre(nombre);
		doctor.setDireccion(direccion);
		doctor.setEspecialidad(daodoctor.getEspecialidad(idEspecialidad));

		try {
			daodoctor.SaveOrUpdate(doctor); // GUARDANDO EL REGISTRO DOCTOR

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

			Doctor doctor = daodoctor.getDoctor(id);

			daodoctor.delete(doctor); // GUARDANDO EL REGISTRO DOCTOR

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
