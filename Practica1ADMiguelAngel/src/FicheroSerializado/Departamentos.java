package FicheroSerializado;

import java.io.Serializable;

/**
 * 
 * @author Miguel¡ngel
 *
 */

public class Departamentos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id,cp;
	private String tipo, nombre, domicilio, ciudad, provincia, pais;
	
	public Departamentos(Departamentos dep){
		
		this.id=dep.id;
		this.tipo=dep.tipo;
		this.nombre=dep.nombre;
		this.domicilio=dep.domicilio;
		this.ciudad=dep.ciudad;
		this.cp=dep.cp;
		this.provincia=dep.provincia;
		this.pais=dep.pais;
		
	}
	
	public Departamentos(int id, String tipo, String nombre, String domicilio,
			String ciudad, int cp, String provincia, String pais){
		
		this.id=id;
		this.tipo=tipo;
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.ciudad=ciudad;
		this.cp=cp;
		this.provincia=provincia;
		this.pais=pais;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Departamentos: \n ID = " + id + "\n Tipo = " + tipo + "\n Nombre = " + nombre + "\n Domicilio = "
				+ domicilio + "\n Ciudad = " + ciudad +  "\n CP = " + cp +"\n Provincia = " + provincia + "\n Pais = " + pais;
	}
	
	

}
