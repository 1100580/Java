import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String vendedores[];
        double vendas[][];
        int n = 0;
        char opcao;

        Scanner ler = new Scanner(System.in);

        n = numVendedores();

        vendedores = new String[n];
        vendas = new double[n][12];

        lerInfo(vendedores, vendas);

        do {
            System.out.println("\nMenu\n" +
                    " 1 - Venda Anual da Empresa \n" +
                    " 2 - Vendedores com Melhor Venda Mensal \n" +
                    " 3 - Vendedores com Melhor Venda Anual \n" +
                    " 4 - Piores Meses da Empresa  \n" +
                    " 5 - Vendas Anuais dos Vendedores \n" +
                    " 6 - Vendas Trimestrais da Empresa \n" +
                    " 7 - Terminar");
            System.out.println("\nInsira uma opção:");
            opcao = ler.next().charAt(0);
            switch (opcao) {
                case '1':
                    System.out.printf("\nVenda Anual da Empresa é %.2f € %n", vendaAnualEmpresa(vendas));
                    break;
                case '2':
                    melhorVendedorMensal(vendedores, vendas);
                    break;
                case '3':
                    melhorVendedorAnual(vendedores, vendas);
                    break;
                case '4':
                    piorMesEmpresa(vendas);
                    break;
                case '5':
                    percVendasAnuaisVendedores(vendedores, vendas);
                    break;
                case '6':
                    vendasTrimestraisEmpresa(vendas);
                    break;
                case '7':
                    break;
                default:
                    System.out.println("Opção inválida !!");
            }
        } while (opcao != '7');
    }

    private static int numVendedores() {
        int n;
        Scanner ler = new Scanner(System.in);

        System.out.print("Insira o nº de vendedores:");
        n = ler.nextInt();
        while (n <= 0) {
            System.out.print("Nº inválido.Insira novamente o nº de vendedores:");
            n = ler.nextInt();
        }

        return n;
    }

    private static String mes(int i) {
        String[] nomeMes = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
            "Outubro", "Novembro", "Dezembro"};
        return nomeMes[i];
    }

    private static void lerInfo(String[] vendedores, double[][] vendas) {
        Scanner ler = new Scanner(System.in);

        for (int i = 0; i < vendas.length; i++) {
            System.out.print("Indique o nome do vendedor " + (i + 1) + ":");
            vendedores[i] = ler.next();
            System.out.println("Indique as vendas do " + vendedores[i] + " em €");
            for (int j = 0; j < 12; j++) {
                System.out.print(mes(j) + ":");
                vendas[i][j] = ler.nextDouble();
                while (vendas[i][j] < 0) {
                    System.out.print("Valor inválido !!! Indique novamente as vendas de " + mes(j) + " (€):");
                    vendas[i][j] = ler.nextDouble();
                }
            }
        }
    }

    private static double vendaAnualEmpresa(double[][] vendas) {
        double s = 0;
        for (int i = 0; i < vendas.length; i++) {
            for (int j = 0; j < 12; j++) {
                s = s + vendas[i][j];
            }
        }
        return s;
    }

    private static void melhorVendedorMensal(String[] vendedores, double[][] vendas) {
        double maior = 0;
        int i, j;

        for (i = 0; i < vendedores.length; i++) {
            for (j = 0; j < 12; j++) {
                if (vendas[i][j] > maior) {
                    maior = vendas[i][j];
                }
            }
        }

        System.out.println("Vendedores com a melhor venda mensal");
        for (i = 0; i < vendedores.length; i++) {
            j = 0;
            while (j < 12 && vendas[i][j] != maior) {
                j++;
            }
            if (j < 12) {
                System.out.println(vendedores[i]);
            }
        }
    }

    private static double[] vendasAnuaisVendedores(double[][] vendas) {
        double vendasAnuais[] = new double[vendas.length];
        double s;
        for (int i = 0; i < vendas.length; i++) {
            s = 0;
            for (int j = 0; j < 12; j++) {
                s = s + vendas[i][j];
            }
            vendasAnuais[i] = s;
        }
        return vendasAnuais;
    }

    private static void melhorVendedorAnual(String[] vendedores, double[][] vendas) {
        double maior = 0;

        double[] vendasAnuaisVendedores = vendasAnuaisVendedores(vendas);

        for (int i = 0; i < vendedores.length; i++) {
            if (vendasAnuaisVendedores[i] > maior) {
                maior = vendasAnuaisVendedores[i];
            }
        }

        System.out.println("Melhores Vendedores do Ano");
        for (int i = 0; i < vendedores.length; i++) {
            if (vendasAnuaisVendedores[i] == maior) {
                System.out.println(vendedores[i]);
            }
        }
    }

    private static double[] vendasMensaisEmpresa(double[][] vendas) {
        double[] vendasMensaisEmpresa = new double[12];
        for (int i = 0; i < 12; i++) {
            vendasMensaisEmpresa[i] = 0;
            for (int j = 0; j < vendas.length; j++) {
                vendasMensaisEmpresa[i] += vendas[j][i];
            }
        }
        return vendasMensaisEmpresa;
    }

    private static void piorMesEmpresa(double[][] vendas) {
        double[] vendasMensaisEmpresa = vendasMensaisEmpresa(vendas);
        double menor = vendasMensaisEmpresa[0];

        for (int i = 1; i < 12; i++) {
            if (vendasMensaisEmpresa[i] < menor) {
                menor = vendasMensaisEmpresa[i];
            }
        }
        System.out.println("Meses com Pior Venda:");
        for (int i = 0; i < 12; i++) {
            if (vendasMensaisEmpresa[i] == menor) {
                System.out.println(mes(i));
            }
        }
    }

    private static String[] ordenar(String[] vendedores, double[] vendasAnuais) {
        String tmpNome, vendedoresOrdenados[] = new String[vendedores.length];
        double tmpVenda;
        for (int i = 0; i < vendedores.length; i++) {
            vendedoresOrdenados[i] = vendedores[i];
        }
        for (int i = 0; i < vendedoresOrdenados.length - 1; i++) {
            for (int j = i + 1; j < vendedoresOrdenados.length; j++) {
                if (vendedoresOrdenados[j].compareToIgnoreCase(vendedoresOrdenados[i]) < 0) {
                    tmpNome = vendedoresOrdenados[i];
                    vendedoresOrdenados[i] = vendedoresOrdenados[j];
                    vendedoresOrdenados[j] = tmpNome;
                    tmpVenda = vendasAnuais[i];
                    vendasAnuais[i] = vendasAnuais[j];
                    vendasAnuais[j] = tmpVenda;
                }
            }
        }
        return vendedoresOrdenados;
    }

    private static void percVendasAnuaisVendedores(String[] vendedores, double[][] vendas) {
        double s, vendaAnualEmpresa = vendaAnualEmpresa(vendas);
        double[] vendasAnuaisVendedores = vendasAnuaisVendedores(vendas);
        String[] vendedoresOrdenados;
        vendedoresOrdenados=ordenar(vendedores, vendasAnuaisVendedores);
        System.out.println("Vendas Anuais dos Vendedores");
        for (int i = 0; i < vendedores.length; i++) {
            System.out.printf("%20s%10.2f€%8.2f%%%n", vendedoresOrdenados[i], vendasAnuaisVendedores[i], (vendasAnuaisVendedores[i] / vendaAnualEmpresa) * 100);
        }
    }

    private static void vendasTrimestraisEmpresa(double[][] vendas) {
        double s = 0;
        System.out.println("Vendas Trimestrais da Empresa (€)");
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < vendas.length; j++) {
                s = s + vendas[j][i];
            }
            if ((i + 1) % 3 == 0) {
                System.out.printf("%dº : %.2f € %n",((i + 1) / 3),s);
                s = 0;
            }
        }
    }
}