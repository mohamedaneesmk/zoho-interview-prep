import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> result = disappearedNumbers(nums);

        System.out.println(result);
    }

    private static List<Integer> disappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;

        while (i < nums.length) {
            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        // find disappeared numbers
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                result.add(index + 1);
            }
        }

        return result;
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
