package mx.uam.tsis.ejemplobackend.datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.uam.tsis.ejemplobackend.negocio.modelo.Alumno;
import mx.uam.tsis.ejemplobackend.servicios.AlumnoController;

/**
 * Se encarga de almacenar y recuperar alumnos
 * 
 * @author humbertocervantes
 *
 */
@Component
@Slf4j
public class AlumnoRepository {
	
	// La "base de datos"
	private Map <Integer, Alumno> alumnoRepository = new HashMap <>();

	/**
	 * Guarda en la BD
	 * 
	 * @param alumno
	 */
	public Alumno save(Alumno nuevoAlumno) {
		alumnoRepository.put(nuevoAlumno.getMatricula(), nuevoAlumno);
		return nuevoAlumno;
	}
	
	public Alumno findByMatricula(Integer matricula) {
		return alumnoRepository.get(matricula);
	}
	
	public List <Alumno> find() {
		return new ArrayList <> (alumnoRepository.values());
	}
	
	// falta update
	
	// falta delete
 
}
