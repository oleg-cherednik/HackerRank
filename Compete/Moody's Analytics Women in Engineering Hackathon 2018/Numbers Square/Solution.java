import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Oleg Cherednik
 * @since 13.10.2018
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int s = Integer.parseInt(firstMultipleInput[1]);

        Result.numbersSquare(n, s);

        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'numbersSquare' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER s
     */

    public static void numbersSquare(int n, int s) {
        int[][] board = new int[n][n];
        int x = 0;
        int y = 0;

        board[y][x] = s;

        while (true) {
            if (x == 0) {
                if (y == n - 1)
                    break;
                x = y + 1;
                y = 0;
                board[y][x] = ++s;
            } else if (board[y][x - 1] == 0)
                board[y][--x] = ++s;
            else if (board[y + 1][x] == 0)
                board[++y][x] = ++s;
        }

        for (y = 0; y < n; y++) {
            for (x = 0; x < n; x++) {
                if (x != 0)
                    System.out.print(' ');
                System.out.print(board[y][x]);
            }

            System.out.println();
        }
    }

}
