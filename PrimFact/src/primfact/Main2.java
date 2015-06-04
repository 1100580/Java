package primfact;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        float numInput, quociente;
        String produto = "";

        int divChecker = 0;
        Scanner ler = new Scanner(System.in);
        System.out.println("Introduza o valor");
        numInput = ler.nextFloat();
        while (numInput != 1) {
            divChecker = 2;
            boolean encontrou = false;
            while (!encontrou) {
                if (numInput % divChecker != 0) {
                    if (divChecker == 2) {
                        divChecker++;
                    } else {
                        divChecker = divChecker + 2;
                    }
                } else {
                    if (isPrimo(divChecker) == true) {
                        encontrou = true;
                    } else {
                        divChecker = divChecker + 2;
                    }
                }
            }
            quociente = numInput / divChecker;
            numInput = quociente;
            produto = produto + Integer.toString(divChecker) + "*";
        }
        System.out.println(produto);
    }

    public static boolean isPrimo(double divChecker) {
        int qtDivisores = 0;
        int i = 1;
        while (qtDivisores != 3 && divChecker >= i) {
            if (divChecker % i == 0) {
                qtDivisores++;
            }
            i++;
        }
        if (qtDivisores == 3) {//sendo eles o um, o primo e o proprio numero
            return false;
        } else {
            return true;
        }
    }
}
