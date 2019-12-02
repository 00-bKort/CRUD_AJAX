package com.example.ajax.controller;

import java.util.HashMap;
import java.util.List;

import com.example.ajax.entidades.Paciente;
import com.example.ajax.repository.IPaciente;
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
 * PacienteController
 */
@Controller
@RequestMapping(value = "paciente")
@CrossOrigin
public class PacienteController {

    @Autowired
    IPaciente ip;
    @Autowired
    ConsultaService cs;

    // obtener un listado de pacientes
    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Paciente> pList() {
        return (List<Paciente>) ip.findAll();
    }

    //metodo para mostrar el id
    @GetMapping(value = "gPaciente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Paciente gPaciente(@PathVariable Integer id) {
        return cs.gPaciente(id);
    }

    // guardar
    @GetMapping(value = "save")
    @ResponseBody
    public HashMap<String, String> guardar(@RequestParam String nombre, @RequestParam String direccion) {
        Paciente p = new Paciente();
        HashMap<String, String> hs = new HashMap<String, String>();

        p.setNombre(nombre);
        p.setDireccion(direccion);

        try {
            ip.save(p);
            hs.put("Estado", "OK");
            hs.put("Mensaje", "Registro Guardado");
            return hs;
        } catch (Exception e) {
            hs.put("Error", "La acción fallo");
            hs.put("Mensaje", "El registro no se guardo");
            return hs;
        }
    }

    //actualizar
    @GetMapping(value = "update/{id}")
    @ResponseBody
    public HashMap<String, String> editar(@RequestParam Integer id, @RequestParam String nombre,
            @RequestParam String direccion) {
        Paciente p = new Paciente();
        HashMap<String, String> hs = new HashMap<>();
        p.setIdPaciente(id);
        p.setNombre(nombre);
        p.setDireccion(direccion);

        try {
            ip.save(p);
            hs.put("Estado", "OK");
            hs.put("Mensaje", "Registro Actualizado");
            return hs;
        } catch (Exception e) {
            hs.put("Error", "La acción fallo");
            hs.put("Mensaje", "El registro no se Actualizo");
            return hs;
        }
    }

    //eliminar
    @GetMapping(value = "delete/{id}")
    @ResponseBody
    public HashMap<String, String> eliminar(@PathVariable Integer id) {
        HashMap<String, String> hs = new HashMap<>();
        Paciente p = ip.findById(id).get();
        try {
            ip.delete(p);
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