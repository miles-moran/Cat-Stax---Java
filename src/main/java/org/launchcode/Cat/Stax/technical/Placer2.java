package org.launchcode.Cat.Stax.technical;

import java.util.ArrayList;


public class Placer2 {
    public ArrayList<ArrayList<Point>> locations(Canvas canvas, Shape shape, ArrayList<ArrayList<Point>> all_positions) { //generates a shape at every location on the canvas
        ArrayList<ArrayList<Point>> locations = new ArrayList<>(); //what we return canvas.points * permutations
        ArrayList<Shape> permutations = shape.getPermutations();
        ArrayList<Point> canvas_points = canvas.getPoints();
        for (Shape child : permutations) {
            for (Point loci : canvas_points) {
                ArrayList<Point> location = place(loci, child, canvas_points, all_positions);
                if (!location.isEmpty()){ //&& (sorter.repeats(locations, location)) == false)
                    locations.add(location);
                }

            }
        }
        return locations;
    }

    public ArrayList<Point> place(Point origin, Shape shape, ArrayList<Point> canvas_points, ArrayList<ArrayList<Point>> all_positions) {
        ArrayList<Point> new_location = new ArrayList<>();
        for (int i = 0; i < shape.points.size(); i++) {
            int x = shape.points.get(i).getX() + (origin.getX() - shape.points.get(0).getX());
            int y = shape.points.get(i).getY() + (origin.getY() - shape.points.get(0).getY());
            int z = shape.points.get(i).getZ() + (origin.getZ() - shape.points.get(0).getZ());
            Point new_point = new Point(x, y, z);
            if(valid_location(new_point, canvas_points, all_positions)){
                new_location.add(new_point);
            } else {
                new_location.clear();
                return new_location;
            }
        }
        return new_location;
    }

    public boolean valid_location(Point location, ArrayList<Point> canvas_points, ArrayList<ArrayList<Point>> all_positions) {
        boolean check = false;

        for(Point i: canvas_points){
            if(location.toString().equals(i.toString())){
                for(ArrayList<Point> placedShape: all_positions){
                    for(Point placedPoint: placedShape){
                        if(location.toString().equals(placedPoint.toString())){
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        if(check == false){
            return false;
        }
        return true;
    }
}
