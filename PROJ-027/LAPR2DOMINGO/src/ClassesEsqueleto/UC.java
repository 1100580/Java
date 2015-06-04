package ClassesEsqueleto;

import Motor.ArrayL;
import java.io.Serializable;

/**
 * Esta classe contém todos os atributos relativos às unidade curriculares:
 * o ano em que está inserida, o seu ID, a época. Implementámos,
 * também dois arraylist's que contêm as pautas e as respectivas épocas.
 * @author Grupo 27
 */
public class UC implements Serializable {

    private int anoUC;
    private String idUC;
    private ArrayL pautas = new ArrayL();
    private ArrayL epocas = new ArrayL();

    /**
     * Class constructor Inicializa todas as variáveis
     * Um objecto deve ser construído cada vez que chamamos a classe. E a
     * responsabilidade de fazer isso é do construtor. Isso parte do princípio
     * que podemos ter dois objectos com a mesma característica, mas que não
     * são os mesmos objectos.
     * @param idUC ID do Curso (o que o identifica no meu de todos os cursos, chave
     * primária)
     * @param anoUC Ano em que a unidade curricular se insere
     */
    public UC(String idUC, int anoUC) {
        setIdUC(idUC);
        setAnoUC(anoUC);
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Ano da unidade curricular
     */
    public int getAnoUC() {
        return anoUC;
    }

    /**
     * Nomeamos um método acessor com set toda vez que este método for modificar
     * algum campo ou atributo de uma classe, ou seja, se não criarmos um método
     * acessor set para algum atributo, isso quer dizer que este atributo não deve ser modificado.
     * Portanto, como o valor de um atributo da classe será modificado, não é
     * necessário que este método retorne nenhum valor, por isso, os métodos setters são void.
     * Porém, obrigatoriamente, eles tem que receber um argumento que será o novo valor do campo.
     * @param anoUC O Ano em que a unidade curricular está inserida
     */
    public void setAnoUC(int anoUC) {
        this.anoUC = anoUC;
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return ID da unidade curricular
     */
    public String getIdUC() {
        return idUC;
    }

    /**
     * Nomeamos um método acessor com set toda vez que este método for modificar
     * algum campo ou atributo de uma classe, ou seja, se não criarmos um método
     * acessor set para algum atributo, isso quer dizer que este atributo não deve ser modificado.
     * Portanto, como o valor de um atributo da classe será modificado, não é
     * necessário que este método retorne nenhum valor, por isso, os métodos setters são void.
     * Porém, obrigatoriamente, eles tem que receber um argumento que será o novo valor do campo.
     * @param idUC Defini-se o ID do curso no respectivo momento, daí o this
     */
    public void setIdUC(String idUC) {
        this.idUC = idUC;
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Arraylist que contém as Épocas
     */
    public ArrayL getEpocas() {
        return this.epocas;
    }

    /**
     * O switch implementado neste métoodo serve para controlar várias acções
     * diferentes de acordo com o case definido dentro dele. O default assume um
     * estado, caso a opção escolhida não esteja entre as definidas.
     * @param indexEpocas Conjuntos de épocas que existe.
     * @return Uma época consoante a opção escolhida.
     */
    public String retornaTipoEpoca(int indexEpocas) {
        switch (indexEpocas) {
            case 0:
                return "NM";
            case 1:
                return "RE";
            case 2:
                return "EE";
            case 3:
                return "TE";
            case 4:
                return "EF";
            case 5:
                return "ML";
            default:
                return "Erro";
        }
    }

    /**
     * Retorna uma String com as informações sobre os estados dos objectos
     * criados através dos métodos acessores
     * @return String
     */
    @Override
    public String toString() {
        return "Ano: " + getAnoUC() + ". Nome: " + getIdUC() + "\n";
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Arraylist que contém as Pautas
     */
    public ArrayL getPautas() {
        return this.pautas;
    }
}
