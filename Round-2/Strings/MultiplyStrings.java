public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "3";

        System.out.println(multiplyStrings(num1, num2));
    }

    private static String multiplyStrings(String num1, String num2) {
        // If any number is 0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length(); 
        int n = num1.length();
        int[] result = new int[m + n];

        // Multiply Each digit
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = multiply + result[i + j + 1];

                result[i + j + 1] = sum % 10; // store digit
                result[i + j] = result[i + j] / 10; // carry
            }
        }

        // Convert result array to string
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : result) {
            if (!(stringBuilder.length() == 0 && num == 0)) {
                stringBuilder.append(num);
            }
        }

        return stringBuilder.toString();
    }
}
