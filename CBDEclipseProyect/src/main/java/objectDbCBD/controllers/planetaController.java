package objectDbCBD.controllers;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import objectDbCBD.Models.Planeta;
import objectDbCBD.repository.PlanetaRepositorio;

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
	
	@RequestMapping(value="/listPlaneta",method=RequestMethod.GET)
    public List<Planeta> listPlaneta() throws Exception {	
		List<Planeta> listPlanetas = PlanetaRepositorio.listPlanetas();
		return listPlanetas;
	}
	
	@RequestMapping(value="/deletePlaneta",method=RequestMethod.POST)
    public void deletePlaneta(@RequestBody Map<String, Object> data) throws Exception {	
		 PlanetaRepositorio.deletePlaneta(data.get("id").toString());
	}
	
	@RequestMapping(value="/updatePlaneta",method=RequestMethod.POST)
    public Planeta updatePlaneta(@RequestBody Map<String, Object> data) throws Exception {	
		Planeta planetaCreado = PlanetaRepositorio.updatePlaneta(data.get("id").toString(), data.get("nombre").toString(), data.get("descripcion").toString());
		return planetaCreado;
	}
	
	@RequestMapping(value="/showPlaneta",method=RequestMethod.POST)
    public Planeta showPlaneta(@RequestBody Map<String, Object> data) throws Exception {	
		Planeta planetaCreado = PlanetaRepositorio.showPlaneta(data.get("id").toString());
		return planetaCreado;
	}

}
