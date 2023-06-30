package festivalaplikacija.server.repozitorijum.impl;

import festivalaplikacija.server.repozitorijum.GenerickiRepozitorijum;
import festivalaplikacija.server.repozitorijum.konekcija.MojaDBKonekcija;
import festivalaplikacija.zajednicki.domen.DanProgram;
import festivalaplikacija.zajednicki.domen.Izvodjac;
import festivalaplikacija.zajednicki.domen.Program;
import festivalaplikacija.zajednicki.domen.Prostor;
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
public class ProgramRepozitorijumImpl implements GenerickiRepozitorijum<Program, Long> {

    @Override
    public void add(Program entitet) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "INSERT INTO program(naziv_programa, vreme, trajanje_programa_u_minutima, broj_izvodjaca, "
                    + "vrsta_id, izvodjac_id, prostor_id, dan_program_id) VALUES (?,?,?,?,?,?,?,?);";
            System.out.println(upit);

            PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
            preparedStatement.setString(1, entitet.getNaziv());
            java.sql.Time sqlTime = new java.sql.Time(entitet.getVreme().getTime());
            preparedStatement.setTime(2, sqlTime);
            preparedStatement.setInt(3, entitet.getTrajanjePrograma());
            preparedStatement.setInt(4, entitet.getBrojIzvodjaca());
            preparedStatement.setInt(5, entitet.getVrstaPrograma().getId());
            preparedStatement.setLong(6, entitet.getIzvodjac().getId());
            preparedStatement.setInt(7, entitet.getProstor().getId());
            preparedStatement.setInt(8, entitet.getDanProgram().getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Doslo je do greske u metodi add(Program entitet) u klasi ProgramRepozitorijumImpl" + ex.getMessage());
        }
    }

    @Override
    public List<Program> getAll() throws Exception {
        try {
            List<Program> programi = new ArrayList<>();
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "SELECT program.id, naziv_programa, vreme, trajanje_programa_u_minutima,"
                    + "broj_izvodjaca, vrsta_id, izvodjac_id, prostor_id, dan_program_id, vrsta_programa.naziv AS vrsta_programa,\n"
                    + "naziv_prostora, kapacitet, naziv_izvodjaca\n"
                    + "FROM program \n"
                    + "JOIN vrsta_programa ON program.vrsta_id = vrsta_programa.id\n"
                    + "JOIN prostor ON program.prostor_id = prostor.id\n"
                    + "JOIN izvodjac ON program.izvodjac_id = izvodjac.id\n"
                    + "JOIN dan_program ON program.dan_program_id = dan_program.id;";
            System.out.println(upit);

            Statement statement = konekcija.createStatement();
            statement.executeQuery(upit);

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nazivProgram = resultSet.getString("naziv_programa");
                java.sql.Time sqlTime = resultSet.getTime("vreme");
                java.util.Date vreme = new java.util.Date(sqlTime.getTime());
                int trajanjePrograma = resultSet.getInt("trajanje_programa_u_minutima");
                int brojIzvodjaca = resultSet.getInt("broj_izvodjaca");
                int vrstaId = resultSet.getInt("vrsta_id");
                Long izvodjacId = resultSet.getLong("izvodjac_id");
                int prostorId = resultSet.getInt("prostor_id");
                int danProgramId = resultSet.getInt("dan_program_id");
                String vrstaProgramaNaziv = resultSet.getString("vrsta_programa");
                String prostorNaziv = resultSet.getString("naziv_prostora");
                int kapacitet = resultSet.getInt("kapacitet");
                String izvodjacNaziv = resultSet.getString("naziv_izvodjaca");

                VrstaPrograma vrstaPrograma = new VrstaPrograma(vrstaId, vrstaProgramaNaziv);
                DanProgram danProgram = new DanProgram(danProgramId, null, null);
                Izvodjac izvodjac = new Izvodjac(izvodjacNaziv, null, null, null, null);
                Prostor prostor = new Prostor(prostorId, prostorNaziv, kapacitet, null);
                Program program = new Program(id, nazivProgram, vreme, trajanjePrograma, brojIzvodjaca, vrstaPrograma, izvodjac, prostor, danProgram);

                programi.add(program);
            }
            return programi;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi getAll u klasi ProgramRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public void delete(Program entitet) throws Exception {
        try {
            Connection konekcija;
            konekcija = MojaDBKonekcija.getInstance().getConnection();

            String upit = "DELETE FROM program WHERE id = ?";
            System.out.println(upit);

            java.sql.PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
            preparedStatement.setLong(1, entitet.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Doslo je do greske u metodi delete(Program entitet) u klasi ProgramRepozitorijumImpl" + ex.getMessage());
        }
    }

    @Override
    public void update(Program entitet) throws Exception {
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            String upit = "UPDATE program SET naziv_programa = ?, vreme = ?, trajanje_programa_u_minutima = ?, broj_izvodjaca = ?, "
                    + "vrsta_id = ?, izvodjac_id = ?, prostor_id = ?, dan_program_id = ? WHERE id = ?";
            System.out.println(upit);
            PreparedStatement preparedStatement = konekcija.prepareStatement(upit);

            preparedStatement.setString(1, entitet.getNaziv());
            java.sql.Time sqlTime = new java.sql.Time(entitet.getVreme().getTime());
            preparedStatement.setTime(2, sqlTime);
            preparedStatement.setInt(3, entitet.getTrajanjePrograma());
            preparedStatement.setInt(4, entitet.getBrojIzvodjaca());
            preparedStatement.setInt(5, entitet.getVrstaPrograma().getId());
            preparedStatement.setLong(6, entitet.getIzvodjac().getId());
            preparedStatement.setInt(7, entitet.getProstor().getId());
            preparedStatement.setInt(8, entitet.getDanProgram().getId());
            preparedStatement.setLong(9, entitet.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi update(Program entitet) u klasi ProgramRepozitorijumImpl" + e.getMessage());
        }
    }

    @Override
    public Program getById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Program> findByQuery(String query) throws Exception {
        List<Program> programi = new ArrayList<>();
        try {
            Connection konekcija = MojaDBKonekcija.getInstance().getConnection();
            Statement statement = konekcija.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nazivPrograma = resultSet.getString("naziv_programa");
                java.sql.Time sqlTime = resultSet.getTime("vreme");
                java.util.Date vreme = new java.util.Date(sqlTime.getTime());
                int trajanjePrograma = resultSet.getInt("trajanje_programa_u_minutima");
                int brojIzvodjaca = resultSet.getInt("broj_izvodjaca");
                int vrstaId = resultSet.getInt("vrsta_id");
                Long izvodjacId = resultSet.getLong("izvodjac_id");
                int prostorId = resultSet.getInt("prostor_id");
                int danProgramId = resultSet.getInt("dan_program_id");
                VrstaPrograma vrstaPrograma = new VrstaPrograma(vrstaId, null);
                Izvodjac izvodjac = new Izvodjac(izvodjacId, null, null, null, null, null);
                Prostor prostor = new Prostor(prostorId, null, 0, null);
                DanProgram danProgram = new DanProgram(danProgramId, null, null);

                Program program = new Program(id, nazivPrograma, vreme, trajanjePrograma, brojIzvodjaca, vrstaPrograma, izvodjac, prostor, danProgram);
                programi.add(program);
            }
            return programi;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Doslo je do greske u metodi findByQuery (Program entitet) u klasi ProgramRepozitorijumImpl" + e.getMessage());
        }
    }

}
