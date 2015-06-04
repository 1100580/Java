
package vencimentos;

public class TrabCom extends Trabalhadores{

    private int s;
    private int v;
    private float c;

    public TrabCom(String nome, int salario, int vendas, float comissao) throws ValorNegativo{
        super(nome);
        if (s < 0 || v < 0 || c < 0) {
            throw new ValorNegativo();
        } else{
            s = salario;
            v = vendas;
            c = comissao;
        }
    }

    public float vencimento(){
        return s + (v*c);
    }

    public String toString() {
        return "Trabalhador à Comissão: " + super.toString();
    }

    public float getSalario() {
        return s;
    }

    public float getVendas() {
        return v;
    }

    public float getComissao() {
        return c;
    }

}
