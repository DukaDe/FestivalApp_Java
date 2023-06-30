package festivalaplikacija.server.servis;

import festivalaplikacija.zajednicki.domen.Program;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public interface ProgramServis {
    void add (Program program) throws Exception;
    List<Program> getAll() throws Exception;
    List<Program> findByDay(String danNaziv) throws Exception;
    void update (Program program) throws Exception;
    List<Program> findByQuery (String query) throws Exception;
    void delete (Program program) throws Exception;
}
