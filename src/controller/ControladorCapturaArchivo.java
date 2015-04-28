/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Transformador.Conversor;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import views.MainView;

/**
 *
 * @author Edgar
 */
public class ControladorCapturaArchivo {
   
    
    public static void accion(MainView mv){
        JFileChooser buscador = new JFileChooser();
        FileNameExtensionFilter filtroArchivo =new FileNameExtensionFilter("XML","xml"); //Se declaran los filtros para el archivo
        buscador.setFileFilter(filtroArchivo); //Se agregan los filtros al JFileChooser
        int opcion = buscador.showOpenDialog(mv);
        if(opcion == JFileChooser.APPROVE_OPTION){
            String xmlfile=buscador.getSelectedFile().getAbsolutePath();
            Conversor.getInstancia().setInputFile(xmlfile);
        }
        
        
    }
    
    
}
