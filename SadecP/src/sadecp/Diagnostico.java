/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sadecp;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Diagnostico {
    private String nome;
    private ArrayList<Medicamento> tratamentos;
    
    public Diagnostico(String n, ArrayList<Medicamento> t){
        setNome(n);
        setTratamentos(t);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Medicamento> getTratamentos() {
        return tratamentos;
    }

    public void setTratamentos(ArrayList<Medicamento> tratamentos) {
        this.tratamentos = tratamentos;
    }
    
}
