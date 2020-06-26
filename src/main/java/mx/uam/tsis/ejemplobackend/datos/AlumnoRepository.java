package mx.uam.tsis.ejemplobackend.datos;


import org.springframework.data.repository.CrudRepository;

import mx.uam.tsis.ejemplobackend.negocio.modelo.Alumno;

/**
 * Se encarga de almacenar y recuperar alumnos
 * 
 * @author humbertocervantes
 *
 */
public interface AlumnoRepository extends CrudRepository <Alumno, Integer>{ 
}
