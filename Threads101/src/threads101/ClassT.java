
package threads101;

public class ClassT implements Runnable {
    private Contacto c;
    public ClassT(Contacto c1){
        c = c1;
    }

    @Override
    public void run() {
        System.out.println(c.toString());
    }
}
