package library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Recorde implements Serializable {

    private String nome;
    private int tempo, jogadas;
    private ArrayList<Recorde> recs = new ArrayList();

    public Recorde(int minutos, int segundos, int jogadas) {
        setTempo(minutos, segundos);
        setJogadas(jogadas);
        setNome("Default");
    }

    public boolean checkSeNovoRecorde() throws Exception {
        carregaRecorde();
        if (recs.isEmpty()) {
            return false;
        } else {
            if (tempo < recs.get(recs.size() - 1).getTempo()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void actualizaRecordista(String nome) {
        setNome(nome);
        gravaRecorde();
    }

    public void gravaRecorde() {
        recs.remove(0);
        recs.add(this);
        try {
            FileOutputStream fileOut = new FileOutputStream("rec.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public Recorde carregaRecorde() throws ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream("rec.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Recorde> recorde = (ArrayList<Recorde>) in.readObject();
            in.close();
            fileIn.close();
            recs = recorde;
            return recs.get(0);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return this;
    }

    public String toString() {
        return ("O recordista é o jogador " + getNome() + " que acabou o jogo em " + getTempo()
                + " segundos. Este jogo contou com " + getJogadas() + " jogadas.");
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tempo
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * @param tempo the tempo to set
     */
    public void setTempo(int minutos, int segundos) {
        tempo = minutos * 60 + segundos;
    }

    /**
     * @return the jogadas
     */
    public int getJogadas() {
        return jogadas;
    }

    /**
     * @param jogadas the jogadas to set
     */
    public void setJogadas(int jogadas) {
        this.jogadas = jogadas;
    }
}
