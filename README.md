[![CodeQL](https://github.com/dawidswiton/jarvismarch/actions/workflows/codeql.yml/badge.svg)](https://github.com/dawidswiton/jarvismarch/actions/workflows/codeql.yml)
# jarvismarch
Convex Hull algorithm

Simplest solution of creating a convex hull.

```
List<Point> points = new ArrayList<>();

points.add(new Point(100, 100));
points.add(new Point(160, 150));
points.add(new Point(200, 200));
points.add(new Point(150, 180));
points.add(new Point(100, 200));
points.add(new Point(150, 150));

points = JarvisMarch.convexHull(points);
```

After this you will get convex hull points in appropriate order.
