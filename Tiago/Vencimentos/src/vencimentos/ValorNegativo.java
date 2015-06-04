/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vencimentos;

/**
 *
 * @author i090674
 */
public class ValorNegativo extends Exception {

    public ValorNegativo() {
        super("Atenção: Valor Negativo.");
    }

    public ValorNegativo(String s) {
        super("Atenção: Valor Negativo na criação de um novo " + s + ".");
    }
}

