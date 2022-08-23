import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        String symbols = "";
        String result = "";
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        Scanner scanner = new Scanner(System.in);
        Coder coder = new Coder();
        Decoder decoder = new Decoder();
        BruteForce bruteForce = new BruteForce();
        {
            try {
                bufferedReader = new BufferedReader(new FileReader("src/StartPhrase.txt"));
                while (bufferedReader.ready()) {
                    symbols = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Введите число: 1 - закодировать фразу, 2 - раскодировать фразу, 3 - взлом фразы");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Введите ключ шифра:");
                int codeKey = scanner.nextInt();
                result = coder.cipher(symbols, codeKey);
                break;
            case 2:
                System.out.println("Введите ключ шифра:");
                int encodeKey = scanner.nextInt();
                result = decoder.decipher(symbols, encodeKey);
                break;
            case 3:
                result = bruteForce.force(symbols);
                break;
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("FinalResult.txt"));
            bufferedWriter.write(result);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

