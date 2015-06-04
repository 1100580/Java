package vencimentosGUI;

public class TrabCom extends Trabalhador {
    
    private float salario;
    private float vendas;
    private float comissao;
    
    public TrabCom(String nome, float s, float v, float c) {
        super(nome);
        salario = s;
        vendas = v;
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
