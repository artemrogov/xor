package stream2;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CryptoOutputStream extends FilterOutputStream {

    private byte[] passwordArray;
    private int position = 0;

    public CryptoOutputStream(OutputStream out, byte[] passwordArray) {
        super(out);
        this.passwordArray = passwordArray;
    }

    @Override
    public void write(int b) throws IOException {
        b = b^passwordArray[position % passwordArray.length];
        position++;
        super.write(b);
    }

}
