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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
public class LectorEstudiante {
    

    private FileInputStream fio;
    private ObjectInputStream ois;
    private File archivo;
    private boolean verificar = false;

    public LectorEstudiante(String fileName) {
        this.archivo = new File(fileName);

        try {
            //verifica si el arcivo existe o no
            if (archivo.exists()) {
                this.fio = new FileInputStream(archivo);
                this.ois = new ObjectInputStream(fio);
                verificar = true;
            }
            this.fio = new FileInputStream(archivo);
            this.ois = new ObjectInputStream(fio);
        } catch (FileNotFoundException ex) {
            System.err.println("Error al crear el flujo de archivos");
        } catch (IOException IOe) {
            System.err.println("Error al crear el flujo del objeto");
        }
    }//fin del metodo

    public ArrayList<Estudiante> reporteEstudiante() {
        ArrayList<Estudiante> listEstudiante = new ArrayList();
        Object aux = null;
        try {
            //si el archivo existe
            if (verificar) {
                while ((aux = this.ois.readObject()) != null) {
                    //aux es una instancia de estudiante
                    if (aux instanceof Estudiante) {
                        //crea la referencia y lo agrega a la lista estudiante
                        Estudiante estu = (Estudiante) aux;
                        listEstudiante.add(estu);
                    }
                }
               ois.close();
            }
         
        } catch (Exception ex) {

        }
        return listEstudiante;

    }//fin del metodo

}
