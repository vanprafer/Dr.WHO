package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import objectDbCBD.Models.Planeta;

public class PlanetaRepositorio {
	
	public static EntityManager em;
	
	public static Planeta createPlaneta(String nombre, String descripcion) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("C:\\Users\\ErMamaweboPlus\\Desktop\\DataBase.odb");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Planeta e1 = new Planeta(nombre,descripcion);
		em.persist(e1);
		em.getTransaction().commit();
		return e1;	
	}
}
