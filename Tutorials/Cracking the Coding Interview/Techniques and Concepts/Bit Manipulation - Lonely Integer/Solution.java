import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 20.05.2018
 */
public class Solution {

    public static int lonelyInteger(int[] arr) {
        int value = 0;

        for (int i : arr)
            value ^= i;

        return value;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        System.out.println(lonelyInteger(a));

        scanner.close();
    }
}
