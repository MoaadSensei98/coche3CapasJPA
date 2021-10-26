package coche.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coche.modelo.entidad.Coche;
import coche.modelo.persistencia.CocheDaoJPA;

@Service
public class GestorCoche {
	
	@Autowired
	private CocheDaoJPA cocheDAO;
	
	//Con esta anotacion le decimos a spring que todas las acciones que se hagan
	//en bbdd sean transaccionales. Son obligatorias en aquellas acciones
	//que modifiquen la BBDD
	@Transactional
	public int insertar(Coche p) {
		if(p.getMatricula().length() == 7 && !p.getMarca().isEmpty() && !p.getModelo().isEmpty() && !p.getMatricula().isEmpty() ) {
			 
			return cocheDAO.insertar(p); 
		 	
		}
		System.out.println("Los parámetros marca, modelo y matricula no pueden estar vacios!");
		System.out.println("El parámetro matricula tiene que ser de 7 carácteres!");
		return 0;
	}
	
	@Transactional
	public Coche modificar(Coche p) {
		if(p.getMatricula().length() == 7 && !p.getMarca().isEmpty() && !p.getModelo().isEmpty() && !p.getMatricula().isEmpty() ) {
			 
			return cocheDAO.modificar(p); 
		 	
		}
		System.out.println("Los parámetros marca, modelo y matricula no pueden estar vacios!");
		System.out.println("El parámetro matricula tiene que ser de 7 carácteres!");
 		return null;
	}
	
	@Transactional
	public void borrar(int id) {
		cocheDAO.borrar(id);
	}
	
	//Listar y obtener NO modifican la bbdd, por lo tanto no tiene
	//porque se transaccional 
	public Coche buscar(int id) {
		return cocheDAO.buscar(id);
	}
	
	public List<Coche> listar(){
		return cocheDAO.listar();
	}
	
}
