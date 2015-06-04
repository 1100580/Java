
package tccrt;

public class TCCRT {

    public static void main(String[] args) {
        Material ferro = new Material("Ferro", (float)3.56);
        LeiFourier f1 = new LeiFourier((float) 4, (float) 6, (float)2, ferro);
    }
}