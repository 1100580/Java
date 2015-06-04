
package ficha3;

import javax.swing.JOptionPane;


public class CartaoGas {

    private String Nome;
    private int Codigo;
    private int Pontos;

    public CartaoGas(String Nome, int Codigo){
        setNome(Nome);
        setCodigo(Codigo);
        Pontos = 0;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        while (Codigo > 9999 || Codigo < 1000){
            Codigo = Integer.parseInt(JOptionPane.showInputDialog("insira um código entre 1000 e 9999"));
        }
        this.Codigo = Codigo;
    }

    public void AdquirirCombustivel(){
        int Combustivel = Integer.parseInt(JOptionPane.showInputDialog("Quanto combustivel quer abastecer?"));
        if (Combustivel > 100) {
            this.Pontos += Combustivel/20;
            System.out.println("Veiculo abastecido, " + Pontos + " pontos juntados ao seu cartão");
        } else{
            System.out.println("Veiculo abastecido");
        }
    }

    public void LavangensNormais(){
        if (Pontos > 50) {
            int Normais = Pontos/50;
            System.out.println("Pode obter " + Normais + " lavagens normais");
        } else{
            System.out.println("Ainda não tem pontos suficientes para obter Lavangens grátis (Mínimo 50 Pontos)");
        }
    }

    public void LavangensEspeciais(){
        if (Pontos > 60) {
            int Especiais = Pontos/60;
            System.out.println("Pode obter " + Especiais + " lavagens especiais");
        } else{
            System.out.println("Ainda não tem pontos suficientes para obter Lavangens grátis (Mínimo 50 Pontos)");
        }
    }

    public void DeduzirLavagens(){
        int Tipo = Integer.parseInt(JOptionPane.showInputDialog("Que tipo de lavagem quer deduzir? (1 para Normal, 2 para Especial)"));
        if (Tipo == 1) {
            this.Pontos -= 50;
        } else{
            this.Pontos -= 60;
        }
    }
}
