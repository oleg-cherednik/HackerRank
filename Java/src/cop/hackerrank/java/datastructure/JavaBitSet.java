package cop.hackerrank.java.datastructure;

import java.util.BitSet;
import java.util.Scanner;

/**
 * <h1>Java BitSet</h1>
 * Java's BitSet class implements a vector of bit values (i.e.: <tt>false</tt> (0) or <tt>true</tt> (1)) that grows as needed, allowing us to easily
 * manipulate bits while optimizing space (when compared to other collections). Any element having a bit value of 1 is called a <tt>set bit</tt>.<br>
 * <br>
 * Given 2 BitSets, <tt>B<sub>1</sub></tt> and <tt>B<sub>2</sub></tt>, of size <tt>N</tt> where all bits in both BitSets are initialized to 0,
 * perform a series of <tt>M</tt> operations. After each operation, print the number of <tt>set bits</tt> in the respective BitSets as two
 * space-separated integers on a new line.
 * <h3>Input Format</h3>
 * The first line contains 2 space-separated integers, <tt>N</tt> (the length of both BitSets <tt>B<sub>1</sub></tt> and <tt>B<sub>2</sub></tt>) and
 * <tt>M</tt> (the number of operations to perform), respectively.<br>
 * The <tt>M</tt> subsequent lines each contain an operation in one of the following forms:
 * <ul>
 * <li>AND {@literal <}set{@literal >} {@literal <}set{@literal >}</li>
 * <li>OR {@literal <}set{@literal >} {@literal <}set{@literal >}</li>
 * <li>XOR {@literal <}set{@literal >} {@literal <}set{@literal >}</li>
 * <li>FLIP {@literal <}set{@literal >} {@literal <}index{@literal >}</li>
 * <li>SET {@literal <}set{@literal >} {@literal <}index{@literal >}</li>
 * </ul>
 * In the list above, {@literal <}set{@literal >} is the integer 1 or 2, where 1 denotes <tt>B<sub>1</sub></tt> and 2 denotes <tt>B<sub>2</sub></tt>.
 * {@literal <}index{@literal >} is an integer denoting a bit's index in the BitSet corresponding to {@literal <}set{@literal >}.<br>
 * <br>
 * For the binary operations AND, OR, and XOR, operands are read from left to right and the BitSet resulting from the operation replaces the contents
 * of the <tt>first operand</tt>. For example:
 * <pre>
 * AND 2 1
 * </pre>
 * <tt>B<sub>2</sub></tt> is the left operand, and <tt>B<sub>1</sub></tt> is the right operand. This operation should assign the result of
 * <tt>B<sub>2</sub></tt> ∧ <tt>B<sub>1</sub></tt> to <tt>B<sub>2</sub></tt>.
 * <h3>Constraints</h3>
 * <ul>
 * <li>1 <= N <= 1000</li>
 * <li>1 <= M <= 10000</li>
 * </ul>
 * <h3>Output Format</h3>
 * After each operation, print the respective number of <tt>set bits</tt> in BitSet <tt>B<sub>1</sub></tt> and BitSet <tt>B<sub>2</sub></tt> as 2
 * space-separated integers on a new line.
 * <h3>Sample Input</h3>
 * <pre>
 * 5 4
 * AND 1 2
 * SET 1 4
 * FLIP 2 2
 * OR 2 1
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 0 0
 * 1 0
 * 1 1
 * 1 2
 * </pre>
 * <h3>Explanation</h3>
 * Initially: N = 5, M = 4, <tt>B<sub>1</sub></tt> = {0,0,0,0,0}, and <tt>B<sub>2</sub></tt> = {0,0,0,0,0}. At each step, we print the respective
 * number of <tt>set bits</tt> in <tt>B<sub>1</sub></tt> and <tt>B<sub>2</sub></tt> as a pair of space-separated integers on a new line.
 * <p>
 * <tt>M<sub>0</sub></tt> = AND 1 2<br>
 * <tt>B<sub>1</sub></tt> = <tt>B<sub>1</sub></tt> ∧ <tt>B<sub>2</sub></tt> = {0,0,0,0,0} ∧ {0,0,0,0,0} = {0,0,0,0,0}<br>
 * <tt>B<sub>1</sub></tt> = {0,0,0,0,0}, <tt>B<sub>2</sub></tt> = {0,0,0,0,0}<br>
 * The number of <tt>set bits</tt> in <tt>B<sub>1</sub></tt> and <tt>B<sub>2</sub></tt> is 0.
 * <p>
 * <tt>M<sub>1</sub></tt> = SET 1 4<br>
 * Set <tt>B<sub>1</sub></tt>[4] to <tt>true</tt> (1).<br>
 * <tt>B<sub>1</sub></tt> = {0,0,0,0,1}, <tt>B<sub>2</sub></tt> = {0,0,0,0,0}.<br>
 * The number of <tt>set bits</tt> in <tt>B<sub>1</sub></tt> is 1 and <tt>B<sub>2</sub></tt> is 0.
 * <p>
 * <tt>M<sub>2</sub></tt> = FLIP 2 2<br>
 * Flip <tt>B<sub>2</sub></tt>[2] from <tt>false</tt> (0) to <tt>true</tt> (1).<br>
 * <tt>B<sub>1</sub></tt> = {0,0,0,0,1}, <tt>B<sub>2</sub></tt> = {0,0,1,0,0}.<br>
 * The number of <tt>set bits</tt> in <tt>B<sub>1</sub></tt> is 1 and <tt>B<sub>2</sub></tt> is 1.
 * <p>
 * <tt>M<sub>3</sub></tt> = OR 2 1<br>
 * <tt>B<sub>1</sub></tt> = <tt>B<sub>2</sub></tt> ∨ <tt>B<sub>1</sub></tt> = {0,0,1,0,0} ∨ {0,0,0,0,1} = {0,0,1,0,1}<br>
 * <tt>B<sub>1</sub></tt> = {0,0,0,0,1}, <tt>B<sub>2</sub></tt> = {0,0,1,0,1}.<br>
 * The number of <tt>set bits</tt> in <tt>B<sub>1</sub></tt> is 1 and <tt>B<sub>2</sub></tt> is 2.
 *
 * @author Oleg Cherednik
 * @since 19.09.2017
 */
public class JavaBitSet {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);

        for (int i = 0; i < m; i++) {
            String op = scan.next();
            int x = scan.nextInt();
            int y = scan.nextInt();

            if ("AND".equals(op)) {
                BitSet a = x == 1 ? b1 : b2;
                BitSet b = y == 1 ? b1 : b2;
                a.and(b);
            } else if ("OR".equals(op)) {
                BitSet a = x == 1 ? b1 : b2;
                BitSet b = y == 1 ? b1 : b2;
                a.or(b);
            } else if ("XOR".equals(op)) {
                BitSet a = x == 1 ? b1 : b2;
                BitSet b = y == 1 ? b1 : b2;
                a.xor(b);
            } else if ("FLIP".equals(op)) {
                BitSet a = x == 1 ? b1 : b2;
                a.flip(y);
            } else if ("SET".equals(op)) {
                BitSet a = x == 1 ? b1 : b2;
                a.set(y);
            }

            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }

    }
}
