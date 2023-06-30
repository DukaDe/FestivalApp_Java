package festivalaplikacija.klijent.ki.forma.mesto;

import festivalaplikacija.klijent.ki.forma.mesto.kontroler.IzmeniMestoFormaKontroler;
import festivalaplikacija.klijent.ki.forma.mesto.kontroler.PrikaziMestoFormaKontroler;
import javax.swing.JOptionPane;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class IzmeniMestoForma extends javax.swing.JDialog {

    /**
     * Creates new form IzmeniDrzavuForma
     */
    public IzmeniMestoForma(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
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

        lblGreska = new javax.swing.JLabel();
        btnIzadji = new javax.swing.JButton();
        btnIzmeniMesto = new javax.swing.JButton();
        btnObrisiMesto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMestoPrikaz = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblGreska.setForeground(new java.awt.Color(255, 0, 51));
        lblGreska.setText("jLabel1");

        btnIzadji.setText("Izadji");
        btnIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzadjiActionPerformed(evt);
            }
        });

        btnIzmeniMesto.setText("Izmeni");
        btnIzmeniMesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniMestoActionPerformed(evt);
            }
        });

        btnObrisiMesto.setText("Obrisi");
        btnObrisiMesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiMestoActionPerformed(evt);
            }
        });

        tblMestoPrikaz.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblMestoPrikaz);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGreska, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIzmeniMesto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrisiMesto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblGreska)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzadji)
                    .addComponent(btnIzmeniMesto)
                    .addComponent(btnObrisiMesto))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnObrisiMestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiMestoActionPerformed
        IzmeniMestoFormaKontroler.delete(tblMestoPrikaz, lblGreska, this);
    }//GEN-LAST:event_btnObrisiMestoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            pripremiFormu();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Konekcija sa serverom je prekinuta. Vaša sesija će biti zatvorena", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowActivated

    private void btnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzadjiActionPerformed
        dispose();
    }//GEN-LAST:event_btnIzadjiActionPerformed

    private void btnIzmeniMestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniMestoActionPerformed
        IzmeniMestoFormaKontroler.OpenUpdateWindow(tblMestoPrikaz, lblGreska);
    }//GEN-LAST:event_btnIzmeniMestoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            PrikaziMestoFormaKontroler.popuniTabelu(tblMestoPrikaz);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Konekcija sa serverom je prekinuta. Vaša sesija će biti zatvorena", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowGainedFocus


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzadji;
    private javax.swing.JButton btnIzmeniMesto;
    private javax.swing.JButton btnObrisiMesto;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGreska;
    private javax.swing.JTable tblMestoPrikaz;
    // End of variables declaration//GEN-END:variables

    private void pripremiFormu() throws Exception {
        IzmeniMestoFormaKontroler.popuniTabelu(tblMestoPrikaz);
        lblGreska.setText("");
    }
}