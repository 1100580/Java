package Motor;

import ClassesEsqueleto.Aluno;
import ClassesEsqueleto.BaseDadosCurso;
import java.io.Serializable;

/**
 * Esta classe contém todos os métodos que são necessários para manipular os
 * os arraylist's: adicionar elementos, remover elementos, listar todo o seu
 * conteúdo, verificar o objecto aluno está contido no array (contains) e, ainda,
 * remover um aluno da classe Aluno.
 * @author Grupo 27
 */
public class ArrayL implements Serializable {

    private Object[] array;
    private int tamanho;

    /**
     * Classe constructor Inicializa todas as variáveis
     * Um objecto deve ser construído cada vez que chamamos a classe. E a
     * responsabilidade de fazer isso é do construtor. Isso parte do princípio
     * que podemos ter dois objectos com a mesma característica, mas que não
     * são os mesmos objectos.
     */
    public ArrayL() {
        array = new Object[0];
    }

    /**
     * Este método adiciona uma nova posição ao array
     * @param novo Novo Objecto
     */
    public void adiciona(Object novo) {
        Object[] array2 = new Object[++tamanho];
        for (int i = 0; i < tamanho - 1; i++) {
            array2[i] = getArray()[i];
        }
        array2[tamanho - 1] = novo;
        array = array2;
    }

    /**
     * Este método remove uma posição do Array
     * @param index Posição
     */
    public void remove(int index) {
        try {
            Object[] array2 = new Object[--tamanho];
            for (int i = 0; i < index; i++) {
                array2[i] = array[i];
            }
            for (int i = index; i < tamanho; i++) {
                array2[i] = array[i + 1];
            }
            array = array2;
        } catch (Exception c) {
        }
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @param index
     * @return Posição no array
     */
    public Object getIndex(int index) {
        try {
            return array[index];
        } catch (Exception c) {
            return null;
        }
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Tamanho do array
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Este método lista todo o conteúdo do array
     * @return String s
     */
    public String listar() {
        String s = "";
        for (int i = 0; i < tamanho; i++) {
            s += String.format(getArray()[i].toString());
        }
        return s;
    }

    /**
     * Este método verifica se o objecto aluno está contido no array ou não.
     * @param aluno Aluno
     * @return Boolean true/false caso o o objecto aluno exista ou não.
     */
    public boolean contains(Object aluno) {
        for (int i = 0; i < tamanho; i++) {
            if (aluno.equals(getArray()[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Este método remove um aluno do array.
     * @param alunoT Objecto da classe Aluno
     */
    public void remove(Aluno alunoT) {
        for (int i = 0; i < tamanho; i++) {
            if (alunoT.getNumAluno() == (((Aluno) getArray()[i]).getNumAluno())) {
                Object[] array2 = new Object[--tamanho];
                for (int j = 0; j < i; j++) {
                    array2[j] = getArray()[j];
                }
                for (int k = i; k < tamanho; k++) {
                    array2[k] = getArray()[k + 1];
                }
                array = array2;
            }
        }
    }

    /**
     * Este método remove um objecto curso ao array
     * @param curso Objecto da classe BaseDadosCurso
     */
    public void remove(BaseDadosCurso curso) {
        for (int i = 0; i < tamanho; i++) {
            if (curso.getIdCurso() == (((BaseDadosCurso) getArray()[i]).getIdCurso())) {
                Object[] array2 = new Object[--tamanho];
                for (int j = 0; j < i; j++) {
                    array2[j] = getArray()[j];
                }
                for (int k = i; k < tamanho; k++) {
                    array2[k] = getArray()[k + 1];
                }
                array = array2;
            }
        }
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Array
     */
    public Object[] getArray() {
        return array;
    }

    /**
     * Este método adiciona uma nova posição ao array
     * @param novo Novo Objecto
     * @param index Posição
     */
    public void adiciona(Object novo, int index) {
        for (int i = 0; i < tamanho; i++) {
            Object[] array2 = new Object[++tamanho];
            for (int j = 0; j < i; j++) {
                array2[j] = getArray()[j];
            }
            array2[i + 1] = novo;
            for (int k = i + 2; k < tamanho; k++) {
                array2[k] = getArray()[k + 1];
            }
            array = array2;
        }
    }
}
