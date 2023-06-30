package festivalaplikacija.zajednicki.domen;

import java.io.Serializable;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Prostor implements Serializable{
    private int id;
    private String naziv;
    private int kapacitet;
    private VrstaProstora vrstaProstora;

    public Prostor() {
    }

    public Prostor(int id, String naziv, int kapacitet, VrstaProstora vrstaProstora ) {
        this.id = id;
        this.naziv = naziv;
        this.kapacitet = kapacitet;
        this.vrstaProstora = vrstaProstora;
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

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public VrstaProstora getVrstaProstora() {
        return vrstaProstora;
    }

    public void setVrstaProstora(VrstaProstora vrstaProstora) {
        this.vrstaProstora = vrstaProstora;
    }

    @Override
    public String toString() {
        return naziv + ", kapacitet=" + kapacitet + ", vrstaProstora=" + vrstaProstora;
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
        final Prostor other = (Prostor) obj;
        return this.id == other.id;
    }
    
    
}
