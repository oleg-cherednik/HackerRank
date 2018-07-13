import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.07.2018
 */
public class Solution {

    static int gemstones(String[] arr) {
        int res = 0;

        out:
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (String s : arr)
                if (s.indexOf(ch) < 0)
                    continue out;

            res++;
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
