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
                            output.add(canvas_point.getOccupant().toString());
                            check = true;
                        }
                    }
                    if (check == false) {
                        output.add("-");
                    }
                }
            }
        }
        System.out.println(output);
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



}
