package festivalaplikacija.server.servis.impl;

import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.server.repozitorijum.impl.DrzavaRepozitorijumImpl;
import festivalaplikacija.server.servis.DrzavaServis;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class DrzavaServisImpl implements DrzavaServis {

    private final DrzavaRepozitorijumImpl drzavaRepozitorijum;
    //private static int generatedKey;

    public DrzavaServisImpl() {
        drzavaRepozitorijum = new DrzavaRepozitorijumImpl();
    }

    @Override
    public void add(Drzava drzava) throws Exception {
        if (drzavaRepozitorijum.getAll().contains(drzava)) {
            throw new Exception("Drzava sa tim imenom vec postoji u bazi!");
        } else {
            drzavaRepozitorijum.add(drzava);
        }
    }

    @Override
    public List<Drzava> getAll() throws Exception {
        return drzavaRepozitorijum.getAll();
    }

    @Override
    public void delete(Drzava drzava) throws Exception {
        try {
            drzavaRepozitorijum.delete(drzava);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Nemoguce je izbrisati drzavu iz baze, jer postoje drugi entiteti koji su vezani za ovu drzavu!");
        }

    }

    @Override
    public void update(Drzava drzava) throws Exception {
        try {
            drzavaRepozitorijum.update(drzava);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

 

    @Override
    public Drzava getById(int id) throws Exception {
        return drzavaRepozitorijum.getById(id);
    }

    @Override
    public List<Drzava> findByQuery(String query) throws Exception {
        List<Drzava> drzave = drzavaRepozitorijum.findByQuery(query);
        if (drzave != null) {
            return drzave;
        } else {
            throw new Exception("Upitom nije selektovan nijedan red iz baze!");
        }
    }

}
