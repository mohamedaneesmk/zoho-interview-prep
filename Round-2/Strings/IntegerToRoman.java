public class IntegerToRoman {
    public static void main(String[] args) {
        int num1 = 4;
        int num2 = 58;
        int num3 = 1994;

        System.out.println(num1 + " -> " + intToRoman(num1)); // Output: MMMDCCXLIX
        System.out.println(num2 + " -> " + intToRoman(num2)); // Output: LVIII
        System.out.println(num3 + " -> " + intToRoman(num3)); // Output: MCMXCIV
    }

    private static String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder roman = new StringBuilder();

        for (int index = 0; index < values.length; index++) {
            while (num >= values[index]) {
                num -= values[index];
                roman.append(symbols[index]);
            }
        }

        return roman.toString();
    }
}
