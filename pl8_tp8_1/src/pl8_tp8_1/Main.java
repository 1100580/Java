package pl8_tp8_1;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        int na = numAlunos();

        int numeros[] = new int[na];
        String nomes[] = new String[na];

        lerFicheiroParaArrays(numeros, nomes);

        ordenarArrays(numeros, nomes);

        escreverArraysEmFicheiro(numeros, nomes);

    }

    private static int numAlunos() throws FileNotFoundException {
        Scanner fin = new Scanner(new File("Alunos.txt"));
        int c = 0;
        while (fin.hasNextLine()) {
            fin.nextLine();
            c++;
        }
        fin.close();
        return c;
    }

    private static void lerFicheiroParaArrays(int[] numeros, String[] nomes) throws FileNotFoundException {
        Scanner fin = new Scanner(new File("Alunos.txt"));
        String linha, subLinhas[];
        int i = 0;
        while (fin.hasNextLine()) {
            linha = fin.nextLine();
            subLinhas = linha.split("/");
            numeros[i] = Integer.parseInt(subLinhas[0]);
            nomes[i] = subLinhas[1];
            i++;
        }
        fin.close();
    }

    private static void ordenarArrays(int[] numeros, String[] nomes) {
        int tmpi;
        String tmps;
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[j] < numeros[i]) {
                    tmpi = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = tmpi;
                    tmps = nomes[i];
                    nomes[i] = nomes[j];
                    nomes[j] = tmps;
                }
            }
        }
    }

    private static void escreverArraysEmFicheiro(int[] numeros, String[] nomes) throws FileNotFoundException {
        Formatter fout = new Formatter(new File("AlunosOrdenados.txt"));
        for (int i = 0; i < numeros.length; i++) {
            fout.format("%d/%s%n", numeros[i], nomes[i]);
            //d representa inteiros s string e n muda de linha
        }
        fout.close();
    }

}