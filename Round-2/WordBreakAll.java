import java.util.*;

public class WordBreakAll {

    public static List<String> wordBreak(String s, List<String> dict) {
        Set<String> wordSet = new HashSet<>(dict);
        Map<String, List<String>> memo = new HashMap<>();

        return dfs(s, wordSet, memo);
    }

    private static List<String> dfs(String s, Set<String> dict,
                                    Map<String, List<String>> memo) {

        if (memo.containsKey(s))
            return memo.get(s);

        List<String> result = new ArrayList<>();

        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);

            if (dict.contains(prefix)) {
                List<String> suffixWays =
                        dfs(s.substring(i), dict, memo);

                for (String way : suffixWays) {
                    result.add(prefix + (way.isEmpty() ? "" : " " + way));
                }
            }
        }

        memo.put(s, result);
        return result;
    }

    public static void main(String[] args) {

        String s1 = "likegfg";
        List<String> dict1 = Arrays.asList("lik", "like", "egfg", "gfg");

        System.out.println(wordBreak(s1, dict1));

        String s2 = "geeksforgeeks";
        List<String> dict2 = Arrays.asList("for", "geeks");
 
        System.out.println(wordBreak(s2, dict2));
    }
}
