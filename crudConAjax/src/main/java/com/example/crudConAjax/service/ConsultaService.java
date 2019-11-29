package com.example.crudConAjax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudConAjax.entidades.Consulta;
import com.example.crudConAjax.entidades.Doctor;
import com.example.crudConAjax.entidades.Paciente;
import com.example.crudConAjax.repositorios.IConsulta;
import com.example.crudConAjax.repositorios.IDoctor;
import com.example.crudConAjax.repositorios.IPaciente;

@Service
public class ConsultaService {
	
	
	@Autowired
	IConsulta rconsulta;
	@Autowired
	IDoctor rdoctor;
	/**/
	
	
	@Autowired
	IPaciente rpaciente;
	//METODOPARA LISTAR Y ENSERVICE CON EL CONTRALADOR
	
	public List<Consulta> getAll(){
		return (List<Consulta>) rconsulta.findAll();
	}
	//GUARDAR

	public boolean SaveOrUpdate(Consulta entity) {
		
		try {
			rconsulta.save(entity);
			return true;
			
		}catch (Exception e) {
			
			return false;
		}
		
	}
	
	
	//ELIMINAR

	public boolean delete(Consulta entity) {
		
		try {
			rconsulta.delete(entity);
			return true;
			
		}catch (Exception e) {
			
			return false;
		}
		
	}

	
	
	
	public Doctor getDoctor(Integer id) {
		return rdoctor.findById(id).get();
	}
	
	
	public Consulta getConsulta(Integer id) {
		return rconsulta.findById(id).get();
	}
	
	
	//para paciente
	
	
	
	public Paciente getPaciente(Integer id) {
		return rpaciente.findById(id).get();
	}
}
