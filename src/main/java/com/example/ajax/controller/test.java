package com.example.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * test
 */
@Controller
@RequestMapping(value = "prueba")
public class test {

    @GetMapping(value = "ver")
    public String ver(){
        return "view/Consultas/consulta";
    }
}