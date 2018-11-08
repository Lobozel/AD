package FicheroSerializado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Miguel¡ngel
 *
 */

public class CrearYEscribirFichero {
	
	public static void main(String[] args) {
		
		File file = new File("C:/AD/departamentos.dat");
		Departamentos[] deps;
		deps = new Departamentos[3];
		deps[0] = new Departamentos(1,"Tipo1","Departamento1","Domicilio1","Ciudad1",0001,"Provincia1","Pais1");
		deps[1] = new Departamentos(2,"Tipo2","Departamento2","Domicilio2","Ciudad2",0002,"Provincia2","Pais2");
		deps[2] = new Departamentos(3,"Tipo3","Departamento3","Domicilio3","Ciudad3",0003,"Provincia3","Pais3");	
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
			
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(deps[0]);
            
            oos = new MiObjectOutputStream(new FileOutputStream(file, true));
            	        
            for(int i=1;i<deps.length;i++){
            	oos.writeObject(deps[i]);
            }
	        
	        System.out.println("Fichero serializable creado correctamente.\n");
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero. Compruebe si existe en C:'\\AD'\\ o vuelva a ejecutar este programa.");
		} catch (IOException e) {
			System.out.println("Error al tratar la informaciÛn del archivo."
					+ "\nCompruebe los permisos del archivo o borrelo y vuelva a ejecutar este programa.");			
		}
		
		LeerFicheroSerializado.LeerFichero(file);
		CrearXMLConDOM.crearXML(deps);
		
	}
	
	

}
