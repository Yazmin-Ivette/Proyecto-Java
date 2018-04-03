public class Alumno extends Persona{
	private String direccion;
	private String telefono;
	private String matricula;
	private Curso[] cursos = new Curso[6];
	//private int[] calificaciones = new int[6];
	private int numCursos = 0;
	private float[] calificaciones = new float[6];

	public Alumno(){

	}

	public Alumno(String n, String d, String t, String m){
		super(n);
		direccion = d;
		telefono = t;
		matricula = m;
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

	public void setMatricula(String m){
		matricula = m;
	}

	public String getMatricula(){
		return matricula;
	}

	public void setCurso(Curso cr){
		if(numCursos <= 6){
			cursos[numCursos] = cr;
			numCursos++;
		}else{
			System.out.println("Un profesor de tipo PPA solo puedo impartir 5 cursos");
		}
	}

	public Curso getCurso(int i){
		if(i >= 0 && i <= 6){
			return cursos[i];
		}else{
			return null;
		}
	}

	public void setCalificacion(int i,float cal){
		calificaciones[i] = cal;
	}

	public float getCalificacion(int i){
		return calificaciones[i];
	}

	public int getNumCursos(){
		return numCursos;
	}

	public Curso buscarCurso(Curso c){
		int j = 0;
		for(int i=0;i<=numCursos;i++){
			if(cursos[i].getNRC() == c.getNRC()){
				return cursos[i];
			}
		}
		return cursos[j]; 
	}

	public int getIndiceCurso(Curso c){
		int j = 0;
			for(int i=0;i<=numCursos;i++){
			if(cursos[i].getNRC() == c.getNRC()){
				return i;
			}
		}
		return j;
		

	}
}