/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sadecp;

import java.util.ArrayList;

public class Medicamento {
    
    String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<ContraI> getContraIndicadoes() {
        return contraIndicadoes;
    }

    public void setContraIndicadoes(ArrayList<ContraI> contraIndicadoes) {
        this.contraIndicadoes = contraIndicadoes;
    }
    ArrayList<ContraI> contraIndicadoes;
    
    public Medicamento(String n, ArrayList<ContraI> ci){
        setNome(n);
        setContraIndicadoes(ci);
    }
}
