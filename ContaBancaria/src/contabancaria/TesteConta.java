/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contabancaria;

import javax.swing.JOptionPane;

/**
 *
 * @author Paulo
 */
public class TesteConta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Conta c1 = new Conta("Pedro", 100, new Data(2011,3,9));
//        Conta c2 = new Conta("Ana", new Data(2011,3,9));
//
//        c1.deposito(25);
//        c1.levantamento(50);
//
//        System.out.println(c2.saldoSuperior(c1));
//        System.out.println(c2.diferencaSaldos(c1));
//
//        System.out.println(Conta.getTotalContas());

//        System.out.println(c1.getDataUltMov());
//        System.out.println(c1.getHoraUltMov());

        int n = Integer.parseInt(JOptionPane.showInputDialog("Número de contas: "));
        Conta arrayContas[] = new Conta[n];
        for (int i = 0; i < n; i++)
            arrayContas[i] = Conta.lerConta();
        Data dataRecente = new Data();
        for (int i = 0; i < n; i++) {
            System.out.println(arrayContas[i]);
            if (arrayContas[i].getDataAbertura().maior(dataRecente))
                dataRecente = arrayContas[i].getDataAbertura();
        }
        System.out.println("Data de abertura de conta mais recente: " + dataRecente);
    }
}