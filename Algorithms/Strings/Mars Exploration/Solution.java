import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.07.2018
 */
public class Solution {

    static int marsExploration(String s) {
        int res = 0;

        for (int i = 0; i <= s.length() - 3; i += 3) {
            res += s.charAt(i) != 'S' ? 1 : 0;
            res += s.charAt(i + 1) != 'O' ? 1 : 0;
            res += s.charAt(i + 2) != 'S' ? 1 : 0;
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        int result = marsExploration(s);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
