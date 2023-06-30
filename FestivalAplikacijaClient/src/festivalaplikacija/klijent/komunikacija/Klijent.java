package festivalaplikacija.klijent.komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Klijent {
    private static Klijent instance;
    private final Socket socket;
    private final ObjectOutputStream output;
    private final ObjectInputStream input;

    private Klijent() throws IOException {
        socket = new Socket("localhost", 9000);
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream()); 
    }
    
    public static Klijent getInstance() throws IOException{
        if (instance == null) instance = new Klijent();
        return instance;
    }

    public ObjectOutputStream getOutput() {
        return output;
    }

    public ObjectInputStream getInput() {
        return input;
    }
    
    
    
    
}
