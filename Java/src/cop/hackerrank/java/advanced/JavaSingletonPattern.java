package cop.hackerrank.java.advanced;

/**
 * <h1>Java Singleton Pattern</h1>
 * <blockquote>"The singleton pattern is a design pattern that restricts the instantiation of a class to one object. This is useful when exactly one
 * object is needed to coordinate actions across the system."<br>
 * - <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Wikipedia: Singleton Pattern</a></blockquote>
 * <p>
 * Complete the <tt>Singleton</tt> class in your editor which contains the following components:
 * <ol>
 * <li>A <tt>private Singleton</tt> non parameterized constructor.</li>
 * <li>A <tt>public</tt> String instance variable named <tt>str</tt>.</li>
 * <li>Write a <tt>static</tt> method named <tt>getSingleInstance</tt> that returns the single instance of the <tt>Singleton</tt> class.</li>
 * </ol>
 * Once submitted, our hidden <tt>Solution</tt> class will check your code by taking a String as input and then using your <tt>Singleton</tt> class to
 * print a line.
 * <h3>Input Format</h3>
 * You will not be handling any input in this challenge.
 * <h3>Output Format</h3>
 * <pre>
 * hello world
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * Hello I am a singleton! Let me say hello world to you
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 30.09.2017
 */
public class JavaSingletonPattern {
    private static final JavaSingletonPattern INSTANCE = new JavaSingletonPattern();

    public static JavaSingletonPattern getSingleInstance() {
        return INSTANCE;
    }

    public String str;

    private JavaSingletonPattern() {
    }
}
