package cop.hackerrank.java.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <h1>Java Map</h1>
 * You are given a phone book that consists of people's names and their phone number. After that you will be given some person's name as query. For
 * each query, print the phone number of that person.
 * <h3>Input Format</h3>
 * The first line will have an integer <tt>n</tt> denoting the number of entries in the phone book. Each entry consists of two lines: a name and the
 * corresponding phone number.<br>
 * After these, there will be some queries. Each query will contain a person's name. Read the queries until end-of-file.
 * <h3>Constraints</h3>
 * A person's name consists of only lower-case English letters and it may be in the format 'first-name last-name' or in the format 'first-name'. Each
 * phone number has exactly 8 digits without any leading zeros.
 * <ul>
 * <li>1 <= n <= 100000</li>
 * <li>1 <= <tt>Query</tt> <= 100000</li>
 * </ul>
 * <h3>Output Format</h3>
 * For each case, print <tt>Not found</tt> if the person has no entry in the phone book. Otherwise, print the person's name and phone number. See
 * sample output for the exact format.<br>
 * To make the problem easier, we provided a portion of the code in the editor. You can either complete that code or write completely on your own.
 * <h3>Sample Input</h3>
 * <pre>
 * 3
 * uncle sam
 * 99912222
 * tom
 * 11122222
 * harry
 * 12299933
 * uncle sam
 * uncle tom
 * harry
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * uncle sam=99912222
 * Not found
 * harry=12299933
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 18.09.2017
 */
public class JavaMap {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        Map<String, Integer> phoneBook = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            phoneBook.put(name, phone);
            in.nextLine();
        }

        while (in.hasNext()) {
            String name = in.nextLine();

            if (phoneBook.containsKey(name))
                System.out.println(name + '=' + phoneBook.get(name));
            else
                System.out.println("Not found");
        }
    }
}
