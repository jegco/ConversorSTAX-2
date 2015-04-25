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
public interface Analizador {
    Validador getInstance();
    String validar(String xmlFile);
}
