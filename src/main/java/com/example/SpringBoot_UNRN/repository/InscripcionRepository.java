package com.example.SpringBoot_UNRN.repository;

import com.example.SpringBoot_UNRN.domain.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    List<Inscripcion> findByEstadoIn(String... estados);
    List<Inscripcion> findByCursoFechaInicioAfter(LocalDate fechaInicio);
    List<Inscripcion> findByEstado(String estado);
    @Query(value = "SELECT * FROM Inscripcion i WHERE i.estado = :estado", nativeQuery = true)
    List<Inscripcion> findByEstadoNative(@Param("estado") String estado);

}
