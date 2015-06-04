/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pl6ex4;
import java.util.Scanner;
/**
 *
 * @author i090674
 */
public class Main {
    public static void inserir(String []v){
        boolean ter = true;
        System.out.println("Insira o nome do visitante:");
        Scanner ler = new Scanner(System.in);
        for(int i=0;i<v.length;i++){
            if(v[i].length()=ter){
                v[i]=ler.next();
                break;
            }
            if(i==(v.length-1))
                System.out.println("Erro:Nao e possivel adicionar mais visitantes");
        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String []v=new String [100];
        
        System.out.printf("MENU:%n1- Inserir um visitante.%n2- Listar todos os visitantes.%n3- Posição dum dado visitante (o primeiro).%n4- Actualizar um nome dado.%n5- Eliminar um visitante dado.%n6- Listar os nomes começados por uma dada letra.%n7- Listar nomes repetidos.%n");
        Scanner ler= new Scanner(System.in);
switch(ler.nextInt()){
            case'1':
                inserir(v);
                break;
               
        }
    }
