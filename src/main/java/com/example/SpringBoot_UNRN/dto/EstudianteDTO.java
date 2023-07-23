package com.example.SpringBoot_UNRN.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EstudianteDTO {
    private String nombre;
    private String apellido;
    private String email;
    private int dni;
    private LocalDate fechaNacimiento;
}
