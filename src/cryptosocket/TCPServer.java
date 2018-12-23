package cryptosocket;

import org.omg.CORBA.portable.InputStream;
import stream2.CryptoInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {

        byte[] key = "p123ky".getBytes();

        try(ServerSocket serverSocket = new ServerSocket(9000)

        ){

           try(Socket socket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(new CryptoInputStream(socket.getInputStream(),key)));
           ){

            String message;
            message = in.readLine();
            System.out.print(message);

           }catch (IOException e){
               e.printStackTrace();
           }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
