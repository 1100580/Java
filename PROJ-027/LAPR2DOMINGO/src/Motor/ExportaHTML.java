package Motor;

import java.io.File;
import java.io.Serializable;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Classe de Formatação HTML
 * @author Grupo 27
 */
public class ExportaHTML implements Serializable {

    /**
     * Class constructor
     * Formatação HTML
     * @param matriz
     * @throws Exception
     */
    public ExportaHTML(String[][] matriz, String tabela) throws Exception {
        String nomeFicheiro = JOptionPane.showInputDialog("Qual o nome que quer dar ao ficheiro da tabela de " + tabela + "?");
        Formatter fo = new Formatter(new File("src/estatisticas/" + nomeFicheiro + ".html"));
        String texto = "<!DOCTYPE HTML PUBLIC " + "-//W3C//DTD HTML 4.01//EN)";
        fo.format("%s%n", texto);
        texto = "http://www.w3.org/TR/html4/strict.dtd" + ">";
        fo.format("%s%n", texto);
        texto = "<meta content=\"text/html; charset=pt\"" + ">";
        fo.format("%s%n", texto);
        texto = "<html>";
        fo.format("%s%n", texto);
        texto = "<head>";
        fo.format("%s%n", texto);
        texto = "</head>";
        fo.format("%s%n", texto);
        texto = "<body>";
        fo.format("%s%n", texto);
        texto = "<p>1DH LAPR 2</p>";
        fo.format("%s%n", texto);
        texto = "<table>";
        fo.format("%s%n", texto);
        texto = "</table>";
        fo.format("%s%n", texto);
        texto = "<table border=\"1\" CELLSPACING=4>";
        fo.format("%s%n", texto);
        texto = "";
        for (int i = 0; i < matriz.length; i++) {
            texto += "<tr>";
            for (int j = 0; j < matriz[0].length; j++) {
                String a = matriz[i][j];
                if (a == null) {
                    a = "";
                }
                texto += "<td WIDTH=50>" + a + "</td>";
            }
            texto += "</tr>";
            fo.format("%s%n", texto);
            texto = "";
        }
        texto = "</table>";
        fo.format("%s%n", texto);
        texto = "</body>";
        fo.format("%s%n", texto);
        texto = "</html>";
        fo.format("%s%n", texto);
        fo.close();
    }

}