package com.example.SpringBoot_UNRN.service;

import com.example.SpringBoot_UNRN.domain.Curso;
import com.example.SpringBoot_UNRN.domain.Estudiante;
import com.example.SpringBoot_UNRN.domain.Inscripcion;

public interface InscripcionService {
    Inscripcion registrarInscripcion(Estudiante estudiante, Curso curso);
}
