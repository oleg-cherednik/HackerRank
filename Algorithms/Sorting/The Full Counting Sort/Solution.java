import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 17.07.2018
 */
public class Solution {

    static String countingSort(int[] num, String[] arr) {
        int capacity = 0;
        StringBuilder[] count = new StringBuilder[100];

        for (int i = 0; i < num.length; i++) {
            StringBuilder buf = count[num[i]];

            if (buf == null)
                buf = count[num[i]] = new StringBuilder();

            if (i < arr.length / 2) {
                buf.append("- ");
                capacity += 2;
            } else {
                buf.append(arr[i]).append(' ');
                capacity += arr[i].length() + 1;
            }
        }

        StringBuilder res = new StringBuilder(capacity);

        for (StringBuilder buf : count)
            if (buf != null)
                res.append(buf);

        return res.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] num = new int[n];
        String[] arr = new String[n];

        for (int nItr = 0; nItr < n; nItr++) {
            String[] xs = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xs[0]);

            String s = xs[1];

            num[nItr] = x;
            arr[nItr] = s;
        }

        System.out.println(countingSort(num, arr));

        scanner.close();
    }
}
