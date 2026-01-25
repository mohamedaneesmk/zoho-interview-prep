public class ArrayMaxNumber {
    public static void main(String[] args) {
        int[] nums = {8, 7, 9, 1};
        String maxNumber = findArrayMaxNumber(nums);
        System.out.println("Maximum Number Formed: " + maxNumber);
    } 

    public static String findArrayMaxNumber(int[] nums) {
        int[] count = new int[10]; 
        for (int num : nums) {
            count[num]++; 
        }

        StringBuilder result = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (count[i] > 0) {
                result.append(i);
                count[i]--;
            }
        }

        return result.toString();
    }
}
