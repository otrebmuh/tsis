package mx.uam.tsis.ejemplobackend.presentacion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controlador web
 * 
 * @author humbertocervantes
 *
 */
@Controller
public class MainController {
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@GetMapping("/")
	public String index() {
		
		log.info("Se invocó el método index()");
	
		return "index";
	}

	@RequestMapping("/ejemplo")
	@ResponseBody
	public String ejemplo() {
		
	
		return "esto es un ejemplo";
	}

}
