package Motor;

import java.io.*;
import java.util.Scanner;

/**
 * Esta classe contém todos os métodos que são necessários para ler uma Pauta.
 * @author Grupo 27
 */
public class LerPauta implements Serializable {

    public String pauta[][];
    public String subLinha[] = new String[1000];
    public int nLin, nCol, c;
    private String tipo = "", epoca = "";

    /**
     * Class constructor Inicializa todas as variáveis
     * Um objecto deve ser construído cada vez que chamamos a classe. E a
     * responsabilidade de fazer isso é do construtor. Isso parte do princípio
     * que podemos ter dois objectos com a mesma característica, mas que não
     * são os mesmos objectos.
     * @param fichIn Ficheiro de Entrada
     * @throws Exception
     */
    public LerPauta(String fichIn) throws Exception {

        Scanner in = new Scanner(new File(fichIn + ".csv"));
        while (in.hasNextLine()) {
            subLinha = in.nextLine().split(";");
            nLin++;
            if (nCol < subLinha.length) {
                nCol = subLinha.length;
            }
        }
        in.close();

        Scanner fin = new Scanner(new File(fichIn + ".csv"));
        pauta = new String[nLin][nCol];
        while (fin.hasNextLine()) {
            String linha = fin.nextLine();
            subLinha = linha.split(";");
            for (int i = 0; i < subLinha.length; i++) {
                pauta[c][i] = subLinha[i];
            }
            c++;
        }
        fin.close();
    }

    /**
     * Este método recebe um ficheiro com pautas e determina quantas linhas e colunas
     * o mesmo tem. De seguida passa os dados do ficheiro para uma matriz com o
     * tamanho definido anteriormente.
     * @return Matriz de String chamada Pauta
     */
    public String[][] getPauta() {
        return pauta;
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @param i Linha
     * @param j Coluna
     * @return Matriz pauta e respectivas posições
     */
    public String getCelula(int i, int j) {
        return pauta[i][j];
    }

    /**
     * Este método percorre a pauta e lista todo o seu o conteúdo.
     */
    public void listaPauta() {
        for (int i = 0; i < getnLin(); i++) {
            for (int j = 0; j < getnCol(); j++) {
                System.out.print(pauta[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Tipo de Pauta
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Nomeamos um método acessor com set toda vez que este método for modificar
     * algum campo ou atributo de uma classe, ou seja, se não criarmos um método
     * acessor set para algum atributo, isso quer dizer que este atributo não deve ser modificado.
     * Portanto, como o valor de um atributo da classe será modificado, não é
     * necessário que este método retorne nenhum valor, por isso, os métodos setters são void.
     * Porém, obrigatoriamente, eles tem que receber um argumento que será o novo valor do campo.
     * @param tipo Tipo de Pauta
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Número de linhas
     */
    public int getnLin() {
        return nLin;
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Número de colunas
     */
    public int getnCol() {
        return nCol;
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Época
     */
    public String getEpoca() {
        return epoca;
    }

    /**
     * Nomeamos um método acessor com set toda vez que este método for modificar
     * algum campo ou atributo de uma classe, ou seja, se não criarmos um método
     * acessor set para algum atributo, isso quer dizer que este atributo não deve ser modificado.
     * Portanto, como o valor de um atributo da classe será modificado, não é
     * necessário que este método retorne nenhum valor, por isso, os métodos setters são void.
     * Porém, obrigatoriamente, eles tem que receber um argumento que será o novo valor do campo.
     * @param epoca Época
     */
    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }
}
