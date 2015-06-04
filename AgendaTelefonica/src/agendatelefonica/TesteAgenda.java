
package agendatelefonica;

import java.util.ArrayList;

public class TesteAgenda {
    public static void main(String[] args) {
    ArrayList a = new ArrayList();

    a.add(new Pessoa("Pessoa1", 222222222, 919999999));
    a.add(new Pessoa("Pessoa2", 222222223, 919999998));
    a.add(new Empresa("Empresa1", 222222224, 220000000, "pessoa3@hotmail.com"));
    a.add(new Empresa("Empresa2", 0, 220000000, ""));

    //imprime todos
        for (int i = 0; i < 4; i++) {
            Entrada e = (Entrada) a.get(i);
            System.out.println(e.toString());
        }
    
    //imprime com fax
        for (int i = 0; i < 4; i++) {
            if (a.get(i) instanceof Empresa) {
                Empresa e = (Empresa) a.get(i);
                if (e.getEmail() != null) {
                    System.out.println(e.toString());
                }
            }
        }

    }
}
