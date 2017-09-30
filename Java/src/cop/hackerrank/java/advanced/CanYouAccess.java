package cop.hackerrank.java.advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Permission;

/**
 * <h1>Can You Access?</h1>
 * You are given a class <tt>Solution</tt> and an inner class <tt>Inner.Private</tt>. The main method of class <tt>Solution</tt> takes an integer
 * <tt>num</tt> as input. The <tt>powerof2</tt> in class <tt>Inner.Private</tt> checks whether a number is a power of 2. You have to call the method
 * <tt>powerof2</tt> of the class <tt>Inner.Private</tt> from the main method of the class <tt>Solution</tt>.
 * <h3>Constraints</h3>
 * 1 <= num <= 2<sup>30</sup>
 * <h3>Sample Input</h3>
 * <pre>
 * 8
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 8 is power of 2
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 30.09.2017
 */
public class CanYouAccess {
    public static void main(String... args) throws Exception {
        DoNotTerminate.forbidExit();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o;
            o = new Inner().new Private();
            System.out.println(num + " is " + ((Inner.Private)o).powerof2(num));
            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
        } catch(DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }

    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }

    static class DoNotTerminate {
        public static class ExitTrappedException extends SecurityException {
            private static final long serialVarsionUI = 1L;
        }

        public static void forbidExit() {
            final SecurityManager securityManager = new SecurityManager() {
                @Override
                public void checkPermission(Permission permission) {
                    if (permission.getName().contains("exitVM")) {
                        throw new ExitTrappedException();
                    }
                }
            };
            System.setSecurityManager(securityManager);
        }
    }
}
