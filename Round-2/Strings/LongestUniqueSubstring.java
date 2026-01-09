import java.util.ArrayList;
import java.util.List;

public class LongestUniqueSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int result = findLongestUniqueSubstring(str);
        System.out.println(result);
    }
    
    private static int findLongestUniqueSubstring(String s) {
        int start=0; 
        int end=0;
        int max_Length=0;
        List<Character> list=new ArrayList<>();
        while(end<s.length()){
            if(!list.contains(s.charAt(end))){
                list.add(s.charAt(end));
                end++;
                max_Length=Math.max(max_Length,list.size());
            }
            else{
                list.remove(Character.valueOf(s.charAt(start)));
                start++;
            }
        }
        return max_Length;
    }
}
