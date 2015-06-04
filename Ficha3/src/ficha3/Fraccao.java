/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ficha3;

public class Fraccao {
    private int numerador;
    private int denominador;

    public Fraccao(int numerador, int denominador){
        setNumerador(numerador);
        setDenominador(denominador);
    }

    public Fraccao(){
        this.numerador = 0;
        this.denominador = 1;
    }

    public int MaxDivCom(int num, int den){
        if (num < 0) {
            num = -num;
        }
        if (den < 0) {
            den = -den;
        }
        while(den != 0){
            int r = num % den;
            num = den;
            den = r;
        }
        return num;
    }

    public void Simplificar(){
        int mdc = MaxDivCom(getNumerador(), getDenominador());
        this.numerador = numerador/mdc;
        this.denominador = denominador/mdc;
    }

    public void Soma(Fraccao f){
        if (f.getDenominador() == this.denominador) {
            Fraccao somada = new Fraccao(f.getNumerador() + this.numerador, f.getDenominador() + this.denominador);
            System.out.println("Resultado: " + somada.getNumerador() + " / " + somada.getDenominador());
        } else{
            System.out.println("So se podem somar duas fracções com denominador igual.");
        }
    }

    public void Subtraccao(Fraccao f){
        if (f.getDenominador() == this.denominador) {
            Fraccao somada = new Fraccao(f.getNumerador() - this.numerador, f.getDenominador() - this.denominador);
            System.out.println("Resultado: " + somada.getNumerador() + " / " + somada.getDenominador());
        } else{
            System.out.println("So se podem subtrair duas fracções com denominador igual.");
        }
    }

    public void Multiplicar(Fraccao f){
        Fraccao somada = new Fraccao(f.getNumerador() * this.numerador, f.getDenominador() * this.denominador);
        System.out.println("Resultado: " + somada.getNumerador() + " / " + somada.getDenominador());
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        if (denominador == 0) {
            System.out.println("Denominador inválido, colocado a 1");
            this.denominador = 1;
        } else{
            this.denominador = denominador;
        }
    }

}
