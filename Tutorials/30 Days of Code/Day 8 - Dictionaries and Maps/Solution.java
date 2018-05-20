import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 20.05.2018
 */
public class Solution {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> phoneBook = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            phoneBook.put(name, phone);
        }
        while (in.hasNext()) {
            String s = in.next();
            // Write code here
            System.out.println(phoneBook.containsKey(s) ? s + '=' + phoneBook.get(s) : "Not found");
        }
        in.close();
    }
}
