import java.util.*;

public class ReplaceWithGreatestOnRight {
    // In-place O(n) time, O(1) space
    public static void replaceWithGreatestOnRight(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int n = arr.length;
        int maxFromRight = arr[n - 1];   // store original last
        arr[n - 1] = -1;                 // last becomes -1

        for (int i = n - 2; i >= 0; i--) {
            int temp = arr[i];           // original value at i
            arr[i] = maxFromRight;       // replace with max to the right
            if (temp > maxFromRight) {   // update running max
                maxFromRight = temp;
            } 
        }
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        replaceWithGreatestOnRight(arr);
        // Expected: 17 5 5 5 2 -1
        System.out.println(Arrays.toString(arr));
    }
}
