package org.launchcode.Cat.Stax.technical;

import java.util.ArrayList;

public class Point {
    private int x;
    private int y;
    private int z;

    private ArrayList<Integer> list = new ArrayList<>();

    private Integer occupant;

    public Point(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.list.add(x);
        this.list.add(y);
        this.list.add(z);
    }

    public Point(){

    }
    public Integer getOccupant() {
        return occupant;
    }

    public void setOccupant(Integer occupant) {
        this.occupant = occupant;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    @Override
    public String toString() {
        return this.list.toString();
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }
}
