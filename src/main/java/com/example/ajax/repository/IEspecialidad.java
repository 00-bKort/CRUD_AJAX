
package com.example.ajax.repository;

import com.example.ajax.entidades.Especialidad;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IEspecialidad
 */
@Repository
public interface IEspecialidad extends CrudRepository<Especialidad, Integer> {

}