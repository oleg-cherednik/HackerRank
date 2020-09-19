/**
 * <p>You are given the following information, but you may prefer to do some research for yourself.</p>
 * <ul><li>1 Jan 1900 was a Monday.</li>
 * <li>Thirty days has September,<br />
 * April, June and November.<br />
 * All the rest have thirty-one,<br />
 * Saving February alone,<br />
 * Which has twenty-eight, rain or shine.<br />
 * And on leap years, twenty-nine.</li>
 * <li>A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.</li>
 * </ul><p>How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?</p>
 *
 * @author Oleg Cherednik
 * @since 19.09.2020
 */
public class Euler {

    public static void main(String... args) {
        System.out.println(Solution.countSundays(1901, 1, 1, 2000, 12, 31)); // 171
    }
}
