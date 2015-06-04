package library;

import java.io.Serializable;
import java.util.Collections;
import java.util.ArrayList;

public class Deck extends ArrayList<Cartao> implements Serializable {

    public Deck() {
        for (Cartao.Cor cor : Cartao.Cor.values()) {
            for (Cartao.Numero num : Cartao.Numero.values()) {
                this.add(new Cartao(num, cor));
            }
        }
    }

    public void baralhar() {
        Collections.shuffle(this);
    }

    public ArrayList<Cartao> removeIniciais() {
        ArrayList<Cartao> subdeck = new ArrayList<Cartao>();
        do {
            for (Cartao cartao : this) {
                if (cartao.getNumero() == Cartao.Numero.Um && subdeck.isEmpty()) {
                    subdeck.add(cartao);
                } else {
                    if (cartao.getNumero() == Cartao.Numero.Dois && subdeck.size() == 1) {
                        subdeck.add(cartao);
                    } else {
                        if (cartao.getNumero() == Cartao.Numero.Tres && subdeck.size() == 2) {
                            subdeck.add(cartao);
                        }
                    }
                }
            }
        } while (subdeck.size() != 3);
        this.removeAll(subdeck);
        return subdeck;
    }

    public Cartao tirarDeDeck() {
        Cartao c1 = this.get(0);
        this.remove(c1);
        return c1;
    }
    
}
