
package equipamento;

import java.util.ArrayList;


public class Teste {

    public static void main(String[] args) {
        ArrayList lst = new ArrayList();

        lst.add(new Computador("Asus", "G60", 1000, "Intel i9"));
        lst.add(new Impressora("Brother", "DPC-110", 20, 1));
        lst.add(new Modem("Pirelli", "TCP330", 37, 1));

        for (int i = 0; i < 3; i++) {
            Equipamento e = (Equipamento) lst.get(i);
            System.out.println(e.toString());
        }
    }
    
}
