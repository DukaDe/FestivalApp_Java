package festivalaplikacija.server.repozitorijum.konekcija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class MojaDBKonekcija {

    private static MojaDBKonekcija instance;
    private final Connection konekcija;

    private MojaDBKonekcija() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/undp_kalejski_dusan";
        String user = "root";
        String password = "DukaDeNiro1004";
        konekcija = DriverManager.getConnection(url, user, password);
    }

    public static MojaDBKonekcija getInstance() throws SQLException {
        if (instance == null) {
            instance = new MojaDBKonekcija();
        }
        return instance;
    }
    
    public Connection getConnection (){
        return konekcija;
    }
    
    public void closeConnection() throws SQLException{
        if(konekcija != null){
            konekcija.close();
        }
    }
}
