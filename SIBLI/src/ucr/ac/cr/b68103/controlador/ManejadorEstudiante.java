/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.b68103.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.b68103.modelo.Estudiante;
import ucr.ac.cr.b68103.modelo.RegistroEstudiante;
import ucr.ac.cr.b68103.vista.FrmEstudiante;
import ucr.ac.cr.b68103.vista.FrmTable;
import ucr.ac.cr.b68103.vista.PnlBotones;
import ucr.ac.cr.b68103.vista.PnlDatosEstudiante;

/**
 *
 * @author coordinacion
 */
public class ManejadorEstudiante implements ActionListener {
    
    private RegistroEstudiante registroEstudiante;
    private PnlDatosEstudiante pnlDataEstudiante;
    private Estudiante estudianteB;
     private PnlBotones pnlBotones;
      private FrmEstudiante frmEstudiante;
      private FrmTable frmTabla;

    
    public ManejadorEstudiante(PnlDatosEstudiante pnlDataEstudiante, PnlBotones pnlBotones,FrmEstudiante frmEstudiante,
            RegistroEstudiante registroEstudiante) {
         this.pnlDataEstudiante = pnlDataEstudiante;
        this.pnlBotones=pnlBotones;
        this.registroEstudiante = registroEstudiante;
        this.frmEstudiante= frmEstudiante;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Estudiante estudiante = new Estudiante();
        if(e.getActionCommand().equals(PnlBotones.BTN_AGREGAR)){
            if(!this.pnlDataEstudiante.getTxtNombre().isEmpty()
                    &&this.pnlDataEstudiante.getTxtCarnet().isEmpty()
                    &&this.pnlDataEstudiante.getTxtCedula().isEmpty()&&
                    this.pnlDataEstudiante.getSpEdad()==1&&
                    pnlDataEstudiante.getCboxTipoBeca()<=0){
                estudiante.setCarnet(this.pnlDataEstudiante.getTxtCarnet());
                estudiante.setCedula(this.pnlDataEstudiante.getTxtCedula());
                estudiante.setNombre(this.pnlDataEstudiante.getTxtNombre());
                estudiante.setEdad(this.pnlDataEstudiante.getSpEdad());
                estudiante.setTipoBeca(this.pnlDataEstudiante.getCboxTipoBeca());
                this.registroEstudiante.add(estudiante);
                frmEstudiante.msj("El estudiante se agregó con exitó");
                pnlDataEstudiante.limpiar();
               
            }else{
            frmEstudiante.msj("Favor complete los datos, para poder guardar al estudiante");
        }
           
           
        }
        if(e.getActionCommand().equals(PnlBotones.BTN_BUSCAR)){
            int encontrar=registroEstudiante.buscarCarnet(pnlDataEstudiante.getTxtCarnet());
            if(encontrar!=-1){
                estudianteB=registroEstudiante.getEstudiante(encontrar);
                pnlDataEstudiante.setTxtNombre(estudianteB.getNombre());
                pnlDataEstudiante.setTxtCedula(estudianteB.getCedula());
                pnlDataEstudiante.setTxtCarnet(estudianteB.getCarnet());
                pnlDataEstudiante.setSpEdad(estudianteB.getEdad());
                pnlDataEstudiante.setCboxTipoBeca(estudianteB.getTipoBeca());
                
            }else{
                frmEstudiante.msj("El Carnet no existe en la lista");
                
            }
        }
        if(e.getActionCommand().equals(PnlBotones.BTN_REPORTE)){
            
//frmEstudiante.msj("Lista de estudiante\n"+registroEstudiante.report());
            frmTabla=new FrmTable();
            frmTabla.setDatoTabla(Estudiante.etiquetas, registroEstudiante.datoTabla());
            frmTabla.setVisible(true);
        }
        if(e.getActionCommand().equals(PnlBotones.BTN_MODIFICAR)){
            if(this.pnlDataEstudiante.getTxtNombre().isEmpty()
                    &&this.pnlDataEstudiante.getTxtCarnet().isEmpty()
                    &&this.pnlDataEstudiante.getTxtCedula().isEmpty()&&
                    this.pnlDataEstudiante.getSpEdad()==1&&
                    pnlDataEstudiante.getCboxTipoBeca()<=0){
                estudianteB.setNombre(pnlDataEstudiante.getTxtNombre());
                estudianteB.setCarnet(pnlDataEstudiante.getTxtCarnet());
                estudianteB.setCedula(pnlDataEstudiante.getTxtCedula());
                estudianteB.setTipoBeca(pnlDataEstudiante.getCboxTipoBeca());
                estudianteB.setEdad(pnlDataEstudiante.getSpEdad());
                frmEstudiante.msj("El estudiante se actualizó");
                pnlDataEstudiante.limpiar();
            }else{
                frmEstudiante.msj("favor complete los datos");
            }
             
        }
        if(e.getActionCommand().equals(PnlBotones.BTN_SALIR)){
            this.frmEstudiante.dispose();
            
        }if(e.getActionCommand().equals(PnlBotones.BTN_ELIMINAR)){
           if(pnlDataEstudiante.getTxtCarnet().isEmpty())
           {
               frmEstudiante.msj("Digiten el carnet En su espacio correspondiente");
           }
            registroEstudiante.delete(pnlDataEstudiante.getTxtCarnet());
            frmEstudiante.msj("Se eliminó correctamente");
        }
    }
    
}
