package festivalaplikacija.server.servis.impl;

import festivalaplikacija.server.repozitorijum.impl.VrstaProgramaRepozitorijumImpl;
import festivalaplikacija.server.servis.VrstaProgramaServis;
import festivalaplikacija.zajednicki.domen.VrstaPrograma;
import java.util.List;
/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class VrstaProgramaServisImpl implements VrstaProgramaServis{

    private VrstaProgramaRepozitorijumImpl vrstaProgramaRepozitorijumImpl;

    public VrstaProgramaServisImpl() {
        vrstaProgramaRepozitorijumImpl = new VrstaProgramaRepozitorijumImpl();
    }
    @Override
    public void add(VrstaPrograma vrstaPrograma) throws Exception {
         if (vrstaProgramaRepozitorijumImpl.getAll().contains(vrstaPrograma)) {
            throw new Exception("Program sa tim imenom vec postoji u bazi!");
        } else {
            vrstaProgramaRepozitorijumImpl.add(vrstaPrograma);
        }
    }

    @Override
    public List<VrstaPrograma> getAll() throws Exception {
        return vrstaProgramaRepozitorijumImpl.getAll();
    }

    @Override
    public void delete(VrstaPrograma vrstaPrograma) throws Exception {
       try {
            vrstaProgramaRepozitorijumImpl.delete(vrstaPrograma);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Nemoguce je izbrisati program iz baze, jer postoje drugi entiteti koji su vezani za ovaj program!");
        }
    }

    @Override
    public VrstaPrograma getById(int id) throws Exception {
        VrstaPrograma vrstaPrograma = vrstaProgramaRepozitorijumImpl.getById(id);
        return vrstaPrograma;
    }

    @Override
    public List<VrstaPrograma> findByQuery(String queri) throws Exception {
        List<VrstaPrograma> vrstePrograma = vrstaProgramaRepozitorijumImpl.findByQuery(queri);
        if (vrstePrograma != null) {
            return vrstePrograma;
        } else {
            throw new Exception("Upitom nije selektovan nijedan red iz baze!");
        }
    }

    @Override
    public void update(VrstaPrograma vrstaPrograma) throws Exception {
        try {
            vrstaProgramaRepozitorijumImpl.update(vrstaPrograma);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
    
}
