package festivalaplikacija.server.servis;

import festivalaplikacija.zajednicki.domen.Prostor;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public interface ProstorServis {
    Prostor getById(int id) throws Exception;
    List<Prostor> getAll() throws Exception;
    List<Prostor> findByQuery(String query) throws Exception;
    void add(Prostor prostor) throws Exception;
    void update (Prostor prostor) throws Exception;
    void delete (Prostor prostor) throws Exception;
}
