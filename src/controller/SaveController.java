/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import Transformador.Conversor;
import views.MainView;
/**
 *
 * @author Edgar
 */
public class SaveController {
    
    public static void action(Conversor tf, MainView mv){
        JFileChooser browser = new JFileChooser();
        FileNameExtensionFilter filtroFile =new FileNameExtensionFilter("XMI","xmi"); //Se declaran los filtros para el archivo
        browser.setFileFilter(filtroFile); //Se agregan los filtros al JFileChooser
        browser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
        browser.setSelectedFile(new File("NuevoArchivoXMI.xmi")); //Nombre por defecto del archivo a guardar
        int option = browser.showSaveDialog(mv);
        if(option == JFileChooser.APPROVE_OPTION){
            /*Script para guardar el archivo*/
            try{
                File archivo = new File(browser.getSelectedFile().getAbsolutePath());
                File origen=new File(tf.getOutputFile());
                BufferedWriter bw;
                if(archivo.exists()) {
                    bw = new BufferedWriter(new FileWriter(archivo));
                } else {
                    bw = new BufferedWriter(new FileWriter(archivo));
                }
                bw.close();
                FileInputStream in = new FileInputStream(origen); //Hay que manejar la excepcion
                FileOutputStream out = new FileOutputStream(archivo);
                int c;
                while( (c = in.read() ) != -1)
                    out.write(c);
                
                in.close();
                out.close();
                origen.delete();
            }catch(IOException e) {
                System.err.println("Hubo un error de entrada/salida!!!");
            }
            /*Fin script para guardar el archivo*/
        }
    }
}
