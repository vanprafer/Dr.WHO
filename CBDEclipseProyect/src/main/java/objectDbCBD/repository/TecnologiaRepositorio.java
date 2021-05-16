package objectDbCBD.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import objectDbCBD.Configuracion;
import objectDbCBD.Models.Tecnologia;

public class TecnologiaRepositorio {
	
	public static EntityManager em;

	public static Tecnologia createTecnologia(String nombre, String descripcion) {
		
		em = Configuracion.em;
		em.getTransaction().begin();
		
		Tecnologia e1 = new Tecnologia(nombre,descripcion);
		
		em.persist(e1);
		em.getTransaction().commit();
		return e1;	
	}
	
	public static List<Tecnologia> listTecnologias(){
		List<Tecnologia> tecnologias = new ArrayList<Tecnologia>();
		em = Configuracion.em;
		
		TypedQuery<Tecnologia> queryP6 = em.createQuery("select p From Tecnologia p", Tecnologia.class);
		tecnologias = queryP6.getResultList();
		return tecnologias;	
	}
	
	public static void deleteTecnologia(String idTecnologia) {
		em = Configuracion.em;
		em.getTransaction().begin();
		
		TypedQuery<Tecnologia> query = em.createQuery("select p From Tecnologia p where p.id = " +idTecnologia, Tecnologia.class);
		Tecnologia tecnologia = query.getSingleResult();
		
		em.remove(tecnologia);
		em.getTransaction().commit();
	}
	
	public static Tecnologia updateTecnologia(String id, String nombre, String descripcion) {
		
		em = Configuracion.em;
		em.getTransaction().begin();
		
		TypedQuery<Tecnologia> query = em.createQuery("select p From Tecnologia p where p.id = " +id, Tecnologia.class);
		Tecnologia tecnologia = query.getSingleResult();
		
		tecnologia.setNombre(nombre);
		tecnologia.setDescripcion(descripcion);
		
		em.persist(tecnologia);
		em.getTransaction().commit();
		return tecnologia;	
	}
	
	public static Tecnologia showTecnologia(String id) {
		em = Configuracion.em;
		
		TypedQuery<Tecnologia> query = em.createQuery("select p From Tecnologia p where p.id = " +id, Tecnologia.class);
		Tecnologia tecnologia = query.getSingleResult();
		return tecnologia;
	}
}
