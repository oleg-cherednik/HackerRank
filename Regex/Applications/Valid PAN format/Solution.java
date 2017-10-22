import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 22.10.2017
 */
public class Solution {

    private static final Pattern PATTERN = Pattern.compile("^[A-Z]{5}\\d{4}[A-Z]$");

    private static boolean isValidPAN(String s) {
        return PATTERN.matcher(s).matches();
    }

    public static void main(String... args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int i = Integer.parseInt(br.readLine());
            for (int j = 0; j < i; j++) {
                String s = br.readLine();
                System.out.println(isValidPAN(s) ? "YES" : "NO");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        Pattern pattern = Pattern.compile("^[A-Z]{5}\\d{4}[A-Z]$");
        scan.nextLine();

        for (int i = 0; i < N; i++)
            System.out.println(pattern.matcher(scan.nextLine()).matches() ? "YES" : "NO");

        scan.close();
    }
}
