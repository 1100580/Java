package utilitarios;

import javax.swing.JOptionPane;

public class Data {
    
    // -- vari�veis de classe --------------------------------------------------
    private static String[] nomeDiaDaSemana = {"Domingo", "Segunda-feira",
    "Ter�a-feira", "Quarta-feira",
    "Quinta-feira", "Sexta-feira",
    "S�bado"};
    
    private static int[] diasPorMes = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    
    private static String[] nomeMes = {"Inv�lido", "Janeiro", "Fevereiro",
    "Mar�o", "Abril", "Maio", "Junho",
    "Julho", "Agosto", "Setembro",
    "Outubro", "Novembro", "Dezembro"};
    
    // -- vari�veis de inst�ncia -----------------------------------------------
    private int ano;
    private int mes;
    private int dia;
    
    // -- construtores ---------------------------------------------------------
    public Data() {
        ano = 1;
        mes = 1;
        dia = 1;
    }
    
    public Data(int a, int m, int d) {
        setData(a,m,d);
    }
    
    // -- m�todos de classe ----------------------------------------------------
    public static boolean anoBissexto(int a) {
        if ( a%4==0 && a%100!=0 || a%400==0 )
            return true;
        return false;
    }
    
    public static Data lerData() {
        int a = Integer.parseInt(JOptionPane.showInputDialog("Ano:"));
        int m = Integer.parseInt(JOptionPane.showInputDialog("M�s:"));
        int d = Integer.parseInt(JOptionPane.showInputDialog("Dia:"));
        
        return new Data(a,m,d);
    }
    
    // -- m�todos de inst�ncia -------------------------------------------------
    public int getAno() {
        return ano;
    }
    
    public int getMes() {
        return mes;
    }
    
    public int getDia() {
        return dia;
    }
    
    public void setData(int a, int m, int d) {
        ano = a;				// tambem poderia validar
        if ( m > 0 && m <= 12 ) mes = m;	// valida o m�s
        else {
            mes = 1;
            System.out.println( "Mes " + m + " invalido. Colocado o mes 1.");
        }
        dia = validaDia( d );			// valida o dia
        // diaDaSemana = detDiaDaSemana();
    }
    
    // Confirma o valor do dia baseado no mes e ano.
    private int validaDia( int d ) {
        if ( d > 0 && d <= diasPorMes[ mes ] ) return d;
        
        // se Fevereiro: Verifica se ano bissexto
        if ( mes == 2 && d == 29 && anoBissexto(ano) ) return d;
        
        System.out.println( "Dia " + d + " invalido. Colocado o dia 1." );
        
        return 1;  // Deixa o objecto num estado consistente
    }
    
    public String diaDaSemana(){
        int totalDias = contaDias();
        
        totalDias = totalDias % 7;
        
        return nomeDiaDaSemana[totalDias];
    }
    
    private int contaDias() {
        int totalDias = 0;
        
        for (int i=1; i<ano; i++) {
            totalDias += anoBissexto(i)?366:365;
        }
        for (int i=1; i<mes; i++) {
            totalDias += diasPorMes[i];
        }
        totalDias += (anoBissexto(ano) && mes>2) ? 1 : 0;
        totalDias += dia;
        
        return totalDias;
    }
    
    public String toAnoMesDiaString() {
        return ano + "/" +
                ((mes<10)?"0":"") + mes + "/" +
                ((dia<10)?"0":"") + dia;
    }
    
    public String toString() {
        return diaDaSemana() + ", " + dia + " de " + nomeMes[mes] + " de " + ano;
    }
    
    public boolean maior(Data d1) {
        int totalDias = contaDias();
        int totalDias1 = d1.contaDias();
        
        return (totalDias>totalDias1)?true:false;
    }
    
    public int diferenca(Data d1) {
        int totalDias = contaDias();
        int totalDias1 = d1.contaDias();
        
        return Math.abs(totalDias-totalDias1);
    }
    
}