/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacarapp_model;

public class Cliente {

    private int id, telefone, ida;
    private float valAc;
    private String nome;
    private Morada morada;

    public Cliente(int id, int telefone, String nome, String rua, int numero) {
        setId(id);
        setTelefone(telefone);
        setNome(nome);
        Morada m1 = new Morada(rua, numero);
        setMorada(m1);
    }
    
    public Cliente(int id, int telefone, String nome, String rua, int numero, int ida) {
        setId(id);
        setTelefone(telefone);
        setNome(nome);
        Morada m1 = new Morada(rua, numero);
        setMorada(m1);
        this.ida = ida;
    }

    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the telefone
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the morada
     */
    public Morada getMorada() {
        return morada;
    }

    /**
     * @param morada the morada to set
     */
    public void setMorada(Morada morada) {
        this.morada = morada;
    }
    
    @Override
    public String toString(){
        return ("\n"
                + "------------------------\n"
                + "ID: " + getId() + "\n"
                + "Nome: " + getNome() + "\n"
                + "Telefone: " + getTelefone() + "\n"
                + "Rua: " + getMorada().getRua() + "\n"
                + "Numero de porta: " + getMorada().getNumero() + "\n"
                + "------------------------\n");
    }

    public void addValAc(float valorTotal) {
        setValAc(getValAc() + valorTotal);
    }

    /**
     * @return the valAc
     */
    public float getValAc() {
        return valAc;
    }

    /**
     * @param valAc the valAc to set
     */
    public void setValAc(float valAc) {
        this.valAc = valAc;
    }
}
