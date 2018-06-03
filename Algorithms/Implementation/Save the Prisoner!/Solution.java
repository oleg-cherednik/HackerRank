import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 03.06.2018
 */
public class Solution {

    static int saveThePrisoner(int n, int m, int s) {
        return (m + s - 1) % n == 0 ? n : (m + s - 1) % n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(saveThePrisoner(4, 8, 3));
        System.out.println(saveThePrisoner(4, 4, 1));
        System.out.println(saveThePrisoner(352926151, 380324688, 94730870));
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
