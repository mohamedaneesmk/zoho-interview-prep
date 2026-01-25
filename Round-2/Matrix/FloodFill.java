import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] images = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;

        int[][] result = findFloodFillMatrix(images, sr, sc, color);
        System.out.println(Arrays.deepToString(result));
    }

    public static int[][] findFloodFillMatrix(int[][] image, int sr, int sc, int color) {
        int start = image[sr][sc];
        if (start == color) return image;
        dfs(image, sr, sc, start, color);
        return image;
    }

    private static void dfs(int[][] image, int r, int c, int start, int color) {
        int m = image.length, n = image[0].length; 
        if (r < 0 || r >= m || c < 0 || c >= n || image[r][c] != start) return;

        image[r][c] = color;

        dfs(image, r + 1, c, start, color);
        dfs(image, r - 1, c, start, color);
        dfs(image, r, c + 1, start, color);
        dfs(image, r, c - 1, start, color);
    }
}
