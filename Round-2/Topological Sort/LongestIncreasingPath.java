public class LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] matrix = {
                { 9, 9, 4 },
                { 6, 6, 8 },
                { 2, 1, 1 }
        };

        int result = longestIncreasingPath(matrix);
        System.out.println(result);
    }

    // directions: down, up, right, left
    private static final int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // dp[i][j] = longest increasing path starting from (i, j)
        int[][] dp = new int[m][n];
        int ans = 0;

        // try starting from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, dp, i, j));
            }
        }
        return ans;
    }

    private static int dfs(int[][] matrix, int[][] dp, int r, int c) {
        // already computed
        if (dp[r][c] != 0)
            return dp[r][c];

        int maxLen = 1; // at least the cell itself

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            // valid move + strictly increasing
            if (nr >= 0 && nc >= 0 &&
                    nr < matrix.length && nc < matrix[0].length &&
                    matrix[nr][nc] > matrix[r][c]) {

                maxLen = Math.max(maxLen, 1 + dfs(matrix, dp, nr, nc));
            }
        }

        dp[r][c] = maxLen; // memoize
        return maxLen;
    }
}
