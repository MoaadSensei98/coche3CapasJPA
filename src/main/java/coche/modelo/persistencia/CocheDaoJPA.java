package coche.modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import coche.modelo.entidad.Coche;

@Repository
public class CocheDaoJPA implements CocheDAO {

	//Para inyectarle el objeto entity manager no podemos usar la anotacion
	//@Autowired ya que no hay un objeto de tipo EntityManager en mi contexto
	//de spring. El objeto que tengo dado de alta es un objeto de tipo
	//EntityManagerFactory. Para inyectar un objeto de tipo EntityManager
	//a partir de un objeto EntityManagerFactory, usaremos la anotacion
	//@PersistenceContext
	@PersistenceContext
	private EntityManager em;
	
	public int insertar(Coche p) {
		em.persist(p);//para insertar usaremos persist()
		return p.getId();
	}

	public Coche modificar(Coche p) {
		return em.merge(p);//para modificar usaremos merge()
	}
	
	public Coche buscar(int id) {
		return em.find(Coche.class, id);//para buscar por id
	}
	
	public int borrar(int id) {
		//Para borrar usaremos remove(), pero...
		//Para poder borrar registros de la bbdd, JPA exige que
		//el objeto que vayamos a borrar este dentro del contexto
		//de persistencia (cache).
		//De esta manera, no podemos ejecutar remove() directamente,
		//primero tenemos que meter el objeto en el contexto
		//de persistencia y luego ya podemos borrarlo
		
		//Primero buscamos el objeto en base de datos
		Coche pAux = em.find(Coche.class, id);
		em.remove(pAux);
		return pAux.getId();
	}


	@SuppressWarnings("unchecked")
	public List<Coche> listar() {
		//Para listar todas las peliculas tenemos que recurrir a un lenguaje llamado JPQL
		//es un lenguaje mezcla entre SQL y POO
		List<Coche> listaCoches = em.createQuery("from Coche p").getResultList();
		return listaCoches;
	}

	
}

