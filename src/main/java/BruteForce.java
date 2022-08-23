
import java.util.Scanner;

public class BruteForce extends Decoder {
    Scanner scanner = new Scanner(System.in);
    boolean flag = false;
    public String force(String phrase) {
        String rightPhrase = "";
        System.out.println("Введите максимальное значение ключа");
        int maxKeyValue = scanner.nextInt();
        for (int i = 0; i < maxKeyValue; i++) {
            if(flag == true)
                break;
            char[] charArray = decipher(phrase, i).toCharArray();
            for (char ch : charArray) {
                if (ch == signs.get(7) && ((charArray[charArray.length-1] == '!') || (charArray[charArray.length-1] == '.') || (charArray[charArray.length-1] == '?'))){
                    rightPhrase = decipher(phrase, i);
                    flag = true;
                    break;
                }
            }
        }
        return rightPhrase;
    }
}
