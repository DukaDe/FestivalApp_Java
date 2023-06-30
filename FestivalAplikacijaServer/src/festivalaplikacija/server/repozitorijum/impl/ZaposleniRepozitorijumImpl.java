package festivalaplikacija.server.repozitorijum.impl;

import festivalaplikacija.zajednicki.domen.Mesto;
import festivalaplikacija.zajednicki.domen.Pozicija;
import festivalaplikacija.zajednicki.domen.Zaposleni;
import festivalaplikacija.server.repozitorijum.GenerickiRepozitorijum;
import festivalaplikacija.server.repozitorijum.konekcija.MojaDBKonekcija;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class ZaposleniRepozitorijumImpl implements GenerickiRepozitorijum<Zaposleni, Integer> {

    @Override
    public void add(Zaposleni entitet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Zaposleni> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Zaposleni entitet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Zaposleni entitet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Zaposleni getById(Integer id) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "SELECT * FROM zaposleni WHERE id = " + id;
            Statement statement = konekcija.createStatement();
            ResultSet resultSet = statement.executeQuery(upit);
            if (resultSet.next()) {
                String ime = resultSet.getString("ime");
                String prezime = resultSet.getString("prezime");
                Date datumRodjenja = resultSet.getDate("datum_rodjenja");
                String kontaktTelefon = resultSet.getString("kontakt_telefon");
                String ulicaIBroj = resultSet.getString("ulica_i_broj");
                int mestoId = resultSet.getInt("mesto_id");
                int pozicijaId = resultSet.getInt("pozicija_id");
                Mesto mesto = new Mesto(mestoId, 0, null, null);
                Pozicija pozicija = new Pozicija(pozicijaId, null);
                Zaposleni zaposleni = new Zaposleni(id, ime, prezime, datumRodjenja, kontaktTelefon, ulicaIBroj, mesto, pozicija);
                resultSet.close();
                statement.close();
                return zaposleni;

            } else {
                throw new Exception("Ne postoji izvodjac sa tim IDijem u bazi!");
            }
        } catch (Exception e) {
             throw new Exception("Doslo je do greske prilikom izvrenja metode getById u klasi ZaposleniRepozitorijumImpl "+e.getMessage());
        }
    }   

    @Override
    public List<Zaposleni> findByQuery(String query) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
