/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author i090674
 */
public class TesteData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Data data1 = new Data(2010,3,5);
        Data data2 = Data.lerData();
        String data1extenso = data1.toString();
        System.out.println("Data1 = "+data1extenso);
        String data2anomesdia = data2.toAnoMesDiaString();
        System.out.println("Data2 = "+data2anomesdia);
        boolean maior = data2.maior(data1);
        if(maior==false)
            System.out.println("Data1 é mais recente que data2");
         else
            System.out.println("Data2 é mais recente que data1");
        int dif = data2.diferenca(data1);
        System.out.println("O número de dias entre data1 e data2 é: "+dif);
        String diasemana = data2.diaDaSemana();
        System.out.println("O dia da semana em que aconteceu o 25 de Abril de 1974 foi "+diasemana);
        boolean bissexto;
        int ano;
        ano=data2.getAno();
        bissexto=data2.anoBissexto(ano);
        if(bissexto==true)
            System.out.println("1974 é ano bissexto");
        else
            System.out.println("1974 não é ano bissexto");
        bissexto=Data.anoBissexto(1974);
        if(bissexto==true)
            System.out.println("1974 é ano bissexto");
        else
            System.out.println("1974 não é ano bissexto");


    }

}
