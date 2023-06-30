package festivalaplikacija.server.repozitorijum.impl;

import festivalaplikacija.zajednicki.domen.KorisnickiNalog;
import festivalaplikacija.zajednicki.domen.Uloga;
import festivalaplikacija.zajednicki.domen.Zaposleni;
import festivalaplikacija.server.repozitorijum.GenerickiRepozitorijum;
import festivalaplikacija.server.repozitorijum.konekcija.MojaDBKonekcija;
import java.util.List;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class KorisnickiNalogRepozitorijumImpl implements GenerickiRepozitorijum<KorisnickiNalog, String> {

    @Override
    public void add(KorisnickiNalog entitet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KorisnickiNalog> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(KorisnickiNalog entitet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(KorisnickiNalog entitet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KorisnickiNalog getById(String id) throws Exception {
        Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
        String upit = "SELECT korisnicki_nalog.email, zaposleni_id, uloga_id, naziv_uloge FROM korisnicki_nalog\n"
                + "JOIN korisnicki_nalog_uloga ON korisnicki_nalog.email=korisnicki_nalog_uloga.email\n"
                + "JOIN uloga ON korisnicki_nalog_uloga.uloga_id=uloga.id\n"
                + "WHERE korisnicki_nalog.email = '"+id+"'";
        Statement statement = konekcija.createStatement();
        ResultSet resultSet = statement.executeQuery(upit);
        KorisnickiNalog korisnickiNalog = new KorisnickiNalog();
        List<Uloga> uloge = new ArrayList<>();
        while (resultSet.next()){
            int zaposleniId = resultSet.getInt("zaposleni_id");            
            Zaposleni zaposleni = new Zaposleni();
            zaposleni.setId(zaposleniId);
            korisnickiNalog.setZaposleni(zaposleni);
            int ulogaId = resultSet.getInt("uloga_id");
            String nazivUloge = resultSet.getString("naziv_uloge");
            Uloga uloga = new Uloga(ulogaId, nazivUloge);
            uloge.add(uloga);
        }

        korisnickiNalog.setUloge(uloge);
        statement.close();
        resultSet.close();
        return korisnickiNalog;
    }

    @Override
    public List<KorisnickiNalog> findByQuery(String query) throws Exception {

        try {
            List<KorisnickiNalog> nalozi = new ArrayList<>();
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            Statement statement = konekcija.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                int zaposleniId = resultSet.getInt("zaposleni_id");
                Zaposleni zaposleni = new Zaposleni();
                zaposleni.setId(zaposleniId);
                KorisnickiNalog korisnickiNalog = new KorisnickiNalog();
                korisnickiNalog.setEmail(email);
                korisnickiNalog.setZaposleni(zaposleni);
                korisnickiNalog.setPassword(password);
                nalozi.add(korisnickiNalog);
            }
            resultSet.close();
            statement.close();
            return nalozi;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske prilikom izvrenja metode findByQueri u klasi KorisnickiNalogRepozitorijumImpl " + e.getMessage());
        }
    }

}
