/*
    Given an integer array nums, find the subarray with the largest sum, and return its sum.

    Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.

    Example 2:
    Input: nums = [1]
    Output: 1
    Explanation: The subarray [1] has the largest sum 1.

    Example 3:
    Input: nums = [5,4,-1,7,8]
    Output: 23
    Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 
 */

/*class MaxSubArray {
    public static void main(String[] args) {
        // int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // int[] nums = {1};
        int[] nums = {5, 4, -1, 7, 8};
        int result = findMaxSubArray(nums);
        System.out.println(result);
    } 

    private static int findMaxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}*/

// To Print Subarray as well
public class MaxSubArray { 
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // int[] nums = {1};
        // int[] nums = {5, 4, -1, 7, 8};
        int result = findMaxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result);
    }

    private static int findMaxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
                tempStart = i;
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        System.out.print("Subarray with maximum sum: [");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i]);
            if (i < end) System.out.print(", ");
        }
        System.out.println("]");

        return maxSum;
    }
}