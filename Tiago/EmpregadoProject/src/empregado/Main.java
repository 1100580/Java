/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package empregado;

/**
 *
 * @author i090674
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Empregado e1 = Empregado.lerEmpregado();
        System.out.println(e1.toString());
        int horas = e1.horasSemanais();
        System.out.println("Horas de trabalho por semana :" + horas);
        int anos = e1.antiguidade();
        System.out.println("Contratado há " + anos + " anos");
    }
}
