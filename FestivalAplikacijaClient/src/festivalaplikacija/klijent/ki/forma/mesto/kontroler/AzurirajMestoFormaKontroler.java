package festivalaplikacija.klijent.ki.forma.mesto.kontroler;

import festivalaplikacija.klijent.operacija.ZahtevKlijent;
import festivalaplikacija.zajednicki.domen.Mesto;
import festivalaplikacija.klijent.validacija.Validacija;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class AzurirajMestoFormaKontroler {

    public static void update(JTextField txtNaziv, JTextField txtPtt, Mesto mesto, JDialog azurirajMestoForma,
            JLabel lblGreskaAzurirajMesto) {
        try {
            String naziv = txtNaziv.getText().trim();
            Validacija.getInstance().isString(naziv);

            String stringPtt = txtPtt.getText().trim();
            Validacija.getInstance().isNumber(stringPtt);
            int ptt = Integer.parseInt(stringPtt);
            int id = mesto.getId();
            Mesto novoMesto = new Mesto(id, ptt, naziv, mesto.getDrzava());
            int i = JOptionPane.showConfirmDialog(azurirajMestoForma, "Da li ste sigurni da zelite da izmenite podatke o mestu?", "Izmena podataka", JOptionPane.INFORMATION_MESSAGE);
            if (i == 0) {
                ZahtevKlijent.updateMesto(novoMesto);
                azurirajMestoForma.dispose();
            }
        } catch (Exception e) {
            lblGreskaAzurirajMesto.setText(e.getMessage());
        }
    }

}
