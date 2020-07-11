import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 11.07.2020
 */
public class Solution {

    static int maxRegion(int[][] grid) {
        int res = 0;

        for (int row = 0, mark = 2; row < grid.length; row++)
            for (int col = 0; col < grid[row].length; col++)
                if (get(row, col, grid) == 1)
                    res = Math.max(res, dfs(row, col, grid, mark++));

        return res;
    }

    private static int dfs(int row, int col, int[][] grid, int mark) {
        int a = get(row, col, grid);
        int res = 0;

        if (a == 1) {
            res++;
            grid[row][col] = mark;
            res += dfs(row - 1, col - 1, grid, mark);
            res += dfs(row - 1, col, grid, mark);
            res += dfs(row - 1, col + 1, grid, mark);

            res += dfs(row, col - 1, grid, mark);
            res += dfs(row, col + 1, grid, mark);

            res += dfs(row + 1, col - 1, grid, mark);
            res += dfs(row + 1, col, grid, mark);
            res += dfs(row + 1, col + 1, grid, mark);
        }

        return res;
    }

    private static int get(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length)
            return 0;
        if (col < 0 || col >= grid[row].length)
            return 0;
        return grid[row][col];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);

        System.out.println(res);

        scanner.close();
    }
}
