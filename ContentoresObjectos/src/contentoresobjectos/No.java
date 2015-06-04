
package contentoresobjectos;

public class No {

    private Veiculo elemento;
    private No prox;

    public No(Veiculo elem, No pr){
        setElemento(elem);
        setProx(pr);
    }

    public No(){
        this(null, null);
    }

    public Veiculo getElemento() {
        return elemento;
    }

    public void setElemento(Veiculo elemento) {
        this.elemento = elemento;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}
