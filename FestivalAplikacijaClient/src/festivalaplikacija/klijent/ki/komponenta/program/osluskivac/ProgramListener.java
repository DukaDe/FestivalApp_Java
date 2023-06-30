package festivalaplikacija.klijent.ki.komponenta.program.osluskivac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class ProgramListener implements ActionListener{

    JDialog dialog;

    public ProgramListener(JDialog dialog) {
        this.dialog = dialog;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
}
