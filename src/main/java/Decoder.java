
public class Decoder extends Coder{
    String decipher(String phrase, int offset) {
         return cipher(phrase, (32 - (offset % 32)));
    }
}