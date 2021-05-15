//package objectDbCBD.controllers;
//
//import java.util.Map;
//
//import javax.persistence.EntityManager;
//
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import objectDbCBD.Models.Individuo;
//import objectDbCBD.repository.IndividuoRepositorio;
//
//@RestController
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
//@ComponentScan(basePackages = { "controllers", "services" })
//public class IndividuoController {
//		
//	public static EntityManager em;
//	
//	@RequestMapping(value="/createIndividuo",method=RequestMethod.POST)
//    public Individuo createPlaneta(@RequestBody Map<String, Object> data) throws Exception {	
//	
//		Individuo individuopCreado = IndividuoRepositorio.createIndividuo(data.get("nombre").toString(), data.get("especie").toString(),
//				data.get("numCorazones").toString(), data.get("organismo").toString(), data.get("descripcion").toString(),
//				data.get("planeta").toString(), data.get("tecnologia").toString());
//		return individuopCreado;
//	}	
//}
