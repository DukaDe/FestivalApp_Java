package festivalaplikacija.klijent;

import festivalaplikacija.klijent.ki.forma.login.LoginForma;
import javax.swing.JDialog;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Start {
    public static void main(String[] args) {
        JDialog login = new LoginForma(null, true);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}
