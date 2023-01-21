/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.b68103.modelo;

/**
 *
 * @author Usuario
 */
public class Libro {
  private String  signatura;
   private String nombre;
    private int annoPublicacion;
   private String  editorial;
   private String  autor;
   public static String[] etiquetas={"Signatura","Nombre","Autor","Año de publicación","Editorial"};
    public Libro() {
    
   this.signatura="";
   this.nombre="";
   this.annoPublicacion=0;
   this.editorial="";
   this.autor="";
    }

    public Libro(String signatura, String nombre, int annoPublicacion, String editorial, String autor) {
        this.signatura = signatura;
        this.nombre = nombre;
        this.annoPublicacion = annoPublicacion;
        this.editorial = editorial;
        this.autor = autor;
    }

    public String getSignatura() {
        return signatura;
    }

    public void setSignatura(String signatura) {
        this.signatura = signatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnnoPublicacion() {
        return annoPublicacion;
    }

    public void setAnnoPublicacion(int annoPublicacion) {
        this.annoPublicacion = annoPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String datoTabla(int opcion){
       if(opcion==1){
       return  getSignatura();
         
       }
       else if(opcion==2){
          return getNombre();
       }else if(opcion==3){
         return getAutor();   
       }
       else if(opcion==4){
            return String.valueOf(getAnnoPublicacion());
       } 
       else{
           return getAutor();
       }
       
    }
    @Override
    public String toString() {
        return "Libro{" + "signatura=" + signatura + ", nombre=" + nombre + ", annoPublicacion=" + annoPublicacion + ", editorial=" + editorial + ", autor=" + autor + '}';
    }
        
    
}
