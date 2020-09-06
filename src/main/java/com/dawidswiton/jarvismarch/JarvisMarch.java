package com.dawidswiton.jarvismarch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author dawid.switon@gmail.com
 */
public class JarvisMarch {

    private static List<Point> filterDuplicated(List<Point> points) {
        return points.stream().distinct().collect(Collectors.toList());
    }

    private static Point findLowestPoint(List<Point> points) {
        Point low = points.get(0);
        boolean change;
        do {
            change = false;
            for (Point point : points) {
                if (low.y == point.y) {
                    if (low.x > point.x) {
                        low = point;
                        change = true;
                        break;
                    }
                }
                if (low.y > point.y) {
                    low = point;
                    change = true;
                    break;
                }
            }
        } while (change);
        return low;
    }

    public static List<Point> convexHull(List<Point> points) {
        points = filterDuplicated(points);
        if(points.size() < 2){
            return points;
        }

        List<Point> hull = new ArrayList<>();

        Point startingPoint = findLowestPoint(points);
        hull.add(startingPoint);

        Point prev = startingPoint;
        double prevAngle = 0;
        double maxDist = 0;

        while (true) {
            double minAngle = 400;
            Point next = null;
            double angle = Double.MAX_VALUE;

            for (Point tested : points) {
                if (tested.equals(prev)) {
                    continue;
                }

                angle = angle(prev, tested);
                double dist = calculateDistanceBetweenPoints(prev, tested);
                int compareAngles = Double.compare(angle, minAngle);

                if (compareAngles <= 0 && angle >= prevAngle) {
                    if (compareAngles < 0) {
                        minAngle = angle;
                        maxDist = dist;
                        next = tested;
                    } else if (compareAngles == 0 && dist > maxDist) {
                        minAngle = angle;
                        maxDist = dist;
                        next = tested;
                    }
                }
            }

            if (next.equals(startingPoint)) {
                break;
            }
            hull.add(next);

            prevAngle = angle(prev, next);

            prev = next;
        }
        return hull;

    }

    private static double angle(Point a, Point b) {
        double y = b.y - a.y;
        double x = b.x - a.x;

        double radianAngle = Math.atan2(y, x);

        double angle = Math.toDegrees(radianAngle);
        angle = (angle + 360) % 360;

        return angle;
    }

    private static double calculateDistanceBetweenPoints(Point p1, Point p2) {

        return Math.hypot(Math.abs(p2.x - p1.x), Math.abs(p2.y - p1.y));
    }

}
