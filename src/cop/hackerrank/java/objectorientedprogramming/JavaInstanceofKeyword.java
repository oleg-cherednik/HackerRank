package cop.hackerrank.java.objectorientedprogramming;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1>Java Instanceof keyword</h1>
 * The Java <tt>instanceof</tt> operator is used to test if the object or instance is an instanceof the specified type.<br>
 * In this problem we have given you three classes in the editor:
 * <ul>
 * <li>Student class</li>
 * <li>Rockstar class</li>
 * <li>Hacker class</li>
 * </ul>
 * In the main method, we populated an <tt>ArrayList</tt> with several instances of these classes. <tt>count</tt> method calculates how many
 * instances of each type is present in the ArrayList. The code prints three integers, the number of instance of Student class, the number of instance
 * of Rockstar class, the number of instance of Hacker class.
 * </p>
 * But some lines of the code are missing, and you have to fix it by modifying only 3 lines! Don't add, delete or modify any extra line.<br>
 * To restore the original code in the editor, click on the top left icon in the editor and create a new buffer.
 * <h3>Sample Input</h3>
 * <pre>
 * 5
 * Student
 * Student
 * Rockstar
 * Student
 * Hacker
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 3 1 1
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 22.09.2017
 */
public class JavaInstanceofKeyword {
    static class Student {
    }

    static class Rockstar {
    }

    static class Hacker {
    }

    static String count(ArrayList mylist) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < mylist.size(); i++) {
            Object element = mylist.get(i);
            if (element instanceof Student)
                a++;
            if (element instanceof Rockstar)
                b++;
            if (element instanceof Hacker)
                c++;
        }
        String ret = Integer.toString(a) + " " + Integer.toString(b) + " " + Integer.toString(c);
        return ret;
    }

    public static void main(String... args) {
        ArrayList mylist = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            if (s.equals("Student")) mylist.add(new Student());
            if (s.equals("Rockstar")) mylist.add(new Rockstar());
            if (s.equals("Hacker")) mylist.add(new Hacker());
        }
        System.out.println(count(mylist));
    }
}
