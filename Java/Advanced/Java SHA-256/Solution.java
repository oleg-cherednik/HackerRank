import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 01.10.2017
 */
public class Solution {
    public static void main(String... args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        MessageDigest md5 = MessageDigest.getInstance("SHA-256");
        md5.update(s.getBytes(StandardCharsets.UTF_8));

        for (byte b : md5.digest())
            System.out.printf("%02x", b);

        System.out.println();
        scan.close();
    }
}
