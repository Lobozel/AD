package FicheroSerializado;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 
 * @author MiguelÁngel
 *
 */

public class MiObjectOutputStream extends ObjectOutputStream {
    
    protected void writeStreamHeader() throws IOException {
        
    }
    
    public MiObjectOutputStream() throws IOException {
        super();
    }

    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
}
