package festivalaplikacija.klijent.ki.forma.mesto.kontroler;

import festivalaplikacija.klijent.ki.forma.mesto.AzurirajMestoForma;
import festivalaplikacija.klijent.ki.komponenta.mojtabelamodel.MestoTabelaModel;
import festivalaplikacija.klijent.operacija.ZahtevKlijent;
import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.zajednicki.domen.Mesto;
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
public class IzmeniMestoFormaKontroler {

    public static void delete(JTable tblMestoPrikaz, JLabel lblGreska, JDialog izmeniMestoForma) {
        try {
            int red = tblMestoPrikaz.getSelectedRow();
            lblGreska.setText("");
            if (red < 0) {
                lblGreska.setText("Niste selektovali nijedan red iz tabele!");
                return;
            }
            String stringId = tblMestoPrikaz.getValueAt(red, 0).toString().trim();
            int id = Integer.parseInt(stringId);
            System.out.println(id);
            String stringPtt = tblMestoPrikaz.getValueAt(red, 1).toString().trim();
            int ptt = Integer.parseInt(stringPtt);
            System.out.println(ptt);
            String naziv = tblMestoPrikaz.getValueAt(red, 2).toString().trim();
            System.out.println(naziv);
            String drzavaNaziv = tblMestoPrikaz.getValueAt(red, 3).toString().trim();
            Drzava drzava = new Drzava(drzavaNaziv, null);
            List<Drzava> drzave = ZahtevKlijent.findByNameDrzava(drzava);
            Drzava drzavaNova = drzave.get(0);
            Mesto mesto = new Mesto(id, ptt, naziv, drzavaNova);
            int i = JOptionPane.showConfirmDialog(izmeniMestoForma, "Da li ste sigurni da zelite da obrisete mesto iz baze?", "brisanje podataka!", JOptionPane.WARNING_MESSAGE);
            if (i == 0) {
                try {
                    ZahtevKlijent.deleteMesto(mesto);
                    JOptionPane.showMessageDialog(izmeniMestoForma, "Uspesno ste obrisali mesto iz baze", "", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(izmeniMestoForma, ex.getMessage(), "", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            lblGreska.setText(ex.getMessage());
        }
    }

    public static void OpenUpdateWindow(JTable tblMestoPrikaz, JLabel lblGreska) {
        int red = tblMestoPrikaz.getSelectedRow();
        lblGreska.setText("");
        if (red <= 0) {
            lblGreska.setText("Niste selektovali nijedan red iz tabele!");
            return;
        }
        try {
            Integer id = (Integer) tblMestoPrikaz.getValueAt(red, 0);
            Integer ptt = (Integer) tblMestoPrikaz.getValueAt(red, 1);
            String naziv = (String) tblMestoPrikaz.getValueAt(red, 2);
            String drzavaNaziv = (String) tblMestoPrikaz.getValueAt(red, 3);
            Drzava drzava = new Drzava(drzavaNaziv, null);
            List <Drzava> drzave = ZahtevKlijent.findByNameDrzava(drzava);
            Drzava drzavaNova = drzave.get(0);
            Mesto mesto = new Mesto(id, ptt, naziv, drzavaNova);
            new AzurirajMestoForma(null, true, mesto).setVisible(true);

        } catch (Exception ex) {
            ex.printStackTrace();
            lblGreska.setText(ex.getMessage());
        }

    }

    public static void popuniTabelu(JTable tblMestoPrikaz) throws Exception {
        try {
            List<Mesto> mesta = ZahtevKlijent.getAllMesto();
            TableModel mestoTabelaModel = new MestoTabelaModel(mesta);
            tblMestoPrikaz.setModel(mestoTabelaModel);
            tblMestoPrikaz.setVisible(true);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

}
