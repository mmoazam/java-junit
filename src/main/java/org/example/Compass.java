package org.example;

public class Compass {
    public enum Point {
        NORTH, EAST, SOUTH, WEST
    }

    public enum Direction {
        LEFT, RIGHT
    }

    private Point point;

    public static Point rotate(Point point, Direction direction) {
        int movement;
        int index;
        Point[] points = Point.values();

        if (direction == Direction.RIGHT) {
            index = (point.ordinal() + 1) % points.length;
        }else {
            index = (point.ordinal() - 1 + points.length) % points.length;
        }




//        // NORTH, EAST, SOUTH, WEST
//
//        // forward
//        index = (point.ordinal() + movement) % points.length;
//
//        // move backward
//        index = (point.ordinal() - movement + points.length) % points.length;


        return points[index];
    }
}
