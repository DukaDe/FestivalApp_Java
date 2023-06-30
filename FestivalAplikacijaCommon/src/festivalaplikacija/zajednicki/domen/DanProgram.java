package festivalaplikacija.zajednicki.domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class DanProgram implements Serializable{
    private int id;
    private String naziv;
    private Date datum;

    public DanProgram() {
    }

    public DanProgram(int id, String naziv, Date datum) {
        this.id = id;
        this.naziv = naziv;
        this.datum = datum;
    }
    
       public DanProgram(String naziv, Date datum) {
        this.naziv = naziv;
        this.datum = datum;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getId() {
        return id;
    }
       
       
}
