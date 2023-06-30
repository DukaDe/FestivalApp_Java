package festivalaplikacija.klijent.ki.forma.drzava.kontroler;

import festivalaplikacija.klijent.komunikacija.Klijent;
import festivalaplikacija.klijent.operacija.ZahtevKlijent;
import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.klijent.validacija.Validacija;
import festivalaplikacija.zajednicki.transfer.Odgovor;
import festivalaplikacija.zajednicki.transfer.Operacija;
import festivalaplikacija.zajednicki.transfer.Zahtev;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class DodajDrzavuFormaKontroler {

    private static Drzava drzava;

    public static void add(JLabel lblGreskaDodajDrzavu, JTextField txtNaziv, JTextField txtSkraceniNaziv, JDialog dodajDrzavuForma) throws Exception {
        lblGreskaDodajDrzavu.setText("");
        try {
            String naziv = txtNaziv.getText().trim();
            Validacija.getInstance().isString(naziv);

            String skraceniNaziv = txtSkraceniNaziv.getText().trim();
            Validacija.getInstance().isString(skraceniNaziv);

            Drzava drzavaAdd = new Drzava(naziv, skraceniNaziv);
            drzava = drzavaAdd;
            ZahtevKlijent.addDrzava(drzavaAdd);
                JOptionPane.showMessageDialog(dodajDrzavuForma, "Uspesno ste dodali drzavu u bazu", null, JOptionPane.INFORMATION_MESSAGE);
                int i = JOptionPane.showConfirmDialog(dodajDrzavuForma, "Želite li da dodate još jednu državu?", "Dodavanje države", JOptionPane.INFORMATION_MESSAGE);
                if (i == 1) {
                    dodajDrzavuForma.dispose();
                }
        } catch (Exception ex) {
            lblGreskaDodajDrzavu.setText(ex.getMessage());
            throw ex;
        }
    }

    public static Drzava getDrzava() {
        return drzava;
    }

}
