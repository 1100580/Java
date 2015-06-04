package library;

import InterfaceGrafica.Relogio;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Jogo implements Serializable{

    private static int jogadas;
    private Deck deck;
    private ArrayList<Cartao> primeiras3;
    private ArrayList<Cartao> cima1 = new ArrayList<Cartao>();
    private ArrayList<Cartao> cima2 = new ArrayList<Cartao>();
    private ArrayList<Cartao> cima3 = new ArrayList<Cartao>();
    private ArrayList<Cartao> baixo1 = new ArrayList<Cartao>();
    private ArrayList<Cartao> baixo2 = new ArrayList<Cartao>();
    private ArrayList<Cartao> baixo3 = new ArrayList<Cartao>();
    private ArrayList<Cartao> cartaVirCima = new ArrayList<Cartao>();
    private ArrayList<ArrayList<Cartao>> arrays = new ArrayList<ArrayList<Cartao>>();

    public Jogo() {
        arrays.add(cartaVirCima);
        arrays.add(cima1);
        arrays.add(cima2);
        arrays.add(cima3);
        arrays.add(baixo1);
        arrays.add(baixo2);
        arrays.add(baixo3);
        deck = new Deck();
        distribuirCartas(deck);
    }
    
    public Jogo(boolean load) {
        arrays.add(cartaVirCima);
        arrays.add(cima1);
        arrays.add(cima2);
        arrays.add(cima3);
        arrays.add(baixo1);
        arrays.add(baixo2);
        arrays.add(baixo3);
        deck = new Deck();
        distribuirCartas(deck);
    }

    private void distribuirCartas(Deck deck) {
        deck.baralhar();
        primeiras3 = deck.removeIniciais();
        cima1.add(primeiras3.get(0));
        cima2.add(primeiras3.get(1));
        cima3.add(primeiras3.get(2));
    }

    public Cartao getCartaEmArray(int n) {
        int tamanho = arrays.get(n).size() - 1;
        Cartao carta = arrays.get(n).get(tamanho);
        return carta;
    }
    
    public Cartao getTodasCartasEmArray(int array, int carta){
        return arrays.get(array).get(carta);
    }

    public int getProxCarta(int n) {
        int tamanho = arrays.get(n).size() - 1;
        int valor = 0;
        if (n == 1) {
            valor = arrays.get(n).get(tamanho).getValor() + 1;
            if (valor == 8) {
                valor = 100;
            }
        } else if (n == 2) {
            valor = arrays.get(n).get(tamanho).getValor() + 2;
            if (valor == 8) {
                valor = 1;
            }else if(valor == 9){
                valor = 100;
            }
        } else if (n == 3) {
            valor = arrays.get(n).get(tamanho).getValor() + 3;
            if (valor == 9 || valor == 8) {
                valor = valor - 7;
            }else if(valor == 10){
                valor = 100;
            }
        }
        return valor;
    }

    public ArrayList<Cartao> getPilha(int n) {
        return arrays.get(n);
    }

    public int getJogadas() {
        return jogadas;
    }

    public void deckParaCartaVirCima() {
        Cartao current = deck.tirarDeDeck();
        cartaVirCima.add(current);
    }

    public boolean moverCarta(int pilhaComeco, int pilhaFim) {
        if (validaMovimento(pilhaComeco, pilhaFim)) {
            arrays.get(pilhaFim).add(arrays.get(pilhaComeco).get(arrays.get(pilhaComeco).size() - 1));
            arrays.get(pilhaComeco).remove(arrays.get(pilhaComeco).get(arrays.get(pilhaComeco).size() - 1));
            return true;
        }
        return false;
    }

    private boolean validaMovimento(int pilhaInicio, int pilhaFim) {
        if (getProxCarta(pilhaFim) == getCartaEmArray(pilhaInicio).getValor() || (pilhaFim >= 4 && pilhaFim <= 6)) {
            if (((pilhaInicio >= 4 && pilhaInicio <= 6) && (pilhaFim >= 4 && pilhaFim <= 6)) || (pilhaInicio >= 1 && pilhaInicio <= 3)) {
                return false;
            }
            Relogio.setjogadas(++jogadas);
            return true;
        }
        return false;
    }

    public void gravarJogo() throws IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream("save.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public Jogo carregarJogo() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream("save.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Jogo loaded = (Jogo) in.readObject();
            in.close();
            fileIn.close();
            return loaded;
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return this;
    }

    public boolean checkFim() {
        if (deck.isEmpty() && baixo1.isEmpty() && baixo2.isEmpty() && baixo3.isEmpty() && cartaVirCima.isEmpty()) {
            return true;
        }
        return false;
    }
}