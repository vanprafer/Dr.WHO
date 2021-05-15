package controllers;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import objectDbCBD.Models.Tecnologia;
import repository.TecnologiaRepositorio;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@ComponentScan(basePackages = { "controllers", "services" })
public class tecnologiaController {
		
	public static EntityManager em;
	
	@RequestMapping(value="/createTecnologia",method=RequestMethod.POST)
    public Tecnologia createTecnologia(@RequestBody Map<String, Object> data) throws Exception {	
		Tecnologia tecnologiaCreada = TecnologiaRepositorio.createTecnologia(data.get("nombre").toString(), data.get("descripcion").toString());
		return tecnologiaCreada;
	}
	
	@RequestMapping(value="/listTecnologia",method=RequestMethod.GET)
    public List<Tecnologia> listTecnologia() throws Exception {	
		List<Tecnologia> listTecnologias = TecnologiaRepositorio.listTecnologias();
		return listTecnologias;
	}
	
	@RequestMapping(value="/deleteTecnologia",method=RequestMethod.POST)
    public void deleteTecnologia(@RequestBody Map<String, Object> data) throws Exception {	
		 TecnologiaRepositorio.deleteTecnologia(data.get("id").toString());
	}
	
	@RequestMapping(value="/updateTecnologia",method=RequestMethod.POST)
    public Tecnologia updateTecnologia(@RequestBody Map<String, Object> data) throws Exception {	
		Tecnologia tecnologiaCreada = TecnologiaRepositorio.updateTecnologia(data.get("id").toString(), data.get("nombre").toString(), data.get("descripcion").toString());
		return tecnologiaCreada;
	}
	
	@RequestMapping(value="/showTecnologia",method=RequestMethod.POST)
    public Tecnologia showTecnologia(@RequestBody Map<String, Object> data) throws Exception {	
		Tecnologia tecnologiaCreada = TecnologiaRepositorio.showTecnologia(data.get("id").toString());
		return tecnologiaCreada;
	}

}
