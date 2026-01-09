import java.util.HashSet;

public class JewlsAndStones {
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aeAAe";
        int count = findJewlsAndStones(jewels, stones);
        System.out.println(count); 
    }

    private static int findJewlsAndStones(String jewels, String stones) {
        HashSet<Character> mySet = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            mySet.add(jewel);
        }

        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (mySet.contains(stone)) {
                count++;
            }
        }
        return count;
    }
}
