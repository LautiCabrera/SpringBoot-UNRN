package com.example.SpringBoot_UNRN.service;

import com.example.SpringBoot_UNRN.domain.Curso;
import com.example.SpringBoot_UNRN.dto.CursoDTO;
import com.example.SpringBoot_UNRN.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoDTO saveCurso(CursoDTO cursoDTO) {
        Curso curso = new Curso(
            null,
            cursoDTO.getName(),
            cursoDTO.getDescription(),
            cursoDTO.getFechaInicio(),
            cursoDTO.getFechaFin()
        );
        cursoRepository.save(curso);
        return cursoDTO;
    }
    
    public List<CursoDTO> findAll() {
        return cursoRepository.findAllCurso()
                .stream().map(c -> new CursoDTO(c.getName(), c.getDescription(),c.getFechaInicio(),c.getFechaFin()))
                .collect(Collectors.toList());
    }

    public CursoDTO update(long id, CursoDTO cursoDTO){
        Curso curso = new Curso(id, cursoDTO.getName(), cursoDTO.getDescription(),cursoDTO.getFechaInicio(),cursoDTO.getFechaFin());
        cursoRepository.save(curso);
        return cursoDTO;
    }

    public CursoDTO find(long id){
        Optional<Curso> cursoOptional = cursoRepository.findById(id);

        if (cursoOptional.isEmpty()) {
            throw new RuntimeException("ID invalido");
        }

        Curso curso = cursoOptional.get();

        return new CursoDTO(curso.getName(), curso.getDescription(), curso.getFechaInicio(), curso.getFechaFin());
    }

    public void deleteById(long id){
        cursoRepository.deleteById(id);
    }

}
