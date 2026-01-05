public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "abcabcd";
        char result = findFirstNonRepeatingCharacter(str);
        System.out.println(result);
    }

    public static Character findFirstNonRepeatingCharacter(String input){
        int length = input.length();
        if(length <= 1)
            return null; 
        int[] count = new int[256];
        
        for(int i=0;i<length;i++){
            count[input.charAt(i)]++;
        }

        for(int i=0;i<length;i++){
            if(count[input.charAt(i)]==1)
                return input.charAt(i);
        }

        return null;
    }
}
