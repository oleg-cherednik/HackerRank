import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Oleg Cherednik
 * @since 24.07.2018
 */
public class Solution {

    static double solve(List<List<Integer>> p, List<List<Integer>> q) {
        Polygon polygonP = createPolygon(p);
        Polygon polygonQ = createPolygon(q);

        if (contains(polygonP, polygonQ) || contains(polygonQ, polygonP))
            return 0;

        List<Line2D> bordersP = createBorders(p);
        List<Line2D> bordersQ = createBorders(q);

        double dist = Double.MAX_VALUE;

        for (Line2D line1 : bordersP) {
            for (Line2D line2 : bordersQ) {
                dist = Math.min(dist, distance(line1, line2));

                if (Double.compare(0, dist) == 0)
                    return 0;
            }
        }

        return dist;
    }

    private static boolean contains(Polygon p1, Polygon p2) {
        for (int i = 0; i < p2.npoints; i++)
            if (p1.contains(p2.xpoints[i], p2.ypoints[i]))
                return true;

        return false;
    }

    private static double distance(Line2D line1, Line2D line2) {
        if (line1.intersectsLine(line2))
            return 0;

        double dist = distance(line1, line2.getP1());
        dist = Math.min(dist, distance(line1, line2.getP2()));
        dist = Math.min(dist, distance(line2, line1.getP1()));
        return Math.min(dist, distance(line2, line1.getP2()));
    }

    private static double distance(Line2D line, Point2D point) {
        double x1 = line.getX1();
        double y1 = line.getY1();
        double x2 = line.getX2();
        double y2 = line.getY2();

        double x = point.getX();
        double y = point.getY();

        double dx = x2 - x1;
        double dy = y2 - y1;

        double t = ((x - x1) * dx + (y - y1) * dy) / (dx * dx + dy * dy);
        t = Math.max(t, 0);
        t = Math.min(t, 1);

        return Math.sqrt((x1 - x + dx * t) * (x1 - x + dx * t) + (y1 - y + dy * t) * (y1 - y + dy * t));
    }

    private static List<Line2D> createBorders(List<List<Integer>> lines) {
        List<Line2D> res = new ArrayList<>(lines.size());
        List<Integer> prv = null;

        for (List<Integer> line : lines) {
            if (prv != null)
                res.add(new Line2D.Double(prv.get(0), prv.get(1), line.get(0), line.get(1)));

            prv = line;
        }

        if (prv != null) {
            List<Integer> line = lines.iterator().next();
            res.add(new Line2D.Double(prv.get(0), prv.get(1), line.get(0), line.get(1)));
        }

        return res;
    }

    private static Polygon createPolygon(List<List<Integer>> lines) {
        int npoints = lines.size();
        int[] xpoints = new int[npoints];
        int[] ypoints = new int[npoints];
        int i = 0;

        for (List<Integer> line : lines) {
            xpoints[i] = line.get(0);
            ypoints[i] = line.get(1);
            i++;
        }

        return new Polygon(xpoints, ypoints, npoints);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] nm = scan.nextLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        List<List<Integer>> p = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            p.add(
                    Stream.of(scan.nextLine().replaceAll("\\s+$", "").split(" "))
                          .map(Integer::parseInt)
                          .collect(toList())
            );
        });

        List<List<Integer>> q = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            q.add(
                    Stream.of(scan.nextLine().replaceAll("\\s+$", "").split(" "))
                          .map(Integer::parseInt)
                          .collect(toList())
            );
        });

        double result = solve(p, q);
        System.out.println(String.valueOf(result));
    }
}
