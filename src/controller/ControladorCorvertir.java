/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Transformador.Conversor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerException;
import views.MainView;

/**
 *
 * @author Edgar
 */
public class ControladorCorvertir {
    
    public static void accion(Conversor tf, MainView mv){
        try {
            Conversor.getInstancia().convertir();
        } catch (TransformerException ex) {
            Logger.getLogger(ControladorCorvertir.class.getName()).log(Level.SEVERE, null, ex);
        }
//        mv.update(tf);
    }
}
