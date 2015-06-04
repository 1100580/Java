/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vencimentos;

/**
 *
 * @author i090674
 */
public class TrabCom extends Trabalhador {

    private float salario;
    private float vendas;
    private float comissao;

    public TrabCom(String nome, float s, float v, float c) throws ValorNegativo{
        super(nome);
        if(s<0)
            throw new ValorNegativo();
        salario = s;
        if(v<0)
            throw new ValorNegativo();
        vendas = v;
        if(c<0)
            throw new ValorNegativo();
        comissao = c;
    }

    public float getSalario() { return salario; }
    public float getVendas() { return vendas; }
    public float getComissao() { return comissao; }

    public float vencimento() {
        return salario + vendas * comissao;
    }

    public String toString() {
        return "Trab. à Comissão: " + super.toString();
    }

}
