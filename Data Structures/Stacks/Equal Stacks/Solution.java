import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 29.10.2017
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();

        int sum = 0;
        Set<Integer> sum1 = new HashSet<>();
        Set<Integer> sum2 = new HashSet<>();

        int h1[] = new int[n1];
        for (int h1_i = 0; h1_i < n1; h1_i++) {
            h1[h1_i] = in.nextInt();
        }

        for (int h1_i = n1 - 1; h1_i >= 0; h1_i--) {
            sum1.add(sum = h1_i == n1 - 1 ? h1[h1_i] : (sum + h1[h1_i]));
        }

        int h2[] = new int[n2];
        for (int h2_i = 0; h2_i < n2; h2_i++) {
            h2[h2_i] = in.nextInt();
        }

        for (int h2_i = n2 - 1; h2_i >= 0; h2_i--) {
            sum = h2_i == n2 - 1 ? h2[h2_i] : (sum + h2[h2_i]);

            if (sum1.contains(sum))
                sum2.add(sum);
        }

        int h3[] = new int[n3];
        for (int h3_i = 0; h3_i < n3; h3_i++) {
            h3[h3_i] = in.nextInt();
        }

        int max = 0;
        for (int h3_i = n3 - 1; h3_i >= 0; h3_i--) {
            sum = h3_i == n3 - 1 ? h3[h3_i] : (sum + h3[h3_i]);

            if (sum2.contains(sum))
                max = sum;
        }

        System.out.println(max);
        in.close();
    }
}
