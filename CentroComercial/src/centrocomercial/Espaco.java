
package centrocomercial;

public abstract class Espaco {
    private String localizacao;
    private double area;

    public Espaco(String localizacao, double area){
        setLocalizacao(localizacao);
        setArea(area);
    }

    public abstract double getValorPagarTotal();

    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
