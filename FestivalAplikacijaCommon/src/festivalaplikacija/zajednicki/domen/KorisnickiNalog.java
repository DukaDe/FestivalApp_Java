package festivalaplikacija.zajednicki.domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class KorisnickiNalog implements Serializable{
    private String email;
    private String password;
    private Zaposleni zaposleni;
    private List<Uloga>uloge;

    public KorisnickiNalog() {
        uloge = new ArrayList<>();
    }

    public KorisnickiNalog(String email, String password, Zaposleni zaposleni, List<Uloga> uloge) {
        this.email = email;
        this.password = password;
        this.zaposleni = zaposleni;
        this.uloge = uloge;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public List<Uloga> getUloge() {
        return uloge;
    }

    public void setUloge(List<Uloga> uloge) {
        this.uloge = uloge;
    }

    @Override
    public String toString() {
        return "KorisnickiNalog{" + "email=" + email + ", password=" + password + ", zaposleni=" + zaposleni + ", uloge=" + uloge + '}';
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
        final KorisnickiNalog other = (KorisnickiNalog) obj;
        return Objects.equals(this.email, other.email);
    }
    
    
    
   
}
