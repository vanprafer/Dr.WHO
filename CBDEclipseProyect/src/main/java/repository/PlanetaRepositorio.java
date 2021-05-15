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
		return planetas;	
	}
	
	public static void deletePlaneta(String idPlaneta) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Planeta> query = em.createQuery("select p From Planeta p where p.id = " +idPlaneta, Planeta.class);
		Planeta planeta = query.getSingleResult();
		
		em.remove(planeta);
		em.getTransaction().commit();
	}
	
	public static Planeta updatePlaneta(String id, String nombre, String descripcion) {
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Planeta> query = em.createQuery("select p From Planeta p where p.id = " +id, Planeta.class);
		Planeta planeta = query.getSingleResult();
		
		planeta.setNombre(nombre);
		planeta.setDescripcion(descripcion);
		
		em.persist(planeta);
		em.getTransaction().commit();
		return planeta;	
	}
	
	public static Planeta showPlaneta(String id) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Planeta> query = em.createQuery("select p From Planeta p where p.id = " +id, Planeta.class);
		Planeta planeta = query.getSingleResult();
		return planeta;
	}
}
