
package ficha3;


public class Quadrado {

    private double lado;
    private String cor;
    
    public Quadrado(double lado, String cor){
        this.lado = lado;
        this.cor = cor;
    }

    public double getLado() {
        return lado;
    }
    public Quadrado(double lado){
        this.lado = lado;
        cor = null;
    }

    public double Perimetro(){
        double perimetro = lado*4;
        System.out.println("O perimetro é " + perimetro);
        return perimetro;
    }

    public double Area(){
        double area = lado*lado;
        System.out.println("A area é " + area);
        return area;
    }

    public void QuadradoMaior (Quadrado q2) {
        System.out.println(((lado > q2.getLado()) ? "q1" : "q2")  + " é o maior quadrado");
    }

}
