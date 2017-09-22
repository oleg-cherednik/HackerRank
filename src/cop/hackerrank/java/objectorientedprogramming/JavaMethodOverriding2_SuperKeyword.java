package cop.hackerrank.java.objectorientedprogramming;

/**
 * <h1>Java Method Overriding 2 (Super Keyword)</h1>
 * When a method in a subclass overrides a method in superclass, it is still possible to call the overridden method using <b>super</b> keyword. If you
 * write <tt>super.func()</tt> to call the function <tt>func()</tt>, it will call the method that was defined in the superclass.
 * </p>
 * You are given a partially completed code in the editor. Modify the code so that the code prints the following text:
 * <pre>
 * Hello I am a motorcycle, I am a cycle with an engine.
 * My ancestor is a cycle who is a vehicle with pedals.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 22.09.2017
 */
public class JavaMethodOverriding2_SuperKeyword {
    static class BiCycle {
        String define_me() {
            return "a vehicle with pedals.";
        }
    }

    static class MotorCycle extends BiCycle {
        String define_me() {
            return "a cycle with an engine.";
        }

        MotorCycle() {
            System.out.println("Hello I am a motorcylce, I am " + define_me());
            String temp = super.define_me();
            System.out.println("My ancestor is a cycle who is " + temp);
        }
    }

    public static void main(String... args) {
        MotorCycle M = new MotorCycle();
    }

}
