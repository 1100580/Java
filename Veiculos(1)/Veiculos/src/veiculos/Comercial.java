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
public class Comercial extends Veiculo {

    private int volume;
    private String tipo;

    public Comercial(String marca, String matricula, double cilindrada, double preco, int volume) {
        super(marca, matricula, cilindrada, preco);
        setVolume(volume);
    }

    /**
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }




    public String toString() {
        return ( "Marca: " + getMarca()
                + "\n" + "Matricula: " + getMatricula()
                + "\n" + "Cilindrada: " + getCilindrada()
                + "\n" + "Preço: " + getPreco()
                + "\n" + "Volume: " + getVolume());

    }
}
