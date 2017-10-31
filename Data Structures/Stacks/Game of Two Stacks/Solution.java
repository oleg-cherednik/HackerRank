import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 29.10.2017
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for (int a0 = 0; a0 < g; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for (int b_i = 0; b_i < m; b_i++) {
                b[b_i] = in.nextInt();
            }

            int sum = 0;
            int score = 0;
            int i = 0;
            int j = 0;

            while (true) {
                if (a[i] <= b[j]) {
                    if (sum + a[i] > x)
                        break;
                    sum += a[i++];
                    score++;
                } else if (a[i] > b[j]) {
                    if (sum + b[j] > x)
                        break;
                    sum += b[j++];
                    score++;
                }
            }

            System.out.println(score);
        }
    }
}
