package pl5ex2;
import javax.swing.JOptionPane;
public class Main {
    public static double angulo(double a, double b, double c){
        return(Math.toDegrees((Math.acos((Math.pow(a,2)+Math.pow(b,2)-Math.pow(c,2))/2*a*b))));
    }
    public static void main(String[] args) {
        double a, b, c;
        do{
            do{
                String vAuxiliar;
                vAuxiliar=JOptionPane.showInputDialog("Insira o valor do lado 1 do triângulo");
                a=Double.parseDouble(vAuxiliar);
            }
            while(a<0);
            do{
                String vAuxiliar;
                vAuxiliar=JOptionPane.showInputDialog("Insira o valor do lado 2 do triângulo");
                b=Double.parseDouble(vAuxiliar);
            }
            while(b<0);
            do{
                String vAuxiliar;
                vAuxiliar=JOptionPane.showInputDialog("Insira o valor do lado 3 do triângulo");
                c=Double.parseDouble(vAuxiliar);
            }
            while(c<0);
            }
        while (a>=b+c || b>=a+c || c>=a+b);
        JOptionPane.showMessageDialog (null, "Ângulo AB:"+angulo(a,b,c));
        JOptionPane.showMessageDialog (null, "Ângulo AC:"+angulo(a,c,b));
        JOptionPane.showMessageDialog (null, "Ângulo BC:"+angulo(b,c,a));
    }

}
