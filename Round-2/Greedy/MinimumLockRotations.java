public class MinimumLockRotations {
    
    /**
     * Calculates minimum total moves to convert current array to target array
     * where each digit is on a circular lock (0-9)
     * 
     * @param current Current state of the lock
     * @param target Target state of the lock
     * @return Minimum total number of moves
     */
    public static int minMoves(int[] current, int[] target) {
        int totalMoves = 0;
        
        for (int i = 0; i < current.length; i++) {
            // Calculate forward moves (clockwise)
            int forwardMoves = (target[i] - current[i] + 10) % 10;
            
            // Calculate backward moves (counter-clockwise)
            int backwardMoves = (current[i] - target[i] + 10) % 10;
            
            // Take minimum of both directions
            int minMovesForDigit = Math.min(forwardMoves, backwardMoves);
            
            totalMoves += minMovesForDigit;
        }
        
        return totalMoves;
    }
    
    // Test cases
    public static void main(String[] args) {
        // Test Case 
        int[] current1 = {4, 5, 6, 7};
        int[] target1 = {1, 2, 3, 4};
        System.out.println("Test Case 1:");
        System.out.println("Current: " + java.util.Arrays.toString(current1));
        System.out.println("Target:  " + java.util.Arrays.toString(target1));
        System.out.println("Output: " + minMoves(current1, target1));
        System.out.println("Expected: 12\n");
        
    }
}