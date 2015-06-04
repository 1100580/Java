package equipamento;

public class Impressora extends Equipamento {

    private int tipo;
    private static boolean[] impressoraEmPromocao = {false, false, false};
    private static String[] tipoImpressora = {"laser", "jacto de tinta", "matriz de pontos"};

    public Impressora(String marca, String modelo, float precoCusto, int tipo){
        super(marca, modelo, precoCusto);
        setTipo(tipo);
    }

    @Override
    public boolean estaEmPromocao() {
        return impressoraEmPromocao[getTipo()];
    }

    @Override
    public String toString() {
        return "Impressora " + getMarca() + " " + getModelo() + ", tipo: " + tipoImpressora[getTipo()] + ". Preço: " + super.precoVenda();
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public  static void setImpressoraEmPromocao(int tipo) {
        impressoraEmPromocao[tipo] = true;
    }

    public static void setImpressoraSemPromocao(int tipo) {
        impressoraEmPromocao[tipo] = false;
    }

}