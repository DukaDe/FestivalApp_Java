package festivalaplikacija.klijent.ki.forma.drzava.kontroler;

import festivalaplikacija.klijent.operacija.ZahtevKlijent;
import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.klijent.validacija.Validacija;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class AzurirajDrzavuFormaKontroler {

    public static void update(JTextField txtNaziv, JTextField txtSkraceniNaziv, JDialog izmeniDrzavuForma, Drzava drzava, JLabel lblGreskaAzurirajDrzavu) {
        try {
            String naziv = txtNaziv.getText().trim();
            Validacija.getInstance().isString(naziv);

            String skraceniNaziv = txtSkraceniNaziv.getText().trim();
            Validacija.getInstance().isString(skraceniNaziv);

            int id = drzava.getId();

            Drzava novaDrzava = new Drzava(id, naziv, skraceniNaziv);
            int i = JOptionPane.showConfirmDialog(izmeniDrzavuForma, "Da li ste sigurni da zelite da izmenite podatke o drzavi?", "Izmena podataka", JOptionPane.INFORMATION_MESSAGE);
            if (i == 0) {
                ZahtevKlijent.updateDrzava(novaDrzava);
                izmeniDrzavuForma.dispose();
            }
        } catch (Exception ex) {
            lblGreskaAzurirajDrzavu.setText(ex.getMessage());
        }
    }
}
