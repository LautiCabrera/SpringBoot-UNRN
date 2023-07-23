package com.example.SpringBoot_UNRN.service;

import com.example.SpringBoot_UNRN.controller.EstudianteRequest;
import com.example.SpringBoot_UNRN.domain.Estudiante;
import com.example.SpringBoot_UNRN.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public Estudiante crearEstudiante(EstudianteRequest estudianteRequest) {
        validarEdad(estudianteRequest.getFechaNacimiento());

        Estudiante estudiante = new Estudiante();
        estudiante.setDni(estudianteRequest.getDni());
        estudiante.setNombre(estudianteRequest.getNombre());
        estudiante.setApellido(estudianteRequest.getApellido());
        estudiante.setFechaNacimiento(estudianteRequest.getFechaNacimiento());
        estudiante.setEmail(estudianteRequest.getEmail());

        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante obtenerEstudiantePorId(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));
    }

    public Estudiante actualizarEstudiante(Long id, EstudianteRequest estudianteRequest) {
        validarEdad(estudianteRequest.getFechaNacimiento());

        Estudiante estudiante = obtenerEstudiantePorId(id);
        estudiante.setDni(estudianteRequest.getDni());
        estudiante.setNombre(estudianteRequest.getNombre());
        estudiante.setApellido(estudianteRequest.getApellido());
        estudiante.setFechaNacimiento(estudianteRequest.getFechaNacimiento());
        estudiante.setEmail(estudianteRequest.getEmail());

        return estudianteRepository.save(estudiante);
    }

    public void eliminarEstudiante(Long id) {
        Estudiante estudiante = obtenerEstudiantePorId(id);
        estudianteRepository.delete(estudiante);
    }

    private void validarEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        int edad = periodo.getYears();

        if (edad < 18) {
            throw new IllegalArgumentException("El estudiante debe ser mayor de edad");
        }
    }
}
