/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopprog;

/**
 *
 * @author Tiago
 */
public class RespostaUnica extends Pergunta {

    private int resp_certa;
    private String[] respostas;

    public RespostaUnica(String p, String[] r, int rc, String t) {
        super(p, t);
        respostas = r;
        resp_certa = rc;
    }

    public String[] getRespostas() {
        return (this.respostas);
    }

    public int getRespostaCerta() {
        return (this.resp_certa);
    }

    public String getPergunta() {
        return (this.perg);
    }

    public int getNumeroRespostas() {
        return (this.respostas.length);
    }

    public int ValidaResposta(int res) {
        if (res == 0) {
            return (0);
        } else if (res == this.getRespostaCerta()) {
            return (1);
        } else {
            return (-1);
        }
    }
}

