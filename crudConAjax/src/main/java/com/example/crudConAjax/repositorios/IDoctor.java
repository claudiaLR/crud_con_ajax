package com.example.crudConAjax.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.crudConAjax.entidades.Doctor;

@Repository
public interface IDoctor extends CrudRepository<Doctor, Integer> {

}
