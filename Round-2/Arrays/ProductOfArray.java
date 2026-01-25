public class ProductOfArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        
        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // Initialize the output array with 1s
        for (int i = 0; i < n; i++) {
            output[i] = 1;
        }

        // Calculate left products
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            output[i] *= leftProduct;
            leftProduct *= nums[i];
        }

        // Calculate right products
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return output;
    }
}
