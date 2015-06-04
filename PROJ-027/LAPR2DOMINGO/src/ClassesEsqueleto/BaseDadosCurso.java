package ClassesEsqueleto;

import Motor.ArrayL;
import Motor.LerPauta;
import java.io.*;
import javax.swing.*;

/**
 * Esta classe engloba todos os dados referente a um curso, bem como listas ligadas
 * que contêm os anos, as ucs, os alunos e ,ainda os arrays. Daí, chamar-se BaseDadosCurso.
 * @author Grupo 27
 */
public class BaseDadosCurso implements Serializable {

    private String tituloCurso, siglaCurso, anoCurso;
    private int idCurso;
    private ArrayL anos = new ArrayL();
    private ArrayL ucs = new ArrayL();
    private ArrayL alunos = new ArrayL();
    //0 = anos, 1=ucs, 2=alunos
    private ArrayL arrays = new ArrayL();

    /**
     * Class constructor Inicializa todas as variáveis
     * Um objecto deve ser construído cada vez que chamamos a classe.
     * E a responsabilidade de fazer isso é do construtor. Isso parte do princípio
     * que podemos ter dois objectos com a mesma característica, mas que não
     * são os mesmos objectos.
     * @param tituloCurso Título do Curso
     * @param siglaCurso Sigla do Curso
     * @param idCurso ID do curso
     * @param anoCurso Ano do Curso
     * @throws Exception
     */
    public BaseDadosCurso(String tituloCurso, String siglaCurso, int idCurso, String anoCurso) throws Exception {
        setTituloCurso(tituloCurso);
        setIdCurso(idCurso);
        setAnoCurso(anoCurso);
        setSiglaCurso(siglaCurso);

        arrays.adiciona(anos);
        arrays.adiciona(ucs);
        arrays.adiciona(alunos);

        try {
            carregaAlunos();
            carregaUCSeEpocas();
            carregaPautas();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Não puderam ser encontradas as pautas para este curso.\n"
                    + "No entanto o curso foi criado, apenas não contêm nenhuma informação portanto não se podem apresentar estatisticas.\n"
                    + "Por favor coloque os dados na pasta correcta (src/ficheiros) e utilize o carregamento manual de pautas.", "Impossível encontrar pautas", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Inicialmente, este método lê uma pauta, carrega todos os alunos existentes
     * nela, a partir do seu número de aluno. De seguida, adiciona-os ao arraylist
     * dos alunos.
     * @throws Exception
     */
    public void carregaAlunos() throws Exception {
        LerPauta listaAlunos = new LerPauta("src/ficheiros/" + getSiglaCurso() + "_" + "ALUNOS_" + getAnoCurso().substring(0, 4) + "_" + getAnoCurso().substring(5, 9));
        String[][] matrizListaAlunos = listaAlunos.getPauta();
        for (int i = 1; i < matrizListaAlunos.length; i++) {
            int numAluno = Integer.parseInt(matrizListaAlunos[i][0]);
            int anoAluno = Integer.parseInt(matrizListaAlunos[i][1]);
            Aluno a = new Aluno(numAluno, anoAluno);
            alunos.adiciona(a);
        }
    }

    /**
     * Este método quando lê uma pauta, lista todas as unidades curriculares e
     * adiciona-as, posteriormente, ao arraylist das uc's. De seguida atribui
     * essas mesma uc's aos alunos.
     * @throws Exception
     */
    public void carregaUCSeEpocas() throws Exception {
        UC u = (UC) null;
        LerPauta listaUcs = new LerPauta("src/ficheiros/" + getSiglaCurso() + "_" + "EPOCAS_" + getAnoCurso());
        String[][] matrizListaUcs = listaUcs.getPauta();
        for (int i = 3; i < matrizListaUcs.length; i++) {
            u = new UC(matrizListaUcs[i][0], Integer.parseInt(matrizListaUcs[i][1]));
            for (int j = 4; j < matrizListaUcs[3].length; j++) {
                if (matrizListaUcs[i][j] == null || matrizListaUcs[i][j].isEmpty()) {
                    u.getEpocas().adiciona(false);
                } else {
                    u.getEpocas().adiciona(true);
                }
            }
            ucs.adiciona(u);
            for (int j = 0; j < alunos.getTamanho(); j++) {
                ((Aluno) alunos.getIndex(i)).discipAR = new String[alunos.getTamanho()];
            }
        }
    }

    /**
     * Este método tem como objectivo principal distinguir qual o tipo de pauta,
     * ou seja, se é uma pauta NFAFER (contém frequência anterior) ou uma pauta
     * NFER (sem frequência anterior). No final da distinção executa os set's
     * do tipo e da época.
     * @throws Exception
     */
    public void carregaPautas() throws Exception {
        for (int i = 0; i < ucs.getTamanho(); i++) {
            for (int j = 0; j < ((UC) ucs.getIndex(i)).getEpocas().getTamanho(); j++) {
                try {
                    LerPauta pauta = new LerPauta("src/ficheiros/" + ((UC) ucs.getIndex(i)).getIdUC() + "_" + ((UC) ucs.getIndex(i)).retornaTipoEpoca(j) + "_" + getAnoCurso());
                    // Vê qual o tipo da pauta e faz set do tipo e epoca.
                    pauta.setEpoca(pauta.getCelula(2, 1));
                    if ("Freq. Ant. ".equals(pauta.getCelula(5, 1))) {
                        pauta.setTipo("NFAFER");
                    } else if ("Freq. ".equals(pauta.getCelula(5, 1))) {
                        pauta.setTipo("NFER");
                    }
                    ((UC) ucs.getIndex(i)).getPautas().adiciona(pauta);
                } catch (FileNotFoundException fnf) {
                }
            }
        }
    }

    /**
     * A única diferrença que existe entre este método e o método CarregaPautas(),
     * é que este método permite ao utilizador carregar a pauta que pretende, manualmente.
     * @param uc Unidade Curricular
     * @param epoca Época
     * @throws Exception
     */
    public void carregaPautaManual(UC uc, String epoca) throws Exception {
        try {
            int indexUC = 0;
            LerPauta pauta = new LerPauta("src/ficheiros/" + uc.getIdUC() + "_" + epoca + "_" + getAnoCurso());
            // Testes dos resultados
//            pauta.listaPauta();
//            ExportaHTML h1 = new ExportaHTML(pauta.getPauta());
            if ("Freq. Ant. ".equals(pauta.getCelula(5, 1))) {
                pauta.setTipo("NFAFER");
            } else if ("Freq. ".equals(pauta.getCelula(5, 1))) {
                pauta.setTipo("NFER");
            }
            for (int i = 0; i < ucs.getTamanho(); i++) {
                if (ucs.getIndex(i) == uc) {
                    indexUC = i;
                }
            }
            for (int i = 0; i < ((UC) ucs.getIndex(indexUC)).getPautas().getTamanho(); i++) {
                if (((UC) ucs.getIndex(indexUC)).getPautas().getIndex(i) == pauta) {
                    ((UC) ucs.getIndex(indexUC)).getPautas().remove(i);
                    ((UC) ucs.getIndex(indexUC)).getPautas().adiciona(pauta);
                } else if (i == ((UC) ucs.getIndex(indexUC)).getPautas().getTamanho() - 1) {
                    ((UC) ucs.getIndex(indexUC)).getPautas().adiciona(pauta);
                }
            }
        } catch (FileNotFoundException fnf) {
        }
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Arraylist arrays (Array que contém os 3 arrays da classe BaseDadosCurso.
     */
    public ArrayL getArrayL() {
        return (ArrayL) arrays;
    }

    /** Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Título do curso
     */
    public String getTituloCurso() {
        return tituloCurso;
    }

    /**
     * Nomeamos um método acessor com set toda vez que este método for modificar
     * algum campo ou atributo de uma classe, ou seja, se não criarmos um método
     * acessor set para algum atributo, isso quer dizer que este atributo não deve ser modificado.
     * Portanto, como o valor de um atributo da classe será modificado, não é
     * necessário que este método retorne nenhum valor, por isso, os métodos setters são void.
     * Porém, obrigatoriamente, eles tem que receber um argumento que será o novo valor do campo.
     * @param tituloCurso Título do Curso
     */
    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return ID do CURSO
     */
    public int getIdCurso() {
        return idCurso;
    }

    /**
     * Nomeamos um método acessor com set toda vez que este método for modificar
     * algum campo ou atributo de uma classe, ou seja, se não criarmos um método
     * acessor set para algum atributo, isso quer dizer que este atributo não deve ser modificado.
     * Portanto, como o valor de um atributo da classe será modificado, não é
     * necessário que este método retorne nenhum valor, por isso, os métodos setters são void.
     * Porém, obrigatoriamente, eles tem que receber um argumento que será o novo valor do campo.
     * @param idCurso ID do Curso
     */
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Ano do Curso
     */
    public String getAnoCurso() {
        return anoCurso;
    }

    /**
     * Nomeamos um método acessor com set toda vez que este método for modificar
     * algum campo ou atributo de uma classe, ou seja, se não criarmos um método
     * acessor set para algum atributo, isso quer dizer que este atributo não deve ser modificado.
     * Portanto, como o valor de um atributo da classe será modificado, não é
     * necessário que este método retorne nenhum valor, por isso, os métodos setters são void.
     * Porém, obrigatoriamente, eles tem que receber um argumento que será o novo valor do campo.
     * @param anoCurso Ano do Curso
     */
    public void setAnoCurso(String anoCurso) {
        this.anoCurso = anoCurso;
    }

    /**
     * Nomeamos um método acessor com get toda vez que este método for verificar
     * algum campo ou atributo de uma classe.
     * Como este método irá verificar um valor, ele sempre terá um retorno como
     * String, int, float, etc. Mas não terá nenhum argumento.
     * @return Sigla do Curso
     */
    public String getSiglaCurso() {
        return siglaCurso;
    }

    /**
     * Nomeamos um método acessor com set toda vez que este método for modificar
     * algum campo ou atributo de uma classe, ou seja, se não criarmos um método
     * acessor set para algum atributo, isso quer dizer que este atributo não deve ser modificado.
     * Portanto, como o valor de um atributo da classe será modificado, não é
     * necessário que este método retorne nenhum valor, por isso, os métodos setters são void.
     * Porém, obrigatoriamente, eles tem que receber um argumento que será o novo valor do campo.
     * @param siglaCurso Sigla do Curso
     */
    public void setSiglaCurso(String siglaCurso) {
        this.siglaCurso = siglaCurso;
    }

    /**
     * Retorna uma String com as informações sobre os estados dos objectos
     * criados através dos métodos acessores
     * @return String
     */
    @Override
    public String toString() {
        return String.format(getTituloCurso() + "\t - " + getSiglaCurso() + " - \t" + getAnoCurso());
    }
}
