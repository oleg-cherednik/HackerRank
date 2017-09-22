package cop.hackerrank.java.objectorientedprogramming;

import java.util.Scanner;

/**
 * <h1>Java Interface</h1>
 * A Java interface can only contain method signatures and fields. The interface can be used to achieve polymorphism. In this problem, you will
 * practice your knowledge on interfaces.
 * </p>
 * You are given an interface <tt>AdvancedArithmetic</tt> which contains a method signature <tt>int divisor_sum(int n)</tt>. You need to write a
 * class called  MyCalculator which implements the interface.
 * </p>
 * <tt>divisorSum</tt> function just takes an integer as input and return the sum of all its divisors. For example divisors of 6 are 1, 2, 3 and 6,
 * so <tt>divisor_sum</tt> should return 12. The value of n will be at most 1000.
 * </p>
 * Read the partially completed code in the editor and complete it. You just need to write the MyCalculator class only. <tt>Your class shouldn't be
 * public</tt>.
 * <h3>Sample Input</h3>
 * <pre>
 * 6
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * I implemented: AdvancedArithmetic
 * 12
 * </pre>
 * <h3>Explanation</h3>
 * Divisors of 6 are 1,2,3 and 6. 1+2+3+6=12.
 *
 * @author Oleg Cherednik
 * @since 22.09.2017
 */
public class JavaInterface {
    interface AdvancedArithmetic {
        int divisor_sum(int n);
    }

    static class MyCalculator implements AdvancedArithmetic {

        public int divisor_sum(int n) {
            int res = 0;

            for(int i = 1; i <= n; i++)
                if(n % i == 0)
                    res += i;

            return res;
        }
    }

    public static void main(String... args) {
        MyCalculator my_calculator = new MyCalculator();
        System.out.println("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(my_calculator.divisor_sum(n) + "\n");
        sc.close();
    }

    static void ImplementedInterfaceNames(Object o) {
        Class[] theInteefaces = o.getClass().getInterfaces();

        for (int i = 0; i < theInteefaces.length; i++) {
            String interfaceName = theInteefaces[i].getName();
            System.out.println(interfaceName);
        }
    }

}
