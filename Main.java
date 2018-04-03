import java.util.Scanner;
import java.io.IOException;
public class Main{
	//--BEGIN--Creando Escannaer
	public static Scanner sc = new Scanner(System.in);
	//--END--Creando Escanner
	public static int numPEs = 0;
	public static ExperienciaEdu[] EEs = new ExperienciaEdu[300];
	public static int numEEs = 0;
	public static ProgramaEdu[] PEs = new ProgramaEdu[100];

	public static int leerEntero(){
		String s = sc.nextLine();
		String e = "0123456789";
		int cont = 0;
		int i = 0;
		for(int j=0;j<s.length();j++){
			for (int k=0;k<e.length();k++){
				if(s.substring(j,j+1)==e.substring(k,k+1)){
					cont++;
				}
			}
		}
		while(cont+1 != s.length()){
			System.out.println("Solo se aceptan numeros\nIntenta nuevamente: ");
			s = sc.nextLine();
			cont = 0;
			for(int j=0;j<s.length();j++){
				for (int k=0;k<e.length();k++){
					if(s.substring(j,j+1)==e.substring(k,k+1)){
					cont++;
					}
				}
			}
			
		}
		i = Integer.parseInt(s);

		return i;
	}

	public static String center(String text, int len){
        if (len <= text.length())
            return text.substring(0, len);
        int before = (len - text.length())/2;
        if (before == 0)
            return String.format("%-" + len + "s", text);
        int rest = len - before;
        return String.format("%" + before + "s%-" + rest + "s", "", text);  
    }

	public static void exito(String mensaje){
		limparPantalla();
		ventanaTop("Sistema de Calificaciones - UV");
		System.out.println("\n");
		System.out.println(center("=================================",80));
		System.out.println("\n");
		System.out.println(center(mensaje,80));
		System.out.println("\n");
		System.out.println(center("=================================",80));
		System.out.println("\n");
		esperarTecla();
	}

	public static void ventanaTop(String s,int i){
		limparPantalla();
		//System.out.printf("\033[31m");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.format("%1s%-69s%-10s","|"," "+s,i+": Salir |\n");
		System.out.println("--------------------------------------------------------------------------------\n");
	}

	public static void ventanaTop(String s){
		limparPantalla();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.format("%1s%-78s%-1s","|"," "+s,"|\n");
		System.out.println("--------------------------------------------------------------------------------\n");
	}

	public static void esperarTecla(){
			System.out.println("\nPresione ENTER para continuar...");
			try{
				System.in.read();
			}  
			catch(Exception e){}
	}
    
	public static void limparPantalla(){
		/*//Limpiar pantalla
			System.out.print("\033[H\033[2J");
			System.out.flush();
		*///limpiar pantalla
		try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            //Runtime.getRuntime().exec("clear");
            System.out.print("\033[H\033[2J");
			System.out.flush();
    	} catch (IOException | InterruptedException ex) {}
	}

	public static void agrEperienciaEducativa(){
		String nombreEE;
		int claveEE, z;
		limparPantalla();
		ventanaTop("Creando Experiencia Educativa");
		System.out.format("%1s%22s"," ","Nombre de la EE:  ");
		nombreEE = sc.nextLine();
		System.out.format("%1s%22s"," ","Creditos de la EE:  ");
		claveEE = sc.nextInt();
		System.out.format("%1s%22s"," ","Programa educativo:  ");
		EEs[numEEs] = new ExperienciaEdu(nombreEE,claveEE);
		sc.nextLine();//fush
		if(numPEs<=0){
			System.out.println("\n\tNo existen programas educativos creados, cree uno y despues agreguelo en el menú modificar.");
		}else{
			System.out.println("\n\nSe encontraron los siguientes programas educativos.\n");
			for(int j=0;j<numPEs;j++){
				System.out.println("\t"+(j+1)+": "+PEs[j].getNombre());
			}
			System.out.printf("\nPrograma Educativo a asociar a esta EE\nEscribe un numero: ");
			z = sc.nextInt();
			while(z<1 || z>numPEs){
				System.out.println("\nEl numero que ingresaste NO corresponde a ningun programa educativo");
				System.out.printf("Intenta nuevamente, escribe el numero: ");
				z = sc.nextInt();
			}
			EEs[numEEs].setProgramaEducativo(PEs[z-1]);
			//Asignano bi-asociacion
			PEs[z-1].setExperienciaEducativa(EEs[numEEs]);

		sc.nextLine();//fush
		
		}
		numEEs++;
		exito("EE agregada correctamente");
	}
	
	public static void modExperienciaEducativa(){
		limparPantalla();
		if(numEEs > 0){
		int opcion = 0;

		ventanaTop("Modificando Experiencia Educativa",0);
		System.out.println("Seleccione la Experiencia Educativa que desea modificar\n");
		System.out.println("\t0: SALIR");
		for(int j=0;j<numEEs;j++){
			System.out.println("\t"+(j+1)+": "+EEs[j].getNombre());
		}
			System.out.printf("\nEscribe un numero: ");
			int z = sc.nextInt();
			while(z<0 || z>numEEs){
				System.out.println("\nÑAAA - El numero que ingresaste no corresponde a ninguna Experiencia Educativa\nIntenta de nuevo, escribe el numero: ");
				z = sc.nextInt();
				sc.nextLine();//fush
			}
			if(z != 0){
			ventanaTop("Modificando Experiencia Educativa");
			System.out.println("Has seleecionado: "+z+": "+EEs[z-1].getNombre()+"\n");
			System.out.println("\t1: Cambiar nombre\n\t2: Cambiar creditos\n\t3: Asociar Programa Educativo\n\t4: Salir");
			System.out.printf("\nEscribe un numero: ");
			opcion = sc.nextInt();
			sc.nextLine();//fush
		switch(opcion){
			case 1:
				ventanaTop("Modificando Experiencia Educativa");
				System.out.println("Actualemente la EE tiene el nombre de: "+EEs[z-1].getNombre()+"\n");
				System.out.printf(" Escriba el nuevo nombre:  ");
				String nnombre = sc.nextLine();
				EEs[z-1].setNombre(nnombre);
				exito("Nombre actualizado correctamente");
				esperarTecla();
			break;

			case 2:
				ventanaTop("Modificando Experiencia Educativa");
				System.out.println("Actualemente la EE tiene: "+EEs[z-1].getCreditos()+" creditos\n");
				System.out.printf(" Escriba el nuevo valor de creditos:  ");
				int ncred = sc.nextInt();
				EEs[z-1].setCreditos(ncred);
				exito("Creditos actualizados correctamente");
				esperarTecla();
			break;

			case 3:
				ventanaTop("Modificando Experiencia Educativa");
				System.out.println("Actualemente la EE esta asociada al PE: "+EEs[z-1].getProgramaEducativo().getNombre()+"\n");
				System.out.println("Seleccione cual quiere asignarle: \n");
				for(int j=0;j<numPEs;j++){
				System.out.println("\t"+(j+1)+": "+PEs[j].getNombre());
				}
				System.out.printf("\nEscriba el numero del PE: ");
				//eliminando asociacion anterior
				
				EEs[z-1].getProgramaEducativo().eliminarEE(EEs[z-1].getNombre());
				
				//^^^^^^eliminando asociacion anterior
				int npe = sc.nextInt();
				EEs[z-1].setProgramaEducativo(PEs[npe-1]);
				exito("PE asociado correctamente");
				//Asignano bi-asociacion
				PEs[npe-1].setExperienciaEducativa(EEs[z-1]);
				esperarTecla();
			break;

			case 4:
				//Regresar
			break;
		}
		}
		}else{
		exito("No hay EE para modificar");
		//esperarTecla();
		}
	}

	public static void eliExperienciaEducativa(){
		limparPantalla();
		ventanaTop("Eliminar Experiencia Educativa");
		System.out.println("Seleccione la Experiencia Educativa que desea eliminar");
		for(int j=0;j<numEEs;j++){
			System.out.println("\t"+(j+1)+": "+EEs[j].getNombre());
		}
			System.out.printf("\nEscribe un numero: ");
			int z = sc.nextInt();

		System.out.println("ATENCION: Eliminar un EE causara que todos los cursos que esten asociados a esta ");
	}

	public static void conExperienciaEducativa(){
		ventanaTop("Consultando Experiencia Educativa");
		int j=0;
		System.out.println("Seleccione la Experiencia Educativa que desea consultar\n");
			System.out.println("\t0: SALIR");
			for(j=0;j<numEEs;j++){
			System.out.println("\t"+(j+1)+": "+EEs[j].getNombre());
			}
			System.out.printf("\nEscribe un numero: ");
			int z = sc.nextInt();
			while(z<0 || z>j){
				System.out.printf("\nEl numero ingresado no es correcto\nEscribe nuevamente el numero: ");
				z = sc.nextInt();
			}
			if(z != 0){
			ventanaTop("Consultando Experiencia Educativa");
			System.out.println("Los datos almacenados son: \n");
			System.out.println(EEs[z-1]);
			//System.out.format("%1s%22s%-57s"," ","Nombre:  ",EEs[z-1].getNombre()+"\n");
			//System.out.format("%1s%22s%-57s"," ","Creditos:  ",EEs[z-1].getCreditos()+"\n");
			//System.out.format("%1s%22s%-57s"," ","Programa Educativo:  ",EEs[z-1].getProgramaEducativo().getNombre()+"\n");
			esperarTecla();
			}
	}

	public static void agrProgramaEducativo(){
		String nombrePE;
		String clavePE;
		ventanaTop("Agregando Programa Educativo");
		System.out.format("%1s%22s"," ","Nombre del PE:  ");
		nombrePE = sc.nextLine();
		System.out.format("%1s%22s"," ","Clave del PE:  ");
		clavePE = sc.nextLine();
		System.out.println("\nNOTA: Para asociar este PE a EE's, debe hacerla desde la \n      opcion Experiencia Educativa en el menu principal");
		esperarTecla();
		PEs[numPEs] = new ProgramaEdu(nombrePE,clavePE);
		sc.nextLine();//fush
		numPEs++;
		exito("PE agregado correctamente");
	}

	public static void modProgramaEducativo(){
		ventanaTop("Modificando Programa Educativo",0);
		System.out.println("Seleccione el Programa Educativo a modificar\n");
		System.out.println("\t0: SALIR");
		for(int j=0;j<numPEs;j++){
				System.out.println("\t"+(j+1)+": "+PEs[j].getNombre());
			}
		System.out.printf("\nEscribe un numero: ");
		int oppe = sc.nextInt();
		while(oppe<0 || oppe>numPEs){
			System.out.printf("\nNumero ingresado es incorrecto\nEscribe nuevamente el numero: ");
			oppe = sc.nextInt();
		}
		if(oppe != 0){
		int opcion = 0;
			ventanaTop("Modificando Programa Educativo",3);
			System.out.println("Has seleccionado el PE: "+PEs[oppe-1].getNombre());
			System.out.println("\nQue desea hacer?");
			System.out.println("\n\t1: Cambiar nombre\n\t2: Cambiar clave\n\t3: Salir");
			System.out.printf("\nEscribe un numero: ");
			opcion = sc.nextInt();
			sc.nextLine();//fush
			switch(opcion){
				case 1:
					ventanaTop("Modificando Programa Educativo");
					System.out.println("Actualemente la PE tiene el nombre de: "+PEs[oppe-1].getNombre()+"\n");
					System.out.printf(" Escriba el nuevo nombre:  ");
					String nnombre = sc.nextLine();
					PEs[oppe-1].setNombre(nnombre);
					exito("Nombre actualizado correctamente");
					esperarTecla();
				break;

				case 2:
					ventanaTop("Modificando Programa Educativo");
					System.out.println("Actualemente la PE tiene la clave: "+PEs[oppe-1].getClave()+"\n");
					System.out.printf(" Escriba la nueva clave:  ");
					String nclave = sc.nextLine();
					PEs[oppe-1].setNombre(nclave);
					exito("Clave actualizada correctamente");
					esperarTecla();
				break;

				case 3:
				//Salir
				break;

			}
		

		}
	}

	public static void eliProgramaEducativo(){
	}

	public static void conProgramaEducativo(){
			ventanaTop("Consultando Programa Educativo", 0);
			System.out.println("Seleccione el Programa Educativo que desea consultar\n");
			System.out.println("\t0: SALIR");
			for(int j=0;j<numPEs;j++){
			System.out.println("\t"+(j+1)+": "+PEs[j].getNombre());
			}
			System.out.printf("\nEscribe un numero: ");
			int z = sc.nextInt();
			if(z!=0){
				ventanaTop("Consultando Programa Educativo");
				System.out.println("\n"+PEs[z-1]);
				PEs[z-1].getTodasEE();
				esperarTecla();
				}
	}

	public static void main(String[] args){

	PEs[0] = new ProgramaEdu("Redes","LRSC010203");
	PEs[1] = new ProgramaEdu("Software","LRSC010204");
	numPEs = 1;
	numPEs++;

	/*
		EE auxiliares
	*/
	EEs[0] = new ExperienciaEdu("Matematicas",8);
	EEs[1] = new ExperienciaEdu("Programacion",10);
	numEEs = 1;
	numEEs++;
	EEs[0].setProgramaEducativo(PEs[0]);
	EEs[1].setProgramaEducativo(PEs[0]);
	PEs[0].setExperienciaEducativa(EEs[0]);
	PEs[0].setExperienciaEducativa(EEs[1]);


	int opcion = 0;
	do{
	limparPantalla();
	ventanaTop("Sistema de Calificaciones - UV",7);	
	System.out.println("Selecciona una de las categorias para realizar alguna accion en ella");
	System.out.println("\n\t1: Experiencia Educativa\n\t2: Programa Educativo\n\t3: Profesor\n\t4: Alumno\n\t5: Curso\n\t6: Calificaciones\n\t7: Salir");
	System.out.printf("\nEscribe un opci\u00f3n: "); 
	opcion = leerEntero(); //sc.nextInt();
	sc.nextLine();//fush
	limparPantalla();
	switch(opcion){
		case 1:
		do{
		ventanaTop("Menu - Experiencia Educativa",5);	
		System.out.println("\t1: Crear nueva\n\t2: Modificar\n\t3: Eliminar\n\t4: Consultar\n\t5: Salir");
		System.out.printf("\nEscribe una opci\u00f3n: ");
		opcion = leerEntero(); //sc.nextInt();
		sc.nextLine();//fush
		switch(opcion){
			case 1:
				agrEperienciaEducativa();
				opcion = 0;
			break;

			case 2:
				modExperienciaEducativa();
				//opcion = 0;
			break;

			case 3:
				eliExperienciaEducativa();
				opcion = 0;
			break;

			case 4:
				conExperienciaEducativa();
			break;

			case 5:
			//Salir
			break;


		}
		}while(opcion != 5);
		break;

		case 2:
		do{
		ventanaTop("Menu - Programa Educativo",5);	
		System.out.println("\t1: Crear nueva\n\t2: Modificar\n\t3: Eliminar\n\t4: Consultar\n\t5: Salir");
		System.out.printf("\nEscribe una opcion: ");
		opcion = sc.nextInt();
		sc.nextLine();//fush
		switch(opcion){
			case 1:
				agrProgramaEducativo();
			break;

			case 2:
				modProgramaEducativo();
			break;

			case 3:
				eliProgramaEducativo();
			break;

			case 4:
				conProgramaEducativo();
			break;

			case 5:
			//Salir
			break;

			}
		}while(opcion != 5);
		break;

		case 3:
		break;

		case 4:
		break;

		case 5:
		break;

		case 6:
		break;

		case 7:
			//Salir
		break;
	}
	}while(opcion != 7);

	// Agregar Experiencia Educativa
		
	// Modificar Experiencia Educativa


	// Eliminar Experiencia  Educativa

	// Agregar Programa Educativo
	// Eliminar Programa Educativo
	// Modificar Programa Educativo

	// Agregar Profesor
	// Eliminar Profesor
	// Modificar Profesor

	// Agregar Alumno
	// Eliminar Alumno
	// Modificar Alumno


	// Agregar Curso
	// Eliminar Curso
	// Modificar Curso

	// Registrar Calificación


	}
}