package stream2;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


public class CryptoInputStream extends FilterInputStream {

    private byte[] passwordArray;
    private int position = 0;


    public CryptoInputStream(InputStream in, byte[] passwordArray) {
        super(in);
        this.passwordArray = passwordArray;
    }

    @Override
    public int read() throws IOException {
        int buffer = super.read();
        buffer = buffer ^ passwordArray[position % passwordArray.length];
        position++;
        return buffer;
    }

    @Override
    public int read(byte[] data, int off, int len) throws  IOException {

        int result = super.read(data, off, len);
        for(int i=off;i<off+len;i++){
            data[i] = (byte) (data[i]^passwordArray[position % passwordArray.length]);
            position++;
        }
        return result;
    }
}
