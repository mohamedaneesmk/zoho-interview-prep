import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SortEvenOdd {
    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 3 };
        // int[] nums = {2,1};
        int[] result = findSortedEvenOdd(nums);
        for(int num:result){
            System.out.print(num+" ");
        }
    }

    private static int[] findSortedEvenOdd(int[] nums) {
        List<Integer> evenIndex = new ArrayList<>();
        List<Integer> oddIndex = new ArrayList<>();

        for (int index = 0; index < nums.length; index++) {
            if (index % 2 == 0)
                evenIndex.add(nums[index]); 
            else
                oddIndex.add(nums[index]);
        } 

        Collections.sort(evenIndex);
        oddIndex.sort(Collections.reverseOrder());

        int[] result = new int[nums.length];
        int even = 0;
        int odd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                result[i] = evenIndex.get(even++);
            else
                result[i] = oddIndex.get(odd++);
        }

        return result;
    }
}