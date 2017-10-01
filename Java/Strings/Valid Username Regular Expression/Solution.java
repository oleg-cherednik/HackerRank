import java.util.Scanner;

/**
 * @since 14.09.2017
 */
public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String... args) {
        int n = Integer.parseInt(scan.nextLine());

        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UseranmeValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }

}

class UseranmeValidator {

    public static final String regularExpression = "[A-Za-z]\\w{7,29}";
}

