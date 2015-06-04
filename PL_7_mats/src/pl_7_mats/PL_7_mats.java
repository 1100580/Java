package pl_7_mats;

import java.util.Scanner;

public class PL_7_mats {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int lin = lerDim("linhas");
        int col = lerDim("colunas");
        int mat[][] = new int[lin][col];
        lerMat(mat);
        somaL(mat);
        imprime(mat);
    }

    private static int lerDim(String s) {
        System.out.println("Insira número de " + s + ": ");
        int val = in.nextInt();
        return val;
    }

    private static void lerMat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.println("Linha " + i + ", Coluna " + j + ". Valor?");
                mat[i][j] = in.nextInt();
            }
        }
    }

    private static void somaL(int[][] mat) {
        int[] soma = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                soma[i] += mat[i][j];
            }
        }
        ordena(mat, soma);
    }

    private static void ordena(int[][] mat, int[] soma) {
        for (int i = 0; i < soma.length-1; i++) {
            int maior = i;
            for (int j = i+1; j < soma.length; j++) {
                if (soma[j] > soma[maior]) {
                    maior = j;
                }
            }
            if (maior != i) {
                int tmp = soma[i];
                soma[maior] = tmp;
                trocaLinhas(mat, i, maior);
            }
        }
    }

    private static void trocaLinhas(int[][] mat, int l1, int l2) {
        for (int j = 0; j < mat[0].length; j++) {
            int tmp = mat[l1][j];
            mat[l1][j] = mat[l2][j];
            mat[l2][j] = tmp;
        }
    }

    private static void imprime(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print("[" + i + "][" + j + "]=" + mat[i][j] + "   ");
            }
            System.out.println("");
        }
    }
}