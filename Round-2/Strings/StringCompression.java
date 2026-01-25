public class StringCompression {
    public static void main(String[] args) {
        String str = "aabbccc";
        String result = findStringCompression(str);
        System.out.println(result);  // Output: a2b2c3
    }

    private static String findStringCompression(String str) {
        int count = 1;
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                result.append(str.charAt(i - 1)).append(count);
                count = 1; 
            } else { 
                count++;
            }
        }

        // append last character group
        result.append(str.charAt(str.length() - 1)).append(count);

        return result.toString();
    }
}
