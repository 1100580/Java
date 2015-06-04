/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pl7ex2;

/**
 *
 * @author i090674
 */
public class Main {

    public static void enigma_2( String[] v, int n ){
        int i, j, m;
        String tmp;
        for ( i=0; i<n-1; i++ ) {
            m = i;
            for ( j=i+1; j<n; j++ )
                if ( v[j].length() > v[m].length())
                    m = j;
            if ( m != i ){
                tmp = v[i];
                v[i] = v[m];
                v[m] = tmp;
            }
        }
        for(i=0;i<v.length;i++)
        System.out.println(v[i]);
    }

     public static void alfabeto( String[] v, int n ){
        int i, j, k, m;
        String tmp;
        for ( i=0; i<n-1; i++ ) {
            m = i;
            for ( j=i+1; j<n; j++ )
                for(k=0;k<999;k++){
                    if ( v[j].charAt(k) < v[m].charAt(k) ){
                        m = j;
                        break;
                    }
                    if ( v[j].charAt(k) > v[m].charAt(k) )
                        break;
                    else{
                        continue;
                    }
                }
            if ( m != i ){
                tmp = v[i];
                v[i] = v[m];
                v[m] = tmp;
            }
        }
        for(i=0;i<v.length;i++)
        System.out.println(v[i]);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String []v={"cibas","j","ciso","domosites","earcinho"};
        alfabeto(v,5);
    }

}
