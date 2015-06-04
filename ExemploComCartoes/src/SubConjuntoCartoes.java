import java.util.ArrayList;
import java.util.Collections;

public class SubConjuntoCartoes extends ArrayList <Cartao> {

    public SubConjuntoCartoes(ArrayList <Cartao> a) {
        super(a);
    }

    public ArrayList <Cartao.Cor>  coresDosCartoes() {
        // Devolve o conjunto das varias cores (Azul, Vermelho, etc.)
        // que existem no subconjunto.
        //throw new UnsupportedOperationException("Not yet implemented");
        ArrayList <Cartao.Cor> a = new ArrayList <Cartao.Cor>(4);
        for (Cartao c : this) if (!a.contains(c.getCor())) a.add(c.getCor());
        return a;
    }

    public int contarCartoesPorCor(Cartao.Cor cor) {
        // Dado uma cor, conta quantos cartoes existem no subconjunto dessa cor
        //throw new UnsupportedOperationException("Not yet implemented");
        int x = 0;
        for (Cartao c : this) if (c.getCor() == cor) x++;
        return x;
    }

    public void ordenar() {
       // Ordena o subconjunto, primeiro por cor e, para a mesma cor, por numero
       // Cartao deve implementar a interface Comparable <Cartao>
       //throw new UnsupportedOperationException("Not yet implemented");
        Collections.sort( this ) ;
    }
}