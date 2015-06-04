/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesEsqueleto;

import Motor.ArrayL;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Esta classe engloba todos os métodos necessários para a gravação e/ou carregamento
 * de uma base de dados com informações a respeito dos cursos.
 * @author Grupo 27
 */
public class BaseDados implements Serializable {

    private ArrayL cursos;

    /**
     * Class constructor
     * Inicializa todas as variáveis
     * Um objecto deve ser construído cada vez que chamamos a classe.
     * E a responsabilidade de fazer isso é do construtor. Isso parte do princípio
     * que podemos ter dois objectos com a mesma característica, mas que não
     * são os mesmos objectos.
     */
    public BaseDados() {
        cursos = new ArrayL();
    }

    /**
     * Este método reinicia todo o processo de leitura e análise de cursos, ou seja,
     * apaga o conteúdo existente, para ser possível criar novos cursos.
     */
    public void resetCursos() {
        cursos = new ArrayL();
    }

    /**
     * Este método grava uma base de dados nova.
     */
    public void gravaBaseDados() throws IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/dados/save.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Este método carrega uma base de dados existente.
     * @throws ClassNotFoundException
     */
    public BaseDados carregaBaseDados() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream("src/dados/save.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            BaseDados loaded = (BaseDados) in.readObject();
            in.close();
            fileIn.close();
            return loaded;
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return this;
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Cursos ArrayL de Cursos
     */
    public ArrayL getCursos() {
        return cursos;
    }
}
