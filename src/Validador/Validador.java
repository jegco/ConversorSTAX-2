/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validador;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;



/**
 *
 * @author j
 */
public class Validador implements IAnalyzable{
    /*atributos del validador, las rutas del archivo a validar y el esquema xsd */
    
    private Source xmlFile;
    private Source schemaFile;

    public Validador() {
        this.schemaFile = new StreamSource(new File("src\\XML\\XML.xsd"));
    }

    @Override
    public String validar(String gxlFile) throws SAXException {
        //busca la ruta del archivo a validar y lo instancia
        this.xmlFile = new StreamSource(new File(gxlFile));
        String resultado = "";
        //instancia el esquema xsd
        SchemaFactory factoriaDeEsquemas = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema esquema = factoriaDeEsquemas.newSchema(schemaFile);
        //instancia el validador de xml
        Validator validador = esquema.newValidator();
        //lista para guardar los posibles errores en la validacion
        ArrayList<Exception> errores=new ArrayList<>();
        
        validador.setErrorHandler(
        new ErrorHandler() {

            @Override
            public void warning(SAXParseException exception) throws SAXException {
                errores.add(exception);
            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                errores.add(exception);
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                errores.add(exception);
            }
        }
        );
        
        try {
            //valida el xml
            validador.validate(xmlFile);
        } catch (IOException ex) {
            Logger.getLogger(Validador.class.getName()).log(Level.SEVERE, null, ex);
        }
        //muestra el resultado dependiendo de la validacion
        if(errores.isEmpty()) resultado="XML valido";
        else resultado="Archivo invalido";
        //devuelve un string con el resultado
        return resultado;
    }
    

}
