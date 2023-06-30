package festivalaplikacija.klijent.ki.komponenta.mojtabelamodel;

import festivalaplikacija.zajednicki.domen.Drzava;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class DrzavaTabelaModel extends AbstractTableModel {

    private final List<Drzava> drzave;

    public DrzavaTabelaModel(List<Drzava> drzave) {
        this.drzave = drzave;
    }

    @Override
    public int getRowCount() {
        if (drzave == null) {
            return 0;
        }
        return drzave.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Drzava drzava = drzave.get(rowIndex);
        if (columnIndex == 0) {
            return drzava.getId();
        }
        if (columnIndex == 1) {
            return drzava.getNaziv();
        }
        if (columnIndex == 2) {
            return drzava.getSkraceniNaziv();
        }
        return "n/a";
         
    }

@Override
public String getColumnName(int column) {

        if (column == 0) {
            return "id";
        }
        if (column == 1) {
            return "Naziv";
        }
        if (column == 2) {
            return "Skraceni naziv";
        }
        return "n/a";
    }

}
