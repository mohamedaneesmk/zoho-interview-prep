// import java.util.ArrayList;
// import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "pwwkew";
        int result = lengthOfLongestSubstring(str);
        System.out.println(result);
    }

    private static int lengthOfLongestSubstring(String str) {

        /*
         * int start = 0;
         * int end = 0;
         * int maxLength = 0;
         * List<Character> list = new ArrayList<>();
         * 
         * while(end < str.length()){
         * if(!list.contains(str.charAt(end))){
         * list.add(str.charAt(end));
         * end++;
         * maxLength = Math.max(list.size(), maxLength);
         * }
         * else{
         * list.remove(Character.valueOf(str.charAt(start)));
         * start++;
         * }
         * }
         * 
         * return maxLength;
         */

        // Using HashSet - Optimized Solution
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < str.length(); right++) {
            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }

            set.add(str.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
