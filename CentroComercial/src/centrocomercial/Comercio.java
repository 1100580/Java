
package centrocomercial;

public class Comercio extends Espaco {
    private double valorPagarTotal;
    private double valorM2 = 20;

    public Comercio(String localizacao, double area){
        super(localizacao, area);
        setValorPagarTotal();
    }

    public double getValorM2() {
        return valorM2;
    }

    public double getValorPagarTotal() {
        return valorPagarTotal;
    }

    public void setValorPagarTotal() {
        this.valorPagarTotal = getArea()*getValorM2();
    }

}
