package com.example.SpringBoot_UNRN.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
