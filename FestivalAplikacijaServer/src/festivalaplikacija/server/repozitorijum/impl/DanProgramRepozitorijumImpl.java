package festivalaplikacija.server.repozitorijum.impl;

import festivalaplikacija.server.repozitorijum.GenerickiRepozitorijum;
import festivalaplikacija.server.repozitorijum.konekcija.MojaDBKonekcija;
import festivalaplikacija.zajednicki.domen.DanProgram;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class DanProgramRepozitorijumImpl implements GenerickiRepozitorijum<DanProgram, Integer> {

    @Override
    public void add(DanProgram entitet) throws Exception {
        try {
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "INSERT INTO dan_program (naziv_dana, datum) VALUES (?, ?)";

            PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
            preparedStatement.setString(1, entitet.getNaziv());
            java.sql.Date sqlDate = new java.sql.Date(entitet.getDatum().getTime());
            preparedStatement.setDate(2, sqlDate);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi add(DanProgram entitet) u klasi DanProgramRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public List<DanProgram> getAll() throws Exception {
        try {
            List<DanProgram> programFestivala = new ArrayList<>();
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "SELECT * FROM dan_program ORDER BY id";
            System.out.println(upit);

            Statement statement = konekcija.createStatement();
            statement.executeQuery(upit);

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String naziv = resultSet.getString("naziv_dana");
                java.sql.Date sqlDate = resultSet.getDate("datum");
                java.util.Date datum = new java.util.Date(sqlDate.getTime());

                DanProgram danProgram = new DanProgram(id, naziv, datum);

                programFestivala.add(danProgram);
            }
            resultSet.close();
            statement.close();
            return programFestivala;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi getAll u klasi DanProgramRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public void delete(DanProgram entitet) throws Exception {
        try {
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "DELETE FROM dan_program WHERE id = ?";
            System.out.println(upit);

            java.sql.PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
            preparedStatement.setInt(1, entitet.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Doslo je do greske u metodi delete(DanProgram entitet) u klasi DanProgramRepozitorijumImpl" + ex.getMessage());
        }
    }

    @Override
    public void update(DanProgram entitet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DanProgram getById(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DanProgram> findByQuery(String query) throws Exception {
        List<DanProgram> danProgrami = new ArrayList<>();
        try {
            System.out.println(query);
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            Statement statement = konekcija.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String naziv = resultSet.getString("naziv_dana");
                java.sql.Date sqlDate = resultSet.getDate("datum");
                java.util.Date datum = new java.util.Date(sqlDate.getTime());
                DanProgram danProgram = new DanProgram(id, naziv, datum);
                danProgrami.add(danProgram);
            }
            return danProgrami;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi findByQuery (DanProgram entitet) u klasi DanProgramRepozitorijumImpl" + e.getMessage());
        }
    }

}
