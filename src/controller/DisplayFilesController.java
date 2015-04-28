/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Transformador.Conversor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author j
 */
public class DisplayFilesController {
      private static File archivo = null;
      private static FileReader fr = null;
      private static BufferedReader br = null;
      private static String file="";
 
      public static String actionInputFile(Conversor tf){
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (tf.getInputFile());
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            file=file+linea+"\n";
      }
      catch(IOException e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();
               
            }                  
         }catch (IOException e2){ 
            e2.printStackTrace();
         }
      }
        return file;
      }
      public static String actionOutputFile(Conversor tf){
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (tf.getOutputFile());
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            file=file+linea+"\n";
      }
      catch(IOException e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();
               
            }                  
         }catch (IOException e2){ 
            e2.printStackTrace();
         }
      }
        return file;
      }
}
