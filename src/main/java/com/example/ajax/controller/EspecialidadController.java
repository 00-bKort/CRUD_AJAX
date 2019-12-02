package com.example.ajax.controller;

import java.util.HashMap;
import java.util.List;

import com.example.ajax.entidades.Especialidad;
import com.example.ajax.repository.IEspecialidad;
import com.example.ajax.services.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "especialidad")
@CrossOrigin
public class EspecialidadController {

    @Autowired
    IEspecialidad ie;
    @Autowired
    DoctorService ds;

    //listado de registros
    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Especialidad> MostrarDoctores() {
        return (List<Especialidad>) ie.findAll();
    }

    //mostrar id
    @GetMapping(value = "getEspecialidad/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Especialidad getEspecialidad(@PathVariable Integer id) {
        return ds.getEspecialidad(id);
    }

    // Save
    @GetMapping(value = "save")
    @ResponseBody
    public HashMap<String, String> GuardarDoctor(@RequestParam String especialidad) {
        Especialidad es = new Especialidad();
        HashMap<String, String> hs = new HashMap<>();

        es.setEspecialidad(especialidad);

        try {
            ie.save(es);
            hs.put("Estado", "OK");
            hs.put("Mensaje", "Registro Guardado");
            return hs;
        } catch (Exception e) {
            hs.put("Error", "La acción fallo");
            hs.put("Mensaje", "El registro no se guardo");
            return hs;
        }

    }

    // Update
    @GetMapping(value = "update/{id}")
    @ResponseBody
    public HashMap<String, String> EditarDoctor(@RequestParam Integer id, @RequestParam String especialidad) {
        Especialidad es = new Especialidad();
        HashMap<String, String> hs = new HashMap<>();
        es.setId(id);
        es.setEspecialidad(especialidad);

        try {
            ie.save(es);
            hs.put("Estado", "OK");
            hs.put("Mensaje", "Registro Actualizado");
            return hs;
        } catch (Exception e) {
            hs.put("Error", "La acción fallo");
            hs.put("Mensaje", "El registro no se Actualizo");
            return hs;
        }
    }

    // Delete
    @GetMapping(value = "delete/{id}")
    @ResponseBody
    public HashMap<String, String> EliminarDoctor(@PathVariable Integer id) {
        HashMap<String, String> hs = new HashMap<>();
        Especialidad es = ie.findById(id).get();
        try {
            ie.delete(es);
            hs.put("Estado", "OK");
            hs.put("Mensaje", "Registro Eliminado");
            return hs;
        } catch (Exception e) {
            hs.put("Error", "La acción fallo");
            hs.put("Mensaje", "El registro no se Elimino");
            return hs;
        }

    }
}