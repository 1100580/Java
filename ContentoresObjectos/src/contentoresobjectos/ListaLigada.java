
package contentoresobjectos;

public class ListaLigada {

    private No cabeca = null;
    private int tamanho = 0;

    public ListaLigada(){
        cabeca = null;
        tamanho = 0;
    }

    public void inserirInicio(Veiculo elem){
        cabeca = new No(elem, cabeca);
        tamanho++;
    }

    public void inserirFim(Veiculo elem){
        if (cabeca == null) {
            cabeca = new No(elem, null);
        } else{
            No n = cabeca;
            while (n.getProx() != null){
                n = n.getProx();
            }
            n.setProx(new No(elem, null));
        }
        tamanho++;
    }
    
    public Veiculo removerInicio(){
        if (listaVazia()) {
            return null;
        } else {
            Veiculo v = cabeca.getElemento();
            cabeca = cabeca.getProx();
            tamanho--;
            return v;
        }
    }

    public String listar(){
        String s = "Listagem dos elementos \n";
        if (listaVazia()) {
            s = String.format("A lista não tem elementos. \n");
        } else {
            No n = cabeca;
            while (n != null){
                s = s + String.format(n.getElemento().printToString() + "\n");
                n = n.getProx();
            }
        }
        return s;
    }

    public boolean listaVazia(){
        return cabeca == null;
    }

}
