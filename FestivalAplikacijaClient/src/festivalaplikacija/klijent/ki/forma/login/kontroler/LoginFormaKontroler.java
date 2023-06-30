package festivalaplikacija.klijent.ki.forma.login.kontroler;

import festivalaplikacija.zajednicki.domen.KorisnickiNalog;
import festivalaplikacija.klijent.ki.glavnaforma.GlavnaForma;
import festivalaplikacija.klijent.komunikacija.Klijent;
import festivalaplikacija.klijent.sesija.Sesija;
import festivalaplikacija.klijent.validacija.Validacija;
import festivalaplikacija.zajednicki.transfer.Odgovor;
import festivalaplikacija.zajednicki.transfer.Operacija;
import festivalaplikacija.zajednicki.transfer.Zahtev;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class LoginFormaKontroler {

    public static void login(JTextField txtEmail, JPasswordField txtPassword, JDialog LoginForma, JLabel lblLoginGreska) {

        try {
            String email = txtEmail.getText();
            Validacija.getInstance().isEmail(email);

            String password = String.valueOf(txtPassword.getPassword());
            Validacija.getInstance().isEmpty(password);

            KorisnickiNalog korisnickiNalog = new KorisnickiNalog(email, password, null, null);
            Zahtev zahtev = new Zahtev(Operacija.LOGIN, korisnickiNalog);
            Klijent.getInstance().getOutput().writeObject(zahtev);
            Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
            if (odgovor.getException() == null) {
                KorisnickiNalog korisnickiNalogUlogovan = (KorisnickiNalog) odgovor.getRezultat();
                Sesija.getInstance().setKorisnickiNalog(korisnickiNalogUlogovan);
                otvoriGlavnuFormu();
                LoginForma.dispose();
            } else {
                throw new Exception(odgovor.getException().getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());;
            lblLoginGreska.setText(e.getMessage());
        }
    }

    private static void otvoriGlavnuFormu() {
        JFrame frame = new GlavnaForma();
        frame.setSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void pripremiFormu(JTextField txtEmail, JPasswordField txtPassword, JLabel lblLoginGreska) {
        txtEmail.setText("pera.peric@gmail.com");
        txtPassword.setText("4321");
        lblLoginGreska.setText("");
    }

    public static void logout() {
        try {
            Zahtev zahtev = new Zahtev(Operacija.END);
            Klijent.getInstance().getOutput().writeObject(zahtev);
            Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
            if (odgovor.getException() != null) {
                throw new Exception("Uspesno zatvorena aplikacija");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
