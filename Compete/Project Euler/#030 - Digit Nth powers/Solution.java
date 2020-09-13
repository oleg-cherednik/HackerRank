import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 17.06.2020
 */
public class Solution {

    private static int calc(int n) {
        int res = 0;

        for (int i = 10; i < 600_000; i++) {
            int sum = 0;
            int j = i;

            while (j > 0) {
                int d = j % 10;
                sum += Math.pow(d, n);
                j /= 10;
            }

            if (sum == i)
                res += i;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(calc(scan.nextInt()));
    }

}
