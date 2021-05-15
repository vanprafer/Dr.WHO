package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import objectDbCBD.Models.Planeta;

public class PlanetaRepositorio {
	
	public static EntityManager em;
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("C:\\Users\\ErMamaweboPlus\\Desktop\\DataBase.odb");
	
	
	public static Planeta createPlaneta(String nombre, String descripcion) {
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Planeta e1 = new Planeta(nombre,descripcion);
		em.persist(e1);
		em.getTransaction().commit();
		return e1;	
	}
	
	public static List<Planeta> listPlanetas(){
		List<Planeta> planetas = new ArrayList<Planeta>();
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Planeta> queryP6 = em.createQuery("select p From Planeta p", Planeta.class);
		planetas = queryP6.getResultList();
		//em.getTransaction().commit();
		return planetas;	
	}
}
