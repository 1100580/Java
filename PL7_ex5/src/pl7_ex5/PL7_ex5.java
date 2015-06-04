package pl7_ex5;

import java.util.Scanner;

public class PL7_ex5 {
    
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n = lerNV();
        String[] nomes = new String[n];
        lerNomes(nomes);
        int[][] vendas = new int[n][12];
        lerVendas(vendas, nomes);
        
        int ma = calculaMontanteAnual(vendas);
        System.out.println("Vendas num ano: " + ma);
        
        melhorMensal(0, vendas, nomes);
        melhorAnual(vendas,nomes);
    }

    private static int lerNV() {
        System.out.println("Quantos vendedores tem a empresa?");
        int m = in.nextInt();
        return m;
    }

    private static void lerNomes(String[] nomes) {
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Qual o nome?");
            nomes[i] = in.next();
        }
    }

    private static void lerVendas(int[][] vendas, String[] nomes) {
        for (int i = 0; i < vendas.length; i++) {
            for (int j = 0; j < vendas[0].length; j++) {
                System.out.println("Vendas do mes " + j + "do vendedor " + nomes[i]);
                vendas[i][j] = in.nextInt();
            }
        }
        System.out.println("");
    }

    private static int calculaMontanteAnual(int[][] vendas) {
        int total = 0;
        for (int i = 0; i < vendas.length; i++) {
            for (int j = 0; j < vendas[0].length; j++) {
                total += vendas[i][j];
            }
        }
        return total;
    }

    private static void melhorMensal(int mes, int[][] vendas, String[] nomes) {
        int melhor = -1;
        int iM = 0;
        for (int i = 0; i < vendas.length; i++) {
            if (vendas[i][mes] > melhor) {
                melhor = vendas[i][mes];
                iM = i;
            }
        }
        System.out.println("O melhor vendedor no mes " + mes + " foi: " + nomes[iM]);
    }

    private static void melhorAnual(int[][] vendas, String[] nomes) {
        int melhor = -1;
        int iM = 0;
        int totalN = 0;
        for (int i = 0; i < vendas.length; i++) {
            for (int j = 0; j < vendas[0].length; j++) {
                totalN += vendas[i][j];
            }
            if (melhor > totalN) {
                totalN = melhor;
                iM = i;
            }
        }
        System.out.println("Melhor vendedor do ano: " + nomes[iM]);
    }
}
