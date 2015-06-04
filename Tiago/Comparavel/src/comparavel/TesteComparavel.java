/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparavel;

/**
 *
 * @author i090674
 */
public class TesteComparavel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Comparavel vec[] = new Comparavel[10];
        vec[0] = new Carro("20-TF-36", "Renault 5");
        vec[1] = new Carro("JH-01-73", "Fiat Punto GT");
        vec[2] = new Carro("09-35-AA", "Opel Corsa");
        vec[3]= new Livro("As memórias da minha terra","Gervásio Palha");
        vec[4]= new Carro("O tone biclas","Tone Biclas");
        vec[5]= new Carro("Sempre que te via gostava de ti","Anacleto Barbosa");
        boolean b = vec[0].igual(new Carro("20-TF-36", "Coiso"));
        if(b==true)
        System.out.println("igual");
        else
            System.out.println("diferente");
    }
}
