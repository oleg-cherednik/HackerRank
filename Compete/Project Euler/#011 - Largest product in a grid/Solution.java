import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.BiFunction;

/**
 * @author Oleg Cherednik
 * @since 08.08.2018
 */
public class Solution {

    private static long largestProduct(int[][] grid) {
        long max = 0;

        final BiFunction<Integer, Integer, Long> horizontal =
                (row, col) -> col < 3 ? 0L : grid[row][col] * grid[row][col - 1] * grid[row][col - 2] * grid[row][col - 3];
        final BiFunction<Integer, Integer, Long> vertical =
                (row, col) -> row < 3 ? 0L : grid[row][col] * grid[row - 1][col] * grid[row - 2][col] * grid[row - 3][col];
        final BiFunction<Integer, Integer, Long> diagonal1 =
                (row, col) -> col < 3 || row < 3 ? 0L : grid[row][col] * grid[row - 1][col - 1] * grid[row - 2][col - 2] * grid[row - 3][col - 3];
        final BiFunction<Integer, Integer, Long> diagonal2 =
                (row, col) -> col > grid.length - 4 || row < 3 ? 0L :
                              grid[row][col] * grid[row - 1][col + 1] * grid[row - 2][col + 2] * grid[row - 3][col + 3];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {
                max = Math.max(max, horizontal.apply(row, col));
                max = Math.max(max, vertical.apply(row, col));
                max = Math.max(max, diagonal1.apply(row, col));
                max = Math.max(max, diagonal2.apply(row, col));
            }
        }

        return max;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[20][20];
        for (int grid_i = 0; grid_i < 20; grid_i++) {
            for (int grid_j = 0; grid_j < 20; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(largestProduct(grid));
    }

//    public static void main(String... args) {
//        try (Scanner scan = new Scanner(Solution.class.getResourceAsStream("./data.txt"))) {
//            int[][] grid = new int[20][20];
//
//            for (int row = 0; row < 20; row++)
//                for (int col = 0; col < 20; col++)
//                    grid[row][col] = scan.nextInt();
//
//            System.out.println(largestProduct(grid));   // 70600674
//        }
//    }

}
