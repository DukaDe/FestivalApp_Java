package festivalaplikacija.zajednicki.domen;

import java.io.Serializable;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Drzava implements Serializable{
    private int id;
    private String naziv;
    private String skraceniNaziv;

    public Drzava() {
    }

    public Drzava(int id, String naziv, String skraceniNaziv) {
        this.id = id;
        this.naziv = naziv;
        this.skraceniNaziv = skraceniNaziv;
    }
    
    public Drzava(String naziv, String skraceniNaziv) {  
        this.naziv = naziv;
        this.skraceniNaziv = skraceniNaziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSkraceniNaziv() {
        return skraceniNaziv;
    }

    public void setSkraceniNaziv(String skraceniNaziv) {
        this.skraceniNaziv = skraceniNaziv;
    }

    @Override
    public String toString() {
        return naziv;
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
        final Drzava other = (Drzava) obj;
        if (!(this.naziv.equalsIgnoreCase(other.getNaziv()))) {
            return false;
        }
        return this.skraceniNaziv.equalsIgnoreCase(other.skraceniNaziv);
    }


    
}
