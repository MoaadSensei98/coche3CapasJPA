package coche.main;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import coche.cfg.ConfiguracionJPA;
import coche.modelo.entidad.Coche;
import coche.modelo.negocio.GestorCoche;

public class MainJPA {

	private static ApplicationContext context;

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext(ConfiguracionJPA.class);
		Coche coche = null;
		GestorCoche gp = context.getBean(GestorCoche.class);

		Scanner sc = new Scanner(System.in);
		System.out.println("Escriba el numero de lo que desa hacer ");
		String menu = "(1.Añadir, 2.Eliminar, 3.Modificar, 4.Buscar o 5.Listar):";
		int casos = 0;
		do {
			System.out.println(menu);
			casos = Integer.parseInt(sc.nextLine());
			switch (casos) {
			case 1:
				coche = new Coche();
				pedirDatosCoche(coche, sc);

				int id = gp.insertar(coche);
				System.out.println("id insertado: " + id);

				break;
			case 2:
				System.out.print("Escribe la id del coche: ");
				int idE = sc.nextInt();
				System.out.println("Coche borrado");
				gp.borrar(idE);
				break;
			case 3:
				try {
					coche = new Coche();
					System.out.print("Escribe la id: ");
					int idM = sc.nextInt();
					coche.setId(idM);
					pedirDatosCoche(coche, sc);
					gp.modificar(coche);
					System.out.println("Coche modificado: ");
				} catch (NumberFormatException e) {
					System.out.println("ERROR: el id debe ser numerico");
				}

				break;
			case 4:
				System.out.print("Escribe la id: ");
				int idB = Integer.parseInt(sc.nextLine());
				System.out.println("Búsqueda del coche");
				System.out.println(gp.buscar(idB));
				break;
			case 5:
				System.out.print("Lista de todos los coches");
				List<Coche> lista = gp.listar();
				// Con una funcion lambda podemos recorrer todas las peliculas
				lista.forEach((v) -> System.out.println(v));
				break;
			case 0:
				break;
			}

		} while (casos != 0);

	}

	private static void pedirDatosCoche(Coche coche, Scanner sc) {
		System.out.print("Escribe la marca: ");
		String marcaA = sc.nextLine();
		coche.setMarca(marcaA);
		System.out.print("Escribe el modelo: ");
		String modeloA = sc.nextLine();
		coche.setModelo(modeloA);
		System.out.print("Escribe los kilometros: ");
		String kmA = sc.nextLine();
		coche.setKm(Integer.parseInt(kmA));
		System.out.print("Escribe la matricula: ");
		String matriculaA = sc.nextLine();
		coche.setMatricula(matriculaA);
	}
}
