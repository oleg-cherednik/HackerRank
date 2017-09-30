import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

/**
 * @author Oleg Cherednik
 * @since 30.09.2017
 */
public class Solution {
    public static void main(String... args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());
            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

class Prime {
    public void checkPrime(int... vals) {
        boolean space = false;

        for (int val : vals) {
            if (!isPrime(val))
                continue;
            if (space)
                System.out.print(' ');
            System.out.print(val);
            space = true;
        }

        System.out.println();
    }

    private static boolean isPrime(int val) {
        if (val < 2)
            return false;

        int sqrt = (int)Math.sqrt(val);

        for (int i = 2; i <= sqrt; i++)
            if (val % i == 0)
                return false;

        return true;
    }
}
