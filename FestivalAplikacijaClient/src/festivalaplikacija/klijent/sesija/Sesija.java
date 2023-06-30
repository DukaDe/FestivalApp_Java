package festivalaplikacija.klijent.sesija;

import festivalaplikacija.zajednicki.domen.KorisnickiNalog;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Sesija {

    private static Sesija instance;
    private KorisnickiNalog korisnickiNalog;

    private Sesija() {
        System.out.println("Kreiran objekat klase Sesija.");
    }

    public KorisnickiNalog getKorisnickiNalog() {
        return korisnickiNalog;
    }

    public void setKorisnickiNalog(KorisnickiNalog korisnickiNalog) {
        this.korisnickiNalog = korisnickiNalog;
    }

    public static Sesija getInstance() {
        if (instance == null) {
            instance = new Sesija();
        }
        return instance;
    }
}
