package controllers;

import java.util.Map;
import javax.persistence.EntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import objectDbCBD.Models.Planeta;
import repository.PlanetaRepositorio;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@ComponentScan(basePackages = { "controllers", "services" })
public class planetaController {
	
	public static EntityManager em;
	
	@RequestMapping(value="/createPlaneta",method=RequestMethod.POST)
    public Planeta createPlaneta(@RequestBody Map<String, Object> data) throws Exception {	
			Planeta planetaCreado = PlanetaRepositorio.createPlaneta(data.get("nombre").toString(), data.get("descripcion").toString());
		return planetaCreado;
	}

}
