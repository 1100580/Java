/*
Crie uma classe designada por Complexo | que permita fazer a representação de números complexos da forma a+bi. Lembra-se que a designa-se por parte real e b por parte imaginária.

Pretende-se a criação de construtores|, de métodos selectores|, modificadores|, conversor para string e ainda métodos públicos para determinação da soma, subtracção e multiplicação de dois complexos.


Nota: (a+bi) + (c+di) = (a+c) + (b+d) i

(a+bi) - (c+di) = (a -c) + (b -d) i

(a+bi) * (c+di) = (ac-bd) + (ad+cb) i
 */

package ficha3;



public class Complexo {
    
    private String complexo = "";
    private int a, b;

    public Complexo(int a, int b){
        this.a = a;
        this.b = b;
        setComplexo(a, b);
    }

    public String Somar(Complexo c2){
        int newA = getA() + c2.getA();
        int newB = getB() + c2.getB();
        return String.format(newA  + "+" + newB + "i");
    }

    public String Subtrair(Complexo c2){
        int newA = getA() - c2.getA();
        int newB = getB() - c2.getB();
        return String.format(newA  + "+" + newB + "i");
    }

    public String Multiplicar(Complexo c2){
        int newA = (getA() * c2.getA() - getB() * c2.getB());
        int newB = (getA() * c2.getB() + c2.getA() * getB());
        return String.format(newA  + "+" + newB + "i");
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }

    public String getComplexo() {
        return complexo;
    }

    public String setComplexo(int a, int b) {
        this.complexo = String.format(a + "b" + b + "i");
        return complexo;
    }
}
