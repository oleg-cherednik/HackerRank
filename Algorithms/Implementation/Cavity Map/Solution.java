import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.07.2018
 */
public class Solution {

    static String[] cavityMap(String[] grid) {
        String[] res = new String[grid.length];

        for (int row = 0; row < grid.length; row++) {
            if (row == 0 || row == grid.length - 1)
                res[row] = grid[row];
            else {
                StringBuilder buf = new StringBuilder();

                for (int col = 0; col < grid.length; col++) {
                    if (col == 0 || col == grid.length - 1)
                        buf.append(grid[row].charAt(col));
                    else {
                        char ch = grid[row].charAt(col);
                        char top = grid[row - 1].charAt(col);
                        char bottom = grid[row + 1].charAt(col);
                        char right = grid[row].charAt(col + 1);
                        char left = grid[row].charAt(col - 1);
                        boolean cavity = ch > top && ch > bottom && ch > right && ch > left;

                        buf.append(cavity ? 'X' : ch);
                    }
                }

                res[row] = buf.toString();
            }
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();

        scanner.close();
    }
}
