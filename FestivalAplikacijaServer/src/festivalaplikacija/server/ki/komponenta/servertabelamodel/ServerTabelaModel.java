package festivalaplikacija.server.ki.komponenta.servertabelamodel;

import festivalaplikacija.server.nit.ObradiZahteveKlijenta;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class ServerTabelaModel extends AbstractTableModel {

    private List<ObradiZahteveKlijenta> klijenti;
    private DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    
    public ServerTabelaModel(List<ObradiZahteveKlijenta> klijenti){
        this.klijenti = klijenti;
    }

    @Override
    public int getRowCount() {
        if (klijenti != null) {
            return klijenti.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ObradiZahteveKlijenta klijent = klijenti.get(rowIndex);
            switch(columnIndex){
                case 0:
                    return klijent.getImeKlijenta();
                case 1:
                    return df.format(klijent.getVremeLogovanja());
                default: 
                    return "n/a";
            }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
                case 0:
                    return "Ime klijenta";
                case 1:
                    return "Vreme logovanja";
                default: 
                    return "n/a";
            }
    }

    
}
