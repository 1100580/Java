
package agendatelefonica;

public class Empresa extends Entrada {

    private String email;
    private int fax;

    public Empresa(String nome, int telefone, int fax, String email){
        super(nome, telefone);
        setEmail(email);
        setFax(fax);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFax() {
        return fax;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public String toString(){
        return ((getNome().isEmpty() ? "" : getNome() + "\n" ) + (getTelefone() == 0 ? "" : getTelefone() + "\n" ) + (getFax() == 0 ? "" : getFax()) + "\n" )  + (getEmail().isEmpty() ? "" : getEmail() + "\n");
    }
}
