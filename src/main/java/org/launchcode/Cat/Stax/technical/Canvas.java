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

    public ArrayList<Integer> ownerOutput() {
        ArrayList<Integer> output = new ArrayList<>();
        for(Point point: this.points){
            output.add(point.getOccupant());
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



}
