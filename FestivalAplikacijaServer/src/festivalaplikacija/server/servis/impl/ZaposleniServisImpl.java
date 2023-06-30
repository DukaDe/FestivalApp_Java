package festivalaplikacija.server.servis.impl;

import festivalaplikacija.zajednicki.domen.Mesto;
import festivalaplikacija.zajednicki.domen.Zaposleni;
import festivalaplikacija.server.repozitorijum.impl.ZaposleniRepozitorijumImpl;
import festivalaplikacija.server.servis.ZaposleniServis;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class ZaposleniServisImpl implements ZaposleniServis {

    ZaposleniRepozitorijumImpl zaposleniRepozitorijumImpl;
    MestoServisImpl mestoServisImpl;

    public ZaposleniServisImpl() {
        zaposleniRepozitorijumImpl = new ZaposleniRepozitorijumImpl();
        mestoServisImpl = new MestoServisImpl();
    }

    @Override
    public Zaposleni getById(Integer id) throws Exception {
        try {
            Zaposleni zaposleni = zaposleniRepozitorijumImpl.getById(id);
            Mesto mesto = mestoServisImpl.getById(zaposleni.getMesto().getId());
            zaposleni.setMesto(mesto);
            return zaposleni;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Zaposleni sa tim ID-jem ne postoji u bazi!");
        }
    }

}
