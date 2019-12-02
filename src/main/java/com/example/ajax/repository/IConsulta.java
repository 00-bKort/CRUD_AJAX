package com.example.ajax.repository;

import com.example.ajax.entidades.Consulta;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IConsulta
 */
@Repository
public interface IConsulta extends CrudRepository<Consulta, Integer> {

}