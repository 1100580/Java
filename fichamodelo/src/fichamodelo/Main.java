package fichamodelo;

public class Main {

    public static void main(String[] args) {
        Livros l1 = new Livros("Miguel",50f,"Manuel");
        Software s1 = new Software("João",40f,"Adobe Photoshop CS5");

        System.out.println(l1.toString());
        System.out.println(s1.toString());

    }
}