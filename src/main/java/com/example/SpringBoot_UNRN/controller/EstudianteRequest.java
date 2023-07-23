package com.example.SpringBoot_UNRN.controller;

import java.time.LocalDate;

public class EstudianteRequest {

    private int dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String email;

    public EstudianteRequest() {
    }

    public EstudianteRequest(int dni, String nombre, String apellido, LocalDate fechaNacimiento, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    // Getters y setters

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

