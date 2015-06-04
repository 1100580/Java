package contasbancarias;

import biblioteca.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Janela extends JFrame {

    public Janela() {
        super("Gestão de Contas Bancárias");

        if (!Contas.lerFicheiroContas())
            JOptionPane.showMessageDialog(this, "Ficheiro de contas inexistente!", "Leitura de Contas", JOptionPane.INFORMATION_MESSAGE);

        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        menuBar = new JMenuBar();

        menu = new JMenu("Gestão");
        menu.setMnemonic('G');
        menuBar.add(menu);

        menuItem = new JMenuItem("Criar", 'C');
        menuItem.setAccelerator(KeyStroke.getKeyStroke('C', ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                DialogCriarConta dialog = new DialogCriarConta(Janela.this);
                Conta conta = dialog.showDialog();
                if (conta != null) {
                    Contas.adicionarConta(conta);
                }
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Consultar", 'A');
        menuItem.setAccelerator(KeyStroke.getKeyStroke('A', ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (!Contas.estaVazio()) {
                    DialogConsultarConta dialog = new DialogConsultarConta(Janela.this);
                    dialog.showDialog();
                } else {
                    JOptionPane.showMessageDialog(Janela.this, "Não há contas", "Consultar", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Eliminar", 'E');
        menuItem.setAccelerator(KeyStroke.getKeyStroke('E', ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (!Contas.estaVazio()) {
                    Object[] opcoes = Contas.getContas().toArray();
                    Conta c = (Conta) JOptionPane.showInputDialog(Janela.this, "Escolha uma conta:", "Eliminar Conta", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
                    if (c != null) {
                        String[] opcoes2 = {"Sim", "Não"};
                        int resposta = JOptionPane.showOptionDialog(Janela.this, "Eliminar\n" + c.toString(), "Eliminar Conta", 0, JOptionPane.QUESTION_MESSAGE, null, opcoes2, opcoes2[0]);
                        if (resposta == 0) {
                            Contas.removerConta(c);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(Janela.this, "Não há contas", "Eliminar", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        menu.add(menuItem);

        JMenu subMenu = new JMenu("Listar");
        subMenu.setMnemonic('L');
        menu.add(subMenu);

        menuItem = new JMenuItem("Titulares",'T');
        menuItem.setAccelerator(KeyStroke.getKeyStroke('T', ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (!Contas.estaVazio()) {
                    JList lstTitulares = new JList(Contas.getTitulares().toArray());
                    lstTitulares.setFixedCellWidth(50);
                    JScrollPane scrollPane = new JScrollPane(lstTitulares);
                    JOptionPane.showMessageDialog(Janela.this, scrollPane, "Titulares", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Janela.this, "Não há contas", "Listar Titulares", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        subMenu.add(menuItem);

        menuItem = new JMenuItem("Saldos", 'D');
        menuItem.setAccelerator(KeyStroke.getKeyStroke('D', ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (!Contas.estaVazio()) {
                    JPanel panLista = new JPanel(new BorderLayout());
                    JLabel lbl = new JLabel(String.format("%-22s Saldo (€)", "Nr. Conta"));
                    panLista.add(lbl, BorderLayout.NORTH);
                    JList lstSaldos = new JList(saldos());
                    JScrollPane scrollPane = new JScrollPane(lstSaldos);
                    panLista.add(scrollPane, BorderLayout.SOUTH);
                    JOptionPane.showMessageDialog(Janela.this, panLista, "Saldos", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Janela.this, "Não há contas", "Listar Saldos", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        subMenu.add(menuItem);

        menu.addSeparator();

        menuItem = new JMenuItem("Sair", 'S');
        menuItem.setAccelerator(KeyStroke.getKeyStroke('S', ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
        menu.add(menuItem);

        menu = new JMenu("Ficheiro");
        menu.setMnemonic('F');
        menuBar.add(menu);

        menuItem = new JMenuItem("Adicionar Contas", 'A');
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Contas.adicionarContas())
                    JOptionPane.showMessageDialog(Janela.this, "Contas adicionadas com sucesso", "Adicionar Contas", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(Janela.this, "Leitura de Contas Impossível!", "Adicionar Contas", JOptionPane.ERROR_MESSAGE);
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Listagem de Contas", 'L');
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Contas.ficheiroListagemContas())
                    JOptionPane.showMessageDialog(Janela.this, "Listagem criada com sucesso", "Listagem de Contas", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(Janela.this, "Listagem não foi criada!", "Listagem de Contas", JOptionPane.ERROR_MESSAGE);
            }
        });
        menu.add(menuItem);

        menu = new JMenu("Ajuda");
        menu.setMnemonic('A');
        menuBar.add(menu);

        menuItem = new JMenuItem("Acerca", 'C');
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Janela.this, "PProg 2010/2011\n@Copyright", "Gestão de Contas Bancárias", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menu.add(menuItem);

        setJMenuBar(menuBar);

        add(new JLabel(new ImageIcon("isep_logo.jpg")));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fechar();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(410,410);
        setResizable(false);
        setLocation(200, 200);
        setVisible(true);
    }

    private void fechar() {
        Object[] opSimNao = {"Sim", "Não"};
        if (JOptionPane.showOptionDialog(this, "Deseja fechar a aplicação?", "Gestão de Contas Bancárias", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1]) == 0) {
            if (!Contas.escreverFicheiroContas())
                JOptionPane.showMessageDialog(this, "Contas Não Armazenadas!!!", "Fechar Aplicação", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }

    private Object[] saldos() {
        ArrayList a = new ArrayList();
        for (Conta c : Contas.getContas()) {
            a.add(String.format("%-30d%.2f", c.getNrConta(), c.getSaldo()));
        }
        return a.toArray();
    }

}
