package com.example.SpringBoot_UNRN.controller;

import com.example.SpringBoot_UNRN.dto.InscripcionDTO;
import com.example.SpringBoot_UNRN.service.InscripcionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {
    
    @Autowired
    private InscripcionServiceImpl inscripcionService;
    
    @PostMapping
    public void registrarInscripcion (@RequestBody InscripcionDTO inscripcionDTO){
        inscripcionService.save(
                inscripcionDTO.getEstudiante(),
                inscripcionDTO.getCurso(),
                inscripcionDTO.getFechaInscripcion(),
                inscripcionDTO.getEstado()
        );
    }
    
}


