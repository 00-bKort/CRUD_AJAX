package com.example.ajax.services;

import java.util.List;

import com.example.ajax.entidades.Consulta;
import com.example.ajax.entidades.Doctor;
import com.example.ajax.entidades.Paciente;
import com.example.ajax.repository.IConsulta;
import com.example.ajax.repository.IDoctor;
import com.example.ajax.repository.IPaciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * ConsultaService
 */
@Service
public class ConsultaService {

    @Autowired
    IConsulta ic;
    @Autowired
    IDoctor idoc;
    @Autowired
    IPaciente ip;

    //muestra el listado
    @Transactional
    public List<Consulta> conlist() {
        return (List<Consulta>) ic.findAll();
    }

    //el guardar o actualizar
    @Transactional
    public Boolean SaveOrUpdate(Consulta con){
        try {
            ic.save(con);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //obtener el id de doctor y paciente
    @Transactional
    public Doctor gDoctor(Integer id){
        return idoc.findById(id).get();
    }
    @Transactional
    public Paciente gPaciente(Integer id){
        return ip.findById(id).get();
    }

    //para eliminar
    @Transactional
    public Boolean delete(Consulta con){
        try {
            ic.delete(con);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //para modificar
    @Transactional
    public Consulta getConsulta(Integer id){
        return ic.findById(id).get();
    }
}