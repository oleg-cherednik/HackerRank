import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 20.05.2018
 */
public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        for (int i = arr.length - 1; i >= 0; i--)
            System.out.print(arr[i] + " ");

        scanner.close();
    }
}
