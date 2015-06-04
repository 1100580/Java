
package contentoresobjectos;


public class Veiculo {

    public static int proxNiv = 0;
    private int direcao;
    private String nomeProp;
    private int niv;
    private int velocidade;



    public Veiculo(String nomeProp, int velocidade, int direcao){
        setNomeProp(nomeProp);
        setVelocidade(velocidade);
        setDirecao(direcao);
        proxNiv++;
        niv = proxNiv;
    }

    public int setDirecao(int direcao) {
        if (direcao > 0 && direcao < 360) {
            this.direcao = direcao;
            return direcao;
        } else {
            System.out.println("Direção errada. Posta a 0.");
            return 0;
        }
    }

    public String setNomeProp(String nomeProp) {
        this.nomeProp = nomeProp;
        return this.nomeProp;
    }

    public int setVelocidade(int velocidade) {
        if (velocidade > 0) {
            this.velocidade = velocidade;
            return velocidade;
        } else {
            System.out.println("Velocidade errada. Posta a 0");
            return 0;
        }
    }

    public int getDirecao() {
        return this.direcao;
    }

    public String getNomeProp() {
        return this.nomeProp;
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public String printToString(){
        return String.format("O veículo de " + nomeProp + " viaja a " + velocidade + " Km/h na direcção " + direcao + " graus.");
    }

}
