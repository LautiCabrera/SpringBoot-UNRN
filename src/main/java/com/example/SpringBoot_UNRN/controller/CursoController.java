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
    public CursoDTO save(@RequestBody CursoDTO cursoDTO){
        return cursoService.saveCurso(cursoDTO);
    }
    @GetMapping
    public List<CursoDTO> all(){
        return cursoService.findAll();
    }
    @GetMapping("/{id}")
    public CursoDTO find(@PathVariable long id){
        return cursoService.find(id);
    }

    @PutMapping ("/{id}")
    public CursoDTO update(@PathVariable long id, @RequestBody CursoDTO cursoDTO){
        return cursoService.update(id, cursoDTO);
        }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        cursoService.deleteById(id);
    }

}

