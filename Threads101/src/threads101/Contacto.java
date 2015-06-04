/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads101;

public class Contacto {
    public int numero;
    public String nome, morada;
    
    public Contacto(int numero, String nome, String morada){
        this.numero = numero;
        this.nome = nome;
        this.morada = morada;
    }
    
    @Override
    public String toString(){
        return "Nome: " + nome + "\n" + "Numero: " + numero + "\n" + "Morada: " + morada + "\n";
    }
}
