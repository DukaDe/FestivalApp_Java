package festivalaplikacija.server.repozitorijum.impl;

import festivalaplikacija.server.repozitorijum.GenerickiRepozitorijum;
import festivalaplikacija.server.repozitorijum.konekcija.MojaDBKonekcija;
import festivalaplikacija.zajednicki.domen.Prostor;
import festivalaplikacija.zajednicki.domen.VrstaProstora;
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
public class ProstorRepozitorijumImpl implements GenerickiRepozitorijum<Prostor, Integer> {

    @Override
    public void add(Prostor entitet) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "INSERT INTO prostor (naziv_prostora, kapacitet, vrsta_prostora) VALUES (?,?,?);";
            System.out.println(upit);
            PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
            preparedStatement.setString(1, entitet.getNaziv());
            preparedStatement.setInt(2, entitet.getKapacitet());
            preparedStatement.setString(3, entitet.getVrstaProstora().toString());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi add(Drzava entitet) u klasi DrzavaRepozitorijumImpl" + e.getMessage());
        }

    }

    @Override
    public List<Prostor> getAll() throws Exception {
        try {
            List<Prostor> prostori = new ArrayList<>();
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "SELECT * FROM prostor ORDER BY naziv_prostora";
            System.out.println(upit);

            Statement statement = konekcija.createStatement();
            statement.executeQuery(upit);

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                Prostor prostor;
                int id = resultSet.getInt("id");
                String nazivProstora = resultSet.getString("naziv_prostora");
                int kapacitet = resultSet.getInt("kapacitet");
                String vrstaProstora = resultSet.getString("vrsta_prostora");
                if (vrstaProstora.equalsIgnoreCase("ZATVORENI")) {
                    prostor = new Prostor(id, nazivProstora, kapacitet, VrstaProstora.ZATVORENI);
                } else {
                    prostor = new Prostor(id, nazivProstora, kapacitet, VrstaProstora.OTVORENI);
                }

                prostori.add(prostor);
            }
            resultSet.close();
            statement.close();
            return prostori;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi getAll u klasi ProstorRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public void delete(Prostor entitet) throws Exception {
        try {
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "DELETE FROM prostor WHERE id = ?";
            System.out.println(upit);

            java.sql.PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
            preparedStatement.setInt(1, entitet.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Doslo je do greske u metodi delete(Prostor entitet) u klasi ProstorRepozitorijumImpl" + ex.getMessage());
        }
    }

    @Override
    public void update(Prostor entitet) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "UPDATE prostor SET naziv_prostora = ?, kapacitet = ?, vrsta_prostora = ? WHERE id = ?";

            PreparedStatement preparedStatement = konekcija.prepareStatement(upit);

            preparedStatement.setString(1, entitet.getNaziv());
            preparedStatement.setInt(2, entitet.getKapacitet());
            preparedStatement.setString(3, entitet.getVrstaProstora().toString());
            preparedStatement.setInt(4, entitet.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi update(Prostor entitet) u klasi ProstorRepozitorijumImpl" + e.getMessage());
        }

    }

    @Override
    public Prostor getById(Integer id) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "SELECT * FROM prostor WHERE id = " + id;
            Statement statement = konekcija.createStatement();
            statement.executeQuery(upit);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                Prostor prostor;
                String nazivProstora = resultSet.getString("naziv_prostora");
                int kapacitet = resultSet.getInt("kapacitet");
                String vrstaProstora = resultSet.getString("vrsta_prostora");
                if (vrstaProstora.equalsIgnoreCase("ZATVORENI")) {
                    prostor = new Prostor(id, nazivProstora, kapacitet, VrstaProstora.ZATVORENI);
                } else {
                    prostor = new Prostor(id, nazivProstora, kapacitet, VrstaProstora.OTVORENI);
                }
                resultSet.close();
                statement.close();
                return prostor;

            } else {
                throw new Exception("Ne postoji prostor sa tim IDijem u bazi!");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi getById (Prostor entitet) u klasi ProstorRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public List<Prostor> findByQuery(String query) throws Exception {
        List<Prostor> prostori = new ArrayList<>();
        try {
            System.out.println(query);
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            Statement statement = konekcija.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Prostor prostor;
                int id = resultSet.getInt("id");
                String nazivProstora = resultSet.getString("naziv_prostora");
                int kapacitet = resultSet.getInt("kapacitet");
                String vrstaProstora = resultSet.getString("vrsta_prostora");
                if (vrstaProstora.equalsIgnoreCase("ZATVORENI")) {
                    prostor = new Prostor(id, nazivProstora, kapacitet, VrstaProstora.ZATVORENI);
                } else {
                    prostor = new Prostor(id, nazivProstora, kapacitet, VrstaProstora.OTVORENI);
                }
                prostori.add(prostor);
            }
            resultSet.close();
            statement.close();
            return prostori;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi findByQuery (Prostor entitet) u klasi ProstorRepozitorijumImpl" + e.getMessage());
        }
    }

}
