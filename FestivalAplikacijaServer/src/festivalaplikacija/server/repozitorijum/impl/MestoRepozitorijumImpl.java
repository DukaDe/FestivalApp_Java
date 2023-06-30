package festivalaplikacija.server.repozitorijum.impl;

import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.zajednicki.domen.Mesto;
import festivalaplikacija.server.repozitorijum.GenerickiRepozitorijum;
import festivalaplikacija.server.repozitorijum.konekcija.MojaDBKonekcija;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class MestoRepozitorijumImpl implements GenerickiRepozitorijum<Mesto, Integer> {

    @Override
    public void add(Mesto entitet) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "INSERT INTO mesto(ptt, naziv_mesta, drzava_id) VALUES (?,?,?);";
            System.out.println(upit);

            PreparedStatement preparedStatement = konekcija.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, entitet.getPtt());
            preparedStatement.setString(2, entitet.getNaziv());
            preparedStatement.setInt(3, entitet.getDrzava().getId());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                entitet.setId(resultSet.getInt(1));
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Doslo je do greske u metodi add(Mesto entitet) u klasi MestoRepozitorijumImpl" + ex.getMessage());
        }
    }

    @Override
    public List<Mesto> getAll() throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            List<Mesto> mesta = new ArrayList<>();
            String upit = "SELECT mesto.id AS mesto_id, ptt, naziv_mesta, drzava_id, naziv_drzave, skraceni_naziv\n"
                    + "FROM mesto JOIN drzava ON drzava_id = drzava.id;";

            Statement statement = konekcija.createStatement();
            statement.executeQuery(upit);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("mesto_id");
                int ptt = resultSet.getInt("ptt");
                String naziv = resultSet.getString("naziv_mesta");
                int drzavaId = resultSet.getInt("drzava_id");
                String nazivDrzave = resultSet.getString("naziv_drzave");
                String skraceniNaziv = resultSet.getString("skraceni_naziv");
                Drzava drzava = new Drzava(drzavaId, nazivDrzave, skraceniNaziv);
                Mesto mesto = new Mesto(id, ptt, naziv, drzava);
                mesta.add(mesto);
            }
            resultSet.close();
            statement.close();
            return mesta;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi getAll(Mesto entitet) u klasi MestoRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public void delete(Mesto entitet) throws Exception {
        try {
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "DELETE FROM mesto WHERE id = ?";
            System.out.println(upit);

            java.sql.PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
            preparedStatement.setInt(1, entitet.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Doslo je do greske u metodi delete(Mesto entitet) u klasi MestoRepozitorijumImpl" + ex.getMessage());
        }
    }

    @Override
    public void update(Mesto entitet) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "UPDATE mesto SET ptt = ?, naziv_mesta = ? WHERE id = ?";

            PreparedStatement preparedStatement = konekcija.prepareStatement(upit);

            preparedStatement.setInt(1, entitet.getPtt());
            preparedStatement.setString(2, entitet.getNaziv());
            preparedStatement.setInt(3, entitet.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi update(Drzava entitet) u klasi DrzavaRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public Mesto getById(Integer id) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "SELECT * FROM mesto WHERE id = " + id;
            Statement statement = konekcija.createStatement();
            statement.executeQuery(upit);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                int ptt = resultSet.getInt("ptt");
                String nazivMesta = resultSet.getString("naziv_mesta");
                int drzavaId = resultSet.getInt("drzava_id");
                Drzava drzava = new Drzava(drzavaId, null, null);
                Mesto mesto = new Mesto(id, ptt, nazivMesta, drzava);
                resultSet.close();
                statement.close();
                return mesto;

            } else {
                throw new Exception("Ne postoji mesto sa tim IDijem u bazi!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi getById (Mesto entitet) u klasi MestoRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public List<Mesto> findByQuery(String query) throws Exception {
        List<Mesto> mesta = new ArrayList<>();
        try {
            System.out.println(query);
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            Statement statement = konekcija.createStatement();            
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int ptt = resultSet.getInt("ptt");
                String nazivMesta = resultSet.getString("naziv_mesta");
                int drzavaId = resultSet.getInt("drzava_id");
                Drzava drzava = new Drzava(drzavaId, null, null);
                Mesto mesto = new Mesto(id, ptt, nazivMesta, drzava);
                mesta.add(mesto);
            }
            return mesta;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi findByQuery (Mesto entitet) u klasi MestaRepozitorijumImpl" + e.getMessage());
        }
    }

}
