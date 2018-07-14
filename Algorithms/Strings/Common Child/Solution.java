import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 14.07.2018
 */
public class Solution {

    static int commonChild(String s1, String s2) {
        int[][] arr = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length(); i++)
            for (int j = 0; j < s2.length(); j++)
                arr[i + 1][j + 1] = s1.charAt(i) == s2.charAt(j) ? arr[i][j] + 1 : Math.max(arr[i][j + 1], arr[i + 1][j]);

        return arr[s2.length()][s1.length()];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
