/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exame2003;

import java.util.ArrayList;

/**
 *
 * @author Tiago
 */
public class Livro {
    private String titulo;
    private ArrayList<Autor> autores;
    private boolean disponivel;

    public Livro(String titulo, boolean disponivel) {
        this.titulo = titulo;
        this.disponivel = disponivel;
        autores=new ArrayList<Autor>();
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void addAutor(Autor a){
        autores.add(a);
    }
}
