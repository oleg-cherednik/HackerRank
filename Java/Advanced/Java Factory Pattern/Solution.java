import java.security.Permission;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 30.09.2017
 */
public class Solution {
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
}

interface Food {
    public String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String order) {
        if ("cake".equalsIgnoreCase(order))
            return new Cake();
        if ("pizza".equalsIgnoreCase(order))
            return new Pizza();
        return null;
    }
}

class Do_Not_Terminate {
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
