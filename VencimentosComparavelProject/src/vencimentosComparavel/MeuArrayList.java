package vencimentosComparavel;

import java.util.ArrayList;

public class MeuArrayList extends ArrayList {
    
    public void ordenar() {
        for( int i=0; i < this.size()-1; i++ ) {
            for( int j=i+1; j < this.size(); j++ ) {
                Comparavel obj1 = (Comparavel) get(i);
                Comparavel obj2 = (Comparavel) get(j);
                
                if( obj2.menor(obj1) )
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
