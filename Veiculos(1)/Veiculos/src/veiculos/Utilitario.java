/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package veiculos;

import java.util.ArrayList;

/**
 *
 * @author Miguel Vilaça
 */
public class Utilitario extends Veiculo {
    private int consumo;
    private String tipo;
    public Utilitario(String marca, String matricula, double cilindrada, double preco, int consumo){
     super(marca, matricula, cilindrada, preco);
     setConsumo(consumo);

    }

    /**
     * @return the consumo
     */
    public int getConsumo() {
        return consumo;
    }

    /**
     * @param consumo the consumo to set
     */
    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }
      @Override
      public String toString() {
        return ("Marca: " + getMarca()
                + "\n" + "Matricula: " + getMatricula()
                + "\n" + "Cilindrada: " + getCilindrada()
                + "\n" + "Preço: " + getPreco()
                + "\n" + "Consumo: " + getConsumo());
    }
}
