/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package festivalaplikacija.server.sesija;

import festivalaplikacija.server.nit.ObradiZahteveKlijenta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milos
 */
public class SesijaServer {

    private static SesijaServer instance;
    private final List<ObradiZahteveKlijenta> korisnici;

    private SesijaServer() {
        this.korisnici = new ArrayList<>();
    }

    public static SesijaServer getInstance() {
        if (instance == null) {
            instance = new SesijaServer();
        }
        return instance;
    }

    public List<ObradiZahteveKlijenta> getKorisnici() {
        return korisnici;
    }

    public void addKorisnik(ObradiZahteveKlijenta korisnik) throws Exception {
        for (ObradiZahteveKlijenta klijent : this.korisnici) {
            if (korisnik.getEmail().equals(klijent.getEmail())) {
                throw new Exception("Korisnik je već ulogovan na sistem");
            }
        }
        korisnici.add(korisnik);
        System.out.println("Klijent: " + korisnik);
//        if(korisnici.contains(korisnik)){
//            throw new Exception("Korisnik je već ulogovan u aplikaciju");
//        } else{
//            korisnici.add(korisnik);
//        }
    }

    public void removeKorisnik(ObradiZahteveKlijenta korisnik) {
        korisnici.remove(korisnik);
    }

}
