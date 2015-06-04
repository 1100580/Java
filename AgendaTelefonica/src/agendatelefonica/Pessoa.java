
package agendatelefonica;

public class Pessoa extends Entrada {

    private int telemovel;

    public Pessoa(String nome, int telefone, int telemovel){
        super(nome, telefone);
        setTelemovel(telemovel);
    }

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public String toString(){
        return ((getNome().isEmpty() ? null : getNome() + "\n" ) + (getTelefone() == 0 ? null : getTelefone() + "\n" ) + (getTelemovel() == 0 ? null : getTelemovel()) + "\n" );
    }

}
