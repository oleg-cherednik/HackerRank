package cop.hackerrank.java.objectorientedprogramming;

/**
 * <h1>Java Inheritance I</h1>
 * Using <tt>inheritance</tt>, one class can acquire the properties of others. Consider the following <tt>Animal</tt> class:
 * <pre>
 * class Animal {
 *     void walk() {
 *         System.out.println("I am walking");
 *     }
 * }
 * </pre>
 * This class has only one method, <tt>walk</tt>. Next, we want to create a <tt>Bird</tt> class that also has a <tt>fly</tt> method. We do this using
 * <tt>extends</tt> keyword:
 * <pre>
 * class Bird extends Animal {
 *     void fly() {
 *         System.out.println("I am flying");
 *     }
 * }
 * </pre>
 * Finally, we can create a Bird object that can both <tt>fly</tt> and <tt>walk</tt>.
 * <pre>
 * public class Solution{
 *     public static void main(String[] args){
 *         Bird bird = new Bird();
 *         bird.walk();
 *         bird.fly();
 *     }
 * }
 * </pre>
 * The above code will print:
 * <pre>
 * I am walking
 * I am flying
 * </pre>
 * This means that a Bird object has all the properties that an Animal object has, as well as some additional unique properties.<br>
 * <br>
 * The code above is provided for you in your editor. You must add a <tt>sing</tt> method to the <tt>Bird</tt> class, then modify the <tt>main</tt>
 * method accordingly so that the code prints the following lines:
 * <pre>
 * I am walking
 * I am flying
 * I am singing
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 21.09.2017
 */
public class JavaInheritance1 {
    static class Animal {
        void walk() {
            System.out.println("I am walking");
        }
    }

    static class Bird extends Animal {
        void fly() {
            System.out.println("I am flying");
        }

        void sing() {
            System.out.println("I am singing");
        }
    }

    public static void main(String... args) {
        Bird bird = new Bird();
        bird.walk();
        bird.fly();
        bird.sing();
    }
}
