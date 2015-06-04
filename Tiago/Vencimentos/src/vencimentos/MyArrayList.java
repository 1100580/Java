/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vencimentos;
import java.util.ArrayList;
/**
 *
 * @author i090674
 */
public class MyArrayList extends ArrayList{

    public void ordenar(){

        for (int i = 0; i < this.size()-1; i++) {
            Trabalhador t1= (Trabalhador) this.get(i);
            for (int j = i+1; j < this.size(); j++) {
                Trabalhador t2= (Trabalhador) this.get(j);
                if(t2.maior(t1)){
                    this.set(i,t2);
                    this.set(j,t1);
                }
            }
        }
    }
}
