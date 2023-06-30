package festivalaplikacija.klijent.ki.forma.izvodjac.kontroler;

import festivalaplikacija.zajednicki.domen.Izvodjac;
import festivalaplikacija.zajednicki.domen.Mesto;
import festivalaplikacija.klijent.ki.komponenta.mojtabelamodel.IzvodjacTabelaModel;
import festivalaplikacija.klijent.komunikacija.Klijent;
import festivalaplikacija.klijent.operacija.ZahtevKlijent;
import festivalaplikacija.klijent.validacija.Validacija;
import festivalaplikacija.zajednicki.transfer.Odgovor;
import festivalaplikacija.zajednicki.transfer.Operacija;
import festivalaplikacija.zajednicki.transfer.Zahtev;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class IzmeniIzvodjacaFormaKontroler {

    private static Long id;

    public static void delete(JTable tblIzmeniIzvodjaca, JDialog izmeniIzvodjacaForma) {
        try {
            int[] brojRedova = tblIzmeniIzvodjaca.getSelectedRows();

            if (brojRedova.length <= 0) {
                throw new Exception("Morate selektovati redove iz tabele koje zelite da obrisete");
            }
            int j = JOptionPane.showConfirmDialog(izmeniIzvodjacaForma, "Da li ste sigurni da zelite da obrisete podatke o izvodjacu?", "brisanje podataka", JOptionPane.WARNING_MESSAGE);
            if (j == 0) {
                for (int i = 0; i < brojRedova.length; i++) {
                    String nazivIzvodjaca = (String) tblIzmeniIzvodjaca.getValueAt(brojRedova[i], 0);
                    String upit = "SELECT * FROM izvodjac WHERE naziv_izvodjaca = " + "'" + nazivIzvodjaca + "'";
                    List<Izvodjac> izvodjaciZaBrisanje = ZahtevKlijent.findByQueryIzvodjac(upit);
                    Izvodjac izvodjac = izvodjaciZaBrisanje.get(0);
                    ZahtevKlijent.deleteIzvodjac(izvodjac);
                }
                JOptionPane.showMessageDialog(izmeniIzvodjacaForma, "Uspesno ste obrisali izvodjace iz tabele");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(izmeniIzvodjacaForma, e.getMessage());
        }

    }

    public static void edit(JTable tblIzmeniIzvodjaca, JTextField txtAzurirajIzvodjacaNaziv, JTextField txtAzurirajIzvodjacaKontaktOsoba,
            JTextField txtAzurirajIzvodjacaEmail, JTextField txtAzurirajIzvodjacaBrojTelefona, JButton btnIzmeni, JButton btnObrisi, JButton btnAzuriraj,
            JButton btnOdustani, JDialog izmeniIzvodjacaForma, JPanel pnlAzurirajIzvodjaca, JComboBox comboBoxAzurirajIzvodjacaMesta) {
        try {
            if (tblIzmeniIzvodjaca.getSelectedRow() >= 0) {
                preparePanel(pnlAzurirajIzvodjaca, txtAzurirajIzvodjacaNaziv, txtAzurirajIzvodjacaKontaktOsoba, txtAzurirajIzvodjacaEmail,
                        txtAzurirajIzvodjacaBrojTelefona, comboBoxAzurirajIzvodjacaMesta, btnObrisi, btnOdustani, true);
                fillPanel(tblIzmeniIzvodjaca, txtAzurirajIzvodjacaNaziv, txtAzurirajIzvodjacaKontaktOsoba, txtAzurirajIzvodjacaEmail,
                        txtAzurirajIzvodjacaBrojTelefona, comboBoxAzurirajIzvodjacaMesta);
            } else {
                throw new Exception("Niste selektovali nijedan red!");
            }

            String naziv = txtAzurirajIzvodjacaNaziv.getText().trim();
            String izvodjacUpit = "SELECT * FROM izvodjac WHERE naziv_izvodjaca = '" + naziv + "'";
            List<Izvodjac> izvodjaciZaIzmenu = ZahtevKlijent.findByQueryIzvodjac(izvodjacUpit);
            if (izvodjaciZaIzmenu != null && !(izvodjaciZaIzmenu.isEmpty())) {
                id = izvodjaciZaIzmenu.get(0).getId();
                btnIzmeni.setEnabled(false);
                btnObrisi.setEnabled(false);
                btnAzuriraj.setEnabled(true);
            } else {
                throw new Exception("Niste selektovali nijedan red!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(izmeniIzvodjacaForma, ex.getMessage());
        }
    }

    public static void update(JTextField txtAzurirajIzvodjacaNaziv, JTextField txtAzurirajIzvodjacaKontaktOsoba, JTextField txtAzurirajIzvodjacaEmail,
            JTextField txtAzurirajIzvodjacaBrojTelefona, JComboBox comboBoxAzurirajIzvodjacaMesta, JDialog izmeniIzvodjacaForma,
            JButton btnObrisi, JButton btnIzmeni, JButton btnAzuriraj, JButton btnOdustani, JTable tblIzmeniIzvodjaca,
            boolean enable, JPanel pnlAzurirajIzvodjaca) {
        try {

            String noviNaziv = txtAzurirajIzvodjacaNaziv.getText().trim();
            Validacija.getInstance().isEmpty(noviNaziv);

            String novaKontaktOsoba = txtAzurirajIzvodjacaKontaktOsoba.getText().trim();
            Validacija.getInstance().isString(novaKontaktOsoba);

            String noviEmail = txtAzurirajIzvodjacaEmail.getText().trim();
            Validacija.getInstance().isEmail(noviEmail);

            String noviTelefon = txtAzurirajIzvodjacaBrojTelefona.getText().trim();
            Validacija.getInstance().isNumber(noviTelefon);

            Mesto novoMesto = (Mesto) comboBoxAzurirajIzvodjacaMesta.getSelectedItem();
            Izvodjac noviIzvodjac = new Izvodjac(id, noviNaziv, novaKontaktOsoba, noviEmail, noviTelefon, novoMesto);

            int i = JOptionPane.showConfirmDialog(izmeniIzvodjacaForma, "Da li ste sigurni da zelite da izmenite podatke o izvodjacu?", "Izmena podataka", JOptionPane.INFORMATION_MESSAGE);
            if (i == 0) {
                ZahtevKlijent.updateIzvodjac(noviIzvodjac);
                    fillTable(tblIzmeniIzvodjaca);
                    preparePanel(pnlAzurirajIzvodjaca, txtAzurirajIzvodjacaNaziv, txtAzurirajIzvodjacaKontaktOsoba, txtAzurirajIzvodjacaEmail, txtAzurirajIzvodjacaBrojTelefona, comboBoxAzurirajIzvodjacaMesta, btnObrisi, btnOdustani, false);
                    btnIzmeni.setEnabled(true);
                    btnObrisi.setEnabled(true);
                    btnAzuriraj.setEnabled(false);
                    btnOdustani.setEnabled(false);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(izmeniIzvodjacaForma, e.getMessage());
        }
    }

    public static void fillTable(JTable tblIzmeniIzvodjaca) throws Exception {
        try {
            List<Izvodjac> izvodjaci = ZahtevKlijent.getAllIzvodjac();
            AbstractTableModel model = new IzvodjacTabelaModel(izvodjaci, 6);
            tblIzmeniIzvodjaca.setModel(model);
            tblIzmeniIzvodjaca.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public static void preparePanel(JPanel pnlAzurirajIzvodjaca, JTextField txtAzurirajIzvodjacaNaziv, JTextField txtAzurirajIzvodjacaKontaktOsoba, JTextField txtAzurirajIzvodjacaEmail,
            JTextField txtAzurirajIzvodjacaBrojTelefona, JComboBox comboBoxAzurirajIzvodjacaMesta, JButton btnAzuriraj, JButton btnOdustani, boolean enable) {
        pnlAzurirajIzvodjaca.setEnabled(enable);
        txtAzurirajIzvodjacaBrojTelefona.setEnabled(enable);
        txtAzurirajIzvodjacaEmail.setEnabled(enable);
        txtAzurirajIzvodjacaKontaktOsoba.setEnabled(enable);
        txtAzurirajIzvodjacaNaziv.setEnabled(enable);
        comboBoxAzurirajIzvodjacaMesta.setEnabled(enable);
        btnAzuriraj.setEnabled(enable);
        btnOdustani.setEnabled(enable);

        txtAzurirajIzvodjacaNaziv.setText("");
        txtAzurirajIzvodjacaKontaktOsoba.setText("");
        txtAzurirajIzvodjacaBrojTelefona.setText("");
        txtAzurirajIzvodjacaEmail.setText("");
    }

    public static void fillComboBox(JComboBox comboBoxAzurirajIzvodjacaMesta) {
        try {
            comboBoxAzurirajIzvodjacaMesta.removeAllItems();
            List<Mesto> mesta = ZahtevKlijent.getAllMesto();
            List<Integer> kljucevi = new ArrayList<>();
            for (Mesto m : mesta) {
                comboBoxAzurirajIzvodjacaMesta.addItem(m);
                kljucevi.add(m.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Doslo je do greske prilikom popunjavanja ComboBox-a: " + e.getMessage());
        }
    }

    public static void fillPanel(JTable tblIzmeniIzvodjaca, JTextField txtAzurirajIzvodjacaNaziv, JTextField txtAzurirajIzvodjacaKontaktOsoba, JTextField txtAzurirajIzvodjacaEmail,
            JTextField txtAzurirajIzvodjacaBrojTelefona, JComboBox comboBoxAzurirajIzvodjacaMesta) {
        try {
            int red = tblIzmeniIzvodjaca.getSelectedRow();
            if (red <= 0) {
                try {
                    throw new Exception("nije selektovan nijedan red iz tabele");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            String naziv = (String) tblIzmeniIzvodjaca.getValueAt(red, 0);
            String mesto = (String) tblIzmeniIzvodjaca.getValueAt(red, 1);
            String drzava = (String) tblIzmeniIzvodjaca.getValueAt(red, 2);
            String kontaktOsoba = (String) tblIzmeniIzvodjaca.getValueAt(red, 3);
            String telefon = (String) tblIzmeniIzvodjaca.getValueAt(red, 4);
            String email = (String) tblIzmeniIzvodjaca.getValueAt(red, 5);

            txtAzurirajIzvodjacaNaziv.setText(naziv);
            txtAzurirajIzvodjacaKontaktOsoba.setText(kontaktOsoba);
            txtAzurirajIzvodjacaBrojTelefona.setText(telefon);
            txtAzurirajIzvodjacaEmail.setText(email);

            String upit = "SELECT * FROM mesto WHERE naziv_mesta = '" + mesto + "'";

            Mesto m = ZahtevKlijent.findByQueryMesto(upit).get(0);

            comboBoxAzurirajIzvodjacaMesta.setSelectedItem(m);
        } catch (Exception ex) {

        }
    }

}
