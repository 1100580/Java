package pl_6;

import java.util.Scanner;

public class PL_6 {

    public static void main(String[] args) {
        //programa para fazer a media dos pares do vector.
        int i, s = 0, c = 0;
        int[] v = new int[10];
        Scanner ler = new Scanner(System.in);
        for (i = 0; i < v.length; i++) {
            v[i] = ler.nextInt();
        }
        for (i = 0; i < v.length; i++) {
            if (v[i] % 2 == 0) {
                s = s + v[i];
                c++;
            }
        }
        if (c != 0) {
            System.out.println(((double) s) / c);
        } else {
            System.out.println("Operação impossível de realizar");
        }
        
        int res = calculaMenor(v);
        System.out.println("O menor número é: " + res);
    }

    private static int calculaMenor(int[] v) {
        int menor = 0, indice = -1;
        for (int i = 0; i < v.length; i++) {
            if(i == 0 || v[i]<menor){
                menor = v[i];
                indice = i;
            }
        }
        System.out.println("Indice: " + indice);
        return menor;
    }
}