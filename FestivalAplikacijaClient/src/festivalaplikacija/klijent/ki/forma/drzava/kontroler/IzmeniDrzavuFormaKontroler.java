package festivalaplikacija.klijent.ki.forma.drzava.kontroler;

import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.klijent.ki.forma.drzava.AzurirajDrzavuForma;
import festivalaplikacija.klijent.ki.komponenta.mojtabelamodel.DrzavaTabelaModel;
import festivalaplikacija.klijent.operacija.ZahtevKlijent;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class IzmeniDrzavuFormaKontroler {

    public static void delete(JTable tblDrzavaPrikaz, JLabel lblGreska, JDialog izmeniDrzavuForma) {
        int red = tblDrzavaPrikaz.getSelectedRow();
        lblGreska.setText("");
        if (red < 0) {
            lblGreska.setText("Niste selektovali nijedan red iz tabele!");
            return;
        }
        String stringId = tblDrzavaPrikaz.getValueAt(red, 0).toString();
        int id = Integer.parseInt(stringId);
        String naziv = (String) tblDrzavaPrikaz.getValueAt(red, 1);
        String skraceniNaziv = (String) tblDrzavaPrikaz.getValueAt(red, 2);
        Drzava drzava = new Drzava(id, naziv, skraceniNaziv);
        int i = JOptionPane.showConfirmDialog(izmeniDrzavuForma, "Da li ste sigurni da zelite da obrisete drzavu iz baze?", "brisanje podataka!", JOptionPane.WARNING_MESSAGE);
        if (i == 0) {
            try {
                ZahtevKlijent.deleteDrzava(drzava);
                JOptionPane.showMessageDialog(izmeniDrzavuForma, "Uspešno ste obrisali državu iz baze");
            } catch (Exception ex) {
                lblGreska.setText(ex.getMessage());
            }
        }
    }

    public static void OpenUpdateWindow(JTable tblDrzavaPrikaz, JLabel lblGreska) {
        int red = tblDrzavaPrikaz.getSelectedRow();
        lblGreska.setText("");
        if (red <= 0) {
            lblGreska.setText("Niste selektovali nijedan red iz tabele!");
            return;
        }
        Integer id = (Integer) tblDrzavaPrikaz.getValueAt(red, 0);
        String naziv = (String) tblDrzavaPrikaz.getValueAt(red, 1);
        String skraceniNaziv = (String) tblDrzavaPrikaz.getValueAt(red, 2);
        Drzava drzava = new Drzava(id, naziv, skraceniNaziv);
        new AzurirajDrzavuForma(null, true, drzava).setVisible(true);
    }

    public static void postaviModelTabele(JTable tblDrzavaPrikaz) throws Exception {
        try {
            List<Drzava> drzave = getAll();
            TableModel tabelaModel = new DrzavaTabelaModel(drzave);
            tblDrzavaPrikaz.setModel(tabelaModel);
            tblDrzavaPrikaz.setVisible(true);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    private static List<Drzava> getAll() throws Exception {
        try {
            return ZahtevKlijent.getAllDrzava();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
