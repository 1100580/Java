package pl_7;

public class PL_7_ex1 {

    public static void main(String[] args) {
        //Ordena um vector de Strings pela quantidade de strings que tem
        String[] v = new String[3];
        v[0] = "A...";
        v[1] = "D..";
        v[2] = "C.";
        int n = 3;
        //ordenaPorNLetras(v,n);
        apresentaAlfa(v,n);
        //imprime(v);
    }

    public static void ordenaPorNLetras(String[] v, int n) {
        int m;
        String tmp;
        for (int i = 0; i < n - 1; i++) {
            m = i;
            for (int j = i + 1; j < n; j++) {
                if (v[j].length() < v[m].length()) {
                    m = j;
                }
            }
            if (m != i) {
                tmp = v[i];
                v[i] = v[m];
                v[m] = tmp;
            }
        }
    }

    private static void imprime(String[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i] + "; ");
        }
    }

    private static void apresentaAlfa(String[] v1, int n) {
        int m;
        String tmp;
        String[] v = v1;
        
        for (int i = 0; i < n-1; i++) {
            m = i;
            for (int j = i+1; j < n; j++) {
                if (v[j].charAt(0) < v[m].charAt(0)) {
                    m = j;
                }
            }
            if (m != i) {
                tmp = v[i];
                v[i] = v[m];
                v[m] = tmp;
            }
        }
        
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i] + "; ");
        }
    }
}