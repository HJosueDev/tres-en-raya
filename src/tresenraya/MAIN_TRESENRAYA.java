/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

import controlador.Controlador;
import modelo.juego;
import vista.Interfaz3x3;


/**
 *
 * @author ALVA
 */
public class MAIN_TRESENRAYA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //nuevas instancias de clase
        juego modelo = new juego();
        Interfaz3x3 vista = new Interfaz3x3();
        Controlador controlador = new Controlador( vista , modelo );
        controlador.iniciar_vista();
        vista.setVisible(true);
    }
    
}
