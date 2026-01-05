import java.util.HashMap;

public class GoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int goodPairs = 0;

        for (int num : nums) {
            // If this number already appeared, it can form pairs with all its previous occurrences
            if (countMap.containsKey(num)) {
                goodPairs += countMap.get(num);
            }
            // Update count of this number
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        return goodPairs;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1, 1, 3};
        int[] nums2 = {1, 1, 1, 1};
        int[] nums3 = {1, 2, 3};

        System.out.println(numIdenticalPairs(nums1)); // Output: 4
        System.out.println(numIdenticalPairs(nums2)); // Output: 6
        System.out.println(numIdenticalPairs(nums3)); // Output: 0
    }
}
