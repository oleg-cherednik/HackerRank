import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 15.07.2018
 */
public class Solution {

    static String highestValuePalindrome(String s, int n, int k) {
        char[] arr = s.toCharArray();
        boolean[] changed = new boolean[arr.length];

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (arr[i] == arr[j])
                continue;
            if (k == 0)
                return "-1";

            if (arr[i] > arr[j]) {
                arr[j] = arr[i];
                changed[j] = true;
            } else {
                arr[i] = arr[j];
                changed[i] = true;
            }

            k--;
        }

        for (int i = 0, j = s.length() - 1; i < j && k > 1; i++, j--) {
            if (arr[i] == '9')
                continue;

            arr[i] = '9';
            arr[j] = '9';
            k -= changed[i] ? 0 : 1;
            k -= changed[j] ? 0 : 1;
        }

        for (int i = 0, j = s.length() - 1; i <= j && k > 0; i++, j--) {
            if (i == j) {
                if (arr[i] == '9')
                    continue;

                arr[i] = '9';
                k -= changed[i] ? 0 : 1;
                changed[i] = true;
            } else if (changed[i] ^ changed[j] && arr[i] != '9') {
                arr[i] = '9';
                arr[j] = '9';
                changed[i] = true;
                changed[j] = true;
                k--;
            }
        }

        return new String(arr);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);
        System.out.println(result);

        scanner.close();
    }
}
