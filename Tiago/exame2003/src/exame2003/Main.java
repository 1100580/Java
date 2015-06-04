/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exame2003;

/**
 *
 * @author Tiago
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Biblioteca b = new Biblioteca();
       Livro l1 = new Livro("coisinhas",true);
       b.addLivro(l1);
       Autor a1 = new Autor("tone");
       l1.addAutor(a1);
       b.addAutor(a1)
       Autor a2 = new Autor("jakim");
       b.addAutor(a1);
       a1.addLivro(new Livro("ceninhas",false));
       System.out.println(b.getAutores());
       System.out.println(b.getLivros());
    }

}
