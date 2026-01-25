import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = 2;
        int result = findKthSmallestElement(nums, k);
        System.out.println(k + "th smallest element is: " + result);
    }

    private static int findKthSmallestElement(int[] nums, int k) {
        if (k <= 0 || k > nums.length) 
            return -1;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
        }

        for (int i = 0; i < k - 1; i++) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
