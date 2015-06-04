package pl_7_ex2;

import java.util.Scanner;

public class PL_7_ex2 {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Quantos numeros irá ler?");
        int lin = in.nextInt();
        int vec[] = new int[lin];
        lerVec(vec);
        System.out.println("Quer listar quantos maiores?");
        int m = in.nextInt();
        mostrarM(vec, m);
    }

    private static void lerVec(int[] vec) {
        for (int i = 0; i < vec.length; i++) {
            System.out.println("Insira o valor da pos " + i);
            vec[i] = in.nextInt();
        }
    }

    private static void mostrarM(int[] vec, int m) {
        ordenarVec(vec);
        for (int i = 0; i < m; i++) {
            System.out.println("Pos: " + vec[i]);
        }
    }

    private static void ordenarVec(int[] vec) {
        for (int i = 0; i < vec.length - 1; i++) {
            for (int j = i+1; j < vec.length; j++) {
                if (vec[i] < vec[j]) {
                    int aux = vec[i];
                    vec[i] = vec[j];
                    vec[j] = aux;
                }
            }
        }
    }
}
