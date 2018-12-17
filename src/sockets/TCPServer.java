package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {
       try(ServerSocket serverSocket = new ServerSocket(9000)){

           String message = null;

           while(!"STOP".equals(message)){
               System.out.println("Waiting for connection ...");

               try(Socket connectionSocket = serverSocket.accept();
                   DataInputStream incoming = new DataInputStream(connectionSocket.getInputStream());
                   DataOutputStream outgoing = new DataOutputStream(connectionSocket.getOutputStream())){

                   System.out.println("Waiting for message ....");

                   message = incoming.readUTF().trim();

                   System.out.println("Клиент написал: " + message);

                   outgoing.writeUTF("Сервер получил и прочитал сообщение от клиента! \n");

                   if ("STOP".equals(message)){

                       outgoing.writeUTF("SERVER CLOSING DOWN\n");

                       outgoing.close();
                   }
               }catch (IOException e){
                   e.printStackTrace();
               }
           }

       }catch (IOException e){
           e.printStackTrace();

       }


    }
}
