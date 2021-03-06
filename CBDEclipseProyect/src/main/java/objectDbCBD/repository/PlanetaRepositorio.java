package objectDbCBD.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import objectDbCBD.Configuracion;
import objectDbCBD.Models.Planeta;

public class PlanetaRepositorio {
	
	public static EntityManager em;
	
	public static Planeta createPlaneta(String nombre, String descripcion) {
		
		em = Configuracion.em;
		em.getTransaction().begin();
		
		Planeta e1 = new Planeta(nombre,descripcion);
		
		em.persist(e1);
		em.getTransaction().commit();
		return e1;	
	}
	
	public static List<Planeta> listPlanetas(){
		List<Planeta> planetas = new ArrayList<Planeta>();
		em = Configuracion.em;
		
		TypedQuery<Planeta> queryP6 = em.createQuery("select p From Planeta p", Planeta.class);
		planetas = queryP6.getResultList();
		return planetas;	
	}
	
	public static void deletePlaneta(String idPlaneta) {
		em = Configuracion.em;
		em.getTransaction().begin();
		
		TypedQuery<Planeta> query = em.createQuery("select p From Planeta p where p.id = " +idPlaneta, Planeta.class);
		Planeta planeta = query.getSingleResult();
		
		em.remove(planeta);
		em.getTransaction().commit();
	}
	
	public static Planeta updatePlaneta(String id, String nombre, String descripcion) {
		
		em = Configuracion.em;
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
		em = Configuracion.em;
		
		TypedQuery<Planeta> query = em.createQuery("select p From Planeta p where p.id = " +id, Planeta.class);
		Planeta planeta = query.getSingleResult();
		return planeta;
	}
}
