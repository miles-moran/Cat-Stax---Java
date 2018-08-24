package org.launchcode.Cat.Stax.technical;

import java.util.ArrayList;

public class Canvas extends Shape{

    ArrayList<Integer> output = new ArrayList<>();
    ArrayList<Shape> shapes = new ArrayList<>();
    public Canvas(ArrayList<Point> points){
        this.points = points;
        this.x = loadList("x");
        this.y = loadList("y");
        this.z = loadList("z");
        this.maxLength = this.max(this.getX());
        this.maxWidth = this.max(this.getY());
        this.maxHeight = this.max(this.getZ());
    }
    public Canvas(){

    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public ArrayList<String> ownerOutput() {
        ArrayList<String> output = new ArrayList<>();
        for(int z = 0; z < this.maxHeight+1; z++) {
            for (int y = 0; y < this.maxWidth + 1; y++) {
                for (int x = 0; x < this.maxLength + 1; x++) {
                    boolean check = false;
                    for (Point canvas_point : this.points) {
                        if (canvas_point.toString().equals(new Point(x, y, z).toString())) {
                            if(canvas_point.getOccupant() != null) {
                                output.add(canvas_point.getOccupant().color);
                            } else {
                                output.add("black");
                            }
                            check = true;
                        }
                    }
                    if (check == false) {
                        output.add("#E8E8E8");
                    }
                }
            }
        }
        return output;
    }

    public Integer dimensionTest(){
        for(Integer z: this.z){
            System.out.println(z);
            if(z > 0){
                return 3;
            }
        }
        return 2;
    }

    public ArrayList<Shape> sortShapesByMass(ArrayList<Shape> unordered) {
        boolean check = false;
        for (int i = 0; i < (unordered.size() - 1); i++) {
            Shape shape1 = unordered.get(i);
            Shape shape2 = unordered.get(i + 1);
            if (shape1.points.size() < shape2.points.size()) {
                Shape placeholder = shape1;
                unordered.set(i, shape2);
                unordered.set(i + 1, placeholder);
                check = true;
            }
            if (check == true) {
                sortShapesByMass(unordered);
            }

        }
        return unordered;
    }

}
