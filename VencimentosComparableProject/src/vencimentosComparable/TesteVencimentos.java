package vencimentosComparable;

public class TesteVencimentos {
    
    public static void main(String[] args) {
        MeuArrayList lstTrabs = new MeuArrayList();
        
        lstTrabs.add( new Patrao("Jorge Silva", 800.00f) );
        lstTrabs.add( new TrabCom("Susana Ferreira", 400.00f, 1500.00f, 0.06f));
        lstTrabs.add( new TrabHora("Carlos Miguel", 160, 3.50f) );
        lstTrabs.add(new TrabPeca("Ana Maria",100,5f));
        
        System.out.println("\n---Listagem de vencimentos:");
        for (int i=0; i<lstTrabs.size(); i++) {
            Trabalhador t = (Trabalhador) lstTrabs.get(i);
            System.out.println(t.toString() + " ...tem o vencimento de " + t.vencimento());
        }
        
        lstTrabs.ordenar();
        
        System.out.println("\n---Listagem ordenada crescente de vencimentos:");
        for (int i=0; i<lstTrabs.size(); i++)
            System.out.println(lstTrabs.get(i).toString() + " ...tem o vencimento de " + ( (Trabalhador) lstTrabs.get(i) ).vencimento());
    }
    
}

