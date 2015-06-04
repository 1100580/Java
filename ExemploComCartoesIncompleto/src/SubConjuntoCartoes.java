import java.lang.reflect.Array;
import java.util.ArrayList;

public class SubConjuntoCartoes extends ArrayList <Cartao> {
    
    public SubConjuntoCartoes(ArrayList <Cartao> a) {
        super(a);
    }

    public ArrayList <Cartao.Cor>  coresDosCartoes() {
        // Devolve o conjunto das varias cores (Azul, Vermelho, etc.)
        // que existem no subconjunto.
        ArrayList <Cartao.Cor> cores = new ArrayList();
        for (int i = 0; i < this.size(); i++) {
            Cartao p = (Cartao)this.get(i);
            for (int j = 0; j < this.size(); j++) {
                if (cores.contains(p)) {
                }
                else{
                    cores.add(p.getCor());
                }
            }
        }
        return cores;
    }

    public int contarCartoesPorCor(Cartao.Cor cor) {
        // Dado uma cor, conta quantos cartoes existem dessa cor no subconjunto
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public void ordenar() {
       // Ordena o subconjunto, primeiro por cor e, para a mesma cor, por numero
       // Cartao deve implementar a interface Comparable <Cartao>
       throw new UnsupportedOperationException("Not yet implemented");
    }
}
