/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contabancaria;

import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo
 */
public class Conta {
    private static int totalContas = 0;

    private int nrConta;
    private String titular;
    private double saldo;
    private Data dataAbertura, dataUltMov;
    private Tempo horaUltMov;


    public Conta(String titular, double saldo, Data dataAbertura) {
        nrConta = ++totalContas;
        setTitular(titular);
        if (!deposito(saldo))
            deposito(0);
        setDataAbertura(dataAbertura);
    }

    public Conta(String titular, Data dataAbertura) {
        this(titular, 0, dataAbertura);
    }

    public int getNrConta(){
        return nrConta;
    }


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setDataAbertura(Data dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Data getDataAbertura() {
        return dataAbertura;
    }

    public void setDataUltMov(Data dataUltMov) {
        this.dataUltMov = dataUltMov;
    }

    public Data getDataUltMov() {
        return dataUltMov;
    }

    public Tempo getHoraUltMov() {
        return horaUltMov;
    }


    public String toString(){
        return String.format("Nr. Conta: %d - Titular: %s - Data abertura: %s - Saldo: %.2f", nrConta, titular, dataAbertura, saldo);
    }

    public boolean deposito(double montante) {
        if (montante > 0) {
            saldo += montante;
            registaDataHoraUltMov();
            return true;

        }
        return false;
    }

    public boolean levantamento(int montante) {
        if (montante <= saldo) {
            saldo -= montante;
            registaDataHoraUltMov();
            return true;
        }
        return false;
    }

    private void registaDataHoraUltMov() {
        Calendar agora = Calendar.getInstance();
        int ano = agora.get(Calendar.YEAR);
        int mes = agora.get(Calendar.MONTH) + 1;
        int dia = agora.get(Calendar.DAY_OF_MONTH);
        dataUltMov = new Data(ano, mes, dia);
        int hora = agora.get(Calendar.HOUR);
        int minuto = agora.get(Calendar.MINUTE);
        int segundo = agora.get(Calendar.SECOND);
        horaUltMov = new Tempo(hora, minuto, segundo);
    }

    public boolean saldoSuperior(Conta conta) {
        return saldo > conta.getSaldo();
    }

    public double diferencaSaldos(Conta conta) {
        return Math.abs(saldo - conta.getSaldo());
    }

    public static int getTotalContas() {
        return totalContas;
    }

    public static Conta lerConta() {
        String titular = JOptionPane.showInputDialog("Introduza o titular: ");
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Introduza o saldo inicial: "));
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Introduza o ano de abertura da conta: "));
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Introduza o mês de abertura da conta: "));
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Introduza o dia de abertura da conta: "));
        return new Conta(titular, saldo, new Data(ano, mes, dia));
    }
}
