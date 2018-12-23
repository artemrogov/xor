package cryptosocket;

import stream2.CryptoOutputStream;

import java.io.*;
import java.net.Socket;

public class TCPClientCrypto {

    public static void main(String[] args) {

        byte[] key = "p123ky".getBytes();

        String message = "hello world";

        byte[] msg = message.getBytes();

        try(Socket socket = new Socket("localhost",9000)){

            CryptoOutputStream st = new CryptoOutputStream(socket.getOutputStream(),key);

            st.write(msg);
            st.flush();
            st.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
