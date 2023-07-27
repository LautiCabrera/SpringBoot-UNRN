package com.example.SpringBoot_UNRN.repository;

import com.example.SpringBoot_UNRN.domain.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    // Consultas básicas
    
    List<Estudiante> findAll();
    Page<Estudiante> findAll(Pageable pageable);
    List<Estudiante> findByDNIGreaterThanAndApellido(int DNI, String apellido);
    
    // Consultas personalizadas
    
    @Query("SELECT e FROM Estudiante e")
    List<Estudiante> findByAllEstudianteQuery();

    @Query("SELECT e FROM Estudiante e WHERE e.DNI > 20000000 AND e.apellido = 'romero'")
    List<Estudiante> findAllEstudianteForDNITwelveMillon();
    
    @Query(value = "SELECT date_part('year', age(fecha_nac)) AS edad FROM estudiante WHERE id = :id;", nativeQuery = true)
    List<Estudiante> findEdad(@Param("id") Long id);

}

