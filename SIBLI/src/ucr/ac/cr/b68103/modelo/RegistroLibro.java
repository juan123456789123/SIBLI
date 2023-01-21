/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.b68103.modelo;
import java.util.ArrayList;
/**ArrayList
 *
 * @author Usuario
 */
public class RegistroLibro {
    private ArrayList<Libro>listaLibro;
    private int contador=0;
    public RegistroLibro()
    {
    this.listaLibro=new ArrayList();
    }
    
   public int buscarLibro(String signatura)
   {
       for(int i=0;i<this.listaLibro.size();i++)
       {
       if(this.listaLibro.get(i).getSignatura().equals(signatura))
       {
       return i;
       }
       
       
       
       }
   return -1;
   }
   
   public String add(Libro libro)
   {
       if(libro!=null)
       {
       if(this.buscarLibro(libro.getSignatura())==-1)
       {
          this.listaLibro.add(libro);
          return" Se agregó correctamente";
       }
       else
       {
           return "El libro ya existe";
       }
       }
       
   
   return"Error al agregar el libro";
   }
   
   public String Eliminar(String editorial)
   {
     if(this.buscarLibro(editorial)!=-1) 
     {
         this.listaLibro.remove(this.buscarLibro(editorial));
                 return"Se elimino correctamente";
     }
     
   return "error al eliminar";
   }
   
   public Libro getLibro(int i)
   {
   return this.listaLibro.get(i);
   }
   
   public String reporte()
   {
   String imprimir="";
   for(Libro libro:this.listaLibro)
   {
       imprimir+=libro.toString()+"\n";
       
       }
   return imprimir;
          }
  public int contador(){
       for(Libro libro:this.listaLibro)
   {
      contador++;
       
       }
       return contador;
   }
    
}
