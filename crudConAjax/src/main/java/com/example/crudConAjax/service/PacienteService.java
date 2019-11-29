package com.example.crudConAjax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudConAjax.entidades.Consulta;
import com.example.crudConAjax.entidades.Paciente;
import com.example.crudConAjax.repositorios.IConsulta;
import com.example.crudConAjax.repositorios.IPaciente;

@Service
public class PacienteService {
	@Autowired
	IPaciente rpaciente;
	
	@Autowired
	IConsulta rconsulta;
	
	
	//PARA LISTAR
	public List<Paciente>getAll(){
		return (List<Paciente>) rpaciente.findAll();
	}

	//GUARDAR

	public boolean SaveOrUpdate(Paciente entity) {
		
		try {
			rpaciente.save(entity);
			return true;
			
		}catch (Exception e) {
			
			return false;
		}
		
	}

	//ELIMINAR

	public boolean delete(Paciente entity) {
		
		try {
			rpaciente.delete(entity);
			return true;
			
		}catch (Exception e) {
			
			return false;
		}
		
	}
	
	
	public Consulta getConsulta(Integer id) {
		return rconsulta.findById(id).get();

		}


		public Paciente getPaciente(Integer id) {
			return rpaciente.findById(id).get();
		}

	
}
