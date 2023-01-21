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
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EscritorEstudiante {
     //ruta(carretera)
    private FileOutputStream fos;
    //bus que lleva el archivo
    private ObjectOutputStream oos;
    private MyStream myFlujo;
    //archivo
    private File archivo;
    private boolean cabeceraInicio = false;

    public EscritorEstudiante(String fileName) {
        try {
            this.archivo = new File(fileName);
            //si el archivo exixte usa miFlujo no lo crea
            if (this.archivo.exists()) {
                //true el archivo exixte
                this.fos = new FileOutputStream(archivo, true);
                this.myFlujo = new MyStream(fos);
                //si no exixte lo crea
            } else {
                //tira error si falta la exepcion, lo ideal para un trycah es encerarlo todo
                //false el archivo no existe
                this.fos = new FileOutputStream(this.archivo, false);
                this.oos = new ObjectOutputStream(fos);
                this.cabeceraInicio = true;
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Error al crear el flujo de archivo");
        } catch (IOException ioe) {
            System.err.println("Error al crear el flujo de objetos");
        }
        
        
    }//fin del metodo
    
    public boolean addEstudiantes(Estudiante estudiante) {
        boolean exito = false;
        try {
            //si no exixte
            if (cabeceraInicio) {
                //agrega el objeto USA OOS
                oos.writeUnshared(estudiante);
                //ACTUALIZA
                this.oos.reset();
                exito = true;
            } else {
                //si existe no lo crea y usa muyFlujo
                this.myFlujo.writeUnshared(estudiante);
                //actualiza
                this.myFlujo.reset();
                exito = true;
            }
        } catch (IOException ioe) {
            System.err.println("Error al agregar el estudiante al archivo");
        }
        return exito;
    }//fin del método
    
    public void cerrar(){
        try{
            if(cabeceraInicio){
                this.oos.close();
                this.fos.close();
            }else{
                this.myFlujo.close();
                this.fos.close();
            }
        }catch(IOException ioe){
            System.err.println("Error al agregar flujo");
        }
    }//fin del metodo
    
}
