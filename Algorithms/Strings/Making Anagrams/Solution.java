import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.07.2018
 */
public class Solution {

    static int makingAnagrams(String s1, String s2) {
        int[] arr = new int[26];

        for (int i = 0; i < s1.length(); i++)
            arr[s1.charAt(i) - 'a']++;

        for (int i = 0; i < s2.length(); i++)
            arr[s2.charAt(i) - 'a']--;

        int res = 0;

        for (int v : arr)
            res += Math.abs(v);

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
