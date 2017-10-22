import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Oleg Cherednik
 * @since 22.10.2017
 */
public class Solution {

    public static void main(String... args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                String str = in.readLine();

                if (str.trim().startsWith("#include")) {
                    System.out.println("C");
                    return;
                }

                if (str.trim().startsWith("import")) {
                    System.out.println("Java");
                    return;
                }

                if (str.trim().startsWith("print")) {
                    System.out.println("Python");
                    return;
                }
            } while (in.ready());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
