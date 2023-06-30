package festivalaplikacija.klijent.ki.komponenta.mojtabelamodel;

import festivalaplikacija.zajednicki.domen.Izvodjac;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class IzvodjacTabelaModel extends AbstractTableModel {

    private final List<Izvodjac> izvodjaci;
    int brojKolona;

    public IzvodjacTabelaModel(List<Izvodjac> izvodjaci, int brojKolona) {
        this.izvodjaci = izvodjaci;
        this.brojKolona = brojKolona;
    }

    @Override
    public int getRowCount() {
        return izvodjaci.size();
    }

    @Override
    public int getColumnCount() {
        if (brojKolona == 3 || brojKolona == 6) {
            return brojKolona;
        } else {
            System.out.println("broj kolona u tabeli Izvodjac mora biti 3 ili 6!");
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Izvodjac izvodjac = izvodjaci.get(rowIndex);
        if (brojKolona == 3) {
            switch (columnIndex) {
                case 0:
                    return izvodjac.getNaziv();
                case 1:
                    return izvodjac.getMesto().getNaziv();
                case 2:
                    return izvodjac.getMesto().getDrzava().getNaziv();
                default:
                    return "n/a";
            }
        }
        if (brojKolona == 6) {
            switch (columnIndex) {
                case 0:
                    return izvodjac.getNaziv();
                case 1:
                    return izvodjac.getMesto().getNaziv();
                case 2:
                    return izvodjac.getMesto().getDrzava().getNaziv();
                case 3:
                    return izvodjac.getKontaktOsoba();
                case 4:
                    return izvodjac.getKontaktelefon();
                case 5:
                    return izvodjac.getEmail();
                default:
                    return "n/a";
            }
        } else {
            return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {

        if (brojKolona == 6) {
            switch (column) {
                case 0:
                    return "Naziv izvodjaca";
                case 1:
                    return "Grad";
                case 2:
                    return "Drzava";
                case 3:
                    return "Kontakt osoba";
                case 4:
                    return "Kontakt telefon";
                case 5:
                    return "email";
                default:
                    return "n/a";
            }
        }
        if (brojKolona == 3) {
            switch (column) {
                case 0:
                    return "Naziv izvodjaca";
                case 1:
                    return "Grad";
                case 2:
                    return "Drzava";
                default:
                    return "n/a";
            }

        }else return "n/a";
    }
}
