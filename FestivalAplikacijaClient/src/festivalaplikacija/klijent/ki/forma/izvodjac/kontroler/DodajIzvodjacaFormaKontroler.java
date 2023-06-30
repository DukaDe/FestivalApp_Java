package festivalaplikacija.klijent.ki.forma.izvodjac.kontroler;

import festivalaplikacija.zajednicki.domen.Izvodjac;
import festivalaplikacija.zajednicki.domen.Mesto;
import festivalaplikacija.klijent.ki.forma.mesto.DodajMestoForma;
import festivalaplikacija.klijent.operacija.ZahtevKlijent;
import festivalaplikacija.klijent.validacija.Validacija;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class DodajIzvodjacaFormaKontroler {

    private static Izvodjac izvodjac;

    public static void add(JLabel lblUnosIzvodjacGreska, JTextField txtUnosIzvodjacNaziv, JTextField txtUnosIzvodjacKontaktOsoba,
            JTextField txtUnosIzvodjacEmail, JTextField txtUnosIzvodjacTelefon, JComboBox comboBoxUnosIzvodjacMesto, JDialog dodajIzvodjacaForma) {

        lblUnosIzvodjacGreska.setText("");

        try {
            String naziv = txtUnosIzvodjacNaziv.getText().trim();
            Validacija.getInstance().isEmpty(naziv);

            String kontaktOsoba = txtUnosIzvodjacKontaktOsoba.getText().trim();
            Validacija.getInstance().isString(kontaktOsoba);

            String email = txtUnosIzvodjacEmail.getText().trim();
            Validacija.getInstance().isEmail(email);

            String telefon = txtUnosIzvodjacTelefon.getText().trim();
            Validacija.getInstance().isNumber(telefon);

            Mesto mesto = (Mesto) comboBoxUnosIzvodjacMesto.getSelectedItem();
            Izvodjac izvodjacDodaj = new Izvodjac(naziv, kontaktOsoba, email, telefon, mesto);

            ZahtevKlijent.addIzvodjac(izvodjacDodaj);
                prepareForm(lblUnosIzvodjacGreska, txtUnosIzvodjacNaziv, txtUnosIzvodjacKontaktOsoba, txtUnosIzvodjacEmail, txtUnosIzvodjacTelefon, comboBoxUnosIzvodjacMesto);
                JOptionPane.showMessageDialog(dodajIzvodjacaForma, "Uspesno ste dodali izvodjaca u bazu", null, JOptionPane.INFORMATION_MESSAGE);
                dodajIzvodjacaForma.dispose();

        } catch (Exception ex) {
            lblUnosIzvodjacGreska.setText(ex.getMessage());
        }
    }

    public static void dodajMesto(JTextField txtUnosIzvodjacNaziv, JTextField txtUnosIzvodjacKontaktOsoba, JTextField txtUnosIzvodjacTelefon,
            JTextField txtUnosIzvodjacEmail) throws Exception {
        String naziv = txtUnosIzvodjacNaziv.getText().trim();
        String kontaktOsoba = txtUnosIzvodjacKontaktOsoba.getText().trim();
        String telefon = txtUnosIzvodjacTelefon.getText().trim();
        String email = txtUnosIzvodjacEmail.getText().trim();
        izvodjac = new Izvodjac(naziv, kontaktOsoba, email, telefon, null);

        DodajMestoForma dodajMestoForma = new DodajMestoForma(null, true);
        dodajMestoForma.setVisible(true);
    }

    public static void formWindowGainedFocus(JTextField txtUnosIzvodjacNaziv, JTextField txtUnosIzvodjacKontaktOsoba,
            JTextField txtUnosIzvodjacEmail, JTextField txtUnosIzvodjacTelefon) {
        try {
            if (izvodjac.getEmail() != null) {
                txtUnosIzvodjacEmail.setText(izvodjac.getEmail());
            } else {
                txtUnosIzvodjacEmail.setText("");
            }
            if (izvodjac.getNaziv() != null) {
                txtUnosIzvodjacNaziv.setText(izvodjac.getNaziv());
            } else {
                txtUnosIzvodjacNaziv.setText("");
            }
            if (izvodjac.getKontaktOsoba() != null) {
                txtUnosIzvodjacKontaktOsoba.setText(izvodjac.getKontaktOsoba());
            } else {
                txtUnosIzvodjacKontaktOsoba.setText("");
            }
            if (izvodjac.getKontaktelefon() != null) {
                txtUnosIzvodjacTelefon.setText(izvodjac.getKontaktelefon());
            } else {
                txtUnosIzvodjacTelefon.setText("");
            }
        } catch (Exception e) {
            System.out.println("U ovom slučaju su prazni unosi ok");
        }
    }

    public static void prepareForm(JLabel lblUnosIzvodjacGreska, JTextField txtUnosIzvodjacNaziv, JTextField txtUnosIzvodjacKontaktOsoba,
            JTextField txtUnosIzvodjacEmail, JTextField txtUnosIzvodjacTelefon, JComboBox comboBoxUnosIzvodjacMesto) {
        lblUnosIzvodjacGreska.setText("");
        txtUnosIzvodjacNaziv.setText("");
        txtUnosIzvodjacEmail.setText("");
        txtUnosIzvodjacKontaktOsoba.setText("");
        txtUnosIzvodjacTelefon.setText("");
    }

    public static void fillComboBox(JComboBox comboBoxUnosIzvodjacMesto, JLabel lblUnosIzvodjacGreska) throws Exception {
        try {
            comboBoxUnosIzvodjacMesto.removeAllItems();
            List<Mesto> mesta = getAllMesta();
            List<Integer> kljucevi = new ArrayList<>();
            for (Mesto m : mesta) {
                comboBoxUnosIzvodjacMesto.addItem(m);
                kljucevi.add(m.getId());
            }

            int size = kljucevi.size();
            int index = size - 1;

            comboBoxUnosIzvodjacMesto.setSelectedIndex(index);
        } catch (Exception e) {
            lblUnosIzvodjacGreska.setText("Doslo je do greske prilikom popunjavanja ComboBoxa!");
            throw e;
        }
    }

    public static void formWindowLostFocus(JTextField txtUnosIzvodjacNaziv, JTextField txtUnosIzvodjacKontaktOsoba, JTextField txtUnosIzvodjacTelefon, JTextField txtUnosIzvodjacEmail) {
        String naziv = txtUnosIzvodjacNaziv.getText().trim();
        String kontaktOsoba = txtUnosIzvodjacKontaktOsoba.getText().trim();
        String telefon = txtUnosIzvodjacTelefon.getText().trim();
        String email = txtUnosIzvodjacEmail.getText().trim();
        izvodjac = new Izvodjac(naziv, kontaktOsoba, email, telefon, null);
    }

    private static List<Mesto> getAllMesta() throws Exception {
            return ZahtevKlijent.getAllMesto();
    }
}
