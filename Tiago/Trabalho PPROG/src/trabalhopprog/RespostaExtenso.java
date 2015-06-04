/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopprog;

/**
 *
 * @author Tiago
 */
public class RespostaExtenso extends Pergunta {

    private String[] respostas_certas;

    public RespostaExtenso(String p, String[] r, String t) {
        super(p, t);
        respostas_certas = r;
    }

    public String[] getRespostasCertas() {
        return (this.respostas_certas);
    }

    public String getPergunta() {
        return (this.perg);
    }

    public int getNumeroRespostas() {
        return (0);
    }

    public int ValidaResposta(String s) {
        String[] r = this.getRespostasCertas();
        if (s.equals("")) {
            return (0);
        } else {
            for (int i = 0; i < r.length; i++) {
                if (s.trim().toLowerCase().equals(r[i])) {
                    return (1);
                }
            }
            return (-1);
        }
    }
}
