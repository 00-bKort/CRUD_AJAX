
package com.example.ajax.controller;

import java.util.List;

import com.example.ajax.entidades.Persona;
import com.example.ajax.repository.IPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("persona")
public class PersonaController {

    // conexion a la capa de datos
    @Autowired
    IPersona ip;

    // metodo para retornar la vista
    @GetMapping("vista")
    public String mostrar() {
        return "persona/persona";
    }

    //metodo para retornar un listado o un arreglo
    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Persona> getAll() {
        return (List<Persona>) ip.findAll();
    }

    // metodo para modificar y agregar
    @PostMapping(value = "addOrUpdate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Boolean addOrUpdate(@RequestParam Integer id, @RequestParam String nombre, @RequestParam String direccion,
            @RequestParam String telefono) {

        // creo un objeto de la entidad
        Persona p = new Persona();

        if (id != null) // la condicional para el ID
            p.setId(id);
        p.setNombre(nombre);
        p.setdireccion(direccion);
        p.setTelefono(telefono);
        // se guardan los datos
        ip.save(p);
        return true;
    }

    // metodo para mostrar por ID
    @GetMapping(value = "get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Persona getMethodName(@PathVariable Integer id) {
        return ip.findById(id).get();
    }

    // metodo para eliminar
    @GetMapping(value = "delete/{id}")
    @ResponseBody
    public Boolean delete(@PathVariable Integer id) {
        Persona p = ip.findById(id).get();
        ip.delete(p);
        return true;
    }
}