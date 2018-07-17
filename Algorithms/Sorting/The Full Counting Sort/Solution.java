import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Oleg Cherednik
 * @since 17.07.2018
 */
public class Solution {

    static void countingSort(int[] num, String[] arr) {
        for (int i = 0; i < arr.length / 2; i++)
            arr[i] = "-";

        StringBuilder[] count = new StringBuilder[100];

        for (int i = 0; i < num.length; i++) {
            StringBuilder buf = count[num[i]];

            if (buf == null)
                buf = count[num[i]] = new StringBuilder();

            buf.append(i < arr.length / 2 ? "-" : arr[i]).append(' ');
        }

        for (StringBuilder buf : count)
            if (buf != null)
                System.out.print(buf);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(Solution.class.getResourceAsStream("/input01.txt")))) {
//        InputStream in = System.in;
            int n = Integer.parseInt(in.readLine());

            int[] num = new int[n];
            String[] arr = new String[n];

            for (int nItr = 0; nItr < n; nItr++) {
                String[] xs = in.readLine().split(" ");

                num[nItr] = Integer.parseInt(xs[0]);
                arr[nItr] = xs[1];
            }

            countingSort(num, arr);
        }
    }
}
