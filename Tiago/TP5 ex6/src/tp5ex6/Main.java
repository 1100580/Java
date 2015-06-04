/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tp5ex6;
import java.util.Scanner;
/**
 *
 * @author Tiago
 */
public class Main {

    public static double area_bases(double c, double l){
        double area=2*c*l;
        return(area);
    }

    public static double area_lateral(double c, double l, double a){
        double area=2*c*a+2*l*a;
        return(area);
    }

    public static double area_total(double c, double l, double a){
        double area=area_bases(c,l)+area_lateral(c,l,a);
        return(area);
    }

    public static double volume(double c, double l, double a){
        double area=((area_bases(c,l)/2)*a);
        return(area);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ler=new Scanner(System.in);
        System.out.println("Introduza as medidas do paralelepipedo (c,l,a):");
        double c=ler.nextDouble();
        double l=ler.nextDouble();
        double a=ler.nextDouble();
        int opcao=ler.nextInt();
        switch(opcao){
            case 1:System.out.println(area_bases(c,l));break;
            case 2:System.out.println(area_lateral(c,l,a));break;
            case 3:System.out.println(area_total(c,l,a));break;
            case 4:System.out.println(volume(c,l,a));break;
            default:System.out.println("Opcao nao valida");
        }
    }

}
