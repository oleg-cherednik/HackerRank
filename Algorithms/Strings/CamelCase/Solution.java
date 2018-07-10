import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 10.07.2018
 */
public class Solution {

    static int camelcase(String s) {
        int total = 0;

        for (int i = 0; i < s.length(); i++)
            if (i == 0 || Character.isUpperCase(s.charAt(i)))
                total++;

        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        int result = camelcase(s);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
