package festivalaplikacija.zajednicki.domen;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Program implements Serializable {

    private Long id;
    private String naziv;
    private Date vreme;
    private int trajanjePrograma;
    private int brojIzvodjaca;
    private VrstaPrograma vrstaPrograma;
    private Izvodjac izvodjac;
    private Prostor prostor;
    private DanProgram danProgram;

    public Program() {
    }

    public Program(Long id, String naziv, Date vreme, int trajanjePrograma, int brojIzvodjaca, VrstaPrograma vrstaPrograma,
            Izvodjac izvodjac, Prostor prostor, DanProgram danProgram) {
        this.id = id;
        this.naziv = naziv;
        this.vreme = vreme;
        this.trajanjePrograma = trajanjePrograma;
        this.brojIzvodjaca = brojIzvodjaca;
        this.vrstaPrograma = vrstaPrograma;
        this.izvodjac = izvodjac;
        this.prostor = prostor;
        this.danProgram = danProgram;
    }
    public Program(String naziv, Date vreme, int trajanjePrograma, int brojIzvodjaca, VrstaPrograma vrstaPrograma,
            Izvodjac izvodjac, Prostor prostor, DanProgram danProgram) {
        this.naziv = naziv;
        this.vreme = vreme;
        this.trajanjePrograma = trajanjePrograma;
        this.brojIzvodjaca = brojIzvodjaca;
        this.vrstaPrograma = vrstaPrograma;
        this.izvodjac = izvodjac;
        this.prostor = prostor;
        this.danProgram = danProgram;
    }

    public Prostor getProstor() {
        return prostor;
    }

    public void setProstor(Prostor prostor) {
        this.prostor = prostor;
    }

    public VrstaPrograma getVrstaPrograma() {
        return vrstaPrograma;
    }

    public void setVrstaPrograma(VrstaPrograma vrstaPrograma) {
        this.vrstaPrograma = vrstaPrograma;
    }

    public Izvodjac getIzvodjac() {
        return izvodjac;
    }

    public void setIzvodjac(Izvodjac izvodjac) {
        this.izvodjac = izvodjac;
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

    public int getTrajanjePrograma() {
        return trajanjePrograma;
    }

    public void setTrajanjePrograma(int trajanjePrograma) {
        this.trajanjePrograma = trajanjePrograma;
    }

    public int getBrojIzvodjaca() {
        return brojIzvodjaca;
    }

    public void setBrojIzvodjaca(int brojIzvodjaca) {
        this.brojIzvodjaca = brojIzvodjaca;
    }

    public Date getVreme() {
        return vreme;
    }

    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }

    public DanProgram getDanProgram() {
        return danProgram;
    }

    public void setDanProgram(DanProgram danProgram) {
        this.danProgram = danProgram;
    }

    @Override
    public String toString() {
        return "Program{" + "id=" + id + ", naziv=" + naziv + ", datumIVreme=" + vreme + ", trajanjePrograma=" + trajanjePrograma + ", brojIzvodjaca=" + brojIzvodjaca + ", vrstaPrograma=" + vrstaPrograma + ", izvodjac=" + izvodjac + ", prostor=" + prostor + '}';
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
        final Program other = (Program) obj;
        return Objects.equals(this.id, other.id);
    }

}
