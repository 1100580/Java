package vencimentosComparable;

import java.util.ArrayList;

public class MeuArrayList extends ArrayList {
    
    public void ordenar() {
        for( int i=0; i < this.size()-1; i++ ) {
            for( int j=i+1; j < this.size(); j++ ) {
                Comparable obj1 = (Comparable) get(i);
                Comparable obj2 = (Comparable) get(j);
                
                if( obj2.compareTo(obj1)==-1 )
                    troca(j, i);
            }
        }
    }
    
    private void troca( int j, int i ) {
        Object temp = get(j);
        set( j, get(i) );
        set( i, temp );
    }
    
}
