
package contentoresobjectos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args){
        int n = Integer.parseInt(JOptionPane.showInputDialog("Quantos Objectos irá criar?"));
        ArrayList <Veiculo> v = new ArrayList <Veiculo> (n);
        Veiculo v1 = new Veiculo("Pedro", 1000, 80);
        Veiculo v2 = new Veiculo("Jose", 100, 70);
        Veiculo v3 = new Veiculo("Andre", 900, 60);

        for (int i = 0; i < n; i++) {
            v.add(v1);
            v.add(v2);
            v.add(v3);
            System.out.println(v.get(i).printToString());
        }

        ListaLigada l1 = new ListaLigada();
        l1.inserirInicio(v3);
        l1.inserirInicio(v2);
        l1.inserirInicio(v1);
        System.out.println("\n" + l1.listar());
    }
}