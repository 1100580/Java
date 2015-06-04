package ClassesEsqueleto;

import java.io.Serializable;

/**
 * Esta classe contém apenas os atributos dos alunos: número indentificativo e o
 * respectivo nome.
 * @author Grupo 27
 */
public class Aluno implements Serializable {

    private int numAluno, anoAluno;
    public String[] discipAR = new String[14];

    /**
     * Class constructor Inicializa todas as variáveis
     * Um objecto deve ser construído cada vez que chamamos a classe. E a
     * responsabilidade de fazer isso é do construtor. Isso parte do princípio
     * que podemos ter dois objectos com a mesma característica, mas que não
     * são os mesmos objectos.
     * @param numAluno Número do aluno
     * @param anoAluno Ano do Aluno
     */

    public Aluno(int numAluno, int anoAluno) {
        setNumAluno(numAluno);
        setAnoAluno(anoAluno);
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Número do Aluno
     */
    public int getNumAluno() {
        return numAluno;
    }

    /**
     * Nomeamos um método acessor com set toda vez que este método for modificar
     * algum campo ou atributo de uma classe, ou seja, se não criarmos um método
     * acessor set para algum atributo, isso quer dizer que este atributo não deve ser modificado.
     * Portanto, como o valor de um atributo da classe será modificado, não é
     * necessário que este método retorne nenhum valor, por isso, os métodos setters são void.
     * Porém, obrigatoriamente, eles tem que receber um argumento que será o novo valor do campo.
     * @param numAluno Número do Aluno
     */
    public void setNumAluno(int numAluno) {
        this.numAluno = numAluno;
    }


    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Ano do Aluno
     */

    public int getAnoAluno() {
        return anoAluno;
    }

     /**
     * Nomeamos um método acessor com set toda vez que este método for modificar
     * algum campo ou atributo de uma classe, ou seja, se não criarmos um método
     * acessor set para algum atributo, isso quer dizer que este atributo não deve ser modificado.
     * Portanto, como o valor de um atributo da classe será modificado, não é
     * necessário que este método retorne nenhum valor, por isso, os métodos setters são void.
     * Porém, obrigatoriamente, eles tem que receber um argumento que será o novo valor do campo.
     * @param anoAluno Ano do Auno
     */
    public void setAnoAluno(int anoAluno) {
        this.anoAluno = anoAluno;
    }

    /**
     * Retorna uma String com as informações sobre os estados dos objectos
     * criados através dos métodos acessores
     * @return String
     */
    public String toString() {
        return "Aluno: " + getNumAluno() + ". Ano: " + getAnoAluno();
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return vector disciAR ( vector discAR é o vector que contém todas as cadeiras
     * e diz se o aluno está inscrito ou passou à disciplina. Quando não está inscrito o valor é null.
     */
    public String[] getDiscipAR() {
        return discipAR;
    }
    
}
