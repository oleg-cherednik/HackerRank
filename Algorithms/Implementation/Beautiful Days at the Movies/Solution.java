import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 02.06.2018
 */
public class Solution {

    static int beautifulDays(int i, int j, int k) {
        int res = 0;

        for (; i <= j; i++)
            if (Math.abs(Integer.parseInt(new StringBuilder().append(i).reverse().toString()) - i) % k == 0)
                res++;

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
