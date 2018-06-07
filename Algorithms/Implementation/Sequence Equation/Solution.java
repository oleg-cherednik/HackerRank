import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 07.06.2018
 */
public class Solution {

    static int[] permutationEquation(int[] p) {
        int[] res = new int[p.length];
        int[] arr = new int[p.length];

        for (int i = 0; i < p.length; i++)
            arr[p[i] - 1] = i;

        for (int i = 0; i < p.length; i++)
            res[i] = arr[arr[i]] + 1;

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        scanner.close();
    }
}
