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
public class Biblioteca {
    ArrayList<Livro> Livros;
    ArrayList<Autor> Autores;

    public Biblioteca() {
        Livros = new ArrayList<Livro>();
        Autores = new ArrayList<Autor>();
    }

    public ArrayList<Autor> getAutores() {
        return Autores;
    }

    public ArrayList<Livro> getLivros() {
        return Livros;
    }

    public void addLivro(Livro l){
        Livros.add(l);
    }

    public void addAutor(Autor a){
        Autores.add(a);
    }
}
