package cop.hackerrank.java.objectorientedprogramming;

import java.util.Scanner;

/**
 * <h1>Java Abstract Class</h1>
 * A Java abstract class is a class that can't be instantiated. That means you cannot create new instances of an abstract class. It works as a base
 * for subclasses. You should learn about Java Inheritance before attempting this challenge.<br>
 * <br>
 * Following is an example of abstract class:
 * <pre>
 * abstract class Book{
 *     String title;
 *     abstract void setTitle(String s);
 *     String getTitle(){
 *         return title;
 *     }
 * }
 * </pre>
 * If you try to create an instance of this class like the following line you will get an error:
 * <pre>
 * Book new_novel=new Book();
 * </pre>
 * You have to create another class that extends the abstract class. Then you can create an instance of the new class.<br>
 * Notice that <tt>setTitle</tt> method is abstract too and has no body. That means you must implement the body of that method in the child
 * class.<br>
 * In the editor, we have provided the abstract <tt>Book</tt> class and a <tt>Main</tt> class. In the Main class, we created an instance of a class
 * called <tt>MyBook</tt>. Your task is to write just the <tt>MyBook</tt> class.<br>
 * Your class mustn't be public.
 * <h3>Sample Input</h3>
 * <pre>
 * A tale of two cities
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * The title is: A tale of two cities
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 22.09.2017
 */
public class JavaAbstractClass {
    abstract static class Book {
        String title;

        abstract void setTitle(String s);

        String getTitle() {
            return title;
        }
    }

    static class MyBook extends Book {
        void setTitle(String s) {
            title = s;
        }
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        MyBook new_novel = new MyBook();
        new_novel.setTitle(title);
        System.out.println("The title is: " + new_novel.getTitle());
        sc.close();
    }
}
