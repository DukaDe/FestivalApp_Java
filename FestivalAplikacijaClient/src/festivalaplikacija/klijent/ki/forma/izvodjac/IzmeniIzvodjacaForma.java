package festivalaplikacija.klijent.ki.forma.izvodjac;

import festivalaplikacija.klijent.ki.forma.izvodjac.kontroler.IzmeniIzvodjacaFormaKontroler;
import javax.swing.JOptionPane;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class IzmeniIzvodjacaForma extends javax.swing.JDialog {

    /**
     * Creates new form IzmeniIzvodjacaForma
     */
    public IzmeniIzvodjacaForma(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        pripremiFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblIzmeniIzvodjaca = new javax.swing.JTable();
        btnObrisi = new javax.swing.JButton();
        lblIzmeniIzvodjacaGreska = new javax.swing.JLabel();
        pnlAzurirajIzvodjaca = new javax.swing.JPanel();
        lblAzurirajIzvodjacaNaziv = new javax.swing.JLabel();
        lblAzurirajIzvodjacaKontaktOsoba = new javax.swing.JLabel();
        lblAzurirajIzvodjacaBrojTelefona = new javax.swing.JLabel();
        txtAzurirajIzvodjacaNaziv = new javax.swing.JTextField();
        txtAzurirajIzvodjacaKontaktOsoba = new javax.swing.JTextField();
        txtAzurirajIzvodjacaBrojTelefona = new javax.swing.JTextField();
        comboBoxAzurirajIzvodjacaMesta = new javax.swing.JComboBox<>();
        lblAzurirajIzvodjacaMesto = new javax.swing.JLabel();
        lblAzurirajIzvodjacaEmail = new javax.swing.JLabel();
        txtAzurirajIzvodjacaEmail = new javax.swing.JTextField();
        btnAzuriraj = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnIzadji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Izmeni izvodjaca");
        setBackground(new java.awt.Color(102, 153, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tblIzmeniIzvodjaca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblIzmeniIzvodjaca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIzmeniIzvodjacaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIzmeniIzvodjaca);

        btnObrisi.setBackground(new java.awt.Color(231, 206, 210));
        btnObrisi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        lblIzmeniIzvodjacaGreska.setBackground(new java.awt.Color(153, 0, 0));
        lblIzmeniIzvodjacaGreska.setText("jLabel1");

        pnlAzurirajIzvodjaca.setBackground(new java.awt.Color(182, 199, 199));
        pnlAzurirajIzvodjaca.setBorder(javax.swing.BorderFactory.createTitledBorder("Azuriraj izvodjaca"));
        pnlAzurirajIzvodjaca.setEnabled(false);

        lblAzurirajIzvodjacaNaziv.setText("Naziv:");

        lblAzurirajIzvodjacaKontaktOsoba.setText("Kontakt osoba:");

        lblAzurirajIzvodjacaBrojTelefona.setText("Broj telefona:");

        txtAzurirajIzvodjacaNaziv.setText("jTextField1");

        txtAzurirajIzvodjacaKontaktOsoba.setText("jTextField1");

        txtAzurirajIzvodjacaBrojTelefona.setText("jTextField1");

        comboBoxAzurirajIzvodjacaMesta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblAzurirajIzvodjacaMesto.setText("Mesto:");

        lblAzurirajIzvodjacaEmail.setText("email:");

        txtAzurirajIzvodjacaEmail.setText("jTextField1");

        btnAzuriraj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAzuriraj.setText("Azuriraj");
        btnAzuriraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajActionPerformed(evt);
            }
        });

        btnOdustani.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAzurirajIzvodjacaLayout = new javax.swing.GroupLayout(pnlAzurirajIzvodjaca);
        pnlAzurirajIzvodjaca.setLayout(pnlAzurirajIzvodjacaLayout);
        pnlAzurirajIzvodjacaLayout.setHorizontalGroup(
            pnlAzurirajIzvodjacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAzurirajIzvodjacaLayout.createSequentialGroup()
                .addGroup(pnlAzurirajIzvodjacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAzurirajIzvodjacaKontaktOsoba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAzurirajIzvodjacaNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAzurirajIzvodjacaBrojTelefona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAzurirajIzvodjacaEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAzurirajIzvodjacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAzurirajIzvodjacaNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(txtAzurirajIzvodjacaKontaktOsoba)
                    .addComponent(txtAzurirajIzvodjacaBrojTelefona)
                    .addComponent(txtAzurirajIzvodjacaEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAzurirajIzvodjacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAzurirajIzvodjacaLayout.createSequentialGroup()
                        .addComponent(lblAzurirajIzvodjacaMesto, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxAzurirajIzvodjacaMesta, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAzurirajIzvodjacaLayout.createSequentialGroup()
                        .addComponent(btnOdustani)
                        .addGap(18, 18, 18)
                        .addComponent(btnAzuriraj)))
                .addGap(18, 18, 18))
        );
        pnlAzurirajIzvodjacaLayout.setVerticalGroup(
            pnlAzurirajIzvodjacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAzurirajIzvodjacaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAzurirajIzvodjacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAzurirajIzvodjacaNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAzurirajIzvodjacaNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxAzurirajIzvodjacaMesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAzurirajIzvodjacaMesto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAzurirajIzvodjacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAzurirajIzvodjacaKontaktOsoba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAzurirajIzvodjacaKontaktOsoba, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlAzurirajIzvodjacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAzurirajIzvodjacaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAzurirajIzvodjacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAzurirajIzvodjacaBrojTelefona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAzurirajIzvodjacaBrojTelefona, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAzurirajIzvodjacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAzurirajIzvodjacaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAzurirajIzvodjacaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAzurirajIzvodjacaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlAzurirajIzvodjacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAzuriraj)
                            .addComponent(btnOdustani))
                        .addGap(14, 14, 14))))
        );

        btnIzmeni.setBackground(new java.awt.Color(231, 206, 210));
        btnIzmeni.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnIzadji.setBackground(new java.awt.Color(231, 206, 210));
        btnIzadji.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIzadji.setText("Izadji");
        btnIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzadjiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                            .addComponent(lblIzmeniIzvodjacaGreska, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(pnlAzurirajIzvodjaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIzmeniIzvodjacaGreska)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObrisi)
                    .addComponent(btnIzmeni)
                    .addComponent(btnIzadji))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlAzurirajIzvodjaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        IzmeniIzvodjacaFormaKontroler.delete(tblIzmeniIzvodjaca, this);

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            popuniTabelu();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Konekcija sa serverom je prekinuta. Vaša sesija će biti zatvorena", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowActivated

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        IzmeniIzvodjacaFormaKontroler.edit(tblIzmeniIzvodjaca, txtAzurirajIzvodjacaNaziv, txtAzurirajIzvodjacaKontaktOsoba, txtAzurirajIzvodjacaEmail, txtAzurirajIzvodjacaBrojTelefona, btnIzmeni, btnObrisi, btnAzuriraj, btnOdustani, this, pnlAzurirajIzvodjaca, comboBoxAzurirajIzvodjacaMesta);
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzadjiActionPerformed
        dispose();
    }//GEN-LAST:event_btnIzadjiActionPerformed

    private void tblIzmeniIzvodjacaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIzmeniIzvodjacaMouseClicked
        popuniPanel();
    }//GEN-LAST:event_tblIzmeniIzvodjacaMouseClicked

    private void btnAzurirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajActionPerformed
        IzmeniIzvodjacaFormaKontroler.update(txtAzurirajIzvodjacaNaziv, txtAzurirajIzvodjacaKontaktOsoba, txtAzurirajIzvodjacaEmail, txtAzurirajIzvodjacaBrojTelefona, comboBoxAzurirajIzvodjacaMesta, this, btnObrisi, btnIzmeni, btnAzuriraj, btnOdustani, tblIzmeniIzvodjaca, rootPaneCheckingEnabled, pnlAzurirajIzvodjaca);
    }//GEN-LAST:event_btnAzurirajActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        pnlAzurirajIzvodjaca.setEnabled(false);
        btnAzuriraj.setEnabled(false);
        btnIzmeni.setEnabled(true);
        btnIzadji.setEnabled(true);
        btnObrisi.setEnabled(true);
        btnOdustani.setEnabled(false);
        pripremiPanel(false);
    }//GEN-LAST:event_btnOdustaniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAzuriraj;
    private javax.swing.JButton btnIzadji;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JComboBox<Object> comboBoxAzurirajIzvodjacaMesta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAzurirajIzvodjacaBrojTelefona;
    private javax.swing.JLabel lblAzurirajIzvodjacaEmail;
    private javax.swing.JLabel lblAzurirajIzvodjacaKontaktOsoba;
    private javax.swing.JLabel lblAzurirajIzvodjacaMesto;
    private javax.swing.JLabel lblAzurirajIzvodjacaNaziv;
    private javax.swing.JLabel lblIzmeniIzvodjacaGreska;
    private javax.swing.JPanel pnlAzurirajIzvodjaca;
    private javax.swing.JTable tblIzmeniIzvodjaca;
    private javax.swing.JTextField txtAzurirajIzvodjacaBrojTelefona;
    private javax.swing.JTextField txtAzurirajIzvodjacaEmail;
    private javax.swing.JTextField txtAzurirajIzvodjacaKontaktOsoba;
    private javax.swing.JTextField txtAzurirajIzvodjacaNaziv;
    // End of variables declaration//GEN-END:variables

    private void pripremiFormu() throws Exception {
        popuniTabelu();
        lblIzmeniIzvodjacaGreska.setText("");
        pripremiPanel(false);
        this.add(pnlAzurirajIzvodjaca);

    }

    private void popuniTabelu() throws Exception {
        IzmeniIzvodjacaFormaKontroler.fillTable(tblIzmeniIzvodjaca);
    }

    private void pripremiPanel(boolean enable) {
        popuniComboBox();
        IzmeniIzvodjacaFormaKontroler.preparePanel(pnlAzurirajIzvodjaca, txtAzurirajIzvodjacaNaziv, txtAzurirajIzvodjacaKontaktOsoba, txtAzurirajIzvodjacaEmail, txtAzurirajIzvodjacaBrojTelefona, comboBoxAzurirajIzvodjacaMesta, btnAzuriraj, btnOdustani, enable);

    }

    private void popuniComboBox() {
        IzmeniIzvodjacaFormaKontroler.fillComboBox(comboBoxAzurirajIzvodjacaMesta);
    }

    private void popuniPanel() {
        IzmeniIzvodjacaFormaKontroler.fillPanel(tblIzmeniIzvodjaca, txtAzurirajIzvodjacaNaziv, txtAzurirajIzvodjacaKontaktOsoba, txtAzurirajIzvodjacaEmail, txtAzurirajIzvodjacaBrojTelefona, comboBoxAzurirajIzvodjacaMesta);
    }

}