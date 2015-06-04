public class TesteComparavel {
    public static Object pesquisar(Comparavel[] a,Object obj){
        int i=0;
        while(i<a.length && !a[i].igual(obj))
            i++;
        if (i<a.length)
            return a[i];
        else
            return null;
    }
    
    public static void main(String[] args){
        Comparavel[] a=new Comparavel[5];
        a[0]=new Carro("22-26-ZH","Toyota");
        a[1]=new Livro("Os Lusiadas","Luís de Camões");
        a[2]=new Carro("AA-00-00","Opel");
        a[3]=new Carro("BB-00-00","Nissan");
        a[4]=new Livro("Memorias de Elefante","Saramago");
        Carro obj1=new Carro("AA-00-00",null);
        Comparavel aux=(Comparavel)pesquisar(a,obj1);
        System.out.println(aux==null? obj1.getMatricula()+" não existe":aux);
        Livro obj2=new Livro("Memorias de Elefante",null);
        aux=(Comparavel)pesquisar(a,obj2);
        System.out.println(aux==null? obj2.getTitulo()+" não existe":aux);
    }
}
