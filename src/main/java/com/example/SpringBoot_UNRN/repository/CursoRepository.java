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

    List<Curso> findAllByEstudiantes(Estudiante estudiante);
    List<Curso> findAllByInscripcionesEstudiante(Estudiante estudiante);
    List<Estudiante> findByDniGreaterThanAndApellido(int dni, String apellido);
    List<Inscripcion> findByEstadoIn(String... estados);
    List<Curso> findByFechaInicioAfter(LocalDate fecha);


    // Consulta nativa

    @Query(value = "SELECT * FROM Inscripcion WHERE estado = :estado", nativeQuery = true)
    List<Inscripcion> findByEstadoNative(@Param("estado") String estado);

    // Consultas personalizadas

    @Query("SELECT c FROM Curso c JOIN c.inscripciones i WHERE i.estudiante.id = :estudianteId")
    List<Curso> findAllByEstudianteId(@Param("estudianteId") Long estudianteId);

    @Query("SELECT c.estudiantes FROM Curso c WHERE c.id = :cursoId")
    List<Estudiante> findEstudiantesByCursoId(@Param("cursoId") Long cursoId);

    @Query("SELECT c.estudiantes FROM Curso c")
    Page<Estudiante> findAllEstudiantes(Pageable pageable);

    @Query("SELECT c FROM Curso c WHERE c.estado = :estado")
    List<Curso> findByEstado(@Param("estado") String estado);


}

