/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tempo;

/**
 *
 * @author i090674
 */
public class TesteTempo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tempo t1 = new Tempo(22, 58, 58);
        Tempo t2 = new Tempo(14, 6, 9);
        String coiso = t1.toStringhhmmss();
        System.out.println(coiso);
//        t1.mais1segundo();
//        String coiso1 = t1.toStringhhmmss();
//        System.out.println(coiso1);
        int dif = t1.diferencaSegundos(t2);
        System.out.println(dif);
//        Tempo t3 = Tempo.lerTempo();
//        String coiso2 = t3.toStringhhmmss();
//        System.out.println(coiso2);
        int maior = t1.maior(t2);
        if (maior == -1) {
            System.out.println("t1 é menor que t2");
        } else if (maior == 0) {
            System.out.println("os tempos sao iguais");
        } else {
            System.out.println("t1 é maior que t2");
        }
        Tempo t4 = Tempo.diferencaTempo(t1, t2);
        String cenas = t4.toStringhhmmss();
        System.out.println(cenas);
        String ahetal = t1.toStringhhmmssAMPM();
        System.out.println(ahetal);
    }
}
