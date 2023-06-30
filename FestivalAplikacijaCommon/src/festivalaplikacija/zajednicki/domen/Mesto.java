package festivalaplikacija.zajednicki.domen;

import java.io.Serializable;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Mesto implements Serializable{
    private int id;
    private int ptt;
    private String naziv;
    private Drzava drzava;

    public Mesto() {
    }
    
    public Mesto(int ptt, String naziv, Drzava drzava) {
        this.ptt = ptt;
        this.naziv = naziv;
        this.drzava = drzava;
    }

    public Mesto(int id, int ptt, String naziv, Drzava drzava) {
        this.id = id;
        this.ptt = ptt;
        this.naziv = naziv;
        this.drzava = drzava;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPtt() {
        return ptt;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }

    @Override
    public String toString() {
        return ptt +" "+ naziv;
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
        final Mesto other = (Mesto) obj;
        if (!(this.ptt == other.getPtt())) {
            return false;
        }
        return this.drzava.getNaziv().equalsIgnoreCase(other.getDrzava().getNaziv());
    }
    
    
}
