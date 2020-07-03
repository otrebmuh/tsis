package mx.uam.tsis.ejemplobackend.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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

			log.info("Voy a guardar a alumno "+nuevoAlumno);
			
			Alumno returnAlumno =  alumnoRepository.save(nuevoAlumno);
			
			log.info("Voy a regresar a alumno "+returnAlumno);
			
			return returnAlumno;
			
		} else {
			
			return null;
			
		}
		
	}
	

	public Iterable <Alumno> retrieveAll () {
		
		
		// Lógica de negocio
		
		return alumnoRepository.findAll();
	}
	
	public Alumno findByMatricula(Integer matricula) {

		// Lógica de negocio
		
		Optional <Alumno> alumnoOpt = alumnoRepository.findById(matricula);
		
		return alumnoOpt.get();
	}
}
