package festivalaplikacija.server.servis.impl;

import festivalaplikacija.server.repozitorijum.impl.ProgramRepozitorijumImpl;
import festivalaplikacija.server.servis.ProgramServis;
import festivalaplikacija.zajednicki.domen.DanProgram;
import festivalaplikacija.zajednicki.domen.Izvodjac;
import festivalaplikacija.zajednicki.domen.Program;
import festivalaplikacija.zajednicki.domen.Prostor;
import festivalaplikacija.zajednicki.domen.VrstaPrograma;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class ProgramServisImpl implements ProgramServis {

    private final ProgramRepozitorijumImpl programRepozitorijumImpl;
    private final DanProgramServisImpl danProgramServisImpl;
    private final IzvodjacServisImpl izvodjacServisImpl;
    private final VrstaProgramaServisImpl vrstaProgramaServisImpl;
    private final ProstorServisImpl prostorServisImpl;

    public ProgramServisImpl() {
        this.programRepozitorijumImpl = new ProgramRepozitorijumImpl();
        this.danProgramServisImpl = new DanProgramServisImpl();
        this.izvodjacServisImpl = new IzvodjacServisImpl();
        this.vrstaProgramaServisImpl = new VrstaProgramaServisImpl();
        this.prostorServisImpl = new ProstorServisImpl();
    }

    @Override
    public void add(Program program) throws Exception {
        try {
            if (!(programRepozitorijumImpl.getAll().contains(program))) {
                programRepozitorijumImpl.add(program);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Program> getAll() throws Exception {
        return programRepozitorijumImpl.getAll();
    }

    @Override
    public List<Program> findByDay(String danNaziv) throws Exception {
        String upitDan = "SELECT * FROM dan_program WHERE naziv_dana = '" + danNaziv + "'";
        DanProgram danProgram;
        List<Program> programiPoDanu = new ArrayList<>();
        try {
            List<DanProgram> danProgrami = danProgramServisImpl.findByQuery(upitDan);
            if (danProgrami != null && !danProgrami.isEmpty()) {
                danProgram = danProgrami.get(0);
                int danId = danProgram.getId();
                String upitDanId = "SELECT * FROM program WHERE dan_program_id = " + danId + " ORDER BY vreme";
                System.out.println(upitDanId);
                programiPoDanu = programRepozitorijumImpl.findByQuery(upitDanId);
                if (programiPoDanu != null) {
                    for (Program dan : programiPoDanu) {
                        Izvodjac izvodjac = izvodjacServisImpl.getById(dan.getIzvodjac().getId());
                        VrstaPrograma vrstaPrograma = vrstaProgramaServisImpl.getById(dan.getVrstaPrograma().getId());
                        Prostor prostor = prostorServisImpl.getById(dan.getProstor().getId());
                        dan.setIzvodjac(izvodjac);
                        dan.setProstor(prostor);
                        dan.setVrstaPrograma(vrstaPrograma);
                    }
                    return programiPoDanu;
                } else {
                    throw new Exception("Došlo je do greške prilikom učitavanja podataka iz baze!");
                }
            }
            return programiPoDanu;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void update(Program program) throws Exception {
        try {
            System.out.println("Pozvana je metoda update evo novog programa: " + program);
            programRepozitorijumImpl.update(program);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Program> findByQuery(String query) throws Exception {
        return programRepozitorijumImpl.findByQuery(query);
    }

    @Override
    public void delete(Program program) throws Exception {
        try {
            programRepozitorijumImpl.delete(program);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Nemoguce je izbrisati program iz baze, jer postoje drugi entiteti koji su vezani za ovaj program!");
        }
    }

}
