package festivalaplikacija.klijent.ki.forma.mesto.kontroler;

import festivalaplikacija.klijent.ki.forma.drzava.kontroler.DodajDrzavuFormaKontroler;
import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.zajednicki.domen.Mesto;
import festivalaplikacija.klijent.ki.forma.mesto.DodajMestoForma;
import festivalaplikacija.klijent.komunikacija.Klijent;
import festivalaplikacija.klijent.operacija.ZahtevKlijent;
import festivalaplikacija.klijent.validacija.Validacija;
import festivalaplikacija.zajednicki.transfer.Odgovor;
import festivalaplikacija.zajednicki.transfer.Operacija;
import festivalaplikacija.zajednicki.transfer.Zahtev;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class DodajMestoFormaKontroler {

    private static Mesto mesto;

    public static void add(JLabel lblGreskaDodajMeto, JTextField txtUnosMestoNaziv, JTextField txtUnosMestoPTT,
            JComboBox ComboBoxUnosMestoDrzava, DodajMestoForma dodajMestoForma) {

        lblGreskaDodajMeto.setText("");

        try {
            String naziv = txtUnosMestoNaziv.getText().trim();
            Validacija.getInstance().isString(naziv);

            String pttString = txtUnosMestoPTT.getText().trim();
            Validacija.getInstance().isNumber(pttString);

            int ptt = Integer.parseInt(pttString);

            Drzava drzava = (Drzava) ComboBoxUnosMestoDrzava.getSelectedItem();
            Mesto mestoDodaj = new Mesto(ptt, naziv, drzava);

            ZahtevKlijent.addMesto(mestoDodaj);
            JOptionPane.showMessageDialog(dodajMestoForma, "Uspesno ste dodali mesto u bazu", null, JOptionPane.INFORMATION_MESSAGE);
            int i = JOptionPane.showConfirmDialog(dodajMestoForma, "Želite li da dodate još jedno mesto u bazu?");
            if (i == 1) {
                dodajMestoForma.dispose();
            } else {
                txtUnosMestoNaziv.setText("");
                txtUnosMestoPTT.setText("");
                lblGreskaDodajMeto.setText("");
            }
        } catch (NumberFormatException nfe) {
            nfe.getMessage();
            lblGreskaDodajMeto.setText("U polje PTT morate uneti broj! ");
        } catch (Exception e) {
            lblGreskaDodajMeto.setText(e.getMessage());
        }
    }

    public static void fillComboBox(JComboBox comboBoxUnosMestoDrzava, JLabel lblGreskaDodajMesto) throws Exception {
        try {
            comboBoxUnosMestoDrzava.removeAllItems();
            List<Drzava> drzave = ZahtevKlijent.getAllDrzava();
            for (Drzava d : drzave) {
                comboBoxUnosMestoDrzava.addItem(d);
            }
            if (DodajDrzavuFormaKontroler.getDrzava() == null) {
                comboBoxUnosMestoDrzava.setSelectedIndex(0);
            } else {
                comboBoxUnosMestoDrzava.setSelectedItem(DodajDrzavuFormaKontroler.getDrzava());

            }

        } catch (Exception e) {
            e.printStackTrace();
            lblGreskaDodajMesto.setText("Doslo je do greske prilikom popunjavanja ComboBoxa!");
            throw e;
        }
    }

    public static void cuvajPrivremenePodatkeIzForme(JTextField txtUnosMestoNaziv, JTextField txtUnosMestoPTT) {
        String naziv = txtUnosMestoNaziv.getText().trim();
        String pttString = txtUnosMestoPTT.getText().trim();
        if (pttString.isEmpty()) {
            mesto = new Mesto(0, naziv, null);
        } else {
            int ptt = Integer.parseInt(pttString);
            mesto = new Mesto(ptt, naziv, null);
        }

    }

    public static void formWindowGainedFocus(JTextField txtUnosMestoNaziv, JTextField txtUnosMestoPTT) {
        try {
            if (mesto.getNaziv() != null) {
                txtUnosMestoNaziv.setText(mesto.getNaziv());
            } else {
                txtUnosMestoNaziv.setText("");
            }
            if (mesto.getPtt() != 0) {
                txtUnosMestoPTT.setText(String.valueOf(mesto.getPtt()));
            } else {
                txtUnosMestoPTT.setText("");
            }

        } catch (Exception e) {
            System.out.println("U ovom slučaju su prazni unosi ok");
        }
    }

}
