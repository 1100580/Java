/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

/**
 *
 * @author i090674
 */
public class ListaLigada {

    private No cabeca;
    private int tamanho;

    public ListaLigada(No c, int t) {
        cabeca = c;
        tamanho = t;
    }

    public ListaLigada() {
    }

    public void setCabeca(Veiculo v) {
        No n = new No(v, cabeca);
        cabeca = n;
        tamanho++;
    }

    public void cutCabeca() {
        if(cabeca!=null){
        cabeca = cabeca.getProximo();
        tamanho--;
        }
        else
            System.out.println("Cabeca = null");
    }

    public boolean isEmpty() {
        boolean b = false;
        if (cabeca == null) {
            b = true;
        }
        return b;
    }

    public String toString() {
        String s="";
        No w= cabeca;
        while (w != null) {
            s = s+w.toString()+"\n";
            w=w.getProximo();
        }
        return s;
    }
}
