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
public class ControladorGuardar {
    
    public static void action(Conversor tf, MainView mv){
        JFileChooser buscador = new JFileChooser();
        FileNameExtensionFilter filtroArchivo =new FileNameExtensionFilter("XMI","xmi"); //Se declaran los filtros para el archivo
        buscador.setFileFilter(filtroArchivo); //Se agregan los filtros al JFileChooser
        buscador.setFileSelectionMode(JFileChooser.FILES_ONLY); 
        buscador.setSelectedFile(new File("NuevoArchivoXMI.xmi")); //Nombre por defecto del archivo a guardar
        int opcion = buscador.showSaveDialog(mv);
        if(opcion == JFileChooser.APPROVE_OPTION){
            /*Script para guardar el archivo*/
            try{
                File archivo = new File(buscador.getSelectedFile().getAbsolutePath());
                File origen=new File(tf.getOutputFile());
                BufferedWriter bw;
                if(archivo.exists()) {
                    bw = new BufferedWriter(new FileWriter(archivo));
                } else {
                    bw = new BufferedWriter(new FileWriter(archivo));
                }
                bw.close();
                FileInputStream entrada = new FileInputStream(origen); //Hay que manejar la excepcion
                FileOutputStream salida = new FileOutputStream(archivo);
                int c;
                while( (c = entrada.read() ) != -1)
                    salida.write(c);
                
                entrada.close();
                salida.close();
                origen.delete();
            }catch(IOException e) {
                System.err.println("Hubo un error de entrada/salida!!!");
            }
            /*Fin script para guardar el archivo*/
        }
    }
}
