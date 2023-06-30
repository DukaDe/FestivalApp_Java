package festivalaplikacija.server.komunikacija;

import festivalaplikacija.server.nit.ObradiZahteveKlijenta;
import festivalaplikacija.server.sesija.SesijaServer;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Server extends Thread {

    private ServerSocket serverSocket;

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(9000);
            while (!isInterrupted()) {
                System.out.println("Ceka se konekcija");
                Socket socket = serverSocket.accept();
                System.out.println("");
                System.out.println("Konekcija je uspostavljena");
                obradiKlijentskiZahtev(socket);
            }
            serverSocket.close();
        } catch (Exception e) {
            System.out.println("Server je zaustavljen");
        }
    }

    public void stopServer() {
        try {
            for (ObradiZahteveKlijenta klijent : SesijaServer.getInstance().getKorisnici()) {
                try {
                    klijent.interrupt();
                    klijent.zavrsiSesiju();
                } catch (Exception e) {
                    System.out.println("Završena konekcija "+e.getMessage());
                }

            }
            interrupt();
            serverSocket.close();
        } catch (Exception ex) {
            System.out.println("Server je zaustavljen");
        }
    }

    private void obradiKlijentskiZahtev(Socket socket) {
        ObradiZahteveKlijenta obradiZahteveKlijenta = new ObradiZahteveKlijenta(socket);
        obradiZahteveKlijenta.start();
    }
}
