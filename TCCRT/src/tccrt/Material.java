package tccrt;

public class Material {
    private String nome;
    private float k;
    
    public Material(){
        nome = "Default";
        k = 0;
    }
    
    public Material(String n, Float cond){
        nome = n;
        k = cond;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getK() {
        return k;
    }

    public void setK(float k) {
        this.k = k;
    }
    
    
}
