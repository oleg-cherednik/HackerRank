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

        Pattern pattern = Pattern.compile("(?i)hackerrank");
        scan.nextLine();

        int total = 0;

        for (int i = 0; i < N; i++)
            if (pattern.matcher(scan.nextLine()).find())
                total++;

        System.out.println(total);
        scan.close();
    }
}
