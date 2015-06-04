
package vencimentos;

public abstract class Trabalhadores {

    private String nome;

    public Trabalhadores(String nome){
        setNome(nome);
    }

    public abstract float vencimento();

    public String toString(){
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

        public boolean igual(Object obj){
            Trabalhadores t = (Trabalhadores)obj;
            return this.vencimento() == t.vencimento();
        }

        public boolean menor(Object obj){
            Trabalhadores t = (Trabalhadores)obj;
            return this.vencimento() < t.vencimento();
        }

        public boolean maior(Object obj){
            Trabalhadores t = (Trabalhadores)obj;
            return this.vencimento() > t.vencimento();
        }
    }