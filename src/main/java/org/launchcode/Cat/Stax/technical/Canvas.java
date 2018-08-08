package org.launchcode.Cat.Stax.technical;

import java.util.ArrayList;

public class Canvas extends Shape{

    ArrayList<Shape> shapes = new ArrayList<>();
    public Canvas(ArrayList<Point> points){
        this.points = points;
        this.x = loadList("x");
        this.y = loadList("y");
        this.z = loadList("z");
        this.maxLength = this.max(this.getX());
        this.maxWidth = this.max(this.getY());
        this.maxHeight = this.max(this.getZ());
        this.output = this.output();
    }
    public Canvas(){

    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public ArrayList<Boolean> output() {
        ArrayList<Boolean> output = new ArrayList<>();
        for (int z = 0; z < (this.max(this.getZ())+1); z++) {
            for (int y = 0; (y < this.max(this.getY())+1); y++) {
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
                        output.add(true);
                    } else {
                        output.add(false);
                    }
                }
            }
        }
        return output;
    }



}
