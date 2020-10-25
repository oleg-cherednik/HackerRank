/**
 * <p>If <i>p</i> is the perimeter of a right angle triangle with integral length sides, {<i>a</i>,<i>b</i>,<i>c</i>}, there are exactly three
 * solutions for <i>p</i> = 120.</p>
 * <p>{20,48,52}, {24,45,51}, {30,40,50}</p>
 * <p>For which value of <i>p</i> ≤ 1000, is the number of solutions maximised?</p>
 *
 * @author Oleg Cherednik
 * @since 25.10.2020
 */
public class Euler {

    public static void main(String... args) {
        System.out.println(Solution.getIntegerRightTriangles()[1000]);    // 840
    }

}
