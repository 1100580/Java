/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package veiculos;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diogo
 */
public abstract class Veiculo {

    private static int id = 1;
    private int numero;
    private String marca;
    private String matricula;
    private double cilindrada;
    private double preco;
    ArrayList carro=new ArrayList();
    public Veiculo(){

    }

    public Veiculo(String marca, String matricula, double cilindrada, double preco) {
        setMarca(marca);
        setMatricula(matricula);
        setCilindrada(cilindrada);
        setPreco(preco);
        setNumero(id);
        carro.add(id-1);
        id++;

    }


    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the cilindrada
     */
    public double getCilindrada() {
        return cilindrada;
    }

    /**
     * @param cilindrada the cilindrada to set
     */
    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }


       public abstract String toString();
}
