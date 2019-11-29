package com.example.crudConAjax.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Doctor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;
	private String direccion;
	
	
	
	
	/*para la otra tabla*/
	/*@ManyToOne(optional = true,fetch = FetchType.EAGER)*/
	
	@ManyToOne(fetch = FetchType.EAGER )
	@NotNull
	private Especialidad especialidad;

	//CONSTRUCTORES
	public Doctor() {
		super();
	}

	public Doctor(Integer id, String nombre, String direccion) {
		
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	//SETERS AND GETERS
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	//SETERS AND GETERS DE LA OTRA TABLA
	
	
		public Especialidad getEspecialidad() {
			return especialidad;
		}

		public void setEspecialidad(Especialidad especialidad) {
			this.especialidad = especialidad;
		}
		
	
	
	
	
}
