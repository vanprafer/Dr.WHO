package objectDbCBD.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.mapping.Array;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import objectDbCBD.Models.Especie;
import objectDbCBD.Models.Individuo;
import objectDbCBD.Models.Organismo;
import objectDbCBD.Models.Planeta;
import objectDbCBD.Models.Tecnologia;
import objectDbCBD.repository.IndividuoRepositorio;
import objectDbCBD.repository.PlanetaRepositorio;
import objectDbCBD.repository.TecnologiaRepositorio;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@ComponentScan(basePackages = { "controllers", "services" })
public class IndividuoController {
		
	public static EntityManager em;
	
	@RequestMapping(value="/createIndividuo",method=RequestMethod.POST)
    public Individuo createIndividuo(@RequestBody Map<String, Object> data) throws Exception {	
		
		List<Tecnologia> lt = new ArrayList<>();
		List<Planeta> lp = new ArrayList<>();
		
		List<String> idsTec = (List) data.get("tecnologias");
		List<String> idsPla = (List) data.get("planetas");
		
		for(String t: idsTec) {
			lt.add(TecnologiaRepositorio.showTecnologia(t)); // ParseInt
		}
		
		for(String p: idsPla) {
			lp.add(PlanetaRepositorio.showPlaneta(p)); // ParseInt
		}
	
		Individuo individuopCreado = IndividuoRepositorio.createIndividuo(data.get("nombre").toString(), 
				Especie.valueOf(data.get("especie").toString()), Integer.valueOf(data.get("numCorazones").toString()), 
				Organismo.valueOf(data.get("organismo").toString()), data.get("descripcion").toString(), lp, lt);
		return individuopCreado;
	}	
	
	@RequestMapping(value="/listIndividuo",method=RequestMethod.GET)
    public List<Individuo> listIndividuo() throws Exception {	
		List<Individuo> listIndividuos = IndividuoRepositorio.listIndividuos();
		return listIndividuos;
	}
	
	@RequestMapping(value="/deleteIndividuo",method=RequestMethod.POST)
    public void deleteIndividuo(@RequestBody Map<String, Object> data) throws Exception {	
		 IndividuoRepositorio.deleteIndividuo(data.get("id").toString());
	}
	
	@RequestMapping(value="/updateIndividuo",method=RequestMethod.POST)
    public Individuo updateIndividuo(@RequestBody Map<String, Object> data) throws Exception {	
		
		List<Tecnologia> lt = new ArrayList<>();
		List<Planeta> lp = new ArrayList<>();
		
		List<String> idsTec = (List) data.get("tecnologias");
		List<String> idsPla = (List) data.get("planetas");
		
		for(String t: idsTec) {
			lt.add(TecnologiaRepositorio.showTecnologia(t));
		}
		
		for(String p: idsPla) {
			lp.add(PlanetaRepositorio.showPlaneta(p));
		}
		
		Individuo indCreado = IndividuoRepositorio.updateIndividuo(data.get("id").toString(), 
				data.get("nombre").toString(), Integer.valueOf(data.get("numCorazones").toString()),
				Organismo.valueOf(data.get("organismo").toString()), data.get("descripcion").toString(), lp, lt);
		return indCreado;
	}
	
	@RequestMapping(value="/showIndividuo",method=RequestMethod.POST)
    public Individuo showIndividuo(@RequestBody Map<String, Object> data) throws Exception {	
		Individuo individuoCreado = IndividuoRepositorio.showIndividuo(data.get("id").toString());
		return individuoCreado;
	}
	
	@RequestMapping(value="/listEspecies",method=RequestMethod.POST)
    public List<Individuo> listIndividuoPorEspecie(@RequestBody Map<String, Object> data) throws Exception {	
		List<Individuo> listIndividuos = IndividuoRepositorio.listarIndPorEspecie(data.get("especie").toString());
		return listIndividuos;
	}
}
