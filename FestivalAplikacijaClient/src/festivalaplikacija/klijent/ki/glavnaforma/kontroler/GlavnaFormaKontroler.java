package festivalaplikacija.klijent.ki.glavnaforma.kontroler;

import festivalaplikacija.zajednicki.domen.Uloga;
import festivalaplikacija.klijent.sesija.Sesija;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenu;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class GlavnaFormaKontroler {
      public static void pripremiFormu(JFrame GlavnaForma, JMenu menuIzvodjac, JMenu menuDrzava, JMenu menuMesto) {
        GlavnaForma.setTitle("Ulogovani ste kao: " + Sesija.getInstance().getKorisnickiNalog().getZaposleni().getIme() + " " + Sesija.getInstance().getKorisnickiNalog().getZaposleni().getPrezime());
        proveriUloge(menuIzvodjac, menuDrzava, menuMesto);
    }
    
    private static void proveriUloge(JMenu menuIzvodjac, JMenu menuDrzava, JMenu menuMesto) {
        List<Uloga> uloge = Sesija.getInstance().getKorisnickiNalog().getUloge();

        List<String> naziviUloga = new ArrayList<>();
        for (Uloga u : uloge) {
            naziviUloga.add(u.getNaziv());
        }
        if (naziviUloga.contains("programski_organizator") && naziviUloga.contains("administrator")) {
            menuIzvodjac.setEnabled(true);
            menuDrzava.setEnabled(true);
            menuMesto.setEnabled(true);
        }else if(naziviUloga.contains("programski_organizator")){
            menuIzvodjac.setEnabled(true);
            menuDrzava.setEnabled(true);
            menuMesto.setEnabled(true);
        }else if(naziviUloga.contains("administrator")){
            menuIzvodjac.setEnabled(false);
            menuDrzava.setEnabled(true);
            menuMesto.setEnabled(true);
        }else {
            menuIzvodjac.setEnabled(false);
            menuDrzava.setEnabled(false);
            menuMesto.setEnabled(false);
        }
    }
    
  
}
