package pl_5;

import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PL_5 {

    private static Formatter out = new Formatter(System.out);
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //-----EX 1b)
//        out.format("Numero?");
//        int num = in.nextInt();
//        while (num != 0) {
//            calculaTabuadas(num);
//            out.format("Numero?");
//            num = in.nextInt();
//        }
//        String pal;
//        out.format("String?");
//        pal = in.next();
//        while(!palindromo(pal)){        
//            out.format("String?");
//            pal = in.next();
//        }
//        out.format("String \"" + pal + "\" é palíndromo.");
//        leValores();
//        exer3();
    }

    private static void calculaTabuadas(int num) {
        for (int i = 1; i < 11; i++) {
            out.format(num + " * " + i + " = " + (num * i) + "%n");
        }
    }

    private static boolean palindromo(String pal) {
        boolean resposta = true;
        pal = pal.toLowerCase();
        int tamanho = pal.length();
        for (int i = 0; i < tamanho / 2; i++) {
            if (pal.charAt(i) != pal.charAt(tamanho - 1 - i)) {
                resposta = false;
                break;
            }
        }
        return resposta;
    }

    private static void calculaAngulo(double a, double b, double c, String ang) {

        double ab = Math.acos(((a * a) + (b * b) - (c * c)) / (2 * a * b));
        double ac = Math.acos(((a * a) + (c * c) - (b * b)) / (2 * a * c));
        double bc = Math.acos(((b * b) + (c * c) - (a * a)) / (2 * b * c));

        if (ang.equals("ab")) {
            out.format("ab:" + Math.toDegrees(ab) + "%n");
        } else if (ang.equals("ac")) {
            out.format("ac:" + Math.toDegrees(ac) + "%n");
        } else if (ang.equals("bc")) {
            out.format("bc:" + Math.toDegrees(bc) + "%n");
        }
    }

    private static void leValores() {
        out.format("Lado a?");
        double a = in.nextFloat();
        out.format("Lado b?");
        double b = in.nextFloat();
        out.format("Lado c?");
        double c = in.nextFloat();
        if ((a < b + c) && (b < a + c) && (c < a + b)) {
            out.format("Triangulo Válido %n");
            calculaAngulo(a, b, c, "ab");
            calculaAngulo(a, b, c, "ac");
            calculaAngulo(a, b, c, "bc");
        } else {
            out.format("Triângulo Inválido");
        }
    }

    private static void exer3() {
        String nome = JOptionPane.showInputDialog("Qual a disciplina?");;
        while (!(nome.equals("FIM"))) {
            calculaNotas(nome);
            nome = JOptionPane.showInputDialog("Qual a disciplina?");
        }
    }

    private static void calculaNotas(String nome) {
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Positivas?"));
        int neg = Integer.parseInt(JOptionPane.showInputDialog("Negativas?"));

        System.out.println("Disciplina: " + nome);
        System.out.print("- Positivas: ");
        for (int i = 0; i < pos; i++) {
            System.out.print("*");
        }
        System.out.println("");
        System.out.print("- Negativas: ");
        for (int i = 0; i < neg; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }
}
