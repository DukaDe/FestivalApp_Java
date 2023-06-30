package festivalaplikacija.server.servis;

import festivalaplikacija.zajednicki.domen.Zaposleni;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public interface ZaposleniServis {
    Zaposleni getById(Integer id) throws Exception;
}
