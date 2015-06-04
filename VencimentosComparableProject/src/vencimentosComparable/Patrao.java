package vencimentosComparable;

public class Patrao extends Trabalhador {
    
    private float salario;
    
    public Patrao(String nome, float s) {
        super(nome);
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
