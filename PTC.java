public class PTC extends Profesor{
	private int cubiculo;
	private Curso[] cursos = new Curso[4];
	private int numCursos = 0;

	public PTC(){

	}

	public PTC(String n, String d, String t, int nP, int c){
		super(n,d,t,nP);
		cubiculo = c;
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

	public void setCubiculo(int c){
		cubiculo = c;
	}

	public int getCubiculo(){
		return cubiculo;
	}

	public void setCurso(Curso cr){
		if(numCursos <= 4){
			cursos[numCursos] = cr;
			numCursos++;
		}else{
			System.out.println("Un profesor de tipo PTC solo puedo impartir 4 cursos");
		}
	}

	public Curso getCurso(int i){
		if(i >= 0 && i <= 4){
			return cursos[i];
		}else{
			return null;
		}
	}
}