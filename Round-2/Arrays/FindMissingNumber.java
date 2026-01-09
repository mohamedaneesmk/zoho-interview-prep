public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 5, 6, 7, 8, 9, 10};
        int result = findMissingNumber(arr);
        System.out.println("The missing number is: " + result);
    } 

    private static int findMissingNumber(int[] arr) {
        int max = 0;
        for (int num : arr) {
            if (num > max)
                max = num;
        }
        int total = max * (max + 1) / 2;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return total - sum;
    }
}
