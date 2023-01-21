/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.b68103.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Prestamo {
    RegistroLibro registroLibro= new RegistroLibro();
    private int idPrestamo;
    private String strFecha;
    private Estudiante estudiante;
    private ArrayList<Libro> librosLista;
   private Date dtpFechaDevolucion;
   private boolean ibiEstado;
   

    public Prestamo() {
       this. idPrestamo=0;
       this.dtpFechaDevolucion=null;
       this.estudiante=null;
       this.ibiEstado=false;
       this.strFecha=null;
       this.librosLista=null;
      
    }

    public Prestamo(int idPrestamo, String strFecha, Estudiante estudiante, ArrayList<Libro> librosLista, Date dtpFechaDevolucion) {
        this.idPrestamo = idPrestamo;
        this.strFecha = strFecha;
        this.estudiante = estudiante;
        this.librosLista = librosLista;
        this.dtpFechaDevolucion = dtpFechaDevolucion;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getStrFecha() {
        return strFecha;
    }

    public void setStrFecha(String strFecha) {
        this.strFecha = strFecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public ArrayList<Libro> getLibrosLista() {
        return librosLista;
    }

    public void setLibrosLista(ArrayList<Libro> librosLista) {
        this.librosLista = librosLista;
    }

    public Date getDtpFechaDevolucion() {
        return dtpFechaDevolucion;
    }

    public void setDtpFechaDevolucion(Date dtpFechaDevolucion) {
        this.dtpFechaDevolucion = dtpFechaDevolucion;
    }

    public boolean isIbiEstado() {
        return ibiEstado;
    }

    public void setIbiEstado(boolean ibiEstado) {
        this.ibiEstado = ibiEstado;
    }
    

    @Override
    public String toString() {
        return "Prestamo{" + "idPrestamo=" + idPrestamo + ", strFecha=" + strFecha + ", estudiante=" + estudiante + ", librosLista=" + librosLista + ", dtpFechaDevolucion=" + dtpFechaDevolucion + ", ibiEstado=" + ibiEstado + '}';
    }
    
   
   
}
