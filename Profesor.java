public class Profesor extends Persona{
	protected String direccion;
	protected String telefono;
	protected int noPersonal;

	public Profesor(){

	}

	public Profesor(String n, String d, String t, int nP){
		super(n);
		direccion = d;
		telefono = t;
		noPersonal = nP;
	}

	public void setNombre(String n){
		super.setNombre(n);
	}

	public String getNombre(){
		return super.getNombre();
	}

	public void setDireccion(String d){
		direccion = d;
	}

	public String getDireccion(){
		return direccion;
	}

	public void setTelefono(String t){
		telefono = t;
	}

	public String getTelefono(){
		return telefono;
	}

	public void setNoPersonal(int nP){
		noPersonal = nP;
	}

	public int getNoPersonal(){
		return noPersonal;
	}
}