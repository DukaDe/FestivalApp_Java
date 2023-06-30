package festivalaplikacija.server.repozitorijum.impl;

import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.server.repozitorijum.GenerickiRepozitorijum;
import festivalaplikacija.server.repozitorijum.konekcija.MojaDBKonekcija;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class DrzavaRepozitorijumImpl implements GenerickiRepozitorijum<Drzava, Integer> {

    @Override
    public void add(Drzava entitet) throws Exception {
        try {
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "INSERT INTO drzava (naziv_drzave, skraceni_naziv) VALUES (?,?);";
            System.out.println(upit);

            PreparedStatement preparedStatement = konekcija.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, entitet.getNaziv());
            preparedStatement.setString(2, entitet.getSkraceniNaziv());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                entitet.setId(resultSet.getInt(1));
            }
            preparedStatement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Doslo je do greske u metodi add(Drzava entitet) u klasi DrzavaRepozitorijumImpl" + ex.getMessage());
        }
    }

    @Override
    public List<Drzava> getAll() throws Exception {
        try {
            List<Drzava> drzave = new ArrayList<>();
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "SELECT * FROM drzava ORDER BY naziv_drzave";
            System.out.println(upit);

            Statement statement = konekcija.createStatement();
            statement.executeQuery(upit);

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String naziv = resultSet.getString("naziv_drzave");
                String skraceniNaziv = resultSet.getString("skraceni_naziv");

                Drzava drzava = new Drzava(id, naziv, skraceniNaziv);

                drzave.add(drzava);
            }
            resultSet.close();
            statement.close();
            return drzave;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi getAll u klasi DrzavaRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public void delete(Drzava entitet) throws Exception {
        try {
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "DELETE FROM drzava WHERE id = ?";
            System.out.println(upit);

            java.sql.PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
            preparedStatement.setInt(1, entitet.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Doslo je do greske u metodi delete(Drzava entitet) u klasi DrzavaRepozitorijumImpl" + ex.getMessage());
        }
    }

    @Override
    public void update(Drzava entitet) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "UPDATE drzava SET naziv_drzave = ?, skraceni_naziv = ? WHERE id = ?";

            PreparedStatement preparedStatement = konekcija.prepareStatement(upit);

            preparedStatement.setString(1, entitet.getNaziv());
            preparedStatement.setString(2, entitet.getSkraceniNaziv());
            preparedStatement.setInt(3, entitet.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi update(Drzava entitet) u klasi DrzavaRepozitorijumImpl" + e.getMessage());
        }
    }


    @Override
    public Drzava getById(Integer id) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "SELECT * FROM drzava WHERE id = " + id;
            Statement statement = konekcija.createStatement();
            statement.executeQuery(upit);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                String naziv = resultSet.getString("naziv_drzave");
                String skraceniNaziv = resultSet.getString("skraceni_naziv");
                Drzava drzava = new Drzava(id, naziv, skraceniNaziv);
                resultSet.close();
                statement.close();
                return drzava;

            } else {
                throw new Exception("Ne postoji drzava sa tim IDijem u bazi!");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi getById (Drzava entitet) u klasi DrzavaRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public List<Drzava> findByQuery(String query) throws Exception {
        List<Drzava> drzave = new ArrayList<>();
        try {
            System.out.println(query);
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            Statement statement = konekcija.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String naziv = resultSet.getString("naziv_drzave");
                String skraceniNaziv = resultSet.getString("skraceni_naziv");
                Drzava drzava = new Drzava(id, naziv, skraceniNaziv);
                drzave.add(drzava);
            }
            return drzave;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi findByQuery (Drzava entitet) u klasi DrzavaRepozitorijumImpl" + e.getMessage());
        }
    }

}
