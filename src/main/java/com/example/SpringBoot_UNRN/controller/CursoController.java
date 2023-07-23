package com.example.SpringBoot_UNRN.controller;

import com.example.SpringBoot_UNRN.dto.CursoDTO;
import com.example.SpringBoot_UNRN.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public CursoDTO saveCurso(@RequestBody CursoDTO cursoDTO) {
        return cursoService.saveCurso(cursoDTO);
    }

    @GetMapping
    public List<CursoDTO> all() {
        return cursoService.findAllCursos();
    }

    @GetMapping("/{id}")
    public CursoDTO find(@PathVariable Long id) {
        return cursoService.findCurso(id);
    }

    @PutMapping("/{id}")
    public CursoDTO updateCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO) {
        return cursoService.updateCurso(id, cursoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
    }

    @GetMapping
    public List<CursoDTO> findAllCursos() {
        return cursoService.findAllCursos();
    }

    @GetMapping("/{id}")
    public CursoDTO findCurso(@PathVariable Long id) {
        return cursoService.findCurso(id);
    }

}

