package ex3_pl_6;

import java.util.Scanner;

public class Ex3_PL_6 {

    public static void main(String[] args) {
        int n = 0;
        String nomes[] = new String[100];
        Scanner ler = new Scanner(System.in);
        String m = " 1-Ler Nomes\n2-Enigma Nome\n3-Terminar\n\nEscolha uma opção:";
        char op;
        do {
            System.out.println(m);
            op = ler.next().charAt(0);
            switch (op) {
                case '1':
                    n = lerNomes(nomes);
                    break;
                case '2':
                    System.out.println("Nome:");
                    String nome = ler.nextLine();
                    n = enigma(nomes, nome, n);
                    break;
                case '3':
                    break;
                default:
                    System.out.println("Opção inválida!!");
            }
        } while (op != '3');
    }

    private static int lerNomes(String[] vec) {
        String nome = "";
        int cont = 0;
        Scanner ler = new Scanner(System.in);
        do {
            System.out.println("Escreva o nome.");
            nome = ler.next();
            vec[cont++] = nome;
        } while (!"FIM".equals(nome));
        return cont;
    }

    private static void listar(String[] vec, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Pos: " + i + " Conteudo: " + vec[i]);
        }
    }

    private static int enigma(String[] nomes, String nome, int n) {
        int i = 0;
        while (i < n && !nomes[i].equalsIgnoreCase(nome)) {
            i++;
        }
        if (i == n) {
            return n;
        } else {
            for (int j = i; j < n - 1; j++) {
                nomes[j] = nomes[j + 1];
            }
            return --n;
        }
    }
}