package cop.hackerrank.java.advanced;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <h1>Java Reflection - Attributes</h1>
 * JAVA reflection is a very powerful tool to inspect the attributes of a class in runtime. For example, we can retrieve the list of public fields of
 * a class using <tt>getDeclaredMethods()</tt>.
 * <p>
 * In this problem, you will be given a class <tt>Solution</tt> in the editor. You have to fill in the incompleted lines so that it prints all the
 * methods of another class called <tt>Student</tt> in alphabetical order. We will append your code with the <tt>Student</tt> class before running
 * it.
 * The <tt>Student</tt> class looks like this:
 * <pre>
 * class Student{
 *     private String name;
 *     private String id;
 *     private String email;
 *
 *     public String getName() {
 *         return name;
 *     }
 *     public void setId(String id) {
 *         this.id = id;
 *     }
 *     public void setEmail(String email) {
 *         this.email = email;
 *     }
 *     public void anothermethod(){  }
 *     ......
 *     ......
 *     some more methods
 *     ......
 * }
 * </pre>
 * You have to print all the methods of the student class in alphabetical order like this:
 * <pre>
 * anothermethod
 * getName
 * setEmail
 * setId
 * ......
 * ......
 * some more methods
 * ......
 * </pre>
 * There is no sample input/output for this problem. If you press "Run Code", it will compile it, but it won't show any outputs.
 * <p>
 * <b>Hint:</b> See the oracle docs for more details about <a href="https://docs.oracle.com/javase/tutorial/reflect/class/classMembers.html">JAVA
 * Reflection Methods and Fields</a>
 *
 * @author Oleg Cherednik
 * @since 25.09.2017
 */
public class JavaReflectionAttributes {

    static class Student {
        private String name;
        private String id;
        private String email;

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void anothermethod() {
        }
    }

    public static void main(String... args) {
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for (Method method : methods) {
            methodList.add(method.getName());
        }
        Collections.sort(methodList);
        for (String name : methodList) {
            System.out.println(name);
        }
    }
}
