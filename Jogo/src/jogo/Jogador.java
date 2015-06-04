/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jogo;

/**
 *
 * @author Gisela
 */
public class Jogador {
    
    private String nickname;
    private String nomeProprio;
    private int pontuacao;
    private static Jogador jogadorActual = null;

    public Jogador(String nickname, String nomeProprio, int pontuacao){
        setNickname(nickname);
        setNomeProprio(nomeProprio);
        setPontuacao(pontuacao);
    }
    
    private Jogador(){
        nickname = "";
        nomeProprio="";
        pontuacao=0;
    }
    // chama-se Singleton - criei um atruibuto e um metodo estatico porque desta forma perimte que haja um unico utilizador a jogar o jogo corrente
    public static Jogador criaJogador(){
        if (jogadorActual==null) {
            jogadorActual= new Jogador();
        }
    return jogadorActual;

    }
   

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the nomeProprio
     */
    public String getNomeProprio() {
        return nomeProprio;
    }

    /**
     * @param nomeProprio the nomeProprio to set
     */
    public void setNomeProprio(String nomeProprio) {
        this.nomeProprio = nomeProprio;
    }

    /**
     * @return the pontuacao
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * @param pontuacao the pontuacao to set
     */
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }


    public int calcularPontuacao(int numJogadas) {
        pontuacao = numJogadas * 10;
        return pontuacao;
    }

      public String toString() {
        return String.format("Nickname: %s - Nome: %s - Pontuação: %d", nickname, nomeProprio, pontuacao);
    }

}
