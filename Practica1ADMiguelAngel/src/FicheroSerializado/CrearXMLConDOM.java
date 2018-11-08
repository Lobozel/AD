package FicheroSerializado;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CrearXMLConDOM {

	public static void crearXML(Departamentos deps[]){
		DocumentBuilderFactory factory;
		DocumentBuilder builder;
		DOMImplementation implementation;
		Document document;
		Element[] dep, id, tipo, nombre, domicilio, ciudad, cp, provincia, pais;
		TransformerFactory transFactory;
		Transformer transformer;
		File file;
		FileWriter fw;
		Source source;
		Result result;
		
		try {
			//------------------INICIALIZACIÓN
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			implementation = builder.getDOMImplementation();
			document = implementation.createDocument(null, "Departamentos", null);
			
			dep = new Element[deps.length];
			id = new Element[deps.length];
			tipo = new Element[deps.length];
			nombre = new Element[deps.length];
			domicilio = new Element[deps.length];
			ciudad = new Element[deps.length];	
			cp = new Element[deps.length];
			provincia = new Element[deps.length];
			pais = new Element[deps.length];
			
			for (int i=0;i<dep.length;i++)
				dep[i] = document.createElement("Departamento");
			for (int i=0;i<id.length;i++)
				id[i] = document.createElement("ID");
			for (int i=0;i<tipo.length;i++)
				tipo[i] = document.createElement("Tipo");
			for (int i=0;i<nombre.length;i++)
				nombre[i] = document.createElement("Nombre");
			for (int i=0;i<domicilio.length;i++)
				domicilio[i] = document.createElement("Domicilio");
			for (int i=0;i<ciudad.length;i++)
				ciudad[i] = document.createElement("Ciudad");
			for (int i=0;i<cp.length;i++)
				cp[i] = document.createElement("CP");
			for (int i=0;i<provincia.length;i++)
				provincia[i] = document.createElement("Pronvincia");
			for (int i=0;i<pais.length;i++)
				pais[i] = document.createElement("Pais");
			
			transFactory = TransformerFactory.newInstance();
			transformer = transFactory.newTransformer();
			file = new File("C:/AD/departamentosDOM.xml");
			fw = new FileWriter(file);
			source = new DOMSource(document);
			result = new StreamResult(fw);
			
			//--------------------CREACIÓN-DE-ARBOL
			for(int i=0;i<deps.length;i++){
				document.getDocumentElement().appendChild(dep[i]);
				dep[i].appendChild(id[i]);
				id[i].setTextContent(String.valueOf(deps[i].getId()));
				dep[i].appendChild(tipo[i]);
				tipo[i].setTextContent(String.valueOf(deps[i].getTipo()));
				dep[i].appendChild(nombre[i]);
				nombre[i].setTextContent(String.valueOf(deps[i].getNombre()));
				dep[i].appendChild(domicilio[i]);
				domicilio[i].setTextContent(String.valueOf(deps[i].getDomicilio()));
				dep[i].appendChild(ciudad[i]);
				ciudad[i].setTextContent(String.valueOf(deps[i].getCiudad()));
				dep[i].appendChild(cp[i]);
				cp[i].setTextContent(String.valueOf(deps[i].getCp()));
				dep[i].appendChild(provincia[i]);
				provincia[i].setTextContent(String.valueOf(deps[i].getProvincia()));
				dep[i].appendChild(pais[i]);
				pais[i].setTextContent(String.valueOf(deps[i].getPais()));
			}
			
			transformer.transform(source, result);
			
			System.out.println("Fichero XML creado con éxito.");
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	

}
