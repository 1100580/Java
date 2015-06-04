package biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Contas {

    private static ArrayList<Conta> contas = new ArrayList<Conta>();

    public static ArrayList<Conta> getContas() {
        return contas;
    }

    public static int getTotalContas() {
        return contas.size();
    }

    public static Conta getContaPorNr(int nrConta) {
        for (Conta c : contas) {
            if (c.getNrConta() == nrConta) {
                return c;
            }
        }
        return null;
    }

    public static String getTitularPorNr(int nr) {
        if (nr > 0 && nr <= Conta.getTotalContas()) {
            for (Conta c : contas) {
                if (c.getNrConta() == nr) {
                    return c.getTitular();
                }
            }
        }
        return null;
    }

    public static ArrayList getTitulares() {
        ArrayList<String> titulares = new ArrayList();
        for (Conta c : contas) {
            if (!titulares.contains(c.getTitular())) {
                titulares.add(c.getTitular());
            }
        }
        return titulares;
    }

    public static boolean adicionarConta(Conta c) {
        return contas.add(c);
    }

    public static boolean removerConta(Conta c) {
        return contas.remove(c);
    }

    public static void removerTudo() {
        contas.clear();
    }

    public static boolean estaVazio() {
        return contas.isEmpty();
    }

    public static boolean escreverFicheiroContas() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("contas.bin"));
            out.writeObject(contas);
            out.close();
            return true;
        } catch (IOException exc) {
            return false;
        }
    }

    public static boolean lerFicheiroContas() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("contas.bin"));
            contas = (ArrayList<Conta>) in.readObject();
            in.close();
            if (contas != null) {
                int maiorNrConta = contas.get(contas.size() - 1).getNrConta();
                Conta.setTotalContas(maiorNrConta);
            }
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

    public static boolean adicionarContas() {
        try {
            Scanner in = new Scanner(new File("contas.txt"));
            String[] dados;
            while (in.hasNextLine()) {
                dados = in.nextLine().split(";");
                Conta c = new Conta(dados[0], Double.parseDouble(dados[1]));
                contas.add(c);
            }
            in.close();
            return true;
        } catch (IOException exc) {
            return false;
        }
    }

    public static boolean ficheiroListagemContas() {
        try {
            Formatter out = new Formatter(new File("listagem.txt"));
            out.format("%-15s%-20s%10s%n","Nº. Conta","Titular","Saldo");
            for (Conta c : contas)
                out.format("%-15d%-20s%10.2f%n",c.getNrConta(),c.getTitular(),c.getSaldo());
            out.close();
            return true;
        } catch (FileNotFoundException exc) {
            return false;
        }
    }
}
