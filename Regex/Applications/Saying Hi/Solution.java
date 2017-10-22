import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 22.10.2017
 */
public class Solution {

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Pattern pattern = Pattern.compile("^[Hh][Ii]\\s[^Dd].*$");
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            String str = scan.nextLine();

            if (pattern.matcher(str).matches())
                System.out.println(str);
        }

        scan.close();
    }
}
