/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.b68103.modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class RegistroPrestamo {

    RegistroEstudiante registroEstudiante;
    RegistroLibro registroLibro;
    Prestamo prestamo;
    Libro libro;
    private final ArrayList<Prestamo> listaPrestamos;

    public RegistroPrestamo() {
        this.prestamo = new Prestamo();
        this.registroEstudiante = new RegistroEstudiante();
        this.registroLibro = new RegistroLibro();
        this.listaPrestamos = new ArrayList();

    }// fin del constructor;

    public int buscarPrestamo(String carnet) {
        for (int i = 0; i < listaPrestamos.size(); i++) {
            if (listaPrestamos.get(i).getEstudiante().getCarnet().equals(carnet)) {
                return i;
            }

        }
        return -1;
    }

    public String agregarPrestamo(Prestamo prestamo, String carnet) {
        if (prestamo != null) {
            if (buscarPrestamo(carnet) == -1) {
                this.listaPrestamos.add(prestamo);
                return "Libro agregado correctamente";
            }else{
                return "Este estudiante ya realizó su prestamo";
            }

        } else {
            return "Error al agregar";
        }
    }

    public Prestamo mostrarPrestamo(String carnet) {
        if(listaPrestamos!=null){
            if(buscarPrestamo(carnet)!=-1){
                return listaPrestamos.get(buscarPrestamo(carnet));
            }
        }
       return null;
    }
    public String eliminar(String carnet){
        if(listaPrestamos!=null){
            if(buscarPrestamo(carnet)!=-1){
                listaPrestamos.remove(this.listaPrestamos.get(buscarPrestamo(carnet)));
                return "Eliminado correctamente";
            }
          return "El estudiante no posee prestamos";
        }
       return "Error al eliminar";
    }

    /**
     *
     * @param fila
     * @param posicion
     * @return
     */
    //muestra la tabla por cada libro agregado
    public String[][] getMatrizLibro(int fila, int posicion){
        String[][] matrizLibro=new String [fila][this.libro.etiquetas.length];
        for(int i=fila-1;i<matrizLibro.length;i++){
            for(int j=0;j<matrizLibro[0].length;j++){
                matrizLibro[i][j]=registroLibro.getLibro(posicion).datoTabla(j);
            }
        }
       return matrizLibro;
    }
    public String[][] getMatrizLibrosPrestados(int tamanno,ArrayList<Libro>listaLibrosPrestados) {

        String[][] librosPrestados = new String[tamanno][Libro.etiquetas.length];
        for (int f = 0; f < librosPrestados.length; f++) {
            for (int c = 0; c < librosPrestados[0].length; c++) {
                librosPrestados[f][c] = listaLibrosPrestados.get(f).datoTabla(c);
            }
        }
        return librosPrestados;
    }
    

    
}
