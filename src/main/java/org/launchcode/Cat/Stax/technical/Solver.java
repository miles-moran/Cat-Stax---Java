package org.launchcode.Cat.Stax.technical;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solver {

    public void data(Canvas canvas) {
        Placer placer = new Placer();
        int sum = 0;
        double p = 1;
        for (Shape shape : canvas.shapes) {
            sum += shape.points.size();
            System.out.println("locations");
            System.out.println(placer.locations(canvas, shape).size());
            p = p * placer.locations(canvas, shape).size();
        }
        Integer count = canvas.shapes.size();
        String canvas_mass = "Canvas Mass: " + canvas.points.size();
        String shape_mass = "Shape Mass: " + sum;
        String shape_count = "Shape Count: " + count;

        System.out.println(canvas_mass);
        System.out.println(shape_mass);
        System.out.println(shape_count);

        System.out.println("Permutations: ");
        System.out.print(p);
    }

    public boolean collisions2(ArrayList<ArrayList<Point>> all_positions) {
        int all_positions_length = all_positions.size();
        for (int i=0; i < all_positions_length; i++){
            for (int j=0; j < all_positions_length && j!=i; j++){
                for(Point iPoint: all_positions.get(i)){
                    for(Point jPoint: all_positions.get(j)){
                        if (iPoint.getList().equals(jPoint.getList())) {
                            return true;
                        }
                    }
                }
            }
        }
    return false;
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
                        if (collisions2(all_positions) == false) {
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
                                if (collisions2(all_positions) == false) {
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
                                        if (collisions2(all_positions) == false) {
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
                                                if (collisions2(all_positions) == false) {
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
                                                        if (collisions2(all_positions) == false) {
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
                                                                if (collisions2(all_positions) == false) {
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
                                                                        if (collisions2(all_positions) == false) {
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
                                                                                if (collisions2(all_positions) == false) {
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
                                                                                        if (collisions2(all_positions) == false) {
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
    public ArrayList<ArrayList<Point>> solve2(Canvas canvas) {
        data(canvas);
        Placer placer = new Placer();

        ArrayList<ArrayList<Point>> all_positions = new ArrayList<>();

        ArrayList<ArrayList<Point>> locations1 = placer.locations(canvas, canvas.shapes.get(0));
        for (ArrayList<Point> location1 : locations1) {
            all_positions.clear();
            all_positions.add(location1);
            System.out.println(all_positions.size());
            if (collisions(all_positions)) {
                continue;
            } else {
                if (canvas.shapes.size() == 1) {
                    claim(canvas, all_positions);
                    return all_positions;
                } else {
                    ArrayList<ArrayList<Point>> locations2 = placer.locations(canvas, canvas.shapes.get(1));
                    for (ArrayList<Point> location2 : locations2) {
                        all_positions.clear();
                        all_positions.add(location1);
                        all_positions.add(location2);
                        System.out.println(all_positions.size());
                        if (collisions(all_positions)) {
                            continue;
                        } else {
                            if (canvas.shapes.size() == 2) {
                                claim(canvas, all_positions);
                                return all_positions;
                            } else {
                                ArrayList<ArrayList<Point>> locations3 = placer.locations(canvas, canvas.shapes.get(2));
                                for (ArrayList<Point> location3 : locations3) {
                                    all_positions.clear();
                                    all_positions.add(location1);
                                    all_positions.add(location2);
                                    all_positions.add(location3);
                                    System.out.println(all_positions.size());
                                    if (collisions(all_positions)) {
                                        continue;
                                    } else {
                                        if (canvas.shapes.size() == 3) {
                                            claim(canvas, all_positions);
                                            return all_positions;
                                        } else {
                                            ArrayList<ArrayList<Point>> locations4 = placer.locations(canvas, canvas.shapes.get(3));
                                            for (ArrayList<Point> location4 : locations4) {
                                                all_positions.clear();
                                                all_positions.add(location1);
                                                all_positions.add(location2);
                                                all_positions.add(location3);
                                                all_positions.add(location4);
                                                System.out.println(all_positions.size());
                                                if (collisions(all_positions)) {
                                                    continue;
                                                } else {
                                                    if (canvas.shapes.size() == 4) {all_positions.add(location1);
                                                        claim(canvas, all_positions);
                                                        return all_positions;
                                                    } else {
                                                        ArrayList<ArrayList<Point>> locations5 = placer.locations(canvas, canvas.shapes.get(4));
                                                        for (ArrayList<Point> location5 : locations5) {
                                                            all_positions.clear();
                                                            all_positions.add(location1);
                                                            all_positions.add(location2);
                                                            all_positions.add(location3);
                                                            all_positions.add(location4);
                                                            all_positions.add(location5);
                                                            System.out.println(all_positions.size());
                                                            if (collisions(all_positions)) {
                                                                continue;
                                                            } else {
                                                                if (canvas.shapes.size() == 5) {
                                                                    claim(canvas, all_positions);
                                                                    return all_positions;
                                                                } else {
                                                                    ArrayList<ArrayList<Point>> locations6 = placer.locations(canvas, canvas.shapes.get(5));
                                                                    for (ArrayList<Point> location6 : locations6) {
                                                                        all_positions.clear();
                                                                        all_positions.add(location1);
                                                                        all_positions.add(location2);
                                                                        all_positions.add(location3);
                                                                        all_positions.add(location4);
                                                                        all_positions.add(location5);
                                                                        all_positions.add(location6);
                                                                        if (collisions(all_positions)) {
                                                                            continue;
                                                                        } else {
                                                                            if (canvas.shapes.size() == 6) {
                                                                                claim(canvas, all_positions);
                                                                                return all_positions;
                                                                            } else {
                                                                                ArrayList<ArrayList<Point>> locations7 = placer.locations(canvas, canvas.shapes.get(6));
                                                                                for (ArrayList<Point> location7 : locations7) {
                                                                                    all_positions.clear();
                                                                                    all_positions.add(location1);
                                                                                    all_positions.add(location2);
                                                                                    all_positions.add(location3);
                                                                                    all_positions.add(location4);
                                                                                    all_positions.add(location5);
                                                                                    all_positions.add(location6);
                                                                                    all_positions.add(location7);
                                                                                    if (collisions(all_positions)) {
                                                                                        continue;
                                                                                    } else {
                                                                                        if (canvas.shapes.size() == 7) {
                                                                                            claim(canvas, all_positions);
                                                                                            return all_positions;
                                                                                        } else {
                                                                                            ArrayList<ArrayList<Point>> locations8 = placer.locations(canvas, canvas.shapes.get(7));
                                                                                            for (ArrayList<Point> location8 : locations8) {
                                                                                                all_positions.clear();
                                                                                                all_positions.add(location1);
                                                                                                all_positions.add(location2);
                                                                                                all_positions.add(location3);
                                                                                                all_positions.add(location4);
                                                                                                all_positions.add(location5);
                                                                                                all_positions.add(location6);
                                                                                                all_positions.add(location7);
                                                                                                all_positions.add(location8);
                                                                                                if (collisions(all_positions)) {
                                                                                                    continue;
                                                                                                } else {
                                                                                                    if (canvas.shapes.size() == 8) {
                                                                                                        claim(canvas, all_positions);
                                                                                                        return all_positions;
                                                                                                    } else {
                                                                                                        ArrayList<ArrayList<Point>> locations9 = placer.locations(canvas, canvas.shapes.get(8));
                                                                                                        for (ArrayList<Point> location9 : locations9) {
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
                                                                                                            if (collisions(all_positions)) {
                                                                                                                continue;
                                                                                                            } else {
                                                                                                                if (canvas.shapes.size() == 9) {
                                                                                                                    claim(canvas, all_positions);
                                                                                                                    return all_positions;
                                                                                                                } else {
                                                                                                                    ArrayList<ArrayList<Point>> locations10 = placer.locations(canvas, canvas.shapes.get(9));
                                                                                                                    for (ArrayList<Point> location10 : locations10) {
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
                                                                                                                        if (collisions(all_positions)) {
                                                                                                                            continue;
                                                                                                                        } else {
                                                                                                                            if (canvas.shapes.size() == 10) {
                                                                                                                                claim(canvas, all_positions);
                                                                                                                                return all_positions;
                                                                                                                            } else {
                                                                                                                                ArrayList<ArrayList<Point>> locations11 = placer.locations(canvas, canvas.shapes.get(10));
                                                                                                                                for (ArrayList<Point> location11 : locations11) {
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
                                                                                                                                    all_positions.add(location11);
                                                                                                                                    if (collisions(all_positions)) {
                                                                                                                                        continue;
                                                                                                                                    } else {
                                                                                                                                        if (canvas.shapes.size() == 11) {
                                                                                                                                            claim(canvas, all_positions);
                                                                                                                                            return all_positions;
                                                                                                                                        } else {
                                                                                                                                            ArrayList<ArrayList<Point>> locations12 = placer.locations(canvas, canvas.shapes.get(11));
                                                                                                                                            for (ArrayList<Point> location12 : locations12) {
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
                                                                                                                                                all_positions.add(location11);
                                                                                                                                                all_positions.add(location12);
                                                                                                                                                if (collisions(all_positions)) {
                                                                                                                                                    continue;
                                                                                                                                                } else {
                                                                                                                                                    if (canvas.shapes.size() == 12) {
                                                                                                                                                        claim(canvas, all_positions);
                                                                                                                                                        return all_positions;
                                                                                                                                                    } else {
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
        return all_positions;
    }
    public ArrayList<ArrayList<Point>> solve4(Canvas canvas){
        data(canvas);
        Placer placer = new Placer();
        int shapes = canvas.shapes.size();

        ArrayList<ArrayList<ArrayList<Point>>> locations = new ArrayList<>();
        for (int i = 0; i < shapes; i++) {
            locations.add(placer.locations(canvas, canvas.shapes.get(i)));
        }

        ArrayList<ArrayList<Point>> all_positions = new ArrayList<>();
        all_positions.add(new ArrayList<>());
        System.out.println(all_positions.size());

        ArrayList<String> test = new ArrayList<>();
        test.add("");
        double comparisons = 0;

        ArrayList<ArrayList<Point>> locations0 = locations.get(0);
        for (ArrayList<Point> location0: locations0) {
            test.clear();
            all_positions.clear();

            all_positions.add(location0);
            test.add("location0");
            System.out.println(test.toString());

            if (collisions(all_positions)) {
                continue;
            } else {
                if (shapes == 1) {
                    claim(canvas, all_positions);
                    System.out.println(comparisons);
                    return all_positions;
                } else {
                    ArrayList<ArrayList<Point>> locations1 = locations.get(1);
                    for (ArrayList<Point> location1: locations1) {
                        for (int i = all_positions.size() - 1; i > 0; i--) {
                            all_positions.remove(i);
                            test.remove(i);
                        }
                        all_positions.add(location1);
                        test.add("location1");
                        System.out.println(test.toString());
                        comparisons += 1;

                        if (collisions(all_positions)) {
                            continue;
                        } else {
                            if (shapes == 2) {
                                claim(canvas, all_positions);
                                System.out.println(comparisons);
                                return all_positions;
                            } else {
                                ArrayList<ArrayList<Point>> locations2 = locations.get(2);
                                for (ArrayList<Point> location2: locations2) {
                                    for (int i = all_positions.size() - 1; i > 1; i--) {
                                        all_positions.remove(i);
                                        test.remove(i);
                                    }
                                    all_positions.add(location2);
                                    test.add("location2");
                                    System.out.println(test.toString());
                                    comparisons += 1;

                                    if (collisions(all_positions)) {
                                        continue;
                                    } else {
                                        if (shapes == 3) {
                                            claim(canvas, all_positions);
                                            System.out.println(comparisons);
                                            return all_positions;
                                        } else {
                                            ArrayList<ArrayList<Point>> locations3 = locations.get(3);
                                            for (ArrayList<Point> location3: locations3) {
                                                for (int i = all_positions.size() - 1; i > 2; i--) {
                                                    all_positions.remove(i);
                                                    test.remove(i);
                                                }
                                                all_positions.add(location3);
                                                test.add("location3");
                                                System.out.println(test.toString());
                                                comparisons += 1;

                                                if (collisions(all_positions)) {
                                                    continue;
                                                } else {
                                                    if (shapes == 4) {
                                                        claim(canvas, all_positions);
                                                        System.out.println(comparisons);
                                                        return all_positions;
                                                    } else {
                                                        ArrayList<ArrayList<Point>> locations4 = locations.get(4);
                                                        for (ArrayList<Point> location4: locations4) {
                                                            for (int i = all_positions.size() - 1; i > 3; i--) {
                                                                all_positions.remove(i);
                                                                test.remove(i);
                                                            }
                                                            all_positions.add(location4);
                                                            test.add("location4");
                                                            System.out.println(test.toString());
                                                            comparisons += 1;

                                                            if (collisions(all_positions)) {
                                                                continue;
                                                            } else {
                                                                if (shapes == 5) {
                                                                    claim(canvas, all_positions);
                                                                    System.out.println(comparisons);
                                                                    return all_positions;
                                                                } else {
                                                                    ArrayList<ArrayList<Point>> locations5 = locations.get(5);
                                                                    for (ArrayList<Point> location5: locations5) {
                                                                        for (int i = all_positions.size() - 1; i > 4; i--) {
                                                                            all_positions.remove(i);
                                                                            test.remove(i);
                                                                        }
                                                                        all_positions.add(location5);
                                                                        test.add("location5");
                                                                        System.out.println(test.toString());
                                                                        comparisons += 1;

                                                                        if (collisions(all_positions)) {
                                                                            continue;
                                                                        } else {
                                                                            if (shapes == 6) {
                                                                                claim(canvas, all_positions);
                                                                                System.out.println(comparisons);
                                                                                return all_positions;
                                                                            } else {
                                                                                ArrayList<ArrayList<Point>> locations6 = locations.get(6);
                                                                                for (ArrayList<Point> location6: locations6) {
                                                                                    for (int i = all_positions.size() - 1; i > 5; i--) {
                                                                                        all_positions.remove(i);
                                                                                        test.remove(i);
                                                                                    }
                                                                                    all_positions.add(location6);
                                                                                    test.add("location6");
                                                                                    System.out.println(test.toString());
                                                                                    comparisons += 1;

                                                                                    if (collisions(all_positions)) {
                                                                                        continue;
                                                                                    } else {
                                                                                        if (shapes == 7) {
                                                                                            claim(canvas, all_positions);
                                                                                            System.out.println(comparisons);
                                                                                            return all_positions;
                                                                                        } else {
                                                                                            ArrayList<ArrayList<Point>> locations7 = locations.get(7);
                                                                                            for (ArrayList<Point> location7: locations7) {
                                                                                                for (int i = all_positions.size() - 1; i > 6; i--) {
                                                                                                    all_positions.remove(i);
                                                                                                    test.remove(i);
                                                                                                }
                                                                                                all_positions.add(location7);
                                                                                                test.add("location7");
                                                                                                System.out.println(test.toString());
                                                                                                comparisons += 1;

                                                                                                if (collisions(all_positions)) {
                                                                                                    continue;
                                                                                                } else {
                                                                                                    if (shapes == 8) {
                                                                                                        claim(canvas, all_positions);
                                                                                                        System.out.println(comparisons);
                                                                                                        return all_positions;
                                                                                                    } else {
                                                                                                        ArrayList<ArrayList<Point>> locations8 = locations.get(8);
                                                                                                        for (ArrayList<Point> location8: locations8) {
                                                                                                            for (int i = all_positions.size() - 1; i > 7; i--) {
                                                                                                                all_positions.remove(i);
                                                                                                                test.remove(i);
                                                                                                            }
                                                                                                            all_positions.add(location8);
                                                                                                            test.add("location8");
                                                                                                            System.out.println(test.toString());
                                                                                                            comparisons += 1;

                                                                                                            if (collisions(all_positions)) {
                                                                                                                continue;
                                                                                                            } else {
                                                                                                                if (shapes == 9) {
                                                                                                                    claim(canvas, all_positions);
                                                                                                                    System.out.println(comparisons);
                                                                                                                    return all_positions;
                                                                                                                } else {
                                                                                                                    ArrayList<ArrayList<Point>> locations9 = locations.get(9);
                                                                                                                    for (ArrayList<Point> location9: locations9) {
                                                                                                                        for (int i = all_positions.size() - 1; i > 8; i--) {
                                                                                                                            all_positions.remove(i);
                                                                                                                            test.remove(i);
                                                                                                                        }
                                                                                                                        all_positions.add(location9);
                                                                                                                        test.add("location9");
                                                                                                                        System.out.println(test.toString());
                                                                                                                        comparisons += 1;

                                                                                                                        if (collisions(all_positions)) {
                                                                                                                            continue;
                                                                                                                        } else {
                                                                                                                            if (shapes == 10) {
                                                                                                                                claim(canvas, all_positions);
                                                                                                                                System.out.println(comparisons);
                                                                                                                                return all_positions;
                                                                                                                            } else {
                                                                                                                                ArrayList<ArrayList<Point>> locations10 = locations.get(10);
                                                                                                                                for (ArrayList<Point> location10: locations10) {
                                                                                                                                    for (int i = all_positions.size() - 1; i > 9; i--) {
                                                                                                                                        all_positions.remove(i);
                                                                                                                                        test.remove(i);
                                                                                                                                    }
                                                                                                                                    all_positions.add(location10);
                                                                                                                                    test.add("location10");
                                                                                                                                    System.out.println(test.toString());
                                                                                                                                    comparisons += 1;

                                                                                                                                    if (collisions(all_positions)) {
                                                                                                                                        continue;
                                                                                                                                    } else {
                                                                                                                                        if (shapes == 11) {
                                                                                                                                            claim(canvas, all_positions);
                                                                                                                                            System.out.println(comparisons);
                                                                                                                                            return all_positions;
                                                                                                                                        } else {
                                                                                                                                            ArrayList<ArrayList<Point>> locations11 = locations.get(11);
                                                                                                                                            for (ArrayList<Point> location11: locations11) {
                                                                                                                                                for (int i = all_positions.size() - 1; i > 10; i--) {
                                                                                                                                                    all_positions.remove(i);
                                                                                                                                                    test.remove(i);
                                                                                                                                                }
                                                                                                                                                all_positions.add(location11);
                                                                                                                                                test.add("location11");
                                                                                                                                                System.out.println(test.toString());
                                                                                                                                                comparisons += 1;

                                                                                                                                                if (collisions(all_positions)) {
                                                                                                                                                    continue;
                                                                                                                                                } else {
                                                                                                                                                    if (shapes == 12) {
                                                                                                                                                        claim(canvas, all_positions);
                                                                                                                                                        System.out.println(comparisons);
                                                                                                                                                        return all_positions;
                                                                                                                                                    } else {

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
        System.out.println(comparisons);
        System.out.println("NO SOLUTION FOUND");
        return all_positions;
    }
    public ArrayList<ArrayList<Point>> solve3(Canvas canvas) { // the goal is to not reconstruct a list every time3
        data(canvas);
        Placer placer = new Placer();

        ArrayList<ArrayList<Point>> all_positions = new ArrayList<>();
        all_positions.add(new ArrayList<>());
        System.out.println(all_positions.size());

        ArrayList<ArrayList<Point>> locations0 = placer.locations(canvas, canvas.shapes.get(0));
        for (ArrayList<Point> location0 : locations0) {

            for (int cleanse = 0; cleanse < all_positions.size(); cleanse++) {
                all_positions.remove(cleanse);
            }
            all_positions.add(location0);
            System.out.println(all_positions.size());

            if (collisions(all_positions)) {
                continue;
            } else {
                if (canvas.shapes.size() == 1) {
                    claim(canvas, all_positions);
                    return all_positions;
                } else {
                    ArrayList<ArrayList<Point>> locations1 = placer.locations(canvas, canvas.shapes.get(1));
                    for (ArrayList<Point> location1 : locations1) {

                        for (int cleanse = 1; cleanse < all_positions.size(); cleanse++) {
                            all_positions.remove(cleanse);
                        }
                        all_positions.add(location1);
                        System.out.println(all_positions.size());

                        if (collisions(all_positions)) {
                            continue;
                        } else {
                            if (canvas.shapes.size() == 2) {
                                claim(canvas, all_positions);
                                return all_positions;
                            } else {
                                ArrayList<ArrayList<Point>> locations2 = placer.locations(canvas, canvas.shapes.get(2));
                                for (ArrayList<Point> location2 : locations2) {

                                    for (int cleanse = 2; cleanse < all_positions.size(); cleanse++) {
                                        all_positions.remove(cleanse);
                                    }
                                    all_positions.add(location2);
                                    System.out.println(all_positions.size());

                                    if (collisions(all_positions)) {
                                        continue;
                                    } else {
                                        if (canvas.shapes.size() == 3) {
                                            claim(canvas, all_positions);
                                            return all_positions;
                                        } else {
                                            ArrayList<ArrayList<Point>> locations3 = placer.locations(canvas, canvas.shapes.get(3));
                                            for (ArrayList<Point> location3 : locations3) {

                                                for (int cleanse = 3; cleanse < all_positions.size(); cleanse++) {
                                                    all_positions.remove(cleanse);
                                                }
                                                all_positions.add(location3);
                                                System.out.println(all_positions.size());

                                                if (collisions(all_positions)) {
                                                    continue;
                                                } else {
                                                    if (canvas.shapes.size() == 4) {
                                                        claim(canvas, all_positions);
                                                        return all_positions;
                                                    } else {
                                                        ArrayList<ArrayList<Point>> locations4 = placer.locations(canvas, canvas.shapes.get(4));
                                                        for (ArrayList<Point> location4 : locations4) {

                                                            for (int cleanse = 4; cleanse < all_positions.size(); cleanse++) {
                                                                all_positions.remove(cleanse);
                                                            }
                                                            all_positions.add(location4);
                                                            System.out.println(all_positions.size());

                                                            if (collisions(all_positions)) {
                                                                continue;
                                                            } else {
                                                                if (canvas.shapes.size() == 5) {
                                                                    claim(canvas, all_positions);
                                                                    return all_positions;
                                                                } else {
                                                                    ArrayList<ArrayList<Point>> locations5 = placer.locations(canvas, canvas.shapes.get(5));
                                                                    for (ArrayList<Point> location5 : locations5) {

                                                                        for (int cleanse = 5; cleanse < all_positions.size(); cleanse++) {
                                                                            all_positions.remove(cleanse);
                                                                        }
                                                                        all_positions.add(location5);
                                                                        System.out.println(all_positions.size());

                                                                        if (collisions(all_positions)) {
                                                                            continue;
                                                                        } else {
                                                                            if (canvas.shapes.size() == 6) {
                                                                                claim(canvas, all_positions);
                                                                                return all_positions;
                                                                            } else {
                                                                                ArrayList<ArrayList<Point>> locations6 = placer.locations(canvas, canvas.shapes.get(6));
                                                                                for (ArrayList<Point> location6 : locations6) {

                                                                                    for (int cleanse = 6; cleanse < all_positions.size(); cleanse++) {
                                                                                        all_positions.remove(cleanse);
                                                                                    }
                                                                                    all_positions.add(location6);

                                                                                    if (collisions(all_positions)) {
                                                                                        System.out.println(all_positions.size());
                                                                                        continue;
                                                                                    } else {
                                                                                        if (canvas.shapes.size() == 7) {
                                                                                            claim(canvas, all_positions);
                                                                                            return all_positions;
                                                                                        } else {
                                                                                            ArrayList<ArrayList<Point>> locations7 = placer.locations(canvas, canvas.shapes.get(7));
                                                                                            for (ArrayList<Point> location7 : locations7) {

                                                                                                for (int cleanse = 7; cleanse < all_positions.size(); cleanse++) {
                                                                                                    all_positions.remove(cleanse);
                                                                                                }
                                                                                                all_positions.add(location7);
                                                                                                System.out.println(all_positions.size());

                                                                                                if (collisions(all_positions)) {
                                                                                                    continue;
                                                                                                } else {
                                                                                                    if (canvas.shapes.size() == 8) {
                                                                                                        claim(canvas, all_positions);
                                                                                                        return all_positions;
                                                                                                    } else {
                                                                                                        ArrayList<ArrayList<Point>> locations8 = placer.locations(canvas, canvas.shapes.get(8));
                                                                                                        for (ArrayList<Point> location8 : locations8) {

                                                                                                            for (int cleanse = 8; cleanse < all_positions.size(); cleanse++) {
                                                                                                                all_positions.remove(cleanse);
                                                                                                            }
                                                                                                            all_positions.add(location8);

                                                                                                            if (collisions(all_positions)) {
                                                                                                                continue;
                                                                                                            } else {
                                                                                                                if (canvas.shapes.size() == 9) {
                                                                                                                    claim(canvas, all_positions);
                                                                                                                    return all_positions;
                                                                                                                } else {
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
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("NO SOLUTION FOUND");
        return all_positions;
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
