package com.example.SpringBoot_UNRN.service;

import com.example.SpringBoot_UNRN.domain.Curso;
import com.example.SpringBoot_UNRN.domain.Estudiante;
import com.example.SpringBoot_UNRN.dto.CursoDTO;
import com.example.SpringBoot_UNRN.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoDTO> findCursosByEstudiante(Estudiante estudiante) {
        List<Curso> cursos = cursoRepository.findAllByInscripcionesEstudiante(estudiante);
        // Convertir la lista de entidades 'Curso' a una lista de DTOs 'CursoDTO'
        List<CursoDTO> cursoDTOs = convertToCursoDTOList(cursos);
        return cursoDTOs;
    }

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public CursoDTO saveCurso(CursoDTO cursoDTO) {
        Curso curso = convertToCursoEntity(cursoDTO);
        Curso savedCurso = cursoRepository.save(curso);
        return convertToCursoDTO(savedCurso);
    }

    public List<CursoDTO> findAllCursos() {
        List<Curso> cursos = cursoRepository.findAll();
        return convertToCursoDTOList(cursos);
    }

    public Page<Estudiante> findAllEstudiantes(Pageable pageable) {
        return cursoRepository.findAllEstudiantes(pageable);
    }

    public CursoDTO findCurso(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso not found with id: " + id));
        return convertToCursoDTO(curso);
    }

    public CursoDTO updateCurso(Long id, CursoDTO cursoDTO) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso not found with id: " + id));

        // Actualizar las propiedades de la entidad curso utilizando cursoDTO

        Curso updatedCurso = cursoRepository.save(curso);
        return convertToCursoDTO(updatedCurso);
    }

    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    private CursoDTO convertToCursoDTO(Curso curso) {
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId(curso.getId());
        cursoDTO.setName(curso.getName());
        cursoDTO.setDescription(curso.getDescription());
        cursoDTO.setFechaInicio(curso.getFechaInicio());
        cursoDTO.setFechaFin(curso.getFechaFin());
        return cursoDTO;
    }

    private List<CursoDTO> convertToCursoDTOList(List<Curso> cursos) {
        List<CursoDTO> cursoDTOList = new ArrayList<>();
        for (Curso curso : cursos) {
            CursoDTO cursoDTO = convertToCursoDTO(curso);
            cursoDTOList.add(cursoDTO);
        }
        return cursoDTOList;
    }

    private Curso convertToCursoEntity(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setId(cursoDTO.getId());
        curso.setName(cursoDTO.getName());
        curso.setDescription(cursoDTO.getDescription());
        curso.setFechaInicio(cursoDTO.getFechaInicio());
        curso.setFechaFin(cursoDTO.getFechaFin());
        return curso;
    }



}
