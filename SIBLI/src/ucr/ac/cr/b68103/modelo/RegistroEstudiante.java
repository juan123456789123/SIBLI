/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.b68103.modelo;

import java.util.ArrayList;

/**
 *
 * @author coordinacion
 */
public class RegistroEstudiante {

    private ArrayList<Estudiante> listaEstudiante;
      private LectorEstudiante lectorE;
    private EscritorEstudiante escritorE;
    public RegistroEstudiante() {
        this.listaEstudiante = new ArrayList();
        this.lectorE=new LectorEstudiante("estudiantes.DATA");
        this.listaEstudiante = this.lectorE.reporteEstudiante();
    }

    public int buscarCarnet(String carnet) {
        for (int i = 0; i < this.listaEstudiante.size(); i++) {
            if (this.listaEstudiante.get(i).getCarnet().equals(carnet)) {
                return i;
            }
        }
        return -1;
    }

    public String add(Estudiante estudiante) {
        if (estudiante != null) {
            if (this.buscarCarnet(estudiante.getCarnet()) == -1) {
               
                 this.escritorE=new EscritorEstudiante("estudiantes.DATA");
                this.escritorE.addEstudiantes(estudiante);
                //actualiza el array list
                this.listaEstudiante=this.lectorE.reporteEstudiante();
                this.escritorE.cerrar();
                //this.listaEstudiante.add(estudiante);
                return "Estudiante agregado correctamente!";
            }
            return "El estudiante se encuentra registrado!";
        }
        return "Error al agregar el estudiante!";
    }//fin del método add

    public String delete(String carnet){
        if(this.buscarCarnet(carnet)!=-1){
            this.listaEstudiante.remove(this.buscarCarnet(carnet));
            return "El estudiante se eliminó correctamente!";
        }
        return "Error al eliminar estudiante";
    }
    
   
    
    public Estudiante getEstudiante(int i){
        return this.listaEstudiante.get(i);
    }
    
    public String report(){
        String salida="Lista de estudiantes: \n";
        for (Estudiante estudiante : this.listaEstudiante) {
            salida+=estudiante.toString()+"\n";
        }
        return salida;
    }
    public String [][]datoTabla(){
        String matrizDato[][]=new String[this.listaEstudiante.size()][Estudiante.etiquetas.length];
        for(int f=0;f<matrizDato.length;f++){
            for(int c=0;c<matrizDato[0].length;c++){
                matrizDato[f][c]=listaEstudiante.get(f).getDateTable(c);
            }
        }
        return matrizDato;
    }
      
}//fin de la clase
