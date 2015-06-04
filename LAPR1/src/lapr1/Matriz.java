package lapr1;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class Matriz {
//  Estas duas variáveis fixas determinam a ordem máxima das matrizes
    private static int LMAX = 20;
    private static int CMAX = 20;

    public static void main(String[] args) throws FileNotFoundException {
        Formatter Fout = new Formatter (new File ("LAPR1.html"));
        Scanner ler = new Scanner (System.in);
        String fichmatriz, nomefich;
        int op, sn, nLin=20, nCol=20, i=0, j=0;
        double mult;
        double [][] matriz1 = null;
        double [][] matriz2 = null;
        double [] vec1;
        double [] vecres;
        double [][] resultado;
        String nome;
        do{
            System.out.println("1  - Ler matriz ou matrizes a utilizar.\n"
                + "2  - Multiplicar vector por matriz.\n"
                + "3  - Calcular o produto de duas matrizes.\n"
                + "4  - Calcular a característica de uma matriz.\n"
                + "5  - Calcular a inversa de uma matriz. Técnica: Utilização da matriz identidade.\n"
                + "6  - Calcular a inversa de uma matriz. Técnica: Utilização da matriz adjunta.\n"
                + "7  - Calcular o determinante de uma matriz. Técnica: Sarrus.\n"
                + "8  - Calcular o determinante de uma matriz. Técnica: Teorema de Laplace.\n"
                + "9  - Calcular o determinante de uma matriz. Técnica: Propriedades.\n"
                + "10 - Calcular a transposta de uma matriz.\n"
                + "11 - Calcular o complemento algébrico de um elemento da matriz.\n"
                + "0 - Terminar\n");
        System.out.print("Qual a sua opção:");
//      op simboliza a escolha do utilizador, como há cases que têm outros case dentro op é lido no fim de cada escolha, não esquecer ao modificar
        op = ler.nextInt();
        if(op<0 || op>11){
            do{
                System.out.print("Opção inválida. Tente de novo: ");
                op= ler.nextInt();
            }while(op<=0 && op>11);
        }
        switch (op){
            case 1:
                System.out.print("Insira 1 para ler a(s) matriz(es) através de um ficheiro ou 2 para definir os valores manualmente:");
                op = ler.nextInt();
                do {
                    switch (op) {
                        case 1:
                            System.out.println("Qual o nome do ficheiro? (Inclua a extensão do mesmo.)");
                            ler.nextLine();
                            fichmatriz = ler.nextLine();
                            System.out.println(fichmatriz);
                            matriz1 = lerMatrizFicheiro(fichmatriz);
                            System.out.print("Deseja ler uma segunda matriz? Se sim, prima 1. Se não, prima 2.");
                            op = ler.nextInt();
                            do{
                                System.out.print("Opção Inválida. Tente novamente: ");
                                op = ler.nextInt();
                            }while(op!=1 && op!=2);
                            if(op == 1){
                                System.out.println("Deseja ler a Segunda matriz através de ficheiro?\n"
                                        + "Se sim, prima 1. Se não, prima 2.");
                                sn = ler.nextInt();
                                if(sn == 1){
                                    System.out.print("Qual o nome do ficheiro que contem a segunda matriz? O nome deve conter também a extensão do mesmo.");
                                    nomefich = ler.nextLine();
                                    matriz2 = lerMatrizFicheiro(nomefich);
                                }else{
                                    System.out.print("Quantas linhas tem a Matriz? Apenas deve introduzir matrízes com um máximo de 20 linhas/Colunas");
                                    nLin = ler.nextInt();
                                    if (nLin<0 || nLin>LMAX){
                                        System.out.print("O valor introduzido não é válido. Por favor tente novamente.");
                                        nLin = ler.nextInt();
                                    }
                                    System.out.print("Quantas colunas tem a Matriz? Apenas deve introduzir matrízes com um máximo de 20 linhas/Colunas");
                                    nCol = ler.nextInt();
                                    if (nLin<0 || nLin>LMAX){
                                        System.out.println("O valor introduzido não é válido. Por favor tente novamente.");
                                        nCol = ler.nextInt();
                                    }
                                    matriz2 = lerMatrizManual(nLin, nCol);
                                }
                            }
                            break;
                        case 2:
                            System.out.print("Qual o número de Linhas matriz que deseja introduzir? Apenas deve introduzir matrízes com um máximo de 20 linhas.");
                            nLin = ler.nextInt();
                            if (nLin<0 || nLin>LMAX){
                                System.out.println("O valor introduzido não é válido. Por favor tente novamente.");
                                nLin = ler.nextInt();
                            }
                            System.out.print("Qual o número de Colunas matriz que deseja introduzir? Apenas deve introduzir matrízes com um máximo de 20 Colunas");
                            nCol = ler.nextInt();
                            if (nLin<0 || nLin>LMAX){
                                System.out.println("O valor introduzido não é válido. Por favor tente novamente.");
                                nCol = ler.nextInt();
                            }
                            matriz1 = lerMatrizManual(nLin, nCol);
                            System.out.println("Deseja ler uma segunda matriz? Se sim, prima 1. Se não, prima 2.");
                            op = ler.nextInt();
                            if(op == 1){
                                System.out.println("Deseja ler a Segunda matriz através de ficheiro?\n"
                                        + "Se sim, prima 1. Se não, prima 2.");
                                sn = ler.nextInt();
                                if(sn == 1){
                                    System.out.println("Qual o nome do ficheiro que contem a segunda matriz? O nome deve conter também a extensão do mesmo.");
                                    nomefich = ler.nextLine();
                                    matriz2 = lerMatrizFicheiro(nomefich);
                                }else{
                                    System.out.println("Quantas linhas tem a Matriz?");
                                    nLin = ler.nextInt();
                                    System.out.println("Quantas colunas tem a Matriz?");
                                    nCol = ler.nextInt();
                                    matriz2 = lerMatrizManual(nLin, nCol);
                                }
                            }
                            break;
                        default:
                    }
                } while (op < 1 || op > 2);
                retornarMenu();
                break;
            case 2:
                System.out.println("Qual o número de elementos do vector?");
                nCol = ler.nextInt();
                if (nCol<=0 || nCol>CMAX){
                    do{
                        System.out.println("O valor introduzido não é válido. Deverá introduzir um valor compreendido entre 0 e 20.");
                        nCol = ler.nextInt();
                    }while(nCol <=0 || nCol>CMAX);
                }
                if (nCol != matriz1[0].length){
                    System.out.println("ERRO: O número de rlementos do vector deve ser igual ao número de linhas da matriz, caso contrário não é possível efectuar a multiplicação.");
                }else{
                    vec1 = preencherVec(nCol);
                    Fout.format("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \n \"http://www.w3.org/TR/html4/strict.dtd\" > \n <html> \n <head> \n <title> MULTIPLICAR MATRIZ POR VECTOR </title> \n </head> \n <body> \n MATRIZ: \n <table border=1> \n ");
                    for (i=0; i<matriz1.length;i++){
                        Fout.format("<tr> \n ");
                        for (j=0; j<matriz1[0].length; j++){
                            Fout.format("<th>" + matriz1[i][j] +"</th>\n");
                        }
                        Fout.format("</tr> \n ");
                    }
                    Fout.format("</tr>\n </table> \n  VECTOR: \n <table border=1> \n <tr> \n ");
                    for (i=0; i<vec1.length; i++){
                        Fout.format("<th>" + vec1[i] +"</th>\n");
                    }
                    Fout.format("</tr>\n </table> \n  RESULTADO: \n <table border=1> \n <tr> \n ");
                    vecres = multiplicarMatVec(matriz1, vec1);
                    for (i=0; i<vecres.length; i++){
                        Fout.format("<th>" + vecres[i] +"</th>\n");
                    }
                    Fout.format("</tr>\n </table>");
                    Fout.close();
                    mostrarVec(vecres);
                }
                retornarMenu();
                break;
            case 3:
                multiplicarMatrizes(matriz1, matriz2);
                retornarMenu();
                break;
            case 4:
                double [][] car = condensar(matriz1);
                caracteristica(car);
                retornarMenu();
                break;
            case 5:
                inversaIdentidade(matriz1);
                retornarMenu();
                break;
            case 6:
                InversaAdjunta(matriz1);
                retornarMenu();
                break;
            case 7:
                calcularSegundoSarrus(matriz1);
                retornarMenu();
                break;
            case 8:
                laplace(matriz1, nLin, nCol, i, j);
                retornarMenu();
                break;
            case 9:
                mult = 1;
                detmatrizPropriedades(matriz1, mult);
                System.out.println("A caracteristica da matriz é:" + mult);
                retornarMenu();
                break;
            case 10:
                resultado = transposta(matriz1);
                mostrarMatriz(resultado);
                retornarMenu();
                break;
            case 11:
                mult = 1;
                complementoAlgebrico(matriz1, mult,i,j);
                retornarMenu();
                break;
        }
        }while (op!=0);
    }

    private static double [][] lerMatrizManual (int nLin, int nCol){
        double [][] matriz1 = new double [nLin][nCol];
        int i, j, valor;
        Scanner ler = new Scanner (System.in);
        for (i=0; i<nLin;i++){
            for (j=0; j<nCol; j++){
                System.out.println("Qual o valor da posição: Linha "+(i+1)+" Coluna "+(j+1));
                matriz1[i][j]=ler.nextInt();
            }
        }
        return matriz1;
    }

    private static double [] preencherVec ( int nCol){
        double[] vec = new double [nCol];
        Scanner ler = new Scanner (System.in);
        int i;
        for(i=0; i<nCol; i++){
            System.out.println("Qual o valor que pretende introduzir na posição " + (i+1) + "?: ");
            vec[i] = ler.nextDouble();
        }
        return vec;
    }

    private static void retornarMenu(){
//      Este método serve simplesmente para que o programa não termine após a conclusão de um método
        Scanner ler = new Scanner (System.in);
        System.out.println("Prima Enter para retornar ao menu");
        ler.nextLine();
    }

    private static double [][] lerMatrizFicheiro (String fichmatriz) throws FileNotFoundException{
        Scanner fIn = new Scanner(new File(fichmatriz));
        String linha;
        String [] temp;
        int nLin, nCol=0, c=-1, i;
        nLin = numeroLinhasFicheiro(fichmatriz);
        while (fIn.hasNextLine()){
            linha = fIn.nextLine();
            temp = linha.split(";");
            nCol = temp.length;
        }
        double [][]matriz1 = new double [nLin][nCol];
        while (fIn.hasNextLine()){
            c=c+1;
            linha = fIn.nextLine();
            temp = linha.split(";");
            for(i=0; i<nCol; i++){
                matriz1 [c][i] = Integer.parseInt(temp[i]);
            }
        }
        fIn.close();
        return matriz1;
    }

    private static int numeroLinhasFicheiro (String fichmatriz) throws FileNotFoundException{
        Scanner fIn = new Scanner (new File (fichmatriz));
        int nLin=0;
        String linha;
        while (fIn.hasNextLine()){
            linha = fIn.nextLine();
            nLin = nLin + 1;
        }
        return nLin;
    }

    private static double [] multiplicarMatVec (double [][] matriz1, double [] vec) throws FileNotFoundException{
        int i,j, nCol;
        double soma;
        double [] vecfinal = new double [matriz1[0].length];
        for (i=0; i<matriz1[0].length; i++){
            soma =0;
            for (j=0; j<vec.length; j++){
                soma = soma + (vec[j]*matriz1[i][j]);
            }
            vecfinal[i]=soma;
        }
        return vecfinal;
        }

    private static void mostrarVec (double [] vecfinal){
        int i;
        for (i=0; i<vecfinal.length; i++){
            System.out.println("Posição "+(i+1)+": "+vecfinal[i]);
        }
    }

    private static double [][] multiplicarMatrizes(double[][] matriz1, double[][] matriz2) throws FileNotFoundException {
//      A multiplicação das matrizes não tem a sua verificação feita no início mas está contida na linha 323
        Formatter Fout = new Formatter (new File("LAPR1"));
        String resultado;
        int nLin1, nLin2, nCol2, nCol1, i, j;
        Fout.format("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \n \"http://www.w3.org/TR/html4/strict.dtd\" > \n <html> \n <head> \n <title> MULTIPLICAR MATRIZES </title> \n </head> \n <body> \n MATRIZ 1: \n <table border=1> \n ");
        for (i=0; i<matriz1.length;i++){
              Fout.format("<tr> \n ");
              for (j=0; j<matriz1[0].length; j++){
                   Fout.format("<th>" + matriz1[i][j] +"</th>\n");
              }
              Fout.format("</tr> \n ");
        }
        Fout.format("</table> \n MATRIZ 2: \n <table border=1> \n ");
        for (i=0; i<matriz2.length;i++){
              Fout.format("<tr> \n ");
              for (j=0; j<matriz2[0].length; j++){
                   Fout.format("<th>" + matriz2[i][j] +"</th>\n");
              }
              Fout.format("</tr> \n ");
        }
        Fout.format("</table>\n");
        nLin1 = matriz1.length;
        nLin2 = matriz2.length;
        nCol2 = matriz2[0].length;
        nCol1 = matriz1[0].length;
        double [][] matRes = new double [nLin1][nCol2];
        if (nCol1!=nLin2){
            System.out.println("Não é possível efectuar a multiplicação das matrizes porque o número de colunas da matriz 1 é diferente do número de linhas da matriz 2");
        }else{
            for (i = 0; i < nLin1; i++) {
                for (j = 0; j < nCol2; j++) {
                    matRes [i][j] = 0;
                    resultado = " ";
                    for (int k = 0; k < nCol1; k++) {
                        matRes[i][j] = matRes [i][j] + (matriz1[i][k] * matriz2[k][j]);
                        if(k==0){
                            resultado+="" + matriz1[i][k]+"x"+matriz2[k][j];
                        }else {
                            resultado+="+"+matriz1[i][k]+"x"+matriz2[k][j];
                        }
                    }
                    System.out.println("Linha "+(i+1)+" Coluna "+(j+1)+":"+resultado+"="+matRes[i][j]);
                }
            }
        }
        Fout.format("</table> \n RESULTADO: \n <table border=1> \n ");
        for (i=0; i<matRes.length;i++){
              Fout.format("<tr> \n ");
              for (j=0; j<matRes[0].length; j++){
                   Fout.format("<th>" + matRes[i][j] +"</th>\n");
              }
              Fout.format("</tr> \n ");
        }
        Fout.format("</table>\n </body> \n </html>");
        Fout.close();
        return matRes;
    }

    private static void mostrarMatriz(double [][] matriz){
        int i, j;
        for (i=0; i<matriz.length; i++){
            for (j=0; j<matriz[0].length; j++){
                System.out.println("Linha "+ (i+1) + " Coluna " + (j+1)+ ": " + matriz[i][j]);
            }
        }
    }

    private static double [][] condensar (double [][] matriz1){
//      condensar não é o método de eliminação de gauss, para isso utiliza-se este método em conjunto com outro, para que código possa ser reutilizado
        int i, j, k;
        double f;
        matriz1 = elementosDiferentesZero(matriz1);
        for(i=0; i<matriz1[0].length;i++){
            for (k=i+1; k<matriz1.length; k++){
                if(matriz1[k][i] == matriz1[i][i]){
                    for(j=0; j<matriz1[0].length; j++){
                        matriz1[k][j] = matriz1[k][j]- matriz1[k-1][j];
                    }
                }else if(matriz1[k][i]== 0){
                    
                }else if(matriz1[k][i]!= matriz1[i][i]){
                    f = matriz1[k][i]/matriz1[i][i];
                    for (j=0; j<matriz1[0].length; j++){
                        matriz1[k][j] = matriz1[k][j] - (f*matriz1[i][j]);
                    }
                }
            }
        }
        return matriz1;
    }

    private static double [][] condensarSuperior (double [][] matriz1){
        int i, j, k;
        double f;
        for(i=matriz1[0].length/2-1; i>0;i--){
            for (k=matriz1.length-1; k>=0; k--){
                if(matriz1[k][i] == matriz1[i][i]){
                    for(j=0; j<matriz1[0].length; j++){
                        matriz1[k][j] = matriz1[k][j]- matriz1[i][j];
                    }
                }else if(matriz1[k][i]== 0){
                }else if(matriz1[k][i]!= matriz1[i][i]){
                    f = matriz1[k][i]/matriz1[i][i];
                    for (j=0; j<matriz1[0].length; j++){
                        matriz1[k][j] = matriz1[k][j] - (f*matriz1[i][j]);
                    }
                }
            }
        }
        return matriz1;
    }

    private static double [][] elementosDiferentesZero (double [][] matriz1){
        int i, j;
        double temp = 0;
        if(matriz1.length < matriz1[0].length){
            for (i=0; i<matriz1.length; i++){
                if (i==0 && matriz1[i][i] == 0){
                    for (j=0; j<matriz1[0].length; j++){
                        matriz1[i][j] = temp;
                        matriz1[i][j] = matriz1[i][(matriz1.length -1)];
                    }
                }else if (i>0 && matriz1[i][i] == 0){
                    for (j=0; j<matriz1[0].length; j++){
                        matriz1[i][j] = temp;
                        matriz1[i][j] = matriz1[j][i-1];
                    }
                }
            }
        } else if(matriz1.length > matriz1[0].length){
            for (i=0; i<matriz1[0].length; i++){
                if (i==0 && matriz1[i][i] == 0){
                    for (j=0; j<matriz1[0].length; j++){
                        matriz1[i][j] = temp;
                        matriz1[i][j] = matriz1[j][(matriz1.length -1)];
                    }
                }else if (i>0 && matriz1[i][i] == 0){
                    for (j=0; j<matriz1[0].length; j++){
                        matriz1[i][j] = temp;
                        matriz1[i][j] = matriz1[j][i-1];
                    }
                }
            }
        } else if(matriz1.length == matriz1[0].length){
            for (i=0; i<matriz1.length; i++){
                if (i==0 && matriz1[i][i] == 0){
                    for (j=0; j<matriz1[0].length; j++){
                        matriz1[i][j] = temp;
                        matriz1[i][j] = matriz1[j][(matriz1.length -1)];
                    }
                }else if (i>0 && matriz1[i][i] == 0){
                    for (j=0; j<matriz1[0].length; j++){
                        matriz1[i][j] = temp;
                        matriz1[i][j] = matriz1[j][i-1];
                    }
                }
            }
        }
        return matriz1;
    }

    private static void caracteristica (double [][] matriz1){
       int i, c=0;
       if(matriz1.length < matriz1[0].length){
            for (i=0; i<matriz1.length; i++){
                if (matriz1[i][i] !=0){
                    c++;
                }
            }
       } else if(matriz1.length > matriz1[0].length){
            for (i=0; i<matriz1[0].length; i++){
                if (matriz1[i][i]!=0){
                    c++;
                }
            }
       } else if(matriz1.length == matriz1[0].length){
            for (i=0; i<matriz1.length; i++){
                if (matriz1[i][i]!=0){
                    c++;
                }
            }
       }
       System.out.println("A característica da matriz introduzida é :" + c);
    }

    private static void calcularSegundoSarrus (double [][] matriz1) throws FileNotFoundException{
        Formatter Fout = new Formatter (new File ("LAPR1"));
        double car;
        int i, j;
        if (matriz1[0].length == 3 && matriz1.length == 3){
            Fout.format("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \n \"http://www.w3.org/TR/html4/strict.dtd\" > \n <html> \n <head> \n <title> MULTIPLICAR MATRIZ POR VECTOR </title> \n </head> \n <body> \n MATRIZ: \n <table border=1> \n ");
            for (i=0; i<matriz1.length;i++){
                 Fout.format("<tr> \n ");
                 for (j=0; j<matriz1[0].length; j++){
                        Fout.format("<th>" + matriz1[i][j] +"</th>\n");
                 }
                 Fout.format("</tr> \n ");
            }
            Fout.format("</tr>\n </table> \n  RESULTADO; \n");
            car = matriz1[0][0]*matriz1[1][1]*matriz1[2][2] + matriz1[1][0]*matriz1[2][1]*matriz1[0][2]+matriz1[2][0]*matriz1[0][1]*matriz1[1][2] - (matriz1[0][2]*matriz1[1][1]*matriz1[2][0]+matriz1[1][2]*matriz1[2][1]*matriz1[0][0]+matriz1[2][2]*matriz1[0][1]*matriz1[1][0]);
            System.out.println( matriz1[0][0]+ " x "+ matriz1[1][1] + " x " + matriz1[2][2] + " + " + matriz1[1][0] + " x " + matriz1[2][1] + " * " + matriz1[0][2]+ " + " + matriz1[2][0] + " x " + matriz1[0][1] + " x " + matriz1[1][2] + " - (" + matriz1[0][2] + " * " + matriz1[1][1] + " x " + matriz1[0][0] + " + " + matriz1[1][2] + " x " + matriz1[2][1] + " x " + matriz1[0][0] + " + " + matriz1[2][2] + " x " + matriz1[0][1] + " x " + matriz1[1][0] + ") = " + car);
            Fout.format(matriz1[0][0]+ " x "+ matriz1[1][1] + " x " + matriz1[2][2] + " + " + matriz1[1][0] + " x " + matriz1[2][1] + " * " + matriz1[0][2]+ " + " + matriz1[2][0] + " x " + matriz1[0][1] + " x " + matriz1[1][2] + " - (" + matriz1[0][2] + " * " + matriz1[1][1] + " x " + matriz1[0][0] + " + " + matriz1[1][2] + " x " + matriz1[2][1] + " x " + matriz1[0][0] + " + " + matriz1[2][2] + " x " + matriz1[0][1] + " x " + matriz1[1][0] + ") = " + car +"\n");
            Fout.close();
        }else {
            System.out.println("Não é possível calcular o determinante da matriz segundo Sarrus, porque a matriz introduzida não é de Ordem 3.");
        }
    }

    private static double detmatrizPropriedades(double[][] matriz1, double mult) {
//      mult foi inicializado a "1" fora do método no seu case, caso queira mudá-lo
        condensar(matriz1);
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                if (i == j) {
                    mult = mult * (matriz1[i][j]);
                }
            }
        }
        return mult;
    }

    private static double [][] transposta (double [][] matriz1){
        int i, j;
        double transposta[][] = new double[matriz1[0].length][matriz1.length];
        for (i = 0; i < matriz1.length; i++) {
            for (j = 0; j < matriz1[0].length; j++) {
                transposta[i][j] = matriz1 [j][i];
            }
        }
        return transposta;
    }

    private static void complementoAlgebrico(double[][] matriz1, double mult, int i, int j) {
        Scanner in = new Scanner(System.in);
        double[][] matriz3 = new double[matriz1.length - 1][matriz1[0].length - 1];
//      A eliminação da linha e coluna involvem a passagem de 8 variaveis diferentes, e nem todas sao inicializadas à mesma altura, verifique se todas elas estão acertadas ao modificar o codigo
        int m, n, l=0,c=0;
        double el, compl;
        if (matriz1.length == matriz1[0].length) {
            System.out.println("Coloque em que linha se encontra o elemento que deseja calcular o complemento algébrico");
            m = in.nextInt()-1;
            System.out.println("Coloque em que coluna se encontra o elemento que deseja calcular o complemento algébrico");
            n = in.nextInt()-1;
            el = matriz1[m][n];
            eliminarlincol(m,n,j,i,matriz3,l,c, matriz1);
            compl = detmatrizPropriedades(matriz3, mult);
            if (((m+n)%2)==1) {
                compl=-compl;
            }
            System.out.println("O complemento algébrico é:" + compl);
        } else {
            System.out.println("A matriz que vocz introduziu tem de ser quadrada.");
        }
    }

    private static void eliminarlincol(int m, int n, int j, int i, double matriz3[][],int c, int l, double [][] matriz1) {
        for (j = 0; j < matriz3[0].length; j++) {
           if (j == m) {
               continue;
           }
           if (j < m) {
               l = j;
           }else {
                l = j - 1;
            }
            for (i = 0; i < matriz3[0].length; i++) {
                if (i == n) {
                    continue;
                }
                if (i < n) {
                    c = i;
                } else {
                    c = i - 1;
                }
                matriz3[l][c]=matriz1[j][i];
            }
        }
    }

    private static void InversaAdjunta ( double [][] matriz1){
        double [][] adjunta = new double [matriz1.length][matriz1[0].length*2];
        int i, j, k;
        double f;
        for(i=0; i<adjunta.length; i++){
            for(j=0; j<adjunta[0].length/2; j++){
                if(j<matriz1[0].length){
                    adjunta[j][i] = matriz1[j][i];
                }
            }
        }
        for(i=0; i<adjunta.length; i++){
            for(j=0; j<matriz1.length; j++){
                if(j==i){
                    adjunta[i][(j+matriz1[0].length)] = 1;
                }else{
                    adjunta[i][(j+matriz1[0].length)] = 0;
                }
            }
        }
//      Três métodos estão a ser utilizados em sequência para o mesmo valor porque estes métodos podem ser encadeados, ao mudar variáveis de todos os três tenha cuidado com resultados inesperados deste método
        adjunta = elementosDiferentesZero(adjunta);
        adjunta = condensar(adjunta);
        adjunta = condensarSuperior(adjunta);
        for (i=0; i<matriz1.length;i++){
            f = adjunta[i][i];
            if(adjunta[i][i] == 1){

            } else{
                for(k=0; k<adjunta[0].length; k++){
                    adjunta[i][k] = adjunta[i][k]/f;
                }
            }
        }
        for (i=0; i<matriz1.length; i++){
            for (j=matriz1[0].length/2; j<matriz1[0].length; j++){
                System.out.println("Linha "+ (i+1) + " Coluna " + (j+1)+ ": " + matriz1[i][j]);
            }
        }
    }

    private static void inversaIdentidade(double[][] matriz1) {
        int i, j, k;
        double f;
//      Constrói matriz identidade
        double[][] identidade = new double[matriz1.length][matriz1[0].length];
        for (i = 0; i < matriz1[0].length; i++) {
            for (j = 0; j < matriz1.length; j++) {
                if (i==j) {
                    identidade[i][j] = 1;
                }else {
                    identidade[i][j] = 0;
                 }
            }
            identidade = elementosDiferentesZero(identidade);
            identidade = condensar(identidade);
            identidade = condensarSuperior(identidade);
        }
    }

       private static void laplace(double[][] matriz1, int nLin, int nCol, int i, int j) throws FileNotFoundException {
        double comp=0, car=0, total;
        int l=0, c=0;
        double[][] matriz3 = new double[matriz1.length - 1][matriz1[0].length - 1];
           for (int m = 0; m < nLin-4; m++) {
               for (int n= 0; n < nCol-4; n++) {
                   eliminarlincol(m,n,j,i,matriz3,l,c, matriz1);
                   comp = comp + (matriz1[m][n] * Math.pow(-1, 1 + i + 1));
               }
           }
           car = matriz1[0][0]*matriz1[1][1]*matriz1[2][2] + matriz1[1][0]*matriz1[2][1]*matriz1[0][2]+matriz1[2][0]*matriz1[0][1]*matriz1[1][2] - (matriz1[0][2]*matriz1[1][1]*matriz1[2][0]+matriz1[1][2]*matriz1[2][1]*matriz1[0][0]+matriz1[2][2]*matriz1[0][1]*matriz1[1][0]);
           total = comp * car;
    }
}