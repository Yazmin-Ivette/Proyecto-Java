public class Curso{
	private Profesor maestro;
	private Alumno[] alumnos = new Alumno[30];
	private int numAlumnos = 0;
	private ExperienciaEdu eE;
	private int nrc;
	private String horario;
	private float[] calificaciones = new float[30];

	public Curso(){

	}

	public Curso(int nrc, String hr){
		this.nrc = nrc;
		horario = hr;
	}

	public void setProfesor(Profesor ms){
		maestro = ms;
	}

	public Profesor getProfesor(){
		return maestro;
	}

	public void setAlumno(Alumno al){
		if(numAlumnos <= 30){
			alumnos[numAlumnos] = al;
			numAlumnos++;
		}else{
			System.out.println("Un Curso solo puede tener un maximo de 30 Alumnos");
		}
	}

	public Alumno getAlumno(int i){
		if(i >= 0 && i <= 30){
			return alumnos[i];
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

	public void setExperienciaEducativa(ExperienciaEdu eE){
		this.eE = eE;
	}

	public ExperienciaEdu getExperienciaEducativa(){
		return eE;
	}

	public void setNRC(int nrc){
		this.nrc = nrc;
	}

	public int getNRC(){
		return nrc;
	}

	public void setHorario(String hr){
		horario = hr;
	}

	public String getHorario(){
		return horario;
	}

	public String getNombre(){
		return eE.getNombre();
	}

	public int getIndiceAlumno(Alumno a){
		int j = 0;
			for(int i=0;i<=numAlumnos;i++){
			if(alumnos[i].getMatricula() == a.getMatricula()){
				return i;
			}
		}
		return j;

	}

	


}