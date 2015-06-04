
package empregado;

import javax.swing.JOptionPane;

public class Empregado {

    public String primNome;
    public String ultNome;
    public Data dataContrato;
    public Tempo horaEntrada;
    public Tempo horaSaida;
    public String horasSemana;
    public int diasContrato;

    //Construtor de empregados, notar Data e Tempo no tipo das variaveis.
    public Empregado(String primeiro, String ultimo, Data data, Tempo horaE, Tempo horaS) {
        this.primNome = primeiro;
        this.ultNome = ultimo;
        this.dataContrato = data;
        this.horaEntrada = horaE;
        this.horaSaida = horaS;
        this.horasSemana = "";
        this.diasContrato = 0;
    }

    private void setprimNome(String primNome){
        this.primNome = JOptionPane.showInputDialog("Insira o primeiro nome");
    }

    public String getprimNome(){
        return primNome;
    }

    private void setultNome(String ultNome) {
        ultNome = JOptionPane.showInputDialog("Insira o último nome");
    }

    public String getultNome(){
        return ultNome;
    }

    public String lerDados(){
        return primNome + "\n" + ultNome + "\n" + dataContrato + "\n" + horaEntrada + "\n" + horaSaida;
    }

    public String imprimirToString(){
        return String.format("Nome: " + primNome + " " + ultNome + " | Data de Contrato: " + dataContrato + " | Hora entrada:" + horaEntrada + " | Hora saída: " + horaSaida);
    }

    public String setHorasSemana(Tempo te1, Tempo ts1, Tempo te2, Tempo ts2, Tempo te3, Tempo ts3, Tempo te4 , Tempo ts4, Tempo te5, Tempo ts5){
        Tempo t1 = ts1.diferencaTempo(te1);
        Tempo t2 = ts2.diferencaTempo(te2);
        Tempo t3 = ts3.diferencaTempo(te3);
        Tempo t4 = ts4.diferencaTempo(te4);
        Tempo t5 = ts5.diferencaTempo(te5);
        horasSemana = t1.somarCincoTempos(t1, t2, t3, t4, t5);

        return horasSemana;
    }

    public int setDiasContrato(Data hoje){
        return dataContrato.diferenca(hoje);
    }
}
