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

import com.example.crudConAjax.entidades.Paciente;
import com.example.crudConAjax.repositorios.IPaciente;


@Controller
@RequestMapping("paciente")
public class PacienteController {
	
	@Autowired
	IPaciente rpaciente;
	
	@GetMapping(value="index")
    public String index() {
        return new String("/views/paciente");
    }


	//LISTAR LOS REGISTROS
	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Paciente>getPaciente(){
		return (List<Paciente>) rpaciente.findAll();
	}

	
	//guardar
	
	
	@GetMapping(value = "save")
	@ResponseBody
	public HashMap<String, String>save(
			@RequestParam String nombre,
			@RequestParam String direccion
			){
		
		Paciente paciente=new Paciente();
		
		HashMap<String, String> jsonReturn = new HashMap<>();
		
		// ASIGNANDO DATOS AL OBJETO ESPECIALIDAD
				paciente.setNombre(nombre);
				paciente.setDireccion(direccion);
				
				try {
					rpaciente.save(paciente); // GUARDANDO EL REGISTRO DE ESPECIALIDAD

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
		public HashMap<String, String> update(@RequestParam Integer id, @RequestParam String nombre,@RequestParam String direccion) {

			HashMap<String, String> jsonReturn = new HashMap<>();
			
			
			Paciente paciente=new Paciente();
			paciente.setId(id);
			paciente.setNombre(nombre);
			paciente.setDireccion(direccion);
			
			

			try {
				rpaciente.save(paciente); // GUARDANDO EL REGISTRO ESPECIALIDAD

				jsonReturn.put("estado", "ok");
				jsonReturn.put("mensaje", "registro actualizado");

				return jsonReturn;

			} catch (Exception e) {

				jsonReturn.put("estado", "error");
				jsonReturn.put("mensaje", "registro no actualizado" + e.getMessage());

				return jsonReturn;
			}

		}
			
		
		//eliminar
		
		// ELIMINAR
		@GetMapping(value = "delete/{id}")
		@ResponseBody
		public HashMap<String, String> delete(@PathVariable Integer id) {

			HashMap<String, String> jsonReturn = new HashMap<>();
			
			
			try {
				Paciente paciente = rpaciente.findById(id).get();
				rpaciente.delete(paciente); // GUARDANDO EL REGISTRO ESPECIALIDAD

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


