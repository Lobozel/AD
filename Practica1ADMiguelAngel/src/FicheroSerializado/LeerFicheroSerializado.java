package FicheroSerializado;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerFicheroSerializado {

	public static void LeerFichero(File file){
		Departamentos dep;
		ObjectInputStream ois;
		
		if (file.exists()){
			try {
				ois = new ObjectInputStream(new FileInputStream(file));
				
				
				while(true){
					dep = (Departamentos) ois.readObject();
					
					System.out.println(dep.toString());
				}
				
			} catch (IOException e) {
				System.out.println("Fin de fichero.\n");		
			} catch (ClassNotFoundException e) {
				System.out.println("No se encuentra la clase Departamentos.java. Comprueba que se encuentre dentro del proyecto.");
			}
		}else{
			System.out.println("Ejecute el programa 'CrearYEscribirFichero.java'.");
		}
		
	}
	
}
