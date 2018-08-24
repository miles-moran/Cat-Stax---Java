package org.launchcode.Cat.Stax.technical;

import java.util.ArrayList;

public class Sorter {
    public Sorter() {

    }
    public ArrayList<Point> sort(ArrayList unordered) {
        boolean check = false;
        for (int i = 0; i < (unordered.size() - 1); i++) {
            Point point1;
            point1 = (Point) unordered.get(i);
            Point point2;
            point2 = (Point) unordered.get(i + 1);
            if (point1.getZ() > point2.getZ()) {
                Point placeholder;
                placeholder = point1;
                unordered.set(i, point2);
                unordered.set(i + 1, placeholder);
                check = true;
            } else if (point1.getZ() == point2.getZ()) {
                if (point1.getY() > point2.getY()) {
                    Point placeholder;
                    placeholder = point1;
                    unordered.set(i, point2);
                    unordered.set(i + 1, placeholder);
                    check = true;
                } else if (point1.getY() == point2.getY()) {
                    if (point1.getX() > point2.getX()) {
                        Point placeholder;
                        placeholder = point1;
                        unordered.set(i, point2);
                        unordered.set(i + 1, placeholder);
                        check = true;
                    }
                }
            }
        }
        if (check == true) {
            sort(unordered);
        }
        return unordered;
    }

    public boolean repeats(ArrayList<ArrayList<Point>> list, ArrayList<Point> item){
        Shape shape1 = new Shape(item);
        for (ArrayList<Point> permutation: list){
            Shape shape2 = new Shape(permutation);
            if (shape1.points().equals(shape2.points())){
                return true;
            }
        }
        return false;

    }


}
