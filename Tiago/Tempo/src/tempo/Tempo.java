/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tempo;

import javax.swing.JOptionPane;

/**
 *
 * @author i090674
 */
public class Tempo {

    private int hora;
    private int minuto;
    private int segundo;

    public Tempo(int h, int m, int s) {
        if (h < 0 || h > 23) {
            hora = 0;
            System.out.println("Hora inválida. Inserido 0.");
        } else {
            hora = h;
        }
        if (m < 0 || m > 59) {
            minuto = 0;
            System.out.println("Minuto inválido. Inserido 0.");
        } else {
            minuto = m;
        }

        if (s < 0 || s > 59) {
            segundo = 0;
            System.out.println("Segundo inválido. Inserido 0.");
        } else {
            segundo = s;
        }
    }



    public int getHora() {
        return (hora);
    }

    public int getMinuto() {
        return (minuto);
    }

    public int getSegundo() {
        return (segundo);
    }

    public void setHora(int h) {
        if (h < 0 || h > 23) {
            hora = 0;
            System.out.println("Hora inválida. Inserido 0.");
        } else {
            hora = h;
        }
    }

    public void setMinuto(int m) {
        if (m < 0 || m > 59) {
            minuto = 0;
            System.out.println("Minuto inválido. Inserido 0.");
        } else {
            minuto = m;
        }
    }

    public void setSegundo(int s) {
        if (s < 0 || s > 59) {
            segundo = 0;
            System.out.println("Segundo inválido. Inserido 0.");
        } else {
            segundo = s;
        }
    }

    public String toStringhhmmss() {
        String s;
        if (hora < 10) {
            s = "0" + hora;
        } else {
            s = "" + hora;
        }
        if (minuto < 10) {
            s = s + "0" + minuto;
        } else {
            s = s + minuto;
        }
        if (segundo < 10) {
            s = s + "0" + segundo;
        } else {
            s = s + segundo;
        }
        return (s);
    }

    public void mais1segundo() {
        if (segundo == 59) {
            if (minuto == 59) {
                if (hora == 23) {
                    hora = 0;
                    minuto = 0;
                    segundo = 0;
                } else {
                    hora++;
                    minuto = 0;
                    segundo = 0;
                }
            } else {
                minuto++;
                segundo = 0;
            }
        } else {
            segundo++;
        }
    }

    public int diferencaSegundos(Tempo t2) {
        int dif = Math.abs(this.toSegundos() - t2.toSegundos());
        return (dif);
    }

    public int toSegundos() {
        int s = segundo + minuto * 60 + hora * 3600;
        return (s);
    }

    public static Tempo lerTempo() {
        int h = Integer.parseInt(JOptionPane.showInputDialog("Horas:"));
        int m = Integer.parseInt(JOptionPane.showInputDialog("Minutos:"));
        int s = Integer.parseInt(JOptionPane.showInputDialog("Segundos:"));
        return (new Tempo(h, m, s));
    }

    public int maior(Tempo t2) { //1=maior 0=igual -1=menor
        int res = 0;
        int dif = this.toSegundos() - t2.toSegundos();
        if (dif < 0) {
            res = -1;
        } else {
            if (dif == 0) {
                res = 0;
            } else {
                res = 1;
            }
        }
        return (res);
    }

    public static Tempo diferencaTempo(Tempo t1,Tempo t2) {
        int dif = t1.diferencaSegundos(t2);
        System.out.println(dif);
        int h = dif / 3600;
        int r = dif%3600*60;
        System.out.println(h);
        int m = r / 3600;
        r=r%3600*60;
        System.out.println(m);
        int s = r/3600;
        System.out.println(s);
        Tempo diferenca = new Tempo(h, m, s);
        return (diferenca);
    }

    public String toStringhhmmssAMPM() {
        String s;
        String ampm = "AM";
        if (hora < 10) {
            s = "0" + hora;
        } else {
            if (hora > 12) {
                s = "" + (hora - 12);
                ampm = "PM";
            } else {
                s = "" + hora;
            }
        }
        if (minuto < 10) {
            s = s + ":0" + minuto;
        } else {
            s = s + ":" + minuto;
        }
        if (segundo < 10) {
            s = s + ":0" + segundo;
        } else {
            s = s + ":" + segundo;
        }
        s = s + " " + ampm;
        return (s);
    }
}

