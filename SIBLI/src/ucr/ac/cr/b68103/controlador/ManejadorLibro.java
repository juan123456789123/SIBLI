/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.b68103.controlador;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.b68103.modelo.RegistroLibro;
import ucr.ac.cr.b68103.vista.PnlBotones;
import ucr.ac.cr.b68103.vista.PnlDatosLibro;
import ucr.ac.cr.b68103.modelo.Libro;
import ucr.ac.cr.b68103.vista.FrmLibro;
import ucr.ac.cr.b68103.vista.PnlLibroBotones;
/**
 *
 * @author Usuario
 */
public class ManejadorLibro implements ActionListener {
    private RegistroLibro registroLibro;
    PnlDatosLibro pnlDatosLibro;
    private PnlLibroBotones pnlLibroBotones;
    Libro libroB;
    FrmLibro frmLibro;
    public ManejadorLibro(PnlDatosLibro pnlDatosLibro1, PnlLibroBotones pnlLibroBotones1, FrmLibro aThis, RegistroLibro registroLibro) {
        this.pnlDatosLibro = pnlDatosLibro;
        this.registroLibro = new RegistroLibro();
    }

  
    
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase(PnlBotones.BTN_AGREGAR)) {
            //Llenar el objeto Estudiante con los datos del panel 
            Libro libro = new Libro();
            libro.setSignatura(this.pnlDatosLibro.getTxtSignatura());
            libro.setNombre(this.pnlDatosLibro.getTxtNombre());
            libro.setAutor(pnlDatosLibro.getTxtAutor());
            libro.setAnnoPublicacion(this.pnlDatosLibro.getSpAnnoDePublicacion());
            libro.setEditorial(pnlDatosLibro.getTxtEditorial());
            
            if (libro.getSignatura().isEmpty()) {
                FrmLibro.getMensaje("Debe agregar la signatura");
            } else if (libro.getAutor().isEmpty()) {
                FrmLibro.getMensaje("Debe agregar el autor");
            } else if (libro.getNombre().isEmpty()) {
                FrmLibro.getMensaje("Debe agregar el nombre");
            } else if (libro.getAnnoPublicacion()==0) {
                FrmLibro.getMensaje("Debe seleccionar el año de publicación");
            } else if (libro.getEditorial().isEmpty()) {
                FrmLibro.getMensaje("Debe agregar la editorial");
            } else {
                FrmLibro.getMensaje(
                        this.registroLibro.add(libro));
                this.pnlDatosLibro.limpiar();
            }
        }
        if (e.getActionCommand().equalsIgnoreCase(PnlBotones.BTN_ELIMINAR)) {
            
            if(this.pnlDatosLibro.getTxtSignatura().isEmpty() ){
                 FrmLibro.getMensaje("Debe ingresar el carnet para proceder a eliminar un estudiante!");
            }else{
                 FrmLibro.getMensaje(registroLibro.Eliminar(this.pnlDatosLibro.getTxtSignatura()));
                
                
            }
        }
        if (e.getActionCommand().equalsIgnoreCase(PnlBotones.BTN_MODIFICAR)) {
            if (this.pnlDatosLibro.getTxtSignatura().isEmpty()) {
                FrmLibro.getMensaje("Debe agregar la Signatura");
            } else if (this.pnlDatosLibro.getTxtNombre().isEmpty()) {
                FrmLibro.getMensaje("Debe agregar el nombre");
            } else if (this.pnlDatosLibro.getSpAnnoDePublicacion()== 0) {
                FrmLibro.getMensaje("Debe seleccionar la  el año de publicación");
            } else if (this.pnlDatosLibro.getTxtEditorial().isEmpty()) {
                FrmLibro.getMensaje("Debe seleccionar un tipo de beca");
            } else {
                libroB.setSignatura(this.pnlDatosLibro.getTxtSignatura());
                libroB.setNombre(pnlDatosLibro.getTxtNombre());
                libroB.setAnnoPublicacion(this.pnlDatosLibro.getSpAnnoDePublicacion());
                libroB.setEditorial(this.pnlDatosLibro.getTxtEditorial());
                FrmLibro.getMensaje("El estudiante se actualizó!");
                 this.pnlDatosLibro.limpiar();
                 
            }
        }
        if (e.getActionCommand().equalsIgnoreCase(PnlBotones.BTN_REPORTE)) {
            FrmLibro.getMensaje(this.registroLibro.reporte());
        }
        if (e.getActionCommand().equalsIgnoreCase(PnlBotones.BTN_SALIR)) {
            this.frmLibro.dispose();
        }
        
        
        if (e.getActionCommand().equalsIgnoreCase(PnlBotones.BTN_BUSCAR)) {
             int index = this.registroLibro.buscarLibro(
                    this.pnlDatosLibro.getTxtSignatura());
            if (index != -1) {
                this.libroB = this.registroLibro.getLibro(index);
                System.err.println(libroB.toString());
                this.pnlDatosLibro.setTxtSignatura(libroB.getSignatura());
                this.pnlDatosLibro.setTxtNombre(libroB.getNombre());
                this.pnlDatosLibro.setSpAnnoDePublicacion(libroB.getAnnoPublicacion());
                this.pnlDatosLibro.setEditorial(libroB.getEditorial());
                
            } else {
                FrmLibro.getMensaje("El estudiante no se encuentra registrado!");
                
            }
        }
        
    }
}
