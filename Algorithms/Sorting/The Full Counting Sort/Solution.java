import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 17.07.2018
 */
public class Solution {

    static String[] countingSort(int[] num, String[] arr) {
        for (int i = 0; i < arr.length / 2; i++)
            arr[i] = "-";

        List<List<String>> count = new ArrayList<>(100);

        for(int i = 0; i < 100; i++)
            count.add(new ArrayList<>());

        for(int i = 0; i < num.length; i++)
            count.get(num[i]).add(arr[i]);

        int i = 0;
        String[] res = new String[arr.length];

        for(List<String> tmp : count)
            for(String str :  tmp)
                res[i++] = str;

        return res;
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

        String[] res = countingSort(num, arr);

        for(int i = 0; i < res.length; i++)
            System.out.print(res[i] + ' ');

        scanner.close();
    }
}
