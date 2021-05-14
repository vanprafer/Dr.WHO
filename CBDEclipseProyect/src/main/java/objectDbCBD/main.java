package objectDbCBD;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import objectDbCBD.Models.Especie;
import objectDbCBD.Models.Individuo;
import objectDbCBD.Models.Organismo;
import objectDbCBD.Models.Planeta;
import objectDbCBD.Models.Tecnologia;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@ComponentScan(basePackages = { "controllers", "services" })
public class main {
	
	static EntityManager em;
	
	@RequestMapping(value="/createDatabase",method=RequestMethod.GET)
	//@GetMapping("/createDatabase")
    public void createDatabase() throws Exception {	
	
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("C:\\Users\\ErMamaweboPlus\\Desktop\\DataBase.odb");
			em = emf.createEntityManager();
			
			try {
				
				//borrarObjetos("Individuo");
				//borrarObjetos("Planeta");
				//borrarObjetos("Tecnologia");
				
				creacionPlaneta();
				creacionTecnologias();
				creacionIndividuo();

			}
			finally {
				em.close();
				emf.close();
			}
			}catch (RuntimeException x) {
				System.err.println("Error: " + x.getMessage());
		}
		
	}
	
	private static void borrarObjetos(String objeto){
		em.getTransaction().begin();
		int count = em.createQuery("DELETE FROM " + objeto).executeUpdate();
		em.getTransaction().commit();
	}
	
	private static void creacionPlaneta(){

		em.getTransaction().begin();
		Planeta e1 = new Planeta("Galifrei","Hogar de los seniores del tiempo, perdido en el tiempo y el espacio");
		em.persist(e1);
		
		Planeta e2 = new Planeta("Skaro","Hogar de los Daleks, actualmente arrasado");
		em.persist(e2);
		
		Planeta e3 = new Planeta("Sontar","Hogar de los sontaran, posee un campo gravitatorio muy potente");
		em.persist(e3);
		
		Planeta e4 = new Planeta("Mondas","Hogar de los Cybermen, planeta mellizo de la tierra");
		em.persist(e4);
		
		Planeta e5 = new Planeta("Sin planeta","El planeta origen de la especie es desconocido");
		em.persist(e5);
		
		Planeta e6 = new Planeta("Tierra","Hogar de los humanos");
		em.persist(e6);

		em.getTransaction().commit();
	}
	
	private static void creacionTecnologias() {
		em.getTransaction().begin();
		
		Tecnologia t1 = new Tecnologia("Destornillador sonico", "Destornillador que emite ondas sonicas propiedad del Doctor");
		em.persist(t1);
		
		Tecnologia t2 = new Tecnologia("Tardis", "Time And Relative Dimensions In Space");
		em.persist(t2);
		
		Tecnologia t3 = new Tecnologia("Papel Psiquico", "Hoja de papel blanco que pone lo que el propietario quiera");
		em.persist(t3);
		
		Tecnologia t4 = new Tecnologia("Cohete espacial", "Cohete para viajar a las estrellas diseniado por los humanos");
		em.persist(t4);
		
		Tecnologia t5 = new Tecnologia("Vortice del tiempo", "Puerta para viajar por el espacio tiempo");
		em.persist(t5);
		
		Tecnologia t6 = new Tecnologia("Caja de pandora", "Carcel definitiva que no se puede abrir diseniada por los daleks");
		em.persist(t6);
		
		Tecnologia t7 = new Tecnologia("Ojo de la armonia", "Singularidad espacial en posesion de los daleks");
		em.persist(t7);
		
		Tecnologia t8 = new Tecnologia("Electro ataque", "Ataque electrico de los cybermen que paraliza o mata al objetivo");
		em.persist(t8);
		
		Tecnologia t9 = new Tecnologia("Baston de contoneo", "Arma principal usada por los sontaran");
		em.persist(t9);
		
		Tecnologia t10 = new Tecnologia("Teleportar en el tiempo", "Castigo que imponen los angeles a sus victimas");
		em.persist(t10);
		
		em.getTransaction().commit();
	}
	
	
	private static void creacionIndividuo() {
		em.getTransaction().begin();
		
		TypedQuery<Planeta> queryP = em.createQuery("select p From Planeta p where p.nombre = 'Galifrei'", Planeta.class);
		Planeta p = queryP.getSingleResult();
		
		TypedQuery<Tecnologia> queryT = em.createQuery("select p From Tecnologia p where p.nombre = 'Tardis'", Tecnologia.class);
		Tecnologia t = queryT.getSingleResult();
		
		List<Planeta> planetas1 = new ArrayList<Planeta>();
		planetas1.add(p);
		
		List<Tecnologia> tecnologias1 = new ArrayList<Tecnologia>();
		tecnologias1.add(t);
		
		Individuo e1 = new Individuo("Doctor", 
				Especie.SENORDELTIEMPO, 2, Organismo.ORGANICO, 
				"El doctor, la tormenta que se acerca, el exterminador de planetas",
				planetas1, tecnologias1);
		
		em.persist(e1);
		
		//-----------------------------------------------------------------------------
		
		TypedQuery<Planeta> queryP2 = em.createQuery("select p From Planeta p where p.nombre = 'Skaro'", Planeta.class);
		Planeta p2 = queryP2.getSingleResult();
		
		TypedQuery<Tecnologia> queryT2 = em.createQuery("select p From Tecnologia p where p.nombre = 'Caja de pandora'", Tecnologia.class);
		Tecnologia t2 = queryT2.getSingleResult();
		
		List<Planeta> planetas2 = new ArrayList<Planeta>();
		planetas2.add(p2);
		
		List<Tecnologia> tecnologias2 = new ArrayList<Tecnologia>();
		tecnologias2.add(t2);
		
		Individuo e2 = new Individuo("Dalek rojo", 
				Especie.DALEK, 1, Organismo.MIXTO, 
				"El enemigo natural de los seniores del tiempo, exterminan especies enteras por placer, le tienen miedo al doctor",
				planetas2, tecnologias2);
		em.persist(e2);
		
		//-----------------------------------------------------------------------------
		
		TypedQuery<Planeta> queryP3 = em.createQuery("select p From Planeta p where p.nombre = 'Sontar'", Planeta.class);
		Planeta p3 = queryP3.getSingleResult();
		
		TypedQuery<Tecnologia> queryT3 = em.createQuery("select p From Tecnologia p where p.nombre = 'Baston de contoneo'", Tecnologia.class);
		Tecnologia t3 = queryT3.getSingleResult();
		
		List<Planeta> planetas3 = new ArrayList<Planeta>();
		planetas3.add(p3);
		
		List<Tecnologia> tecnologias3 = new ArrayList<Tecnologia>();
		tecnologias3.add(t3);
		
		Individuo e3 = new Individuo("Sontaran medico", 
				Especie.SONTARAN, 1, Organismo.ORGANICO, 
				"Especie que se reproduce mediante clonacion, son guerreros perfectos sin miedo, ser medico es una desonra para ellos",
				planetas3, tecnologias3);
		em.persist(e3);
		
		//-----------------------------------------------------------------------------
		
		TypedQuery<Planeta> queryP4 = em.createQuery("select p From Planeta p where p.nombre = 'Mondas'", Planeta.class);
		Planeta p4 = queryP4.getSingleResult();
		
		TypedQuery<Tecnologia> queryT4 = em.createQuery("select p From Tecnologia p where p.nombre = 'Electro ataque'", Tecnologia.class);
		Tecnologia t4 = queryT4.getSingleResult();
		
		List<Planeta> planetas4 = new ArrayList<Planeta>();
		planetas4.add(p4);
		
		List<Tecnologia> tecnologias4 = new ArrayList<Tecnologia>();
		tecnologias4.add(t4);
		
		Individuo e4 = new Individuo("Cybermen generico", 
				Especie.CYBERMAN, 1, Organismo.MIXTO, 
				"Evolucion de los humanos, cebebro humano, corazon de maquina, no tienen sentimientos, solo conquistan",
				planetas4, tecnologias4);
		em.persist(e4);
		
		//-----------------------------------------------------------------------------
		
		TypedQuery<Planeta> queryP5 = em.createQuery("select p From Planeta p where p.nombre = 'Sin planeta'", Planeta.class);
		Planeta p5 = queryP5.getSingleResult();
		
		TypedQuery<Tecnologia> queryT5 = em.createQuery("select p From Tecnologia p where p.nombre = 'Teleportar en el tiempo'", Tecnologia.class);
		Tecnologia t5 = queryT5.getSingleResult();
		
		List<Planeta> planetas5 = new ArrayList<Planeta>();
		planetas5.add(p5);
		
		List<Tecnologia> tecnologias5 = new ArrayList<Tecnologia>();
		tecnologias5.add(t5);
		
		Individuo e5 = new Individuo("Angel lloroso enfadado", 
				Especie.ANGEL, 1, Organismo.NOORGANICO, 
				"Los depredadores primigeneos, nacidos en el origen del tiempo para matar y causar dolor, si los miras fijamente se vuelven de piedra",
				planetas5, tecnologias5);
		em.persist(e5);
		
		//-----------------------------------------------------------------------------
		
		TypedQuery<Planeta> queryP6 = em.createQuery("select p From Planeta p where p.nombre = 'Tierra'", Planeta.class);
		Planeta p6 = queryP6.getSingleResult();
		
		List<Planeta> planetas6 = new ArrayList<Planeta>();
		planetas6.add(p6);
		
		List<Tecnologia> tecnologias6 = new ArrayList<Tecnologia>();
		
		Individuo e6 = new Individuo("Rose", 
				Especie.HUMANO, 1, Organismo.ORGANICO, 
				"Companiera del doctor, londinense, energica y un poco choni",
				planetas6, tecnologias6);
		em.persist(e6);
		
		em.getTransaction().commit();
	}
	
	

}
