package org.launchcode.Cat.Stax.technical;

import java.util.ArrayList;

public class Forge {

    public Shape sample1x3x0(int id) {
        Point zero = new Point(0, 0, 0);
        Point one = new Point(1, 0, 0);
        Point two = new Point(2, 0, 0);

        ArrayList<Point> points = new ArrayList<Point>();
        points.add(zero);
        points.add(one);
        points.add(two);

        Shape sample = new Shape(id, points);

        return sample;
    }

    public Shape sample2x2x0(int id) {
        Point zero = new Point(0, 0, 0);
        Point one = new Point(1, 0, 0);
        Point two = new Point(0, 1, 0);
        Point three = new Point(1, 1, 0);

        ArrayList<Point> points = new ArrayList<>();
        points.add(zero);
        points.add(one);
        points.add(two);
        points.add(three);

        Shape sample = new Shape(id, points);

        return sample;
    }

    public Shape sample2x2x0lshape(int id) {
        Point zero = new Point(0, 0, 0);
        Point one = new Point(1, 0, 0);
        Point two = new Point(0, 1, 0);

        ArrayList<Point> points = new ArrayList<>();
        points.add(zero);
        points.add(one);
        points.add(two);

        Shape sample = new Shape(id, points);

        return sample;
    }


    public Shape sample2x3xlshape(int id) {
        Point zero = new Point(0, 0, 0);
        Point one = new Point(1, 0, 0);
        Point two = new Point(0, 1, 0);
        Point three = new Point(0, 2, 0);


        ArrayList<Point> points = new ArrayList<>();
        points.add(zero);
        points.add(one);
        points.add(two);
        points.add(three);

        Shape sample = new Shape(id, points);

        return sample;
    }

    public Shape sample2x2x2shape(int id) {
        Point zero = new Point(0, 0, 0);
        Point one = new Point(1, 0, 0);
        Point two = new Point(0, 1, 0);
        Point three = new Point(1, 1, 0);
        Point four = new Point(0, 0, 1);
        Point five = new Point(1, 0, 1);
        Point six = new Point(0, 1, 1);
        Point seven = new Point(1, 1, 1);


        ArrayList<Point> points = new ArrayList<>();
        points.add(zero);
        points.add(one);
        points.add(two);
        points.add(three);
        points.add(four);
        points.add(five);
        points.add(six);
        points.add(seven);

        Shape sample = new Shape(id, points);

        return sample;
    }

    public Shape sample1x1x1shape(int id) {
        Point zero = new Point(0, 0, 0);


        ArrayList<Point> points = new ArrayList<>();
        points.add(zero);
        Shape sample = new Shape(id, points);

        return sample;
    }

    public Canvas sample3x3x1canvas() {
        Point zero = new Point(0, 0, 0);
        Point one = new Point(1, 0, 0);
        Point two = new Point(2, 0, 0);
        Point three = new Point(0, 1, 0);
        Point four = new Point(1, 1, 0);
        Point five = new Point(2, 1, 0);
        Point six = new Point(0, 2, 0);
        Point seven = new Point(1, 2, 0);
        Point eight = new Point(2, 2, 0);


        ArrayList<Point> points = new ArrayList<>();
        points.add(zero);
        points.add(one);
        points.add(two);
        points.add(three);
        points.add(four);
        points.add(five);
        points.add(six);
        points.add(seven);
        points.add(eight);
        Canvas sample = new Canvas(points);

        return sample;
    }

    public Shape sample2x1x0(int id) {
        Point zero = new Point(0, 0, 0);
        Point one = new Point(1, 0, 0);

        ArrayList<Point> points = new ArrayList<Point>();
        points.add(zero);
        points.add(one);

        Shape sample = new Shape(id, points);

        return sample;
    }
    public Canvas sample3x3x2canvas() {
        Point zero = new Point(0, 0, 0);
        Point one = new Point(1, 0, 0);
        Point two = new Point(2, 0, 0);
        Point three = new Point(0, 1, 0);
        Point four = new Point(1, 1, 0);
        Point five = new Point(2, 1, 0);
        Point six = new Point(0, 2, 0);
        Point seven = new Point(1, 2, 0);
        Point eight = new Point(2, 2, 0);
        Point eleven = new Point(0, 0, 1);
        Point twelve = new Point(1, 0, 1);
        Point thirteen = new Point(2, 0, 1);
        Point fourteen = new Point(0, 1, 1);
        Point fifteen = new Point(1, 1, 1);
        Point sixteen = new Point(2, 1, 1);
        Point seventeen = new Point(0, 2, 1);
        Point eighteen = new Point(1, 2, 1);
        Point nineteen = new Point(2, 2, 1);


        ArrayList<Point> points = new ArrayList<>();
        points.add(zero);
        points.add(one);
        points.add(two);
        points.add(three);
        points.add(four);
        points.add(five);
        points.add(six);
        points.add(seven);
        points.add(eight);
        points.add(eleven);
        points.add(twelve);
        points.add(thirteen);
        points.add(fourteen);
        points.add(fifteen);
        points.add(sixteen);
        points.add(seventeen);
        points.add(eighteen);
        points.add(nineteen);

        Canvas sample = new Canvas(points);

        return sample;
    }

    public Canvas sample2x2x2canvas() {
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(1, 0, 0);
        Point p3 = new Point(0, 1, 0);
        Point p4 = new Point(1, 1, 0);
        Point p5 = new Point(0, 0, 1);
        Point p6 = new Point(1, 0, 1);
        Point p7 = new Point(0, 1, 1);
        Point p8 = new Point(1, 1, 1);

        ArrayList<Point> points = new ArrayList<>();

        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        points.add(p5);
        points.add(p6);
        points.add(p7);
        points.add(p8);

        Canvas sample = new Canvas(points);

        return sample;
    }

    public Shape sample3x3x1(int id) {
        Point zero = new Point(0, 0, 0);
        Point one = new Point(1, 0, 0);
        Point two = new Point(2, 0, 0);
        Point three = new Point(0, 1, 0);
        Point four = new Point(1, 1, 0);
        Point five = new Point(2, 1, 0);
        Point six = new Point(0, 2, 0);
        Point seven = new Point(1, 2, 0);
        Point eight = new Point(2, 2, 0);


        ArrayList<Point> points = new ArrayList<>();
        points.add(zero);
        points.add(one);
        points.add(two);
        points.add(three);
        points.add(four);
        points.add(five);
        points.add(six);
        points.add(seven);
        points.add(eight);
        Shape sample = new Shape(id, points);

        return sample;
    }

    public Shape sample5x2x2(int id) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0, 0));
        points.add(new Point(1, 0, 0));
        points.add(new Point(2, 0 , 0));
        points.add(new Point(4, 0, 0));
        points.add(new Point(0, 1, 0));
        points.add(new Point(1, 1, 0));
        points.add(new Point(2, 1, 0));
        points.add(new Point(3, 1, 0));
        points.add(new Point(4, 1, 0));
        points.add(new Point(0, 0, 1));
        points.add(new Point(1, 0, 1));
        points.add(new Point(2, 0 , 1));
        points.add(new Point(4, 0, 1));
        points.add(new Point(0, 1, 1));
        points.add(new Point(1, 1, 1));
        points.add(new Point(2, 1, 1));
        points.add(new Point(3, 1, 1));
        points.add(new Point(4, 1, 1));


        Shape sample = new Shape(id, points);

        return sample;
    }
    public Shape sample5x1x1(int id) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0, 0));
        points.add(new Point(1, 0, 0));
        points.add(new Point(2, 0 , 0));
        points.add(new Point(3, 0, 0));
        points.add(new Point(4, 0, 0));


        Shape sample = new Shape(id, points);

        return sample;
    }
    public Shape sample3x3x1L(int id) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0, 0));
        points.add(new Point(1, 0, 0));
        points.add(new Point(2, 0 , 0));
        points.add(new Point(0, 1, 0));
        points.add(new Point(0, 2, 0));


        Shape sample = new Shape(id, points);

        return sample;
    }

    public Shape sample3x2x1U(int id) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0, 0));
        points.add(new Point(1, 0, 0));
        points.add(new Point(2, 0 , 0));
        points.add(new Point(0, 1, 0));
        points.add(new Point(2, 1, 0));


        Shape sample = new Shape(id, points);

        return sample;
    }
    public Canvas sample5x5x2canvas() {
        Point zero = new Point(0, 0, 0);
        Point one = new Point(1, 0, 0);
        Point two = new Point(2, 0, 0);
        Point three = new Point(0, 1, 0);
        Point four = new Point(1, 1, 0);
        Point five = new Point(2, 1, 0);
        Point six = new Point(0, 2, 0);
        Point seven = new Point(1, 2, 0);
        Point eight = new Point(2, 2, 0);
        Point eleven = new Point(0, 0, 1);
        Point twelve = new Point(1, 0, 1);
        Point thirteen = new Point(2, 0, 1);
        Point fourteen = new Point(0, 1, 1);
        Point fifteen = new Point(1, 1, 1);
        Point sixteen = new Point(2, 1, 1);
        Point seventeen = new Point(0, 2, 1);
        Point eighteen = new Point(1, 2, 1);
        Point nineteen = new Point(2, 2, 1);
        ArrayList<Point> points = new ArrayList<>();
        points.add(zero);
        points.add(one);
        points.add(two);
        points.add(three);
        points.add(four);
        points.add(five);
        points.add(six);
        points.add(seven);
        points.add(eight);
        points.add(eleven);
        points.add(twelve);
        points.add(thirteen);
        points.add(fourteen);
        points.add(fifteen);
        points.add(sixteen);
        points.add(seventeen);
        points.add(eighteen);
        points.add(nineteen);
        points.add(new Point(3, 0, 0));
        points.add(new Point(3, 1, 0));
        points.add(new Point(3, 2, 0));
        points.add(new Point(3, 3, 0));
        points.add(new Point(3, 4, 0));
        points.add(new Point(4, 0, 0));
        points.add(new Point(4, 1, 0));
        points.add(new Point(4, 2, 0));
        points.add(new Point(4, 3, 0));
        points.add(new Point(4, 4, 0));
        points.add(new Point(0, 3, 0));
        points.add(new Point(0, 4, 0));
        points.add(new Point(1, 3, 0));
        points.add(new Point(1, 4, 0));
        points.add(new Point(2, 3, 0));
        points.add(new Point(2, 4, 0));
        points.add(new Point(3, 0, 1));
        points.add(new Point(3, 1, 1));
        points.add(new Point(3, 2, 1));
        points.add(new Point(3, 3, 1));
        points.add(new Point(3, 4, 1));
        points.add(new Point(4, 0, 1));
        points.add(new Point(4, 1, 1));
        points.add(new Point(4, 2, 1));
        points.add(new Point(4, 3, 1));
        points.add(new Point(4, 4, 1));
        points.add(new Point(0, 3, 1));
        points.add(new Point(0, 4, 1));
        points.add(new Point(1, 3, 1));
        points.add(new Point(1, 4, 1));
        points.add(new Point(2, 3, 1));
        points.add(new Point(2, 4, 1));

        Canvas sample = new Canvas(points);

        return sample;
    }


}
