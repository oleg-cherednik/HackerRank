import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 03.11.2017
 */

/**
 * @author Oleg Cherednik
 * @since 03.11.2017
 */
public class Solution {
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        Queue<String> queue = new LinkedList<>();

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grid = new String[n];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            grid[grid_i] = in.next();
        }
        int startX = in.nextInt();
        int startY = in.nextInt();
        int goalX = in.nextInt();
        int goalY = in.nextInt();
        int result = minimumMoves(grid, startX, startY, goalX, goalY);
        in.close();
    }

}

