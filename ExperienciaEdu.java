public class ExperienciaEdu{
	private String nombre;
	private int creditos;
	private ProgramaEdu ProgramaEducativo;

	public ExperienciaEdu(){

	}

	public ExperienciaEdu(String n, int cr){
		nombre = n;
		creditos = cr;
	}

	public void setNombre(String n){
		nombre = n;
	}

	public String getNombre(){
		return nombre;
	}

	public void setCreditos(int cr){
		creditos = cr;
	}

	public int getCreditos(){
		return creditos;
	}

	public void setProgramaEducativo(ProgramaEdu pe){
		ProgramaEducativo = pe;
	}

	public ProgramaEdu getProgramaEducativo(){
		return ProgramaEducativo;
	}

	public String toString(){
		if(ProgramaEducativo == null){
			return	"Nombre: "+nombre+"\n"+
					"Creditos: "+creditos+"\n"+
					"**No hay Programa Educativo asignado aun**\n";
		}else{
		 return	"             Nombre:  "+nombre+"\n"+
		 		"           Creditos:  "+creditos+"\n"+
		 		" Programa Educativo:  "+ProgramaEducativo.getNombre()+"\n";
		}
	}
}