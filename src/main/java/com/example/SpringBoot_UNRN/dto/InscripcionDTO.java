package com.example.SpringBoot_UNRN.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class InscripcionDTO {
    private String estado;
    private LocalDate fechaInscripcion;
    private CursoDTO curso;
    private EstudianteDTO estudiante;
}
