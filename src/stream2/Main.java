package stream2;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        String key = "pass123";

        byte[] passKey = key.getBytes();


        try(CryptoInputStream in2 = new CryptoInputStream(new FileInputStream("resultCrypto.txt"),passKey)){

            byte[] msg2 = new byte[in2.available()];

            in2.read(msg2,0,msg2.length);

            for (byte i: msg2){
                System.out.print((char)i);
            }

        }catch (IOException e){
            e.printStackTrace();
        }



    }
}
