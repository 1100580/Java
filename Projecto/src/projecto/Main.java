package projecto;

import java.io.*;
import java.util.*;
import sun.text.resources.CollationData_hi;

/**
 *
 * @author Grupo 1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    //Declarações de variáveis
    static Scanner ler = new Scanner(System.in);
    static final int MAX_LIN_COL_MAT = 20;

    public static void main(String[] args) throws Exception {
        //Declarações de variáveis
        int op;
        int sub_op;
        boolean introduzidosDados = false;
        float matriz[][] = null;
        int lin = 0, col = 0;

        do {
            op = menu(); //Chama o Método Menu, que irá apresentar o MENU PRINCIPAL do Programa, retornando a opção escolhida pelo utilizador
            switch (op) {

                case 1: //Introdução de dados
                    do {
                        //Sub-Menu -> Introdução de Dados
                        System.out.println("");
                        System.out.println("                               ---Introdução de dados---");
                        System.out.println("\n\n1- Via teclado");
                        System.out.println("2- Ficheiro HTML");
                        System.out.println("3- Ficheiro de Texto");
                        System.out.println("0- Voltar atrás");
                        System.out.print("Escolha a sua opção: ");
                        sub_op = ler.nextInt(); //A variável sub_op contém a escolha do utilizador (Opções válidas-1,2,3,0)
                        if (sub_op != 0 && sub_op != 1 && sub_op != 2 && sub_op != 3) {
                            System.out.println("\nOpção incorrecta! Por favor, escolha correctamente a opção prentendida"); //Em caso de erro na escolha da opção, será apresentada esta mensagem
                        }
                    } while (sub_op != 0 && sub_op != 1 && sub_op != 2 && sub_op != 3);
                    System.out.println(""); //Linha em Branco

                    switch (sub_op) {
                        case 1:
                            System.out.println("");
                            do {
                                System.out.print("Digite o número de linhas que pretende para a Matriz Principal(Máximo 20):");
                                lin = ler.nextInt(); //Nº de Linhas que irá conter a Matriz
                            } while ((lin > MAX_LIN_COL_MAT) || (lin <= 0));

                            do {
                                System.out.print("Digite o número de colunas que pretende para a Matriz Principal(Máximo 20):");
                                col = ler.nextInt();//Nº de Colunas que irá conter a Matriz
                            } while ((col > MAX_LIN_COL_MAT) || (col <= 0));
                            matriz = new float[lin][col]; //Criação da matriz principal com os limites definidos pelo utilizador

                            lerMatriz(matriz); //Procedimento para ler a matriz via teclado
                            System.out.println("\n");
                            introduzidosDados = true; //Dá instrução ao programa principal que já foram introduzidos dados na matriz
                            break;

                        case 2: //Ler matriz via Ficheiro HTML
                            break;

                        case 3:
                            System.out.println("Qual o nome do ficheiro que pretende abrir?");
                            String nomeFich = ler.next(); //Lê o valor que o utilizador introduziu
                            matriz = lerFicheiro(nomeFich); //Chama o método para ler o ficheiro
                            lin = matriz[0].length; //Nº de Linhas da matriz
                            col = matriz.length; //Nº de Colunas da matriz
                            System.out.println("\nMatriz Introduzida:");
                            mostrarMatriz(matriz);
                            introduzidosDados = true; //Dá instrução ao programa principal que já foram introduzidos dados na matriz
                            break;
                        case 0: //Voltar ao MENU PRINCIPAL
                            break;
                        default:
                            System.out.println("\nOPÇÃO INCORRECTA. REPITA"); //Em caso de erro na escolha da opção, será apresentada esta mensagem
                            break;
                    }

                    break;

                case 2: //Calcular o produto de um vector por uma matriz
                    if (introduzidosDados == true) { //Se o utilizador já tiver introduzido dados na matriz, será executado o código que se segue.
                        float[] vectorResultado = calcularProdutoVectorMatriz(matriz, lin, col); //Chama o método para efectuar o Cálculo do Produto de um vector por uma matriz

                        int output = respOutput();
                        switch (output) {
                            case 1: //Caso o utilizador deseje que o Output seja apresentado através da consola
                                System.out.println("\n\nResultado:\n");
                                //Mostrar o resultado
                                for (int i = 0; i < vectorResultado.length; i++) {
                                    System.out.print(vectorResultado[i] + " | ");
                                }
                                break;
                            case 2: //Caso o utilizador deseje que o Output seja apresentado num ficheiro HTML
                                System.out.println("Qual o nome que prentede dar para o Ficheiro HTML?");
                                String nomeFich = ler.next();
                                Formatter fout = new Formatter(new File(nomeFich + ".html"));

                                fout.format(abrirHtml());
                                fout.format(abrirtitle("Calcular o produto de um vector por uma matriz"));
                                fout.format("<p align=\"left\"><img src=\"isep.jpg\"></p>");
                                fout.format(escrevertexto("<h1 align=\"center\">Calcular o produto de um vector por uma matriz</h1>"));
                                fout.format("<br>");
                                fout.format("<br>");
                                fout.format(escrevertexto("Matriz Principal: "));
                                fout.format(escrevermatriz(matriz));
                                fout.format("<br>");
                                fout.format("<br>");
                                fout.format(escrevertexto("Resultado Final: "));
                                fout.format(escrevervector(vectorResultado));
                                fout.format(fecharHtml());
                                fout.close();

                                System.out.println("\nFicheiro criado com Sucesso!");
                                break;
                            default:
                                break;
                        }

                    } else { //Caso a matriz ainda não se encontre preenchida com valores, será apresentada a seguinte mensagem:
                        System.out.println("Erro. Ainda não foram introduzidos valores na matriz. Por favor escolha a 1º Opção.\n");
                    }
                    break;

                case 3: //Calcular o produto de matrizes
                    if (introduzidosDados == true) {//Se o utilizador já tiver introduzido dados na matriz, será executado o código que se segue.
                        float[][] matrizResultado = calcularProdutoMatrizes(matriz, lin, col); //Chama o método para calcular o produto entre matrizes
                        int output = respOutput();
                        switch (output) {
                            case 1: //Caso o utilizador deseje que o Output seja apresentado através da consola
                                System.out.println("\n\nResultado: (Multiplicação da 1º Matriz com a 2º Matriz)");
                                mostrarMatriz(matrizResultado);
                                break;
                            case 2: //Caso o utilizador deseje que o Output seja apresentado num ficheiro HTML
                                System.out.println("Qual o nome que prentede dar para o Ficheiro HTML?");
                                String nomeFich = ler.next();
                                codificadorMatriz(nomeFich, matriz, matrizResultado, "Calcular o produto de matrizes");
                                System.out.println("\nFicheiro criado com Sucesso!");
                                break;
                            default:
                                break;
                        }

                    } else { //Caso a matriz ainda não se encontre preenchida com valores, será apresentada a seguinte mensagem:
                        System.out.println("Erro Ainda não foram introduzidos valores na matriz. Por favor escolha a 1º Opção.\n");
                    }
                    break;
                case 4: //Calcular a  característica de uma matriz pelo método de condensação com pivotação parcial

                    if (introduzidosDados == true) {//Se o utilizador já tiver introduzido dados na matriz, será executado o código que se segue.
                        boolean matquad;
                        String maior = ""; //Inicializa a variável a nulo
                        if (lin == col) { //Se o número de linhas introduzidas for igual ao número de colunas faz:
                            System.out.println("Informação: A Matriz é quadrada");
                            matquad = true;
                        } else { //Se a matriz não for quadrada, faz:
                            System.out.println("Informação: A Matriz não é quadrada.");
                            matquad = false;

                            if (lin > col) {
                                maior = "linhas";
                            } else {
                                maior = "colunas";
                            }
                        }

                        float matTemp[][] = new float[lin][col]; //Criação de uma matriz temporária

                        matTemp = condensar(matriz, lin, col, matquad, maior);
                        int count = 0;
                        System.out.println("\nMatriz Introduzida");
                        mostrarMatriz(matriz);
                        System.out.println("\n\nMatriz Condensada:");
                        mostrarMatriz(matTemp);
                        if (maior.equals("linhas")) {
                            for (int i = 0; i < col; i++) {
                                if (matTemp[i][i] != 0) {
                                    count++;
                                }

                            }
                        } else if (maior.equals("colunas")) {
                            for (int i = 0; i < lin; i++) {
                                if (matTemp[i][i] != 0) {
                                    count++;
                                }
                            }
                        } else if (maior.equals("")) {
                            for (int i = 0; i < col; i++) {
                                if (matTemp[i][i] != 0) {
                                    count++;
                                }
                            }
                        }

                        int output = respOutput();
                        switch (output) {
                            case 1: //Caso o utilizador deseje que o Output seja apresentado através da consola
                                System.out.println("\n\nA característica é: " + count);
                                break;
                            case 2: //Caso o utilizador deseje que o Output seja apresentado num ficheiro HTML
                                System.out.println("Qual o nome que prentede dar para o Ficheiro HTML?");
                                String nomeFich = ler.next();
                                codificadorTexto(nomeFich, "\n\nA caracteristica e: " + count, matTemp, "Calcular a  caracteristica de uma matriz pelo metodo de condensacao com pivotacao parcial");
                                System.out.println("Ficheiro criado com sucesso!");
                                break;
                            default:
                                break;
                        }

                    } else { //Caso a matriz ainda não se encontre preenchida com valores, será apresentada a seguinte mensagem:
                        System.out.println("Erro. Ainda não foram introduzidos valores na matriz. Por favor escolha a 1º Opção.\n");
                    }

                    break;
                case 5: //Calcular a  inversa de uma matriz quadrada pela utilização da matriz identidade (método da condensação)
                    if (introduzidosDados == true) { //Se o utilizador já tiver introduzido dados na matriz, será executado o código que se segue.
                        float matAux[][] = new float[lin * 2][col * 2];
                        matAux = determinarMatrizIdentidade(matriz, lin, col);
                        int output = respOutput();
                        switch (output) {
                            case 1: //Caso o utilizador deseje que o Output seja apresentado através da consola
                                System.out.println("\nMatriz identidade:");
                                mostrarMatriz(matAux);
                                break;
                            case 2: //Caso o utilizador deseje que o Output seja apresentado num ficheiro HTML
                                System.out.println("Qual o nome que prentede dar para o Ficheiro HTML?");
                                String nomeFich = ler.next();
                                codificadorMatriz(nomeFich, matriz, matAux, "Calcular a inversa usando a matriz identidade");
                                System.out.println("Ficheiro criado com sucesso!");
                                break;
                            default:
                                break;
                        }

                    } else { //Caso a matriz ainda não se encontre preenchida com valores, será apresentada a seguinte mensagem:
                        System.out.println("Erro. Ainda não foram introduzidos valores na matriz. Por favor escolha a 1º Opção.\n");
                    }
                    break;
                case 6: //Calcular o determinante de uma matriz quadrada de 3ª ordem utilizando a Regra de Sarrus
                    if (introduzidosDados == true) { //Se o utilizador já tiver introduzido dados na matriz, será executado o código que se segue.
                        if (lin == 3 && col == 3) {
                            float res = calcularSarrus(matriz); //Calcula o Determinante e retorna o valor para na próxima linha ser mostrado ao utilizador

                            int output = respOutput();
                            switch (output) {
                                case 1: //Caso o utilizador deseje que o Output seja apresentado através da consola
                                    System.out.println("\nO determinante calculado através de Sarrus é igual a " + res);
                                    break;
                                case 2: //Caso o utilizador deseje que o Output seja apresentado num ficheiro HTML
                                    System.out.println("Qual o nome que prentede dar para o Ficheiro HTML?");
                                    String nomeFich = ler.next();
                                    codificadorTexto(nomeFich, "\nO determinante calculado atraves de Sarrus e igual a " + res, matriz, "Calcular o determinante de uma matriz quadrada de 3 ordem utilizando a Regra de Sarrus");
                                    System.out.println("Ficheiro criado com sucesso!");
                                    break;
                                default:
                                    break;
                            }

                        } else {
                            System.out.println("\nA Matriz não é de 3x3, logo não pode ser calculada através de Sarrus!");
                        }
                    } else {//Caso a matriz ainda não se encontre preenchida com valores, será apresentada a seguinte mensagem:
                        System.out.println("Erro. Ainda não foram introduzidos valores na matriz. Por favor escolha a 1º Opção.\n");
                    }

                    break;
                case 7: //Calcular o determinante de uma matriz quadrada utilizando o Teorema de Laplace
                    if (introduzidosDados == true) {//Se o utilizador já tiver introduzido dados na matriz, será executado o código que se segue.
                        if (lin == col) { //Se o nº de linhas for igual ao número de colunas então a matriz é quadrada e poderá ser calculada através de Laplace
                            System.out.println("Informação: A Matriz é quadrada");

                            int output = respOutput();
                            switch (output) {
                                case 1: //Caso o utilizador deseje que o Output seja apresentado através da consola
                                    System.out.println("\n\nO Determinante é igual a: " + laplace(matriz, lin, col)); //Calcula o Determinante através de Laplace
                                    break;
                                case 2: //Caso o utilizador deseje que o Output seja apresentado num ficheiro HTML
                                    System.out.println("Qual o nome que prentede dar para o Ficheiro HTML?");
                                    String nomeFich = ler.next();
                                    codificadorTexto(nomeFich, "O Determinante e igual a: " + laplace(matriz, lin, col), matriz, "Calcular o determinante de uma matriz quadrada utilizando o Teorema de Laplace");
                                    System.out.println("Ficheiro criado com sucesso!");
                                    break;
                                default:
                                    break;
                            }

                        } else { //Se a matriz não for quadrada não poderá ser calculada através de laplace
                            System.out.println("\nInformação: A Matriz não é quadrada, logo não pode ser calculada!");
                        }
                    } else { //Caso a matriz ainda não se encontre preenchida com valores, será apresentada a seguinte mensagem:
                        System.out.println("Erro. Ainda não foram introduzidos valores na matriz. Por favor escolha a 1º Opção.\n");
                    }
                    break;
                case 8: //Calcular o determinante de uma matriz quadrada utilizando apenas as suas propriedades
                    if (introduzidosDados == true) {//Se o utilizador já tiver introduzido dados na matriz, será executado o código que se segue.

                        if (lin == col) {
                            System.out.println("Informação: A Matriz é quadrada");
                            int output = respOutput();
                            switch (output) {
                                case 1: //Caso o utilizador deseje que o Output seja apresentado através da consola
                                    System.out.println("O Determinante é igual a: " + propriedades(matriz, lin, col));
                                    break;
                                case 2: //Caso o utilizador deseje que o Output seja apresentado num ficheiro HTML
                                    System.out.println("Qual o nome que prentede dar para o Ficheiro HTML?");
                                    String nomeFich = ler.next();
                                    codificadorTexto(nomeFich, "O Determinante e igual a: " + propriedades(matriz, lin, col), matriz, "Calcular o determinante de uma matriz quadrada utilizando apenas as suas propriedades");
                                    System.out.println("Ficheiro criado com sucesso!");
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            System.out.println("Informação: A Matriz não é quadrada, logo não pode ser calculada!");
                        }
                    } else { //Caso a matriz ainda não se encontre preenchida com valores, será apresentada a seguinte mensagem:
                        System.out.println("Erro. Ainda não foram introduzidos valores na matriz. Por favor escolha a 1º Opção.\n");
                    }

                    break;

                case 9: //Calcular a transposta de uma matriz
                    if (introduzidosDados == true) { //Se o utilizador já tiver introduzido dados na matriz, será executado o código que se segue.
                        int output = respOutput();
                        float matrizAux[][] = new float[lin][col]; //Cria uma matriz auxiliar
                        matrizAux = calcularTransposta(matriz, lin, col);
                        switch (output) {
                            case 1: //Caso o utilizador deseje que o Output seja apresentado através da consola
                                System.out.println("Matriz Original:\n");
                                mostrarMatriz(matriz); //Mostra a matriz Original
                                System.out.println("\n\nMatriz Transposta:\n");
                                mostrarMatriz(matrizAux); //Mostra a Matriz Transposta
                                break;
                            case 2: //Caso o utilizador deseje que o Output seja apresentado num ficheiro HTML
                                System.out.println("Qual o nome que prentede dar para o Ficheiro HTML?");
                                String nomeFich = ler.next();
                                codificadorMatriz(nomeFich, matriz, matrizAux, "Calcular a transposta de uma matriz");
                                System.out.println("Ficheiro criado com sucesso!");
                                break;
                            default:
                                break;
                        }

                    } else { //Caso a matriz ainda não se encontre preenchida com valores, será apresentada a seguinte mensagem:
                        System.out.println("Erro. Ainda não foram introduzidos valores na matriz. Por favor escolha a 1º Opção.\n");
                    }
                    break;
                case 10: //Calcular o complemento algébrico de um dado elemento de uma matriz quadrada
                    if (introduzidosDados == true) {//Se o utilizador já tiver introduzido dados na matriz, será executado o código que se segue.
                        if (lin == col) {
                            System.out.println("Informação: A Matriz é quadrada");
                            int templin, tempcol;
                            System.out.println("\nMatriz:");
                            mostrarMatriz(matriz); //Mostra a Matriz
                            do {
                                System.out.print("\n\nQual o índice da linha?(Máximo " + lin + "): ");
                                templin = ler.nextInt();
                            } while ((templin > lin) || (templin <= 0));

                            do {
                                System.out.print("\nQual o índice da coluna?(Máximo " + col + "): ");
                                tempcol = ler.nextInt();
                            } while ((tempcol > col) || (tempcol <= 0));


                            int output = respOutput();
                            switch (output) {
                                case 1: //Caso o utilizador deseje que o Output seja apresentado através da consola
                                    System.out.println("\nO resultado é: " + calculcarComplementoAlgebricoMatQuadrada(matriz, lin, col, templin, tempcol));
                                    break;
                                case 2: //Caso o utilizador deseje que o Output seja apresentado num ficheiro HTML
                                    System.out.println("Qual o nome que prentede dar para o Ficheiro HTML?");
                                    String nomeFich = ler.next();

                                    codificadorTexto(nomeFich, "O resultado e: " + calculcarComplementoAlgebricoMatQuadrada(matriz, lin, col, templin, tempcol), matriz, "Calcular o complemento algebrico de um dado elemento de uma matriz quadrada");
                                    System.out.println("Ficheiro criado com sucesso!");
                                    break;
                                default:
                                    break;
                            }

                        } else {
                            System.out.println("\nInformação: A Matriz não é quadrada, portanto não poderá calcular o seu complemento algébrico.");
                        }
                    } else { //Caso a matriz ainda não se encontre preenchida com valores, será apresentada a seguinte mensagem:
                        System.out.println("\nErro. Ainda não foram introduzidos valores na matriz. Por favor escolha a 1º Opção.\n");
                    }

                    break;
                case 11: // Calcular a inversa de uma matriz quadrada através da utilização da matriz adjunta
                    if (introduzidosDados == true) {//Se o utilizador já tiver introduzido dados na matriz, será executado o código que se segue.
                        if (lin == col) { //Se a matriz for quadrada então executa o seguinte código:
                            System.out.println("Informação: A Matriz é quadrada");
                            float deter;
                            deter = laplace(matriz, lin, col); //Calcula o determinante através de laplace
                            float matrizResultado[][] = new float[lin][col]; //Criação de uma matriz Auxiliar

                            matrizResultado = calcularAdjunta(matriz, lin, col); //calcula a matriz Adjunta, retornando a matriz resultado

                            int output = respOutput();
                            switch (output) {
                                case 1: //Caso o utilizador deseje que o Output seja apresentado através da consola
                                    System.out.println("Resultado:");
                                    System.out.print("\n" + "1/" + deter + " x ");
                                    mostrarMatriz(matrizResultado);
                                    break;
                                case 2: //Caso o utilizador deseje que o Output seja apresentado num ficheiro HTML
                                    System.out.println("Qual o nome que prentede dar para o Ficheiro HTML?");
                                    String nomeFich = ler.next();

                                    codificadorTexto(nomeFich, "Resultado:\n\n" + "1/" + deter + " x ", matrizResultado, "Calcular a inversa de uma matriz quadrada atraves da utilizacao da matriz adjunta");
                                    System.out.println("Ficheiro criado com sucesso!");
                                    break;
                                default:
                                    break;
                            }

                        } else {
                            System.out.println("\nInformação: A Matriz não é quadrada, portanto não poderá calcular o seu complemento algébrico.");
                        }
                    } else { //Caso a matriz ainda não se encontre preenchida com valores, será apresentada a seguinte mensagem:
                        System.out.println("\nErro. Ainda não foram introduzidos valores na matriz. Por favor escolha a 1º Opção.\n");
                    }
                    break;

                case 12: //Saida de Dados em Ficheiros de texto
                    if (introduzidosDados == true) { //Se o utilizador já tiver introduzido dados na matriz, será executado o código que se segue.
                        System.out.println("Qual o nome do ficheiro que pretende guardar os valores?");
                        String nomeFich = ler.next(); //Lê o nome do ficheiro que o utilizador pretende guardar os dados.
                        saida_dados_ficheiro(matriz, lin, col, nomeFich); //Método para criar o ficheiro de texto com os dados
                        System.out.println("Ficheiro criado com sucesso!");
                    } else { //Caso a matriz ainda não se encontre preenchida com valores, será apresentada a seguinte mensagem:
                        System.out.println("Erro. Ainda não foram introduzidos valores na matriz. Por favor escolha a 1º Opção.\n");
                    }
                    break;
                case 0:
                    System.out.println("                                                                              *** Fim do Programa ***");
                    op = 0;
                    break;
                default:
                    System.out.println("\nOpção incorrecta! Por favor, escolha correctamente a opção prentendida");
                    break;
            }

        } while (op != 0);


    }

    //@ Menu Principal
    private static int menu() {
        //Apresentação do Menu Principal
        System.out.println("\n                                      ----- MENU PRINCIPAL-----                      ");
        System.out.println("\n\n\n1 - Introdução de dados");
        System.out.println("2 - Calcular o produto de um vector por uma matriz");
        System.out.println("3 - Calcular o produto de matrizes");
        System.out.println("4 - Calcular a  característica de uma matriz pelo método de condensação com pivotação parcial");
        System.out.println("5 - Calcular a  inversa de uma matriz quadrada pela utilização da matriz identidade (método da condensação)");
        System.out.println("6 - Calcular o determinante de uma matriz quadrada de 3ª ordem utilizando a Regra de Sarrus");
        System.out.println("7 - Calcular o determinante de uma matriz quadrada utilizando o Teorema de Laplace");
        System.out.println("8 - Calcular o determinante de uma matriz quadrada utilizando apenas as suas propriedades");
        System.out.println("9 - Calcular a transposta de uma matriz");
        System.out.println("10 - Calcular o complemento algébrico de um dado elemento de uma matriz quadrada");
        System.out.println("11 - Calcular a inversa de uma matriz quadrada através da utilização da matriz adjunta");
        System.out.println("12 - Saida de Dados em Ficheiros de texto");
        System.out.println("0 - Sair");
        System.out.print("Escolha a sua opção: ");

        int op = ler.nextInt(); //Lê a opção do utilizador
        System.out.println("");

        return op; //Retorna a opção que o utilizador escolheu
    }

    private static void lerVector(float[] vec) {

        System.out.println("\nIntrodução de Dados no vector:\n");
        for (int i = 0; i < vec.length; i++) {
            System.out.println("Insira valor para a Coluna " + (i + 1));
            vec[i] = ler.nextInt();
        }

        String resp; //Criação da variável resp para usar no ciclo Do-while

        System.out.println("\nVector:\n");
        for (int j = 0; j < vec.length; j++) {
            System.out.print(vec[j] + " | ");
        }

        do { //Este ciclo irá ser repetido sempre que o utilizador deseje alterar um valor
            System.out.println("\n\nDeseja alterar algum valor do vector?(S/N) ");
            resp = ler.next(); // Variável que contém a resposta do utilizador
            resp = resp.toUpperCase(); // Coloca todos os caracteres da variável resp com maiúsculas
            while (resp.length() != 1 || (resp.charAt(0) != 'S' && resp.charAt(0) != 'N')) {
                System.out.print("Resposta inválida!!! Deseja alterar algum valor da matriz?(S/N)? ");
                resp = ler.next();
                resp = resp.toUpperCase();
            }
            int tempcol;
            if (resp.equals("S")) { //Se o utilizador quiser alterar um valor, irá ser executado o código em baixo

                do {
                    System.out.print("Qual o índice da coluna?(Máximo " + vec.length + "): ");
                    tempcol = ler.nextInt();
                } while ((tempcol > vec.length) || (tempcol <= 0));

                System.out.print("Qual o novo valor para a coluna " + (tempcol) + ":");
                float novoValor = ler.nextFloat(); //Variável que contém o novo valor
                vec[tempcol - 1] = novoValor; //Coloca o novo valor no vector, na posição indicada pelo utilizador

            } // Fim do IF
            System.out.println("\nVector:\n");
            for (int j = 0; j < vec.length; j++) {
                System.out.print(vec[j] + " | ");
            }
        } while (resp.equals("S")); // Fim do ciclo While

    }

    private static void lerMatriz(float matriz[][]) {
        int i, j;
        System.out.println("");
        for (i = 0; i < matriz.length; i++) {
            for (j = 0; j < matriz[i].length; j++) {
                System.out.println("Insira valor para a Linha " + (i + 1) + " Coluna " + (j + 1));
                matriz[i][j] = ler.nextInt();
            }
        }
        System.out.println("\nMatriz:");
        mostrarMatriz(matriz);
        String resp; //Criação da variável resp para usar no ciclo Do-while

        do { //Este ciclo irá ser repetido sempre que o utilizador deseje alterar um valor
            System.out.println("\n\nDeseja alterar algum valor da matriz?(S/N) ");
            resp = ler.next(); // Variável que contém a resposta do utilizador
            resp = resp.toUpperCase(); // Coloca todos os caracteres da variável resp com maiúsculas
            while (resp.length() != 1 || (resp.charAt(0) != 'S' && resp.charAt(0) != 'N')) {
                System.out.print("Resposta inválida!!! Deseja alterar algum valor da matriz?(S/N)? ");
                resp = ler.next();
                resp = resp.toUpperCase();
            }
            int templin,
                    tempcol;
            if (resp.equals("S")) { //Se o utilizador quiser alterar um valor, irá ser executado o código em baixo
                do { //Ciclo que permite a alteração
                    System.out.print("Qual o índice da linha?(Máximo " + matriz.length + "): ");
                    templin = ler.nextInt();
                } while ((templin > matriz.length) || (templin <= 0));

                do {
                    System.out.print("Qual o índice da coluna?(Máximo " + matriz[0].length + "): ");
                    tempcol = ler.nextInt();
                } while ((tempcol > matriz[0].length) || (tempcol <= 0));

                System.out.print("Qual o novo valor para a posição (" + (templin) + "," + (tempcol) + ")" + ":");
                float novoValor = ler.nextFloat(); //Variável que contém o novo valor
                matriz[templin - 1][tempcol - 1] = novoValor; //Coloca o novo valor na matriz, na posição indicada pelo utilizador

            } // Fim do IF
            System.out.println("\nMatriz:");
            mostrarMatriz(matriz);
        } while (resp.equals("S")); // Fim do ciclo While
    }

    private static void mostrarMatriz(float[][] matrizPrincipal) {
        //Mostra a Matriz
        for (int i = 0; i < matrizPrincipal.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < matrizPrincipal[0].length; j++) {
                System.out.print(matrizPrincipal[i][j] + " | ");
            }
        }
    }

    private static float[] calcularProdutoVectorMatriz(float matrizPrincipal[][], int linMat_Principal, int colMat_Principal) throws Exception {

        int col;
        System.out.println("\nMatriz Principal:");
        mostrarMatriz(matrizPrincipal); //Mostra a Matriz Principal

        float vectorResultado[] = new float[colMat_Principal]; //Criação do vector Resultado

        float vec[] = new float[linMat_Principal]; // Criação do vector
        System.out.println("\n\nInformação: O número de colunas do vector terá de ser o mesmo que o número de linhas da matriz principal (" + (linMat_Principal) + ")");
        System.out.println("");
        lerVector(vec); // Inserção de Dados no 1º vector

        float aux;

        // Multiplicação do vector pela matriz

        for (int i = 0; i < colMat_Principal; i++) {
            aux = 0; //O aux é sempre inicializado a zero ao fim do 2º ciclo para se poder fazer os cálculos para cada coluna
            for (int j = 0; j < linMat_Principal; j++) {
                aux += matrizPrincipal[j][i] * vec[j]; // o aux irá conter a multiplicação de cada posição da matriz com a respectiva posiçao do vector, estando sempre a ser incrementado o seu valor
            }
            vectorResultado[i] = aux; // Guarda o resultado na posição i do vector resultado
        }
        return vectorResultado; //Retorna o vector que contém o resultado

    }

    private static float[][] calcularProdutoMatrizes(float matrizPrincipal[][], int linMat_Principal, int colMat_Principal) throws Exception {

        int col;

        System.out.println("\n\nNOTA: O número de linhas é obrigatoriamente :" + colMat_Principal);
        System.out.println("Para a multiplicação de matrizes, o nº de Linhas da 2º Matriz terá de ser igual ao nº de Colunas da 1º Matriz\n");

        do {
            System.out.print("Qual o número de colunas que pretende para a Matriz (Máximo 20):");
            col = ler.nextInt();
        } while ((col > MAX_LIN_COL_MAT) || (col <= 0));

        float matrizResultado[][] = new float[linMat_Principal][col]; //Criação da Matriz Resultado
        float matriz2[][] = new float[colMat_Principal][col]; // Criação da 2º Matriz
        lerMatriz(matriz2); // Inserção de Dados na 2º Matriz

        System.out.println("\n\n1ºMatriz:");
        mostrarMatriz(matrizPrincipal); //Mostra a 1º Matriz

        System.out.println("\n\nMatriz Introduzida: (2ºMatriz) ");
        mostrarMatriz(matriz2); //Mostra a 2º Matriz

        float aux; //Criação de uma variável auxiliar
        int j;
        // Multiplicação
        for (int linha = 0; linha < linMat_Principal; linha++) {
            for (int i = 0; i < col; i++) {
                aux = 0; //Terá de ser inicializado a zero cada vez que acaba o 2º ciclo, para poder calculcar correctamente a multiplicação
                for (j = 0; j < colMat_Principal; j++) {
                    aux += matrizPrincipal[linha][j] * matriz2[j][i];
                }
                matrizResultado[linha][i] = aux;
            }
        }

        return matrizResultado; // Retorna a matriz com o resultado
    }

    private static float calcularSarrus(float matriz[][]) {
        float det = 0;
        System.out.println("(" + matriz[0][0] + "*" + matriz[1][1] + "*" + matriz[2][2] + ") + (" + matriz[1][0] + "*" + matriz[2][1] + "*" + matriz[0][2] + ") + ( " + matriz[2][0] + "*" + matriz[0][1] + "*" + matriz[1][2] + ") - (" + matriz[2][0] + "*" + matriz[1][1] + "*" + matriz[0][2] + ") - (" + matriz[0][0] + "*" + matriz[2][1] + "*" + matriz[1][2] + ") - (" + matriz[2][2] + "*" + matriz[1][0] + "*" + matriz[0][1] + ")");
        return det = (matriz[0][0] * matriz[1][1] * matriz[2][2]) + (matriz[1][0] * matriz[2][1] * matriz[0][2]) + (matriz[2][0] * matriz[0][1] * matriz[1][2]) - (matriz[2][0] * matriz[1][1] * matriz[0][2]) - (matriz[0][0] * matriz[2][1] * matriz[1][2]) - (matriz[2][2] * matriz[1][0] * matriz[0][1]);

    }

    private static float[][] calcularTransposta(float matriz[][], int linMatPrincipal, int colMatPrincipal) {

        float matrizTransposta[][] = new float[colMatPrincipal][linMatPrincipal]; //Criação da matriz Transposta

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matrizTransposta[j][i] = matriz[i][j]; //Calcula a Transposta da matriz original
            }
        }
        return matrizTransposta; //Retorna a Matriz Transposta

    }

    private static float calculcarComplementoAlgebricoMatQuadrada(float matrizPrincipal[][], int linMat_Principal, int colMat_Principal, int templin, int tempcol) {

        float[][] matrizAux = new float[linMat_Principal][colMat_Principal]; //Criação de uma matriz Auxiliar

        matrizAux = matPrincipal_to_matAux(matrizPrincipal, linMat_Principal, colMat_Principal); //Passa os valores que estão na matriz principal para uma matriz auxiliar

        //"Cortar a Linha" Este código que se segue irá copiar a as linhas da matriz para cima apartir da posicao que o utilizador indicou, deixando a ultima linha sempre igual à penúltima.
        for (int i = templin - 1; i < linMat_Principal - 1; i++) {
            for (int j = 0; j < colMat_Principal; j++) {
                matrizAux[i][j] = matrizPrincipal[i + 1][j];
            }
        }
        //"Cortar a Linha" Este código que se segue irá copiar a as colunas da matriz para cima apartir da posicao que o utilizador indicou, deixando a ultima coluna sempre igual à penúltima.
        for (int i = 0; i < linMat_Principal; i++) {
            for (int j = tempcol - 1; j < colMat_Principal - 1; j++) {
                matrizAux[i][j] = matrizAux[i][j + 1];
            }
        }
        float temp[][] = new float[linMat_Principal - 1][colMat_Principal - 1]; //Criação de uma Matriz auxiliar que irá conter a matriz sem as devidas repetições nas linhas e colunas, criadas no código anterior
        for (int i = 0; i < matrizAux.length - 1; i++) {
            for (int j = 0; j < matrizAux[i].length - 1; j++) {
                temp[i][j] = matrizAux[i][j];
            }
        }

        float aux = 1;
        float mat_condensada[][] = new float[linMat_Principal][colMat_Principal]; //Criação de uma nova matriz
        float det = 0;
        if (temp.length == 2) { //Se a matriz for de 2x2 (2 Linhas x 2 Colunas), irão ser calculadas as suas diagonais
            aux = temp[0][0] * temp[1][1] - temp[0][1] * temp[1][0];
        } else if (temp.length == 3) { //Se a matriz for de 3x3 (3 Linhas x 3 Colunas), irá ser calculado através de Sarrus
            aux = calcularSarrus(temp);
        } else if (temp.length > 3) { //Se a matriz for mais de 3x3, esta tem de ser calculada através das propriedades
            aux = propriedades(mat_condensada, linMat_Principal, colMat_Principal);
        }
        return det = (int) Math.pow(-1, (templin + tempcol)) * aux; //Retorna o valor do Complemento algébrico

    }

    private static float[][] calcularAdjunta(float[][] matrizPrincipal, int linMatPrincipal, int colMatPrincipal) {

        float matAux[][] = new float[linMatPrincipal][colMatPrincipal]; // Criação de uma matriz Auxiliar
        for (int i = 0; i < linMatPrincipal; i++) {
            for (int j = 0; j < colMatPrincipal; j++) {
                matAux[i][j] = calculcarComplementoAlgebricoMatQuadrada(matrizPrincipal, linMatPrincipal, colMatPrincipal, i + 1, j + 1);
            }
        }
        return matAux = calcularTransposta(matAux, linMatPrincipal, colMatPrincipal); //Calcula a Transposta e retorna a Matriz
    }

    private static float[][] matPrincipal_to_matAux(float matrizPrincipal[][], int linMat_Principal, int colMat_Principal) {

        //Este método passa os valores da matriz Principal para uma matriz Auxiliar
        float matAux[][] = new float[linMat_Principal][colMat_Principal]; //Criação de uma matriz Auxiliar

        for (int i = 0; i < linMat_Principal; i++) {
            for (int j = 0; j < colMat_Principal; j++) {
                matAux[i][j] = matrizPrincipal[i][j];
            }
        }
        return matAux; //Retorna a Matriz Auxiliar
    }

    private static void saida_dados_ficheiro(float matriz[][], int linMatPrincipal, int colMatPrincipal, String nFich) throws FileNotFoundException {
        Formatter out = new Formatter(new File(nFich)); //Abre e Cria um novo Ficheiro
        for (int i = 0; i < linMatPrincipal; i++) {
            for (int j = 0; j < colMatPrincipal; j++) {
                out.format("%f;", matriz[i][j]); //Coloca os respectivos valores separando-os por um ";"
            }
            out.format("%n");
        }
        out.close(); //Fecha a escrita do Ficheiro
    }

    private static int[] saber_lin_col_ficheiro(String nFich) throws FileNotFoundException {
        //Este método permite saber qual o número de linhas e colunas que tem o ficheiro

        Scanner fin = new Scanner(new File(nFich)); //Abre o ficheiro para leitura
        String linha, subLinha[];

        int lin_col[] = new int[2]; //Vector que irá conter o número de linhas e colunas do ficheiro

        int lin = 0, col = 0;

        while (fin.hasNextLine()) { //Enquanto não for fim de ficheiro faz
            linha = fin.nextLine();
            subLinha = linha.split(";");
            lin++; //conta(incrementa) o número de linhas
            col = subLinha.length; //Conta o número de colunas

        }
        lin_col[0] = lin;//A posição 0 representa o numero de linhas do ficheiro
        lin_col[1] = col; //A posição 1 representa o numero de colunas do ficheiro

        fin.close(); //Fecha a Leitura do Ficheiro

        return lin_col; //Retorna o vector lin_col que contém o número de linhas e colunas do ficheiro

    }

    private static float[][] lerFicheiro(String nFich) throws FileNotFoundException {
        Scanner fin = new Scanner(new File(nFich)); //Abertura do Ficheiro para Leitura
        String linha, subLinha[];

        int[] lin_col = new int[2]; //Vector que irá conter o número de linhas e colunas do ficheiro

        lin_col = saber_lin_col_ficheiro(nFich); //Retorna um vector que contem o número de linhas e colunas da matriz

        int lin = lin_col[0], col = lin_col[1]; //Atribuição às variáveis lin e col os respectivos valores de linhas e colunas

        float[][] matrizPrincipal = new float[lin][col]; //Criação da matriz Principal


        while (fin.hasNextLine()) { //Enquanto não for fim de fiheiro irá executar o código que se segue
            for (int i = 0; i < lin; i++) {
                linha = fin.nextLine(); //A variável linha contém a linha "i" do ficheiro
                subLinha = linha.split(";");//Separa cada valor para um vector quando encontra o caractér ";"
                for (int j = 0; j < col; j++) {
                    matrizPrincipal[i][j] = Float.parseFloat(subLinha[j].trim().replace(",", ".")); //Coloca o respectivo valor na matriz, eliminando os espaços e substituindo a "," por um ".", para não haver erro na introdução dos dados
                }
            }
        }
        fin.close(); //Fecha a leitura do Ficheiro

        return matrizPrincipal; //Retorna a Matriz

    }

    private static String abrirHtml() throws FileNotFoundException {

        return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\""
                + "\n \"http://www.w3.org/TR/html4/strict.dtd\">"
                + "\n <html> "
                + "\n <head><style type=\"text/css\">body {background-color:#F5F5DC}p {color:#7CFC00}</style>";
    }

    private static String abrirtitle(String titulo) throws FileNotFoundException {

        return "<title>" + titulo + "</title>"
                + "\n </head>"
                + "\n <body>";
    }

    private static String fecharHtml() throws FileNotFoundException {

        return "</body> "
                + "\n </html>";
    }

    private static String escrevertexto(String texto) throws FileNotFoundException {

        return "<p align=\"center\"><font color=\"#228B22\">" + texto + "</font></p>";
    }

    private static String escrevermatriz(float[][] matriz) throws FileNotFoundException {
        String texto = "<p align=\"center\"><table align=\"center\" border=1>";
        for (int i = 0; i < matriz.length; i++) {
            texto += "\n <tr>";
            for (int j = 0; j < matriz[0].length; j++) {
                texto += "<td><font size=\"4\" color=\"#1C1C1C\">" + matriz[i][j] + " </font></td>";
            }
            texto += "\n </tr>";
        }
        texto += "</table></p>";

        return texto;
    }

    private static float laplace(float[][] matrizPrincipal, int linMat_Principal, int colMat_Principal) {

        float matAux[][] = new float[matrizPrincipal.length - 1][matrizPrincipal[0].length - 1]; //Criação da matriz que irá conter o Menor Complementar
        float aux = 1;
        float mat_condensada[][] = new float[linMat_Principal][colMat_Principal]; //Criação da matriz que irá conter a matriz condensada
        float det = 0;

        //O código que se segue, permite calcular o menor complementar do determinante, cortando a 1º linha e a primeira coluna
        for (int i = 0; i < matrizPrincipal.length; i++) {
            for (int j = 0; j < matAux.length; j++) {
                for (int k = 0; k < matAux[0].length; k++) {
                    if (j == i) {
                        matAux[j][k] = matrizPrincipal[j + 1][k + 1];
                    } else if (j < i) {
                        matAux[j][k] = matrizPrincipal[j][k + 1];
                    } else {
                        matAux[j][k] = matrizPrincipal[j + 1][k + 1];
                    }
                }
            }

            if (matAux.length == 2) { //Se a matriz for de 2x2, irá ser calculadas as suas diagonais
                aux = matAux[0][0] * matAux[1][1] - matAux[0][1] * matAux[1][0];
            } else if (matAux.length == 3) { //Se a matriz for de 3x3, irá ser calculada através de sarrus
                aux = calcularSarrus(matAux); //A variável Aux irá conter o valor do determinante calculado através de Sarrus

            } else { //Se a matriz for maior que 3x3, a matriz será condensada e será chamado o método das propriedades para determinar o cálculo do determinante

                aux = propriedades(matAux, linMat_Principal, colMat_Principal);
            }
            det += (int) (matrizPrincipal[i][0] * Math.pow(-1, 1 + (i + 1))) * aux; //Cálculo do determinante
        }
        System.out.println("");
        System.out.println("");

        return det;
    }

    private static float[][] condensar(float matrizPrincipal[][], int linMat_Principal, int colMat_Principal, boolean matquad, String maior) {
        float aux;
        int indice = 0;

        float matAux[][] = new float[linMat_Principal][colMat_Principal]; //Criação da matriz auxiliar

        float factor;
        matAux = matPrincipal_to_matAux(matrizPrincipal, linMat_Principal, colMat_Principal); // Passa os valores da matriz principal para uma matriz auxiliar

        if (matAux[0][0] != 1 && (matAux[0][0]) != 0) { //Se a 1º posição da matriz for diferente de 1 e 0, vai dividir a 1º posição da matriz(e os restantes elementos da linha) por ela própria para dar 1.
            for (int i = 0; i < linMat_Principal; i++) {
                for (int j = 0; j < colMat_Principal; j++) {
                    matAux[0][j] = matAux[0][j] / matAux[0][0];
                }
            }
        } else if (matAux[0][0] == 0) { // Se a 1º posição for igual a zero faz

            for (int i = 0; i < linMat_Principal; i++) {
                if (matAux[i][0] != 0) { //Procura na 1º coluna, se algum elemento é diferente de zero e guarda a sua posição
                    indice = i;
                }
            }
            if (indice != 0) { //Se o indice for diferente de zero (1º posição) faz
                for (int j = 0; j < linMat_Principal; j++) {
                    for (int k = 0; k < colMat_Principal; k++) {
                        aux = matAux[0][k]; //Guarda o valor de cada coluna, sempre na 1ºlinha, em cada iteração do ciclo
                        matAux[0][k] = matAux[indice][0]; //Troca os valores
                        matAux[indice][0] = aux;
                    }
                }
                if (matAux[0][0] != 1) { //Se a 1º posição for diferente de 1, vai dividir a 1º posição da matriz( e os restantes elementos da linha) por ela própria para dar 1
                    for (int i = 0; i < linMat_Principal; i++) {
                        for (int j = 0; j < colMat_Principal; j++) {
                            matAux[0][j] = matAux[0][j] / matAux[0][0];
                        }
                    }
                }
            }
        }

        if (matquad == true) { //Se a matriz for quadrada faz:
            for (int k = 0; k < linMat_Principal - 1; k++) {
                for (int i = k + 1; i < linMat_Principal; i++) {
                    factor = (matAux[i][k] / matAux[k][k]); //Cálculo do factor, para posteriormente multiplicar e subtrair pela posição
                    for (int c = 0; c < colMat_Principal; c++) {
                        matAux[i][c] = matAux[i][c] - factor * matAux[k][c];
                    }
                }
            }
        } else if (matquad == false) { //Se a matriz não for quadrada faz:
            if (maior.equals("colunas")) { //Se a matriz tiver mais colunas que linhas faz: Cálculo do factor, para posteriormente multiplicar e subtrair pela posição. isto irá condensar
                for (int k = 0; k < linMat_Principal; k++) {
                    for (int i = k + 1; i < linMat_Principal; i++) {
                        factor = (matAux[i][k] / matAux[k][k]);
                        for (int c = 0; c < colMat_Principal; c++) {
                            matAux[i][c] = matAux[i][c] - factor * matAux[k][c];
                        }
                    }
                }
            } else if (maior.equals("linhas")) { //Se a matriz tiver mais linhas que colunas faz: Cálculo do factor, para posteriormente multiplicar e subtrair pela posição. isto irá condensar
                for (int k = 0; k < colMat_Principal; k++) {
                    for (int i = k + 1; i < linMat_Principal; i++) {
                        factor = (matAux[i][k] / matAux[k][k]);
                        for (int c = 0; c < colMat_Principal; c++) {
                            matAux[i][c] = matAux[i][c] - factor * matAux[k][c];
                        }
                    }
                }
            }
        }
        return matAux; //Retorna a matriz
    }

    private static float propriedades(float[][] matrizPrincipal, int linMat_Principal, int colMat_Principal) {
        float aux = 1;
        //Este método irá chamar o método condensar e depois irá multiplicar os pivots da matriz
        float matAux[][] = new float[linMat_Principal][colMat_Principal];
        matAux = condensar(matrizPrincipal, linMat_Principal, colMat_Principal, true, null);
        for (int i = 0; i < matAux.length; i++) {
            aux = aux * matAux[i][i];
        }
        return aux;
    }

    private static float[][] determinarMatrizIdentidade(float[][] matrizPrincipal, int linMatPrincipal, int colMatPrincipal) {
        //Criação das matrizes identidades e inversa. As colunas terão de ter o dobro do comprimento da matriz principal
        float matrizIdent[][] = new float[linMatPrincipal][colMatPrincipal * 2];
        float matrizInversa[][] = new float[linMatPrincipal][colMatPrincipal * 2];

        for (int i = 0; i < linMatPrincipal; i++) { //Passagem dos valores da matriz principal para a matriz identidade
            for (int j = 0; j < colMatPrincipal; j++) {
                matrizIdent[i][j] = matrizPrincipal[i][j];
            }
        }

        //Acrescentar a matriz identidade à matriz principal, para de seguida efectuar os devidos cálculos para a matriz inversa
        for (int i = 0; i < linMatPrincipal; i++) {
            for (int j = colMatPrincipal; j < colMatPrincipal * 2; j++) {
                if (j - colMatPrincipal == i) {
                    matrizIdent[i][j] = 1;
                } else {
                    matrizIdent[i][j] = 0;
                }
            }
        }
        matrizInversa = condensar(matrizIdent, linMatPrincipal, colMatPrincipal * 2, true, null); //Cálculo da condensação da parte de baixo dos pivots

        return matrizInversa;

    }

    private static void codificadorTexto(String nomefich, String texto, float[][] matriz, String titulo) throws FileNotFoundException {
        Formatter fout = new Formatter(new File(nomefich + ".html"));

        fout.format(abrirHtml());
        fout.format(abrirtitle(titulo));
        fout.format("<p align=\"left\"><img src=\"isep.jpg\"></p>");
        fout.format(escrevertexto("<h1 align=\"center\">" + titulo + "</h1>"));
        fout.format("<br>");
        fout.format("<br>");
        fout.format(escrevertexto("Matriz: "));
        fout.format(escrevermatriz(matriz));
        fout.format("<br>");
        fout.format("<br>");
        fout.format(escrevertexto("Resultado: "));
        fout.format(escrevertexto(texto));
        fout.format(fecharHtml());
        fout.close();
    }

    private static void codificadorMatriz(String nomefich, float[][] matriz, float[][] matriz2, String titulo) throws FileNotFoundException {
        Formatter fout = new Formatter(new File(nomefich + ".html"));

        fout.format(abrirHtml());
        fout.format(abrirtitle(titulo));
        fout.format("<p align=\"left\"><img src=\"isep.jpg\"></p>");
        fout.format(escrevertexto("<h1 align=\"center\">" + titulo + "</h1>"));
        fout.format("<br>");
        fout.format("<br>");
        fout.format(escrevertexto(" 1º Matriz: "));
        fout.format(escrevermatriz(matriz));
        fout.format("<br>");
        fout.format("<br>");
        fout.format(escrevertexto("2º Matriz: "));
        fout.format(escrevermatriz(matriz2));
        fout.format(fecharHtml());
        fout.close();


    }

    private static String escrevervector(float[] matriz) throws FileNotFoundException {
        String texto = "<p align=\"center\"><table align=\"center\" border=1>";

        texto += "\n <tr>";
        for (int j = 0; j < matriz.length; j++) {
            texto += "<td>" + matriz[j] + "</td>";
        }
        texto += "\n </tr>";

        texto += "</table></p>";

        return texto;
    }

    private static int respOutput() {
        int op;
        do {
            System.out.println("\n\nEscolha o Output pretendido:\n");
            System.out.println("1- Consola");
            System.out.println("2- Ficheiro HTML");
            System.out.print("\nEscolha a sua opção: ");
            op = ler.nextInt();
            if (op != 1 && op != 2) {
                System.out.println("\nOpção incorrecta! Por favor, escolha correctamente a opção prentendida"); //Em caso de erro na escolha da opção, será apresentada esta mensagem
            }
        } while (op != 1 && op != 2);
        System.out.println(""); //Linha em Branco

        return op;
    }
} //Fim do Main (Programa)

