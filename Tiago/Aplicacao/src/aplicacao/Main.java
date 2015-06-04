package aplicacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
/**
 *
 * @author Tiago
 */
public class Main {
    static int maxmaquinas=80;
    static Scanner ler=new Scanner(System.in);
    static Formatter out=new Formatter(System.out);

    public static void menu(){
        System.out.println("");
        System.out.println("---------------------MENU----------------------");
        System.out.println("a - Ler do ficheiro de texto, maquinas.txt, a informação base sobre todas as máquinas da linha de produção, da empresa, e carregá-la em memória;");
        System.out.println("b - Mostrar no ecrã a informação base de uma máquina;");
        System.out.println("c - Guardar a informação base existente em memória para um ficheiro de texto com a mesma estrutura do ficheiro de leitura;");
        System.out.println("d - Inserir a produtividade das máquinas num determinado dia da semana;");
        System.out.println("e - Listar no ecrã toda a informação existente em memória;");
        System.out.println("f - Imprimir num ficheiro de texto a produção semanal, por tipo de máquina;");
        System.out.println("g - Ordenar toda a informação que reside em memória organizada por código da máquina (ordem alfabética);");
        System.out.println("h - Ordenar toda a informação que reside em memória organizada por ordem decrescente da produtividade semanal;");
        System.out.println("i - Remover da estrutura de dados toda a informação relativa a uma máquina que foi retirada da linha de produção;");
        System.out.println("j - Mostrar, para cada máquina, o(s) dia(s) da semana em que o total de horas de produção foi maior e o(s) dia(s) em que foi menor.");
        System.out.println("k - Inserir a produtividade (em horas) das máquinas num determinado dia da semana. Para terminar introduza o código de máquina 000.");
        System.out.println("s - Sair do programa;");
        System.out.println("Introduza a opção:");
    }

    public static int guardaInf(String x, String [] codigo, int [] cap, int n){ //guardar info nos vectores
        String[] temp= x.split(",");
        codigo[n]=temp[0].trim();
        cap[n]= Integer.parseInt(temp[1]);
        return (n+1);
    }

    private static int ler(String nomeficheiro, String [] codigo, int[]capProdutiva) throws FileNotFoundException{ //ler info do ficheiro
        Scanner in=new Scanner(new File(nomeficheiro));
        int n=0;
        while (in.hasNextLine() && n<maxmaquinas){
            n=guardaInf(in.nextLine(),codigo,capProdutiva,n);
        }
        in.close();
        return n;
    }

    private static int pesquisaMaquinas(int n, String ocodigo, String[]codigo){
        int aux = -1;
        for(int i=0;i<n;i++){
            if(codigo[i].trim().toLowerCase().equals(ocodigo.trim().toLowerCase())){
                aux=i;
                break;
            }
        }
        return aux;
    }

    private static void mostrarinfo(int posicao,String []codigo,int[]capProdutiva){ //mostra a capacidade produtiva de 1 maquina
        if(posicao>=0 && posicao<maxmaquinas){
            out.format("codigo\tcapProdutiva%n");
            out.format("%s\t%d%n",codigo[posicao],capProdutiva[posicao]);
        }
        else{
            out.format("Maquina Desconhecida");
        }
    }

    private static void escreverficheiro(String[]codigo, int[]capProdutiva, String nomeficheiro, int n) throws FileNotFoundException{
        Formatter output=new Formatter(new File(nomeficheiro));
        for(int i=0;i<n;i++){
            output.format("%s,%d%n",codigo[i],capProdutiva[i]);
        }
            output.close();
    }

    private static void dias_semana(String nomeficheiro, String [] codigo, float [][] produtividade,int nummaquinas) throws FileNotFoundException{ //ler info dos ficheiros de cada dia da semana
        nomeficheiro=nomeficheiro.toLowerCase();
        int dia=-1;
        if(nomeficheiro.equals("domingo.txt"))
            dia=0;
        if(nomeficheiro.equals("segunda.txt"))
            dia=1;
        if(nomeficheiro.equals("terca.txt"))
            dia=2;
        if(nomeficheiro.equals("quarta.txt"))
            dia=3;
        if(nomeficheiro.equals("quinta.txt"))
            dia=4;
        if(nomeficheiro.equals("sexta.txt"))
            dia=5;
        if(nomeficheiro.equals("sabado.txt"))
            dia=6;
        ordenar_info_codigo(nummaquinas,codigo,produtividade);
        if(dia>-1){
            Scanner asd=new Scanner(new File(nomeficheiro));
            float prod;
            int i=0;
            while(asd.hasNext()){
                String[] temp= asd.nextLine().split(",");
                prod= Float.parseFloat(temp[1]);
                produtividade[i][dia]=prod;
                i++;
            }
            asd.close();
        }
        else
            System.out.println("Dia nao existe");
    }
    
    public static void mostrarmatriz(int n, String []codigo, int[]capacidade, float [][]produtividade){
        System.out.println("Codigo\tCap-producao\tDomingo\tSeg\tTerca\tQuarta\tQuinta\tSexta\tSabado");
        for(int i=0;i<n;i++){
            System.out.println("");
            System.out.print(codigo[i]+"\t"+capacidade[i]);
            for(int j=0;j<7;j++){
                System.out.print("\t"+produtividade[i][j]);
            }
        }
    }

    public static String tipomaquina(String tipomaq){
        String nomecompleto="Desconhecido";
        if(tipomaq.equals("CO"))
            nomecompleto="Cortar";
        else
            if(tipomaq.equals("FU"))
                nomecompleto="Furar";
            else
                if(tipomaq.equals("PR"))
                    nomecompleto="Prensar";
        return nomecompleto;
    }

    public static void imprimir(String tipomaq, int n,String[]codigo, int[] capacidade, float[][] produtividade){
        int soma_cap_prod_semanal=0, cap_prod_semanal;
        float produtividade_semanal, soma_produtividade_semanal=0, desvio, soma_desvio=0;
        out.format("Mapa de produção semanal das máquinas do Tipo:%s%n%n",tipomaquina(tipomaq));
        out.format("Código Máquina\tCapac. Prod. Sem.\tProd. Semanal\tDesvio Produção%n");
        out.format("--------------------------------------------------------------------------------------------------%n");
        for(int i=0;i<n;i++){
            if(codigo[i].substring(0,2).toUpperCase().equals(tipomaq)){
                cap_prod_semanal=capacidade[i]*7;
                out.format("%s\t\t%d",codigo[i],cap_prod_semanal);
                soma_cap_prod_semanal+=cap_prod_semanal;
                produtividade_semanal=0;
                for(int j=0;j<7;j++){
                    produtividade_semanal+=produtividade[i][j];
                }
                soma_produtividade_semanal+=produtividade_semanal;
                desvio=produtividade_semanal-cap_prod_semanal;
                soma_desvio+=desvio;
                out.format("\t\t\t%.2f\t\t%.2f%n",produtividade_semanal,desvio);
            }
        }
        out.format("--------------------------------------------------------------------------------------------------%n");
        out.format("\t\t\t%d\t\t\t%.2f\t\t%.2f%n",soma_cap_prod_semanal,soma_produtividade_semanal,soma_desvio);
    }

    public static void ordenar_info_codigo(int n,String []codigo, float [][] produtividade){
        String x;
        float z;
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++)
                if(codigo[i].compareTo(codigo[j])>0){
                   x=codigo[i];
                   codigo[i]=codigo[j];
                   codigo[j]=x;
                   for(int k=0;k<7;k++){
                       z=produtividade[i][k];
                       produtividade[i][k]=produtividade[j][k];
                       produtividade[j][k]=z;
                   }
                }
    }

    public static void ordenar_info_prod(int n,String []codigo, float [][] produtividade){
        float [] prod_semanal=new float[n]; // no fim da funcao as producoes semanais nao vao estar ligadas as suas maquinas
        float soma_prod;
        for(int i=0;i<n;i++){
            soma_prod=0;
            for(int j=0;j<7;j++)
                soma_prod+=produtividade[i][j];
            prod_semanal[i]=soma_prod;
        }
        String x;
        float z;
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++)
                if(prod_semanal[i]>prod_semanal[j]){
                   x=codigo[i];
                   codigo[i]=codigo[j];
                   codigo[j]=x;
                   for(int k=0;k<7;k++){
                       z=produtividade[i][k];
                       produtividade[i][k]=produtividade[j][k];
                       produtividade[j][k]=z;
                   }
                }
    }

    public static int remover_maquina(int n, int pos, String []codigo, float [][] produtividade){
        for(int i=pos;i<n-1;i++)
            for(int j=i+1;j<n;j++){
               codigo[i]=codigo[j];
               for(int k=0;k<7;k++)
                   produtividade[i][k]=produtividade[j][k];
            }
        codigo[n-1]=null;
        for(int i=0;i<7;i++)
            produtividade[n-1][i]=0;
            return(n-1);
    }

    public static void dia_prod_maior_menor(int n, String[]codigo, float[][]produtividade){
        for(int i=0;i<n;i++){
            System.out.println("Máquina "+codigo[i]+":");
            float maior=0;
            float menor=24;
            for(int j=0;j<7;j++){
                if(produtividade[i][j]>maior)
                    maior=produtividade[i][j];
                if(produtividade[i][j]<menor)
                    menor=produtividade[i][j];
            }
            System.out.println("Dia(s) com mais horas de produção:");
            for(int j=0;j<7;j++){
                if(produtividade[i][j]==maior){
                    if(j==0)
                        System.out.println("Domingo");
                    if(j==1)
                        System.out.println("Segunda");
                    if(j==2)
                        System.out.println("Terca");
                    if(j==3)
                        System.out.println("Quarta");
                    if(j==4)
                        System.out.println("Quinta");
                    if(j==5)
                        System.out.println("Sexta");
                    if(j==6)
                        System.out.println("Sabado");
                }
            }
            System.out.println("Dia(s) com menos horas de produção:");
            for(int j=0;j<7;j++){
                if(produtividade[i][j]==menor){
                    if(j==0)
                        System.out.println("Domingo");
                    if(j==1)
                        System.out.println("Segunda");
                    if(j==2)
                        System.out.println("Terca");
                    if(j==3)
                        System.out.println("Quarta");
                    if(j==4)
                        System.out.println("Quinta");
                    if(j==5)
                        System.out.println("Sexta");
                    if(j==6)
                        System.out.println("Sabado");
                }
            }
        }
    }

    public static void inserir_produtividade(int n, String[]codigo, float[][]produtividade){
        System.out.println("Introduza o dia da semana:");
        String nomedia=ler.next();
        int dia=-1;
        if(nomedia.toLowerCase().equals("domingo"))
            dia=0;
        if(nomedia.toLowerCase().equals("segunda"))
            dia=1;
        if(nomedia.toLowerCase().equals("terça"))
            dia=2;
        if(nomedia.toLowerCase().equals("quarta"))
            dia=3;
        if(nomedia.toLowerCase().equals("quinta"))
            dia=4;
        if(nomedia.toLowerCase().equals("sexta"))
            dia=5;
        if(nomedia.toLowerCase().equals("sábado"))
            dia=6;
        System.out.println("Introduza o código da máquina:");
        String cod=ler.next();
        while(!cod.equals("000")){
            int posicao=pesquisaMaquinas(n,cod,codigo);
            if(posicao==-1)
                System.out.println("Máquina não existe!");
            else{
                System.out.println("Introduza a produtividade (em horas)");
                float prod=ler.nextFloat();
                produtividade[posicao][dia]=prod;
            }
            System.out.println("Introduza o código da máquina:");
            cod=ler.next();
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        String [] codigo= new String [maxmaquinas];
        int [] capProdutiva= new int[maxmaquinas];
        float [][] produtividade=new float [maxmaquinas][7];           //dia 0 e Domingo
        
       
        int nummaquinas=10;
        char opcao='z';
        do{
            menu();
            opcao=ler.next().charAt(0);
            switch(opcao){
                case 'a':
                    out.format("Nome do ficheiro:");
                    nummaquinas=ler(ler.next()+".txt",codigo,capProdutiva);
                    break;
                case 'b':
                    System.out.println("Introduza o codigo que pretende procurar:");
                    String ocodigo=ler.next();
                    int posicao=pesquisaMaquinas(nummaquinas,ocodigo,codigo);
                    mostrarinfo(posicao,codigo,capProdutiva);
                    break;
                case 'c':
                    System.out.println("Introduza o nome do ficheiro para o qual pretende guardar os dados:");
                    String nomeficheiro=ler.next();
                    escreverficheiro(codigo,capProdutiva,nomeficheiro,nummaquinas);
                    break;
                case 'd':
                    System.out.println("Nome do dia da Semana:");
                    String dia=ler.next()+".txt";
                    dias_semana(dia,codigo,produtividade,nummaquinas);
                    break;
                case 'e':
                    mostrarmatriz(nummaquinas,codigo,capProdutiva,produtividade);
                    break;
                case 'f':
                    String tipomaquina;
                    do{
                        System.out.println("Introduza o tipo de máquina:");
                        tipomaquina=ler.next().toUpperCase();
                    }while(!tipomaquina.matches("CO|PR|FU"));
                    imprimir(tipomaquina, nummaquinas,codigo,capProdutiva,produtividade);
                    break;
                case 'g':
                    ordenar_info_codigo(nummaquinas,codigo,produtividade);
                    break;
                case 'h':
                    ordenar_info_prod(nummaquinas,codigo,produtividade);
                    break;
                case 'i':
                    System.out.println("Introduza o código da máquina que pretende remover:");
                    String cod=ler.next();
                    int pos=pesquisaMaquinas(nummaquinas, cod, codigo);
                    nummaquinas=remover_maquina(nummaquinas,pos,codigo,produtividade);
                    break;
                case 'j':
                    dia_prod_maior_menor(nummaquinas,codigo,produtividade);
                    break;
                case 'k':
                    inserir_produtividade(nummaquinas,codigo,produtividade);
                    break;
                default:
                    System.out.println("Opção não válida!");
                    break;
            }
        }
        while(opcao!='s');
    }
}