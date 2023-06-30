package festivalaplikacija.klijent.ki.komponenta.mojtabelamodel;

import festivalaplikacija.zajednicki.domen.Mesto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class MestoTabelaModel extends AbstractTableModel {

    private final List<Mesto> mesta;

    public MestoTabelaModel(List<Mesto> mesta) {
        this.mesta = mesta;
    }

    @Override
    public int getRowCount() {
        if (mesta == null) {
            return 0;
        } else {
            return mesta.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mesto mesto = mesta.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mesto.getId();
            case 1:
                return mesto.getPtt();
            case 2:
                return mesto.getNaziv();
            case 3:
                return mesto.getDrzava().getNaziv();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "PTT";
            case 2:
                return "Naziv";
            case 3:
                return "Drzava";
            default:
                return "n/a";
        }

    }
}
