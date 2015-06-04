package jogo;

import java.util.ArrayList;
import jogo.Jogador;


public class Jogadores {

    private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

    public  ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public  int getTotalJogadores() {
        return jogadores.size();
    }

     public boolean adicionarConta(Jogador j) {
        return jogadores.add(j);
    }

    public boolean removerConta(Jogador j) {
            return jogadores.remove(j);
    }


    public boolean estaVazio() {
        return jogadores.isEmpty();
    }




    }
