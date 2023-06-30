package festivalaplikacija.zajednicki.domen;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Izvodjac implements Serializable{
    private Long id;
    private String naziv;
    private String kontaktOsoba;
    private String email;
    private String kontaktelefon;
    private Mesto mesto;

    public Izvodjac() {
    }

    public Izvodjac(Long id, String naziv, String kontaktOsoba, String email, String kontaktelefon, Mesto mesto) {
        this.id = id;
        this.naziv = naziv;
        this.kontaktOsoba = kontaktOsoba;
        this.email = email;
        this.kontaktelefon = kontaktelefon;
        this.mesto = mesto;
    }
    
    public Izvodjac(String naziv, String kontaktOsoba, String email, String kontaktelefon, Mesto mesto) {
        this.naziv = naziv;
        this.kontaktOsoba = kontaktOsoba;
        this.email = email;
        this.kontaktelefon = kontaktelefon;
        this.mesto = mesto;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKontaktOsoba() {
        return kontaktOsoba;
    }

    public void setKontaktOsoba(String kontaktOsoba) {
        this.kontaktOsoba = kontaktOsoba;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKontaktelefon() {
        return kontaktelefon;
    }

    public void setKontaktelefon(String kontaktelefon) {
        this.kontaktelefon = kontaktelefon;
    }

    @Override
    public String toString() {
        return "Izvodjac{" + "id=" + id + ", naziv=" + naziv + ", kontaktOsoba=" + kontaktOsoba + ", email=" + email + ", kontaktelefon=" + kontaktelefon + ", mesto=" + mesto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Izvodjac other = (Izvodjac) obj;
        if (!(this.naziv.equalsIgnoreCase(other.naziv))) {
            return false;
        }
        return Objects.equals(this.mesto, other.mesto);
    }

 
    
}
