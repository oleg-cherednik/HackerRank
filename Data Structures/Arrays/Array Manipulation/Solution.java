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

        int[] arr = new int[n];

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();

            for (int j = a - 1; j <= b - 1; j++)
                arr[j] += k;
        }

        int max = 0;

        for (int i = 0; i < n; i++)
            max = Math.max(arr[i], max);

        System.out.println(max);

        in.close();
    }
}
