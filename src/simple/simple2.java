package simple;

import stream2.CryptoInputStream;
import stream2.CryptoOutputStream;

import java.io.*;

public class simple2 {
    public static void main(String[] args) {

        byte[] passArr;

        String key = "password";

        passArr = key.getBytes();


       /* try(OutputStream out = new CryptoOutputStream(new FileOutputStream("file2.txt"),passArr);
            InputStream in = new CryptoInputStream(new FileInputStream("file.txt"),passArr)
        ){

            byte[] msg = new byte[in.available()];

            while((in.read(msg) >0)){
                out.write(msg);
            }

        }catch (IOException e){
            e.printStackTrace();
        }*/


        try(InputStream in = new CryptoInputStream(new FileInputStream("file2.txt"),passArr);
            OutputStream out = new CryptoOutputStream(new FileOutputStream("result.txt"),passArr)
        ){

            byte[] msg = new byte[in.available()];




        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
