
package comparavel;

    public class Carro implements Comparavel{
        public String matricula;
        private String marca;

        public Carro(String marca, String matricula){
            this.marca = marca;
            this.matricula = matricula;
        }

        public boolean igual(Object obj){
            if (obj instanceof Carro) {
                if (marca.compareToIgnoreCase(((Carro)obj).marca) == 0) {
                    return matricula.compareToIgnoreCase(((Carro)obj).matricula) == 0;
                }
                return false;
            } else{
                return false;
            }
        }
    }
