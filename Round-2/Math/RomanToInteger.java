import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String input = "III";
        int result = findRomanToInteger(input);
        System.out.println(result);
    }

    private static int findRomanToInteger(String input) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        // Start from the last character
        int result = romanMap.get(input.charAt(input.length() - 1));

        // Traverse from second last to first
        for (int i = input.length() - 2; i >= 0; i--) {
            int current = romanMap.get(input.charAt(i));
            int next = romanMap.get(input.charAt(i + 1));

            // If smaller value before larger → subtract
            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}
    