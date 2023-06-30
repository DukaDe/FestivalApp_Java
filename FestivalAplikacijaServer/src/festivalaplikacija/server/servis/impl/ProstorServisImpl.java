package festivalaplikacija.server.servis.impl;

import festivalaplikacija.server.repozitorijum.impl.ProstorRepozitorijumImpl;
import festivalaplikacija.server.servis.ProstorServis;
import festivalaplikacija.zajednicki.domen.Prostor;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class ProstorServisImpl implements ProstorServis{
    ProstorRepozitorijumImpl prostorRepozitorijumImpl;

    public ProstorServisImpl() {
        prostorRepozitorijumImpl = new ProstorRepozitorijumImpl();
    }
    
    
    @Override
    public Prostor getById(int id) throws Exception {
        return prostorRepozitorijumImpl.getById(id);
    }

    @Override
    public List<Prostor> getAll() throws Exception {
        return prostorRepozitorijumImpl.getAll();
    }

    @Override
    public List<Prostor> findByQuery(String query) throws Exception {
        List<Prostor> prostori = prostorRepozitorijumImpl.findByQuery(query);
        if (prostori != null) {
            return prostori;
        } else {
            throw new Exception("Upitom nije selektovan nijedan red iz baze!");
        }
    }

    @Override
    public void add(Prostor prostor) throws Exception {
        List<Prostor> prostori = prostorRepozitorijumImpl.getAll();
        if (prostori.contains(prostor)){
            throw new Exception ("Prostor sa ovim nazivom već postoji u bazi!");
        } else{
            prostorRepozitorijumImpl.add(prostor);
        }
    }

    @Override
    public void update(Prostor prostor) throws Exception {
        try {
             prostorRepozitorijumImpl.update(prostor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Prostor prostor) throws Exception {
        try {
            prostorRepozitorijumImpl.delete(prostor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Nemoguce je izbrisati prostor iz baze, jer postoje drugi entiteti koji su vezani za ovaj prostor!");
        }
    }
    
}
