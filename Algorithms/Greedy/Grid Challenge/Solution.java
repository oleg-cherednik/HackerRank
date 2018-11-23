import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 23.11.2018
 */
public class Solution {

    static String gridChallenge(String[] grid) {
        for(int row = 0; row < grid.length; row++) {
            char[] arr = grid[row].toCharArray();
            Arrays.sort(arr);
            grid[row] = new String(arr);
        }

        for(int col = 0; col < grid[0].length(); col++) {
            for(int row = 1; row < grid.length; row++)
                if(grid[row].charAt(col) < grid[row - 1].charAt(col))
                    return "NO";
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] grid = new String[n];

            for (int i = 0; i < n; i++) {
                String gridItem = scanner.nextLine();
                grid[i] = gridItem;
            }

            System.out.println(gridChallenge(grid));
        }

        scanner.close();
    }
}
