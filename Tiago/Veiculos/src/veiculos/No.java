/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

/**
 *
 * @author i090674
 */
public class No {

    private Veiculo elemento;
    private No proximo;

    public No(Veiculo v, No n) {
        elemento = v;
        proximo = n;
    }

    public Veiculo getElemento() {
        return elemento;
    }

    public No getProximo() {
        return proximo;
    }

    public void setElemento(Veiculo v) {
        elemento=v;
    }

    public void setProximo(No n) {
        proximo=n;
    }

    public String toString(){
        return elemento.toString();
    }
}
