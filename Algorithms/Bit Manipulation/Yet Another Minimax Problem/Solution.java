import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.07.2018
 */
public class Solution {

    static int anotherMinimaxProblem(int[] a) {


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = anotherMinimaxProblem(a);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
