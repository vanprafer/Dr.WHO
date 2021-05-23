package objectDbCBD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Configuracion {
	
	public static EntityManagerFactory emf;
	public static EntityManager em;
	
	public static void init() {
		emf = Persistence.createEntityManagerFactory("C:\\Users\\Vanessa\\Desktop\\DataBase.odb");
		em = emf.createEntityManager();
	}
	
}
