/**
 * Starting with the number <tt>1</tt> and moving to the right in a clockwise direction a <tt>5</tt> by <tt>5</tt>
 * spiral is formed as follows:<br>
 * <br>
 * <span class="red"><b>21</b></span> 22 23 24 <span class="red"><b>25</b></span><br/>
 * 20 <span class="red"><b>07</b></span> 08 <span class="red"><b>09</b></span> 10<br/>
 * 19 06 <span class="red"><b>01</b></span> 02 11<br/>
 * 18 <span class="red"><b>05</b></span> 04 <span class="red"><b>03</b></span> 12<br/>
 * <span class="red"><b>17</b></span> 16 15 14 <span class="red"><b>13</b></span><br/>
 * <br>
 * It can be verified that the sum of the numbers on the diagonals is <tt>101</tt>.
 * <p>
 * What is the sum of the numbers on the diagonals in a <tt>1001</tt> by <tt>1001</tt> spiral formed in the same way?
 *
 * @author Oleg Cherednik
 * @since 24.05.2021
 */
public class Euler {

    public static void main(String... args) {
        long res = Solution.findDiagonalSum(1001);
        System.out.println(res);    // 669171001
    }

}
