package festivalaplikacija.klijent.ki.forma.izvodjac.kontroler;

import festivalaplikacija.zajednicki.domen.Izvodjac;
import festivalaplikacija.klijent.ki.komponenta.mojtabelamodel.IzvodjacTabelaModel;
import festivalaplikacija.klijent.komunikacija.Klijent;
import festivalaplikacija.klijent.operacija.ZahtevKlijent;
import festivalaplikacija.zajednicki.transfer.Odgovor;
import festivalaplikacija.zajednicki.transfer.Operacija;
import festivalaplikacija.zajednicki.transfer.Zahtev;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableModel;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class PrikaziIzvodjacaFormaKontroler {

    public static void prikaziSvePodatke(JTable tblPrikaziIzvodjaca, JLabel lblPrikaziIzvodjaceGreska,
            JTextArea TextAreaPrikaziSvePodatke) {
        try {
            int red = tblPrikaziIzvodjaca.getSelectedRow();
            lblPrikaziIzvodjaceGreska.setText("");
            if (red < 0) {
                lblPrikaziIzvodjaceGreska.setText("Niste selektovali nijedan red iz tabele!");
                return;
            }
            String izvodjacNaziv = (String) tblPrikaziIzvodjaca.getValueAt(red, 0);

            String upit = "SELECT * FROM izvodjac WHERE naziv_izvodjaca = " + "'" + izvodjacNaziv + "'";
                List<Izvodjac> izvodjaci = ZahtevKlijent.findByQueryIzvodjac(upit);
                Izvodjac izvodjac = izvodjaci.get(0);
                TextAreaPrikaziSvePodatke.setText("Izvodjac: " + izvodjac.getNaziv() + "\n" + "Grad: " + izvodjac.getMesto().getPtt() + " " + izvodjac.getMesto().getNaziv() + "\n"
                        + "Drzava: " + izvodjac.getMesto().getDrzava().getNaziv() + " (" + izvodjac.getMesto().getDrzava().getSkraceniNaziv() + ")"
                        + "\n" + "Kontakt osoba: " + izvodjac.getKontaktOsoba() + "\n" + "Telefon: " + izvodjac.getKontaktelefon() + "\n" + "email: " + izvodjac.getEmail());

        } catch (Exception e) {
            lblPrikaziIzvodjaceGreska.setText(e.getMessage());
        }
    }

    public static void pripremiFormu(JTable tblPrikaziIzvodjaca, JLabel lblPrikaziIzvodjaceGreska,
            JDialog PrikaziIzvodjacaForma) throws Exception {
        try {
            popuniTabelu(tblPrikaziIzvodjaca, lblPrikaziIzvodjaceGreska);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(PrikaziIzvodjacaForma, ex.getMessage(), "Doslo je do greske prilikom pravljenja tabele izvodjaca!", JOptionPane.INFORMATION_MESSAGE);
            throw ex;
        }
    }

    private static void popuniTabelu(JTable tblPrikaziIzvodjaca, JLabel lblPrikaziIzvodjaceGreska) throws Exception {
        try {
                List<Izvodjac> izvodjaci = ZahtevKlijent.getAllIzvodjac();
                TableModel model = new IzvodjacTabelaModel(izvodjaci, 3);
                tblPrikaziIzvodjaca.setModel(model);
                lblPrikaziIzvodjaceGreska.setText("");
        } catch (Exception e) {
            e.printStackTrace();
            lblPrikaziIzvodjaceGreska.setText(e.getMessage());
        }

    }
}
