package com.example.crudConAjax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudConAjax.entidades.Doctor;
import com.example.crudConAjax.entidades.Especialidad;
import com.example.crudConAjax.repositorios.IDoctor;
import com.example.crudConAjax.repositorios.IEspecialidad;

@Service
public class DoctorService {

	@Autowired
	IDoctor rdoctor;

	@Autowired
	IEspecialidad respecialidad;

	public List<Doctor> getAll() {
		return (List<Doctor>) rdoctor.findAll();
	}

	// GUARDAR

	public boolean SaveOrUpdate(Doctor entity) {

		try {
			rdoctor.save(entity);
			return true;

		} catch (Exception e) {

			return false;
		}

	}

//ELIMINAR

	public boolean delete(Doctor entity) {

		try {
			rdoctor.delete(entity);
			return true;

		} catch (Exception e) {

			return false;
		}

	}

	public Especialidad getEspecialidad(Integer id) {
		return respecialidad.findById(id).get();

	}

	public Doctor getDoctor(Integer id) {
		return rdoctor.findById(id).get();
	}

}