package jarvismarch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dawid.switon@gmail.com
 */
public class Main {

    public static void main(String[] args) {

        List<Point> points = new ArrayList<>();

        points.add(new Point(100, 100));
        points.add(new Point(160, 150));
        points.add(new Point(200, 200));
        points.add(new Point(150, 180));
        points.add(new Point(100, 200));
        points.add(new Point(150, 150));

        points = JarvisMarch.convexHull(points);

        points.forEach((point) -> {
            System.out.println("Point (" + point.x + " " + point.y + ")");
        });

    }

}
