package festivalaplikacija.klijent.ki.forma.mesto.kontroler;

import festivalaplikacija.zajednicki.domen.Mesto;
import festivalaplikacija.klijent.ki.komponenta.mojtabelamodel.MestoTabelaModel;
import festivalaplikacija.klijent.operacija.ZahtevKlijent;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class PrikaziMestoFormaKontroler {

    public static void popuniTabelu(JTable tblPrikaziMesto) throws Exception {
        try {
            List<Mesto> mesta = ZahtevKlijent.getAllMesto();
            MestoTabelaModel mestoTabelaModel = new MestoTabelaModel(mesta);
            tblPrikaziMesto.setModel(mestoTabelaModel);
            tblPrikaziMesto.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
}
