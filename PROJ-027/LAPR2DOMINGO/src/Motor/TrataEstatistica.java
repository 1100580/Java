package Motor;

import ClassesEsqueleto.Aluno;
import ClassesEsqueleto.BaseDadosCurso;
import ClassesEsqueleto.UC;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * Esta classe contém todos os métodos que apresentam as estatísticas.
 * @author Grupo 27
 */
public class TrataEstatistica implements Serializable {

    public static ArrayL alunosAprov = new ArrayL();
    public static ArrayL alunosReprov = new ArrayL();
    public static ArrayL alunosSM = new ArrayL();
    public static ArrayL alunosNC = new ArrayL();
    public static ArrayL alunosNF = new ArrayL();
    public int[] notas0a20SMNCNF = new int[23];

    /**
     * Este método lê uma uma pauta e calcula as estimativas da caracterização
     * da amostra.
     * @param b Objecto da BaseDadosCurso
     * @throws Exception
     */
    public void trataAmostra(BaseDadosCurso b) throws Exception {

        //-------------------Estimativa da alínea a)
        String[][] finalAmostra = new String[((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 16][13];

        String[][] estA = new String[((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 3][6];
        int lin = 2;
        int anoDaUC = 1;

        //Formata tabela estimativa a)
        estA[0][2] = "Ano em que o aluno se encontra";
        estA[1][0] = "Ano";
        estA[1][1] = "UC";
        estA[1][2] = "1";
        estA[1][3] = "2";
        estA[1][4] = "3";
        estA[2][0] = "1 Ano";
        estA[1][5] = "Total";
        estA[((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 2][1] = "Total";

        //escreve ids das UC
        for (int i = 0; i < ((ArrayL) b.getArrayL().getIndex(1)).getTamanho(); i++) {
            estA[i + 2][1] = ((UC) ((ArrayL) b.getArrayL().getIndex(1)).getIndex(i)).getIdUC();
        }

        for (int i = 0; i < ((ArrayL) b.getArrayL().getIndex(1)).getTamanho(); i++) {
            LerPauta p2 = (LerPauta) ((UC) ((ArrayL) b.getArrayL().getIndex(1)).getIndex(i)).getPautas().getIndex(0);
            String[][] matriz = p2.getPauta();
            int alunos1 = 0, alunos2 = 0, alunos3 = 0;
            for (int j = 6; j < p2.getnLin(); j++) {
                int numeroAluno = Integer.parseInt(matriz[j][0]);
                for (int k = 0; k < ((ArrayL) b.getArrayL().getIndex(2)).getTamanho(); k++) {
                    if (numeroAluno == ((Aluno) (((ArrayL) b.getArrayL().getIndex(2)).getIndex(k))).getNumAluno()) {
                        int ano = ((Aluno) (((ArrayL) b.getArrayL().getIndex(2)).getIndex(k))).getAnoAluno();
                        if (ano == 1) {
                            alunos1++;
                        } else if (ano == 2) {
                            alunos2++;
                        } else if (ano == 3) {
                            alunos3++;
                        }
                    }
                }
            }
            //Atribui dados às celulas
            estA[lin][2] = "" + alunos1;
            estA[lin][3] = "" + alunos2;
            estA[lin][4] = "" + alunos3;
            estA[lin][5] = "" + (alunos1 + alunos2 + alunos3);
            lin++;
            if (((UC) ((ArrayL) b.getArrayL().getIndex(1)).getIndex(i)).getAnoUC() > anoDaUC) {
                anoDaUC++;
                estA[i + 2][0] = anoDaUC + " Ano";
            }
        }

        //Calcula totais das Colunas
        for (int i = 2; i < 6; i++) {
            int totalColuna = 0;
            for (int j = 2; j < (((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 2); j++) {
                totalColuna += Integer.parseInt(estA[j][i]);
            }
            estA[((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 2][i] = "" + totalColuna;
        }
        //-------------------Fim da Estimativa da alínea a)

        //-------------------Estimativa da alínea d)
        int[] nUcs1 = new int[11];
        int[] nUcs2 = new int[11];
        int[] nUcs3 = new int[11];
        int totalAlunos1 = 0;
        int totalAlunos2 = 0;
        int totalAlunos3 = 0;

        //conta quandos alunos passaram a quantas ucs e poe no vector
        for (int i = 0; i < ((ArrayL) b.getArrayL().getIndex(2)).getTamanho(); i++) { // para cada aluno
            int nUcsIns = 0;
            for (int j = 0; j < ((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getDiscipAR().length; j++) { // para cada posição do vector das cadeiras
                if ("Passou".equals(((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getDiscipAR()[j]) || "SM".equals(((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getDiscipAR()[j]) || "Inscrito".equals(((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getDiscipAR()[j])) {
                    nUcsIns++;
                }
            }
            if (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getAnoAluno() == 1) {
                nUcs1[nUcsIns]++;
            } else if (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getAnoAluno() == 2) {
                nUcs2[nUcsIns]++;
            } else if (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getAnoAluno() == 3) {
                nUcs3[nUcsIns]++;
            }

        }

        String[][] estB = new String[7][13];

        //Escreve estatisticas
        for (int j = 1; j < 11; j++) {
            estB[2][j] = "" + nUcs1[j];
            totalAlunos1 += nUcs1[j];
            estB[3][j] = "" + nUcs2[j];
            totalAlunos2 += nUcs2[j];
            estB[4][j] = "" + nUcs3[j];
            totalAlunos3 += nUcs3[j];
        }

        estB[0][2] = "Num de UCs a que o aluno esta inscrito";
        estB[1][0] = "Ano";
        for (int i = 1; i < 11; i++) {
            estB[1][i] = "" + (i);
        }
        estB[1][11] = "Total";
        estB[2][11] = "" + totalAlunos1;
        estB[3][11] = "" + totalAlunos2;
        estB[4][11] = "" + totalAlunos3;
        estB[1][12] = "%";
        estB[2][0] = "1";
        estB[3][0] = "2";
        estB[4][0] = "3";
        estB[5][0] = "Total";

        //Escreve totais
        for (int i = 1; i < 12; i++) {//para cada coluna
            int totalColuna = 0;
            for (int j = 2; j < 5; j++) {//Para cada linha
                totalColuna += Integer.parseInt(estB[j][i]);
            }
            estB[5][i] = "" + totalColuna;
        }
        //escreve percentagens do nº UCS
        for (int i = 1; i < 11; i++) {
            float perc = (Float.parseFloat(estB[5][i]) / Integer.parseInt(estB[5][11])) * 100;
            DecimalFormat df = new DecimalFormat(".#");
            estB[6][i] = df.format(perc) + "%";
        }
        //escreve percentagens dos anos
        for (int i = 2; i < 5; i++) {
            float perc = (Float.parseFloat(estB[i][11]) / Integer.parseInt(estB[5][11])) * 100;
            DecimalFormat df = new DecimalFormat(".#");
            estB[i][12] = df.format(perc) + "%";
        }

        String[][] estB2 = new String[4][12];

        estB2[0][0] = "Ano";
        for (int i = 1; i < 11; i++) {
            estB2[0][i] = "" + (i);
        }
        estB2[0][11] = "Total";
        estB2[1][0] = "1";
        estB2[2][0] = "2";
        estB2[3][0] = "3";

        //preenche tabela percentegens
        for (int i = 2; i < 5; i++) {
            for (int j = 1; j < 11; j++) {
                float perc = (Float.parseFloat(estB[i][j]) / Integer.parseInt(estB[i][11])) * 100;
                DecimalFormat df = new DecimalFormat("#");
                estB2[i - 1][j] = df.format(perc) + "%";
            }
        }

        //preenche totais percentagens
        estB2[1][11] = "100%";
        estB2[2][11] = "100%";
        estB2[3][11] = "100%";
        //-------------------Fim da Estimativa da alínea d)

//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 12; j++) {
//                System.out.print(estB2[i][j] + "\t");
//            }
//            System.out.println("");
//        }
        //copia tabelas todas pra final
        //tabela A
        for (int i = 0; i < ((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 3; i++) {
            for (int j = 0; j < 6; j++) {
                finalAmostra[i][j] = estA[i][j];
            }
        }
        //tabela B
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 13; j++) {
                finalAmostra[((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 4 + i][j] = estB[i][j];
            }
        }
        //tabela b2
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                finalAmostra[((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 11 + i][j] = estB2[i][j];
            }
        }
        //-------------------Exporta resultados
        ExportaHTML amostra = new ExportaHTML(finalAmostra, "amostra");
    }

    /**
     * Este método contém toda a informação necessária para o cálculo das estatísticas
     * dos resultados das unidades curriculares.
     * @param b Objecto da BaseDadosCurso
     * @throws Exception
     */
    public void trataResUcs(BaseDadosCurso b) throws Exception {

        //-----------Inicio estimativa a)
        String[][] finalUcs = new String[(((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 3) * 2 + 2][8];

        String[][] estA = new String[((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 3][8];
        String[][] estB = new String[((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 3][6];

        estA[0][2] = "Res.";
        estA[1][0] = "Ano";
        estA[1][1] = "Disc.";
        estA[1][2] = "Aprov.";
        estA[1][3] = "SM";
        estA[1][4] = "Reprov.";
        estA[1][5] = "NC";
        estA[1][6] = "NF";
        estA[1][7] = "GT";
        estA[((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 2][1] = "GT";

        //preenche ids das UCS
        for (int i = 0; i < ((ArrayL) b.getArrayL().getIndex(1)).getTamanho(); i++) {
            estA[i + 2][1] = ((UC) ((ArrayL) b.getArrayL().getIndex(1)).getIndex(i)).getIdUC();
        }

        int tipo = 0;
        int contotal = 0;
        int ca = 0;
        int cb = 0;
        int anoDaUC = 0;
        for (int l = 0; l < ((ArrayL) b.getArrayL().getIndex(1)).getTamanho(); l++) {
//            System.out.println("Teste1");
            for (int k = 0; k < ((UC) ((ArrayL) b.getArrayL().getIndex(1)).getIndex(l)).getPautas().getTamanho(); k++) {
                LerPauta p2 = (LerPauta) ((UC) ((ArrayL) b.getArrayL().getIndex(1)).getIndex(l)).getPautas().getIndex(k);
                String[][] matriz = p2.getPauta();
                String epoca = p2.getEpoca();
                if ("NFAFER".equals(p2.getTipo())) {
                    tipo = 0;
                } else if ("NFER".equals(p2.getTipo())) {
                    tipo = -1;
                }
                for (int i = 6; i < p2.getnLin(); i++) {
                    if ("NF ".equals(matriz[i][tipo + 2])) {
                        contaAlunos(b, p2.getEpoca(), Integer.parseInt(matriz[i][0]), alunosNF);
                    } else if ("SM ".equals(matriz[i][tipo + 4])) {
                        contaAlunos(b, p2.getEpoca(), Integer.parseInt(matriz[i][0]), alunosSM);
                    } else if ("NC ".equals(matriz[i][tipo + 4])) {
                        contaAlunos(b, p2.getEpoca(), Integer.parseInt(matriz[i][0]), alunosNC);
                    } else if (Integer.parseInt(matriz[i][tipo + 4]) >= 10) {
                        contaAlunos(b, p2.getEpoca(), Integer.parseInt(matriz[i][0]), alunosAprov);
                    } else if (Integer.parseInt(matriz[i][tipo + 4]) <= 9) {
                        contaAlunos(b, p2.getEpoca(), Integer.parseInt(matriz[i][0]), alunosReprov);
                    }
                }
            }
            //preenche linha da uc com resultados
            contotal = alunosAprov.getTamanho() + alunosReprov.getTamanho() + alunosSM.getTamanho() + alunosNC.getTamanho() + alunosNF.getTamanho();
            estA[ca + 2][2] = alunosAprov.getTamanho() + "";
            estA[ca + 2][3] = alunosSM.getTamanho() + "";
            estA[ca + 2][4] = alunosReprov.getTamanho() + "";
            estA[ca + 2][5] = alunosNC.getTamanho() + "";
            estA[ca + 2][6] = alunosNF.getTamanho() + "";
            estA[ca + 2][7] = contotal + "";
            ca++;

            //preenche linha da uc com resultados
            contotal = alunosAprov.getTamanho() + alunosReprov.getTamanho() + alunosSM.getTamanho();
            estB[cb + 2][2] = alunosAprov.getTamanho() + "";
            estB[cb + 2][3] = alunosSM.getTamanho() + "";
            estB[cb + 2][4] = alunosReprov.getTamanho() + "";
            estB[cb + 2][5] = contotal + "";
            cb++;
//            System.out.println(alunosAprov.getTamanho() + "+" + alunosSM.getTamanho() + "+" + alunosReprov.getTamanho() + "+" + alunosNC.getTamanho() + "+" + alunosNF.getTamanho() + "=");
//            System.out.println("Resultado: " + contotal);
            alunosAprov = new ArrayL();
            alunosReprov = new ArrayL();
            alunosSM = new ArrayL();
            alunosNC = new ArrayL();
            alunosNF = new ArrayL();

            //Actualiza o ano
            if (((UC) ((ArrayL) b.getArrayL().getIndex(1)).getIndex(l)).getAnoUC() > anoDaUC) {
                anoDaUC++;
                estA[l + 2][0] = anoDaUC + " Ano";
                estB[l + 2][0] = anoDaUC + " Ano";
            }
        }

        //poe totais colunas
        for (int i = 2; i < 8; i++) {//para cada coluna
            int totalColuna = 0;
            for (int j = 2; j < ((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 2; j++) {//Para cada linha
                if(estA[j][i] != null) totalColuna += Integer.parseInt(estA[j][i]);
            }
            estA[((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 2][i] = "" + totalColuna;
        }

        //-----------Fim estimativa a)
        //-----------Inicio estimativa b)

        estB[0][2] = "Res.";
        estB[1][0] = "Ano";
        estB[1][1] = "Disc.";
        estB[1][2] = "Aprov.";
        estB[1][3] = "SM";
        estB[1][4] = "Reprov.";
        estB[1][5] = "GT";
        estB[((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 2][1] = "GT";

        //preenche ids das UCS
        for (int i = 0; i < ((ArrayL) b.getArrayL().getIndex(1)).getTamanho(); i++) {
            estB[i + 2][1] = ((UC) ((ArrayL) b.getArrayL().getIndex(1)).getIndex(i)).getIdUC();
        }

        //poe totais colunas
        for (int i = 2; i < 6; i++) {//para cada coluna
            int totalColuna = 0;
            for (int j = 2; j < ((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 2; j++) {//Para cada linha
                if(estB[j][i] != null) totalColuna += Integer.parseInt(estB[j][i]);
            }
            estB[((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 2][i] = "" + totalColuna;
        }

//        Imprime tabela 2
//        for (int i = 0; i < 17; i++) {
//            for (int j = 0; j < 6; j++) {
//                System.out.print(estB[i][j] + "\t");
//            }
//            System.out.println("");
//        }

        //imprime tudo pra tabela final
        //tabela A
        for (int i = 0; i < ((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 3; i++) {
            for (int j = 0; j < 8; j++) {
                finalUcs[i][j] = estA[i][j];
            }
        }
        //tabela B
        for (int i = 0; i < ((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 3; i++) {
            for (int j = 0; j < 6; j++) {
                finalUcs[((ArrayL) b.getArrayL().getIndex(1)).getTamanho() + 4 + i][j] = estA[i][j];
            }
        }
        ExportaHTML h1 = new ExportaHTML(finalUcs, "ucs");

    }

    /**
     * Este método contém toda a informação necessária para o cálculo da estatística
     * dos resultados por unidade curricular, considerando apenas os alunos que participaram na
     * avaliacao(Excluindo as classificações com NC e NF)
     * @param b Objecto da BaseDadosCurso
     * @param epoca Época
     * @param numAluno Número do aluno
     * @param pautaFinal Array
     */
    private void contaAlunos(BaseDadosCurso b, String epoca, int numAluno, ArrayL pautaFinal) {
        Aluno alunoT = null;

        for (int i = 0; i < ((ArrayL) b.getArrayL().getIndex(2)).getTamanho(); i++) {
            if (numAluno == ((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getNumAluno()) {
                alunoT = (Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i);
            }
        }

        if ("NM".equals(epoca)) {
            pautaFinal.adiciona(alunoT);
        } else {
            if (alunosAprov.contains(alunoT)) {
            } else if (alunosReprov.contains(alunoT)) {
                if (pautaFinal == alunosAprov) {
                    alunosAprov.adiciona(alunoT);
                    alunosReprov.remove(alunoT);
                }
            } else if (alunosSM.contains(alunoT)) {
                if (pautaFinal == alunosAprov || pautaFinal == alunosReprov) {
                    pautaFinal.adiciona(alunoT);
                    alunosSM.remove(alunoT);
                }
            } else if (alunosNC.contains(alunoT)) {
                if (pautaFinal == alunosAprov || pautaFinal == alunosReprov || pautaFinal == alunosSM) {
                    pautaFinal.adiciona(alunoT);
                    alunosNC.remove(alunoT);
                }
            }
        }
    }

    /**
     * Este método contém toda a informação necessária para o cálculo das estatísticas
     * dos resultados dos alunos.
     * @param b Objecto da BaseDadosCurso
     */
    public void trataResAlunos(BaseDadosCurso b) throws Exception {
        //------Inicio da estatistica a, b)
        int[][] estA = new int[10][11];
        int[][] estB = new int[6][10];

        for (int i = 0; i < ((ArrayL) b.getArrayL().getIndex(2)).getTamanho(); i++) {
            Aluno at = ((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i));
            int nPassou = 0;
            int nInscrito = 0;
            int ano = at.getAnoAluno();
            for (int j = 0; j < at.getDiscipAR().length; j++) {
                if ("Passou".equals(at.getDiscipAR()[j])) {
                    nPassou++;
                    nInscrito++;
                } else if ("Inscrito".equals(at.getDiscipAR()[j]) || "SM".equals(at.getDiscipAR()[j])) {
                    nInscrito++;
                }
            }
            if (nInscrito != 0 || nPassou != 0) {
                estA[nInscrito - 1][nPassou]++;
                estB[ano + 1][nPassou]++;
            }
        }

        int nLinhas = 0;
        for (int i = 0; i < 10; i++) {
            int nLinT = 0;
            for (int j = 0; j < 11; j++) {
                if (estA[i][j] != 0) {
                    nLinT = j + 1;
                }
            }
            if (nLinT > nLinhas) {
                nLinhas = nLinT;
            }
        }

        int nColunas = 0;
        for (int i = 0; i < 11; i++) {
            int nColT = 0;
            for (int j = 0; j < 10; j++) {
                if (estA[j][i] != 0) {
                    nColT = j + 1;
                }
            }
            if (nColT > nColunas) {
                nColunas = nColT;
            }
        }

        String[][] finalAlunos = new String[(nLinhas + 4) + 1 + 5 + 7][nColunas + 7];

        finalAlunos[0][1] = "Num de UCs em que o aluno foi aprovado";
        finalAlunos[1][0] = "Num de UCs inscrito";
        finalAlunos[nLinhas + 2][0] = "Total";
        finalAlunos[nLinhas + 3][0] = "%";
        finalAlunos[1][nColunas + 1] = "Total";
        finalAlunos[1][nColunas + 2] = "%";
        for (int i = 2; i < nLinhas + 2; i++) {
            finalAlunos[i][0] = String.valueOf(i - 1);
        }
        for (int i = 1; i < nColunas + 1; i++) {
            finalAlunos[1][i] = String.valueOf(i - 1);
        }
        //copia tabelas para a final
        //tabela A
        for (int i = 0; i < nLinhas + 2; i++) {
            for (int j = 0; j < nColunas + 1; j++) {
                finalAlunos[i + 2][j + 1] = String.valueOf(estA[i][j]);
            }
        }

        //trata totais linhas
        for (int i = 0; i < nLinhas; i++) {
            int totalLinha = 0;
            for (int j = 0; j < nColunas; j++) {
                totalLinha += estA[i][j];
            }
            finalAlunos[i + 2][nColunas + 1] = String.valueOf(totalLinha);
        }

        //trata totais colunas
        for (int i = 0; i < nColunas; i++) {
            int totalColuna = 0;
            for (int j = 0; j < nLinhas; j++) {
                totalColuna += estA[j][i];
            }
            finalAlunos[nLinhas + 2][i + 1] = String.valueOf(totalColuna);
        }
        //trata grandTotal
        int grandT = 0;
        for (int i = 2; i < nLinhas + 2; i++) {
            grandT += Integer.parseInt(finalAlunos[i][nColunas + 1]);
        }
        finalAlunos[nLinhas + 2][nColunas + 1] = String.valueOf(grandT);

        //trata percentagens linha
        for (int i = 2; i < nLinhas + 2; i++) {
            float perc = (Float.parseFloat(finalAlunos[i][nColunas + 1]) / Integer.parseInt(finalAlunos[nLinhas + 2][nColunas + 1])) * 100;
            DecimalFormat df = new DecimalFormat("#.#");
            finalAlunos[i][nColunas + 2] = df.format(perc) + "%";
        }

        //trata percentagens coluna
        for (int i = 1; i < nColunas + 1; i++) {
            float perc = (Float.parseFloat(finalAlunos[nLinhas + 2][i]) / Integer.parseInt(finalAlunos[nLinhas + 2][nColunas + 1])) * 100;
            DecimalFormat df = new DecimalFormat("#.#");
            finalAlunos[nLinhas + 3][i] = df.format(perc) + "%";
        }

        finalAlunos[nLinhas + 5][0] = "Ano do Aluno";
        finalAlunos[nLinhas + 6][0] = "1";
        finalAlunos[nLinhas + 7][0] = "2";
        finalAlunos[nLinhas + 8][0] = "3";
        finalAlunos[nLinhas + 9][0] = "Total";

        for (int i = 2; i < 5; i++) {
            for (int j = 0; j < nColunas; j++) {
                finalAlunos[nLinhas + 4 + i][j + 1] = String.valueOf(estB[i][j]);
            }
        }

        //trata total Linhas b
        for (int i = 2; i < 5; i++) {
            int totalLinha = 0;
            for (int j = 0; j < nColunas; j++) {
                totalLinha += estB[i][j];
            }
            finalAlunos[nLinhas + 4 + i][nColunas + 1] = String.valueOf(totalLinha);
        }

        //trata total Colunas b
        for (int i = 0; i < nColunas; i++) {
            int totalColuna = 0;
            for (int j = 2; j < 5; j++) {
                totalColuna += estB[j][i];
            }
            finalAlunos[nLinhas + 7 + 2][i + 1] = String.valueOf(totalColuna);
        }

        //trata grandTotal b
        int grandTb = 0;
        for (int i = nLinhas + 4 + 2; i < nLinhas + 7 + 2; i++) {
            grandTb += Integer.parseInt(finalAlunos[i][nColunas + 1]);
        }
        finalAlunos[nLinhas + 7 + 2][nColunas + 1] = String.valueOf(grandTb);
        //------Fim da estatistica a, b)

        //------Inicio da estatistica e)
        int aprovados1 = 0;
        int aprovados2 = 0;
        int aprovados3 = 0;
        int inscritos1 = 0;
        int inscritos2 = 0;
        int inscritos3 = 0;
        int avaliados1 = 0;
        int avaliados2 = 0;
        int avaliados3 = 0;
        String[][] estE = new String[5][5];

        for (int i = 0; i < ((ArrayL) b.getArrayL().getIndex(2)).getTamanho(); i++) {
            for (int j = 0; j < ((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getDiscipAR().length; j++) {
                if ("Inscrito".equals(((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getDiscipAR()[j])) {
                    if (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getAnoAluno() == 1) {
                        inscritos1++;
                    } else if (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getAnoAluno() == 2) {
                        inscritos2++;
                    } else if (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getAnoAluno() == 3) {
                        inscritos3++;
                    }
                } else if ("Passou".equals(((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getDiscipAR()[j])) {
                    if (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getAnoAluno() == 1) {
                        inscritos1++;
                        avaliados1++;
                        aprovados1++;
                    } else if (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getAnoAluno() == 2) {
                        inscritos2++;
                        avaliados2++;
                        aprovados2++;
                    } else if (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getAnoAluno() == 3) {
                        inscritos3++;
                        avaliados3++;
                        aprovados3++;
                    }
                } else if ("SM".equals(((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getDiscipAR()[j])) {
                    if (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getAnoAluno() == 1) {
                        inscritos1++;
                        avaliados1++;
                    } else if (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getAnoAluno() == 2) {
                        inscritos2++;
                        avaliados2++;
                    } else if (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getAnoAluno() == 3) {
                        inscritos3++;
                        avaliados3++;
                    }
                }
            }

            estE[0][0] = "Anos";
            estE[0][1] = "Total";
            estE[0][2] = "%";
            estE[1][1] = "Ins";
            estE[1][2] = "Av/Ins";
            estE[1][3] = "Ap/Ins";
            estE[1][4] = "Ap/avs";
            estE[2][0] = "1º Ano";
            estE[3][0] = "2º Ano";
            estE[4][0] = "3º Ano";

            estE[2][1] = String.valueOf(inscritos1);
            estE[3][1] = String.valueOf(inscritos2);
            estE[4][1] = String.valueOf(inscritos3);

            DecimalFormat df = new DecimalFormat("##");

            float perc = Float.parseFloat(String.valueOf(avaliados1)) / inscritos1 * 100;
            estE[2][2] = df.format(perc) + "%";
            perc = Float.parseFloat(String.valueOf(avaliados2)) / inscritos2 * 100;
            estE[3][2] = df.format(perc) + "%";
            perc = Float.parseFloat(String.valueOf(avaliados3)) / inscritos3 * 100;
            estE[4][2] = df.format(perc) + "%";

            perc = Float.parseFloat(String.valueOf(aprovados1)) / inscritos1 * 100;
            estE[2][3] = df.format(perc) + "%";
            perc = Float.parseFloat(String.valueOf(aprovados2)) / inscritos2 * 100;
            estE[3][3] = df.format(perc) + "%";
            perc = Float.parseFloat(String.valueOf(aprovados3)) / inscritos3 * 100;
            estE[4][3] = df.format(perc) + "%";

            perc = Float.parseFloat(String.valueOf(aprovados1)) / avaliados1 * 100;
            estE[2][4] = df.format(perc) + "%";
            perc = Float.parseFloat(String.valueOf(aprovados2)) / avaliados2 * 100;
            estE[3][4] = df.format(perc) + "%";
            perc = Float.parseFloat(String.valueOf(aprovados3)) / avaliados3 * 100;
            estE[4][4] = df.format(perc) + "%";

            //------Fim da estatistica e)
        }

        for (int i = 0; i < estE.length; i++) {
            for (int j = 0; j < estE[0].length; j++) {
                finalAlunos[nLinhas + 11 + i][j] = estE[i][j];
            }
        }
        ExportaHTML alunos = new ExportaHTML(finalAlunos, "alunos");
    }

    /**
     * Este método verifica, após ler uma pauta, se um aluno estando inscrito numa
     * unidade curricular, a concluiu com sucesso ou não.
     * @param b Objecto da classe BaseDadosCurso
     */
    public void adicionaResCadeiras(BaseDadosCurso b) {
        int tipo = 0;
        for (int i = 0; i < ((ArrayL) b.getArrayL().getIndex(2)).getTamanho(); i++) {//Aluno
            Aluno at = ((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i));
            int numAluno = at.getNumAluno();
            for (int j = 0; j < ((ArrayL) b.getArrayL().getIndex(1)).getTamanho(); j++) {//UC
                for (int contaIteracao = 0; contaIteracao < 3; contaIteracao++) {
                    int numUC = Integer.parseInt((((((UC) ((ArrayL) b.getArrayL().getIndex(1)).getIndex(j)).getIdUC()).substring(2, 4)).startsWith("0")) ? (((UC) ((ArrayL) b.getArrayL().getIndex(1)).getIndex(j)).getIdUC()).substring(3, 4) : (((UC) ((ArrayL) b.getArrayL().getIndex(1)).getIndex(j)).getIdUC()).substring(2, 4));
                    for (int k = 0; k < ((UC) ((ArrayL) b.getArrayL().getIndex(1)).getIndex(j)).getPautas().getTamanho(); k++) { // para cada pauta
                        LerPauta p2 = (LerPauta) ((UC) ((ArrayL) b.getArrayL().getIndex(1)).getIndex(j)).getPautas().getIndex(k);
                        String[][] matriz = p2.getPauta();
                        if ("NFAFER".equals(p2.getTipo())) {
                            tipo = 0;
                        } else if ("NFER".equals(p2.getTipo())) {
                            tipo = -1;
                        }
                        for (int l = 6; l < p2.getnLin(); l++) {
                            if (numAluno == Integer.parseInt(matriz[l][0])) {
                                if (contaIteracao == 0) {
                                    (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getDiscipAR())[numUC - 1] = "Inscrito";
                                } else if (contaIteracao == 1) {
                                    try {
                                        if (Integer.parseInt(matriz[l][tipo + 4]) >= 10) {
                                            (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getDiscipAR())[numUC - 1] = "Passou";
                                        }
                                    } catch (NumberFormatException nfe3) {
                                    }
                                } else if (contaIteracao == 2) {
                                    try {
                                        if ("SM ".equals(matriz[l][tipo + 4]) || Integer.parseInt(matriz[l][tipo + 4]) < 10) {
                                            if ("Inscrito".equals((((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getDiscipAR())[numUC - 1])) {
                                                (((Aluno) ((ArrayL) b.getArrayL().getIndex(2)).getIndex(i)).getDiscipAR())[numUC - 1] = "SM";
                                            }
                                        }
                                    } catch (NumberFormatException nfe3) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
