package cop.hackerrank.java.datastructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * <h1>Java Comparator</h1>
 * Comparators are used to compare two objects. In this challenge, you'll create a comparator and use it to sort an array.<br>
 * <br>
 * The <tt>Player</tt> class is provided for you in your editor. It has 2 fields: a <tt>name</tt> String and a <tt>score</tt> integer.<br>
 * <br>
 * Given an array of <tt>Player</tt> objects, write a comparator that sorts them in order of decreasing score; if 2 or more players have the same
 * score, sort those players alphabetically by name. To do this, you must create a <tt>Checker</tt> class that implements the <tt>Comparator</tt>
 * interface, then write an <tt>int compare(Player a, Player b)</tt> method implementing the <tt>Comparator.compare(T o1, T o2)</tt> method.
 * <h3>Input Format</h3>
 * Input from stdin is handled by the locked stub code in the <tt>Solution</tt> class.<br>
 * <br>
 * The first line contains an integer, n, denoting the number of players.<br>
 * Each of the n subsequent lines contains a player's <tt>name</tt> and <tt>score</tt>, respectively.
 * <h3>Constraints</h3>
 * <ul>
 * <li>0 <= score <= 1000</li>
 * <li>2 players can have the same name.</li>
 * <li>Player names consist of lowercase English letters.</li>
 * </ul>
 * <h3>Output Format</h3>
 * You are not responsible for printing any output to stdout. The locked stub code in <tt>Solution</tt> will create a <tt>Checker</tt> object, use it
 * to sort the <tt>Player</tt> array, and print each sorted element.
 * <h3>Sample Input</h3>
 * <pre>
 * 5
 * amy 100
 * david 100
 * heraldo 50
 * aakansha 75
 * aleksa 150
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * aleksa 150
 * amy 100
 * david 100
 * aakansha 75
 * heraldo 50
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 18.09.2017
 */
public class JavaComparator {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker studentChecker = new Checker();

        for (int i = 0; i < n; i++)
            player[i] = new Player(scan.next(), scan.nextInt());

        scan.close();

        Arrays.sort(player, studentChecker);
        for (int i = 0; i < player.length; i++)
            System.out.printf("%s %s\n", player[i].name, player[i].score);
    }

    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static class Checker implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            int res = Integer.compare(o2.score, o1.score);
            return res == 0 ? o1.name.compareTo(o2.name) : res;
        }
    }
}
