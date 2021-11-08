import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Подсчет повторяющихся символов. Написать программу, которая подсчитывает повторяющиеся символы в заданной строке.

public class Task1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Input text: ");
        String text = in.next();
        System.out.println(countDublicateCharacters(text));
    }

    public static Map<Character, Integer> countDublicateCharacters(String text) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }
}
