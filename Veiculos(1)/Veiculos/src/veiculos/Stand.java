
package veiculos;

import java.util.ArrayList;

public class Stand extends ArrayList<Veiculo> {

    public void adicionar(Veiculo V) {
        try {
            this.add(V);
        } catch (Exception e) {
            System.out.println("O veiculo nao foi adicionado");
        }

    }

    public void remover(Veiculo V) {
        try {
            this.remove(V);
        } catch (Exception E) {
            System.out.println("O veiculo nao foi removido");
        }

    }

    public String NumTotal() {
        return "Existem " + this.size() + "carros no stand";
    }

    public void Listar() {
        for (Veiculo v : this) {
            System.out.println(v.toString());
            System.out.println("");
        }
    }

 ;
}
