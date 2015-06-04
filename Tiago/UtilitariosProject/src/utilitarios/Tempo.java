package utilitarios;

import javax.swing.JOptionPane;

public class Tempo {
    
    // -- vari�veis de inst�ncia -----------------------------------------------
    private int hora;
    private int minuto;
    private int segundo;
    
    // -- construtores ---------------------------------------------------------
    public Tempo() {
        setHora(0);
        setMinuto(0);
        setSegundo(0);
    }
    
    public Tempo(int h, int m, int s) {
        setHora(h);
        setMinuto(m);
        setSegundo(s);
    }
    
    // -- m�todos de classe ----------------------------------------------------
    public static Tempo lerTempo() {
        int h = Integer.parseInt(JOptionPane.showInputDialog("Horas:"));
        int m = Integer.parseInt(JOptionPane.showInputDialog("Minutos:"));
        int s = Integer.parseInt(JOptionPane.showInputDialog("Segundos:"));
        
        return new Tempo(h,m,s);
    }
    
    // -- m�todos de inst�ncia -------------------------------------------------
    public int getHora() { return hora; }
    
    public int getMinuto() { return minuto; }
    
    public int getSegundo() { return segundo; }
    
    public void setHora(int h){
        hora = (h>=0&&h<24)?h:0;
    }
    
    public void setMinuto(int m){
        minuto = (m>=0&&m<60)?m:0;
    }
    
    public void setSegundo(int s){
        segundo = (s>=0&&s<60)?s:0;
    }
    
    public String toHoraMinutoSegundoString() {
        String s;
        
        s = ( (hora<10)?"0":"" ) + hora;
        s += ( (minuto<10)?"0":"" ) + minuto;
        s += ( (segundo<10)?"0":"" ) + segundo;
        
        return s;
    }
    
    public void tick() {
        if ( ++segundo == 60 ) {
            segundo = 0;
            if ( ++minuto == 60 ) {
                minuto = 0;
                if ( ++hora == 24 )
                    hora = 0;
            }
        }
    }

    public int diferencaEmSegundos(Tempo t1) {
        int total = hora*3600 + minuto*60 + segundo;
        int total_t1 = t1.hora*3600 + t1.minuto*60 + t1.segundo;
        
        return Math.abs(total - total_t1);
    }
    
    public boolean maior(Tempo t1) {
        if (hora > t1.hora || hora == t1.hora && minuto > t1.minuto ||
            hora == t1.hora && minuto == t1.minuto && segundo > t1.segundo)
            return true;
        
        return false;
    }
    
    public Tempo diferencaEmTempo(Tempo t1) {
        int dif = diferencaEmSegundos(t1);
        
        int h = dif / 3600;
        dif = dif % 3600;
        
        int m = dif / 60;
        int s = dif % 60;
        
        return new Tempo(h,m,s);
    }
    
    public String toString() {
        String s;
        
        s = ( (hora==12||hora==0) ? "12" : ((hora%12<10)?"0":"")+hora%12 ) +":";
        s += ( (minuto<10)?"0":"" ) + minuto + ":";
        s += ( (segundo<10)?"0":"" ) + segundo;
        s += (hora < 12) ? " AM" : " PM";
        
        return s;
    }
    
}
