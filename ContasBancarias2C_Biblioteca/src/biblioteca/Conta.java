package biblioteca;

import java.io.Serializable;

public class Conta implements Serializable {

    private static int totalContas = 0;
    private int nrConta;
    private String titular;
    private double saldo;

    public Conta(String titular, double saldo) {
        nrConta = ++totalContas;
        setTitular(titular);
        setSaldo(saldo);
    }

    public Conta(String titular) {
        this(titular, 0);
    }

    public int getNrConta() {
        return nrConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public static int getTotalContas() {
        return totalContas;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo>0 ? saldo : 0;
    }

    public static void setTotalContas(int totalContas) {
        Conta.totalContas = totalContas > 0 ? totalContas : 0;
    }

    public String toString() {
        return String.format("Nr Conta: %d - Titular: %s - Saldo: %.2f €", nrConta, titular, saldo);
    }

}
