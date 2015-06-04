package pl_7_ex3;

public class PL_7_ex3 {

    public static void main(String[] args) {
        int x;
        int m[][] = {{1, 4, 2, 1}, {9, 7, 2, 2}, {1, 7, 3, 5}, {2, 5, 0, 3}, {4, 7, 2, 1}};
        for (int i = 0; i < m.length; i++) {
            x = m[i][0];
            for (int j = 1; j < m[i].length; j++) {
                if (m[i][j] > x) {
                    x = m[i][j];
                }
            }
            System.out.println(x);
        }
        imprime(m);
        apresentaMedias(m);
        transposta(m);
    }

    private static void imprime(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " | ");
            }
            System.out.println("");
        }
    }

    private static void apresentaMedias(int[][] m) {
        int mediaC = 0;
        int mediaT = 0;
        System.out.println("" + m.length);
        for (int i = 0; i < m[0].length; i++) {
            for (int j = 0; j < m.length; j++) {
                mediaC += m[j][i];
                mediaT += m[j][i];
            }
            System.out.println("Media da coluna " + i + ": " + mediaC/m[0].length);
            mediaC = 0;
        }
        System.out.println("Media da matriz: " + mediaT/(m[0].length*m.length));
    }

    private static void transposta(int[][] m) {
        int[][]tra = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                tra[j][i] = m[i][j];
            }
        }
        imprime(tra);
    }
}