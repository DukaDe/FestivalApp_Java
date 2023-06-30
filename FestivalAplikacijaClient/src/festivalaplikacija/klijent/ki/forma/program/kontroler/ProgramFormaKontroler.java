package festivalaplikacija.klijent.ki.forma.program.kontroler;

import festivalaplikacija.klijent.ki.komponenta.program.osluskivac.DaniZaBrisanjeListener;
import festivalaplikacija.klijent.ki.komponenta.program.osluskivac.ProgramListener;
import festivalaplikacija.klijent.ki.komponenta.program.panel.MojPanelDanProgram;
import festivalaplikacija.klijent.komunikacija.Klijent;
import festivalaplikacija.klijent.operacija.ZahtevKlijent;
import festivalaplikacija.zajednicki.domen.DanProgram;
import festivalaplikacija.zajednicki.domen.Program;
import festivalaplikacija.zajednicki.transfer.Odgovor;
import festivalaplikacija.zajednicki.transfer.Operacija;
import festivalaplikacija.zajednicki.transfer.Zahtev;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class ProgramFormaKontroler {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.");

    public static void dodajDan(JDialog dialog, JPanel panel) {
        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public static void obrisiDan(List<String> daniZaBrisanje, JDialog programForma, JPanel pnlPrikazDana, JButton btnDodajDan,
            JPanel pnlObrisiDan) {
        try {
            if (daniZaBrisanje.isEmpty()) {
                throw new Exception("Niste selektovali dan za brisanje!");
            } else {
                int j = JOptionPane.showConfirmDialog(programForma, "Da li ste sigurni da zelite da obrisete dane/e iz baze?", "brisanje podataka", JOptionPane.WARNING_MESSAGE);
                if (j == 0) {
                    for (String dan : daniZaBrisanje) {
                        String upit = "SELECT * FROM dan_program WHERE naziv_dana = '" + dan + "'";

                        List<DanProgram> danPrograma = ZahtevKlijent.findByQueryDanProgram(upit);
                        if (danPrograma.isEmpty()) {
                            throw new Exception("Došlo je do greške prilikom brisanja dana iz baze, pokušate ponovo!");
                        }
                        DanProgram danProgramaZaBrisanje = danPrograma.get(0);
                        System.out.println("Dan za brisanje: " + danProgramaZaBrisanje.getNaziv());
                        ZahtevKlijent.deleteDanProgram(danProgramaZaBrisanje);
                    }
                    JOptionPane.showMessageDialog(programForma, "Uspesno ste obrisali dane iz baze");
                    pripremiFormu(pnlPrikazDana, btnDodajDan, programForma, pnlObrisiDan, daniZaBrisanje);
                    daniZaBrisanje.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(programForma, e.getMessage());
        }

    }

    public static void pripremiFormu(JPanel pnlPrikazDana, JButton btnDodajDan, JDialog programForma, JPanel pnlObrisiDan, List<String> daniZaBrisanje) throws Exception {
        popuniDaneZaBrisanje(pnlObrisiDan, daniZaBrisanje);
        popuniDane(pnlPrikazDana, programForma);
        pnlPrikazDana.setEnabled(true);
        btnDodajDan.setEnabled(true);
    }

    private static void popuniDane(JPanel pnlPrikazDana, JDialog programForma) throws Exception {
        pnlPrikazDana.removeAll();
        System.out.println("Pozvana je metoda popuniDane");
        try {
            List<DanProgram> daniFestivala = ZahtevKlijent.getAllDanProgram();
            for (DanProgram danProgram : daniFestivala) {
                System.out.println("Dan id: " + danProgram.getId() + ", " + danProgram.getNaziv());
                JButton button = new JButton(danProgram.getNaziv() + " - " + dateFormat.format(danProgram.getDatum()));
                Font font = new Font("Segoe UI", Font.BOLD, 19);
                button.setFont(font);
                pnlPrikazDana.add(button);
                List<Program> programi = findByDayProgrami(danProgram.getNaziv());
                JDialog dialog = new JDialog(programForma, false);
                MojPanelDanProgram panel = new MojPanelDanProgram(programi, dialog, danProgram);
                dialog.add(panel);
                dialog.pack();
                ProgramListener programListener = new ProgramListener(dialog);
                button.addActionListener(programListener);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static List<Program> findByDayProgrami(String danNaziv) throws Exception {
        List<Program> programiPoDanu = ZahtevKlijent.findByDayProgrami(danNaziv);
        return programiPoDanu;
    }

    private static void popuniDaneZaBrisanje(JPanel pnlObrisiDan, List<String> daniZaBrisanje) throws Exception {
        try {
            pnlObrisiDan.removeAll();
            List<DanProgram> daniFestivala = ZahtevKlijent.getAllDanProgram();
            for (DanProgram danProgram : daniFestivala) {
                JCheckBox checkBox = new JCheckBox();
                checkBox.setText(danProgram.getNaziv());
                pnlObrisiDan.add(checkBox);
                DaniZaBrisanjeListener listener = new DaniZaBrisanjeListener(daniZaBrisanje, danProgram.getNaziv());
                checkBox.addActionListener(listener);
                System.out.println("Popunjen je dan za brisanje" + danProgram.getNaziv());
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
