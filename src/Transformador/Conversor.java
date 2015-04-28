/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transformador;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author j
 */
public class Conversor {
    /*atributos, la ruta del archivo de entrada, la ruta de donde lo vas a guardar, el 
    el esquema(xsl) para hacer la conversion y el singleton para la unica instancia*/
    private String ArchivoEntrada;
    private String archivoSalida;
    private String esquemaXSL;
    private static Conversor instancia=null;

    private Conversor() {
        this.ArchivoEntrada = "";
        this.archivoSalida = "src\\XML\\estructura.xmi";
        esquemaXSL="src\\XML\\estructura.xsl";
    }

    public static Conversor getInstancia() {
        if(instancia==null) instancia=new Conversor();
        return instancia;
    }

    public void setInstancia(Conversor instancia) {
        this.instancia = instancia;
    }
    

    public String getInputFile() {
        return ArchivoEntrada;
    }

    public void setInputFile(String inputFile) {
        this.ArchivoEntrada = inputFile;
    }

    public String getOutputFile() {
        return archivoSalida;
    }

    public void setOutputFile(String outputFile) {
        this.archivoSalida = outputFile;
    }

    public String getSchema() {
        return esquemaXSL;
    }

    public void setSchema(String schema) {
        this.esquemaXSL = schema;
    }
    //metodo conversor puede arrojar excepciones de configuracion del transformador(error en el xsl) o del xml como tal
    public void convertir()throws TransformerConfigurationException,
    TransformerException
    {
        TransformerFactory factoria = TransformerFactory.newInstance();
        //la ruta del xsl
        StreamSource xslStream = new StreamSource(esquemaXSL);
        //instancia el transformador con la instancia del xsl
        Transformer transformador = factoria.newTransformer(xslStream);
        //rutas de los datos de entrada y salida
        StreamSource entrada = new StreamSource(ArchivoEntrada);
        StreamResult salida = new StreamResult(archivoSalida);
        //llamada para transformar el archivo xml a xmi
        transformador.transform(entrada, salida);
        System.out.println("se genero el xmi correctamente y se guardo en la carpeta: " + archivoSalida);
    }
    
}
