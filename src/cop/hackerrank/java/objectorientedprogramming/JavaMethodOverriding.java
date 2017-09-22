package cop.hackerrank.java.objectorientedprogramming;

/**
 * <h1>Java Method Overriding</h1>
 * When a subclass inherits from a superclass, it also inherits its methods; however, it can also <tt>override</tt> the superclass methods (as well
 * as
 * declare and implement new ones). Consider the following <tt>Sports</tt> class:
 * <pre>
 * class Sports{
 *     String getName(){
 *         return "Generic Sports";
 *     }
 *     void getNumberOfTeamMembers(){
 *         System.out.println( "Each team has n players in " + getName() );
 *     }
 * }
 * </pre>
 * Next, we create a <tt>Soccer</tt> class that inherits from the <tt>Sports</tt> class. We can override the <tt>getName</tt> method and return a
 * different, subclass-specific string:
 * <pre>
 * class Soccer extends Sports{
 *    {@literal @Override}
 *     String getName(){
 *         return "Soccer Class";
 *     }
 * }
 * </pre>
 * <b>Note:</b> When overriding a method, you should precede it with the <tt>@Override</tt> annotation. The parameter(s) and return type of an
 * overridden method must be exactly the same as those of the method inherited from the supertype.<br>
 * <br>
 * <hr>
 * <h3>Task </h3>
 * Complete the code in your editor by writing an overridden <tt>getNumberOfTeamMembers</tt> method that prints the same statement as the superclass'
 * <tt>getNumberOfTeamMembers</tt> method, except that it replaces n with 11 (the number of players on a Soccer team).
 * <h3>Output Format</h3>
 * When executed, your completed code should print the following:
 * <pre>
 * Generic Sports
 * Each team has n players in Generic Sports
 * Soccer Class
 * Each team has 11 players in Soccer Class
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 22.09.2017
 */
public class JavaMethodOverriding {
    static class Sports {
        String getName() {
            return "Generic Sports";
        }

        void getNumberOfTeamMembers() {
            System.out.println("Each team has n players in " + getName());
        }
    }

    static class Soccre extends Sports {
        String getName() {
            return "Soccer Class";
        }

        void getNumberOfTeamMembers() {
            System.out.println("Each team has 11 players in " + getName());
        }
    }

    public static void main(String... args) {
        Sports c1 = new Sports();
        Soccre c2 = new Soccre();
        System.out.println(c1.getName());
        c1.getNumberOfTeamMembers();
        System.out.println(c2.getName());
        c2.getNumberOfTeamMembers();
    }
}
