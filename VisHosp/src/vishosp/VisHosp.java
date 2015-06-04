package vishosp;

import java.util.Scanner;

public class VisHosp {

    public static Scanner in = new Scanner(System.in);
    public static int nEl = 0;

    public static void main(String[] args) {
        String[] vis = new String[100];

        int op;
        do {
            op = menu();
            String nome;
            switch (op) {
                case 0:
                    inserirVis(vis);
                    break;
                case 1:
                    listarVis(vis);
                    break;
                case 2:
                    encontraPrim(vis);
                    break;
                case 3:
                    actualizaNome(vis);
                    break;
                case 4:
                    eliminaNome(vis);
                    break;
                case 5:
                    listaPrimLetra(vis);
                    break;
                case 6:
                    listaRepetidos(vis);
                    break;
                default:

                    break;
            }
        } while (op != 0);
    }

    private static void inserirVis(String[] vis) {
        System.out.println("Qual o nome?");
        vis[nEl++] = in.next();
    }

    private static void listarVis(String[] vis) {
        for (int i = 0; i < nEl; i++) {
            System.out.println(vis[i]);
        }
    }

    private static void encontraPrim(String[] vis) {
        System.out.println("Qual o nome a procurar?");
        String nome = in.next();
        boolean check = false;
        int i = 0;
        while (!check) {
            if (nome.equals(vis[i])) {
                System.out.println("Indice: " + i);
            }
            i++;
            check = true;
        }
    }

    private static void actualizaNome(String[] vis) {
        System.out.println("Qual o nome a mudar?");
        String nome = in.next();
        boolean encontrou = false;
        for (int i = 0; i < vis.length; i++) {
            if (nome.equals(vis[i])) {
                System.out.println("Qual o novo nome?");
                vis[i] = in.next();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nome não encontrado");
        }
    }

    private static void eliminaNome(String[] vis) {
        System.out.println("Qual o nome a eliminar?");
        String nome = in.next();

        for (int i = 0; i < vis.length; i++) {
            if (nome.equals(vis[i])) {
                for (int j = i; j < vis.length - 1; j++) {
                    vis[j] = vis[j + 1];
                }
            }
        }
    }

    private static void listaPrimLetra(String[] vis) {
        System.out.println("Qual a letra?");
        String letra = in.next();
        for (int i = 0; i < vis.length; i++) {
            if (vis[i].startsWith(letra) && vis[i] != null) {
                System.out.println(vis[i]);
            }
        }
    }

    private static void listaRepetidos(String[] vis) {
        String aTestar = "";
        boolean check = false;
        int pos;
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] != null) {
                aTestar = vis[i];
                pos = -1;
            }
            for (int j = i + 1; j < vis.length; j++) {
                if (vis[i] != null && vis[i].equals(aTestar)) {
                    check = true;
                    pos = i;
                }
            }
            if (check) {
                System.out.println(vis[i]);
            }
            check = false;
        }
    }

    private static int menu() {
        System.out.println("---MENU---");
        System.out.println("O que quer fazer?" + "\n"
                + "1-Inserir visitante" + "\n"
                + "2-Listar visitantes" + "\n"
                + "3-Posição dum dado visitante (o primeiro)" + "\n"
                + "4-Actualizar um nome dado" + "\n"
                + "5-Eliminar um visitante dado" + "\n"
                + "6-Listar os nomes começados por uma dada letra" + "\n"
                + "7-Listar nomes repetidos" + "\n");
        int op = in.nextInt();
        return op;
    }
}
