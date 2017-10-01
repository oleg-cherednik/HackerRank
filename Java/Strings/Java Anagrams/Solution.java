import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.09.2017
 */
public class Solution {
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;

        char[] arrA = a.toLowerCase().toCharArray();
        char[] arrB = b.toLowerCase().toCharArray();

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        for (int i = 0; i < arrA.length; i++)
            if (arrA[i] != arrB[i])
                return false;

        return true;
    }

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println(ret ? "Anagrams" : "Not Anagrams");
    }
}
