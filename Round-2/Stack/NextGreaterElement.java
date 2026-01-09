import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };

        int[] result = findNextGreaterElement(nums1, nums2);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static int[] findNextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store next greater element for each number in nums2
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            int curr = nums2[i];

            // Pop elements smaller than or equal to current
            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }

            // Top of stack is the next greater element (or -1 if empty)
            nextGreater.put(curr, stack.isEmpty() ? -1 : stack.peek());

            // Push current element to stack
            stack.push(curr);
        }

        // Build result array for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.get(nums1[i]);
        }

        return result;
    }
}