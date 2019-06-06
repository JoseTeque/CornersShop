package m.google.androidcornershop.modelo;


import com.google.gson.annotations.SerializedName;

public class Order{

   private int id;
   private String nombre;
   private int contador;
   private String imagen;

    public Order() {
    }

    public Order(String nombre, String imagen) {
        this.nombre = nombre;
        contador= 0;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}