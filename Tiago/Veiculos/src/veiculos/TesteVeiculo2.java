/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

/**
 *
 * @author i090674
 */
public class TesteVeiculo2 {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        lista.setCabeca(new Veiculo("José", 200, 45));
        lista.setCabeca(new Veiculo("António", 180, 70));
        lista.setCabeca(new Veiculo("Joaquim", 160, 90));
        System.out.println(lista.toString());

    }
}
