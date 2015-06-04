
package vencimentos;

public class Patrao extends Trabalhadores{
    
    private int salario;
    
    public Patrao(String nome, int salario) throws ValorNegativo{
        super(nome);
        if (salario < 0) {
            throw new ValorNegativo();
        } else{
            setSalario(salario);
        }
    }

    public float vencimento(){
        return salario;
    }

    public String toString() {
        return "Patrão: " + super.toString();
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    
}
