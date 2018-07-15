import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 15.07.2018
 */
public class Solution {

    static void initialize(String s) {
        // This function is called once before all queries.
        int a = 0;
        a++;

    }

    // Complete the answerQuery function below.
    static int answerQuery(int l, int r) {
        // Return the answer for this query modulo 1000000007.
        int a = 0;
        a++;
        return 0;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        initialize(s);
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] lr = scanner.nextLine().split(" ");

            int l = Integer.parseInt(lr[0]);

            int r = Integer.parseInt(lr[1]);

            int result = answerQuery(l, r);

            System.out.println(result);
        }

        scanner.close();
    }
}
