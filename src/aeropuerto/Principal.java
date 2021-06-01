package aeropuerto;

import java.util.Scanner;

public class Principal {

	static Scanner entrada = new Scanner(System.in);
	final static int num = 4; // Numero de aeropuertos
	static Aeropuerto aeropuertos[] = new Aeropuerto[4];

	public static void main(String[] args) {
		// Insertar datos de los aeropuertos
		insertarDatosAeropuerto(aeropuertos);
		menu();
	}

	public static void insertarDatosAeropuerto(Aeropuerto aero[]) {

		aero[0] = new AeropuertoPublico("Jorge Ch�vez", "Lima", "Per�", 80000000);
		aero[0].insertarCompa�ia(new Compa�ia("AeroPer�"));
		aero[0].insertarCompa�ia(new Compa�ia("LATAM"));
		aero[0].getCompa�ia("AeroPer�").insertarVuelos(new Vuelo("IB20", "Lima", "M�xico", 150.90, 150));
		aero[0].getCompa�ia("AeroPer�").insertarVuelos(new Vuelo("IB21", "Lima", "BuenosAires", 180.99, 120));
		aero[0].getCompa�ia("LATAM").insertarVuelos(new Vuelo("FC12", "Lima", "Londres", 500.90, 180));
		aero[0].getCompa�ia("AeroPer�").getVuelo("IB20")
				.insertarPasajero(new Pasajero("Alejandro", "20BGHP", "Peruana"));
		aero[0].getCompa�ia("AeroPer�").getVuelo("IB20").insertarPasajero(new Pasajero("Maria", "PJKL20", "Mexicana"));
		aero[0].getCompa�ia("LATAM").getVuelo("FC12").insertarPasajero(new Pasajero("Ra�l", "JH21k1", "Peruana"));

		aero[1] = new AeropuertoPrivado("Central Ciudad Real", "Ciudad Real", "Espa�a");
		aero[1].insertarCompa�ia(new Compa�ia("AirEuropa"));
		String empresas[] = { "Cobresol", "Aguila34" };
		((AeropuertoPrivado) aero[1]).insertarEmpresas(empresas);
		aero[1].getCompa�ia("AirEuropa").insertarVuelos(new Vuelo("AE025", "Madrid", "BuenosAires", 125.50, 150));
		aero[1].getCompa�ia("AirEuropa").getVuelo("AE025")
				.insertarPasajero(new Pasajero("Carlos", "JLA2828", "Espa�ola"));

		aero[2] = new AeropuertoPrivado("Aeropuerto Bogot�", "Bogot�", "Colombia");
		aero[2].insertarCompa�ia(new Compa�ia("AirAm�rica"));
		aero[2].insertarCompa�ia(new Compa�ia("Vuela Bogot�"));
		aero[2].getCompa�ia("AirAm�rica").insertarVuelos(new Vuelo("AE030", "Bogot�", "Lima", 120, 120));
		aero[2].getCompa�ia("AirAm�rica").insertarVuelos(new Vuelo("AE031", "Bogot�", "Lima", 120, 120));
		aero[2].getCompa�ia("AirAm�rica").getVuelo("AE030")
				.insertarPasajero(new Pasajero("Socorro", "B13620", "Colombiana"));
		aero[2].getCompa�ia("AirAm�rica").getVuelo("AE031")
				.insertarPasajero(new Pasajero("Manuel", "B13720", "Colombiana"));

		aero[3] = new AeropuertoPublico("Aeropuerto M�xico", "M�xico", "M�xico");
		aero[3].insertarCompa�ia(new Compa�ia("Aeromexico"));
		aero[3].getCompa�ia("Aeromexico").insertarVuelos(new Vuelo("IB2040", "M�xico", "Nueva York", 600, 120));
		aero[3].getCompa�ia("Aeromexico").insertarVuelos(new Vuelo("IB2042", "M�xico", "Lima", 500, 120));
		aero[3].getCompa�ia("Aeromexico").getVuelo("IB2040")
				.insertarPasajero(new Pasajero("Jessica", "B12183", "Mexicana"));
		;

	}

	public static void menu() {
		int opcion;
		String nombreAeropuerto, nombreCompa�ia, origen, destino;
		Aeropuerto aero;
		Compa�ia compa�ia;

		do {
			System.out.println("\t .:MENU:.");
			System.out.println("1.- Ver Aeropuertos gestionados (P�blicos o privados)");
			System.out.println("2.- Ver empresas(Privado) o subvenci�n (P�blico)");
			System.out.println("3.- Lista de compa�ias de un Aeropuerto");
			System.out.println("4.- Lista de vuelos por Compa�ia");
			System.out.println("5.- Listar posibles vuelos de Origen a Destino");
			System.out.println("6.- Salir");
			System.out.println("Digite la opci�n: ");
			opcion = entrada.nextInt();

			switch (opcion) {

			case 1: // Ver Aeropuertos gestionados
				mostrarDatosAeropuertos();
				break;
			case 2:// Ver empresas
				mostrarPatrocinio(aeropuertos);
				break;
			case 3: // Lista de compa�ias de un aeropuerto
				System.out.print("\nDigite un el nombre de un aeropuerto");
				entrada.nextLine();
				nombreAeropuerto = entrada.nextLine();
				aero = buscarAeropuerto(nombreAeropuerto, aeropuertos);
				if (aero == null) {
					System.out.println("El aeropuerto no existe");
				} else {
					mostrarCompa�ias(aero);
				}
				break;
			case 4: // Lista de vuelos por compa�ia

				entrada.nextLine();
				System.out.println("Digite el nombre del aeropuerto");
				nombreAeropuerto = entrada.nextLine();
				aero = buscarAeropuerto(nombreAeropuerto, aeropuertos);

				if (aero == null) {
					System.out.println("El aeropuerto no existe");
				} else {
					System.out.println("Digite el nombre de la compa�ia");
					nombreCompa�ia = entrada.nextLine();
					compa�ia = aero.getCompa�ia(nombreCompa�ia);
					mostrarVuelos(compa�ia);
				}
				break;
			case 5: // Listar posibles vuelos de origen a destino
				entrada.nextLine();
				System.out.println("Digite la ciudad de origen: ");
				origen = entrada.nextLine();
				System.out.println("Digite la ciudd destino");
				destino = entrada.nextLine();
				mostrarVueloOrigenDestino(origen, destino, aeropuertos);

				break;
			case 6:
				System.out.println("Haz salido del sistema");
				break;
			default:
				System.out.println("Digite una opci�n v�lida");

			}

			System.out.println(" ");

		} while (opcion != 6);
	}

	public static void mostrarDatosAeropuertos() {
		for (int i = 0; i < aeropuertos.length; i++) {
			if (aeropuertos[i] instanceof AeropuertoPrivado) {
				System.out.println("Aeropuerto Privado");
				System.out.println("Nombre: " + aeropuertos[i].getNombre());
				System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
				System.out.println("Pa�s: " + aeropuertos[i].getPais());

			}

			else {
				System.out.println("Aeropuerto P�blico");
				System.out.println("Nombre: " + aeropuertos[i].getNombre());
				System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
				System.out.println("Pa�s: " + aeropuertos[i].getPais());

			}

			System.out.println("");
		}
	}

	public static void mostrarPatrocinio(Aeropuerto aeropuertos[]) {

		String empresas[];

		for (int i = 0; i < aeropuertos.length; i++) {

			if (aeropuertos[i] instanceof AeropuertoPrivado) {
				System.out.println("Aeropuerto Privado");
				System.out.println(aeropuertos[i].getNombre());
				empresas = ((AeropuertoPrivado) aeropuertos[i]).getListaEmpresas();

				System.out.println("Las empresas que patrocinan son las siguientes: ");

				for (int j = 0; j < empresas.length; j++) {
					System.out.println(empresas[j]);
				}
			}

			else {
				System.out.println("Aeropuerto P�blico: " + aeropuertos[i].getNombre());
				System.out.println("La subvensi�n es: " + ((AeropuertoPublico) aeropuertos[i]).getSubvencion());
			}

			System.out.println("");
		}

	}

	public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]) {
		boolean encontrado = false;
		int i = 0;
		Aeropuerto aero = null;

		while ((!encontrado) && i < aeropuertos.length) {
			if (nombre.equals(aeropuertos[i].getNombre())) {
				encontrado = true;
				aero = aeropuertos[i];
			}
			i++;
		}
		return aero;
	}

	public static void mostrarCompa�ias(Aeropuerto aeropuerto) {

		System.out.println("Las compa�ias del aeropuerto: " + aeropuerto.getNombre() + "son las siguientes: ");
		for (int i = 0; i < aeropuerto.getNumCompa�ia(); i++) {
			System.out.println(aeropuerto.getCompa�ia(i).getNombre());
		}
	}

	public static void mostrarVuelos(Compa�ia compa�ia) {

		Vuelo vuelo;
		System.out.println("Los vuelos de la compa�ia: " + compa�ia.getNombre());
		for (int i = 0; i < compa�ia.getNumVuelo(); i++) {
			vuelo = compa�ia.getVuelo(i);
			System.out.println("Identificador: " + vuelo.getIdentificador());
			System.out.println("Ciudad origen: " + vuelo.getCiudadOrigen());
			System.out.println("Ciudad destino: " + vuelo.getDestinoDestino());
			System.out.println("Precio: " + vuelo.getPrecio());
			System.out.println("");
		}
	}

	public static Vuelo[] buscarVuelosOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]) {

		Vuelo vuelo;
		int contador=0;
		Vuelo listaVuelos[];

		for (int i = 0; i < aeropuertos.length; i++) {
			for (int j = 0; j < aeropuertos[i].getNumCompa�ia(); j++) {
				for (int k = 0; k < aeropuertos[i].getCompa�ia(j).getNumVuelo(); k++) {
					vuelo = aeropuertos[i].getCompa�ia(j).getVuelo(k);
					if((origen.equals(vuelo.getCiudadOrigen())) && (destino.equals(vuelo.getDestinoDestino()))){
						contador++;
					}
				}
			}
		}
		
		listaVuelos = new Vuelo[contador];
		int q=0;
		
		for(int i=0; i<aeropuertos.length;i++) {
			for(int j=0; j<aeropuertos[i].getNumCompa�ia();j++) {
				for(int k=0; k<aeropuertos[i].getCompa�ia(j).getNumVuelo();k++) {
					vuelo= aeropuertos[i].getCompa�ia(j).getVuelo(k);
					if((origen.equals(vuelo.getCiudadOrigen()))&& (destino.equals(vuelo.getDestinoDestino()))) {
						listaVuelos[q]=vuelo;
						q++;
					}
				}
			}
		}
		return listaVuelos;
	}

	public static void mostrarVueloOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]) {
		Vuelo vuelos[];
		vuelos=buscarVuelosOrigenDestino(origen, destino, aeropuertos);
		if(vuelos.length==0) {
			System.out.println("No existen vuelos de esa ciudad origen a destino");
		}
		else {
			System.out.println("Vuelos encontrados");
			for(int i=0; i<vuelos.length; i++) {
				System.out.println("Identificador: "+vuelos[i].getIdentificador());
				System.out.println("Ciudad de origen: "+vuelos[i].getCiudadOrigen());
				System.out.println("Ciudad destino: "+vuelos[i].getDestinoDestino());
				System.out.println("Precio del vuelo: "+vuelos[i].getPrecio());
				System.out.println("");
			}
		}
	}
}
