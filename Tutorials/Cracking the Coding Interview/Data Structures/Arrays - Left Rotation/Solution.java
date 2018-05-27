import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Oleg Cherednik
 * @since 13.05.2018
 */
public class Solution {

    private static void leftRotate(int[] a, int k) {
        k = k >= a.length ? a.length % k : k;

        for (int i = 0, j = a.length - 1; i < j; i++, j--)
            swap(a, i, j);
        for (int i = 0, j = a.length - k - 1; i < j; i++, j--)
            swap(a, i, j);
        for (int i = a.length - k, j = a.length - 1; i < j; i++, j--)
            swap(a, i, j);
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static String string(int[] a) {
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        leftRotate(a, k);
        System.out.println(string(a));

        scanner.close();
    }

}
