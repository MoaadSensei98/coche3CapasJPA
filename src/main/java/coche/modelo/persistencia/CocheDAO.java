package coche.modelo.persistencia;

import java.util.List;

import coche.modelo.entidad.Coche;

public interface CocheDAO {
	
	int insertar(Coche p);	
	Coche modificar(Coche p);	
	int borrar(int id);	
	Coche buscar(int id);	
	List<Coche> listar();
}
