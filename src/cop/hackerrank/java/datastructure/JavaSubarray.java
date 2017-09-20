package cop.hackerrank.java.datastructure;

import java.util.Scanner;

/**
 * <h1>Java Subarray</h1>
 * We define the following:
 * <ul>
 * <li>A <tt>subarray</tt> of an <tt>n</tt>-element array is an array composed from a contiguous block of the original array's elements. For example,
 * if <array=[1,2,3], then the subarrays are [1], [2], [3], [1,2], [2,3], and [1,2,3]. Something like [1,3] would <tt>not</tt> be a subarray as it's
 * not a contiguous subsection of the original array.</li>
 * <li>
 * The <tt>sum</tt> of an array is the total sum of its elements.
 * <ul>
 * <li>An array's sum is <tt>negative</tt> if the total sum of its elements is negative.</li>
 * <li>An array's sum is <tt>positive</tt> if the total sum of its elements is positive.</li>
 * </ul>
 * </li>
 * </ul>
 * Given an array of <tt>n</tt> integers, find and print its number of <tt>negative subarrays</tt> on a new line.
 * <h3>Input Format</h3>
 * The first line contains a single integer, <tt>n</tt>, denoting the length of array A=[a<sub>0</sub>,a<sub>1</sub>,...,a<sub>n-1</sub>].<br>
 * The second line contains <tt>n</tt> space-separated integers describing each respective element, a<sub>i</sub>, in array <tt>A</tt>.
 * <h3>Constraints</h3>
 * <ul>
 * <li>1 <= n <= 100</li>
 * <li>-10<sup>4</sup> <= a<sub>i</sub> <= 10<sup>4</sup></li>
 * </ul>
 * <h3>Sample Input</h3>
 * <pre>
 * 5
 * 1 -2 4 -5 1
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 9
 * </pre>
 * <h3>Explanation</h3>
 * There are nine negative subarrays of A=[1,-2,4,-5,1]:
 * <ol>
 * <li>[1:1] => -2</li>
 * <li>[3:3] => -5</li>
 * <li>[0:1] => 1 + -1 = -1</li>
 * <li>[2:3] => 4 + -1 = -1</li>
 * <li>[3:4] => -5 + 1 = -4</li>
 * <li>[1:3] => -2 + 4 + -5 = -3</li>
 * <li>[0:3] => 1 + -2 + 4 + -5 = -2</li>
 * <li>[1:4] => -2 + 4 + -5 + 1 = -2</li>
 * <li>[0:4] => 1 + -2 + 4 + -5 + 1 = -1</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 15.09.2017
 */
public class JavaSubarray {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] A = new int[2][n + 1];

        for (int i = 1; i <= n; i++) {
            A[0][i] = scan.nextInt();
            A[1][i] = A[1][i - 1] + A[0][i];
        }

        int res = 0;

        for (int i = 0; i <= n; i++)
            if (A[0][i] < 0)
                res++;

        for (int i = 2; i <= n; i++)
            for (int j = 0, k = j + i; k <= n; j++, k++)
                if (A[1][k] - A[1][j] < 0)
                    res++;

        System.out.println(res);
    }
}
