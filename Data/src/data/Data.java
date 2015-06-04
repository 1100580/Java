package data;

import javax.swing.JOptionPane;

public class Data {
    private static String[]nomeDiaSemana = {"Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};
    private static int[] diasPorMes = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    private static String[] nomeMes = {"Inválido", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    private int ano;
    private int mes;
    private int dia;

    public Data(){
        ano = 1;
        mes = 1;
        dia = 1;
    }

    public Data(int a, int m, int d) {
        setData(a,m,d);
    }

    public static Data lerData() {
        int a = Integer.parseInt(JOptionPane.showInputDialog("Ano:"));
        int m = Integer.parseInt(JOptionPane.showInputDialog("Mês:"));
        int d = Integer.parseInt(JOptionPane.showInputDialog("Dia:"));
        return new Data(a,m,d);
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }


    public void setData (int a, int m, int d){
        if (a <= 0) {
            System.out.println("Ano errado. Colocado a 1.");
            ano = 1;
        }else
            ano = a;

        if (m < 1 || m > 12) {
            m = 1;
            System.out.println("Mês errado. Colocado a 1.");
        }
        dia = validarDia(d);
    }

    public int validarDia(int d){
        if (d > 0 && d <= diasPorMes [mes]) {
            return d;
        } else{
            if (mes == 2 && dia == 29 && anoBissexto(ano)) {
                return d;
            }
        }
        System.out.println("Dia errado. Colocado a 1.");
        return 1;
    }

    public static boolean anoBissexto(int a) {
        if ( a%4==0 && a%100!=0 || a%400==0 ){
            return true;
        }
        return false;
    }

    public String toAnoMesDiaString(){
        return ano + "/" + (mes < 10? "0":"") + mes + (dia < 10? "0":"") + dia;
    }

    public String diaSemana(int ano){
        int a = ano - 1;
        int totalDias = a * 365 + a/4 - a/100 + a/400;
        for (int i=1; i<mes; i++) {
            totalDias += diasPorMes[i];
        }
        totalDias += (anoBissexto(ano) && mes>2) ? 1 : 0;
        totalDias += dia;
        totalDias = totalDias % 7;
        return nomeDiaSemana[totalDias];
    }

    public static void main(String[] args) {

    }

}
