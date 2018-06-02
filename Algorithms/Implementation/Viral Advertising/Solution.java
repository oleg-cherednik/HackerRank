import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 02.06.2018
 */
public class Solution {

    static int viralAdvertising(int n) {
        int res = 0;

        for (int day = 0, shared = 5; day < n; day++) {
            int like = shared / 2;
            res += like;
            shared = like * 3;
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
