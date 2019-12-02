package com.example.ajax.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Paciente
 */
@Entity
@Table(name = "paciente")
public class Paciente {

    //PARAMETROS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;

    //CONSTRUCTORES
    public Paciente() {

    }
    public Paciente(Integer idPaciente, String nombre, String direccion) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    //SETTER AND GETTER
    /**
     * @return the idPaciente
     */
    public Integer getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}