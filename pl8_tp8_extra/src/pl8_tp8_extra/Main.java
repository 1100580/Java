package pl8_tp8_extra;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        int na = numAlunos();

        int numeros[] = new int[na];
        String nomes[] = new String[na];

        lerFicheiroParaArrays(numeros, nomes);

        ordenarArraysPorNumero(numeros, nomes);
        escreverArraysEmFicheiro(numeros, nomes, "AlunosOrdenadosPorNumero.txt");

        ordenarArraysPorNome(numeros, nomes);
        escreverArraysEmFicheiro(numeros, nomes, "AlunosOrdenadosPorNome.txt");
    }

    private static int numAlunos() throws FileNotFoundException {
        Scanner in = new Scanner(new File("Alunos.txt"));
        String linha;
        int c = 0;
        while (in.hasNextLine()) {
            linha = in.nextLine();
            c++;
        }
        in.close();
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

    private static void ordenarArraysPorNumero(int[] numeros, String[] nomes) {
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

    private static void escreverArraysEmFicheiro(int[] numeros, String[] nomes, String nomeFicheiro) throws FileNotFoundException {
        Formatter fout = new Formatter(new File(nomeFicheiro));
        for (int i = 0; i < numeros.length; i++) {
            fout.format("%d/%s%n", numeros[i], nomes[i]);
        }
        fout.close();
    }

    private static void ordenarArraysPorNome(int[] numeros, String[] nomes) {
        int tmpi;
        String tmps;
        for (int i = 0; i < nomes.length - 1; i++) {
            for (int j = i + 1; j < nomes.length; j++) {
                if (nomes[j].compareToIgnoreCase(nomes[i]) < 0) {
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
}
