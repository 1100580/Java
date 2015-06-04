import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfaceGrafico extends JFrame {
    private Adivinha a;
    private JTextField t1;
    private JLabel resposta;
    private JButton b1;
    
    public InterfaceGrafico(Adivinha a) {
        super("Jogo da Adivinha");
        this.a = a;
        Container c = getContentPane();
        String tit1 = "Bem-vindo ao Jogo da Adivinha de um Número.";
        String tit2 = "Estou a pensar num número entre 1 e 100.";
        String tit = "<html> <h1> "+ tit1 + " </h1> " +
                        " <h2> " + tit2 + " </h2>  <p> </html> ";
        JLabel titulo = new JLabel(tit);
        JPanel p1 = new JPanel();
        p1.add(titulo);
        c.add(p1, BorderLayout.NORTH);
        
        JLabel l3 = new JLabel("Qual é o número?");
        t1 = new JTextField(5);
        JPanel p2 = new JPanel();
        p2.add(l3);
        p2.add(t1);
        
        resposta = new JLabel();
        JPanel p3 = new JPanel();
        p3.add(resposta);
        
        JPanel pCentro = new JPanel(new GridLayout(2,1));
        pCentro.add(p2);
        pCentro.add(p3);
        c.add(pCentro, BorderLayout.CENTER);
        
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        b1 = new JButton("Novo Jogo");
        p4.add(b1);
        b1.setVisible(false);
        c.add(p4, BorderLayout.SOUTH);
        
        t1.addActionListener(new TrataEvResposta());
        b1.addActionListener(new TrataEvNovoJogo());
    }
    
    public String respostaErro() {
        String info1 = "Boa tentativa, mas falhou.";
        String info2 = "Tente " + a.getSugestao(t1.getText());
//        String info3 = "Já fez " + a.getNumTentativas() + " tentativas.";
        int n = a.getNumTentativas();
        String info3 = "Já fez " + n + " tentativa" + (n>1?"s":"") + ".";
        String infoErro = "<html> <h2> "+ info1 + "<p>" + info2 + "<p>" + info3
                       + " </h2>  <p> </html> ";
        return infoErro;
    }
    
    public String respostaSucesso() {
         String info4 = "Parabéns.";
        String info5 = "Acertou ao fim de " + a.getNumTentativas() + " tentativas.";;
        String infoAcerto = "<html> <h2> "+ info4 + "<p>" + info5 + "<p>"
                       + " </h2>  <p> </html> ";
        return infoAcerto;
    }
    
    
    class TrataEvResposta implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == t1) {
                a.setTentativa();
                a.getNumTentativas();
                if (a.getSucesso(t1.getText())) {
                    resposta.setText(respostaSucesso());
                    t1.setEnabled(false);
                    b1.setVisible(true);
                }
                else resposta.setText(respostaErro());
                t1.setText("");
            }
        }
    }
    
       class TrataEvNovoJogo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                t1.setEnabled(true);
                t1.setText("");
                b1.setVisible(false);
                a.iniciar();
                resposta.setText("");
                resposta.setBackground(Color.white);
            }
        }
    }
    
}