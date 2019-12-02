package com.example.ajax.controller;

import java.util.HashMap;
import java.util.List;

import com.example.ajax.entidades.Doctor;
import com.example.ajax.entidades.Especialidad;
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

/**
 * DoctorController
 */
@Controller
@CrossOrigin
@RequestMapping(value = "doctor")
public class DoctorController {

    @Autowired
    DoctorService ds;

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Doctor> getAllDoctor() {
        return (List<Doctor>) ds.doclist();
    }

    //obtener ID
    @GetMapping(value = "getDoctor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Doctor getDoctor(@PathVariable Integer id) {
        return ds.getDoctor(id);
    }

    // metodo para mostrar un listado de especialidad
    @GetMapping(value = "allEspecialidad", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Especialidad> getAllEspecialidad() {
        return (List<Especialidad>) ds.getAllEspecialidad();
    }

    @GetMapping(value = "save")
    @ResponseBody
    public HashMap<String, String> save(@RequestParam String nombre, @RequestParam String direccion,
            @RequestParam Integer idEs) {
        Doctor doc = new Doctor();
        HashMap<String, String> hs = new HashMap<>();

        doc.setNombre(nombre);
        doc.setDireccion(direccion);
        doc.setEspecialidad(ds.gEspecialidad(idEs));

        try {
            ds.SaveOrUpdate(doc);
            hs.put("Estado", "OK");
            hs.put("Mensaje", "Registro Guardado");
            return hs;
        } catch (Exception e) {
            hs.put("Error", "La accion fallo");
            hs.put("Mensaje", "El registro no se guardo");
            return hs;
        }

    }

    @GetMapping(value = "update/{id}")
    @ResponseBody
    public HashMap<String, String> editar(@RequestParam Integer id, @RequestParam String nombre,
            @RequestParam String direccion, @RequestParam Integer idEs) {
        Doctor doc = new Doctor();
        HashMap<String, String> hs = new HashMap<>();

        doc.setId(id);
        doc.setNombre(nombre);
        doc.setDireccion(direccion);
        doc.setEspecialidad(ds.gEspecialidad(idEs));

        try {
            ds.SaveOrUpdate(doc);
            hs.put("Estado", "OK");
            hs.put("Mensaje", "Registro Actualizado");
            return hs;
        } catch (Exception e) {
            hs.put("Error", "La accion fallo");
            hs.put("Mensaje", "El registro no se Actualizo");
            return hs;
        }
    }

    @GetMapping(value = "delete/{id}")
    @ResponseBody
    public HashMap<String, String> delete(@PathVariable Integer id) {
        HashMap<String, String> hs = new HashMap<>();
        Doctor doc = ds.getDoctor(id);

        try {
            ds.delete(doc);
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