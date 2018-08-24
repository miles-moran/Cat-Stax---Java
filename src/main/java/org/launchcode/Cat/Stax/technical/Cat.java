package org.launchcode.Cat.Stax.technical;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cat {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cat_id")
    private List<CatPoint> points;

    public Cat(){
    }
    public Cat(List<CatPoint> points){
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CatPoint> getPoints() {
        return points;
    }

    public void setPoints(List<CatPoint> points) {
        this.points = points;
    }

    public Cat shapeToCat(Shape shape){
        List<CatPoint> points = new ArrayList<>();
        for(Point point: shape.getPoints()){
            points.add(new CatPoint(point.getX(), point.getY(), point.getZ()));
        }
        Cat cat = new Cat(points);
        return cat;
    }
}
