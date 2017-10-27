import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 27.10.2017
 */
public class Solution {
    static int[] leftRotation(int[] a, int d) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--)
            swap(a, i, j);

        d %= a.length;

        if (d > 0) {
            d = a.length - d;

            for (int i = 0, j = d - 1; i < j; i++, j--)
                swap(a, i, j);

            for (int i = d, j = a.length - 1; i < j; i++, j--)
                swap(a, i, j);
        }

        return a;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
