/**
 * <p>Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right
 * corner.</p>
 * <div class="center">
 * <img src="p015.png" class="dark_img" alt="" /></div>
 * <p>How many such routes are there through a 20×20 grid?</p>
 *
 * @author Oleg Cherednik
 * @since 19.09.2020
 */
public class Euler {

    private static long latticePathEuler(int N, int M) {
        long[] row = new long[M + 1];

        for (int i = 0; i <= N; i++)
            for (int j = 0; j <= M; j++)
                row[j] = i == 0 || j == 0 ? 1 : (row[j] + row[j - 1]);

        return row[M];
    }

    public static void main(String... args) {
        System.out.println(latticePathEuler(20, 20));   // 137846528820
    }
}
