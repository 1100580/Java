
package impostos;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

    Reformado r1 = new Reformado("Ze", "Rua 1", 300f, 300f);
    TrabContOutr to1 = new TrabContOutr("Quim", "Rua 2", "Empresa 1", 400f, 400f);
    TrabContProp tp1 = new TrabContProp("Quim", "Rua 2", "Profissao 1", 500f, 500f);
    Desempregado d1 = new Desempregado("Quim", "Rua 2", 2, 600f, 600f);

    ArrayList a1 = new ArrayList (4);
            
            a1.add(0, r1);
            a1.add(1, to1);
            a1.add(2, tp1);
            a1.add(3, d1);
            System.out.println(a1.toString());
            for (int i = 0; i < 4; i++) {
                if (a1.get(i) instanceof Desempregado) {
                    System.out.println(a1.toString());
                }
            }
    }
}
