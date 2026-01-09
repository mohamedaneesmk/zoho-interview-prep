public class BitonicPoint {
    public static void main(String[] args) {
        int[] arr = {1,3,8,12,4,2};
        int result = findBitonicPoint(arr);
        System.out.println(result);
    }
 
    private static int findBitonicPoint(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return arr[mid];
            else if(arr[mid-1]>arr[mid]) right = mid-1;
            else left = mid+1;
        }

        return -1;
    }
}
