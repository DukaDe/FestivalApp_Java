package festivalaplikacija.server.servis;

import festivalaplikacija.zajednicki.domen.Izvodjac;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public interface IzvodjacServis {
    void add (Izvodjac izvodjac) throws Exception;
    List <Izvodjac> getAll()throws Exception;
    List<Izvodjac> findByQuery(String query)throws Exception;
    Izvodjac getById (Long id) throws Exception;
    void delete (Izvodjac izvodjac) throws Exception;
    void update (Izvodjac izvodjac) throws Exception;
}
