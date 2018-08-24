package org.launchcode.Cat.Stax.technical;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CatPoint {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Cat cat;

    private int x;
    private int y;
    private int z;

    public CatPoint(){

    }

    public CatPoint(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
