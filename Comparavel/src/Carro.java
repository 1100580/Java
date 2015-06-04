public class Carro implements Comparavel {

    private String matricula;
    private String marca;

    public Carro(String matricula, String marca) {
        this.matricula = matricula;
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String toString() {
        return "Matricula: " + matricula + " Marca: " + marca;
    }

    public boolean igual(Object obj) {
        if (obj instanceof Carro)
            return matricula.compareToIgnoreCase(((Carro) obj).matricula) == 0;
        else 
            return false;
    }
}
