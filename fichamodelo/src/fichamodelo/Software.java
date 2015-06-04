
package fichamodelo;

public class Software extends Produto {

    private String versao;

    public Software(String nome, float custo, String versao){
        super(nome,custo);
        setVersao(versao);
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

     public String toString(){
        return String.format(super.toString(),"Versão: ", versao);
    }
}