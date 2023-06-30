package festivalaplikacija.server.servis.impl;

import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.zajednicki.domen.Izvodjac;
import festivalaplikacija.zajednicki.domen.Mesto;
import festivalaplikacija.server.repozitorijum.impl.IzvodjacRepozitorijumImpl;
import festivalaplikacija.server.servis.IzvodjacServis;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class IzvodjacServisImpl implements IzvodjacServis {

    private final IzvodjacRepozitorijumImpl izvodjacRepozitorijumImpl;
    private final DrzavaServisImpl drzavaServisImpl;
    private final MestoServisImpl mestoServisImpl;

    public IzvodjacServisImpl() {
        izvodjacRepozitorijumImpl = new IzvodjacRepozitorijumImpl();
        drzavaServisImpl = new DrzavaServisImpl();
        mestoServisImpl = new MestoServisImpl();
    }

    @Override
    public void add(Izvodjac izvodjac) throws Exception {
        try {
            if (!(izvodjacRepozitorijumImpl.getAll().contains(izvodjac))) {
                izvodjacRepozitorijumImpl.add(izvodjac);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public List<Izvodjac> getAll() throws Exception {
        return izvodjacRepozitorijumImpl.getAll();
    }

    @Override
    public List<Izvodjac> findByQuery(String query) throws Exception {
        List<Izvodjac> izvodjaci = izvodjacRepozitorijumImpl.findByQuery(query);
        for (Izvodjac i : izvodjaci) {
            Mesto mesto = mestoServisImpl.getById(i.getMesto().getId());
            Drzava drzava = drzavaServisImpl.getById(mesto.getDrzava().getId());
            mesto.setDrzava(drzava);
            i.setMesto(mesto);
        }
        return izvodjaci;
    }

    @Override
    public Izvodjac getById(Long id) throws Exception {
        Izvodjac izvodjac = izvodjacRepozitorijumImpl.getById(id);
        Mesto mesto = mestoServisImpl.getById(izvodjac.getMesto().getId());
        Drzava drzava = drzavaServisImpl.getById(mesto.getDrzava().getId());
        mesto.setDrzava(drzava);
        izvodjac.setMesto(mesto);
        return izvodjac;
    }

    @Override
    public void delete(Izvodjac izvodjac) throws Exception {
        try {
            izvodjacRepozitorijumImpl.delete(izvodjac);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Nemoguce je izbrisati izvodjaca iz baze, jer postoje drugi entiteti koji su vezani za ovog izvodjaca!");
        }
    }

    @Override
    public void update(Izvodjac izvodjac) throws Exception {
         try {
             izvodjacRepozitorijumImpl.update(izvodjac);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

}
