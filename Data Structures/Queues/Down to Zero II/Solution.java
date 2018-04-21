import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 21.04.2018
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = Integer.parseInt(scan.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scan.nextLine().trim());
            System.out.println(downToZero(n));
        }

        scan.close();
    }

    private static final int[] ARR = new int[1000001];

    static {
        ARR[0] = 0;
        ARR[1] = 1;
        ARR[2] = 2;
        ARR[3] = 3;

        for (int i = 1; i < ARR.length; i++) {
            ARR[i] = ARR[i] == 0 ? ARR[i - 1] + 1 : ARR[i];
            ARR[i] = Math.min(ARR[i], ARR[i - 1] + 1);

            for (int j = 1; j <= i && i * j < ARR.length; j++)
                if (ARR[i * j] == 0 || (ARR[i] + 1) < ARR[i * j])
                    ARR[i * j] = ARR[i] + 1;
        }
    }

    static int downToZero(int n) {
        return ARR[n];
    }

}
