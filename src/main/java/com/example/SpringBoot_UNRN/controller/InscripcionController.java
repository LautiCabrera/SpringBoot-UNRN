package com.example.SpringBoot_UNRN.controller;

import com.example.SpringBoot_UNRN.domain.Curso;
import com.example.SpringBoot_UNRN.domain.Estudiante;
import com.example.SpringBoot_UNRN.repository.CursoRepository;
import com.example.SpringBoot_UNRN.repository.EstudianteRepository;
import com.example.SpringBoot_UNRN.service.InscripcionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    private final InscripcionService inscripcionService;
    private final EstudianteRepository estudianteRepository;
    private final CursoRepository cursoRepository;

    public InscripcionController(InscripcionService inscripcionService, EstudianteRepository estudianteRepository, CursoRepository cursoRepository) {
        this.inscripcionService = inscripcionService;
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
    public ResponseEntity<String> registrarInscripcion(@RequestBody InscripcionRequest request) {
        Estudiante estudiante = estudianteRepository.findById(request.getEstudianteId())
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));
        Curso curso = cursoRepository.findById(request.getCursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
        inscripcionService.registrarInscripcion(estudiante, curso);
        return ResponseEntity.ok("Inscripción registrada exitosamente");
    }
}


