package com.example.SpringBoot_UNRN;

import com.example.SpringBoot_UNRN.domain.Curso;
import com.example.SpringBoot_UNRN.domain.Estudiante;
import com.example.SpringBoot_UNRN.domain.Inscripcion;
import com.example.SpringBoot_UNRN.repository.CursoRepository;
import com.example.SpringBoot_UNRN.repository.EstudianteRepository;
import com.example.SpringBoot_UNRN.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class SpringBoot_UNRN {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot_UNRN.class, args);
	}

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private InscripcionRepository inscripcionRepository;

	private void saveCursos() {
		// Crear instancias de estudiantes
		Estudiante estudiante1 = new Estudiante();
		estudiante1.setNombre("Juan");
		estudiante1.setApellido("Perez");
		estudiante1.setEmail("juan@example.com");
		// ... asignar otros atributos

		Estudiante estudiante2 = new Estudiante();
		estudiante2.setNombre("Maria");
		estudiante2.setApellido("Lopez");
		estudiante2.setEmail("maria@example.com");
		// ... asignar otros atributos

		// Guardar estudiantes en la base de datos
		estudianteRepository.saveAll(Arrays.asList(estudiante1, estudiante2));

		// Crear instancias de cursos
		Curso curso1 = new Curso();
		curso1.setName("Matematicas");
		curso1.setDescription("Funciones cuadraticas");
		curso1.setFechaInicio(LocalDate.of(2023, 2, 4));
		curso1.setFechaFin(LocalDate.of(2010, 2, 4));

		Curso curso2 = new Curso();
		curso2.setName("Lengua");
		curso2.setDescription("Lecturas sobre Borges");
		curso2.setFechaInicio(LocalDate.of(2023, 2, 4));
		curso2.setFechaFin(LocalDate.of(2010, 2, 4));

		// Guardar cursos en la base de datos
		cursoRepository.saveAll(Arrays.asList(curso1, curso2));

		// Crear instancias de inscripciones
		Inscripcion inscripcion1 = new Inscripcion();
		inscripcion1.setEstado("Pendiente");
		inscripcion1.setCurso(curso1);
		inscripcion1.setEstudiante(estudiante1);

		Inscripcion inscripcion2 = new Inscripcion();
		inscripcion2.setEstado("Aprobada");
		inscripcion2.setCurso(curso2);
		inscripcion2.setEstudiante(estudiante2);

		// Guardar inscripciones en la base de datos
		inscripcionRepository.saveAll(Arrays.asList(inscripcion1, inscripcion2));

		// Asignar inscripciones a los cursos
		curso1.setInscripciones(Arrays.asList(inscripcion1));
		curso2.setInscripciones(Arrays.asList(inscripcion2));

		// Guardar cursos actualizados en la base de datos
		cursoRepository.saveAll(Arrays.asList(curso1, curso2));

	}



}
