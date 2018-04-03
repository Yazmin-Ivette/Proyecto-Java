public class ProgramaEdu{
	private String nombre;
	private String clave;
	private ExperienciaEdu[] EEs = new ExperienciaEdu[300];
	private int numEE = 0;

	public ProgramaEdu(){

	}

	public ProgramaEdu(String n, String c){
		nombre = n;
		clave = c;
	}

	public void setNombre(String n){
		nombre = n;
	} 

	public String getNombre(){
		return nombre;
	}

	public void setClave(String c){
		clave = c;
	}

	public String getClave(){
		return clave;
	}

	public void eliminarEE(String nm){
		ExperienciaEdu vacia = new ExperienciaEdu("vacia",0);
		for(int j=0;j<numEE;j++){
			if(EEs[j].getNombre() == nm){
				EEs[j] = vacia;
			}
		}
	}

	public void setExperienciaEducativa(ExperienciaEdu ee){
		if(numEE <= 300){
			EEs[numEE] = ee;
			numEE++;
		}else{
			System.out.println("Un programa educativo solo pueden tener un maximo de 300 EE");
		}
	}

	public ExperienciaEdu getExperienciaEducativa(int i){
		if(i >= 0 && i <= 300){
			return EEs[i];
		}else{
			return null;
		}
	}


	public int buscarEE(ExperienciaEdu ee){
		int j = 0;
		for(j=0;j<=numEE;j++){
			if(EEs[j].getNombre() == ee.getNombre()){
				return j;
			}
		}
		return j;
	}

	public void getTodasEE(){
		for(int j=0;j<numEE;j++){
			if(EEs[j].getNombre() != "vacia"){
			System.out.println("\t--> "+EEs[j].getNombre());
			}
		}
	}

	public String toString(){
		if(numEE <= 0){
			return	"   Nombre: "+nombre+"\n"+
					"    Clave: "+clave+"\n"+
					"==>No hay Experiencias Educativas asignadas\n";
		}else{
			int cont = 0;
			for(int j=0;j<numEE;j++){
			if(EEs[j].getNombre() == "vacia"){
				cont++;
				}
			}
			if(numEE == cont){
			return	"   Nombre: "+nombre+"\n"+
					"    Clave: "+clave+"\n"+
					"==>No hay Experiencias Educativas asignadas\n";
		}else{
		 return	"          Nombre: "+nombre+"\n"+
				"           Clave: "+clave+"\n"+
		 		"    EE Asociadas: \n";
		}
		}
	}


}