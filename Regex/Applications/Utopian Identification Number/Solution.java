import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 22.10.2017
 */
public class Solution {

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        Pattern pattern = Pattern.compile("^[a-z]{0,3}\\d{2,8}[A-Z]{3,}$");
        scan.nextLine();

        for (int i = 0; i < N; i++)
            System.out.println(pattern.matcher(scan.nextLine()).matches() ? "VALID" : "INVALID");

        scan.close();
    }
}
