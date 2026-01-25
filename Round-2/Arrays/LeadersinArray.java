public class LeadersinArray {
    public static void main(String[] args) {
        int[] nums = { 16, 17, 4, 3, 5, 2 };
        String leaders = findLeaders(nums);
        System.out.println(leaders);
    }

    public static String findLeaders(int[] nums) {
        int max = Integer.MIN_VALUE;
        StringBuilder result = new StringBuilder();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (max < nums[i]) {
                max = nums[i];
                result.insert(0, max + " "); 
            }
        }

        return result.toString();
    }

}