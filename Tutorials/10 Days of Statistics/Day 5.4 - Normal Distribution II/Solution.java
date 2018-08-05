import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###.##");

        double mean = 70;
        double stdev = 10;

        System.out.println(df.format((1 - normal(80, mean, stdev)) * 100)); //greater than 80
        System.out.println(df.format((1 - normal(60, mean, stdev)) * 100)); //greater than equal to 60
        System.out.println(df.format(normal(60, mean, stdev) * 100)); //less than 60
    }

    public static double normal(double x, double mean, double stdev) {
        return 0.5 * (1 + erf((x - mean) / (1.4142135623730951 * stdev)));
    }

    public static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

        // use Horner's method
        double ans = 1 - t * Math.exp(-z * z - 1.26551223 +
                t * (1.00002368 +
                        t * (0.37409196 +
                                t * (0.09678418 +
                                        t * (-0.18628806 +
                                                t * (0.27886807 +
                                                        t * (-1.13520398 +
                                                                t * (1.48851587 +
                                                                        t * (-0.82215223 +
                                                                                t * (0.17087277))))))))));
        if (z >= 0) return ans;
        else return -ans;
    }

}

