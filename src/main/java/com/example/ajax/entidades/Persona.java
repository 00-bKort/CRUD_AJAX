package com.example.ajax.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;


@Entity
@Table(name = "persona")
public class Persona {

    //parametros
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;

    //constructores
    public Persona() {

    }

    //setter y getter
    public void setId (Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    
    public void setNombre (String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    
    public void setdireccion (String direccion){
        this.direccion = direccion;
    }

    public String getDireccion(){
        return direccion;
    }

    
    public void setTelefono (String telefono){
        this.telefono = telefono;
    }

    public String getTelefono(){
        return telefono;
    }
}