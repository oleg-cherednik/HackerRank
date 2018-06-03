import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 03.06.2018
 */
public class Solution {

    static int[] circularArrayRotation(int[] a, int[] m, int k) {
        k = k > a.length ? k % a.length : k;

        for(int i = 0, j = a.length - 1; i < j; i++, j--)
            swap(a, i, j);
        for(int i = 0, j = k - 1; i < j; i++, j--)
            swap(a, i, j);
        for(int i = k, j = a.length - 1; i < j; i++, j--)
            swap(a, i, j);

        int[] res = new int[m.length];

        for(int i = 0; i < res.length; i++)
            res[i] = a[m[i]];

        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nkq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkq[0]);

        int k = Integer.parseInt(nkq[1]);

        int q = Integer.parseInt(nkq[2]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] m = new int[q];

        for (int i = 0; i < q; i++) {
            int mItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            m[i] = mItem;
        }

        int[] result = circularArrayRotation(a, m, k);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        scanner.close();
    }
}
