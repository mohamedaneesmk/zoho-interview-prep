public class NumberToWords {
    private static final String[] belowTen = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    };
    private static final String[] belowTwenty = {
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fiveteen", "Sixteen", "Seventeen", "Eightteen",
            "Nineteen"
    };
    private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    private static final String[] thousands = {
            "", "Thousand", "Million", "Billion"
    };

    private static String numberToWords(int number) {
        if (number == 0)
            return "Zero";

        int index = 0;
        String result = "";

        while (number > 0) {
            int part = number % 1000;

            if (part != 0) {
                result = helper(part) + thousands[index] + " " + result;
            }

            number = number / 1000;
            index++;
        }

        return result.trim();
    }

    // Converts numbers from 1 to 999
    private static String helper(int num) {
        if (num == 0)
            return "";
        if (num < 10)
            return belowTen[num] + "";
        if (num < 20)
            return belowTwenty[num - 10] + "";
        if (num < 100)
            return tens[num / 10] + " " + helper(num % 10);

        return belowTen[num / 100] + " Hundred " + helper(num % 100);
    }

    public static void main(String[] args) {
        int number = 123;
        System.out.println(numberToWords(number));
    }

}
