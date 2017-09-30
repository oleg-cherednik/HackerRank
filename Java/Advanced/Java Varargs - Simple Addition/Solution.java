import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 25.09.2017
 */
public class Solution {
    public static void main(String... args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            int n6 = Integer.parseInt(br.readLine());

            Add ob = new Add();
            ob.add(n1, n2);
            ob.add(n1, n2, n3);
            ob.add(n1, n2, n3, n4, n5);
            ob.add(n1, n2, n3, n4, n5, n6);

            Method[] methods = Add.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;

            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }

                set.add(methods[i].getName());
            }

            if (overload)
                throw new Exception("Overloading not allowed");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class Add {
    public void add(int... arr) {
        int sum = 0;
        StringBuilder buf = new StringBuilder();

        for (int val : arr) {
            if (buf.length() > 0)
                buf.append('+');
            buf.append(val);

            sum += val;
        }

        buf.append('=').append(sum);
        System.out.println(buf);
    }
}
