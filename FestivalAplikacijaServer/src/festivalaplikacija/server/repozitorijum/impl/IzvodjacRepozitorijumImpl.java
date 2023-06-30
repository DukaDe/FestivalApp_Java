package festivalaplikacija.server.repozitorijum.impl;

import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.zajednicki.domen.Izvodjac;
import festivalaplikacija.zajednicki.domen.Mesto;
import festivalaplikacija.server.repozitorijum.GenerickiRepozitorijum;
import festivalaplikacija.server.repozitorijum.konekcija.MojaDBKonekcija;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class IzvodjacRepozitorijumImpl implements GenerickiRepozitorijum<Izvodjac, Long> {

    @Override
    public void add(Izvodjac entitet) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "INSERT INTO izvodjac(naziv_izvodjaca, kontakt_osoba, email, telefon, mesto_id) VALUES (?,?,?,?,?);";
            System.out.println(upit);

            PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
            preparedStatement.setString(1, entitet.getNaziv());
            preparedStatement.setString(2, entitet.getKontaktOsoba());
            preparedStatement.setString(3, entitet.getEmail());
            preparedStatement.setString(4, entitet.getKontaktelefon());
            preparedStatement.setInt(5, entitet.getMesto().getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Doslo je do greske u metodi add(Izvodjac entitet) u klasi IzvodjacRepozitorijumImpl" + ex.getMessage());
        }
    }

    @Override
    public List<Izvodjac> getAll() throws Exception {
        try {
            List<Izvodjac> izvodjaci = new ArrayList<>();
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "SELECT izvodjac.id, naziv_izvodjaca, kontakt_osoba, email, telefon, mesto_id, ptt, naziv_mesta, drzava_id, naziv_drzave, skraceni_naziv \n"
                    + "FROM izvodjac JOIN mesto ON izvodjac.mesto_id = mesto.id\n"
                    + "JOIN drzava ON mesto.drzava_id=drzava.id ORDER BY skraceni_naziv";
            System.out.println(upit);

            Statement statement = konekcija.createStatement();
            statement.executeQuery(upit);

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String naziv = resultSet.getString("naziv_izvodjaca");
                String kontaktOsoba = resultSet.getString("kontakt_osoba");
                String email = resultSet.getString("email");
                String kontaktTelefon = resultSet.getString("telefon");
                int mestoId = resultSet.getInt("mesto_id");
                int ptt = resultSet.getInt("ptt");
                String nazivMesta = resultSet.getString("naziv_mesta");
                int drzavaId = resultSet.getInt("drzava_id");
                String nazivDrzave = resultSet.getString("naziv_drzave");
                String skraceniNaziv = resultSet.getString("skraceni_naziv");

                Drzava drzava = new Drzava(drzavaId, nazivDrzave, skraceniNaziv);
                Mesto mesto = new Mesto(mestoId, ptt, nazivMesta, drzava);
                Izvodjac izvodjac = new Izvodjac(id, naziv, kontaktOsoba, email, kontaktTelefon, mesto);

                izvodjaci.add(izvodjac);
            }
            resultSet.close();
            statement.close();
            return izvodjaci;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi getAll u klasi IzvodjacRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public void delete(Izvodjac entitet) throws Exception {
        try {
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "DELETE FROM izvodjac WHERE id = ?";
            System.out.println(upit);

            java.sql.PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
            preparedStatement.setLong(1, entitet.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Doslo je do greske u metodi delete(Izvodjac entitet) u klasi IzvodjacRepozitorijumImpl" + ex.getMessage());
        }
    }

    @Override
    public void update(Izvodjac entitet) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "UPDATE izvodjac SET naziv_izvodjaca = ?, kontakt_osoba = ?, email = ?, telefon = ?, mesto_id = ? WHERE id = ?";
            System.out.println(upit);
            PreparedStatement preparedStatement = konekcija.prepareStatement(upit);

            preparedStatement.setString(1, entitet.getNaziv());
            preparedStatement.setString(2, entitet.getKontaktOsoba());
            preparedStatement.setString(3, entitet.getEmail());
            preparedStatement.setString(4, entitet.getKontaktelefon());
            preparedStatement.setLong(5, entitet.getMesto().getId());
            preparedStatement.setLong(6, entitet.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi update(Izvodjac entitet) u klasi IzvodjacRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public Izvodjac getById(Long id) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "SELECT * FROM izvodjac WHERE id = " + id;
            Statement statement = konekcija.createStatement();
            statement.executeQuery(upit);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                String nazivIzvodjaca = resultSet.getString("naziv_izvodjaca");
                String kontaktOsoba = resultSet.getString("kontakt_osoba");
                String email = resultSet.getString("email");
                String telefon = resultSet.getString("telefon");
                int mestoId = resultSet.getInt("mesto_id");
                Mesto mesto = new Mesto(mestoId, 0, null, null);
                Izvodjac izvodjac = new Izvodjac(id, nazivIzvodjaca, kontaktOsoba, email, telefon, mesto);
                resultSet.close();
                statement.close();
                return izvodjac;

            } else {
                throw new Exception("Ne postoji izvodjac sa tim IDijem u bazi!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi getById (Izvodjac entitet) u klasi IzvodjacRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public List<Izvodjac> findByQuery(String query) throws Exception {
        List<Izvodjac> izvodjaci = new ArrayList<>();
        try {
            System.out.println(query);
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            Statement statement = konekcija.createStatement();           
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nazivIzvodjaca = resultSet.getString("naziv_izvodjaca");
                String kontaktOsoba = resultSet.getString("kontakt_osoba");
                String email = resultSet.getString("email");
                String telefon = resultSet.getString("telefon");
                int mestoId = resultSet.getInt("mesto_id");
                Mesto mesto = new Mesto(mestoId, 0, null, null);
                Izvodjac izvodjac = new Izvodjac(id, nazivIzvodjaca, kontaktOsoba, email, telefon, mesto);
                izvodjaci.add(izvodjac);
            }
            return izvodjaci;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi findByQuery (Drzava entitet) u klasi DrzavaRepozitorijumImpl" + e.getMessage());
        }
    }

}
