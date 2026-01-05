import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the limit: ");
        int limit = sc.nextInt();
        int[] nums = new int[limit];
        System.out.println("Enter 10 integers:");
        for (int i = 0; i < limit; i++) {
            nums[i] = sc.nextInt();
        }
        int result = findSecondLargest(nums);
        if (result == Integer.MIN_VALUE) {
            System.out.println("No second largest element found.");
        } else {
            System.out.println("The second largest number is: " + result);
        }
        sc.close();
    }

    private static int findSecondLargest(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE; 

        for (int n : nums) {
            if (n > max) {
                secondMax = max;
                max = n;
            } else if (n > secondMax && n != max) {
                secondMax = n;
            }
        }

        return secondMax;
    }
}
