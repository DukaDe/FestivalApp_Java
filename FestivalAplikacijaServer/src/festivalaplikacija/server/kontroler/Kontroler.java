package festivalaplikacija.server.kontroler;

import festivalaplikacija.server.servis.DanProgramServis;
import festivalaplikacija.server.servis.DrzavaServis;
import festivalaplikacija.server.servis.IzvodjacServis;
import festivalaplikacija.server.servis.KorisnickiNalogServis;
import festivalaplikacija.server.servis.MestoServis;
import festivalaplikacija.server.servis.ProgramServis;
import festivalaplikacija.server.servis.ProstorServis;
import festivalaplikacija.server.servis.VrstaProgramaServis;
import festivalaplikacija.server.servis.impl.DanProgramServisImpl;
import festivalaplikacija.server.servis.impl.DrzavaServisImpl;
import festivalaplikacija.server.servis.impl.IzvodjacServisImpl;
import festivalaplikacija.server.servis.impl.KorisnickiNalogServisImpl;
import festivalaplikacija.server.servis.impl.MestoServisImpl;
import festivalaplikacija.server.servis.impl.ProgramServisImpl;
import festivalaplikacija.server.servis.impl.ProstorServisImpl;
import festivalaplikacija.server.servis.impl.VrstaProgramaServisImpl;
import festivalaplikacija.zajednicki.domen.DanProgram;
import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.zajednicki.domen.Izvodjac;
import festivalaplikacija.zajednicki.domen.KorisnickiNalog;
import festivalaplikacija.zajednicki.domen.Mesto;
import festivalaplikacija.zajednicki.domen.Program;
import festivalaplikacija.zajednicki.domen.Prostor;
import festivalaplikacija.zajednicki.domen.VrstaPrograma;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Kontroler {

    private static final Kontroler instance = new Kontroler();
    private final DrzavaServis drzavaServis;
    private final KorisnickiNalogServis korisnickiNalogServis;
    private final MestoServis mestoServis;
    private final IzvodjacServis izvodjacServis;
    private final DanProgramServis danProgramServis;
    private final ProgramServis programServis;
    private final VrstaProgramaServis vrstaProgramaServis;
    private final ProstorServis prostorServis;

    private Kontroler() {
        this.drzavaServis = new DrzavaServisImpl();
        this.korisnickiNalogServis = new KorisnickiNalogServisImpl();
        this.mestoServis = new MestoServisImpl();
        this.izvodjacServis = new IzvodjacServisImpl();
        this.danProgramServis = new DanProgramServisImpl();
        this.programServis = new ProgramServisImpl();
        this.vrstaProgramaServis = new VrstaProgramaServisImpl();
        this.prostorServis = new ProstorServisImpl();
    }

    public static Kontroler getInstance() {
        return instance;
    }

    public List<Drzava> getAllDrzava() throws Exception {
        return drzavaServis.getAll();
    }

    public KorisnickiNalog login(KorisnickiNalog korisnickiNalog) throws Exception {
        return korisnickiNalogServis.login(korisnickiNalog);
    }

    public void addDrzava(Drzava drzava) throws Exception {
        drzavaServis.add(drzava);
    }

    public void updateDrzava(Drzava drzava) throws Exception {
        drzavaServis.update(drzava);
    }

    public void deleteDrzava(Drzava drzava) throws Exception {
        drzavaServis.delete(drzava);
    }

    public List<Drzava> findByNameDrzava(Drzava drzava) throws Exception {
        String upit = "SELECT * FROM drzava WHERE naziv_drzave = " + "'" + drzava.getNaziv() + "'";
        return drzavaServis.findByQuery(upit);
    }

    public void addMesto(Mesto mesto) throws Exception {
        mestoServis.add(mesto);
    }

    public List<Mesto> getAllMesto() throws Exception {
        return mestoServis.getAll();
    }

    public void updateMesto(Mesto mesto) throws Exception {
        mestoServis.update(mesto);
    }

    public void deleteMesto(Mesto mesto) throws Exception {
        mestoServis.delete(mesto);
    }

    public List<Mesto> findByQueryMesto(String upit) throws Exception {
        return mestoServis.findByQuery(upit);
    }

    public List<Izvodjac> getAllIzvodjac() throws Exception {
        return izvodjacServis.getAll();
    }

    public void addIzvodjac(Izvodjac izvodjac) throws Exception {
        izvodjacServis.add(izvodjac);
    }

    public List<Izvodjac> findByQueryIzvodjac(String upit) throws Exception {
        return izvodjacServis.findByQuery(upit);
    }

    public void deleteIzvodjac(Izvodjac izvodjac) throws Exception {
        izvodjacServis.delete(izvodjac);
    }

    public void updateIzvodjac(Izvodjac izvodjac) throws Exception {
        izvodjacServis.update(izvodjac);
    }

    public void addDanProgram(DanProgram danProgram) throws Exception {
        danProgramServis.add(danProgram);
    }

    public List<Program> findByQueryProgram(String query) throws Exception {
        return programServis.findByQuery(query);
    }

    public List<DanProgram> getAllDanPrograma() throws Exception {
        return danProgramServis.getAll();
    }

    public List<Program> findByDayProgrami(String danNaziv) throws Exception {
        return programServis.findByDay(danNaziv);
    }
    
    public void deleteProgram (Program program) throws Exception {
        programServis.delete(program);
    }

    public void deleteDanProgram(DanProgram danProgram) throws Exception {
        danProgramServis.delete(danProgram);
    }

    public List<Program> getAllProgram() throws Exception {
        return programServis.getAll();
    }

    public void addProgram(Program program) throws Exception {
        programServis.add(program);
    }

    public void updateProgram(Program program) throws Exception {
        programServis.update(program);
    }

    public List<VrstaPrograma> getAllVrstaPrograma() throws Exception {
        return vrstaProgramaServis.getAll();
    }

    public void addVrstaPrograma(VrstaPrograma vrstaPrograma) throws Exception {
        vrstaProgramaServis.add(vrstaPrograma);
    }

    public void deleteVrstaPrograma(VrstaPrograma vrstaPrograma) throws Exception {
        vrstaProgramaServis.delete(vrstaPrograma);
    }
    
    public void updateVrstaPrograma(VrstaPrograma vrstaPrograma) throws Exception {
        vrstaProgramaServis.update(vrstaPrograma);
    }

    public List<VrstaPrograma> findByQueryVrstaPrograma(String upit) throws Exception {
        return vrstaProgramaServis.findByQuery(upit);
    }

    public List<DanProgram> findByQueryDanProgram(String upit) throws Exception {
        return danProgramServis.findByQuery(upit);
    }

    public List<Prostor> getAllProstor() throws Exception {
        return prostorServis.getAll();
    }

    public List<Prostor> findByQueryProstor(String query) throws Exception {
        return prostorServis.findByQuery(query);
    }

    public Prostor getByIdProstor(int id) throws Exception {
        return prostorServis.getById(id);
    }

    public void addProstor(Prostor prostor) throws Exception {
        prostorServis.add(prostor);
    }

    public void updateProstor(Prostor prostor) throws Exception {
        prostorServis.update(prostor);
    }

    public void deleteProstor(Prostor prostor) throws Exception {
        prostorServis.delete(prostor);
    }
}
