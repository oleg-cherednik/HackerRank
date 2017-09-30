package cop.hackerrank.java.advanced;

import java.security.Permission;
import java.util.Scanner;

/**
 * <h1>Java Factory Pattern</h1>
 * According to Wikipedia, a factory is simply an object that returns another object from some other method call, which is assumed to be "new".
 * <p>
 * In this problem, you are given an interface <tt>Food</tt>. There are two classes <tt>Pizza</tt> and <tt>Cake</tt> which implement the
 * <tt>Food</tt>
 * interface, and they both contain a method <tt>getType()</tt>.
 * <p>
 * The main function in the <tt>Main</tt> class creates an instance of the <tt>FoodFactory</tt> class. The <tt>FoodFactory</tt> class contains a
 * method <tt>getFood(String)</tt> that returns a new instance of <tt>Pizza</tt> or <tt>Cake</tt> according to its parameter.
 * <p>
 * You are given the partially completed code in the editor. Please complete the <tt>FoodFactory</tt> class.
 * <h3>Sample Input 1</h3>
 * <pre>
 * cake
 * </pre>
 * <h3>Sample Output 1</h3>
 * <pre>
 * The factory returned class Cake
 * Someone ordered a Dessert!
 * </pre>
 * <h3>Sample Input 2</h3>
 * <pre>
 * pizza
 * </pre
 * <h3>Sample Output 2</h3>
 * <pre>
 * The factory returned class Pizza
 * Someone ordered Fast Food!
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 30.09.2017
 */
public class JavaFactoryPattern {
    static interface Food {
        public String getType();
    }

    static class Pizza implements Food {
        public String getType() {
            return "Someone ordered a Fast Food!";
        }
    }

    static class Cake implements Food {
        public String getType() {
            return "Someone ordered a Dessert!";
        }
    }

    static class FoodFactory {
        public Food getFood(String order) {
            if ("cake".equalsIgnoreCase(order))
                return new Cake();
            if ("pizza".equalsIgnoreCase(order))
                return new Pizza();
            return null;
        }
    }

    public static void main(String... args) {
        Do_Not_Terminate.forbidExit();

        try {
            Scanner scan = new Scanner(System.in);
            FoodFactory foodFactory = new FoodFactory();
            Food food = foodFactory.getFood(scan.nextLine());
            System.out.println("The factory returned " + food.getClass());
            System.out.println(food.getType());
        } catch(Do_Not_Terminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!");
        }
    }

    static class Do_Not_Terminate {
        public static class ExitTrappedException extends SecurityException {
            private static final long serialVersionUID = 1L;
        }

        public static void forbidExit() {
            final SecurityManager securityManager = new SecurityManager() {
                @Override
                public void checkPermission(Permission permission) {
                    if (permission.getName().contains("exitVM"))
                        throw new ExitTrappedException();
                }
            };
            System.setSecurityManager(securityManager);
        }
    }


}
