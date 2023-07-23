package com.example.SpringBoot_UNRN.controller;

import com.example.SpringBoot_UNRN.domain.Estudiante;
import com.example.SpringBoot_UNRN.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping("/estudiantes")
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody EstudianteRequest estudianteRequest) {
        Estudiante estudiante = estudianteService.crearEstudiante(estudianteRequest);
        return ResponseEntity.ok(estudiante);
    }

    @GetMapping("/estudiantes")
    public ResponseEntity<List<Estudiante>> obtenerTodosLosEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable Long id) {
        Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id);
        return ResponseEntity.ok(estudiante);
    }

    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteRequest estudianteRequest) {
        Estudiante estudiante = estudianteService.actualizarEstudiante(id, estudianteRequest);
        return ResponseEntity.ok(estudiante);
    }

    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<String> eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.ok("Estudiante eliminado exitosamente");
    }

}
