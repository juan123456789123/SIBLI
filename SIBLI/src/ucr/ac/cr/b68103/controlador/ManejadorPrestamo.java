/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.b68103.controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import ucr.ac.cr.b68103.modelo.Libro;
import ucr.ac.cr.b68103.modelo.Prestamo;
import ucr.ac.cr.b68103.modelo.RegistroEstudiante;
import ucr.ac.cr.b68103.modelo.RegistroLibro;
import ucr.ac.cr.b68103.modelo.RegistroPrestamo;
import ucr.ac.cr.b68103.vista.FrmPrestamo;
import ucr.ac.cr.b68103.vista.PnlBotonesPrestamo;
import ucr.ac.cr.b68103.vista.PnlDatosPrestamo;
import ucr.ac.cr.b68103.vista.PnlTablaPrestamo;
import java.awt.event.ActionListener;

/**
 *
 * @author Usuario
 */
public class ManejadorPrestamo implements ActionListener {

    PnlDatosPrestamo pnlDatosPrestamo;
    PnlBotonesPrestamo pnlBotonesPrestamo;
    PnlTablaPrestamo pnlTablaPrestamo;
    FrmPrestamo frmPrestamo;
    RegistroPrestamo registroPrestamo;
    Prestamo prestamo;
    RegistroEstudiante registroEstudiante = new RegistroEstudiante();
    RegistroLibro registroLibro = new RegistroLibro();
    int contador = 0;
    int codigo = 00000;
    int indexLibro, index;
    
    ArrayList<Libro> listaLibrosPrestados;

    public ManejadorPrestamo(PnlDatosPrestamo pnlDatosPrestamo, PnlBotonesPrestamo pnlBotonesPrestamo, PnlTablaPrestamo pnlTablaPrestamo, FrmPrestamo frmPrestamo, RegistroPrestamo registroPrestamo) {
        this.pnlDatosPrestamo = pnlDatosPrestamo;
        this.pnlBotonesPrestamo = pnlBotonesPrestamo;
        this.pnlTablaPrestamo = pnlTablaPrestamo;
        this.frmPrestamo = frmPrestamo;
        this.registroPrestamo = registroPrestamo;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase(PnlDatosPrestamo.BTN_BUSCAR)) {
            contador = 0;
            if (this.pnlDatosPrestamo.getTxtCarnet().isEmpty()) {
                FrmPrestamo.getMensaje("Debe digitar el carnet");
            }
            this.index = registroEstudiante.buscarCarnet(pnlDatosPrestamo.getTxtCarnet());
            if (index != -1) {
                this.pnlDatosPrestamo.setLblNombre(registroEstudiante.getEstudiante(index).getNombre());
            }

        }
        if (e.getActionCommand().equalsIgnoreCase(PnlDatosPrestamo.BTN_AGREGAR)) {
            contador++;
            if(pnlDatosPrestamo.getCeboxLibros().equals("Seleccione un libro")){
                FrmPrestamo.getMensaje("Debe seleccionar una opcion");
            }
            this.indexLibro = registroLibro.buscarLibro(pnlDatosPrestamo.getCeboxLibros());
            this.listaLibrosPrestados.add(registroLibro.getLibro(indexLibro));
            PnlTablaPrestamo tabla = new PnlTablaPrestamo();
            tabla.setTabla(Libro.etiquetas, registroPrestamo.getMatrizLibro(contador, indexLibro));
        }
        if (e.getActionCommand().equalsIgnoreCase(PnlDatosPrestamo.BTN_PRESTAMO)) {
            this.codigo++;
            String fechaPrestamo;
            fechaPrestamo = pnlDatosPrestamo.getlblFecha();
            prestamo.setIdPrestamo(codigo);
            prestamo.setStrFecha(fechaPrestamo);
            prestamo.setEstudiante(registroEstudiante.getEstudiante(index));
            prestamo.setLibrosLista(listaLibrosPrestados);
            prestamo.setDtpFechaDevolucion(pnlDatosPrestamo.getSpFechaDevolucion());
            FrmPrestamo.getMensaje(registroPrestamo.agregarPrestamo(prestamo, (pnlDatosPrestamo.getTxtCarnet())));
        }
        if (e.getActionCommand().equalsIgnoreCase(PnlBotonesPrestamo.BTN_CONSULTAR)) {
            if (this.pnlDatosPrestamo.getTxtCarnet().isEmpty()) {
                FrmPrestamo.getMensaje("Debe digitar el carnet");
            }
            if (index != -1) {
                if (registroPrestamo.buscarPrestamo(pnlDatosPrestamo.getTxtCarnet()) != -1) {
                    pnlDatosPrestamo.setLblID(String.valueOf(registroPrestamo.mostrarPrestamo(pnlDatosPrestamo.getTxtCarnet()).getIdPrestamo()));
                    pnlDatosPrestamo.setLblNombre(registroPrestamo.mostrarPrestamo(pnlDatosPrestamo.getTxtCarnet()).getEstudiante().getNombre());
                    pnlDatosPrestamo.setLblFecha(registroPrestamo.mostrarPrestamo(pnlDatosPrestamo.getTxtCarnet()).getStrFecha());
                    pnlDatosPrestamo.setSpFechaDevolucion(registroPrestamo.mostrarPrestamo(pnlDatosPrestamo.getTxtCarnet()).getDtpFechaDevolucion());
                    pnlTablaPrestamo.setTabla(Libro.etiquetas, registroPrestamo.getMatrizLibrosPrestados(registroPrestamo.mostrarPrestamo(pnlDatosPrestamo.getTxtCarnet()).getLibrosLista().size(), registroPrestamo.mostrarPrestamo(pnlDatosPrestamo.getTxtCarnet()).getLibrosLista()));
                } else {
                    FrmPrestamo.getMensaje("Este estudiante no posee prestamos");
                }
            } else {
                FrmPrestamo.getMensaje("El estudiante no se encuentra registrado");
            }

        }
        if (e.getActionCommand().equalsIgnoreCase(PnlBotonesPrestamo.BTN_ELIMINARC)) {
            if(pnlDatosPrestamo.getTxtCarnet().isEmpty()){
                FrmPrestamo.getMensaje("Debe digitar el carnet");
            }
            FrmPrestamo.getMensaje(registroPrestamo.eliminar(pnlDatosPrestamo.getTxtCarnet()));
        }
        if (e.getActionCommand().equalsIgnoreCase(PnlBotonesPrestamo.BTN_SALIR)) {
            this.frmPrestamo.dispose();

        }
    }//fin del action performed

}//fin de la clase
