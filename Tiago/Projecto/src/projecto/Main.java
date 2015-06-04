package projecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static Scanner ler= new Scanner(System.in);
    static String []vector1=new String [3];
    static int []coeficientesx=new int [4];
    static int []coeficientesy=new int [4];
    static int []coeficientesz=new int [4];
    static int [][]matriz2=new int [4][20];
    static int nelem2=0;
    static float [][]matriz2cond=new float [4][4];
    static int nelem2c=0;
    static float [][]variaveis2={{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
    static float [][]variaveis2cond=new float [4][4];
    static String [] vector2= new String [4];
    static String [] vectorsubspaco=new String [4];
    static float [][]subspaco= new float [4][4];
    static float [][]matriz3=new float [20][3];

    public static void menu(){
        System.out.println("--------------------------------- M E N U ---------------------------------");
        System.out.println("");
        System.out.println("A - Dado um subconjunto de R^3 verificar se é subespaço de R^3;");
        System.out.println("B - Determinar uma base e a dimensão de um subespaço de R^4;");
        System.out.println("C - Determine se um dado conjunto de vectores são ou não geradores de R^3;");
        System.out.println("S - Sair do programa;");
        System.out.println("");
        System.out.println("Introduza a opção:");
    }

    @SuppressWarnings("static-access")
    public static void introduzir1(String coord, int pos, String[]vector, int coeficientes[]){
        System.out.print(coord+":");
        String aux=ler.next().toUpperCase().trim();
        if(aux.isEmpty())
            System.out.println("Nenhum valor introduzido!");
        else{
            vector[pos]=aux;
        }
        guarda_coeficientes(pos,vector,coeficientes);

        System.out.println("");
    }

    public static void guarda_coeficientes(int pos, String [] vector, int []coeficientes){
        String aux=vector[pos];
        String[]scoeficientes=new String[4];
        boolean x=false;
        boolean y=false;
        boolean z=false;
        int i;
        for(i=0;i<aux.length();i++){
            if(aux.charAt(i)=='X'){
                x=true;
            }
            if(aux.charAt(i)=='Y'){
                y=true;
            }
            if(aux.charAt(i)=='Z'){
                z=true;
            }
        }
        if(x==true){
            if(aux.startsWith("X")){
                coeficientes[0]=1;
                scoeficientes[1]=aux.substring(1);
            }
            else{
                scoeficientes=aux.split("X");
                if(scoeficientes[0].equals("-"))
                    coeficientes[0]=-1;
                else{
                    if(scoeficientes[0].isEmpty())
                        coeficientes[0]=1;
                    else
                        coeficientes[0]=Integer.parseInt(scoeficientes[0]);
                }
            }
            if(y==true){
                scoeficientes=scoeficientes[1].split("Y");
                if(scoeficientes[0].equals("+"))
                    coeficientes[1]=1;
                else{
                    if(scoeficientes[0].equals("-"))
                        coeficientes[1]=-1;
                    else{
                        if(scoeficientes[0].startsWith("+"))
                            coeficientes[1]=Integer.parseInt(scoeficientes[0].substring(1));
                        else{
                            coeficientes[1]=Integer.parseInt(scoeficientes[0]);
                        }
                    }
                }
                if(z==true){
                    scoeficientes=scoeficientes[1].split("Z");
                    if(scoeficientes[0].equals("+"))
                        coeficientes[2]=1;
                    else{
                        if(scoeficientes[0].equals("-"))
                            coeficientes[2]=-1;
                        else{
                            if(scoeficientes[0].startsWith("+"))
                                coeficientes[2]=Integer.parseInt(scoeficientes[0].substring(1));
                            else
                                coeficientes[2]=Integer.parseInt(scoeficientes[0]);
                        }
                    }
                    if(scoeficientes.length>1){
                        if(scoeficientes[1].isEmpty())
                            coeficientes[3]=0;
                        else{
                            if(scoeficientes[1].startsWith("+"))
                                coeficientes[3]=Integer.parseInt(scoeficientes[1].substring(1));
                            else
                                coeficientes[3]=Integer.parseInt(scoeficientes[1]);
                        }
                    }
                }
                if(z==false){
                    coeficientes[2]=0;
                    if(scoeficientes.length>1){
                        if(scoeficientes[1].isEmpty())
                            coeficientes[3]=0;
                        else{
                            if(scoeficientes[1].startsWith("+"))
                                coeficientes[3]=Integer.parseInt(scoeficientes[1].substring(1));
                            else
                                coeficientes[3]=Integer.parseInt(scoeficientes[1]);
                        }
                    }
                }
            }
            if(y==false){
                coeficientes[1]=0;
                if(z==true){
                    if(scoeficientes[1].startsWith("+Z")){
                        coeficientes[2]=1;
                        scoeficientes[1]=scoeficientes[1].substring(2);
                    }
                    else{
                        scoeficientes=scoeficientes[1].split("Z");
                        if(scoeficientes[0].equals(""))
                            coeficientes[2]=1;
                        else{
                            if(scoeficientes[0].equals("-"))
                                coeficientes[2]=-1;
                            else{
                                if(scoeficientes[0].startsWith("+"))
                                    coeficientes[2]=Integer.parseInt(scoeficientes[0].substring(1));
                                else
                                    coeficientes[2]=Integer.parseInt(scoeficientes[0]);
                            }
                        }
                    }
                    if(scoeficientes.length>1){
                       if(scoeficientes[1].isEmpty())
                           coeficientes[3]=0;
                       else{
                            if(scoeficientes[1].startsWith("+"))
                                coeficientes[3]=Integer.parseInt(scoeficientes[1].substring(1));
                            else
                                coeficientes[3]=Integer.parseInt(scoeficientes[1]);
                        }
                   }
                }
                if(z==false){
                    coeficientes[2]=0;
                    if(scoeficientes.length>1){
                        if(scoeficientes[1].isEmpty())
                            coeficientes[3]=0;
                        else{
                            if(scoeficientes[1].startsWith("+"))
                                coeficientes[3]=Integer.parseInt(scoeficientes[1].substring(1));
                            else
                                coeficientes[3]=Integer.parseInt(scoeficientes[1]);
                        }
                    }
                }
            }
        }
        if(x==false){
            coeficientes[0]=0;
            if(y==true){
                if(aux.startsWith("Y")){
                    coeficientes[1]=1;
                    scoeficientes[1]=aux.substring(1);
                }
                else{
                    scoeficientes=aux.split("Y");
                    if(scoeficientes[0].equals("-"))
                        coeficientes[1]=-1;
                    else
                        coeficientes[1]=Integer.parseInt(scoeficientes[0]);
                }
                if(z==true){
                    scoeficientes=scoeficientes[1].split("Z");
                    if(scoeficientes[0].equals("+"))
                        coeficientes[2]=1;
                    else{
                        if(scoeficientes[0].equals("-"))
                            coeficientes[2]=-1;
                        else{
                            if(scoeficientes[0].startsWith("+"))
                                coeficientes[2]=Integer.parseInt(scoeficientes[0].substring(1));
                            else
                                coeficientes[2]=Integer.parseInt(scoeficientes[0]);
                        }
                    }
                    if(scoeficientes.length>1){
                        if(scoeficientes[1].isEmpty())
                            coeficientes[3]=0;
                       else{
                            if(scoeficientes[1].startsWith("+"))
                                coeficientes[3]=Integer.parseInt(scoeficientes[1].substring(1));
                            else
                                coeficientes[3]=Integer.parseInt(scoeficientes[1]);
                        }
                    }
                }
                if(z==false){
                    coeficientes[2]=0;
                    if(scoeficientes.length>1){
                        if(scoeficientes[1].isEmpty())
                            coeficientes[3]=0;
                        else{
                            if(scoeficientes[1].startsWith("+"))
                                coeficientes[3]=Integer.parseInt(scoeficientes[1].substring(1));
                            else
                                coeficientes[3]=Integer.parseInt(scoeficientes[1]);
                        }
                    }
                }
            }
            if(y==false){
                coeficientes[1]=0;
                if(z==true){
                    if(aux.startsWith("Z")){
                        coeficientes[2]=1;
                        scoeficientes[1]=aux.substring(1);
                    }
                    else{
                        scoeficientes=aux.split("Z");
                        if(scoeficientes[0].equals("-"))
                            coeficientes[2]=-1;
                        else
                            coeficientes[2]=Integer.parseInt(scoeficientes[0]);
                    }
                    if(scoeficientes.length>1){
                        if(scoeficientes[1].isEmpty())
                            coeficientes[3]=0;
                        else{
                            if(scoeficientes[1].startsWith("+"))
                                coeficientes[3]=Integer.parseInt(scoeficientes[1].substring(1));
                            else
                                coeficientes[3]=Integer.parseInt(scoeficientes[1]);
                        }
                    }
                }
                if(z==false){
                    coeficientes[2]=0;
                    coeficientes[3]=Integer.parseInt(aux);
                }
            }
        }
        for(i=0;i<coeficientes.length;i++){
            System.out.println(coeficientes[i]);
        }
    }

    public static boolean subespaco(int[]coordenadasx,int[]coordenadasy,int[]coordenadasz){
        boolean subespaco=false;
        if(coordenadasx[3]==0&&coordenadasy[3]==0&&coordenadasz[3]==0)
            subespaco=true;
        return(subespaco);
    }

    public static void menu2(){
        System.out.println("De que maneira pretende introduzir os dados dos vectores?");
        System.out.println("");
        System.out.println("1 - Através da consola;");
        System.out.println("2 - Através de um ficheiro de texto em formato CSV;");
        System.out.println("3 - Voltar ao menu anterior.");
        System.out.println("");
        System.out.println("Introduza a sua opção:");
    }

    public static int introduzir2consola(int [][]matriz,int nelem2){
        System.out.println("Introduza os vectores do subespaço na forma: «x,y,z,w»(para parar a introdução introduza o vector (0,0,0,0):");
        System.out.println("");
        String vectoraux[]=new String[4];
        for(int i=0;i<matriz[0].length;i++){
            System.out.println("Vector "+(i+1)+":");
            String aux=ler.next().trim();
            System.out.println("");
            if(aux.isEmpty()){
                System.out.println("Nenhum valor introduzido!");
                break;
            }
            else{
                vectoraux=aux.split(",");
                if(vectoraux[0].equals("0")&&vectoraux[1].equals("0")&&vectoraux[2].equals("0")&&vectoraux[3].equals("0"))
                    break;   
                else{
                    for(int j=0;j<vectoraux.length;j++){
                        matriz[j][i]=Integer.parseInt(vectoraux[j]);
                    }
                }
            }
            nelem2++;
        }
        return(nelem2);
    }

    public static int introduzir2csv(int [][]matriz,int nelem2) throws FileNotFoundException{
        Scanner in=new Scanner(new File("exercicio2.csv"));
        in.useDelimiter(";");
        String [][]matriz0= new String [4][4];
        for(int i=0;i<matriz[0].length;i++){
            for(int j=0;j<matriz.length;j++){
                matriz[j][i]=in.nextInt();
            }
            nelem2++;
        }
        for(int i=0;i<matriz[0].length;i++)
            for(int j=0;j<matriz.length;j++)
                System.out.println(matriz[j][i]);
        return(nelem2);
    }

    public static void condensarmatriz(int[][]matriz,float[][]vector,float[][]condensada,float [][]vectorcond,int nelem2){
        float aux[][]=new float [4][nelem2];
        for(int i=0;i<aux.length;i++)
            for(int j=0;j<aux[i].length;j++)
                aux[i][j]=matriz[i][j];
        float vaux[][]=new float[4][4];
        for(int i=0;i<vaux.length;i++)
            for(int j=0;j<vaux[i].length;j++)
                vaux[i][j]=vector[i][j];
        float x;
        float aux2[]=new float [4];
        float vaux2[]=new float [4];
        int cont=0;
        for(int i=0;i<nelem2;i++){
            float pivot=aux[i][i];
            System.out.println("pivot="+pivot);
            while(pivot==0){
                if(cont>3){
                    for(int a=0;a<aux.length;a++){
                        aux2[a]=aux[a][i];                  
                    }
                    for(int b=i;b<aux[i].length-1;b++)
                        for(int c=0;c<aux.length;c++){
                            aux[c][b]=aux[c][b+1];                           
                        }
                    for(int a=0;a<aux.length;a++){
                        aux[a][nelem2-1]=aux2[a];                      
                    }
                    cont=0;
                    if(aux[i][i]!=0)
                        break;
                }
                for(int a=0;a<aux[i].length;a++){
                    aux2[a]=aux[i][a];
                    vaux2[a]=vaux[i][a];
                }
                for(int b=i;b<aux.length-1;b++)
                    for(int c=0;c<aux[b].length;c++){
                        aux[b][c]=aux[b+1][c];
                        vaux[b][c]=vaux[b+1][c];
                    }
                for(int a=0;a<aux[i].length;a++){
                    aux[3][a]=aux2[a];
                    vaux[3][a]=vaux2[a];
                }
                pivot=aux[i][i];
                cont++;
            }
            for(int l=i+1;l<aux.length;l++){
                x=aux[l][i]/pivot;
                for (int c=i;c<aux[i].length;c++)
                    aux[l][c]=aux[l][c]+(aux[i][c]*x*-1);
                for(int v=0;v<vaux[0].length;v++)
                    vaux[l][v]=vaux[l][v]+(vaux[i][v]*x*-1);
            }
        }
        for(int i=0;i<aux.length;i++)
            for(int j=0;j<aux[i].length;j++)
                condensada[i][j]=aux[i][j];
        for(int i=0;i<vaux.length;i++)
            for(int j=0;j<vaux[i].length;j++)
                vectorcond[i][j]=vaux[i][j];
    }

    @SuppressWarnings("static-access")
    public static void guarda_coeficientes_inv(float[][]variaveis,String [] vector){
        String aux;
        for(int i=0;i<4;i++){
            aux="";
            for(int j=0;j<4;j++){
                switch(j){
                    case 0:
                        if(variaveis[i][j]==1){
                            aux=aux.format("%c",'X');
                            break;
                        }
                        if(variaveis[i][j]==-1){
                            aux=aux.format("%s","-X");
                            break;
                        }
                        if(variaveis[i][j]!=0){
                            aux=aux.format("%.2f%c",variaveis[i][j],'X');
                            break;
                        }
                    case 1:
                        if(aux.equals("")){
                            if(variaveis[i][j]==1){
                                aux=aux.format("%c",'Y');
                                break;
                            }
                            if(variaveis[i][j]==-1){
                                aux=aux.format("%s","-Y");
                                break;
                            }
                            if(variaveis[i][j]!=0){
                                aux=aux.format("%.2f%c",variaveis[i][j],'Y');
                                break;
                            }
                        }
                        else{
                            if(variaveis[i][j]==1){
                                aux=aux.format("%s%s",aux,"+Y");
                                break;
                            }
                            if(variaveis[i][j]==-1){
                                aux=aux.format("%s%s",aux,"-Y");
                                break;
                            }
                            if(variaveis[i][j]>0&&variaveis[i][j]!=1){
                                aux=aux.format("%s%c%.2f%c",aux,'+',variaveis[i][j],'Y');
                                break;
                            }
                            if(variaveis[i][j]<0&&variaveis[i][j]!=-1){
                                aux=aux.format("%s%.2f%c",aux,variaveis[i][j],'Y');
                                break;
                            }
                       }
                    case 2:
                        if(aux.equals("")){
                            if(variaveis[i][j]==1){
                                aux=aux.format("%c",'Z');
                                break;
                            }
                            if(variaveis[i][j]==-1){
                                aux=aux.format("%s","-Z");
                                break;
                            }
                            if(variaveis[i][j]!=0){
                                aux=aux.format("%.2f%c",variaveis[i][j],'Z');
                                break;
                            }
                        }
                        else{
                            if(variaveis[i][j]==1){
                                aux=aux.format("%s%s",aux,"+Z");
                                break;
                            }
                            if(variaveis[i][j]==-1){
                                aux=aux.format("%s%s",aux,"-Z");
                                break;
                            }
                            if(variaveis[i][j]>0&&variaveis[i][j]!=1){
                                aux=aux.format("%s%c%.2f%c",aux,'+',variaveis[i][j],'Z');
                                break;
                            }
                            if(variaveis[i][j]<0&&variaveis[i][j]!=-1){
                                aux=aux.format("%s%.2f%c",aux,variaveis[i][j],'Z');
                                break;
                            }
                        }     
                    case 3:
                        if(aux.equals("")){
                            if(variaveis[i][j]==1){
                                aux=aux.format("%c",'W');
                                break;
                            }
                            if(variaveis[i][j]==-1){
                                aux=aux.format("%s","-W");
                                break;
                            }
                            if(variaveis[i][j]!=0){
                                aux=aux.format("%.2f%c",variaveis[i][j],'W');
                                break;
                            }
                        }
                        else{
                            if(variaveis[i][j]==1){
                                aux=aux.format("%s%s",aux,"+W");
                                break;
                            }
                            if(variaveis[i][j]==-1){
                                aux=aux.format("%s%s",aux,"-W");
                                break;
                            }
                            if(variaveis[i][j]>0&&variaveis[i][j]!=1){
                                aux=aux.format("%s%c%.2f%c",aux,'+',variaveis[i][j],'W');
                                break;
                            }
                            if(variaveis[i][j]<0&&variaveis[i][j]!=-1){
                                aux=aux.format("%s%.2f%c",aux,variaveis[i][j],'W');
                                break;
                            }
                       }
                }
               
           }
            vector[i]=aux;
       }
    }

    public static void introduzir_subespaco(String []vector){
        System.out.println("Introduza as coordenadas do subespaço verctorial:");
        System.out.println("");
        for(int i=0;i<vector.length;i++){
            if(i==0)
                System.out.print("X= ");
            if(i==1)
                System.out.print("Y= ");
            if(i==2)
                System.out.print("Z= ");
            if(i==3)
                System.out.print("W= ");
            String aux=ler.next().trim().toUpperCase();
            System.out.println("");
            if(aux.isEmpty()){
                System.out.println("Nenhum valor introduzido!");
                break;
            }
            else
                vector[i]=aux;
        }

    }

    public static int guarda_coeficientes2(String []vector, float [][]matriz){
        String aux;
        String []coord={"X","Y","Z","W"};
        for(int i=0;i<4;i++){
            for(int j=0;j<vector.length;j++){
                aux="";
                if(vector[j].equals(coord[i])){
                    matriz[i][j]=1;
                    continue;
                }
                if(vector[j].contains(coord[i])){
                    aux=vector[j].substring(0,vector[j].indexOf(coord[i]));
                    if(aux.contains("X"))
                        aux=aux.substring(aux.indexOf("X")+1,aux.length());
                    if(aux.contains("Y"))
                        aux=aux.substring(aux.indexOf("Y")+1,aux.length());
                    if(aux.contains("Z"))
                        aux=aux.substring(aux.indexOf("Z")+1,aux.length());
                    if(aux.contains("W"))
                        aux=aux.substring(aux.indexOf("W")+1,aux.length());
                    if(aux.equals("+")){
                        matriz[i][j]=1;
                        continue;
                    }
                    if(aux.equals("-")){
                        matriz[i][j]=-1;
                        continue;
                    }
                    if(aux.isEmpty()){
                        matriz[i][j]=1;
                        continue;
                    }
                    if(aux.charAt(0)=='+')
                        aux=aux.substring(1,aux.length());
                    else{
                        matriz[i][j]=Float.parseFloat(aux);
                    }
                }
            }
        }
        int nvectores=4;
        int zero;
        for(int i=0;i<matriz.length;i++){
            zero=0;
            for(int j=0;j<matriz[i].length;j++)
                if(matriz[i][j]==0)
                    zero++;
            if(zero==4)
                nvectores--;
        }
        return(nvectores);
    }
    public static void menu3(){
        System.out.println("De que maneira pretende introduzir os dados dos vectores?");
        System.out.println("");
        System.out.println("1 - Através da consola;");
        System.out.println("2 - Através de um ficheiro de texto em formato CSV;");
        System.out.println("3 - Voltar ao menu anterior.");
        System.out.println("");
        System.out.println("Introduza a sua opção:");
    }

    public static void introduzir3consola(float [][]vector){
       System.out.println("Introduza os vectores (para parar a introdução introduza o vector (0,0,0,0):");
       System.out.println("");
       int nelem=0;
       for(int i=0;i<99;i++){
           System.out.println("Vector "+(i+1)+":");
           System.out.print("X = ");
           vector[i][0]=ler.nextFloat();
           System.out.print("Y = ");
           vector[i][1]=ler.nextFloat();
           System.out.print("Z = ");
           vector[i][2]=ler.nextFloat();
           System.out.println("");
           if(vector[i][0]==0 && vector[i][1]==0 && vector[i][2]==0)
               break;
           else
               nelem++;
       }
       if(nelem>3)
            System.out.println("O conjunto de vectores introduzidos não são geradores de R^3");
    }

    public static void main(String[] args) throws FileNotFoundException{
        boolean repetirmenu=true;
        while(repetirmenu==true){
            repetirmenu=false;
            char opcao='d';
            menu();
            String aux=ler.next();
            System.out.println("");
            opcao=aux.toLowerCase().charAt(0);
            switch(opcao){
                case 'a':
                    System.out.println("Introduza os coeficientes das coordenadas do subespaço na forma de aX+bY+cZ+d:");
                    System.out.println("");
                    introduzir1("X",0,vector1,coeficientesx);
                    introduzir1("Y",1,vector1,coeficientesy);
                    introduzir1("Z",2,vector1,coeficientesz);
                    boolean subespaco = subespaco(coeficientesx,coeficientesy,coeficientesz);
                    System.out.println(subespaco);
                    break;
                case 'b':
                    menu2();
                    int opcao2= ler.nextInt();
                    System.out.println("");
                    switch(opcao2){
                        case 1:
                            nelem2=introduzir2consola(matriz2,nelem2);
                            if(nelem2>4)
                            System.out.println("O conjunto de vectores introduzidos não forma um subespaço de R^4");
                            else{
                            System.out.println(nelem2);
                            condensarmatriz(matriz2,variaveis2,matriz2cond,variaveis2cond,nelem2);
                            guarda_coeficientes_inv(variaveis2cond,vector2);
                            introduzir_subespaco(vectorsubspaco);
                            int nvectores=guarda_coeficientes2(vectorsubspaco,subspaco);
                            }
                            break;
                        case 2:
                            nelem2=introduzir2csv(matriz2,nelem2);
                            break;
                        case 3:
                            repetirmenu=true;
                            break;
                        default:
                            System.out.println("Opção não válida.");
                    }
                    break;
                case 'c':
                    menu3();
                    int opcao3= ler.nextInt();
                    System.out.println("");
                    switch(opcao3){
                        case 1:
                            introduzir3consola(matriz3);
                            break;
                        case 2:
                            System.out.println("introduzir pelo ficheiro...");
                            break;
                        case 3:
                            repetirmenu=true;
                            break;
                        default:
                            System.out.println("Opção não válida.");
                    }
                    break;
                case 's':
                    break;
                default:
                    System.out.println("Opção não válida!");
          }
       }
    }
}
