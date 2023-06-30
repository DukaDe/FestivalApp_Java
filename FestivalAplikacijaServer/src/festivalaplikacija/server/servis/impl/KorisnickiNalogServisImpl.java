package festivalaplikacija.server.servis.impl;

import festivalaplikacija.zajednicki.domen.KorisnickiNalog;
import festivalaplikacija.zajednicki.domen.Zaposleni;
import festivalaplikacija.server.repozitorijum.impl.KorisnickiNalogRepozitorijumImpl;
import festivalaplikacija.server.servis.KorisnickiNalogServis;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class KorisnickiNalogServisImpl implements KorisnickiNalogServis {

    private final KorisnickiNalogRepozitorijumImpl korisnickiNalogRepozitorijumImpl;
    private final ZaposleniServisImpl zaposleniServisImpl;

    public KorisnickiNalogServisImpl() {
        korisnickiNalogRepozitorijumImpl = new KorisnickiNalogRepozitorijumImpl();
        zaposleniServisImpl = new ZaposleniServisImpl();
    }


    @Override
    public KorisnickiNalog login(KorisnickiNalog korisnickiNalog) throws Exception {
        try {
            String upit = "SELECT * FROM korisnicki_nalog WHERE email = '" + korisnickiNalog.getEmail() + "' AND password = '" + korisnickiNalog.getPassword() + "'";
            List<KorisnickiNalog> korisnici = korisnickiNalogRepozitorijumImpl.findByQuery(upit);
            if (korisnici.isEmpty()) {
                throw new Exception("Ne postoji korisnik sa tim e-mailom i tom lozinkom u bazi");
            }
            KorisnickiNalog korisnickiNalogUlogovan = korisnici.get(0);
            Zaposleni zaposleni = zaposleniServisImpl.getById(korisnickiNalogUlogovan.getZaposleni().getId());
            if (zaposleni == null) {
                throw new Exception("Korisnicki nalog ne mogu da povezem sa zaposlenim!!!");
            }
            korisnickiNalogUlogovan.setZaposleni(zaposleni);
            korisnickiNalogUlogovan.setUloge(korisnickiNalogRepozitorijumImpl.getById(korisnickiNalog.getEmail()).getUloge());
            return korisnickiNalogUlogovan;
        } catch (Exception e) {
            System.out.println("aa; " + e.getMessage());;
            throw new Exception(e.getMessage());
        }
    }

}
