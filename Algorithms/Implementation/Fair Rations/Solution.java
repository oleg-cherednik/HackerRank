import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 02.07.2018
 */
public class Solution {

    static int fairRations(int[] B) {
        int res = 0;

        for (int i = 0; i < B.length - 1; i++) {
            if (B[i] % 2 == 0)
                continue;

            B[i]++;
            B[i + 1]++;
            res += 2;
        }

        return B[B.length - 1] % 2 == 0 ? res : -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);

        System.out.println(result >= 0 ? result : "NO");

        scanner.close();
    }
}
