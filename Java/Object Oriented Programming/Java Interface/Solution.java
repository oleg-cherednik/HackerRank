import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 22.09.2017
 */
public class Solution {
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

interface AdvancedArithmetic {
    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic {

    public int divisor_sum(int n) {
        int res = 0;

        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                res += i;

        return res;
    }
}


