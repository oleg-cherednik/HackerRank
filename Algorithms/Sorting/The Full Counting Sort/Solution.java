import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

            String res = countingSort(num, arr);
            System.out.println(res);
        }
    }
}
