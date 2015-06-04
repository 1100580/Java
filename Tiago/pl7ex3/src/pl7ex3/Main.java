package pl7ex3;
import java.util.Scanner;
public class Main {
    public static void met1(String v[], double m[][]){
        Scanner ler = new Scanner (System.in);
        for (int i = 0; i < v.length; i++){
            System.out.println("Introduza o nome do funcionário "+(i+1));
            v[i]=ler.next();
            for (int o = 0 ; o < 12; o++){
                System.out.println("Introduza o vencimento do funcionário para o "+(o+1)+"º mês:");
                m[i][o]=ler.nextDouble();
            }
        }
    }
    public static double met2(String v[], double m[][]){
        double soma=0;
        for (int i = 0; i < v.length; i++){
            for (int o = 0 ; o < 12; o++){
                soma = soma + m[i][o];
            }
        }
        return soma;
    }
    public static void main(String[] args) {
        Scanner ler=new Scanner (System.in);
        System.out.println("Introduza o número de vendedores da empresa.");
        int numv = ler.nextInt ();
        String v [] = new String [numv];
        double m [][] = new double [numv][12];
        int opcao=0;
        while (opcao !=-1){
            System.out.println("-=MENU=-");
            System.out.println("1) Guardar os nomes e as vendas mensais (€) de cada um dos N vendedores da empresa.");
            System.out.println("2) Mostrar o montante anual das vendas da empresa.");
            System.out.println("3) Mostrar o(s) nome(s) do(s) vendedor(es) com o melhor montante mensal de vendas.");
            System.out.println("4) Mostrar o(s) nome(s) do(s) vendedor(es) com o melhor montante anual de vendas.");
            System.out.println("5) Apresentar o(s) mês(es) com o pior montante global de vendas.");
            System.out.println("6) Listar a percentagem de vendas anuais de cada um dos N vendedores.");
            System.out.println("7) Apresentar os montantes trimestrais de vendas da empresa.");
            System.out.println("\nIntroduza a sua opção:");
            opcao=ler.nextInt();
            switch (opcao){
                case 1:
                    met1(v,m);
                    System.out.println("Guardado com Sucesso!");
                    System.out.println("Prima Enter para voltar ao menu.");
                    String coiso = ler.next();
                    continue;
                case 2:
                    double soma = met2(v,m);
                    System.out.println("O montante anual das vendas da empresa é:\n"+soma);
                    continue;
                case 3:

                case 4:

                case 5:

                case 6:

                case 7:

                case -1:
                    break;
            }
        }
    }
}
