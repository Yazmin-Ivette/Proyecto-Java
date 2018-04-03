public class PPA extends Profesor{
	private Curso[] cursos = new Curso[5];
	private int numCursos = 0;

	public PPA(){
	}

	public PPA(String n, String d, String t, int nP){
		super(n,d,t,nP);
	}

	public void setNombre(String n){
		super.setNombre(n);
	}

	public String getNombre(){
		return super.getNombre();
	}

	public void setDireccion(String d){
		super.setDireccion(d);
	}

	public String getDireccion(){
		return super.getDireccion();
	}

	public void setTelefono(String t){
		super.setTelefono(t);
	}

	public String getTelefono(){
		return super.getTelefono();
	}

	public void setNoPersonal(int nP){
		super.setNoPersonal(nP);
	}

	public int getNoPersonal(){
		return super.getNoPersonal();
	}

	public void setCurso(Curso cr){
		if(numCursos <= 5){
			cursos[numCursos] = cr;
			numCursos++;
		}else{
			System.out.println("Un profesor de tipo PPA solo puedo impartir 5 cursos");
		}
	}

	public Curso getCurso(int i){
		if(i >= 0 && i <= 5){
			return cursos[i];
		}else{
			return null;
		}
	}
}