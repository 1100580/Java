package javaapplication23;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int vec[] = new int[20];
        int op = 0;
        do {
            System.out.println("---------MENU---------");
            System.out.println("\n1 - Inserir");
            System.out.println("2 - Remover");
            System.out.println("3 - Procurar");
            System.out.println("4 - Actualizar");
            System.out.println("5 - Listar");
            System.out.println("\nEscolha uma opção: ");
            op = ler.nextInt();
            switch (op) {
                case 1: {
                    Inserir(vec);
                    break;
                }
                case 2: {
                    Remover(vec);
                    break;
                }
                case 3: {
                    Procurar(vec);
                    break;
                }
                case 4: {
                    Actualizar(vec);
                    break;
                }
                case 5: {
                    Listar(vec);
                    break;
                }
                case 0: {
                    System.out.println("Escolha uma operação válida!!!");
                    break;
                }
            }
        } while (op != 0);
    }

    private static void Inserir(int vec[]) {
        Scanner ler = new Scanner(System.in);
        int n;
        int num;
        System.out.println("Quantos números quer inserir: ");
        n = ler.nextInt();
        do {
            if (n > vec.length) {
                System.out.println("Excede a capacidade do vector");
                System.out.println("\nQuantos números quer inserir: ");
                n = ler.nextInt();
            }
        } while (n > vec.length);
        for (int i = 0; i < n; i++) {
            System.out.println("Número:");
            num = ler.nextInt();
            vec[i] = num;
        }
    }

    private static void Remover(int vec[]) {
        Scanner ler = new Scanner(System.in);
        int num = 0;
        System.out.println("Que número pretende remover: ");
        num = ler.nextInt();
        for (int i = 0; i < vec.length; i++) {
            if (vec[i] == num) {
                vec[i] = 0;
            }
        }
    }

    private static void Actualizar(int vec[]) {
        Scanner ler = new Scanner(System.in);
        int pos = 0;
        int num = 0;
        System.out.println("Em que posição quer mudar o número: ");
        pos = ler.nextInt();
        System.out.println("Que número pretende colocar: ");
        num = ler.nextInt();
        for (int i = 0; i < vec.length; i++) {
            vec[pos] = num;
        }
    }

    private static void Procurar(int vec[]) {
        Scanner ler = new Scanner(System.in);
        int num = 0;
        int i = 0;
        boolean flag = false;
        System.out.println("Qual o número que procura: ");
        num = ler.nextInt();
        while (flag == false) {
            if (vec[i] == num) {
                System.out.println("O número estava na posição: " + i);
                flag = true;
            } else {                
                i++;
            }
        }
    }

    private static void Listar(int[] vec) {
        int j = 0;
        for (int i = 0; i < vec.length; i++) {
            System.out.println(j + "ª" + "Posição: " + vec[i]);
            j++;
        }
    }
}
