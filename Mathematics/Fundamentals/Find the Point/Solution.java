import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.08.2018
 */
public class Solution {

    static int[] findPoint(int px, int py, int qx, int qy) {
        int dx = Math.abs(qx - px);
        int dy = Math.abs(qy - py);

        int rx = qx == px ? px : qx > px ? qx + dx : qx - dx;
        int ry = qy >= py ? qy + dy : qy - dy;

        return new int[] { rx, ry };
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine().trim());

        for (int nItr = 0; nItr < n; nItr++) {
            String[] pxPyQxQy = scanner.nextLine().split(" ");

            int px = Integer.parseInt(pxPyQxQy[0].trim());

            int py = Integer.parseInt(pxPyQxQy[1].trim());

            int qx = Integer.parseInt(pxPyQxQy[2].trim());

            int qy = Integer.parseInt(pxPyQxQy[3].trim());

            int[] result = findPoint(px, py, qx, qy);

            for (int resultItr = 0; resultItr < result.length; resultItr++) {
                System.out.print(String.valueOf(result[resultItr]));

                if (resultItr != result.length - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

}
