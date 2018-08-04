import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.05.2018
 */
public class Solution {

    private static int deleteAmount(String a, String b) {
        int[] arr = new int['z' - 'a' + 1];

        a = a.toLowerCase();
        b = b.toLowerCase();

        for (int i = 0; i < a.length(); i++)
            arr[a.charAt(i) - 'a']++;

        for (int i = 0; i < b.length(); i++)
            arr[b.charAt(i) - 'a']--;

        int res = 0;

        for(int val : arr)
            res += Math.abs(val);

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scanner.nextLine();

        String b = scanner.nextLine();

        System.out.println(deleteAmount(a, b));

        scanner.close();
    }

}
