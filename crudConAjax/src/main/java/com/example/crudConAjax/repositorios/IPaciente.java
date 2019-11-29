package com.example.crudConAjax.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.crudConAjax.entidades.Paciente;

public interface IPaciente extends CrudRepository<Paciente, Integer> {

}
