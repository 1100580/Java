/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopprog;

/**
 *
 * @author Tiago
 */
public abstract class Pergunta {

    protected String perg;
    protected String topico;

    public Pergunta(String p, String t) {
        perg = p;
        topico = t;
    }

    public abstract String getPergunta();

    public abstract int getNumeroRespostas();

    public String getTopico() {
        return (this.topico);
    }
}
