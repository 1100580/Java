
package ficha3;

import javax.swing.JOptionPane;


public class Contentor {
    int n = Integer.parseInt(JOptionPane.showInputDialog("Qual o tamanho do primeiro array?"));
    Object[] Contentor = new Object[n];

    public void juntarFim(Object obj){
        Contentor[Contentor.length] = obj;
    }

    public void juntarPos(int pos, Object obj){
        Contentor[pos] = obj;
    }

    public void remover(int pos){
        for (int i = pos; i < Contentor.length; i++) {
            Contentor[i] = Contentor[i+1];
        }
    }

    public int tamanho(){
        int tamanho = 0;
        for (int i = 0; i < Contentor.length; i++) {
            if (Contentor[i] != null) {
                tamanho ++;
            }
        }
        return tamanho;
    }

    public boolean vazio(){
        if (Contentor[0] == null) {
            return true;
        } else{
            return false;
        }
    }

    public Object getElemento(int pos){
        return Contentor[pos];
    }

    public void listar(){
        for (int i = 0; i < Contentor.length; i++) {
            System.out.println("\n" + Contentor[i].toString());
        }
    }
}

