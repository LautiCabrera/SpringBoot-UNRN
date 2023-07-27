package com.example.SpringBoot_UNRN.service;

import com.example.SpringBoot_UNRN.domain.Curso;
import com.example.SpringBoot_UNRN.domain.Estudiante;
import com.example.SpringBoot_UNRN.domain.Inscripcion;
import com.example.SpringBoot_UNRN.repository.CursoRepository;
import com.example.SpringBoot_UNRN.repository.EstudianteRepository;
import com.example.SpringBoot_UNRN.repository.InscripcionRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@Transactional
public class InscripcionServiceImpl implements InscripcionService {

    private final EstudianteRepository estudianteRepository;
    private final CursoRepository cursoRepository;
    private final InscripcionRepository inscripcionRepository;

    public InscripcionServiceImpl(EstudianteRepository estudianteRepository, CursoRepository cursoRepository, InscripcionRepository inscripcionRepository) {
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    @Override
    public Inscripcion registrarInscripcion(Estudiante estudiante, Curso curso) {
        if (esMayorDeEdad(estudiante)) {
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setEstudiante(estudiante);
            inscripcion.setCurso(curso);
            inscripcion.setFechaInscripcion(LocalDate.now());
            inscripcion.setEstado("Pendiente");
            return inscripcionRepository.save(inscripcion);
        } else {
            throw new IllegalArgumentException("El estudiante debe ser mayor de edad");
        }
    }

    private boolean esMayorDeEdad(Estudiante estudiante) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = estudiante.getFechaNacimiento();
        Period edad = Period.between(fechaNacimiento, fechaActual);
        return edad.getYears() >= 18;
    }
    
    @Transactional
    public void save(@NotNull @Positive(message = "Se necesita un ID") Long idEstudiante,
                              @NotNull @Positive (message =  "Se de necesita un ID")Long idCurso,
                              LocalDate fechaInscripcion, String estado){


        Curso curso = cursoRepository
                .findById(idCurso)
                .orElseThrow(()-> new RuntimeException("ID no valido"));


        Estudiante estudiante = estudianteRepository
                .findById(idEstudiante)
                .orElseThrow( () -> new RuntimeException("El id del estudiante no es validad"));

        Inscripcion inscripcion = new Inscripcion(
                null,
                estado,
                curso,
                estudiante,
                fechaInscripcion
        );

        inscripcionRepository.save(inscripcion);
    }
}

