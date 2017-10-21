import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 21.10.2017
 */
public class Solution {

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Pattern pattern = Pattern.compile("^(?:_|\\.)\\d+[A-Za-z]*_?$");
        scan.nextLine();

        for (int i = 0; i < n; i++)
            System.out.println(pattern.matcher(scan.nextLine()).matches() ? "VALID" : "INVALID");

        scan.close();
    }
}
