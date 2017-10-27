import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 27.10.2017
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();

            if (k > 0) {
                arr[a - 1] += k;

                if (b < arr.length)
                    arr[b] -= k;
            }
        }

        in.close();

        long max = arr[0];
        long cur = arr[0];

        for (int i = 1; i < arr.length; i++) {
            cur += arr[i];
            max = cur > max ? cur : max;
        }

        System.out.println(max);
    }
}
