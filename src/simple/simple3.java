package simple;

import java.io.*;

public class simple3 {

    public static void main(String[] args) {
       try(InputStream in = new FileInputStream("fileResult.txt");
           OutputStream out = new FileOutputStream("file777.txt")
       ){

           byte[] sourceArray = new byte[in.available()];

           in.read(sourceArray);

           byte key = '6';

           for (int i = 0; i<sourceArray.length; i++){

               sourceArray[i] = (byte)(sourceArray[i] ^ key);

           }

           /*for (int i = 0; i<sourceArray.length; i++){

               sourceArray[i] = (byte)(sourceArray[i] ^ key);

           }*/

           out.write(sourceArray,0,sourceArray.length);

       }catch (IOException e){
           e.printStackTrace();
       }
    }
}
