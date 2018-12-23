package simple;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class decode {


    public static void main(String[] args) {


        try(InputStream in = new FileInputStream("file777.txt")){

            byte[] msg = new byte[in.available()];
            byte key = '6';

            in.read(msg);

             for (int i = 0; i<msg.length; i++){

               msg[i] = (byte)(msg[i] ^ key);

           }

             for (int j:msg){
                 System.out.print((char)j);
             }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
