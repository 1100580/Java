package aplicacaofinal;

import java.io.*;
import java.util.*;

public class AplicacaoAtletas {

    private static final int MAX_PROVAS = 10;
    private static final int MAX_ATLETAS = 100;
    private static Scanner in = new Scanner(System.in);
    private static String[] v;

    public static void main(String[] args) throws Exception {
        String[] atletas = new String[100];
        int[][] provas = new int[100][10];
        int np, op, r, num, nElems = 0;
        String nom = "atletas";
        do {
            op = menu();
            switch (op) {
                case 1:
                    System.out.println("\nQual o nome do ficheiro?");
                    in.nextLine();
                    nom = in.nextLine();
                    nom += ".txt";
                    r = lerInfoBaseFicheiro(nom, atletas, nElems);
                    if (r == -1) {
                        System.out.println("\nNão foi possível introduzir toda a informação");
                        nElems = MAX_ATLETAS;
                        continuar();
                    } else {
                        nElems = r;
                        System.out.printf("%nForam lidos %d atletas%n", nElems);
                        continuar();
                    }
                    break;
                case 2:
                    System.out.println("Qual o número do atleta?");
                    num = in.nextInt();
                    mostrarInfoAtleta(num, atletas, nElems);
                    in.nextLine();
                    continuar();
                    break;
                case 3:
                    System.out.println("Qual o número da prova?");
                    np = in.nextInt();
                    while (np < 1 || np > MAX_PROVAS) {
                        System.out.print("Número inválido!!! Insira novamente o número da prova:");
                        np = in.nextInt();
                    }
                    lerTemposProva(np, atletas, provas, nElems);
                    break;
                case 4:
                    listarInfoMemoria(atletas, provas, nElems);
                    in.nextLine();
                    continuar();
                    break;
                case 5:
                    nElems = removerAtletaMemoria(atletas, provas, nElems);
                    in.nextLine();
                    continuar();
                    break;
                case 6:
                    do {
                        System.out.println("\nOpções de Ordenação:\n\t1 - Números\n\t2 - Médias dos Tempos\nQual pretende?");
                        op = in.nextInt();
                        switch (op) {
                            case 1:
                                ordenarNumeros(atletas, provas, nElems);
                                break;
                            case 2:
                                ordenarMedias(atletas, provas, nElems);
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                    } while (op < 1 || op > 2);
                    break;
                case 7:
                    mostrarMelhorPiorProvasAtleta(atletas, provas, nElems);
                    continuar();
                    break;
                case 8:
                    actualizarTempoProvaAtleta(atletas, provas, nElems);
                    break;
                case 9:
                    System.out.println("Qual o nome do ficheiro para backup?");
                    in.nextLine();
                    nom = in.nextLine();
                    guardaInfoEmFicheiro(nom, atletas, provas, nElems);
                    break;
                case 10:
                    System.out.println("Qual o nome do ficheiro de backup?");
                    in.nextLine();
                    nom = in.nextLine();
                    nElems = recuperaInfoDeFicheiro(nom, atletas, provas);
                    break;
                case 11:
                    int tmp = nElems;
                    nElems = guardarInfoBaseAtletaEmMemoria(atletas, nElems, nom);
                    if (nElems != tmp) {
                        System.out.println("\nInformação guardada com sucesso");
                    }
                    in.nextLine();
                    continuar();
                    break;
                case 12:
                    mediaAtleta(atletas, provas, nElems);
                    in.nextLine();
                    continuar();
                    break;
                case 13:
                    tresMelhoresMedias(atletas, provas, nElems);
                    in.nextLine();
                    continuar();
                    break;
                case 0:
                    System.out.println("\nFIM");
                    break;
                default:
                    System.out.println("\nOPÇÃO INCORRECTA. REPITA");
                    continuar();
                    break;
            }
        } while (op != 0);
    }

    private static int menu() {
        String texto = "\nMENU";
        texto += "\n  1 - Ler ficheiro com informação base de todos os atletas";
        texto += "\n  2 - Mostrar informação de um dado atleta, existente na RAM";
        texto += "\n  3 - Ler ficheiro com o tempo dos atletas numa determinada prova";
        texto += "\n  4 - Mostrar toda a informação existente na RAM";
        texto += "\n  5 - Remover da RAM informação relativa a um atleta que foi desclassificado";
        texto += "\n  6 - Ordenar toda a informação existente em RAM";
        texto += "\n  7 - Mostrar a melhor e a pior prova realizadas por um dado atleta";
        texto += "\n  8 - Actualizar o tempo de uma prova de um determinado atleta";
        texto += "\n  9 - Guardar num ficheiro toda a informação existente em RAM";
        texto += "\n 10 - Recuperar para RAM toda a informação guardada na opção anterior";
        texto += "\n 11 - Guardar em RAM a informação base de um novo atleta";
        texto += "\n 12 - Mostrar o tempo médio que um dado atleta realizou em todas as provas em que participou";
        texto += "\n 13 - Guardar em ficheiro os 3 atletas que obtiveram a melhor média de todas as provas";
        texto += "\n\n  0 - Terminar";
        texto += "\n\nQual a sua opção?";
        System.out.println(texto);
        int op = in.nextInt();
        return op;
    }

    // Um tipo de pausa controlada pelo utilizador
    private static void continuar() {
        System.out.println("\nPrima ENTER para continuar");
        in.nextLine();
    }

    private static int lerInfoBaseFicheiro(String nomeFich, String[] atl, int nEl) throws Exception {
        Scanner fIn = new Scanner(new File(nomeFich));
        String linha;
        while (fIn.hasNextLine() && nEl < MAX_ATLETAS) {
            linha = fIn.nextLine();
            nEl = guardarInfoAtleta(linha, atl, nEl);
        }
        if (fIn.hasNext()) {
            fIn.close();
            return -1;
        } else {
            fIn.close();
            return nEl;
        }
    }

    private static char categoria(int idade) {
        if (idade < 20) {
            return 'A';
        } else if (idade <= 30) {
            return 'B';
        } else {
            return 'C';
        }
    }

    private static int guardarInfoAtleta(String aux, String[] vec, int n) {
        String[] temp = aux.split(";");
        vec[n] = temp[1];
        vec[n] += temp[3];
        vec[n] += categoria(Integer.parseInt(temp[2]));
        temp[0] = temp[0].trim();

        if (temp[0].length() > 20) {
            vec[n] += temp[0].substring(0, 20);
        } else {
            vec[n] += temp[0];
        }
        return ++n;
    }

    private static void mostrarInfoAtleta(int num, String[] atl, int nEl) {
        int pos = procurarAtletaNum(num, atl, nEl);

        if (pos != -1) {
            System.out.println();
            System.out.printf("%-15s: %s%n", "Nome", atl[pos].substring(5, atl[pos].length()));
            System.out.printf("%-15s: %c%n", "Sexo", atl[pos].charAt(0));
            System.out.printf("%-15s: %c%n", "Categoria", atl[pos].charAt(4));
            System.out.printf("%-15s: %3s%n", "Nº de Camisola", atl[pos].substring(1, 4));
        } else {
            System.out.printf("%nO atleta nº %d não existe %n", num);
        }
    }

    private static int procurarAtletaNum(int num, String[] v, int nEl) {
        for (int i = 0; i < nEl; i++) {
            if (getNumCamisola(v[i]) == num) {
                return i;
            }
        }
        return -1;
    }

    private static int getNumCamisola(String atleta) {
        return Integer.parseInt(atleta.substring(1, 4));
    }

    private static void guardaInfoEmFicheiro(String nFich, String[] atl, int[][] prov, int nEl) throws Exception {
        Formatter out = new Formatter(new File(nFich + ".txt"));
        for (int i = 0; i < nEl; i++) {
            out.format("%s", atl[i]);
            for (int j = 0; j< MAX_PROVAS; j++) {
                out.format(";%d", prov[i][j]);
            }
            out.format("%n");
        }
        out.close();
    }

    private static int recupera(String aux, String[] atletas, int[][] provas, int nEl) {
        String[] temp = aux.split(";");
        atletas[nEl] = temp[0];
        for (int i = 0; i< MAX_PROVAS; i++) {
            provas[nEl][i] = Integer.parseInt(temp[i + 1]);
        }
        nEl = nEl + 1;
        return nEl;
    }

    private static int recuperaInfoDeFicheiro(String nFich, String[] atl, int[][] provas) throws Exception {
        Scanner fIn = new Scanner(new File(nFich + ".txt"));
        int nEl = 0;
        String aux;
        while (fIn.hasNext()) {
            aux = fIn.nextLine();
            nEl = recupera(aux, atl, provas, nEl);
        }
        fIn.close();
        return nEl;
    }

    private static void listarInfoMemoria(String[] atl, int[][] provas, int nEl) {
        System.out.printf("%24s%6s%12s%14s", "Nome", "Sexo", "Categoria", "Nº Camisola");
        for (int i = 0; i< MAX_PROVAS; i++) {
            System.out.printf("%8s", "P" + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < nEl; i++) {
            System.out.printf("%24s%6c%12c%14s", atl[i].substring(5, atl[i].length()), atl[i].charAt(0), atl[i].charAt(4), atl[i].substring(1, 4));
            for (int j = 0; j < MAX_PROVAS; j++) {
                System.out.printf("%8d", provas[i][j]);
            }
            System.out.println();
        }
    }

    private static void lerTemposProva(int np, String[] atl, int[][] provas, int nEl) throws Exception {
        for (int i = 0; i < MAX_ATLETAS; i++) {
            provas[i][np] = 0;
        }
        Scanner fIn = new Scanner(new File(np + ".txt"));
        String linha, subLinha[];
        while (fIn.hasNextLine()) {
            linha = fIn.nextLine();
            subLinha = linha.split(";");
            int pos = procurarAtletaNum(Integer.parseInt(subLinha[0]), atl, nEl);
            provas[pos][np - 1] = Integer.parseInt(subLinha[1]);
        }
        fIn.close();
    }

    private static int removerAtletaMemoria(String[] atl, int[][] provas, int nEl) {
        System.out.println("Qual o número do atleta a remover?");
        int num = in.nextInt();
        int pos = procurarAtletaNum(num, atl, nEl);
        if (pos == -1) {
            System.out.printf("Atleta %d não existe na memória%n", num);
            return nEl;
        } else {
            for (int i = pos; i < nEl - 1; i++) {
                atl[i] = atl[i + 1];
                for (int j = 0; j < MAX_PROVAS; j++) {
                    provas[i][j] = provas[i + 1][j];
                }
            }
            System.out.printf("%nO atleta %d foi removido da memória com sucesso%n", num);
            return --nEl;
        }
    }

    private static void mostrarMelhorPiorProvasAtleta(String[] atletas, int[][] provas, int nEl) {
        System.out.println("Qual o número do atleta?");
        int num = in.nextInt();
        int pos = procurarAtletaNum(num, atletas, nEl);
        if (pos == -1) {
            System.out.printf("%nO atleta %d não existe na memória%n", num);
        } else {
            int piorTempo = 0, melhorTempo = 0;
            boolean flag = false;
            for (int col = 0; col < MAX_PROVAS; col++) {
                if (provas[pos][col] > 0) {
                    if (!flag) {
                        melhorTempo = provas[pos][col];
                        piorTempo = provas[pos][col];
                        flag = true;
                    } else if (provas[pos][col] > piorTempo) {
                        piorTempo = provas[pos][col];
                    } else if (provas[pos][col] < melhorTempo) {
                        melhorTempo = provas[pos][col];
                    }
                }
            }
            if (piorTempo == 0) {
                System.out.printf("%nO atleta %d não realizou qualquer prova%n", num);
            } else {
                numerosProvas(pos, provas, piorTempo, "Piores provas:");
                numerosProvas(pos, provas, melhorTempo, "Melhores provas:");
            }
        }
    }

    private static void numerosProvas(int pos, int provas[][], int tempo, String msg) {
        System.out.println(msg);
        for (int col = 0; col < MAX_PROVAS; col++) {
            if (provas[pos][col] == tempo) {
                System.out.println(col + 1);
            }
        }
    }

    private static void actualizarTempoProvaAtleta(String[] atletas, int[][] provas, int nEl) {
        System.out.println("Qual o número do atleta?");
        int num = in.nextInt();
        int pos = procurarAtletaNum(num, atletas, nEl);
        if (pos == -1) {
            System.out.println("O atleta não existe na memória");
            continuar();
        } else {
            System.out.println("Qual o número da prova?");
            int np = in.nextInt();
            while (np < 1 || np > MAX_PROVAS) {
                System.out.print("Número inválido!!! Insira novamente o número da prova: ");
                np = in.nextInt();
            }
            System.out.println("Qual o novo tempo?");
            int t = in.nextInt();
            while (t < 0) {
                System.out.print("\nTempo inválido!!! Insira novamente o novo tempo: ");
                t = in.nextInt();
            }
            provas[pos][np - 1] = t;
        }
    }

    private static void ordenarNumeros(String[] atl, int[][] provas, int nEl) {
        for (int i = 0; i < nEl - 1; i++) {
            for (int j = i + 1; j< nEl; j++) {
                if (getNumCamisola(atl[j]) < getNumCamisola(atl[i])) {
                    troca(atl, provas, i, j);
                }
            }
        }
    }

    private static float[] medias(int[][] provas, int nEl) {
        float medias[] = new float[nEl];
        for (int i = 0; i < nEl; i++) {
            medias[i] = tempoMedioAtleta(provas, i);
        }
        return medias;
    }

    private static void ordenarMedias(String[] atl, int[][] provas, int nEl) {
        float medias[] = medias(provas, nEl);

        for (int i = 0; i < nEl - 1; i++) {
            for (int j = i + 1; j < nEl; j++) {
                if (medias[j] > medias[i]) {
                    troca(atl, provas, i, j);
                }
            }
        }
    }

    private static void troca(String[] atl, int[][] provas, int i, int j) {
        String tmps = atl[i];
        atl[i] = atl[j];
        atl[j] = tmps;
        int tmpi;
        for (int k = 0; k < MAX_PROVAS; k++) {
            tmpi = provas[i][k];
            provas[i][k] = provas[j][k];
            provas[j][k] = tmpi;
        }
    }

    private static float tempoMedioAtleta(int[][] provas, int pos) {
        int s = 0, c = 0;
        for (int col = 0; col < MAX_PROVAS; col++) {
            if (provas[pos][col] > 0) {
                s += provas[pos][col];
                c++;
            }
        }
        if (c != 0) {
            return (float) s / c;
        } else {
            return -1;
        }
    }

    private static int guardarInfoBaseAtletaEmMemoria(String[] atl, int nEl, String nomeFich) throws Exception {
        if (nEl < MAX_ATLETAS) {
            System.out.println("Número (3 algarismos):");
            int numero = in.nextInt();
            while (numero < 99 || numero > 999) {
                System.out.print("Número inválido!!! Insira novamente o número do atleta (3 algarismos): ");
                numero = in.nextInt();
            }
            int pos = procurarAtletaNum(numero, atl, nEl);
            if (pos != -1 || procurarAtletaNumEmFicheiro(numero, nomeFich)) {
                System.out.printf("%nO atleta %d já existe em memória%n", numero);
            } else {
                System.out.print("Nome: ");
                String nome = in.next();
                System.out.print("Sexo (M/F): ");
                String sexo = in.next();
                sexo = sexo.toUpperCase();
                while (sexo.length() != 1 || (sexo.charAt(0) != 'M' && sexo.charAt(0) != 'F')) {
                    System.out.print("Sexo inválido!!! Insira novamente o sexo (M/F): ");
                    sexo = in.next();
                    sexo = sexo.toUpperCase();
                }
                System.out.print("Idade: ");
                int idade = in.nextInt();
                while (idade < 1) {
                    System.out.print("Idade inválida!!! Insira novamente a idade: ");
                    idade = in.nextInt();
                }
                atl[nEl] = sexo + numero + categoria(idade) + nome;
                nEl++;
            }
        }
        return nEl;
    }

    private static boolean procurarAtletaNumEmFicheiro(int num, String nomeFich) throws Exception {
        Scanner fIn = new Scanner(new File(nomeFich));
        String linha, subLinha[];
        while (fIn.hasNextLine()) {
            linha = fIn.nextLine();
            subLinha = linha.split(";");
            if (Integer.parseInt(subLinha[3]) == num) {
                fIn.close();
                return true;
            }
        }
        return false;
    }

    private static void tresMelhoresMedias(String[] atl, int[][] provas, int nEl) throws Exception {
        float[] med = medias(provas, nEl);
        String atletas[] = new String[nEl];
        for (int i = 0; i < nEl; i++) {
            atletas[i] = atl[i];
        }
        int max;
        if (nEl<3)
            max=nEl;
        else
            max=3;
        for (int i = 0; i < max; i++) {
            for (int j = i + 1; j < nEl; j++) {
                if (med[j] < med[i]) {
                    float tmpf = med[j];
                    med[j]=med[i];
                    med[i]=tmpf;
                    String tmps = atletas[j];
                    atletas[j] = atletas[i];
                    atletas[i] = tmps;
                }
            }
        }
        Formatter fOut = new Formatter(new File("melhoresMedias.txt"));
        System.out.println("\nOs números dos atletas com a melhor média");
        for (int i = 0; i < max; i++) {
            if (med[i]!=-1)
                System.out.println(getNumCamisola(atletas[i]));
                fOut.format("%s;%s;%s;%s%n",atletas[i].substring(5),atletas[i].charAt(0),atletas[i].charAt(4),atletas[i].substring(1,4));
        }
        fOut.close();
    }

    private static void mediaAtleta(String[] atl, int[][] provas, int nEl) {
        System.out.println("Qual o número do atleta?");
        int num = in.nextInt();
        int pos = procurarAtletaNum(num, atl, nEl);
        if (pos == -1) {
            System.out.printf("%nO atleta %d não existe na memória%n", num);
        } else {
            float med = tempoMedioAtleta(provas, pos);
            if (med == -1) {
                System.out.printf("%nO atleta %d não realizou qualquer prova!!!%n", num);
            } else {
                System.out.printf("%nO atleta %d realizou a média de %.1f segundos%n", num, med);
            }
        }
    }
}