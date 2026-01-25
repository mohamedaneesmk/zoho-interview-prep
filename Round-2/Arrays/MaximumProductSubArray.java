public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };
        int reuslt = maxProduct(nums);
        System.out.println(reuslt);
    }

    private static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(maxProd * num, num);
            minProd = Math.min(minProd * num, num);

            result = Math.max(result, maxProd);
        }

        return result;
    }
}
