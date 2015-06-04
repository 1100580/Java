
package manipulavecs;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class ManipulaVecs {
    public static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Dimensão do vector?"));
        int[] vec = new int[n];
        lerVec(vec);
        trocaVec(vec);
        imprime(vec);
        shiftDir(vec);
        imprime(vec);
    }

    private static void lerVec(int[] vec) {
        for (int i = 0; i < vec.length; i++) {
            vec[i] = in.nextInt();
        }
    }

    private static void trocaVec(int[] vec) {
        for (int i = 0; i < vec.length; i++) {
            for (int j = vec.length - 1; j > 0; j--) {
                int temp = vec[i];
                vec[i] = vec[j];
                vec[j] = temp;
            }
        }
    }

    private static void imprime(int[] vec) {
        for (int i = 0; i < vec.length; i++) {
            System.out.println(vec[i]);
        }
    }

    private static void shiftDir(int[] vec) {
        int tempor = vec[vec.length];
        for (int i = 0; i < vec.length - 1; i++) {
            vec[i+1] = vec[i];
        }
        vec[0] =tempor;
    }
}
