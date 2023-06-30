package festivalaplikacija.server.nit;

import festivalaplikacija.server.kontroler.Kontroler;
import festivalaplikacija.server.sesija.SesijaServer;
import festivalaplikacija.zajednicki.domen.DanProgram;
import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.zajednicki.domen.Izvodjac;
import festivalaplikacija.zajednicki.domen.KorisnickiNalog;
import festivalaplikacija.zajednicki.domen.Mesto;
import festivalaplikacija.zajednicki.domen.Program;
import festivalaplikacija.zajednicki.domen.Prostor;
import festivalaplikacija.zajednicki.domen.VrstaPrograma;
import festivalaplikacija.zajednicki.transfer.Odgovor;
import festivalaplikacija.zajednicki.transfer.Zahtev;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class ObradiZahteveKlijenta extends Thread {

    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private boolean signal;
    private String imeKlijenta;
    private Date vremeLogovanja;
    private String email;

    public ObradiZahteveKlijenta(Socket socket) {
        try {
            this.socket = socket;
            this.output = new ObjectOutputStream(this.socket.getOutputStream());
            this.input = new ObjectInputStream(this.socket.getInputStream());
            this.signal = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (signal && !isInterrupted()) {
            try {
                Zahtev zahtev = (Zahtev) input.readObject();
                Odgovor odgovor = new Odgovor();
                try {
                    switch (zahtev.getOperacija()) {
                        case LOGIN:
                            KorisnickiNalog korisnickiNalog = (KorisnickiNalog) zahtev.getArgument();
                            KorisnickiNalog korisnickiNalogUlogovan = (KorisnickiNalog) Kontroler.getInstance().login(korisnickiNalog);
                            this.imeKlijenta = korisnickiNalogUlogovan.getZaposleni().getIme() + " " + korisnickiNalogUlogovan.getZaposleni().getPrezime();
                            this.vremeLogovanja = new Date();
                            this.email = korisnickiNalogUlogovan.getEmail();
                            SesijaServer.getInstance().addKorisnik(this);
                            odgovor.setRezultat(korisnickiNalogUlogovan);
                            break;
                        case DRZAVA_ADD:
                            Drzava drzavaAdd = (Drzava) zahtev.getArgument();
                            Kontroler.getInstance().addDrzava(drzavaAdd);
                            break;
                        case DRZAVA_UPDATE:
                            Drzava drzavaUpdate = (Drzava) zahtev.getArgument();
                            Kontroler.getInstance().updateDrzava(drzavaUpdate);
                            break;
                        case DRZAVA_DELETE:
                            Drzava drzavaDelete = (Drzava) zahtev.getArgument();
                            Kontroler.getInstance().deleteDrzava(drzavaDelete);
                            break;
                        case DRZAVA_GET_ALL:
                            List<Drzava> drzaveGetAll = Kontroler.getInstance().getAllDrzava();
                            odgovor.setRezultat(drzaveGetAll);
                            break;
                        case DRZAVA_FIND_BY_NAME:
                            Drzava drzava = (Drzava) zahtev.getArgument();
                            List<Drzava> drzaveFindByName = Kontroler.getInstance().findByNameDrzava(drzava);
                            odgovor.setRezultat(drzaveFindByName);
                            break;
                        case MESTO_ADD:
                            Mesto mestoAdd = (Mesto) zahtev.getArgument();
                            Kontroler.getInstance().addMesto(mestoAdd);
                            break;
                        case MESTO_GET_ALL:
                            List<Mesto> mestaGetAll = Kontroler.getInstance().getAllMesto();
                            odgovor.setRezultat(mestaGetAll);
                            break;
                        case MESTO_UPDATE:
                            Mesto mestoUpdate = (Mesto) zahtev.getArgument();
                            Kontroler.getInstance().updateMesto(mestoUpdate);
                            break;
                        case MESTO_DELETE:
                            Mesto mestoDelete = (Mesto) zahtev.getArgument();
                            Kontroler.getInstance().deleteMesto(mestoDelete);
                            break;
                        case IZVODJAC_GET_ALL:
                            List<Izvodjac> izvodjaciGetAll = Kontroler.getInstance().getAllIzvodjac();
                            odgovor.setRezultat(izvodjaciGetAll);
                            break;
                        case IZVODJAC_ADD:
                            Izvodjac izvodjacAdd = (Izvodjac) zahtev.getArgument();
                            Kontroler.getInstance().addIzvodjac(izvodjacAdd);
                            break;
                        case IZVODJAC_FIND_BY_QUERY:
                            String upitFindByQueryIzvodjac = (String) zahtev.getArgument();
                            List<Izvodjac> izvodjaci = Kontroler.getInstance().findByQueryIzvodjac(upitFindByQueryIzvodjac);
                            odgovor.setRezultat(izvodjaci);
                            break;
                        case IZVODJAC_DELETE:
                            Izvodjac izvodjacDelete = (Izvodjac) zahtev.getArgument();
                            Kontroler.getInstance().deleteIzvodjac(izvodjacDelete);
                            break;
                        case IZVODJAC_UPDATE:
                            Izvodjac izvodjacUpdate = (Izvodjac) zahtev.getArgument();
                            Kontroler.getInstance().updateIzvodjac(izvodjacUpdate);
                            break;
                        case MESTO_FIND_BY_QUERY:
                            String upitFindByQueryMesto = (String) zahtev.getArgument();
                            List<Mesto> mesta = Kontroler.getInstance().findByQueryMesto(upitFindByQueryMesto);
                            odgovor.setRezultat(mesta);
                            break;
                        case DAN_PROGRAM_ADD:
                            DanProgram danProgramAdd = (DanProgram) zahtev.getArgument();
                            Kontroler.getInstance().addDanProgram(danProgramAdd);
                            break;
                        case DAN_PROGRAM_GET_ALL:
                            List<DanProgram> danProgramaGetAll = Kontroler.getInstance().getAllDanPrograma();
                            odgovor.setRezultat(danProgramaGetAll);
                            break;
                        case DAN_PROGRAM_DELETE:
                            DanProgram danProgramDelete = (DanProgram) zahtev.getArgument();
                            Kontroler.getInstance().deleteDanProgram(danProgramDelete);
                            break;
                        case DAN_PROGRAM_FIND_BY_QUERY:
                            String upit = (String) zahtev.getArgument();
                            List<DanProgram> danProgramaFindByQuery = Kontroler.getInstance().findByQueryDanProgram(upit);
                            odgovor.setRezultat(danProgramaFindByQuery);
                            break;
                        case PROGRAM_ADD:
                            Program programAdd = (Program) zahtev.getArgument();
                            Kontroler.getInstance().addProgram(programAdd);
                            break;
                        case PROGRAM_GET_ALL:
                            List<Program> programiGetAll = Kontroler.getInstance().getAllProgram();
                            odgovor.setRezultat(programiGetAll);
                            break;
                        case PROGRAM_FIND_BY_DAY:
                            String danNaziv = (String) zahtev.getArgument();
                            List<Program> programiFindByDay = Kontroler.getInstance().findByDayProgrami(danNaziv);
                            odgovor.setRezultat(programiFindByDay);
                            break;
                        case PROGRAM_UPDATE:
                            Program programUpdate = (Program) zahtev.getArgument();
                            Kontroler.getInstance().updateProgram(programUpdate);
                            break;
                        case PROGRAM_DELETE:
                            Program programDelete = (Program) zahtev.getArgument();
                            Kontroler.getInstance().deleteProgram(programDelete);
                            break;
                        case PROGRAM_FIND_BY_QUERY:
                            String upitProgramFindByQuery = (String) zahtev.getArgument();
                            List<Program> programi = Kontroler.getInstance().findByQueryProgram(upitProgramFindByQuery);
                            odgovor.setRezultat(programi);
                            break;
                        case VRSTA_PROGRAMA_GET_ALL:
                            List<VrstaPrograma> vrstaProgramaGetAll = Kontroler.getInstance().getAllVrstaPrograma();
                            odgovor.setRezultat(vrstaProgramaGetAll);
                            break;
                        case VRSTA_PROGRAMA_ADD:
                            VrstaPrograma vrstaProgramaAdd = (VrstaPrograma) zahtev.getArgument();
                            Kontroler.getInstance().addVrstaPrograma(vrstaProgramaAdd);
                            break;
                        case VRSTA_PROGRAMA_DELETE:
                            VrstaPrograma vrstaProgramaDelete = (VrstaPrograma) zahtev.getArgument();
                            Kontroler.getInstance().deleteVrstaPrograma(vrstaProgramaDelete);
                            break;
                        case VRSTA_PROGRAMA_UPDATE:
                            VrstaPrograma vrstaProgramaUpdate = (VrstaPrograma) zahtev.getArgument();
                            Kontroler.getInstance().updateVrstaPrograma(vrstaProgramaUpdate);
                            break;
                        case VRSTA_PROGRAMA_FIND_BY_QUERY:
                            String upitFindByQueryVrstaPrograma = (String) zahtev.getArgument();
                            List<VrstaPrograma> vrstePrograma = Kontroler.getInstance().findByQueryVrstaPrograma(upitFindByQueryVrstaPrograma);
                            odgovor.setRezultat(vrstePrograma);
                            break;
                        case PROSTOR_FIND_BY_QUERY:
                            String upitFindByQueryProstor = (String) zahtev.getArgument();
                            List<Prostor> prostori = Kontroler.getInstance().findByQueryProstor(upitFindByQueryProstor);
                            odgovor.setRezultat(prostori);
                            break;
                        case PROSTOR_GET_ALL:
                            List<Prostor> prostoriGetAll = Kontroler.getInstance().getAllProstor();
                            odgovor.setRezultat(prostoriGetAll);
                            break;
                        case PROSTOR_GET_BY_ID:
                            int id = (int) zahtev.getArgument();
                            Prostor prostorGetById = Kontroler.getInstance().getByIdProstor(id);
                            odgovor.setRezultat(prostorGetById);
                            break;
                        case PROSTOR_ADD:
                            Prostor prostorAdd = (Prostor) zahtev.getArgument();
                            Kontroler.getInstance().addProstor(prostorAdd);
                            break;
                        case PROSTOR_UPDATE:
                            Prostor prostorUpdate = (Prostor) zahtev.getArgument();
                            Kontroler.getInstance().updateProstor(prostorUpdate);
                            break;
                        case PROSTOR_DELETE:
                            Prostor prostorDelete = (Prostor) zahtev.getArgument();
                            Kontroler.getInstance().deleteProstor(prostorDelete);
                            break;
                        case END:
                            SesijaServer.getInstance().removeKorisnik(this);
                            interrupt();
                            break;
                    }
                } catch (Exception e) {
                    odgovor.setException(e);
                    System.out.println("GRESKA: " + e.getMessage());

                }
                output.writeObject(odgovor);
            } catch (Exception e) {

//                e.printStackTrace();
            }
        }
        System.out.println("Za klijenta: " + getImeKlijenta() + " konekcija je zavrsena");
    }

    public void zavrsiSesiju() throws IOException {
        socket.close();
    }

    public String getImeKlijenta() {
        return imeKlijenta;
    }

    public void setImeKlijenta(String imeKlijenta) {
        this.imeKlijenta = imeKlijenta;
    }

    public Date getVremeLogovanja() {
        return vremeLogovanja;
    }

    public void setVremeLogovanja(Date vremeLogovanja) {
        this.vremeLogovanja = vremeLogovanja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.socket);
        hash = 43 * hash + Objects.hashCode(this.imeKlijenta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ObradiZahteveKlijenta other = (ObradiZahteveKlijenta) obj;
        if (!Objects.equals(this.imeKlijenta, other.imeKlijenta)) {
            return false;
        }
        return Objects.equals(this.socket, other.socket);
    }

    @Override
    public String toString() {
        return "ObradiZahteveKlijenta{" + "imeKlijenta=" + imeKlijenta + ", vremeLogovanja=" + vremeLogovanja + '}';
    }

}
