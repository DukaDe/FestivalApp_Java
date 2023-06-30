package festivalaplikacija.server.nit;

import festivalaplikacija.server.ki.komponenta.servertabelamodel.ServerTabelaModel;
import festivalaplikacija.server.sesija.SesijaServer;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class AktivniKorisnici extends Thread{
    
    private final JTable tblUlogovaniKorisnici;

    public AktivniKorisnici(JTable tblUlogovaniKorisnici) {
        this.tblUlogovaniKorisnici = tblUlogovaniKorisnici;
    }

    @Override
    public void run() {
        while(!isInterrupted()){
            List<ObradiZahteveKlijenta> korisnici = SesijaServer.getInstance().getKorisnici();
            TableModel model = new ServerTabelaModel(korisnici);
            tblUlogovaniKorisnici.setModel(model);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Nit je uspesno prekinuta");
            }
        }
    }
    
    
}
