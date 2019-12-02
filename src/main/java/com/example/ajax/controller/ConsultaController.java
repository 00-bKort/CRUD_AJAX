package com.example.ajax.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import com.example.ajax.entidades.Consulta;
import com.example.ajax.entidades.Doctor;
import com.example.ajax.entidades.Paciente;
import com.example.ajax.services.ConsultaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ConsultaController
 */
@Controller
@RequestMapping(value = "consulta")
@CrossOrigin
public class ConsultaController {

    @Autowired
    ConsultaService cs;

    // para mostrar un listado de consultas
    @GetMapping(value = "all")
    @ResponseBody
    public List<Consulta> lista() {
        return cs.conlist();
    }

    // mostrar el listado de paciente y doctor
    @GetMapping(value = "allPaciente", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Paciente> getPaciente() {
        return (List<Paciente>) cs.palist();
    }
    @GetMapping(value = "allDoctor", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Doctor> getDoctor() {
        return (List<Doctor>) cs.doclist();
    }
    /*****************************************************/

    // traer el ID
    @GetMapping(value = "getConsulta/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Consulta getConsulta(@PathVariable Integer id) {
        return cs.getConsulta(id);
    }

    // guardar
    @GetMapping(value = "save")
    @ResponseBody
    public HashMap<String, String> save(@RequestParam String sintomas, @RequestParam Date fecha,
            @RequestParam String diagnostico, @RequestParam Doctor doctor, @RequestParam Paciente paciente) {
        Consulta c = new Consulta();
        HashMap<String, String> hs = new HashMap<String, String>();

        c.setSintomas(sintomas);
        c.setFecha(fecha);
        c.setDiagnostico(diagnostico);
        c.setDoctor(doctor);
        c.setPaciente(paciente);

        try {
            cs.SaveOrUpdate(c);
            hs.put("Estado", "OK");
            hs.put("Mensaje", "Registro Guardado");
            return hs;
        } catch (Exception e) {
            hs.put("Error", "La accion fallo");
            hs.put("Mensaje", "El registro no se guardo");
            return hs;
        }
    }

    // actualizar
    @GetMapping(value = "update/{id}")
    @ResponseBody
    public HashMap<String, String> editar(@RequestParam Integer id, @RequestParam String sintomas,
            @RequestParam Date fecha, @RequestParam String diagnostico, @RequestParam Doctor doctor,
            @RequestParam Paciente paciente) {

        Consulta c = new Consulta();
        HashMap<String, String> hs = new HashMap<String, String>();

        c.setIdConsulta(id);
        c.setSintomas(sintomas);
        c.setFecha(fecha);
        c.setDiagnostico(diagnostico);
        c.setDoctor(doctor);
        c.setPaciente(paciente);

        try {
            cs.SaveOrUpdate(c);
            hs.put("Estado", "OK");
            hs.put("Mensaje", "Registro Actualizado");
            return hs;
        } catch (Exception e) {
            hs.put("Error", "La accion fallo");
            hs.put("Mensaje", "El registro no se Actualizo");
            return hs;
        }
    }

    // eliminar
    @GetMapping(value = "delete/{id}")
    @ResponseBody
    public HashMap<String, String> delete(@PathVariable Integer id) {
        HashMap<String, String> hs = new HashMap<String, String>();
        Consulta c = cs.getConsulta(id);

        try {
            cs.delete(c);
            hs.put("Estado", "OK");
            hs.put("Mensaje", "El registro se elimino");
            return hs;
        } catch (Exception e) {
            hs.put("Error", "La accion fallo");
            hs.put("Mensaje", "El registro no se elimino");
            return hs;
        }
    }
}