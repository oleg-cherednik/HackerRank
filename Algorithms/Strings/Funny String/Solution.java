import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.07.2018
 */
public class Solution {

    static String funnyString(String s) {
        char[] arr = s.toCharArray();
        int[] diff = new int[arr.length - 1];

        for (int i = 0, j = i + 1; j < arr.length; i++, j++)
            diff[i] = Math.abs(arr[j] - arr[i]);

        for (int i = arr.length - 2, j = arr.length - 1, k = 0; i >= 0; i--, j--, k++)
            if (Math.abs(arr[j] - arr[i]) != diff[k])
                return "Not Funny";

        return "Funny";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);
            System.out.println(result);
        }

        scanner.close();
    }
}
