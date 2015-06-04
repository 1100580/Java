/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopprog;

/**
 *
 * @author Tiago
 */
public class RespostaMultipla extends Pergunta {

    private boolean[] resp_certas;
    private String[] respostas;

    public RespostaMultipla(String p, String[] r, boolean[] rc, String t) {
        super(p, t);
        respostas = r;
        resp_certas = rc;
    }

    public String[] getRespostas() {
        return (this.respostas);
    }

    public boolean[] getRespostasCertas() {
        return (this.resp_certas);
    }

    public String getPergunta() {
        return (this.perg);
    }

    public int getNumeroRespostas() {
        return (this.respostas.length);
    }

    public int ValidaResposta(boolean[] r) {
        boolean[] b = this.getRespostasCertas();
        int cont = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] == false) {
                cont++;
            }
        }
        if (cont == b.length) {
            return (0);
        }
        int cont1 = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] == r[i]) {
                cont1++;
            }
        }
        if (cont1 == b.length) {
            return (1);
        } else {
            return (-1);
        }
    }
}
