
package vencimentos;

public class teste {

    public static void main(String[] args) throws ValorNegativo {
        Trabalhadores[] t = new Trabalhadores[3];
        Patrao p = new Patrao("Jorge Silva", 800);
        TrabCom tc = new TrabCom("Susana Ferreira", 400, 1500, 0.06f);
        TrabHora th = new TrabHora("Carlos Miguel", 160, 3.5f);

         t[0] = p;
         t[1] = tc;
         t[2] = th;

        for (int i = 0; i < 3; i++) {
            System.out.println(t[i]+", Vencimento: "+t[i].vencimento());
        }

        System.out.println("");
        
        for (int i = 0; i < 3; i++) {
            if (t[i] instanceof TrabHora ) {
                System.out.println(t[i] + ", Vencimento: "+t[i].vencimento());
            }
        }
    }
}
