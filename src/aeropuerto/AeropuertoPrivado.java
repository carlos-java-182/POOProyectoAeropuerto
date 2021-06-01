package aeropuerto;

public class AeropuertoPrivado extends Aeropuerto{
	
	private String listaEmpresas[]= new String[10];
	private int numeroEmpresa;
	
	
	public AeropuertoPrivado(String nombre, String ciudad, String pais) {
		super(nombre, ciudad, pais);
	}


	public AeropuertoPrivado(String nombre, String ciudad, String pais, Compañia[] c, String[] e,
			int numeroEmpresa) {
		super(nombre, ciudad, pais, c);
		this.listaEmpresas = e;
		this.numeroEmpresa = e.length;
	}
	
	
	public void insertarEmpresas(String e[]) {
		this.listaEmpresas = e;
		this.numeroEmpresa = e.length;
	}
	
	public void insertarEmpresa(String e) {
		listaEmpresas[numeroEmpresa] = e;
		numeroEmpresa++;
	}


	public String[] getListaEmpresas() {
		return listaEmpresas;
	}


	public int getNumeroEmpresa() {
		return numeroEmpresa;
	}


	
	
	
	
	

	

}
