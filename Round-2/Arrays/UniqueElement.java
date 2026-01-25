public class UniqueElement {
    public static void main(String[] args) {
        int[] nums = {1,22,22,1,5,3,6,3,6};
        int result = findUniqueElement(nums);
        System.out.println("Unique Number is = "+result);
    }

    public static int findUniqueElement(int[] arr){
        int result = 0;
        for(int num:arr){
            result = result^num;
        }
        return result;
    } 
}
  