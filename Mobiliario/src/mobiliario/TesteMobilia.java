
package mobiliario;

import java.util.ArrayList;

public class TesteMobilia {

    public static void main(String[] args) {
        ArrayList empresa = new ArrayList();

        Cadeira cad1 = new Cadeira(10, 1.3, true);
        Cadeira cad2 = new Cadeira(5, 0.9, false);
        Mesa m1 = new Mesa(20, 5.3, 6);
        Mesa m2 = new Mesa(25, 6.7, 8);

        empresa.add(cad1);
        empresa.add(cad2);
        empresa.add(m1);
        empresa.add(m2);

        //imprime todos
            System.out.println(m2.getCapacidade());
            System.out.println((cad1.getEncosto()) ? "A cadeira tem encosto." : "A cadeira não tem encosto.");
            System.out.println("");

            cad1.aumentaPreco(10);
            cad2.aumentaPreco(10);
            m1.aumentaPreco(10);
            m2.aumentaPreco(10);
            
            for (int i = 0; i < 4; i++) {
                Mobilia m = (Mobilia) empresa.get(i);
                System.out.println(m.toString());
            }
    }
}
