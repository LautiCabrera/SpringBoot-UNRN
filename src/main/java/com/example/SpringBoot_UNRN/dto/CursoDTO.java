package com.example.SpringBoot_UNRN.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CursoDTO {
    private String name;
    private String description;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
