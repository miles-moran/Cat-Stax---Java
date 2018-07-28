package org.launchcode.Cat.Stax.technical;

import java.util.ArrayList;
import java.util.Collections;

public class Shape {
    private int id; //IDENTIFIER or SHAPE NUMBER to be incorporated into a database
    public ArrayList<Point> points; //POINTS that comprise the shape
    private Shape parent; //IDENTIFIER used to establish a relationship between PERMUTATION and SHAPE
    public int maxLength;
    public int maxWidth;
    public int maxHeight;
    private int mass;
    private int area;
    public ArrayList<Integer> x;
    public ArrayList<Integer> y;
    public ArrayList<Integer> z;
    private ArrayList<Shape> permutations;

    public Shape() {

    }

    public Shape(ArrayList<Point> points) {
        this.points = points;
        this.x = loadList("x");
        this.y = loadList("y");
        this.z = loadList("z");
        this.maxLength = this.max(this.getX());
        this.maxWidth = this.max(this.getY());
        this.maxHeight = this.max(this.getZ());
    }

    public Shape(Shape parent, ArrayList<Point> points) {
        this.points = points;
        this.x = loadList("x");
        this.y = loadList("y");
        this.z = loadList("z");
        this.maxLength = this.max(this.getX());
        this.maxWidth = this.max(this.getY());
        this.maxHeight = this.max(this.getZ());
    }

    public Shape(int id, ArrayList<Point> points) {
        this.id = id;
        this.points = points;
        this.x = loadList("x");
        this.y = loadList("y");
        this.z = loadList("z");
        this.maxLength = this.max(this.getX());
        this.maxWidth = this.max(this.getY());
        this.maxHeight = this.max(this.getZ());
        this.permutations = children();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public Shape getParent() {
        return parent;
    }

    public void setParent(Shape parent) {
        this.parent = parent;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public ArrayList<Integer> getX() {
        return x;
    }

    public void setX(ArrayList<Integer> x) {
        this.x = x;
    }

    public ArrayList<Integer> getY() {
        return y;
    }

    public void setY(ArrayList<Integer> y) {
        this.y = y;
    }

    public ArrayList<Integer> getZ() {
        return z;
    }

    public void setZ(ArrayList<Integer> z) {
        this.z = z;
    }

    public ArrayList<Shape> getPermutations() {
        return permutations;
    }

    public void setPermutations(ArrayList<Shape> permutations) {
        this.permutations = permutations;
    }

    public ArrayList<Integer> loadList(String query) {
        ArrayList<Integer> dimensionlist = new ArrayList<Integer>();
        if (query == "x") {
            for (Point point : this.points) {
                dimensionlist.add(point.getX());
            }
        }
        if (query == "y") {
            for (Point point : this.points) {
                dimensionlist.add(point.getY());
            }
        }
        if (query == "z") {
            for (Point point : this.points) {
                dimensionlist.add(point.getZ());
            }
        }
        return dimensionlist;
    }

    public void output() {
        ArrayList<ArrayList<ArrayList<String>>> output = new ArrayList<>();
        for (int z = 0; z < (this.max(this.getZ())+1); z++) {
            ArrayList<ArrayList<String>> slide = new ArrayList<>();
            for (int y = 0; (y < this.max(this.getY())+1); y++) {
                ArrayList<String> row = new ArrayList<>();
                for (int x = 0; (x < this.max(this.getX())+1); x++) {
                    Point compare = new Point(x, y, z);
                    boolean check = false;
                    for (Point point : this.points) {
                        if (point.getList().equals(compare.getList())) {
                            check = true;
                            break;
                        }
                    }
                    if (check == true) {
                        row.add("x");
                    } else {
                        row.add("y");
                    }
                }
                slide.add(row);
                System.out.println(row);
            }
            output.add(slide);
            System.out.println("");
        }
        System.out.println("-");
        System.out.println("");
    }

    public ArrayList<ArrayList<Point>> permutations() {
        ArrayList<ArrayList<Point>> permutations = new ArrayList<>();
        ArrayList<Integer> signs = new ArrayList<>();
        signs.add(1);
        signs.add(-1);
        for (int a = 0; a < 3; a++) {
            for (int signA : signs) {
                for (int b = 0; b < 3; b++) {
                    for (int signB : signs) {
                        for (int c = 0; c < 3; c++) {
                            for (int signC : signs) {
                                if (a != b && a != c && b != c) {
                                    ArrayList<Point> permutation = new ArrayList<>();
                                    for (Point point : this.points) {
                                        int x = point.getList().get(a) * signA;
                                        int y = point.getList().get(b) * signB;
                                        int z = point.getList().get(c) * signC;
                                        Point p = new Point(x, y, z);
                                        permutation.add(p);
                                    }
                                    Sorter sorter = new Sorter();
                                    permutation = sorter.sort(permutation);
                                    Shape temp = new Shape(permutation);
                                    ArrayList<Point> sorted_points = new ArrayList<>();
                                    sorted_points = temp.positive_points();
                                    temp = new Shape(sorted_points);
                                    temp = new Shape(temp.shrink());
                                    if (sorter.repeats(permutations, temp.points) == false){
                                        permutations.add(temp.points);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return permutations;
    }

    public ArrayList<String> points() {
        ArrayList<String> points = new ArrayList<>();
        for (Point point : this.points) {
            points.add(point.getList().toString());
        }
        return points;
    }

    public Integer max(ArrayList<Integer> query) {
        return Collections.max(query);
    }

    public ArrayList<Point> positive_points() {
        ArrayList<Integer> axis = new ArrayList<>();
        for (Point point : this.points) {
            axis.add(point.getX());
            axis.add(point.getY());
            axis.add(point.getZ());
        }
        Integer min = Collections.min(axis);
        ArrayList<Point> new_points = new ArrayList<>();
        if (min < 0) {
            min = min * -1;
            for (Point point : this.points) {
                Integer new_x = point.getX() + min;
                Integer new_y = point.getY() + min;
                Integer new_z = point.getZ() + min;
                Point new_point = new Point(new_x, new_y, new_z);
                new_points.add(new_point);
            }
            this.points = new_points;
            this.x = this.getX();
            this.y = this.getY();
            this.z = this.getZ();
        }
        return this.points;
    }

    public ArrayList<Point> shrink() {
        //FIND THE LOWEST X, Y, Z VALUE. LOWER ALL VALUES UNTIL THE LOWEST IS ZERO.
        ArrayList<Point> new_points = new ArrayList<>();
        ArrayList<Integer> new_x = new ArrayList<>();
        ArrayList<Integer> new_y = new ArrayList<>();
        ArrayList<Integer> new_z = new ArrayList<>();
        int first_x = Collections.min(this.x);
        int first_y = Collections.min(this.y);
        int first_z = Collections.min(this.z);
        for(int point: this.x){
            new_x.add(point-first_x);
        }
        for(int point: this.y){
            new_y.add(point-first_y);
        }
        for(int point: this.z){
            new_z.add(point-first_z);
        }
        for(int a = 0; a < this.points.size(); a++){
            new_points.add(new Point(new_x.get(a), new_y.get(a), new_z.get(a)));
        }
        return new_points;
    }

    public void permutations_output(){
        for (ArrayList<Point> permutation : this.permutations()){
            Shape out = new Shape(permutation);
            out.output();
        }
    }

    public ArrayList<Shape> children() {
        ArrayList<ArrayList<Point>> permutations = permutations();
        ArrayList<Shape> children = new ArrayList<>();
        for (ArrayList<Point> permutation : permutations) {
            Shape temp = new Shape(this, permutation);
            children.add(temp);
        }
        return children;
    }

}
