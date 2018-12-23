package simple;

public class Simple {

    public static void main(String[] args) {

        String message = "Шифрование строчки символов";

        String encodeMessage = "";
        String decodeMessage = "";

        String key ="789";

        int keyLength = key.length();
        int msgLength = message.length();

        int j = 0;

        System.out.println("Оригинальное сообщение: " + message);

        for (int i = 0; i<msgLength; i++){

            encodeMessage = encodeMessage + (char)(message.charAt(i) ^ key.charAt(j));
            j++;
            if (j==keyLength){
                j = 0;
            }
        }

        System.out.println("Зашифрованное сообщение: " + encodeMessage);

        j = 0;

        for (int i = 0; i<msgLength; i++){

            decodeMessage = decodeMessage + (char)(encodeMessage.charAt(i) ^ key.charAt(j));
            j++;

            if (j==keyLength){
                j = 0;
            }

        }

        System.out.println("Расшифрованное сообщение: " + decodeMessage);


        System.out.println("------------------Method:-----------------------------");

        String strMess = encodeMessage("Hello world!","wer123");

        System.out.println(strMess);

        System.out.println("=============================================================");
        String decode = decodeMessage(strMess,"wer123");

        System.out.println(decode);


    }

    private static String encodeMessage(String message, String key){

        int keyLength = key.length();
        int msgLength = message.length();

        String encodeMessage = "";

        int j = 0;

        for (int i = 0; i<msgLength; i++){
            encodeMessage = encodeMessage + (char)(message.charAt(i) ^ key.charAt(j));
            j++;

            if (j==keyLength){
                j = 0;
            }

        }
        return encodeMessage;
    }

    private static String decodeMessage(String message, String key){
        String decodeMsg = "";
        int j = 0;
        int keyLength = key.length();
        int msgLength = message.length();


        for (int i = 0; i<msgLength; i++){
            decodeMsg = decodeMsg + (char)(message.charAt(i) ^ key.charAt(j));

            j++;

            if (j==keyLength){
                j = 0;
            }


        }
        return decodeMsg;
    }



}
