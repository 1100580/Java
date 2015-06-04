package calcsol;

import java.util.Formatter;
import java.util.Scanner;

public class CalcSol {

    public static Scanner in = new Scanner(System.in);
    public static Formatter out = new Formatter(System.out);

    public static void main(String[] args) {
        out.format("Qual o sólido?");
        String solido = in.next();
        while (!(solido.equals("FIM"))) {
            calculaSolido(solido);
            out.format("Qual o sólido?");
            solido = in.next();
        }
    }

    private static void calculaSolido(String solido) {
        out.format("Raio?");
        int raio = in.nextInt();
        if (solido.equals("cilindro")) {
            System.out.println("Res: " + 4/3*Math.PI*(raio*raio*raio));
        }else if(solido.equals("cone")){
            out.format("Altura?");
            int alt = in.nextInt();
            System.out.println("Res: " + Math.PI*(raio*raio)*alt);
        }else if(solido.equals("esfera")){
            out.format("Altura?");
            int alt = in.nextInt();
            System.out.println("Res: " + 1/3*Math.PI*(raio*raio)*alt);
        }else{
            System.out.println("Inválido");
        }
    }
}
