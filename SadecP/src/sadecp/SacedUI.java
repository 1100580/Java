package sadecp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SacedUI extends javax.swing.JFrame {
    
    int width;
    int height;

    public SacedUI() {
        this.setResizable(false);
        initComponents();
    }

    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        listModel = new javax.swing.DefaultListModel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        listModel2 = new javax.swing.DefaultListModel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        listSelectionModel = jList1.getSelectionModel();
        listSelectionModel.addListSelectionListener(
                new SharedListSelectionHandler());

        listSelectionModel2 = jList2.getSelectionModel();
        listSelectionModel2.addListSelectionListener(
                new SharedListSelectionHandler());

        initDB();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setText("Diagnóstico");

        jLabel2.setText("Problemas existentes");

        jTextField1.setText("Search");

        fillDiag(listModel);
        fillDoen(listModel2);

        jList1.setModel(listModel2);
        jScrollPane1.setViewportView(jList1);

        jTextField2.setText("Search");
        jTextField1.addActionListener(new MyTextActionListener());
        jTextField2.addActionListener(new MyTextActionListener2());

        jList2.setModel(listModel);
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jScrollPane2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jTextField2)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1)
                                .addComponent(jScrollPane2))
                        .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 0, 51));

        jLabel3.setText("Avisos!");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setText("Por favor escolha o diagnóstico e os problemas conhecidos.");
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                        .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)
                        .addContainerGap())
        );
        //TODO QUANDO IMPLEMENTAR O ADICIONAR FILES DO MENU
/*
        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);
*/
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );

        pack();
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SacedUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.ListSelectionModel listSelectionModel;
    private javax.swing.ListSelectionModel listSelectionModel2;
    private javax.swing.JList jList1;
    private DefaultListModel listModel;
    private javax.swing.JList jList2;
    private DefaultListModel listModel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;

    private ArrayList<Diagnostico> dbDiagnostico;
    private ArrayList<ContraI> dbDoenca;

    private void initDB() {

        dbDiagnostico = new ArrayList();
        dbDoenca = new ArrayList();

        ContraI c1 = new ContraI("Insuficiencia Renal");
        ContraI c2 = new ContraI("Diabetes");
        ContraI c3 = new ContraI("Problemas cardiacos");

        ArrayList<ContraI> ac1 = new ArrayList();
        ac1.add(c1);
        ac1.add(c2);

        ArrayList<ContraI> ac2 = new ArrayList();
        ac2.add(c2);
        ac2.add(c3);

        ArrayList<ContraI> ac3 = new ArrayList();
        ac3.add(c1);
        ac3.add(c3);

        Medicamento m1 = new Medicamento("Anfotericina B ", ac1);
        Medicamento m2 = new Medicamento("Caspofungina", ac2);
        Medicamento m3 = new Medicamento("Voriconazol", ac3);
        Medicamento m4 = new Medicamento("Itraconazol", ac1);
        Medicamento m5 = new Medicamento("Fluconazol", ac2);
        Medicamento m6 = new Medicamento("Terbinafina", ac3);

        ArrayList<Medicamento> am1 = new ArrayList();
        am1.add(m1);
        am1.add(m2);
        ArrayList<Medicamento> am2 = new ArrayList();
        am2.add(m2);
        am2.add(m3);
        ArrayList<Medicamento> am3 = new ArrayList();
        am3.add(m3);
        am3.add(m4);
        ArrayList<Medicamento> am4 = new ArrayList();
        am4.add(m4);
        am4.add(m5);
        ArrayList<Medicamento> am5 = new ArrayList();
        am5.add(m5);
        am5.add(m6);
        ArrayList<Medicamento> am6 = new ArrayList();
        am6.add(m6);
        am6.add(m1);

        Diagnostico d1 = new Diagnostico("Candidose", am1);
        Diagnostico d2 = new Diagnostico("Histoplasmose", am2);
        Diagnostico d3 = new Diagnostico("Criptococose", am3);
        Diagnostico d4 = new Diagnostico("Coccidiomicose", am4);
        Diagnostico d5 = new Diagnostico("Blastomicose", am5);
        Diagnostico d6 = new Diagnostico("Aspergilose", am6);
        Diagnostico d7 = new Diagnostico("Esporotricose", am1);
        Diagnostico d8 = new Diagnostico("Dermatófitos", am2);
        Diagnostico d9 = new Diagnostico("Síndrome febril em neutropénicos ", am3);

        dbDiagnostico.add(d1);
        dbDiagnostico.add(d2);
        dbDiagnostico.add(d3);
        dbDiagnostico.add(d4);
        dbDiagnostico.add(d5);
        dbDiagnostico.add(d6);
        dbDiagnostico.add(d7);
        dbDiagnostico.add(d8);
        dbDiagnostico.add(d9);

        dbDoenca.add(c1);
        dbDoenca.add(c2);
        dbDoenca.add(c3);

    }

    private void fillDiag(DefaultListModel model) {
        model.removeAllElements();
        for (Diagnostico diagnostico : dbDiagnostico) {
            model.addElement(diagnostico.getNome());
        }
    }

    private void fillDoen(DefaultListModel model) {
        model.removeAllElements();
        for (ContraI c : dbDoenca) {
            model.addElement(c.getNome());
        }
    }

    class MyTextActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String name = jTextField1.getText();

            //User did not type in a unique name...
            if (name.equals("")) {
                fillDiag(listModel);
            } else {
                listModel.removeAllElements();
                for (Diagnostico diagnostico : dbDiagnostico) {
                    if (diagnostico.getNome().contains(name)) {
                        listModel.addElement(diagnostico.getNome());
                    }
                }
            }

        }
    }

    class MyTextActionListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String name = jTextField2.getText();

            //User did not type in a unique name...
            if (name.equals("")) {
                fillDoen(listModel2);
            } else {
                listModel2.removeAllElements();
                for (ContraI ci : dbDoenca) {
                    if (ci.getNome().contains(name)) {
                        listModel2.addElement(ci.getNome());
                    }
                }
            }

        }
    }

    class SharedListSelectionHandler implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {

            ArrayList<String> diags = new ArrayList();
            ArrayList<String> doencas = new ArrayList();

            if (listSelectionModel.isSelectionEmpty() || listSelectionModel2.isSelectionEmpty()) {
                jTextArea1.setText("Por favor escolha o diagnóstico e os problemas conhecidos.");
            } else {
                jTextArea1.setText("");
                String text = "";

                //DIAGS
                int minIndex = listSelectionModel.getMinSelectionIndex();
                int maxIndex = listSelectionModel.getMaxSelectionIndex();
                for (int i = minIndex; i <= maxIndex; i++) {
                    if (listSelectionModel.isSelectedIndex(i)) {
                        doencas.add(jList1.getModel().getElementAt(i).toString());
                    }
                }

                //DOENCAS
                int minIndex2 = listSelectionModel2.getMinSelectionIndex();
                int maxIndex2 = listSelectionModel2.getMaxSelectionIndex();
                for (int i = minIndex2; i <= maxIndex2; i++) {
                    if (listSelectionModel2.isSelectedIndex(i)) {
                        diags.add(jList2.getModel().getElementAt(i).toString());
                    }
                }

                for (String a : doencas) {
                    for (String b : diags) {
                        Diagnostico d1 = findDiagByName(b);
                        if (d1 != null) {
                            for (Medicamento m : d1.getTratamentos()) {
                                for (ContraI ci : m.getContraIndicadoes()) {
                                    if (ci.getNome().equals(a)) {
                                        text += "O medicamento " + m.getNome() + " não pode ser tomado com pessoas com " + ci.getNome() + ".\n\n";
                                    }
                                }
                            }
                        } else {
                            System.out.println("DIAG IS NULL");
                        }
                    }
                }

                jTextArea1.setText(text);
            }
        }

        private Diagnostico findDiagByName(String n) {
            for (Diagnostico diagnostico : dbDiagnostico) {
                if (diagnostico.getNome().equals(n)) {
                    return diagnostico;
                }
            }
            return null;
        }
    }
}
