package festivalaplikacija.zajednicki.transfer;

import java.io.Serializable;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Zahtev implements Serializable{
    private Operacija operacija;
    private Object argument;

    public Zahtev(Operacija operacija, Object argument) {
        this.operacija = operacija;
        this.argument = argument;
    }

    public Zahtev(Operacija operacija) {
        this.operacija = operacija;
    }

    public Operacija getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacija operacija) {
        this.operacija = operacija;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }
    
    
}
