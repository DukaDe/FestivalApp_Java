package festivalaplikacija.zajednicki.transfer;

import java.io.Serializable;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Odgovor implements Serializable{
    private Object rezultat;
    private Exception exception;

    public Odgovor() {
    }

    public Odgovor(Object rezultat, Exception exception) {
        this.rezultat = rezultat;
        this.exception = exception;
    }

    public Object getRezultat() {
        return rezultat;
    }

    public void setRezultat(Object rezultat) {
        this.rezultat = rezultat;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
    
    
}
