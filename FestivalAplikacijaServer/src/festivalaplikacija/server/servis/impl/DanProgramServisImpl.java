package festivalaplikacija.server.servis.impl;

import festivalaplikacija.server.repozitorijum.impl.DanProgramRepozitorijumImpl;
import festivalaplikacija.server.servis.DanProgramServis;
import festivalaplikacija.zajednicki.domen.DanProgram;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class DanProgramServisImpl implements DanProgramServis{

    private final DanProgramRepozitorijumImpl danProgramRepozitorijumImpl;

    public DanProgramServisImpl() {
        this.danProgramRepozitorijumImpl = new DanProgramRepozitorijumImpl();
    }
    
    
    @Override
    public void add(DanProgram danProgram) throws Exception {
        try {
            danProgramRepozitorijumImpl.add(danProgram);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<DanProgram> getAll() throws Exception {
        return danProgramRepozitorijumImpl.getAll();
    }

    @Override
    public List<DanProgram> findByQuery(String upit) throws Exception {
        return danProgramRepozitorijumImpl.findByQuery(upit);
    }

    @Override
    public void delete(DanProgram danProgram) throws Exception {
         try {
            danProgramRepozitorijumImpl.delete(danProgram);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Nemoguce je izbrisati dan iz baze, jer postoje drugi entiteti koji su vezani za ovaj dan!");
        }
    }

    @Override
    public void update(DanProgram danProgram) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
