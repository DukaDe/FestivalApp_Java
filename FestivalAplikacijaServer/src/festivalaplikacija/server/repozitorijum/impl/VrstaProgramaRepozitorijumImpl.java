package festivalaplikacija.server.repozitorijum.impl;

import festivalaplikacija.server.repozitorijum.GenerickiRepozitorijum;
import festivalaplikacija.server.repozitorijum.konekcija.MojaDBKonekcija;
import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.zajednicki.domen.VrstaPrograma;
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
public class VrstaProgramaRepozitorijumImpl implements GenerickiRepozitorijum<VrstaPrograma, Integer> {

    @Override
    public void add(VrstaPrograma entitet) throws Exception {
        try {
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "INSERT INTO vrsta_programa (naziv) VALUES (?);";
            System.out.println(upit);

            PreparedStatement preparedStatement = konekcija.prepareStatement(upit);

            preparedStatement.setString(1, entitet.getNaziv());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Doslo je do greske u metodi add(VrstaPrograma entitet) u klasi VrstaProgramaRepozitorijumImpl" + ex.getMessage());
        }
    }

    @Override
    public List<VrstaPrograma> getAll() throws Exception {
        try {
            List<VrstaPrograma> programi = new ArrayList<>();
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "SELECT * FROM vrsta_programa ORDER BY naziv";
            System.out.println(upit);

            Statement statement = konekcija.createStatement();
            statement.executeQuery(upit);

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String naziv = resultSet.getString("naziv");

                VrstaPrograma vrstaPrograma = new VrstaPrograma(id, naziv);

                programi.add(vrstaPrograma);
            }
            resultSet.close();
            statement.close();
            return programi;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi getAll u klasi VrstaProgramaRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public void delete(VrstaPrograma entitet) throws Exception {
        try {
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "DELETE FROM vrsta_programa WHERE id = ?";
            System.out.println(upit);

            java.sql.PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
            preparedStatement.setInt(1, entitet.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Doslo je do greske u metodi delete(VrstaPrograma entitet) u klasi VrstaProgramaRepozitorijumImpl" + ex.getMessage());
        }
    }

    @Override
    public void update(VrstaPrograma entitet) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "UPDATE vrsta_programa SET naziv = ? WHERE id = ?";

            PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
            preparedStatement.setString(1, entitet.getNaziv());
            preparedStatement.setInt(2, entitet.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi update(VrstaPrograma entitet) u klasi VrstaProgramaRepozitorijumImpl" + e.getMessage());
        }

    }

    @Override
    public VrstaPrograma getById(Integer id) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "SELECT * FROM vrsta_programa WHERE id = " + id;
            Statement statement = konekcija.createStatement();
            statement.executeQuery(upit);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                String naziv = resultSet.getString("naziv");
                VrstaPrograma vrstaPrograma = new VrstaPrograma(id, naziv);
                resultSet.close();
                statement.close();
                return vrstaPrograma;

            } else {
                throw new Exception("Ne postoji vrsta programa sa tim IDijem u bazi!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi getById (VrstaPrograma entitet) u klasi VrstaProgramaRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public List<VrstaPrograma> findByQuery(String query) throws Exception {
        List<VrstaPrograma> vrstePrograma = new ArrayList<>();
        try {
            System.out.println(query);
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            Statement statement = konekcija.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String naziv = resultSet.getString("naziv");
                VrstaPrograma vrstaPrograma = new VrstaPrograma(id, naziv);
                vrstePrograma.add(vrstaPrograma);
            }
            resultSet.close();
            statement.close();
            return vrstePrograma;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi findByQuery (VrstaPrograma entitet) u klasi VrstaProgramaRepozitorijumImpl" + e.getMessage());
        }
    }

}
