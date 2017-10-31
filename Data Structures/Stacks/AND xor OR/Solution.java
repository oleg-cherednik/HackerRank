import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 31.10.2017
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();

        long a;
        long b = -1;
        long max = 0;

        for (int i = 0; i < N; i++) {
            a = b;
            b = scan.nextLong();

            if (a > 0) {
                long res = ((a & b) ^ (a | b)) & (a ^ b);
                if (res == 262143 || res == 262141) {
                    System.out.println(res);
                    System.out.println("a:" + a + ", b:" + b);
                }
                max = Math.max(max, res);
            }
        }

        scan.close();

        System.out.println(max);
    }
}
