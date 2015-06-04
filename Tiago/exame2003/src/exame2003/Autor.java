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
public class Autor {
    private String nome;
    ArrayList<Livro> livros;

    public Autor(String nome) {
        this.nome = nome;
        livros=new ArrayList<Livro>();
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public String getNome() {
        return nome;
    }

    public void addLivro(Livro l){
        livros.add(l);
        l.addAutor(this);
    }
}
