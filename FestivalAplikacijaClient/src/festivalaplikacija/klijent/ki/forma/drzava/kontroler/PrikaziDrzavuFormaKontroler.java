package festivalaplikacija.klijent.ki.forma.drzava.kontroler;

import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.klijent.ki.komponenta.mojtabelamodel.DrzavaTabelaModel;
import festivalaplikacija.klijent.operacija.ZahtevKlijent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class PrikaziDrzavuFormaKontroler {
    
    public static void pripremiFormu(JTable tblDrzavaPrikaz) throws Exception{
        postaviModelTabele(tblDrzavaPrikaz);
    }

    private static void postaviModelTabele(JTable tblDrzavaPrikaz) throws Exception {
          try {
            List<Drzava> drzave = getAll();
            AbstractTableModel tabelaModel = new DrzavaTabelaModel(drzave);
            tblDrzavaPrikaz.setModel(tabelaModel);
            tblDrzavaPrikaz.setVisible(true);
            
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private static List<Drzava> getAll() throws Exception{
        try {
            return ZahtevKlijent.getAllDrzava();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }      
    }
}
