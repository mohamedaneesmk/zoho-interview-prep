import java.util.*;

class Solution {
    // OPTIMAL SOLUTION: O(n) time, O(1) space
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Step 1: Mark presence by negating values at corresponding indices
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Get the index (0-based)

            // Mark as visited by making it negative
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Step 2: Find indices with positive values (unmarked = missing numbers)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // Convert index back to number (1-based)
            }
        }

        return result;
    }

    // ALTERNATIVE SOLUTION 1: Using HashSet - O(n) time, O(n) space
    public List<Integer> findDisappearedNumbersHashSet(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();

        // Add all numbers to set
        for (int num : nums) {
            numSet.add(num);
        }

        // Check which numbers from 1 to n are missing
        for (int i = 1; i <= nums.length; i++) {
            if (!numSet.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    // ALTERNATIVE SOLUTION 2: Using Boolean Array - O(n) time, O(n) space
    public List<Integer> findDisappearedNumbersBoolean(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] present = new boolean[nums.length + 1];

        // Mark present numbers
        for (int num : nums) {
            present[num] = true;
        }

        // Find missing numbers
        for (int i = 1; i <= nums.length; i++) {
            if (!present[i]) {
                result.add(i);
            }
        }

        return result;
    }
}

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("=== Test Case 1 ===");
        int[] nums1 = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Expected Output: [5, 6]");

        // Make copies since optimal solution modifies the array
        int[] nums1Copy1 = nums1.clone();
        int[] nums1Copy2 = nums1.clone();
        int[] nums1Copy3 = nums1.clone();

        System.out.println("Optimal Solution: " + solution.findDisappearedNumbers(nums1Copy1));
        System.out.println("HashSet Solution: " + solution.findDisappearedNumbersHashSet(nums1Copy2));
        System.out.println("Boolean Solution: " + solution.findDisappearedNumbersBoolean(nums1Copy3));

        // Test Case 2
        System.out.println("\n=== Test Case 2 ===");
        int[] nums2 = { 1, 1 };
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Expected Output: [2]");

        int[] nums2Copy1 = nums2.clone();
        int[] nums2Copy2 = nums2.clone();
        int[] nums2Copy3 = nums2.clone();

        System.out.println("Optimal Solution: " + solution.findDisappearedNumbers(nums2Copy1));
        System.out.println("HashSet Solution: " + solution.findDisappearedNumbersHashSet(nums2Copy2));
        System.out.println("Boolean Solution: " + solution.findDisappearedNumbersBoolean(nums2Copy3));

        // Test Case 3: All numbers present
        System.out.println("\n=== Test Case 3 ===");
        int[] nums3 = { 1, 2, 3, 4, 5 };
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Expected Output: []");

        int[] nums3Copy1 = nums3.clone();
        int[] nums3Copy2 = nums3.clone();
        int[] nums3Copy3 = nums3.clone();

        System.out.println("Optimal Solution: " + solution.findDisappearedNumbers(nums3Copy1));
        System.out.println("HashSet Solution: " + solution.findDisappearedNumbersHashSet(nums3Copy2));
        System.out.println("Boolean Solution: " + solution.findDisappearedNumbersBoolean(nums3Copy3));

        // Test Case 4: All same number
        System.out.println("\n=== Test Case 4 ===");
        int[] nums4 = { 2, 2, 2, 2, 2 };
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Expected Output: [1, 3, 4, 5]");

        int[] nums4Copy1 = nums4.clone();
        int[] nums4Copy2 = nums4.clone();
        int[] nums4Copy3 = nums4.clone();

        System.out.println("Optimal Solution: " + solution.findDisappearedNumbers(nums4Copy1));
        System.out.println("HashSet Solution: " + solution.findDisappearedNumbersHashSet(nums4Copy2));
        System.out.println("Boolean Solution: " + solution.findDisappearedNumbersBoolean(nums4Copy3));

        // Performance comparison
        System.out.println("\n=== Performance Comparison ===");
        int[] largeArray = new int[100000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (i % 50000) + 1; // Creates duplicates
        }

        long startTime, endTime;

        // Optimal solution
        int[] largeCopy1 = largeArray.clone();
        startTime = System.nanoTime();
        List<Integer> result1 = solution.findDisappearedNumbers(largeCopy1);
        endTime = System.nanoTime();
        System.out.println("Optimal Solution Time: " + (endTime - startTime) / 1000000.0 + " ms");
        System.out.println("Missing numbers count: " + result1.size());

        // HashSet solution
        int[] largeCopy2 = largeArray.clone();
        startTime = System.nanoTime();
        List<Integer> result2 = solution.findDisappearedNumbersHashSet(largeCopy2);
        endTime = System.nanoTime();
        System.out.println("HashSet Solution Time: " + (endTime - startTime) / 1000000.0 + " ms");
        System.out.println("Missing numbers count: " + result2.size());

        // Boolean solution
        int[] largeCopy3 = largeArray.clone();
        startTime = System.nanoTime();
        List<Integer> result3 = solution.findDisappearedNumbersBoolean(largeCopy3);
        endTime = System.nanoTime();
        System.out.println("Boolean Solution Time: " + (endTime - startTime) / 1000000.0 + " ms");
        System.out.println("Missing numbers count: " + result3.size());
    }
}
