
package uniaointerseccao;

public class UniaoInterseccao {

    public static void main(String[] args) {
        int[] vec1 = new int[5];
        int[] vec2 = new int[5];
        
        intersect(vec1, vec2);
        union(vec1,vec2);
    }

    private static void intersect(int[] vec1, int[] vec2) {
        for (int i = 0; i < vec1.length; i++) {
            int num = vec1[i];
            for (int j = 0; j < vec2.length; j++) {
                if (vec2[i] == num) {
                    System.out.println("" + num);
                }
            }
        }
    }

    private static void union(int[] vec1, int[] vec2) {
        for (int i = 0; i < vec1.length; i++) {
            System.out.println("" + vec1[i]);
        }
        
        boolean checks = false;
        for (int i = 0; i < vec2.length; i++) {
            int num = vec2[i];
            for (int j = 0; j < vec1.length; j++) {
                if (vec1[i] == num) {
                    checks = true;
                }
            }
            if (!checks) {
                System.out.println("" + num);
            }
        }
    }
}
