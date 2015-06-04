package leitura;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int n1;
        boolean check = false;
        do{
            try {
                n1 = Leitura.lerInteiro("Digite um inteiro: ");
                check = true;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Inválido!!!" + nfe.getMessage());
            }
        }while(!check);
    }
}