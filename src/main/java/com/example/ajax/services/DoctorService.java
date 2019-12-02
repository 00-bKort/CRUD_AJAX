package com.example.ajax.services;

import java.util.List;

import com.example.ajax.entidades.Doctor;
import com.example.ajax.entidades.Especialidad;
import com.example.ajax.repository.IDoctor;
import com.example.ajax.repository.IEspecialidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * DoctorService
 */
@Service
public class DoctorService {

    @Autowired
    IDoctor idoc;
    @Autowired
    IEspecialidad ie;

    @Transactional
    public List<Doctor> doclist() {
        return (List<Doctor>) idoc.findAll();
    }

    @Transactional
    public List<Especialidad> getAllEspecialidad() {
        return (List<Especialidad>) ie.findAll();
    }

    @Transactional
    public Boolean SaveOrUpdate(Doctor doc) {
        try {
            idoc.save(doc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public Especialidad gEspecialidad(Integer id) {
        return ie.findById(id).get();
    }

    @Transactional
    public Boolean delete(Doctor doc) {
        try {
            idoc.delete(doc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Doctor getDoctor(Integer id) {
        return idoc.findById(id).get();
    }

    public Especialidad getEspecialidad(Integer id) {
        return ie.findById(id).get();
    }
}