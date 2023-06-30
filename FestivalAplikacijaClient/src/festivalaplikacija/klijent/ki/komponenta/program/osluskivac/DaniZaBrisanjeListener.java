package festivalaplikacija.klijent.ki.komponenta.program.osluskivac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class DaniZaBrisanjeListener implements ActionListener{
    List<String> daniZaBrisanje;
    String dan;
    public DaniZaBrisanjeListener(List<String> daniZaBrisanje, String dan) {
        this.daniZaBrisanje = daniZaBrisanje;
        this.dan = dan;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {        
        daniZaBrisanje.add(dan);
        System.out.println("Pozvana je metoda DaniZaBrisanjeListener Za dan: "+dan);
    }
    
}
