package m.google.androidcornershop.modelo;

import com.google.gson.annotations.SerializedName;


public class Modelo{

	@SerializedName("imagen")
	private String imagen;

	@SerializedName("id")
	private int id;

	@SerializedName("nombre")
	private String nombre;

	public Modelo(String imagen, String nombre) {
		this.imagen = imagen;
		this.nombre = nombre;
	}

	public Modelo() {
	}

	public void setImagen(String imagen){
		this.imagen = imagen;
	}

	public String getImagen(){
		return imagen;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;
	}

	@Override
	public String toString() {
		return "Modelo{" +
				"imagen='" + imagen + '\'' +
				", id='" + id + '\'' +
				", nombre='" + nombre + '\'' +
				'}';
	}
}