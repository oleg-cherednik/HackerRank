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
            boolean multi = false;

            do {
                String str = in.readLine();

                if (multi) {
                    int pos = str.indexOf("*/");

                    if (pos >= 0) {
                        multi = false;
                        System.out.println(str.substring(0, pos + 2).trim());
                    } else
                        System.out.println(str.trim());
                } else {
                    int pos1 = str.indexOf("//");
                    int pos2 = str.indexOf("/*");

                    if (pos1 > -1) {
                        if (pos2 < 0 || pos1 < pos2)
                            System.out.println(str.substring(pos1));
                    } else if (pos2 > -1) {
                        pos1 = str.indexOf("*/", pos2);

                        if (pos1 > -1)
                            System.out.println(str.substring(pos2, pos1 + 2));
                        else {
                            multi = true;
                            System.out.println(str.substring(pos2));
                        }
                    }
                }
            } while (in.ready());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
