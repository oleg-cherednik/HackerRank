import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 23.11.2018
 */
public class Solution {

    static String twoArrays(int k, int[] A, int[] B) {
        Arrays.sort(B);

        out:
        for(int a : A) {
            for(int i = 0; i < B.length; i++) {
                if(B[i] == Integer.MAX_VALUE)
                    continue;
                if(a + B[i] >= k) {
                    B[i] = Integer.MAX_VALUE;
                    continue out;
                }
            }

            return "NO";
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] A = new int[n];

            String[] AItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(AItems[i]);
                A[i] = AItem;
            }

            int[] B = new int[n];

            String[] BItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            System.out.println(twoArrays(k, A, B));
        }

        scanner.close();
    }
}
