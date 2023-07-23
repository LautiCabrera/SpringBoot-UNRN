package com.example.SpringBoot_UNRN.controller;

public class InscripcionRequest {

    private Long estudianteId;
    private Long cursoId;

    public InscripcionRequest() {
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}

