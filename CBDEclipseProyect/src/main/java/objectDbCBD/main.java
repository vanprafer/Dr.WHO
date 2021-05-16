package objectDbCBD;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@ComponentScan(basePackages = { "controllers", "services" })
public class main {
	
	public static EntityManager em;
	
	@RequestMapping(value="/deleteDatabase",method=RequestMethod.GET)
    public void deleteDatabase() throws Exception {	

		em = Configuracion.em;
		
		try {
			PopulateDB.borrarObjetos("Individuo", em);
			PopulateDB.borrarObjetos("Planeta", em);
			PopulateDB.borrarObjetos("Tecnologia", em);
		}catch (RuntimeException x) {
			System.err.println("Error: " + x.getMessage());
		}
		
	}
	
	@RequestMapping(value="/createDatabase",method=RequestMethod.GET)
    public void createDatabase() throws Exception {	
	
		em = Configuracion.em;
		
		try {
			PopulateDB.creacionPlaneta(em);
			PopulateDB.creacionTecnologias(em);
			PopulateDB.creacionIndividuo(em);
		}catch (RuntimeException x) {
			System.err.println("Error: " + x.getMessage());
		}
	}
}
