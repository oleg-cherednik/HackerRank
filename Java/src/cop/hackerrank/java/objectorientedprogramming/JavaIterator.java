package cop.hackerrank.java.objectorientedprogramming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * <h1>Java Iterator</h1>
 * Java Iterator class can help you to iterate through every element in a collection. Here is a simple example:
 * <pre>
 * import java.util.*;
 * public class Example{
 *
 *     public static void main(String []args){
 *         ArrayList mylist = new ArrayList();
 *         mylist.add("Hello");
 *         mylist.add("Java");
 *         mylist.add("4");
 *         Iterator it = mylist.iterator();
 *         while(it.hasNext()){
 *             Object element = it.next();
 *             System.out.println((String)element);
 *         }
 *     }
 * }
 * </pre>
 * In this problem you need to complete a method <tt>func</tt>. The method takes an <tt>ArrayList</tt> as input. In that <tt>ArrayList</tt> there is
 * one or more integer numbers, then there is a special string "###", after that there are one or more other strings. A sample <tt>ArrayList</tt> may
 * look like this:
 * <pre>
 * element[0]=>42
 * element[1]=>10
 * element[2]=>"###"
 * element[3]=>"Hello"
 * element[4]=>"Java"
 * </pre>
 * You have to modify the <tt>func</tt> method by editing <tt>at most 2 lines</tt> so that the code only prints the elements after the special string
 * "###". For the sample above the output will be:
 * <pre>
 * Hello
 * Java
 * </pre>
 * <tt>Note:</tt> The stdin doesn't contain the string "###", it is added in the <tt>main</tt> method.<br>
 * To restore the original code in the editor, click the top left icon on the editor and create a new buffer.
 *
 * @author Oleg Cherednik
 * @since 22.09.2017
 */
public class JavaIterator {
    static Iterator func(ArrayList mylist) {
        Iterator it = mylist.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            if (element instanceof String)
                break;
        }
        return it;
    }

    public static void main(String... args) {
        ArrayList mylist = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            mylist.add(sc.nextInt());
        }

        mylist.add("###");
        for (int i = 0; i < m; i++) {
            mylist.add(sc.next());
        }

        Iterator it = func(mylist);
        while (it.hasNext()) {
            Object element = it.next();
            System.out.println((String)element);
        }
    }

}
