class SplitStringsToMakePalindrome{
    public static void main(String[] args){
        String a = "abc";
        String b = "def";
        System.out.println(checkPalindromeFormation(a, b));
    }    

    private static boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private static boolean check(String a, String b){
        int left = 0;
        int right = a.length() - 1;

        while(left < right && a.charAt(left) == b.charAt(right)){
            left++;
            right--;
        }

        return isPalindrome(a, left, right) || isPalindrome(b, left, right);
    }

    private static boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }

        return true;
    }
}