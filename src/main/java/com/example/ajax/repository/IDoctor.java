
package com.example.ajax.repository;

import com.example.ajax.entidades.Doctor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IDoctor
 */
@Repository
public interface IDoctor extends CrudRepository<Doctor, Integer> {

}