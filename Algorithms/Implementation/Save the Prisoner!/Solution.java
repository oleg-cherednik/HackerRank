import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 29.05.2018
 */
public class Solution {

    static int saveThePrisoner(int n, int m, int s) {


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
