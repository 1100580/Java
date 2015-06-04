
package vencimentos;

public class ValorNegativo extends Exception {
    public ValorNegativo(){
        super("Atenção: valor negativo");
    }

    public ValorNegativo(String s){
        super("Atenção: valor negativo na criação de um novo " + s + ".");
    }
}
