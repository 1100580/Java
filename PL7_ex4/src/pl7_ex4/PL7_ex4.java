package pl7_ex4;

public class PL7_ex4 {

    public static void main(String[] args) {
        int[][] m = {{8,1,6},{3,5,7},{4,9,2}};
        if (magico(m)) {
            System.out.println("É quadrado mágico.");
        }
    }

    private static boolean magico(int[][] m) {
        int c1 = 0,c2 = 0;
        int tl, tc;
        for (int i = 0; i < m.length - 1; i++) {
            for (int j = 0; j < m[0].length - 1; j++) {
                c1 += m[i][j];
                c2 += m[i+1][j+2];
            }
            if (c1 != c2) {
                return false;
            }
        }
        tl = c1;
        c1 = 0; c2 = 0;
        
        for (int i = 0; i < m[0].length-1; i++) {
            for (int j = 0; j < m.length-1; j++) {
                c1 += m[i][j];
                c2 += m[i+1][j+1];
            }
            if (c1 != c2) {
                return false;
            }
        }
        tc = c1;
        c1 = 0; c2 = 0;
        
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i == j) {
                    c1 += m[i][j];
                }
            }
        }
        
        int [][] t = transposta(m);
        
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if (i == j) {
                    c2 += t[i][j];
                }
            }
        }
        if (c1 != c2) {
            return false;
        }
        return true;
    }

    private static int[][] transposta(int[][] m) {
        int[][]tra = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                tra[j][i] = m[i][j];
            }
        }
        return tra;
    }
}
