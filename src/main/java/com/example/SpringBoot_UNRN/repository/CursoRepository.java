package com.example.SpringBoot_UNRN.repository;

import com.example.SpringBoot_UNRN.domain.Curso;
import com.example.SpringBoot_UNRN.domain.Estudiante;
import com.example.SpringBoot_UNRN.domain.Inscripcion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    // Consultas básicas

    List<Curso> findByfechaInicio(LocalDate fechaInicio);
    List<Curso> findAll();

    // Consultas personalizadas
    
    @Query (value = "DELETE c FROM Curso c WHERE id = :id ", nativeQuery = true)
    List<Curso> deleteById(@Param("id")long id);
    
    @Query ("SELECT c FROM Curso c")
    List<Curso> findAllCurso();


}

