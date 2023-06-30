package festivalaplikacija.klijent.operacija;

import festivalaplikacija.klijent.komunikacija.Klijent;
import festivalaplikacija.zajednicki.domen.DanProgram;
import festivalaplikacija.zajednicki.domen.Drzava;
import festivalaplikacija.zajednicki.domen.Izvodjac;
import festivalaplikacija.zajednicki.domen.Mesto;
import festivalaplikacija.zajednicki.domen.Program;
import festivalaplikacija.zajednicki.domen.Prostor;
import festivalaplikacija.zajednicki.domen.VrstaPrograma;
import festivalaplikacija.zajednicki.transfer.Odgovor;
import festivalaplikacija.zajednicki.transfer.Operacija;
import festivalaplikacija.zajednicki.transfer.Zahtev;
import java.util.List;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class ZahtevKlijent {

    public static List<Prostor> getAllProstor() throws Exception {
        Zahtev zahtevProstori = new Zahtev(festivalaplikacija.zajednicki.transfer.Operacija.PROSTOR_GET_ALL);
        Klijent.getInstance().getOutput().writeObject(zahtevProstori);
        Odgovor odgovorProstori = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovorProstori.getException() == null) {
            List<Prostor> prostori = (List<Prostor>) odgovorProstori.getRezultat();
            return prostori;
        } else {
            throw new Exception(odgovorProstori.getException().getMessage());
        }
    }

    public static List<VrstaPrograma> getAllVrstaPrograma() throws Exception {
        Zahtev zahtevVrstaPrograma = new Zahtev(Operacija.VRSTA_PROGRAMA_GET_ALL);
        Klijent.getInstance().getOutput().writeObject(zahtevVrstaPrograma);
        Odgovor odgovorVrstaPrograma = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovorVrstaPrograma.getException() == null) {
            List<VrstaPrograma> vrstePrograma = (List<VrstaPrograma>) odgovorVrstaPrograma.getRezultat();
            return vrstePrograma;
        } else {
            throw new Exception(odgovorVrstaPrograma.getException().getMessage());
        }
    }

    public static List<Izvodjac> getAllIzvodjac() throws Exception {
        Zahtev zahtevIzvodjac = new Zahtev(Operacija.IZVODJAC_GET_ALL);
        Klijent.getInstance().getOutput().writeObject(zahtevIzvodjac);
        Odgovor odgovorIzvodjac = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovorIzvodjac.getException() == null) {
            List<Izvodjac> izvodjaci = (List<Izvodjac>) odgovorIzvodjac.getRezultat();
            return izvodjaci;
        } else {
            throw new Exception(odgovorIzvodjac.getException().getMessage());
        }
    }
    
     public static List<Drzava> getAllDrzava() throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.DRZAVA_GET_ALL);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() == null) {
            List<Drzava> drzave = (List<Drzava>) odgovor.getRezultat();
            return drzave;
        } else {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
     
      public static List<Mesto> getAllMesto() throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.MESTO_GET_ALL);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() == null) {
            List<Mesto> mesta = (List<Mesto>) odgovor.getRezultat();
            return mesta;
        } else {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
      
       public static List<DanProgram> getAllDanProgram() throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.DAN_PROGRAM_GET_ALL);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() == null) {
            List<DanProgram> dani = (List<DanProgram>) odgovor.getRezultat();
            return dani;
        } else {
            throw new Exception(odgovor.getException().getMessage());
        }
    }

    public static List<Prostor> findByQueryProstor(String upit) throws Exception {
        List<Prostor> prostori;
        Zahtev zahtev = new Zahtev(festivalaplikacija.zajednicki.transfer.Operacija.PROSTOR_FIND_BY_QUERY, upit);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() == null) {
            prostori = (List<Prostor>) odgovor.getRezultat();
            return prostori;
        } else {
            throw new Exception(odgovor.getException().getMessage());
        }
    }

    public static List<Program> findByQueryProgrami(String upit) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.PROGRAM_FIND_BY_QUERY, upit);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() == null) {
            List<Program> programi = (List<Program>) odgovor.getRezultat();
            return programi;
        } else {
            throw new Exception(odgovor.getException().getMessage());
        }
    }

    public static List<Program> findByDayProgrami(String danNaziv) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.PROGRAM_FIND_BY_DAY, danNaziv);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() == null) {
            List<Program> programiPoDanu = (List<Program>) odgovor.getRezultat();
            return programiPoDanu;
        } else {
            throw new Exception(odgovor.getException().getMessage());
        }
    }

    public static List<VrstaPrograma> findByQueryVrstaPrograma(String upit) throws Exception {
        List<VrstaPrograma> vrstePrograma;
        Zahtev zahtev = new Zahtev(festivalaplikacija.zajednicki.transfer.Operacija.VRSTA_PROGRAMA_FIND_BY_QUERY, upit);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() == null) {
            vrstePrograma = (List<VrstaPrograma>) odgovor.getRezultat();
            return vrstePrograma;
        } else {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
    
    public static List<Izvodjac> findByQueryIzvodjac(String upit) throws Exception {
        List<Izvodjac> izvodjaci;
        Zahtev zahtev = new Zahtev(festivalaplikacija.zajednicki.transfer.Operacija.IZVODJAC_FIND_BY_QUERY, upit);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() == null) {
            izvodjaci = (List<Izvodjac>) odgovor.getRezultat();
            return izvodjaci;
        } else {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
    
     public static List<Mesto> findByQueryMesto(String upit) throws Exception {
        List<Mesto> mesta;
        Zahtev zahtev = new Zahtev(festivalaplikacija.zajednicki.transfer.Operacija.MESTO_FIND_BY_QUERY, upit);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() == null) {
            mesta = (List<Mesto>) odgovor.getRezultat();
            return mesta;
        } else {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
     
     public static List<Drzava> findByNameDrzava(Drzava drzava) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.DRZAVA_FIND_BY_NAME, drzava);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() == null) {
            List<Drzava> drzave = (List<Drzava>) odgovor.getRezultat();
            return drzave;
        } else {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
     
     public static List<DanProgram> findByQueryDanProgram(String upit) throws Exception {
        List<DanProgram> dani;
        Zahtev zahtev = new Zahtev(festivalaplikacija.zajednicki.transfer.Operacija.DAN_PROGRAM_FIND_BY_QUERY, upit);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() == null) {
            dani = (List<DanProgram>) odgovor.getRezultat();
            return dani;
        } else {
            throw new Exception(odgovor.getException().getMessage());
        }
    }

    public static void addVrstaPrograma(VrstaPrograma vrstaPrograma) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.VRSTA_PROGRAMA_ADD, vrstaPrograma);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() != null) {
            throw new Exception(odgovor.getException().getMessage());
        }
    }

    public static void addProstor(Prostor prostor) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.PROSTOR_ADD, prostor);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() != null) {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
    
    public static void addDrzava(Drzava drzava) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.DRZAVA_ADD, drzava);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() != null) {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
    
    public static void addIzvodjac(Izvodjac izvodjac) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.IZVODJAC_ADD, izvodjac);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() != null) {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
    
    public static void addProgram(Program program) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.PROGRAM_ADD, program);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() != null) {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
    
    public static void addDanProgram(DanProgram danProgram) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.DAN_PROGRAM_ADD, danProgram);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() != null) {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
    
    public static void addMesto(Mesto mesto) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.MESTO_ADD, mesto);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() != null) {
            throw new Exception(odgovor.getException().getMessage());
        }
    }

    public static void updateProstor(Prostor prostor) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.PROSTOR_UPDATE, prostor);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() != null) {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
    
     public static void updateVrstaPrograma(VrstaPrograma vrstaPrograma) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.VRSTA_PROGRAMA_UPDATE, vrstaPrograma);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() != null) {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
     
      public static void updateDrzava(Drzava drzava) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.DRZAVA_UPDATE, drzava);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() != null) {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
      
      public static void updateIzvodjac(Izvodjac izvodjac) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.IZVODJAC_UPDATE, izvodjac);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() != null) {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
      
       public static void updateMesto(Mesto mesto) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.MESTO_UPDATE, mesto);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() != null) {
            throw new Exception(odgovor.getException().getMessage());
        }
    }
       
        public static void updateProgram(Program program) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.PROGRAM_UPDATE, program);
        Klijent.getInstance().getOutput().writeObject(zahtev);
        Odgovor odgovor = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovor.getException() != null) {
            throw new Exception(odgovor.getException().getMessage());
        }
    }

    public static void deleteProstor(Prostor prostor) throws Exception {
        Zahtev zahtevZaBrisanje = new Zahtev(Operacija.PROSTOR_DELETE, prostor);
        Klijent.getInstance().getOutput().writeObject(zahtevZaBrisanje);
        Odgovor odgovorZaBrisanje = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovorZaBrisanje.getException() != null) {
            throw new Exception(odgovorZaBrisanje.getException().getMessage());
        }
    }

    public static void deleteProgram(Program program) throws Exception {
        Zahtev zahtevZaBrisanje = new Zahtev(Operacija.PROGRAM_DELETE, program);
        Klijent.getInstance().getOutput().writeObject(zahtevZaBrisanje);
        Odgovor odgovorZaBrisanje = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovorZaBrisanje.getException() != null) {
            throw new Exception(odgovorZaBrisanje.getException().getMessage());
        }
    }


    public static void deleteVrstePrograma(VrstaPrograma vrstaPrograma) throws Exception {
        Zahtev zahtevZaBrisanje = new Zahtev(Operacija.VRSTA_PROGRAMA_DELETE, vrstaPrograma);
        Klijent.getInstance().getOutput().writeObject(zahtevZaBrisanje);
        Odgovor odgovorZaBrisanje = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovorZaBrisanje.getException() != null) {
            throw new Exception(odgovorZaBrisanje.getException().getMessage());
        }
    }
    
    public static void deleteDrzava(Drzava drzava) throws Exception {
        Zahtev zahtevZaBrisanje = new Zahtev(Operacija.DRZAVA_DELETE, drzava);
        Klijent.getInstance().getOutput().writeObject(zahtevZaBrisanje);
        Odgovor odgovorZaBrisanje = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovorZaBrisanje.getException() != null) {
            throw new Exception(odgovorZaBrisanje.getException().getMessage());
        }
    }
    
    public static void deleteIzvodjac(Izvodjac izvodjac) throws Exception {
        Zahtev zahtevZaBrisanje = new Zahtev(Operacija.IZVODJAC_DELETE, izvodjac);
        Klijent.getInstance().getOutput().writeObject(zahtevZaBrisanje);
        Odgovor odgovorZaBrisanje = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovorZaBrisanje.getException() != null) {
            throw new Exception(odgovorZaBrisanje.getException().getMessage());
        }
    }
    
     public static void deleteMesto(Mesto mesto) throws Exception {
        Zahtev zahtevZaBrisanje = new Zahtev(Operacija.MESTO_DELETE, mesto);
        Klijent.getInstance().getOutput().writeObject(zahtevZaBrisanje);
        Odgovor odgovorZaBrisanje = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovorZaBrisanje.getException() != null) {
            throw new Exception(odgovorZaBrisanje.getException().getMessage());
        }
    }
     
     public static void deleteDanProgram(DanProgram danProgram) throws Exception {
        Zahtev zahtevZaBrisanje = new Zahtev(Operacija.DAN_PROGRAM_DELETE, danProgram);
        Klijent.getInstance().getOutput().writeObject(zahtevZaBrisanje);
        Odgovor odgovorZaBrisanje = (Odgovor) Klijent.getInstance().getInput().readObject();
        if (odgovorZaBrisanje.getException() != null) {
            throw new Exception(odgovorZaBrisanje.getException().getMessage());
        }
    }

}
