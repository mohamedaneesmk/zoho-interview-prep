<<<<<<< HEAD:Round-2/CheckAnagram.java
class CheckAnagram {
    public static void main(String[] args) {
        String input1 = "aabbcd";
        String input2 = "abcdba"; 
        boolean isAnagram = findAnagram(input1, input2);
        System.out.println(isAnagram);  // Expected output: true
    }

    private static boolean findAnagram(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }

        int[] freq = new int[26];  // Only for lowercase letters a-z 

        for (int i = 0; i < input1.length(); i++) {
            freq[input1.charAt(i) - 'a']++;
            freq[input2.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
=======
class CheckAnagram {
    public static void main(String[] args) {
        String input1 = "aabbcd";
        String input2 = "abcdba";
        
        boolean isAnagram = findAnagram(input1, input2);
        System.out.println(isAnagram);  // Expected output: true
    }

    private static boolean findAnagram(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }

        int[] freq = new int[26];  // Only for lowercase letters a-z 

        for (int i = 0; i < input1.length(); i++) {
            freq[input1.charAt(i) - 'a']++;
            freq[input2.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
>>>>>>> b84da99 (patch work):CheckAnagram.java
