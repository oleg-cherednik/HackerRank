import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.07.2018
 */
public class Solution {

    static String pangrams(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++)
            if (Character.isAlphabetic(s.charAt(i)))
                arr[Character.toLowerCase(s.charAt(i)) - 'a']++;

        for (int count : arr)
            if (count == 0)
                return "not pangram";

        return "pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        String result = pangrams(s);
        System.out.println(result);

        scanner.close();
    }
}
