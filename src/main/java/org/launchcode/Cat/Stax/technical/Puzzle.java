package org.launchcode.Cat.Stax.technical;

import java.util.ArrayList;

public class Puzzle {
    private int canvas_x;
    private int canvas_y;
    private int canvas_z;
    private int shape_count;
    private ArrayList<String> canvas_points;

    public Puzzle(){

    }
    public Puzzle(int canvas_x, int canvas_y, int canvas_z, int shape_count, ArrayList<String> canvas_points) {
        this.canvas_x = canvas_x;
        this.canvas_y = canvas_y;
        this.canvas_z = canvas_z;
        this.shape_count = shape_count;
        this.canvas_points = canvas_points;
    }

    public Puzzle(int canvas_x, int canvas_y, int canvas_z, int shape_count) {
        this.canvas_x = canvas_x;
        this.canvas_y = canvas_y;
        this.canvas_z = canvas_z;
        this.shape_count = shape_count;
    }

    public int getShape_count() {
        return shape_count;
    }

    public void setShape_count(int shape_count) {
        this.shape_count = shape_count;
    }


    public ArrayList<String> getCanvas_points() {
        return canvas_points;
    }

    public void setCanvas_points(ArrayList<String> canvas_points) {
        this.canvas_points = canvas_points;
    }

    public int getCanvas_x() {
        return canvas_x;
    }

    public void setCanvas_x(int canvas_x) {
        this.canvas_x = canvas_x;
    }

    public int getCanvas_y() {
        return canvas_y;
    }

    public void setCanvas_y(int canvas_y) {
        this.canvas_y = canvas_y;
    }

    public int getCanvas_z() {
        return canvas_z;
    }

    public void setCanvas_z(int canvas_z) {
        this.canvas_z = canvas_z;
    }


}
