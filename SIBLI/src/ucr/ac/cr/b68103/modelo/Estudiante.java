/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.b68103.modelo;

import java.io.Serializable;

/**
 *
 * @author coordinacion
 */
public class Estudiante extends Persona implements Serializable{
    private String carnet;
    private int tipoBeca;
   public static String etiquetas[]={"carnet","nombre","cedula","edad","tipo Beca"};
    public String getDatoTable(int opt){
        if(opt==0){
            return carnet;
        }
        if(opt==1){
            return super.getNombre();
        }if(opt==2){
            return super.getCedula();
        }if(opt==3){
            return String.valueOf(super.getEdad());
        }
        else{
            return String.valueOf(tipoBeca);
        }
        
    }
    
    public Estudiante() {
        super();
        this.carnet="B0000";
        this.tipoBeca=0;
    }

    public Estudiante(String carnet, int tipoBeca) {
        super();
        this.carnet = carnet;
        this.tipoBeca = tipoBeca;
    }

    public Estudiante(String carnet, int tipoBeca, String cedula, String nombre, int edad) {
        super(cedula, nombre, edad);
        this.carnet = carnet;
        this.tipoBeca = tipoBeca;
    }
 public String getDateTable(int opt) {
        if (opt == 0) {
            return carnet;
        } else if (opt == 1) {
            return super.getCedula();
        } else if (opt == 2) {
            return super.getNombre();
        } else if (opt == 3) {
            return String.valueOf(super.getEdad());
        } else {
            return String.valueOf(this.tipoBeca);
        }
    }
 
    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getTipoBeca() {
        return tipoBeca;
    }

    public void setTipoBeca(int tipoBeca) {
        this.tipoBeca = tipoBeca;
    }

    @Override
    public String toString() {
        return super.toString()+"\tEstudiante{" + "carnet=" + carnet + ", tipoBeca=" + tipoBeca + '}';
    }
    
    
    
    
}
