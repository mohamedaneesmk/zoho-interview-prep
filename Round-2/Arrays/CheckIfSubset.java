// Using Set Approach 

// import java.util.HashSet;
// import java.util.Set;

// public class CheckIfSubset {
//     public static void main(String[] args) {
//         int[] nums1 = { 1, 2, 3, 4, 5 };
//         int[] nums2 = { 2, 4, 5 };
//         boolean result = isAllElementsPresent(nums1, nums2);
//         System.out.println(result);
//     }

//     private static boolean isAllElementsPresent(int[] nums1, int[] nums2) {
//         Set<Integer> set = new HashSet<>();
//         for (int num : nums1)
//             set.add(num);
//         for (int num : nums2) {
//             if (!set.contains(num)) return false;
//         }
//         return true;
//     }
// }


// Using Two Pointer method

public class CheckIfSubset {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {2,4,5};
        boolean result = isAllElementsPresent(nums1,nums2);
        System.out.println(result);
    }

    private static boolean isAllElementsPresent(int[] nums1, int[] nums2) {
        int i=0,j=0;
 
        while (i<nums1.length && j<nums2.length) {
            if(nums1[i]<nums2[j]) i++;
            else if(nums1[i]==nums2[j]){
                i++;
                j++;
            }
            else return false;
        }

        return j==nums2.length;
    }
}