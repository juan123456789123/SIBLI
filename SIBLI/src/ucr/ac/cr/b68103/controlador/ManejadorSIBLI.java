/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.b68103.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.b68103.modelo.RegistroEstudiante;
import ucr.ac.cr.b68103.modelo.RegistroLibro;
import ucr.ac.cr.b68103.modelo.RegistroPrestamo;
import ucr.ac.cr.b68103.vista.FrmEstudiante;
import ucr.ac.cr.b68103.vista.FrmLibro;
import ucr.ac.cr.b68103.vista.FrmPrestamo;
import ucr.ac.cr.b68103.vista.SIBLI;

/**
 *
 * @author Usuario
 */
public class ManejadorSIBLI implements ActionListener{
  RegistroEstudiante registroEstudiante;
    RegistroLibro registroLibro;
    RegistroPrestamo registroPrestamo;
    FrmEstudiante frmEstudiante;
    FrmLibro frmLibro;
    FrmPrestamo frmPrestamo;
    SIBLI sibli;
    public ManejadorSIBLI(SIBLI sibli) {
        this.sibli =sibli;
        this.registroEstudiante=new RegistroEstudiante();
        this.registroLibro=new RegistroLibro();
        this.registroPrestamo=new RegistroPrestamo();
    }

  
    @Override
    
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Libros")){
            new FrmLibro(this.registroLibro).setVisible(true); 
        }
        if(e.getActionCommand().equalsIgnoreCase("Estudiante")){
            new FrmLibro(this.registroLibro).setVisible(true);
        }
        if(e.getActionCommand().equalsIgnoreCase("Salir")){
            System.exit(0);
            
        }
        if(e.getActionCommand().equalsIgnoreCase("Prestamo")){
            new FrmPrestamo(this.registroPrestamo).setVisible(true);
        }
      }

}