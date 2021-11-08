package string_numbers_math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

//Подсчет повторяющихся символов. Написать программу, которая подсчитывает повторяющиеся символы в заданной строке.

public class Task1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Input text: ");
        String text = in.next();
        //System.out.println(countDublicateCharacters(text));
        //System.out.println(countDublicateCharacters2(text));
        System.out.println(countDublicateCharactersSurrogateCouple(text));
    }

    public static Map<Character, Integer> countDublicateCharacters(String text) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }

    public static Map<Character, Long> countDublicateCharacters2(String text) {
        Map<Character, Long> result = text.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return result;
    }

    //с учетом суррогатных пар Unicode
    public static Map<String, Long> countDublicateCharactersSurrogateCouple(String text) {
        Map<String, Long> result = text.codePoints()
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return result;
    }

}
