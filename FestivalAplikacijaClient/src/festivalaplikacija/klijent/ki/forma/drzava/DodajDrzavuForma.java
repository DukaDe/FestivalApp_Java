package festivalaplikacija.klijent.ki.forma.drzava;

import festivalaplikacija.klijent.ki.forma.drzava.kontroler.DodajDrzavuFormaKontroler;
import javax.swing.JOptionPane;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class DodajDrzavuForma extends javax.swing.JDialog {
    /**
     * Creates new form DodajDrzavuForma
     */
    public DodajDrzavuForma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblGreskaDodajDrzavu.setText("");
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        lblSkraceniNaziv = new javax.swing.JLabel();
        txtSkraceniNaziv = new javax.swing.JTextField();
        lblGreskaDodajDrzavu = new javax.swing.JLabel();
        btnDodajDrzavu = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dodaj novu drzavu");
        setBackground(new java.awt.Color(0, 0, 0));

        lblNaziv.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNaziv.setText("Naziv:");

        lblSkraceniNaziv.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSkraceniNaziv.setText("Skraceni naziv:");

        lblGreskaDodajDrzavu.setBackground(new java.awt.Color(255, 255, 255));
        lblGreskaDodajDrzavu.setForeground(new java.awt.Color(255, 0, 51));
        lblGreskaDodajDrzavu.setText("jLabel2");

        btnDodajDrzavu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDodajDrzavu.setText("Dodaj");
        btnDodajDrzavu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajDrzavuActionPerformed(evt);
            }
        });

        btnOdustani.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOdustani.setText("Izadji");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNaziv))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblSkraceniNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSkraceniNaziv))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                                        .addComponent(btnDodajDrzavu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblGreskaDodajDrzavu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSkraceniNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSkraceniNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGreskaDodajDrzavu)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajDrzavu)
                    .addComponent(btnOdustani))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnDodajDrzavuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajDrzavuActionPerformed

        try {
            DodajDrzavuFormaKontroler.add(lblGreskaDodajDrzavu, txtNaziv, txtSkraceniNaziv, this);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Konekcija sa serverom je prekinuta. Vaša sesija će biti zatvorena", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }//GEN-LAST:event_btnDodajDrzavuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajDrzavu;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JLabel lblGreskaDodajDrzavu;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblSkraceniNaziv;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtSkraceniNaziv;
    // End of variables declaration//GEN-END:variables
}
