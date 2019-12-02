package com.example.ajax.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




/**
 * Especialidad
 */
@Entity
@Table(name = "especialidad")
public class Especialidad {

    // PARAMETROS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEs;
    @Column(name = "especialidad")
    private String especialidad;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Doctor> doctor;

    // CONSTRUCTORES
    public Especialidad() {

    }

    public Especialidad(Integer id, String especialidad) {
        this.idEs = id;
        this.especialidad = especialidad;
    }

    // SETTER AND GETTER
    /**
     * @return the id
     */
    public Integer getId() {
        return idEs;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.idEs = id;
    }

    /**
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}