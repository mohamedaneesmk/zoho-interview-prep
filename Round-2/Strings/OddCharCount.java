import java.util.HashMap;
import java.util.LinkedHashMap;

public class OddCharCount {
    public static void main(String[] args) {
        String str = "aabbcccdee";
        System.out.println(findOddCharCount(str));
    }

    private static String findOddCharCount(String str) {
        HashMap<Character, Integer> freq = new LinkedHashMap<>();
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
 
        for (char ch : freq.keySet()) {
            if (freq.get(ch) % 2 != 0)
                result.append(ch);
        }

        return result.toString();
    }
}