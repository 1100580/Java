/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparavel;

/**
 *
 * @author i090674
 */
public class Livro implements Comparavel {

    protected String titulo;
    protected String autor;

    public Livro(String m1, String m2) {
        titulo = m1;
        autor = m2;
    }

    public boolean igual(Object obj){
        boolean b=false;
        if(obj instanceof Livro){
            Livro c = (Livro) obj;
            if(this.titulo.equals(c.titulo))
                b=true;
        }
        return b;
    }
}
