package festivalaplikacija.server.servis;

import festivalaplikacija.zajednicki.domen.VrstaPrograma;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public interface VrstaProgramaServis {

    void add(VrstaPrograma vrstaPrograma) throws Exception;
    List<VrstaPrograma> getAll() throws Exception;
    void delete(VrstaPrograma vrstaPrograma) throws Exception;
    VrstaPrograma getById (int id) throws Exception;
    List<VrstaPrograma> findByQuery(String queri) throws Exception;
    void update (VrstaPrograma vrstaPrograma) throws Exception;
}
