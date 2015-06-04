
package centrocomercial;
import java.util.ArrayList;

public class TesteCentroComercial {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        double total = 0;

        Restauracao rest1 = new Restauracao("Local1", 33.6, false);
        Restauracao rest2 = new Restauracao("Local2", 40.8, true);
        Comercio com1 = new Comercio("Local3", 50);
        Comercio com2 = new Comercio("Local4", 14);

        a.add(rest1);
        a.add(rest2);
        a.add(com1);
        a.add(com2);

        System.out.println(com2.getValorM2());
        System.out.println(rest1.getEsplanada());
        System.out.println(rest2.getValorPagarTotal());

        for (int i = 0; i < 4; i++) {
            Espaco e = (Espaco) a.get(i);
            total += e.getValorPagarTotal();
        }

        System.out.println(total);
    }
}
