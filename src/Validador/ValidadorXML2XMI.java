/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Validador;

/**
 *
 * @author j
 */
public class ValidadorXML2XMI {
    private static Validador validador;
    
    private ValidadorXML2XMI(){}
    
    private static void createInstance(){
        if(validador==null)
       validador=new Validador();
    }
    
    public static Validador getInstance(){
        createInstance();
        return validador;
    }
}
