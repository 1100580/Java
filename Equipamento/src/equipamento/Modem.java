package equipamento;

public class Modem extends Equipamento {

    private int localizacao;
    private static boolean[] modemEmPromocao = {false, false};
    private static String[] localizacaoModem = {"interno", "externo"};

    public Modem(String marca, String modelo, float precoCusto, int localizacao){
        super(marca, modelo, precoCusto);
    }

    public static void setModemEmPromocao(int localizacao){
        modemEmPromocao[localizacao] = true;
    }

    public static void setModemSemPromocao(int localizacao){
        modemEmPromocao[localizacao] = false;
    }

    @Override
    public boolean estaEmPromocao() {
        return modemEmPromocao[getLocalizacao()];
    }

    @Override
    public String toString() {
        return "Computador " + getMarca() + " " + getModelo() + ", localização:  " + localizacaoModem[getLocalizacao()] + ". Preço: " + super.precoVenda();
    }

    public static boolean[] getModemEmPromocao() {
        return modemEmPromocao;
    }

    public static String[] getLocalizacaoModem() {
        return localizacaoModem;
    }

    public int getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(int localizacao) {
        this.localizacao = localizacao;
    }
}
