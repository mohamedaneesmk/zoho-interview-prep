import java.util.*;

public class CombinationSumII {
    
    /**
     * OPTIMIZED: Find all unique combinations where candidate numbers sum to target.
     * Optimizations:
     * 1. Early termination with sorted array
     * 2. Skip duplicates efficiently
     * 3. Frequency map approach for better handling of duplicates
     * 4. Avoid unnecessary list operations
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void backtrack(int[] candidates, int remaining, int start, 
        List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // OPTIMIZATION 1: Early termination (sorted array)
            if (candidates[i] > remaining) break;
            
            // OPTIMIZATION 2: Skip duplicates at same level
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            
            current.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    /**
     * FREQUENCY MAP APPROACH (Most Optimized for many duplicates)
     * Time: O(2^n) worst case, but much better with duplicates
     * Space: O(n)
     * 
     * This approach is especially efficient when input has many duplicate values.
     */
    public static List<List<Integer>> combinationSum2FrequencyMap(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Build frequency map
        Map<Integer, Integer> freqMap = new TreeMap<>(); // TreeMap keeps sorted order
        for (int num : candidates) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Convert to list of unique numbers
        List<int[]> uniqueNums = new ArrayList<>(); // [number, frequency]
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            uniqueNums.add(new int[]{entry.getKey(), entry.getValue()});
        }
        
        backtrackWithFreq(uniqueNums, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void backtrackWithFreq(List<int[]> uniqueNums, int remaining, 
                                          int index, List<Integer> current, 
                                          List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (index >= uniqueNums.size() || remaining < 0) {
            return;
        }
        
        int num = uniqueNums.get(index)[0];
        int freq = uniqueNums.get(index)[1];
        
        // OPTIMIZATION: Try using 0, 1, 2, ... up to freq copies of current number
        for (int count = 0; count <= freq; count++) {
            if (num * count > remaining) break; // Early termination
            
            // Add 'count' copies of current number
            for (int i = 0; i < count; i++) {
                current.add(num);
            }
            
            // Recurse to next unique number
            backtrackWithFreq(uniqueNums, remaining - num * count, index + 1, current, result);
            
            // Remove 'count' copies
            for (int i = 0; i < count; i++) {
                current.remove(current.size() - 1);
            }
        }
    }
    
    /**
     * ITERATIVE DYNAMIC PROGRAMMING APPROACH
     * Good for smaller targets, avoids recursion overhead
     * Time: O(n * target * average_combination_length)
     * Space: O(target * number_of_combinations)
     */
    public static List<List<Integer>> combinationSum2DP(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        // dp[i] = list of all combinations that sum to i
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 0; i <= target; i++) {
            dp.add(new ArrayList<>());
        }
        
        // Base case: empty combination sums to 0
        dp.get(0).add(new ArrayList<>());
        
        for (int i = 0; i < candidates.length; i++) {
            int num = candidates[i];
            
            // Skip duplicates: only process if it's first occurrence OR different from previous
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            // Count frequency of current number
            int count = 1;
            while (i + 1 < candidates.length && candidates[i + 1] == num) {
                count++;
                i++;
            }
            
            // Update dp table from target down to num
            for (int sum = target; sum >= num; sum--) {
                // Try using 1, 2, ... count copies of num
                for (int k = 1; k <= count && sum >= num * k; k++) {
                    int prevSum = sum - num * k;
                    
                    for (List<Integer> prevCombination : dp.get(prevSum)) {
                        List<Integer> newCombination = new ArrayList<>(prevCombination);
                        for (int j = 0; j < k; j++) {
                            newCombination.add(num);
                        }
                        dp.get(sum).add(newCombination);
                    }
                }
            }
        }
        
        return dp.get(target);
    }
    
    /**
     * Performance comparison and testing
     */
    public static void main(String[] args) {
        System.out.println("=== Combination Sum II - Optimized Versions ===\n");
        
        // Example 1
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        
        System.out.println("Example 1: " + Arrays.toString(candidates1) + ", target = " + target1);
        
        long start = System.nanoTime();
        List<List<Integer>> result1 = combinationSum2(candidates1, target1);
        long time1 = System.nanoTime() - start;
        System.out.println("Standard Backtracking: " + result1);
        System.out.println("Time: " + time1 / 1000 + " microseconds\n");
        
        start = System.nanoTime();
        List<List<Integer>> result2 = combinationSum2FrequencyMap(candidates1, target1);
        long time2 = System.nanoTime() - start;
        System.out.println("Frequency Map Approach: " + result2);
        System.out.println("Time: " + time2 / 1000 + " microseconds\n");
        
        start = System.nanoTime();
        List<List<Integer>> result3 = combinationSum2DP(candidates1, target1);
        long time3 = System.nanoTime() - start;
        System.out.println("DP Approach: " + result3);
        System.out.println("Time: " + time3 / 1000 + " microseconds\n");
        
        System.out.println("=".repeat(60));
        
        // Example 2 - Many duplicates (frequency map shines here)
        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        
        System.out.println("\nExample 2: " + Arrays.toString(candidates2) + ", target = " + target2);
        
        start = System.nanoTime();
        result1 = combinationSum2(candidates2, target2);
        time1 = System.nanoTime() - start;
        System.out.println("Standard Backtracking: " + result1);
        System.out.println("Time: " + time1 / 1000 + " microseconds\n");
        
        start = System.nanoTime();
        result2 = combinationSum2FrequencyMap(candidates2, target2);
        time2 = System.nanoTime() - start;
        System.out.println("Frequency Map Approach: " + result2);
        System.out.println("Time: " + time2 / 1000 + " microseconds\n");
        
        // Large test case with many duplicates
        System.out.println("=".repeat(60));
        System.out.println("\nLarge Test Case (many duplicates):");
        int[] candidates3 = {1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5};
        int target3 = 10;
        
        start = System.nanoTime();
        result1 = combinationSum2(candidates3, target3);
        time1 = System.nanoTime() - start;
        System.out.println("Standard Backtracking: " + result1.size() + " combinations");
        System.out.println("Time: " + time1 / 1000 + " microseconds\n");
        
        start = System.nanoTime();
        result2 = combinationSum2FrequencyMap(candidates3, target3);
        time2 = System.nanoTime() - start;
        System.out.println("Frequency Map Approach: " + result2.size() + " combinations");
        System.out.println("Time: " + time2 / 1000 + " microseconds");
        System.out.println("Speedup: " + String.format("%.2fx", (double)time1 / time2));
    }
}