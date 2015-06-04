
package comparavel;

public class TesteComparavel {

    public static Object pesquisar(Comparavel[] a, Object obj){
        int i=0;
        while (i < a.length && !a[i].igual(obj))
            i++;
        if (i<a.length) {
            return a[i];
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        Comparavel a[] = new Comparavel[5];
        a[0] = new Carro ("Nissan", "03aa03");
        a[1] = new Carro ("Toyota", "343434");
        a[2] = new Carro ("Citroen", "00zz00");
        a[3] = new Carro ("Fiat", "100000");
        a[4] = new Carro ("Seat", "0455aa");

        Carro obj1 = new Carro("Seat", null);

        Comparavel aux = ((Comparavel)pesquisar(a, obj1));

        System.out.println(aux == null? obj1.matricula + "Não existe." : aux);
    }
}