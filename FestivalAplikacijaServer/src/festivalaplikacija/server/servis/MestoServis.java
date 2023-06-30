package festivalaplikacija.server.servis;

import festivalaplikacija.zajednicki.domen.Mesto;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public interface MestoServis {
    void add(Mesto mesto)throws Exception;
    List<Mesto> getAll()throws Exception;
    void delete(Mesto mesto)throws Exception;
    void update(Mesto mesto) throws Exception;
    Mesto getById(int id) throws Exception;
    List <Mesto> findByQuery(String upit) throws Exception;
}
