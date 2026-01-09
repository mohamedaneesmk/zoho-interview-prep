import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class RemoveFirstKElements {
    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 40, 50 };
        int k = 1;
        List<Integer> result = findRemovedFirstKElements(nums, k);
        System.out.println(result);
    }

    private static List<Integer> findRemovedFirstKElements(int[] nums, int k) {
        if (k == 0 || k > nums.length)
            return new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            queue.add(num);
        }

        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        int size = nums.length - k;
        for (int i = 0; i < size; i++) {
            queue.add(queue.poll());
        }

        return new ArrayList<>(queue);
    }
} 