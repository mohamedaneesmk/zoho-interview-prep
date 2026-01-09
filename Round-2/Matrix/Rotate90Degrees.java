public class Rotate90Degrees {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // System.out.println(matrix.length);
        rotate90Clockwise(matrix);
        printMatrix(matrix);
    } 

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static void rotate90Clockwise(int[][] matrix) {
        int length = matrix.length;

        // Transpose the matrix
        for (int row = 0; row <= length; row++) {
            for (int col = row + 1; col < length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // Reverse Each row
        for (int row = 0; row < length; row++) {
            int start = 0;
            int end = length - 1;

            while (start < end) {
                int temp = matrix[row][start];
                matrix[row][start] = matrix[row][end];
                matrix[row][end] = temp;
                start++;
                end--;
            }
        }
    }
}
