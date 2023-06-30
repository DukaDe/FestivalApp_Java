package festivalaplikacija.zajednicki.domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Zaposleni implements Serializable{
    private int id;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String kontaktTelefon;
    private String ulicaIBroj;
    private Mesto mesto;
    private Pozicija pozicija;

    public Zaposleni() {
    }

    public Zaposleni(int id, String ime, String prezime, Date datumRodjenja, String kontaktTelefon, String ulicaIBroj, Mesto mesto, Pozicija pozicija) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.kontaktTelefon = kontaktTelefon;
        this.ulicaIBroj = ulicaIBroj;
        this.mesto = mesto;
        this.pozicija = pozicija;
    }

    public Pozicija getPozicija() {
        return pozicija;
    }

    public void setPozicija(Pozicija pozicija) {
        this.pozicija = pozicija;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public String getUlicaIBroj() {
        return ulicaIBroj;
    }

    public void setUlicaIBroj(String ulicaIBroj) {
        this.ulicaIBroj = ulicaIBroj;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return "Zaposleni{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", datumRodjenja=" + datumRodjenja + ", kontaktTelefon=" + kontaktTelefon + ", ulicaIBroj=" + ulicaIBroj + ", mesto=" + mesto + ", pozicija=" + pozicija + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Zaposleni other = (Zaposleni) obj;
        return this.id == other.id;
    }


    
    
}
