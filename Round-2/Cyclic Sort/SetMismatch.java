import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 4 };
        int[] result = findErrorNums(nums);

        System.out.println(Arrays.toString(result));

    }

    private static int[] findErrorNums(int[] nums) {
        int i = 0;

        // Step 1 : Find Cyclic Sort
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        // Step 2 : Find Duplicate And Missing
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return new int[] { nums[index], index + 1 };
            }
        }

        return new int[] { -1, -1 };
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}