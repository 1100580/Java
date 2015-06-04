/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparavel;

/**
 *
 * @author i090674
 */
public class Carro implements Comparavel{

    protected String matricula;
    protected String marca;

    public Carro(String m1, String m2) {
        matricula = m1;
        marca = m2;
    }

    public boolean igual(Object obj){
        boolean b=false;
        if(obj instanceof Carro){
            Carro c = (Carro) obj;
            if(this.matricula.equals(c.matricula))
                b=true;
        }
        return b;
    }
}
