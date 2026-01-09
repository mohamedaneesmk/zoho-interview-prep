public class DeleteColumnsToMakeSorted {
    public static void main(String[] args) {
        String[] strs = {"cba","daf","ghi"};
        System.out.println(minDeletionSize(strs)); 
    }

    public static int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int deleteCount = 0;
 
        for (int c = 0; c < cols; c++) {
            for (int r = 1; r < rows; r++) {
                if (strs[r].charAt(c) < strs[r - 1].charAt(c)) {
                    deleteCount++;
                    break;
                }
            }
        }

        return deleteCount;
    }
}
