package festivalaplikacija.zajednicki.domen;

import java.io.Serializable;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Pozicija implements Serializable{
    private int id;
    private String naziv;

    public Pozicija() {
    }

    public Pozicija(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pozicija{" + "id=" + id + ", naziv=" + naziv + '}';
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
        final Pozicija other = (Pozicija) obj;
        return this.id == other.id;
    }
    
    
}
