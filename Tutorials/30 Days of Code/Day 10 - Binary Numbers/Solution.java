import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 24.05.2018
 */
public class Solution {

    private static int getMaxConsecutive(int n) {
        String binary = Integer.toBinaryString(n);

        int cur = 0;
        int max = 0;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                max = Math.max(cur, max);
                cur = 0;
            } else if (binary.charAt(i) == '1')
                cur++;
        }

        return Math.max(max, cur);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(getMaxConsecutive(n));

        scanner.close();
    }
}
