package com.dawidswiton.jarvismarch;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JarvisMarchTest {

    @Test
    void makeConvexHull() {
        List<Point> points = new ArrayList<>();

        points.add(new Point(100, 100));
        points.add(new Point(160, 150));
        points.add(new Point(200, 200));
        points.add(new Point(150, 180));
        points.add(new Point(100, 200));
        points.add(new Point(150, 150));
        points.add(new Point(140, 210));

        points = JarvisMarch.convexHull(points);

        List<Point> expected = new ArrayList<>();
        expected.add(new Point(100, 100));
        expected.add(new Point(160, 150));
        expected.add(new Point(200, 200));
        expected.add(new Point(140, 210));
        expected.add(new Point(100, 200));

        Assertions.assertThat(points).hasSize(5);
        Assertions.assertThat(points).containsExactlyElementsOf(expected);
    }

    @Test
    void makeConvexHullTwoElements() {
        List<Point> points = new ArrayList<>();

        points.add(new Point(100, 100));
        points.add(new Point(160, 150));

        points = JarvisMarch.convexHull(points);

        List<Point> expected = new ArrayList<>();
        expected.add(new Point(100, 100));
        expected.add(new Point(160, 150));

        Assertions.assertThat(points).hasSize(2);
        Assertions.assertThat(points).containsExactlyElementsOf(expected);
    }

    @Test
    void makeConvexHullFourMainElements() {
        List<Point> points = new ArrayList<>();

        points.add(new Point(100, 100));
        points.add(new Point(0, 0));
        points.add(new Point(50, 50));
        points.add(new Point(100, 0));
        points.add(new Point(0, 100));

        points = JarvisMarch.convexHull(points);

        List<Point> expected = new ArrayList<>();
        expected.add(new Point(0, 0));
        expected.add(new Point(100, 0));
        expected.add(new Point(100, 100));
        expected.add(new Point(0, 100));
        

        Assertions.assertThat(points).hasSize(4);
        Assertions.assertThat(points).containsExactlyElementsOf(expected);
    }
    
    @Test
    void makeConvexHullFourMinusInvolvedMainElements() {
        List<Point> points = new ArrayList<>();

        points.add(new Point(100, 100));
        points.add(new Point(-100, -100));
        points.add(new Point(50, 50));
        points.add(new Point(100, -100));
        points.add(new Point(-100, 100));

        points = JarvisMarch.convexHull(points);

        List<Point> expected = new ArrayList<>();
        expected.add(new Point(-100, -100));
        expected.add(new Point(100, -100));
        expected.add(new Point(100, 100));
        expected.add(new Point(-100, 100));
        

        Assertions.assertThat(points).hasSize(4);
        Assertions.assertThat(points).containsExactlyElementsOf(expected);
    }

}
