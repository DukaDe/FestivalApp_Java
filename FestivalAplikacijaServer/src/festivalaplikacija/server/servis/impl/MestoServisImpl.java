package festivalaplikacija.server.servis.impl;

import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.zajednicki.domen.Mesto;
import festivalaplikacija.server.repozitorijum.impl.MestoRepozitorijumImpl;
import festivalaplikacija.server.servis.DrzavaServis;
import festivalaplikacija.server.servis.MestoServis;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class MestoServisImpl implements MestoServis {

    MestoRepozitorijumImpl mestoRepozitorijumImpl;
    DrzavaServis drzavaServisImpl;

    public MestoServisImpl() {
        mestoRepozitorijumImpl = new MestoRepozitorijumImpl();
        drzavaServisImpl = new DrzavaServisImpl();
    }

    @Override
    public void add(Mesto mesto) throws Exception {
        List<Mesto> mesta = mestoRepozitorijumImpl.getAll();
        if (mesta.contains(mesto)) {
            throw new Exception("Mesto sa tim ptt brojem iz drzave: " + mesto.getDrzava().getNaziv() + ", vec postoji u bazi!");
        } else {
            mestoRepozitorijumImpl.add(mesto);
        }
    }

    @Override
    public List<Mesto> getAll() throws Exception {
        return mestoRepozitorijumImpl.getAll();
    }

    @Override
    public void delete(Mesto mesto) throws Exception {
        try {
            mestoRepozitorijumImpl.delete(mesto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Nemoguce je izbrisati mesto iz baze, jer postoje drugi entiteti koji su vezani za ovo mesto!");
        }
    }

    @Override
    public void update(Mesto mesto) throws Exception {
        try {
             mestoRepozitorijumImpl.update(mesto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mesto getById(int id) throws Exception {
        Mesto mesto = mestoRepozitorijumImpl.getById(id);
        Drzava drzava = drzavaServisImpl.getById(mesto.getDrzava().getId());
        mesto.setDrzava(drzava);
        return mesto;
    }

    @Override
    public List<Mesto> findByQuery(String query) throws Exception {
         List <Mesto> mesta = mestoRepozitorijumImpl.findByQuery(query);
       for(Mesto m : mesta){
           Drzava drzava = drzavaServisImpl.getById(m.getDrzava().getId());
           m.setDrzava(drzava);
       }
       return mesta;
    }

}
