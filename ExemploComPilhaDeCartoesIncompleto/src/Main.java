public class Main {

   public static void main(String[] args) {

      PilhaCartoes conj = new PilhaCartoes();
      System.out.println("Cartoes iniciais: " + conj);

      // Partir
      conj.partir();
      System.out.println("Cartoes depois de partir: " + conj);

      // Retirar os primeiros 3 cartoes
      System.out.println("Primeiros 2 cartoes: " + conj.primeirosCartoes(3));
      System.out.println("Restantes Cartoes: " + conj);

      // Retirar os ultimos 2 cartoes
      System.out.println("Ultimos 2 cartoes: " + conj.ultimosCartoes(2));
      System.out.println("Restantes Cartoes: " + conj);
   }
}
