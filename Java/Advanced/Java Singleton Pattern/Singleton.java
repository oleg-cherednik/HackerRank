/**
 * @author Oleg Cherednik
 * @since 30.09.2017
 */
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getSingleInstance() {
        return INSTANCE;
    }

    public String str;

    private Singleton() {
    }
}
