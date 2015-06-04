/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vencimentos;

/**
 *
 * @author i090674
 */
public class Patrao extends Trabalhador {

    private float salario;

    public Patrao(String nome, float s)  throws ValorNegativo {
        super(nome);
        if(s<0)
            throw new ValorNegativo("Patrão");
        salario = s;
    }

    public float getSalario() { return salario; }

    public float vencimento() {
        return salario;
    }

    public String toString() {
        return "Patrão: " + super.toString();
    }

}

