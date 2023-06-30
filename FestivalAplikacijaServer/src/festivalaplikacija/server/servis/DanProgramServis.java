package festivalaplikacija.server.servis;

import festivalaplikacija.zajednicki.domen.DanProgram;
import festivalaplikacija.zajednicki.domen.Drzava;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public interface DanProgramServis {

    void add(DanProgram danProgram) throws Exception;
    List<DanProgram> getAll() throws Exception;
    List<DanProgram> findByQuery(String upit) throws Exception;
    void delete(DanProgram danProgram) throws Exception;
    void update(DanProgram danProgram) throws Exception;
}
