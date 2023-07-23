package com.example.SpringBoot_UNRN.repository;

import com.example.SpringBoot_UNRN.domain.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    List<Estudiante> findByDniGreaterThanAndApellido(int dni, String apellido);
    List<Estudiante> findAll();
    List<Estudiante> findByEstadoIn(List<String> estados);
    @Query("SELECT e FROM Estudiante e WHERE e.fechaNacimiento > :fecha")
    List<Estudiante> findByFechaNacimientoAfter(@Param("fecha") LocalDate fecha);
    @Query(nativeQuery = true, value = "SELECT * FROM Estudiante e WHERE e.estado = :estado")
    List<Estudiante> findByEstadoNative(@Param("estado") String estado);
    Page<Estudiante> findAll(Pageable pageable);

}

