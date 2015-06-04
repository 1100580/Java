
package centrocomercial;

public class Restauracao extends Espaco {

    private boolean esplanada;
    private double valorPagarTotal;
    private double valorSEsplanada = 20;
    private double valorCEsplanada = 15;

    public Restauracao(String localizacao, double area, boolean esplanada){
        super(localizacao, area);
        setValorPagarTotal();
        setEsplanada(esplanada);
    }

    public double getValorCEsplanada() {
        return valorCEsplanada;
    }

    public double getValorSEsplanada() {
        return valorSEsplanada;
    }

    public boolean getEsplanada() {
        return esplanada;
    }

    public void setEsplanada(boolean esplanada) {
        this.esplanada = esplanada;
    }

    public double getValorPagarTotal() {
        return valorPagarTotal;
    }

    public void setValorPagarTotal() {
        this.valorPagarTotal = getEsplanada() ? valorCEsplanada*super.getArea() : valorSEsplanada*super.getArea();
    }

}
