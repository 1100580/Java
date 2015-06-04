/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

/**
 *
 * @author i090674
 */
public class Veiculo {
    private static int num=0;
    private int niv;
    private String nomeProp;
    private int velocidade;
    private int direccao;

    public Veiculo(String n, int v, int d) {
        num++;
        niv=num;
        nomeProp = n;
        velocidade = v;
        direccao = d;
    }

    public Veiculo(String n) {
        num=num++;
        niv=num;
        nomeProp = n;
    }

    public String toString(){
        return (niv+" O veículo de "+nomeProp+" viaja a "+velocidade+"Km/h na direcção "+direccao+"º");
    }
}
