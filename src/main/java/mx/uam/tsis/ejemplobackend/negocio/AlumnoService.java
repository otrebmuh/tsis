package mx.uam.tsis.ejemplobackend.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.tsis.ejemplobackend.datos.AlumnoRepository;
import mx.uam.tsis.ejemplobackend.negocio.modelo.Alumno;

/**
 * 
 * Clase que contiene la lógica de negocio del manejo de alumnos
 * 
 * @author humbertocervantes
 *
 */
@Service
public class AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	/**
	 * 
	 * Método que permite crear nuevos alumnos
	 * 
	 * @param nuevoAlumno el alumno que se desea crear en el sistema
	 * @return el alumno que se acaba de crear si la creacion es exitosa, null de lo contrario
	 */
	public Alumno create(Alumno nuevoAlumno) {
		
		// Regla de negocio: No se puede crear más de un alumno con la misma matricula
		Optional <Alumno> alumnoOpt = alumnoRepository.findById(nuevoAlumno.getMatricula());
		
		if(!alumnoOpt.isPresent()) {
			
			return alumnoRepository.save(nuevoAlumno);
			
		} else {
			
			return null;
			
		}
		
	}
	

	public Iterable <Alumno> retrieveAll () {
		return alumnoRepository.findAll();
	}
	
	public Alumno findByMatricula(Integer matricula) {
		Optional <Alumno> alumnoOpt = alumnoRepository.findById(matricula);
		
		return alumnoOpt.get();
	}
}
