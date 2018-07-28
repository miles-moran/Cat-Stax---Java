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
    }
    public Canvas(){

    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public void output() {
        String occupant = "-";
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
                            if(point.getOccupant() != null) {
                                occupant = point.getOccupant().toString();
                            } else {
                                occupant = "-";
                            }
                            break;
                        }
                    }
                    if (check == true) {
                        row.add(occupant);
                    } else {
                        row.add("-");
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


}
