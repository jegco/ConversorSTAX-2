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
public class UploadFileController {
   
    
    public static void action(MainView mv){
        JFileChooser browser = new JFileChooser();
        FileNameExtensionFilter filtroFile =new FileNameExtensionFilter("XML","xml"); //Se declaran los filtros para el archivo
        browser.setFileFilter(filtroFile); //Se agregan los filtros al JFileChooser
        int option = browser.showOpenDialog(mv);
        if(option == JFileChooser.APPROVE_OPTION){
            String xmlfile=browser.getSelectedFile().getAbsolutePath();
            Conversor.getInstancia().setInputFile(xmlfile);
        }
        
        
    }
    
    
}
