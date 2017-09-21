package cop.hackerrank.java.strings;

import java.util.Scanner;

/**
 * <h1>Valid Username Regular Expression</h1>
 * A username is considered valid if all the following constraints are satisfied:
 * <ul>
 * <li>The username consists of 8 to 30 characters inclusive, i.e., if the username consists of less than 8 or greater than 30 characters, then it is
 * invalid username.</li>
 * <li>The username must contain alphanumeric characters, and underscores (_) only. Alphanumeric characters describe the character set consisting of
 * <tt>lowercase</tt> characters [a-z], <tt>uppercase</tt> characters [A-Z], and digits [0-9].</li>
 * <li>The <tt>first</tt> character of the username must be an <tt>alphabetic</tt> character, i.e., either <tt>lowercase</tt> character [a-z] or
 * <tt>uppercase</tt> character [A-Z].</li>
 * </ul>
 * For example:
 * <ul>
 * <li><tt><font color="red">Julia</font></tt> is invalid user name because it contains less than 8 characters.</li>
 * <li><tt><font color="green">Samantha</font></tt> is valid as it satisfies all the three constraints for a valid username.</li>
 * <li><tt><font color="green">Samantha_21</font></tt> is valid as it satisfies all the three constraints for a valid username.</li>
 * <li><tt><font color="red">1</font><font color="green">Samantha</font></tt> is invalid as the first character must be <tt>alphabetic</tt>.</li>
 * <li><tt><font color="green">Samantha</font><font color="red">?</font><font color="green">10_2A</font></tt> is invalid as it contains the <tt><font
 * color="red">?</font></tt> which does not belong to any of the allowed characters set.</li>
 * </ul>
 * Update the value of <tt>regularExpression</tt> field in the <tt>UsernameValidator</tt> class so that the regular expression only matches with
 * valid
 * usernames.
 * <h3>Input Format</h3>
 * The first line of input contains an integer <tt>n</tt>, describing the total number of usernames. Each of the next <tt>n</tt> lines contains a
 * string describing the username. The locked stub code reads the inputs and validates the username.
 * <h3>Constraints</h3>
 * <ul>
 * <li>1 <= n <= 100</li>
 * <li>The username consists of any printable characters.</li>
 * </ul>
 * <h3>Output Format</h3>
 * For each of the usernames, the locked stub code prints <tt>Valid</tt> if the username is valid; otherwise <tt>Invalid</tt> each on a new line.
 * <h3>Sample Input 0</h3>
 * <pre>
 * 8
 * Julia
 * Samantha
 * Samantha_21
 * 1Samantha
 * Samantha?10_2A
 * JuliaZ007
 * Julia@007
 * _Julia007
 * </pre>
 * <h3>Sample Output 0</h3>
 * <pre>
 * Invalid
 * Valid
 * Valid
 * Invalid
 * Invalid
 * Valid
 * Invalid
 * Invalid
 * </pre>
 * <h3>Explanation 0</h3>
 * <ul>
 * <li><tt><font color="red">Julia</font></tt> is invalid user name because it contains less than 8 characters.</li>
 * <li><tt><font color="green">Samantha</font></tt> is valid as it satisfies all the three constraints for a valid username.</li>
 * <li><tt><font color="green">Samantha_21</font></tt> is valid as it satisfies all the three constraints for a valid username.</li>
 * <li><tt><font color="red">1</font><font color="green">Samantha</font></tt> is invalid as the first character must be <tt>alphabetic</tt>.</li>
 * <li><tt><font color="green">Samantha</font><font color="red">?</font><font color="green">10_2A</font></tt> is invalid as it contains the <tt><font
 * color="red">?</font></tt> which does not belong to any of the allowed characters set.</li>
 * <li><tt><font color="green">JuliaZ007</font></tt> is valid as it satisfies all the three constraints for a valid username.</li>
 * <li><tt><font color="green">Julia</font><font color="red">@</font><font color="green">007</font></tt> is invalid user name because it contains the
 * invalid character <font color="red">@</font>.</li>
 * <li><tt><font color="red">_</font><font color="green">Juliz007</font></tt> is invalid user name as the first character is <font
 * color="red">_</font> which is not an <tt>alphabetic</tt> character.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class ValidUsernameRegularExpression {
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

    static class UseranmeValidator {

        public static final String regularExpression = "[A-Za-z][\\w\\d_]{7,29}";
    }

}

