/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conversortagx;

import Transformador.Conversor;
import Validador.Validador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import views.MainView;

/**
 *
 * @author j
 */
public class ConversorTAGX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Conversor conversor=Conversor.getInstancia();
//        
//        try {
//            conversor.convertir("", "");
//        } catch (TransformerException ex) {
//            Logger.getLogger(ConversorTAGX.class.getName()).log(Level.SEVERE, null, ex);
//        }
         new MainView().setVisible(true);
    }
    
}
