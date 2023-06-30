package festivalaplikacija.server.repozitorijum;

import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
S */
public interface GenerickiRepozitorijum <T, ID>{
    void add (T entitet)throws Exception;
    List <T> getAll ()throws Exception;
    void delete(T entitet)throws Exception;
    void update(T entitet) throws Exception;
    T getById(ID id)throws Exception;
    List<T>findByQuery(String query) throws Exception;
}
