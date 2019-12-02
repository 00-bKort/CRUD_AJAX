package com.example.ajax.repository;

import com.example.ajax.entidades.Paciente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IPaciente
 */
@Repository
public interface IPaciente extends CrudRepository<Paciente, Integer> {

}