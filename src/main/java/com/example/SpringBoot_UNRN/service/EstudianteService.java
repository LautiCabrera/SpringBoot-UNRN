package com.example.SpringBoot_UNRN.service;

import com.example.SpringBoot_UNRN.domain.Estudiante;
import com.example.SpringBoot_UNRN.dto.EstudianteDTO;
import com.example.SpringBoot_UNRN.repository.EstudianteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EstudianteService {
    
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Transactional
    public EstudianteDTO saveEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = new Estudiante(
                null,
                estudianteDTO.getNombre(),
                estudianteDTO.getApellido(),
                estudianteDTO.getEmail(),
                estudianteDTO.getDni(),
                estudianteDTO.getFechaNacimiento(),
                estudianteDTO.getEdad()
        );
        estudianteRepository.save(estudiante);
        return estudianteDTO;
    }

    public List<EstudianteDTO> findAll() {
        return estudianteRepository.findAll()
                .stream().map(e -> new EstudianteDTO(e.getNombre(), e.getApellido(), e.getEmail(), e.getDni(), e.getFechaNacimiento(), e.getEdad()))
                .collect(Collectors.toList());
    }

    public EstudianteDTO find(Long id) {
        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);

        if (estudianteOptional.isEmpty()) {
            throw new RuntimeException("ID invalido");
        }

        Estudiante estudiante = estudianteOptional.get();

        return new EstudianteDTO(estudiante.getNombre(), estudiante.getApellido(), estudiante.getEmail(), estudiante.getDni(), estudiante.getFechaNacimiento(), estudiante.getEdad());

    }

    public EstudianteDTO update(Long id, EstudianteDTO estudianteDTO){
        Estudiante estudiante = new Estudiante(id, estudianteDTO.getNombre(), estudianteDTO.getApellido(), estudianteDTO.getEmail(), estudianteDTO.getDni(), estudianteDTO.getFechaNacimiento(), estudianteDTO.getEdad());
        estudianteRepository.save(estudiante);
        return estudianteDTO;
    }
    
    public void deleteById(Long id){
        estudianteRepository.deleteById(id);
    }

    private void validarEdad(Long id, LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        find(id);
        int edad = periodo.getYears();
        if (edad < 18) {
            throw new IllegalArgumentException("El estudiante debe ser mayor de edad");
        }
    }
}
