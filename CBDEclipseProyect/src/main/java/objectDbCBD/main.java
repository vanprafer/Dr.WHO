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
	
	static EntityManager em;
	
	@RequestMapping(value="/createDatabase",method=RequestMethod.GET)
	//@GetMapping("/createDatabase")
    public void createDatabase() throws Exception {	
	
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("C:\\Users\\Vanessa\\Desktop\\DataBase.odb");
			em = emf.createEntityManager();
			
			try {
				
				//creacionDatosEstudiantes();

				//creacionDatosProfesores();

				//creacionDatosAsignaturas();

				//crearRelacionesEstudianteAsignatura();
				
				//crearRelacionesProfesorAsignatura();
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
