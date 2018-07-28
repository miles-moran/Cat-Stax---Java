package org.launchcode.Cat.Stax.technical;

import java.util.ArrayList;

public class Placer {
    public ArrayList<ArrayList<Point>> locations(Canvas canvas, Shape shape) { //generates a shape at every location on the canvas
        ArrayList<ArrayList<Point>> locations = new ArrayList<>(); //what we return canvas.points * permutations
        Sorter sorter = new Sorter();
        for (Shape child : shape.getPermutations()) {
            for (Point loci : canvas.getPoints()) {
                ArrayList<Point> location = place(loci, child);
                if (valid_location(location, canvas) == true && (sorter.repeats(locations, location)) == false){
                    locations.add(location);
                }

            }

        }
        return locations;
    }

    public ArrayList<Point> place(Point origin, Shape shape) {
        ArrayList<Point> new_location = new ArrayList<>();
        for (int i = 0; i < shape.points.size(); i++) {
            int x = shape.points.get(i).getX() + (origin.getX() - shape.points.get(0).getX());
            int y = shape.points.get(i).getY() + (origin.getY() - shape.points.get(0).getY());
            int z = shape.points.get(i).getZ() + (origin.getZ() - shape.points.get(0).getZ());
            Point new_point = new Point(x, y, z);
            new_location.add(new_point);
        }
        return new_location;
    }

    public boolean valid_location(ArrayList<Point> location, Canvas canvas) {
        for(Point i: location){
            boolean check = false;
            for(Point j: canvas.points){
                if(i.toString().equals(j.toString())){
                    check = true;
                }
            }
            if(check == false){
                return false;
            }
        }
        return true;
    }
}
