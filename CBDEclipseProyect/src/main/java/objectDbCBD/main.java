package objectDbCBD;


import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

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
public class main {
	
	public static EntityManager em;
	
	@RequestMapping(value="/createDatabase",method=RequestMethod.GET)
    public void createDatabase() throws Exception {	
	
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("C:\\Users\\ErMamaweboPlus\\Desktop\\DataBase.odb");
			em = emf.createEntityManager();
			
			try {
				
				//borrarObjetos("Individuo");
				//borrarObjetos("Planeta");
				//borrarObjetos("Tecnologia");
				
				PopulateDB.creacionPlaneta();
				PopulateDB.creacionTecnologias();
				PopulateDB.creacionIndividuo();

			}
			finally {
				em.close();
				emf.close();
			}
			}catch (RuntimeException x) {
				System.err.println("Error: " + x.getMessage());
		}
		
	}
}
