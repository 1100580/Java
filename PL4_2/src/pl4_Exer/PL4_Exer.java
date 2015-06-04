package pl4_Exer;

import javax.swing.JOptionPane;

public class PL4_Exer {

    public static void main(String[] args) {
//        int n, num, s = 0, c = 0;
//        double m;
//
//        n = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero de valores a ler."));
//        for (int i = 0; i < n; i++) {
//            num = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor de num."));
//            if (num % 2 == 0) {
//                c = c + 1;
//                s = s + num;
//            }
//        }
//        if (c != 0) {
//            m = s/c;
//            System.out.println("Media dos pares: " + m);
//        }else{
//            System.out.println("Não foram introduzidos pares.");
//        }
//-------------------------------------------------------------------------------------
//        int n, dia, temp, max = -31;
//        n = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero de dias a ler."));
//
//        for (int i = 0; i < n; i++) {
//            temp = Integer.parseInt(JOptionPane.showInputDialog("Insira a temperatura."));
//            if (temp > max) {
//                max = temp;
//                dia = i;
//            }
//        }
//        if (n != 0) {
//            if (max <= -30) {
//                System.out.println("Temperatura extrema!!!");
//            } else if (max <= 9) {
//                System.out.println("Muito frio.");
//            } else if (max <= 15) {
//                System.out.println("Frio.");
//            } else if (max <= 20) {
//                System.out.println("Ameno.");
//            } else if (max <= 30) {
//                System.out.println("Quente.");
//            } else if (max <= 50) {
//                System.out.println("Muito quente.");
//            } else {
//                System.out.println("Temperatura extrema!!!");
//            }
//        }
//------------------------------------------------------------------------------
//        String nome = "aaa";
//        double idade, m18 = 0, numIdades = 0;
//        while (!"zzz".equals(nome)) {
//            nome = JOptionPane.showInputDialog("Qual o nome?");
//            idade = Integer.parseInt(JOptionPane.showInputDialog("Qual a idade?"));
//            if (!"zzz".equals(nome)) {
//                System.out.println(nome);
//                numIdades++;
//                if (idade > 18) {
//                    m18++;
//                }
//            }
//        }
//        if (numIdades != 0) {
//            System.out.println("Percentagem: " + (m18 / numIdades) * 100);
//        }
//------------------------------------------------------------------------------
        //Isola os numeros impares de um numero
//        int num,d,aux = 1,res = 0;
//        num = Integer.parseInt(JOptionPane.showInputDialog("Qual o valor de num?"));
//        while(num != 0){
//            d = num%10;
//            if (d%2 == 1) {
//                res = res+d*aux;
//                aux = aux*10;
//            }
//            num = num/10;
//        }
//        System.out.println("O resultado é: " + res);
//------------------------------------------------------------------------------
//        int a,b,aux,num,d,e = 0;
//        a = Integer.parseInt(JOptionPane.showInputDialog("Qual o valor de a?"));
//        b = Integer.parseInt(JOptionPane.showInputDialog("Qual o valor de b?"));
//        if (a>b) {
//            aux = a;
//            a = b;
//            b = aux;
//        }
//        d = Integer.parseInt(JOptionPane.showInputDialog("Quantos números irá ler??"));
//        for (int i = 0; i < d; i++) {
//            do{
//                num = Integer.parseInt(JOptionPane.showInputDialog("Qual o valor do numero a testar?(Maior que 0)"));
//            }while(num<0);
//            if ((num%a == 0) && (b%num == 0)) {
//                e++;
//            }
//        }
//        System.out.println("Nums multiplos de a e divisores de b: " + e);
//------------------------------------------------------------------------------
//        int pares1 = 0, pares2 = 0, numLido;
//
//        numLido = Integer.parseInt(JOptionPane.showInputDialog("Insira um número da sequência 1?"));
//        while (numLido != 0) {
//            if (numLido % 2 == 0) {
//                pares1++;
//            }
//            numLido = Integer.parseInt(JOptionPane.showInputDialog("Insira um número da sequência 1?"));
//        }
//        
//        numLido = Integer.parseInt(JOptionPane.showInputDialog("Insira um número da sequência 2?"));
//        while (numLido != -1) {
//            if (numLido % 2 == 0) {
//                pares2++;
//            }
//            numLido = Integer.parseInt(JOptionPane.showInputDialog("Insira um número da sequência 2?"));
//        }
//        if (pares1 > pares2) {
//            System.out.println("A primeira sequência tem mais pares (" + pares1 + ").");
//        }else if(pares1 == pares2){
//            System.out.println("Ambas têm " + pares1 + "pares.");
//        }else{
//            System.out.println("A primeira sequência tem mais pares (" + pares2 + ").");
//        }
    }
}
