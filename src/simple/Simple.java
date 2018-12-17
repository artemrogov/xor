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


    }
}
