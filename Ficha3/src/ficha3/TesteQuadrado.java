package ficha3;

public class TesteQuadrado {

 public static void main(String[] args) {
        Quadrado q1 = new Quadrado (2);
        Quadrado q2 = new Quadrado (3);
        q1.Perimetro();
        q1.Area();
        q1.QuadradoMaior(q2);
    }
}