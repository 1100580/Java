/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tp5ex3;
import java.util.Scanner;
/**
 *
 * @author Tiago
 */
public class Main {

    public static double distancia(double xa, double ya, double xb, double yb){
        double dist=0;
        dist=Math.sqrt(Math.pow(xb-xa, 2)+Math.pow(yb-ya, 2));
        return(dist);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ler=new Scanner(System.in);
        System.out.println("Coordenadas do centro do circulo:");
        double xc= ler.nextFloat();
        double yc= ler.nextFloat();
        System.out.println("Raio do circulo:");
        double raio= ler.nextFloat();
        double xp=xc+1;
        double yp=yc+1;
        int cont=0;
        while (xp!=xc && yp!=yc){
            System.out.println("Coordenadas do ponto:");
            xp=ler.nextDouble();
            yp=ler.nextDouble();
            double dist=distancia(xp,yp,xc,yc);
            if(dist<raio && dist!=0)
                cont++;
        }
        System.out.println(cont+" pontos estao dentro do circulo");
    }

}
