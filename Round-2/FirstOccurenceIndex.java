public class FirstOccurenceIndex {
    public static void main(String[] args) {
        String hayStack = "leetcode";
        String needle = "leeto";
        int result = FindThFirstOccurenceIndex(hayStack,needle);
        System.out.println(result);
    } 

    private static int FindThFirstOccurenceIndex(String hayStack, String needle) {
        for(int i=0;i<hayStack.length()-needle.length()+1;i++){
            if(hayStack.charAt(i)==needle.charAt(0)){
                if(hayStack.substring(i, needle.length()+i).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}
