
import java.util.ArrayList;


public class Coder {
    ArrayList<Character> signs = new ArrayList<>();
    public String cipher(String phrase, int offset) {
        char[] signsArray = new char[]{'.', ',', '”', ':', '-', '!', '?', ' '};
        for (char ch :signsArray) {
            signs.add(ch);
        }
        StringBuilder result = new StringBuilder();
        for (char character : phrase.toCharArray()) {
            if (!signs.contains(character)) {
                if (!Character.isUpperCase(character)) {
                    int originalAlphabetPosition = character - 'а';
                    int newAlphabetPosition = (originalAlphabetPosition + offset) % 32;
                    char newCharacter = (char) ('а' + newAlphabetPosition);
                    result.append(newCharacter);
                } else {
                    int originalAlphabetPosition = character - 'А';
                    int newAlphabetPosition = (originalAlphabetPosition + offset) % 32;
                    char newCharacter = (char) ('А' + newAlphabetPosition);
                    result.append(newCharacter);
                }
            } else {
                int index = signs.indexOf(character);
                int newIndex = (index + offset) % 8;
                char newCharacter = signs.get(newIndex);
                result.append(newCharacter);
            }
        }
        return result.toString();
    }
}