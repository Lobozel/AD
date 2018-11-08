package FicheroSerializado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 
 * @author MiguelÁngel
 *
 */

public class CrearYEscribirFichero {

	public static void main(String[] args) {
		
		File file = new File("C:/AD/departamentos.dat");
		Departamentos dep1 = new Departamentos(1,"Tipo1","Departamento1","Domicilio1","Ciudad1",0001,"Provincia1","Pais1");
		Departamentos dep2 = new Departamentos(2,"Tipo2","Departamento2","Domicilio2","Ciudad2",0002,"Provincia2","Pais2");
		Departamentos dep3 = new Departamentos(3,"Tipo3","Departamento3","Domicilio3","Ciudad3",0003,"Provincia3","Pais3");
		ObjectOutputStream oos;
		
		//Si existe el ficheor primero lo elimino y luego lo creo, para crear uno vacio
		if(!file.exists())
			try {
				file.delete();
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Error al crear el fichero. Compruebe que puede crearse en C:'\\AD'\\.");
			}
		
		
		try {
			//Uso MiObjectOutputStream para serializar el fichero y escribir en él.
			//El parametro true me permite que al escribir de nuevo no sobreescriba lo escrito. 
			oos = new MiObjectOutputStream(new FileOutputStream(file, true));
			
	        oos.writeObject(dep1);
	        oos.writeObject(dep2);
	        oos.writeObject(dep3);
	        
	        System.out.println("Fichero creado correctamente.");
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero. Compruebe si existe en C:'\\AD'\\ o vuelva a ejecutar este programa.");
		} catch (IOException e) {
			System.out.println("Error al tratar la información del archivo."
					+ "\nCompruebe los permisos del archivo o borrelo y vuelva a ejecutar este programa.");			
		}
		

	}

}
