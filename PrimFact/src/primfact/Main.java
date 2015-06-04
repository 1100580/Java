package primfact;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList primoutil = new ArrayList();
        int i = 0, ndivisores, auxprimo, auxnum;
        Long numeroInput;
        Scanner ler = new Scanner(System.in);
        System.out.println("Qual o número que pretende factorizar?");
        numeroInput = ler.nextLong();
        long ini = numeroInput;
        do {
            int primo = 2;
            boolean flag = false;
            do {
                if (numeroInput % primo != 0) {
                    if (primo == 2) {
                        primo++;
                    } else {
                        primo = primo + 2;
                    }
                } else {
                    auxprimo = primo;
                    auxnum = 1;
                    ndivisores = 0;
                    while (ndivisores != 3 && primo < auxnum) {
                        if (auxprimo % auxnum == 0) {
                            ndivisores++;
                        }
                        auxnum++;
                    }
                    if (ndivisores < 3) {
                        System.out.println(numeroInput + "|" + primo);
                        flag = true;
                        numeroInput = numeroInput / primo;
                        primoutil.add(primo);
                    } else {
                        primo++;
                    }
                }
            } while (flag == false);

        } while (numeroInput != 1);

        System.out.println("1 | Factorização Completa");
        System.out.print(ini + " = ( ");
        do {
            System.out.print(primoutil.get(i).toString());
            i++;
            if (i < primoutil.size()) {
                System.out.print(" * ");
            }
        } while (i < primoutil.size());
        System.out.print(")");
        System.out.println("");
    }
}
