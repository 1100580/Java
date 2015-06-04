
package threads101;

import java.util.ArrayList;

public class Threads101 {

    public static void main(String[] args) {
        ArrayList<Contacto> ay = new ArrayList<Contacto>();
        ay.add(new Contacto(1,"Ze","Rua1"));
        ay.add(new Contacto(2,"Rui","Rua2"));
        ay.add(new Contacto(3,"Tiago","Rua3"));
        ay.add(new Contacto(4,"Pedro","Rua4"));
        ay.add(new Contacto(5,"Ana","Rua5"));
        
        ClassT c1 = new ClassT(ay.get(0));
        ClassT c2 = new ClassT(ay.get(1));
        ClassT c3 = new ClassT(ay.get(2));
        ClassT c4 = new ClassT(ay.get(3));
        ClassT c5 = new ClassT(ay.get(4));
        
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);
        Thread t5 = new Thread(c5);
        
        t1.start();t2.start();t3.start();t4.start();t5.start();
        
    }
}
