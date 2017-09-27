package cop.hackerrank.java.datastructure;

import java.util.Scanner;

/**
 * <h1>Java 1D Array (Part 2)</h1>
 * Let's play a game on an array! You're standing at index 0 of an <tt>n</tt>-element array named <i>game</i>. From some index <tt>i</tt> (where 0 <=
 * i <= n), you can perform one of the following moves:
 * <ul>
 * <li><i>Move Backward:</i> If cell <tt>i-1</tt> exists and contains a 0, you can walk back to cell <tt>i-1</tt>.</li>
 * <li><i>Move Forward:</i>
 * <ul>
 * <li>If cell <tt>i+1</tt> contains a zero, you can walk to cel <tt>i+1</tt>.</li>
 * <li>If cell <tt>i+leap</tt> contains a zero, you can jump to cell <tt>i+leap</tt>.</li>
 * <li>If you're standing in cell <tt>n-1</tt> or the value of <tt>i+leap >= n</tt>, you can walk or jump off the end of the array and win the
 * game.</li>
 * </ul>
 * </li>
 * </ul>
 * In other words, you can move from index <tt>i</tt> to index <tt>i+1</tt>, <tt>i-1</tt>, or <tt>i+leap</tt> as long as the destination index is a
 * cell containing a 0. If the destination index is greater than <tt>n-1</t>, you win the game.<br>
 * Given <tt>leap</tt> and <tt>game</tt>, complete the function in the editor below so that it returns <tt>true</tt> if you can win the game (or
 * <tt>false</tt> if you cannot).
 * <h3>Input Format</h3>
 * The first line contains an integer, <tt>q</tt>, denoting the number of queries (i.e., function calls).<br>
 * The <tt>2*q</tt> subsequent lines describe each query over two lines:
 * <ol>
 * <li>The first line contains two space-separated integers describing the respective values of <tt>n</tt> and <tt>leap</tt>.</li>
 * <li>The second line contains <tt>n</tt> space-separated binary integers (i.e., zeroes and ones) describing the respective values of
 * <tt>game<sub>0</sub></tt>, <tt>game<sub>1</sub></tt>,...,<tt>game<sub>n-1</sub></tt>.</li>
 * </ol>
 * <h3>Constraints</h3>
 * <ul>
 * <li>1 <= q <= 5000</li>
 * <li>2 <= n <= 100</li>
 * <li>0 <= leap <= 100</li>
 * <li>It is guaranteed that the value of <t>game[0]</t> is always 0.</li>
 * </ul>
 * <h3>Output Format</h3>
 * Return <i>true</i> if you can win the game; otherwise, return <tt>false</tt>.
 * <h3>Sample Input</h3>
 * <pre>
 * 4
 * 5 3
 * 0 0 0 0 0
 * 6 5
 * 0 0 0 1 1 1
 * 6 3
 * 0 0 1 1 1 0
 * 3 1
 * 0 1 0
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * YES
 * YES
 * NO
 * NO
 * </pre>
 * <h3>Explanation</h3>
 * We perform the following <t>q=4</t> queries:
 * <ol>
 * <li>For <tt>game=[0,0,0,0,0]</tt> and <tt>leap=3</tt>, we can walk and/or jump to the end of the array because every cell contains a 0. Because we
 * can win, we return <tt>true</tt>.</li>
 * <li>For <tt>game=[0,0,0,1,1,1]</tt> and <tt>leap=5</tt>, we can walk to index 1 and then jump <tt>i+leap=1+5=6</tt> units to the end of the array.
 * Because we can win, we return <tt>true</tt>.</li>
 * <li>For <tt>game=[0,0,1,1,1,0]</tt> and <tt>leap=3</tt>, there is no way for us to get past the three consecutive ones. Because we cannot win, we
 * return <tt>false</tt>.</li>
 * <li>For <tt>game=[0,1,0]</tt> and <tt>leap=1</tt>, there is no way for us to get past the one at index 1. Because we cannot win, we return
 * <tt>false</tt>.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 16.09.2017
 */
public class Java1DArray2 {
    private static boolean dfs(int leap, int[] game, int i) {
        if (i < 0 || game[i] == 1)
            return false;
        if (i == game.length - 1 || i + leap > game.length - 1)
            return true;

        game[i] = 1;
        return dfs(leap, game, i + 1) || dfs(leap, game, i - 1) || dfs(leap, game, i + leap);
    }

    public static boolean canWin(int leap, int[] game) {
        return dfs(leap, game, 0);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
