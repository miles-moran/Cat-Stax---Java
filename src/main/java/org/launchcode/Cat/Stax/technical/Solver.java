package org.launchcode.Cat.Stax.technical;

import java.util.ArrayList;

public class Solver {

    public void data(Canvas canvas) {
        int sum = 0;
        for (Shape shape : canvas.shapes) {
            System.out.println(shape.points);
            sum = sum + shape.points.size();
        }
        Integer count = canvas.shapes.size();
        String canvas_mass = "Canvas Mass: " + canvas.points.size();
        String shape_mass = "Shape Mass: " + sum;
        String shape_count = "Shape Count: " + count;

        System.out.println(canvas_mass);
        System.out.println(shape_mass);
        System.out.println(shape_count);
        double p = 1;
        for(Shape shape: canvas.shapes){
            p = p * (shape.permutations().size() * canvas.points.size());
        }
        System.out.println("Permutations: ");
        System.out.print(p);
    }

    public boolean collisions(ArrayList<ArrayList<Point>> all_positions) {
        ArrayList<Point> all_positions_points = new ArrayList<>();
        for (ArrayList<Point> position : all_positions) {
            for (Point point : position) {
                all_positions_points.add(point);
            }
        }
        for (Point i : all_positions_points) {
            for (Point j : all_positions_points) {
                if (i != j && i.getList().equals(j.getList())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void claim(Canvas canvas, ArrayList<ArrayList<Point>> solution) {
        for (Point canvas_point : canvas.points) {
            for (int shape = 0; shape < solution.size(); shape++) {
                for (Point shape_point : solution.get(shape)) {
                    if (shape_point.getList().equals(canvas_point.getList())) {
                        canvas_point.setOccupant(shape);
                    }
                }
            }
        }
    }

    public ArrayList<ArrayList<Point>> solve(Canvas canvas) {
        data(canvas);
        Placer placer = new Placer();

        ArrayList<ArrayList<Point>> all_positions = new ArrayList<>();
        ArrayList<ArrayList<Point>> locations1 = placer.locations(canvas, canvas.shapes.get(0));
        for (ArrayList<Point> location1 : locations1) {
            if (canvas.shapes.size() == 1) {
                all_positions.clear();
                all_positions.add(location1);
                if (collisions(all_positions) == false) {
                    claim(canvas, all_positions);
                    return all_positions;
                }
            } else {

                ArrayList<ArrayList<Point>> locations2 = placer.locations(canvas, canvas.shapes.get(1));
                for (ArrayList<Point> location2 : locations2) {
                    if (canvas.shapes.size() == 2) {
                        all_positions.clear();
                        all_positions.add(location1);
                        all_positions.add(location2);
                        if (collisions(all_positions) == false) {
                            claim(canvas, all_positions);
                            return all_positions;
                        }
                    } else {
                        ArrayList<ArrayList<Point>> locations3 = placer.locations(canvas, canvas.shapes.get(2));
                        for (ArrayList<Point> location3 : locations3) {
                            if (canvas.shapes.size() == 3) {
                                all_positions.clear();
                                all_positions.add(location1);
                                all_positions.add(location2);
                                all_positions.add(location3);
                                if (collisions(all_positions) == false) {
                                    claim(canvas, all_positions);
                                    return all_positions;
                                }
                            } else {
                                ArrayList<ArrayList<Point>> locations4 = placer.locations(canvas, canvas.shapes.get(3));
                                for (ArrayList<Point> location4 : locations4) {
                                    if (canvas.shapes.size() == 4) {
                                        all_positions.clear();
                                        all_positions.add(location1);
                                        all_positions.add(location2);
                                        all_positions.add(location3);
                                        all_positions.add(location4);
                                        if (collisions(all_positions) == false) {
                                            claim(canvas, all_positions);
                                            return all_positions;
                                        }
                                    } else {
                                        ArrayList<ArrayList<Point>> locations5 = placer.locations(canvas, canvas.shapes.get(4));
                                        for (ArrayList<Point> location5 : locations5) {
                                            if (canvas.shapes.size() == 5) {
                                                all_positions.clear();
                                                all_positions.add(location1);
                                                all_positions.add(location2);
                                                all_positions.add(location3);
                                                all_positions.add(location4);
                                                all_positions.add(location5);
                                                if (collisions(all_positions) == false) {
                                                    claim(canvas, all_positions);
                                                    return all_positions;
                                                }
                                            } else {
                                                ArrayList<ArrayList<Point>> locations6 = placer.locations(canvas, canvas.shapes.get(5));
                                                for (ArrayList<Point> location6 : locations6) {
                                                    if (canvas.shapes.size() == 6) {
                                                        all_positions.clear();
                                                        all_positions.add(location1);
                                                        all_positions.add(location2);
                                                        all_positions.add(location3);
                                                        all_positions.add(location4);
                                                        all_positions.add(location5);
                                                        all_positions.add(location6);
                                                        if (collisions(all_positions) == false) {
                                                            claim(canvas, all_positions);
                                                            return all_positions;
                                                        }
                                                    } else {
                                                        ArrayList<ArrayList<Point>> locations7 = placer.locations(canvas, canvas.shapes.get(6));
                                                        for (ArrayList<Point> location7 : locations7) {
                                                            if (canvas.shapes.size() == 7) {
                                                                all_positions.clear();
                                                                all_positions.add(location1);
                                                                all_positions.add(location2);
                                                                all_positions.add(location3);
                                                                all_positions.add(location4);
                                                                all_positions.add(location5);
                                                                all_positions.add(location6);
                                                                all_positions.add(location7);
                                                                if (collisions(all_positions) == false) {
                                                                    claim(canvas, all_positions);
                                                                    return all_positions;
                                                                }
                                                            } else {
                                                                ArrayList<ArrayList<Point>> locations8 = placer.locations(canvas, canvas.shapes.get(7));
                                                                for (ArrayList<Point> location8 : locations8) {
                                                                    if (canvas.shapes.size() == 8) {
                                                                        all_positions.clear();
                                                                        all_positions.add(location1);
                                                                        all_positions.add(location2);
                                                                        all_positions.add(location3);
                                                                        all_positions.add(location4);
                                                                        all_positions.add(location5);
                                                                        all_positions.add(location6);
                                                                        all_positions.add(location7);
                                                                        all_positions.add(location8);
                                                                        if (collisions(all_positions) == false) {
                                                                            claim(canvas, all_positions);
                                                                            return all_positions;
                                                                        }
                                                                    } else {
                                                                        ArrayList<ArrayList<Point>> locations9 = placer.locations(canvas, canvas.shapes.get(8));
                                                                        for (ArrayList<Point> location9 : locations9) {
                                                                            if (canvas.shapes.size() == 9) {
                                                                                all_positions.clear();
                                                                                all_positions.add(location1);
                                                                                all_positions.add(location2);
                                                                                all_positions.add(location3);
                                                                                all_positions.add(location4);
                                                                                all_positions.add(location5);
                                                                                all_positions.add(location6);
                                                                                all_positions.add(location7);
                                                                                all_positions.add(location8);
                                                                                all_positions.add(location9);
                                                                                if (collisions(all_positions) == false) {
                                                                                    claim(canvas, all_positions);
                                                                                    return all_positions;
                                                                                }
                                                                            } else {
                                                                                ArrayList<ArrayList<Point>> locations10 = placer.locations(canvas, canvas.shapes.get(9));
                                                                                for (ArrayList<Point> location10 : locations10) {
                                                                                    if (canvas.shapes.size() == 10) {
                                                                                        all_positions.clear();
                                                                                        all_positions.add(location1);
                                                                                        all_positions.add(location2);
                                                                                        all_positions.add(location3);
                                                                                        all_positions.add(location4);
                                                                                        all_positions.add(location5);
                                                                                        all_positions.add(location6);
                                                                                        all_positions.add(location7);
                                                                                        all_positions.add(location8);
                                                                                        all_positions.add(location9);
                                                                                        all_positions.add(location10);
                                                                                        if (collisions(all_positions) == false) {
                                                                                            claim(canvas, all_positions);
                                                                                            return all_positions;
                                                                                        }
                                                                                    } else {
                                                                                        System.out.println("MAX AMOUNT OF SHAPES IS HARD CODED TO 10.");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        ArrayList<ArrayList<Point>> blank = new ArrayList<>();
        return blank;
    }
    public ArrayList<ArrayList<Point>> convertRawString(String rawInput) {
        String[] rawDivided = rawInput.split("\\D+");
        ArrayList<ArrayList<Point>> shapes = new ArrayList<>();
        int counter = 0;
        Integer index = 0;
        Integer x = 0;
        Integer y = 0;
        Integer z = 0;
        for(String rawValue: rawDivided){
            if(isNumeric(rawValue)){
                if(counter == 0){
                    index = Integer.parseInt(rawValue);
                    ArrayList<Point> points = new ArrayList<>();
                    while(shapes.size() < (index + 1)){
                        shapes.add(points);
                    }
                    counter += 1;
                } else if(counter == 1){
                    x = Integer.parseInt(rawValue);

                    counter += 1;
                } else if(counter == 2){
                    y = Integer.parseInt(rawValue);

                    counter += 1;
                } else if(counter == 3){
                    z = Integer.parseInt(rawValue);
                    shapes.get(index).add(new Point(x, y, z));
                    counter = 0;
                }
            } else {
                continue;
            }
        }
        System.out.println(shapes.get(1).toString());
        return shapes;

    }


    public static boolean isNumeric(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        int i = 0;
        int stringLength = string.length();
        if (string.charAt(0) == '-') {
            if (stringLength > 1) {
                i++;
            } else {
                return false;
            }
        }
        if (!Character.isDigit(string.charAt(i))
                || !Character.isDigit(string.charAt(stringLength - 1))) {
            return false;
        }
        i++;
        stringLength--;
        if (i >= stringLength) {
            return true;
        }
        for (; i < stringLength; i++) {
            if (!Character.isDigit(string.charAt(i))
                    && string.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }
    public ArrayList<Shape> convertPointsToShapes(ArrayList<ArrayList<Point>> points, Integer dimensions){
        ArrayList<Shape> shapes = new ArrayList<>();
        Sorter sorter = new Sorter();
        for(int i=0; i < points.size(); i++){
            Shape shape = new Shape(i, sorter.sort(points.get(i)), dimensions);
            shapes.add(shape);
        }
        return shapes;
    }
    public Canvas prepareCanvas(ArrayList<Shape> shapes){
        Canvas canvas = new Canvas(shapes.get(0).points);
        shapes.remove(0);
        canvas.setShapes(shapes);
        return canvas;
    }
}
