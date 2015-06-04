import java.util.Random;

public class Adivinha {
    private int resposta;
    private boolean sucesso;
    private String sugestao;
    private int numTentativas;
    
    public Adivinha() {
        iniciar();
    }
    
    public void iniciar() {
        numTentativas = 0;
        Random randomGenerator = new Random();
        resposta = randomGenerator.nextInt(100);
        System.out.println(resposta);
    }
    
    public boolean getSucesso(String t1){
        if (Integer.parseInt(t1) == resposta) {
            return true;
        }
        return false;
    }
    public String getSugestao(String t1){
        if (Integer.parseInt(t1) > resposta) {
            return "menor";
        }
        return "maior";
    }

    public int getNumTentativas(){
        return numTentativas;
    }
    
    public void setTentativa() {
        numTentativas++;
    }
}
