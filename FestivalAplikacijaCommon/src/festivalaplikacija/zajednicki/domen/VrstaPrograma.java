package festivalaplikacija.zajednicki.domen;

import java.io.Serializable;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class VrstaPrograma implements Serializable{
    private int id;
    private String naziv;

    public VrstaPrograma() {
    }

    public VrstaPrograma(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
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

    @Override
    public String toString() {
        return "VrstaPrograma{" + "id=" + id + ", naziv=" + naziv + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final VrstaPrograma other = (VrstaPrograma) obj;
        return this.id == other.id;
    }
    
    
}
