package com.example.crudConAjax.entidades;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date fecha;
	private String sintomas;
	private String diagnostico;
	
	//PARA LA OTRA TABLA DE CONSULTA CON DOCTOR
	@ManyToOne(fetch = FetchType.EAGER )
	@NotNull
	Doctor doctor;
	
	
	//HACIENDO LA RELACION PARA LA OTRA TABLA DE CONSULTA CON PACIENTE
	@ManyToOne(fetch = FetchType.EAGER)
	Paciente paciente;
	
	public Consulta() {
		super();
	}

/**/
	public Consulta(Integer id, Date fecha, String sintomas, String diagnostico) {
		
		this.id = id;
		this.fecha = fecha;
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getSintomas() {
		return sintomas;
	}


	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}


	public String getDiagnostico() {
		return diagnostico;
	}


	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	
	//DATOS DE LA OTRA TABLA

	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	///DATOS DE LA OTRA TABLA DE CONSULTTA CON PACIENTE
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
		
	}
	


