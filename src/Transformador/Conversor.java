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
    private String inputFile;
    private String outputFile;
    private String schema;
    private static Conversor instancia=null;

    private Conversor() {
        this.inputFile = "";
        this.outputFile = "";
        
    }

    public static Conversor getInstancia() {
        if(instancia==null) instancia=new Conversor();
        return instancia;
    }

    public void setInstancia(Conversor instancia) {
        this.instancia = instancia;
    }
    

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
    
    public void convertir(String inputFile, String outputFile)throws TransformerConfigurationException,
    TransformerException
    {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream = new StreamSource("src\\XML\\estructura.xsl");
        Transformer transformer = factory.newTransformer(xslStream);
        StreamSource in = new StreamSource("src\\XML\\estructura.xml");
        StreamResult out = new StreamResult("src\\XML\\estructura.xmi");
        transformer.transform(in, out);
        System.out.println("se genero el xmi correctamente y se guardo en la carpeta: " + outputFile);
    }
    
}
