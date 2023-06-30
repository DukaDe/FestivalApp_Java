package festivalaplikacija.klijent.ki.komponenta.mojtabelamodel;

import festivalaplikacija.klijent.operacija.ZahtevKlijent;
import festivalaplikacija.zajednicki.domen.DanProgram;
import festivalaplikacija.zajednicki.domen.Izvodjac;
import festivalaplikacija.zajednicki.domen.Program;
import festivalaplikacija.zajednicki.domen.Prostor;
import festivalaplikacija.zajednicki.domen.VrstaPrograma;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class ProgramTabelaModel extends AbstractTableModel {

    private final List<Program> programi;
    private final String[] kolone = {"Naziv programa", "Izvođač", "Vreme početka", "Trajanje", "Broj izvodjaca", "Vrsta programa", "Prostor"};
    SimpleDateFormat dateFormat;
    DanProgram dan;

    public ProgramTabelaModel(List<Program> programi, DanProgram dan) {
        this.programi = programi;
        this.dateFormat = new SimpleDateFormat("HH:mm");
        this.dan = dan;
    }

    @Override
    public int getRowCount() {
        return programi.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Program program = programi.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return program.getNaziv();
            case 1:
                return program.getIzvodjac().getNaziv();
            case 2:
                return dateFormat.format(program.getVreme());
            case 3:
                return program.getTrajanjePrograma();
            case 4:
                return program.getBrojIzvodjaca();
            case 5:
                return program.getVrstaPrograma().getNaziv();
            case 6:
                return program.getProstor().getNaziv();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return kolone[0];
            case 1:
                return kolone[1];
            case 2:
                return kolone[2];
            case 3:
                return kolone[3];
            case 4:
                return kolone[4];
            case 5:
                return kolone[5];
            case 6:
                return kolone[6];
            default:
                return "n/a";
        }
    }

    public void addRow(int rowSelected) throws Exception {
        fireTableDataChanged();
        Izvodjac izvodjac = ZahtevKlijent.getAllIzvodjac().get(0);
        Prostor prostor = ZahtevKlijent.getAllProstor().get(0);
        VrstaPrograma vrstaPrograma = ZahtevKlijent.getAllVrstaPrograma().get(0);
        Program program = new Program("-", new Date(), 0, 0, vrstaPrograma, izvodjac, prostor, dan);
        try {
            ZahtevKlijent.addProgram(program);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        if (rowSelected == -1) {
            programi.add(program);
        } else {
            programi.add((rowSelected + 1), program);
        }
        this.fireTableDataChanged();
    }

    public void deleteRow(int rowSelected) throws Exception {
        if (rowSelected == -1) {
            throw new Exception("Niste selektovali nijedan red!");
        } else {
            programi.remove(rowSelected);
        }
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0: {
                try {
                    programi.get(rowIndex).setNaziv(value.toString());
                    System.out.println("Posle: " + programi.get(rowIndex));
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println(ex.getMessage());
                }
                break;
            }

            case 1: {
                try {
                    Izvodjac izvodjac;
                    String upit = "SELECT * from izvodjac WHERE naziv_izvodjaca= '" + value.toString() + "'";
                    List<Izvodjac> izvodjaci = ZahtevKlijent.findByQueryIzvodjac(upit);
                    izvodjac = izvodjaci.get(0);
                    programi.get(rowIndex).setIzvodjac(izvodjac);
                    System.out.println("Posle: " + programi.get(rowIndex));
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println(ex.getMessage());
                }
                break;
            }

            case 2: 
                try {
                Date date = dateFormat.parse(value.toString());
                programi.get(rowIndex).setVreme(date);
                System.out.println("Posle: " + programi.get(rowIndex));
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
            break;

            case 3: 
                try {
                int trajanjePrograma = Integer.parseInt(value.toString());
                programi.get(rowIndex).setTrajanjePrograma(trajanjePrograma);
                System.out.println("Posle: " + programi.get(rowIndex));
            } catch (Exception e) {
            }
            break;

            case 4:
                try {
                int brojIzvodjaca = Integer.parseInt(value.toString());
                programi.get(rowIndex).setBrojIzvodjaca(brojIzvodjaca);
                System.out.println("Posle: " + programi.get(rowIndex));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            break;

            case 5:
                try {
                VrstaPrograma vrstaPrograma;
                String upit = "SELECT * from vrsta_programa WHERE naziv= '" + value.toString() + "'";

                List<VrstaPrograma> vrstePrograma = ZahtevKlijent.findByQueryVrstaPrograma(upit);
                vrstaPrograma = vrstePrograma.get(0);

                programi.get(rowIndex).setVrstaPrograma(vrstaPrograma);
                System.out.println("Posle: " + programi.get(rowIndex));
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
            break;

            case 6: {
                try {
                    Prostor prostor;
                    String upit = "SELECT * from prostor WHERE naziv_prostora= '" + value.toString() + "'";

                    List<Prostor> prostori = ZahtevKlijent.findByQueryProstor(upit);
                    prostor = prostori.get(0);
                    programi.get(rowIndex).setProstor(prostor);
                    System.out.println("Posle: " + programi.get(rowIndex));
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println(ex.getMessage());
                }
                break;
            }
        }
    }

    public void updateProgram(Program program) throws Exception {
        System.out.println("Program u update metodi: " + program);
        if (program.getId() == null) {
            return;
        }
        ZahtevKlijent.updateProgram(program);
        System.out.println("Uspesno je izmenjen program");
    }

}
