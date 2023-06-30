package festivalaplikacija.server.servis;

import festivalaplikacija.zajednicki.domen.Drzava;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public interface DrzavaServis {
    void add(Drzava drzava)throws Exception;
    List <Drzava> getAll()throws Exception;
    void delete(Drzava drzava)throws Exception;
    void update(Drzava drzava) throws Exception;
    Drzava getById(int id)throws Exception;
    List<Drzava> findByQuery(String query) throws Exception;
}
