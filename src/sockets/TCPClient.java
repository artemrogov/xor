package sockets;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {


        try(
                Socket clientSocket = new Socket("localhost",9000);

                BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
                DataInputStream incoming = new DataInputStream(clientSocket.getInputStream());

                DataOutputStream outgoing = new DataOutputStream(clientSocket.getOutputStream() );

                ){

            System.out.println("Введите свое текстовое сообщение, для отправки на сервер: ");

            String message = keyboardReader.readLine();

            outgoing.writeUTF(message + '\n');

            System.out.println("Server replied: ");

            try {
                String reply = incoming.readUTF();
                System.out.println(reply);
            }catch (EOFException eof){

            }
            clientSocket.close();
            System.out.println("Connection closed gracefully!");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
