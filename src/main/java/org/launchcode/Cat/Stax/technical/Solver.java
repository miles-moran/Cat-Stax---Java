package org.launchcode.Cat.Stax.technical;

import sun.security.provider.SHA;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Solver {

    public double data(Canvas canvas) {
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
        return p;
    }

    public boolean collisions2(ArrayList<ArrayList<Point>> all_positions) {
        int all_positions_length = all_positions.size();
        for (int i = 0; i < all_positions_length; i++) {
            for (int j = 0; j < all_positions_length && j != i; j++) {
                for (Point iPoint : all_positions.get(i)) {
                    for (Point jPoint : all_positions.get(j)) {
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
                        canvas_point.setOccupant(canvas.shapes.get(shape));
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
                                                    if (canvas.shapes.size() == 4) {
                                                        all_positions.add(location1);
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

    public ArrayList<ArrayList<Point>> solve4(Canvas canvas) {
        data(canvas);
        Placer placer = new Placer();
        int shapes = canvas.shapes.size();
        canvas.shapes = canvas.sortShapesByMass(canvas.shapes);

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
        for (ArrayList<Point> location0 : locations0) {
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
                    for (ArrayList<Point> location1 : locations1) {
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
                                for (ArrayList<Point> location2 : locations2) {
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
                                            for (ArrayList<Point> location3 : locations3) {
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
                                                        for (ArrayList<Point> location4 : locations4) {
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
                                                                    for (ArrayList<Point> location5 : locations5) {
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
                                                                                for (ArrayList<Point> location6 : locations6) {
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
                                                                                            for (ArrayList<Point> location7 : locations7) {
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
                                                                                                        for (ArrayList<Point> location8 : locations8) {
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
                                                                                                                    for (ArrayList<Point> location9 : locations9) {
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
                                                                                                                                for (ArrayList<Point> location10 : locations10) {
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
                                                                                                                                            for (ArrayList<Point> location11 : locations11) {
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

    public ArrayList<ArrayList<Point>> convertRawString(String rawInput) {
        System.out.println("RAWINPUT" + rawInput);
        String[] rawDivided = rawInput.split("\\D+");
        ArrayList<ArrayList<Point>> shapes = new ArrayList<>();
        System.out.println("raw divided - length" + rawDivided.length);
        int counter = 0;
        Integer index = 0;
        Integer x = 0;
        Integer y = 0;
        Integer z = 0;
        for (String rawValue : rawDivided) {
            if (isNumeric(rawValue)) {
                if (counter == 0) {
                    index = Integer.parseInt(rawValue);
                    ArrayList<Point> points = new ArrayList<>();
                    while (shapes.size() < (index + 1)) {
                        shapes.add(points);
                    }
                    counter += 1;
                } else if (counter == 1) {
                    x = Integer.parseInt(rawValue);

                    counter += 1;
                } else if (counter == 2) {
                    y = Integer.parseInt(rawValue);

                    counter += 1;
                } else if (counter == 3) {
                    z = Integer.parseInt(rawValue);
                    shapes.get(index).add(new Point(x, y, z));
                    counter = 0;
                }
            } else {
                continue;
            }
        }
        return shapes;
    }

    public ArrayList<ArrayList<Point>> convertRawStringADD(String rawInput) {
        String[] rawDivided = rawInput.split("\\D+");
        ArrayList<ArrayList<Point>> shapes = new ArrayList<>();
        HashMap<Integer, Integer> indexes = new HashMap<>();
        int counter = 0;
        Integer index = 0;
        Integer x = 0;
        Integer y = 0;
        Integer z = 0;
        for (String rawValue : rawDivided) {
            if (isNumeric(rawValue)) {
                if (counter == 0) {
                    index = Integer.parseInt(rawValue);
                    ArrayList<Point> points = new ArrayList<>();

                    if (!indexes.containsKey(index) || indexes.isEmpty()) {
                        shapes.add(points);
                        indexes.put(index, (shapes.size() - 1));
                    }
                    counter += 1;
                } else if (counter == 1) {
                    x = Integer.parseInt(rawValue);
                    counter += 1;
                } else if (counter == 2) {
                    y = Integer.parseInt(rawValue);

                    counter += 1;
                } else if (counter == 3) {
                    z = Integer.parseInt(rawValue);
                    shapes.get(indexes.get(index)).add(new Point(x, y, z));
                    counter = 0;
                }
            } else {
                continue;
            }
        }

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

    public ArrayList<Shape> convertPointsToShapes(ArrayList<ArrayList<Point>> points, Integer dimensions) {
        ArrayList<Shape> shapes = new ArrayList<>();
        Sorter sorter = new Sorter();
        if (!points.isEmpty()) {
            for (int i = 0; i < points.size(); i++) {
                Shape shape = new Shape(i, sorter.sort(points.get(i)), dimensions);
                shape.setColor(shape.createColor());
                shapes.add(shape);
            }
        }
        return shapes;
    }

    public Canvas prepareCanvas(ArrayList<Shape> shapes) {
        Canvas canvas = new Canvas(shapes.get(0).points);
        shapes.remove(0);
        canvas.setShapes(shapes);
        return canvas;
    }

    public void solve5(Canvas canvas) {

        System.out.println("SOLVING");
        Placer2 placer2 = new Placer2();

        ArrayList<Shape> shapes = canvas.shapes;
        ArrayList<ArrayList<Point>> all_positions = new ArrayList<>();

        ArrayList<ArrayList<Point>> locations0 = placer2.locations(canvas, shapes.get(0), all_positions);
        System.out.println(locations0.size());
        for (ArrayList<Point> location0 : locations0) {
            all_positions.clear();
            all_positions.add(location0);
            System.out.println(all_positions.toString());
            if (locations0.size() == 0) {
                continue;
            } else if (shapes.size() == 1) {
                if (locations0.size() == 1) {
                    claim(canvas, all_positions);
                    return;
                } else {
                    continue;
                }
            } else {
                ArrayList<ArrayList<Point>> locations1 = placer2.locations(canvas, shapes.get(1), all_positions);
                System.out.println(locations1.size());

                for (ArrayList<Point> location1 : locations1) {
                    for (int i = all_positions.size() - 1; i > 0; i--) {
                        all_positions.remove(i);
                    }
                    all_positions.add(location1);
                    System.out.println(all_positions.toString());
                    if (locations1.size() == 0) {
                        continue;
                    } else if (shapes.size() == 2) {
                        if (locations1.size() == 1) {
                            claim(canvas, all_positions);
                            return;
                        } else {
                            continue;
                        }
                    } else {
                        ArrayList<ArrayList<Point>> locations2 = placer2.locations(canvas, shapes.get(2), all_positions);
                        System.out.println(locations2.size());

                        for (ArrayList<Point> location2 : locations2) {
                            for (int i = all_positions.size() - 1; i > 1; i--) {
                                all_positions.remove(i);
                            }
                            all_positions.add(location2);
                            System.out.println(all_positions.toString());

                            if (location2.size() == 0) {
                                continue;
                            } else if (shapes.size() == 3) {
                                if (locations2.size() == 1) {
                                    claim(canvas, all_positions);
                                    return;
                                } else {
                                    continue;
                                }
                            } else {
                                ArrayList<ArrayList<Point>> locations3 = placer2.locations(canvas, shapes.get(3), all_positions);
                                System.out.println(locations3.size());

                                for (ArrayList<Point> location3 : locations3) {
                                    for (int i = all_positions.size() - 1; i > 2; i--) {
                                        all_positions.remove(i);
                                    }
                                    all_positions.add(location3);
                                    System.out.println(all_positions.toString());
                                    if (location3.size() == 0) {
                                        continue;
                                    } else if (shapes.size() == 4) {
                                        if (locations3.size() == 1) {
                                            claim(canvas, all_positions);
                                            return;
                                        } else {
                                            continue;
                                        }
                                    } else {
                                        ArrayList<ArrayList<Point>> locations4 = placer2.locations(canvas, shapes.get(4), all_positions);
                                        System.out.println(locations4.size());

                                        for (ArrayList<Point> location4 : locations4) {
                                            for (int i = all_positions.size() - 1; i > 3; i--) {
                                                all_positions.remove(i);
                                            }
                                            all_positions.add(location4);
                                            System.out.println(all_positions.toString());
                                            if (location4.size() == 0) {
                                                continue;
                                            } else if (shapes.size() == 5) {
                                                if (locations4.size() == 1) {
                                                    claim(canvas, all_positions);
                                                    return;
                                                } else {
                                                    continue;
                                                }
                                            } else {
                                                ArrayList<ArrayList<Point>> locations5 = placer2.locations(canvas, shapes.get(5), all_positions);
                                                System.out.println(locations5.size());

                                                for (ArrayList<Point> location5 : locations5) {
                                                    for (int i = all_positions.size() - 1; i > 4; i--) {
                                                        all_positions.remove(i);
                                                    }
                                                    all_positions.add(location5);
                                                    System.out.println(all_positions.toString());
                                                    if (locations5.size() == 0) {
                                                        continue;
                                                    } else if (shapes.size() == 6) {
                                                        if (locations5.size() == 1) {
                                                            claim(canvas, all_positions);
                                                            return;
                                                        } else {
                                                            continue;
                                                        }
                                                    } else {
                                                        ArrayList<ArrayList<Point>> locations6 = placer2.locations(canvas, shapes.get(6), all_positions);
                                                        System.out.println(locations6.size());

                                                        for (ArrayList<Point> location6 : locations6) {
                                                            for (int i = all_positions.size() - 1; i > 5; i--) {
                                                                all_positions.remove(i);
                                                            }
                                                            all_positions.add(location6);
                                                            System.out.println(all_positions.toString());
                                                            if (locations6.size() == 0) {
                                                                continue;
                                                            } else if (shapes.size() == 7) {
                                                                if (locations6.size() == 1) {
                                                                    claim(canvas, all_positions);
                                                                    return;
                                                                } else {
                                                                    continue;
                                                                }
                                                            } else {
                                                                ArrayList<ArrayList<Point>> locations7 = placer2.locations(canvas, shapes.get(7), all_positions);
                                                                System.out.println(locations7.size());

                                                                for (ArrayList<Point> location7 : locations7) {
                                                                    for (int i = all_positions.size() - 1; i > 6; i--) {
                                                                        all_positions.remove(i);
                                                                    }
                                                                    all_positions.add(location7);
                                                                    System.out.println(all_positions.toString());
                                                                    if (locations7.size() == 0) {
                                                                        continue;
                                                                    } else if (shapes.size() == 8) {
                                                                        if (locations7.size() == 1) {
                                                                            claim(canvas, all_positions);
                                                                            return;
                                                                        } else {
                                                                            continue;
                                                                        }
                                                                    } else {
                                                                        ArrayList<ArrayList<Point>> locations8 = placer2.locations(canvas, shapes.get(8), all_positions);
                                                                        System.out.println(locations8.size());

                                                                        for (ArrayList<Point> location8 : locations8) {
                                                                            for (int i = all_positions.size() - 1; i > 7; i--) {
                                                                                all_positions.remove(i);
                                                                            }
                                                                            all_positions.add(location8);
                                                                            System.out.println(all_positions.toString());
                                                                            if (locations8.size() == 0) {
                                                                                continue;
                                                                            } else if (shapes.size() == 9) {
                                                                                if (locations8.size() == 1) {
                                                                                    claim(canvas, all_positions);
                                                                                    return;
                                                                                } else {
                                                                                    continue;
                                                                                }
                                                                            } else {
                                                                                System.out.println("EXCEEDS SHAPE LIMIT");
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

        System.out.println("FINALIZING)");
    }
    public ArrayList<ArrayList<Point>> solver6(Canvas canvas) {
        data(canvas);
        Placer placer = new Placer();
        canvas.shapes = canvas.sortShapesByMass(canvas.shapes);
        int shapes = canvas.shapes.size();

        ArrayList<ArrayList<ArrayList<Point>>> locations = new ArrayList<>();
        for (int i = 0; i < shapes; i++) {
            locations.add(placer.locations(canvas, canvas.shapes.get(i)));
        }

        ArrayList<ArrayList<Point>> all_positions = new ArrayList<>();
        all_positions.add(new ArrayList<>());

        ArrayList<ArrayList<Point>> locations0 = locations.get(0);
        for (ArrayList<Point> location0 : locations0) {
            all_positions.clear();
            all_positions.add(location0);
            if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                continue;
            } else {
                if (shapes == 1) {
                    claim(canvas, all_positions);
                    return all_positions;
                } else {
                    ArrayList<ArrayList<Point>> locations1 = locations.get(1);
                    for (ArrayList<Point> location1 : locations1) {
                        for (int i = all_positions.size() - 1; i > 0; i--) {
                            all_positions.remove(i);
                        }
                        all_positions.add(location1);

                        if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                            continue;
                        } else {
                            if (shapes == 2) {
                                claim(canvas, all_positions);
                                return all_positions;
                            } else {
                                ArrayList<ArrayList<Point>> locations2 = locations.get(2);
                                for (ArrayList<Point> location2 : locations2) {
                                    for (int i = all_positions.size() - 1; i > 1; i--) {
                                        all_positions.remove(i);
                                    }
                                    all_positions.add(location2);
                                    if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                        continue;
                                    } else {
                                        if (shapes == 3) {
                                            claim(canvas, all_positions);
                                            return all_positions;
                                        } else {
                                            ArrayList<ArrayList<Point>> locations3 = locations.get(3);
                                            for (ArrayList<Point> location3 : locations3) {
                                                for (int i = all_positions.size() - 1; i > 2; i--) {
                                                    all_positions.remove(i);
                                                }
                                                all_positions.add(location3);
                                                if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                    continue;
                                                } else {
                                                    if (shapes == 4) {
                                                        claim(canvas, all_positions);
                                                        return all_positions;
                                                    } else {
                                                        ArrayList<ArrayList<Point>> locations4 = locations.get(4);
                                                        for (ArrayList<Point> location4 : locations4) {
                                                            for (int i = all_positions.size() - 1; i > 3; i--) {
                                                                all_positions.remove(i);
                                                            }
                                                            all_positions.add(location4);
                                                            if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                continue;
                                                            } else {
                                                                if (shapes == 5) {
                                                                    claim(canvas, all_positions);
                                                                    return all_positions;
                                                                } else {
                                                                    ArrayList<ArrayList<Point>> locations5 = locations.get(5);
                                                                    for (ArrayList<Point> location5 : locations5) {
                                                                        for (int i = all_positions.size() - 1; i > 4; i--) {
                                                                            all_positions.remove(i);
                                                                        }
                                                                        all_positions.add(location5);

                                                                        if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                            continue;
                                                                        } else {
                                                                            if (shapes == 6) {
                                                                                claim(canvas, all_positions);
                                                                                return all_positions;
                                                                            } else {
                                                                                ArrayList<ArrayList<Point>> locations6 = locations.get(6);
                                                                                for (ArrayList<Point> location6 : locations6) {
                                                                                    for (int i = all_positions.size() - 1; i > 5; i--) {
                                                                                        all_positions.remove(i);
                                                                                    }
                                                                                    all_positions.add(location6);
                                                                                    if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                                        continue;
                                                                                    } else {
                                                                                        if (shapes == 7) {
                                                                                            claim(canvas, all_positions);
                                                                                            return all_positions;
                                                                                        } else {
                                                                                            ArrayList<ArrayList<Point>> locations7 = locations.get(7);
                                                                                            for (ArrayList<Point> location7 : locations7) {
                                                                                                for (int i = all_positions.size() - 1; i > 6; i--) {
                                                                                                    all_positions.remove(i);
                                                                                                }
                                                                                                all_positions.add(location7);
                                                                                                if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                                                    continue;
                                                                                                } else {
                                                                                                    if (shapes == 8) {
                                                                                                        claim(canvas, all_positions);
                                                                                                        return all_positions;
                                                                                                    } else {
                                                                                                        ArrayList<ArrayList<Point>> locations8 = locations.get(8);
                                                                                                        for (ArrayList<Point> location8 : locations8) {
                                                                                                            for (int i = all_positions.size() - 1; i > 7; i--) {
                                                                                                                all_positions.remove(i);
                                                                                                            }
                                                                                                            all_positions.add(location8);
                                                                                                            if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                                                                continue;
                                                                                                            } else {
                                                                                                                if (shapes == 9) {
                                                                                                                    claim(canvas, all_positions);
                                                                                                                    return all_positions;
                                                                                                                } else {
                                                                                                                    ArrayList<ArrayList<Point>> locations9 = locations.get(9);
                                                                                                                    for (ArrayList<Point> location9 : locations9) {
                                                                                                                        for (int i = all_positions.size() - 1; i > 8; i--) {
                                                                                                                            all_positions.remove(i);
                                                                                                                        }
                                                                                                                        all_positions.add(location9);

                                                                                                                        if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                                                                            continue;
                                                                                                                        } else {
                                                                                                                            if (shapes == 10) {
                                                                                                                                claim(canvas, all_positions);
                                                                                                                                return all_positions;
                                                                                                                            } else {
                                                                                                                                ArrayList<ArrayList<Point>> locations10 = locations.get(10);
                                                                                                                                for (ArrayList<Point> location10 : locations10) {
                                                                                                                                    for (int i = all_positions.size() - 1; i > 9; i--) {
                                                                                                                                        all_positions.remove(i);
                                                                                                                                    }
                                                                                                                                    all_positions.add(location10);
                                                                                                                                    if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                                                                                        continue;
                                                                                                                                    } else {
                                                                                                                                        if (shapes == 11) {
                                                                                                                                            claim(canvas, all_positions);
                                                                                                                                            return all_positions;
                                                                                                                                        } else {
                                                                                                                                            ArrayList<ArrayList<Point>> locations11 = locations.get(11);
                                                                                                                                            for (ArrayList<Point> location11 : locations11) {
                                                                                                                                                for (int i = all_positions.size() - 1; i > 10; i--) {
                                                                                                                                                    all_positions.remove(i);
                                                                                                                                                }
                                                                                                                                                all_positions.add(location11);
                                                                                                                                                if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                                                                                                    continue;
                                                                                                                                                } else {
                                                                                                                                                    if (shapes == 12) {
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
        System.out.println("NO SOLUTION FOUND");
        return all_positions;
    }

    public ArrayList<ArrayList<Point>> solve6DIAGNOSTIC(Canvas canvas) {
        data(canvas);
        Placer placer = new Placer();
        canvas.shapes = canvas.sortShapesByMass(canvas.shapes);
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
        for (ArrayList<Point> location0 : locations0) {
            test.clear();
            all_positions.clear();

            all_positions.add(location0);
            test.add("location0");
            System.out.println(test.toString());
            if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                continue;
            } else {
                if (shapes == 1) {
                    claim(canvas, all_positions);
                    System.out.println(comparisons);
                    return all_positions;
                } else {
                    ArrayList<ArrayList<Point>> locations1 = locations.get(1);
                    for (ArrayList<Point> location1 : locations1) {
                        for (int i = all_positions.size() - 1; i > 0; i--) {
                            all_positions.remove(i);
                            test.remove(i);
                        }
                        all_positions.add(location1);
                        test.add("location1");
                        System.out.println(test.toString());
                        System.out.print(comparisons);
                        comparisons += 1;

                        if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                            continue;
                        } else {
                            if (shapes == 2) {
                                claim(canvas, all_positions);
                                System.out.println(comparisons);
                                return all_positions;
                            } else {
                                ArrayList<ArrayList<Point>> locations2 = locations.get(2);
                                for (ArrayList<Point> location2 : locations2) {
                                    for (int i = all_positions.size() - 1; i > 1; i--) {
                                        all_positions.remove(i);
                                        test.remove(i);
                                    }
                                    all_positions.add(location2);
                                    test.add("location2");
                                    System.out.println(test.toString());
                                    System.out.print(comparisons);
                                    comparisons += 1;
                                    if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                        continue;
                                    } else {
                                        if (shapes == 3) {
                                            claim(canvas, all_positions);
                                            System.out.println(comparisons);
                                            return all_positions;
                                        } else {
                                            ArrayList<ArrayList<Point>> locations3 = locations.get(3);
                                            for (ArrayList<Point> location3 : locations3) {
                                                for (int i = all_positions.size() - 1; i > 2; i--) {
                                                    all_positions.remove(i);
                                                    test.remove(i);
                                                }
                                                all_positions.add(location3);
                                                test.add("location3");
                                                System.out.println(test.toString());
                                                System.out.print(comparisons);
                                                comparisons += 1;
                                                if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                    continue;
                                                } else {
                                                    if (shapes == 4) {
                                                        claim(canvas, all_positions);
                                                        System.out.println(comparisons);
                                                        return all_positions;
                                                    } else {
                                                        ArrayList<ArrayList<Point>> locations4 = locations.get(4);
                                                        for (ArrayList<Point> location4 : locations4) {
                                                            for (int i = all_positions.size() - 1; i > 3; i--) {
                                                                all_positions.remove(i);
                                                                test.remove(i);
                                                            }
                                                            all_positions.add(location4);
                                                            test.add("location4");
                                                            System.out.println(test.toString());
                                                            System.out.print(comparisons);
                                                            comparisons += 1;
                                                            if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                continue;
                                                            } else {
                                                                if (shapes == 5) {
                                                                    claim(canvas, all_positions);
                                                                    System.out.println(comparisons);
                                                                    return all_positions;
                                                                } else {
                                                                    ArrayList<ArrayList<Point>> locations5 = locations.get(5);
                                                                    for (ArrayList<Point> location5 : locations5) {
                                                                        for (int i = all_positions.size() - 1; i > 4; i--) {
                                                                            all_positions.remove(i);
                                                                            test.remove(i);
                                                                        }
                                                                        all_positions.add(location5);
                                                                        test.add("location5");
                                                                        System.out.println(test.toString());
                                                                        System.out.print(comparisons);
                                                                        comparisons += 1;

                                                                        if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                            continue;
                                                                        } else {
                                                                            if (shapes == 6) {
                                                                                claim(canvas, all_positions);
                                                                                System.out.println(comparisons);
                                                                                return all_positions;
                                                                            } else {
                                                                                ArrayList<ArrayList<Point>> locations6 = locations.get(6);
                                                                                for (ArrayList<Point> location6 : locations6) {
                                                                                    for (int i = all_positions.size() - 1; i > 5; i--) {
                                                                                        all_positions.remove(i);
                                                                                        test.remove(i);
                                                                                    }
                                                                                    all_positions.add(location6);
                                                                                    test.add("location6");
                                                                                    System.out.println(test.toString());
                                                                                    System.out.print(comparisons);
                                                                                    comparisons += 1;
                                                                                    if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                                        continue;
                                                                                    } else {
                                                                                        if (shapes == 7) {
                                                                                            claim(canvas, all_positions);
                                                                                            System.out.println(comparisons);
                                                                                            return all_positions;
                                                                                        } else {
                                                                                            ArrayList<ArrayList<Point>> locations7 = locations.get(7);
                                                                                            for (ArrayList<Point> location7 : locations7) {
                                                                                                for (int i = all_positions.size() - 1; i > 6; i--) {
                                                                                                    all_positions.remove(i);
                                                                                                    test.remove(i);
                                                                                                }
                                                                                                all_positions.add(location7);
                                                                                                test.add("location7");
                                                                                                System.out.println(test.toString());
                                                                                                System.out.print(comparisons);
                                                                                                comparisons += 1;
                                                                                                if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                                                    continue;
                                                                                                } else {
                                                                                                    if (shapes == 8) {
                                                                                                        claim(canvas, all_positions);
                                                                                                        System.out.println(comparisons);
                                                                                                        return all_positions;
                                                                                                    } else {
                                                                                                        ArrayList<ArrayList<Point>> locations8 = locations.get(8);
                                                                                                        for (ArrayList<Point> location8 : locations8) {
                                                                                                            for (int i = all_positions.size() - 1; i > 7; i--) {
                                                                                                                all_positions.remove(i);
                                                                                                                test.remove(i);
                                                                                                            }
                                                                                                            all_positions.add(location8);
                                                                                                            test.add("location8");
                                                                                                            System.out.println(test.toString());
                                                                                                            System.out.print(comparisons);
                                                                                                            comparisons += 1;
                                                                                                            if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                                                                continue;
                                                                                                            } else {
                                                                                                                if (shapes == 9) {
                                                                                                                    claim(canvas, all_positions);
                                                                                                                    System.out.println(comparisons);
                                                                                                                    return all_positions;
                                                                                                                } else {
                                                                                                                    ArrayList<ArrayList<Point>> locations9 = locations.get(9);
                                                                                                                    for (ArrayList<Point> location9 : locations9) {
                                                                                                                        for (int i = all_positions.size() - 1; i > 8; i--) {
                                                                                                                            all_positions.remove(i);
                                                                                                                            test.remove(i);
                                                                                                                        }
                                                                                                                        all_positions.add(location9);
                                                                                                                        test.add("location9");
                                                                                                                        System.out.println(test.toString());
                                                                                                                        System.out.print(comparisons);
                                                                                                                        comparisons += 1;

                                                                                                                        if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                                                                            continue;
                                                                                                                        } else {
                                                                                                                            if (shapes == 10) {
                                                                                                                                claim(canvas, all_positions);
                                                                                                                                System.out.println(comparisons);
                                                                                                                                return all_positions;
                                                                                                                            } else {
                                                                                                                                ArrayList<ArrayList<Point>> locations10 = locations.get(10);
                                                                                                                                for (ArrayList<Point> location10 : locations10) {
                                                                                                                                    for (int i = all_positions.size() - 1; i > 9; i--) {
                                                                                                                                        all_positions.remove(i);
                                                                                                                                        test.remove(i);
                                                                                                                                    }
                                                                                                                                    all_positions.add(location10);
                                                                                                                                    test.add("location10");
                                                                                                                                    System.out.println(test.toString());
                                                                                                                                    System.out.print(comparisons);
                                                                                                                                    comparisons += 1;

                                                                                                                                    if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
                                                                                                                                        continue;
                                                                                                                                    } else {
                                                                                                                                        if (shapes == 11) {
                                                                                                                                            claim(canvas, all_positions);
                                                                                                                                            System.out.println(comparisons);
                                                                                                                                            return all_positions;
                                                                                                                                        } else {
                                                                                                                                            ArrayList<ArrayList<Point>> locations11 = locations.get(11);
                                                                                                                                            for (ArrayList<Point> location11 : locations11) {
                                                                                                                                                for (int i = all_positions.size() - 1; i > 10; i--) {
                                                                                                                                                    all_positions.remove(i);
                                                                                                                                                    test.remove(i);
                                                                                                                                                }
                                                                                                                                                all_positions.add(location11);
                                                                                                                                                test.add("location11");
                                                                                                                                                System.out.println(test.toString());
                                                                                                                                                System.out.print(comparisons);
                                                                                                                                                comparisons += 1;

                                                                                                                                                if (collisions(all_positions) || futilityTest(canvas, all_positions)) {
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

    public ArrayList<ArrayList<Point>> findVoidSpaces(Canvas canvas, ArrayList<ArrayList<Point>> all_positions) {
        ArrayList<Point> voids = new ArrayList<>();
        for (Point canvas_point : canvas.points) {
            boolean check = false;
            for (ArrayList<Point> shape : all_positions) {
                for (Point taken : shape) {
                    if (taken.toString().equals(canvas_point.toString())) {
                        check = true;
                        break;
                    }
                }
                if (check == true) {
                    break;
                }
            }
            if (check == false) {
                voids.add(canvas_point);
            }
        }

        Sorter sorter = new Sorter();

        sorter.sort(voids);
        ArrayList<ArrayList<Point>> ungroupedVoid = new ArrayList<>();
        for (Point voidPoint : voids) {
            ArrayList<Point> voidGrouping = new ArrayList<>();
            voidGrouping.add(voidPoint);
            ungroupedVoid.add(voidGrouping);
        }
        return groupVoidSpaces(ungroupedVoid);
    }

    public ArrayList<ArrayList<Point>> groupVoidSpaces(ArrayList<ArrayList<Point>> ungroupedVoid) {
        boolean ordered = true;
        for (ArrayList<Point> i : ungroupedVoid) {
            for (ArrayList<Point> j : ungroupedVoid) {
                boolean check = false;
                if (i != j) {
                    for (Point iPoint : i) {
                        for (Point jPoint : j) {
                            if (areNeighbors(iPoint, jPoint)) {
                                ordered = false;
                                check = true;
                                break;
                            } else {
                            }
                        }
                        if (check == true) {
                            break;
                        }
                    }
                    if (check == true) {
                        for (Point jPoint : j) {
                            i.add(jPoint);
                        }
                        j.clear();
                    }
                }
            }
        }

        ArrayList<ArrayList<Point>> nonEmpty = new ArrayList<>();

        for (ArrayList<Point> group : ungroupedVoid) {
            if (!group.isEmpty()) {
                nonEmpty.add(group);
            }
        }


        if (ordered == false) {
            groupVoidSpaces(nonEmpty);
        }
        return nonEmpty;
    }

    public boolean areNeighbors(Point pointA, Point pointB) {
        int x_difference = Math.abs(pointA.getX() - pointB.getX());
        int y_difference = Math.abs(pointA.getY() - pointB.getY());
        int z_difference = Math.abs(pointA.getZ() - pointB.getZ());

        if (x_difference + y_difference + z_difference > 1) {
            return false;
        }
        return true;
    }


    public ArrayList<Shape> convertPointsToShapesNoPermutations(ArrayList<ArrayList<Point>> points) {
        ArrayList<Shape> shapes = new ArrayList<>();
        Sorter sorter = new Sorter();
        if (!points.isEmpty()) {
            for (int i = 0; i < points.size(); i++) {
                if (!points.get(i).isEmpty()) {
                    Shape shape = new Shape(sorter.sort(points.get(i)));
                    shape.setColor(shape.createColor());
                    shapes.add(shape);
                }
            }
        }
        return shapes;
    }

    public boolean futilityTestOLD(Canvas canvas, ArrayList<ArrayList<Point>> all_positions) {
        ArrayList<Shape> voids = convertPointsToShapesNoPermutations(findVoidSpaces(canvas, all_positions));
        if (!voids.isEmpty()) {


            Shape smallest_shape = canvas.shapes.get(canvas.shapes.size() - 1);
            Shape smallest_void = voids.get(voids.size() - 1);

            if (smallest_void.points.size() < smallest_shape.points.size()) {
                return true;
            }
        }
        return false;
    }

    //WE HAVE NOT COCNSIDERED VOIDS THAT SHARE THE SAME MASS
    //IF VOIDS SHARE THE SAME MASS WE COULD BE RETURNING A FAILURE WHEN NONE SUCH EXISTS
    public boolean futilityTestNONOPTIMAL(Canvas canvas, ArrayList<ArrayList<Point>> all_positions) {
        ArrayList<Shape> voids = convertPointsToShapesNoPermutations(findVoidSpaces(canvas, all_positions));
        if (!voids.isEmpty()) {
            int leftover_shape_count = canvas.shapes.size() - all_positions.size();
            if (leftover_shape_count >= voids.size()) { //CHANGE THIS CONDITION: IF == THEN WE NEED TO FIND A CORROSPONDING SHAPE FOR EACH VOID

            } else {
                return true;
            }
            for (int i = 0; i < voids.size() - 1; i++) {
                int void_size = voids.get(voids.size() - 1 - i).points.size();
                    int shape_size = canvas.shapes.get(canvas.shapes.size() - 1 - i).points.size();
                    if (void_size < shape_size) {
                        return true;
                    } else if (void_size == shape_size){
                        voids.get(voids.size() - 1 - i).points = voids.get(voids.size() - 1 - i).shrink();
                        for (int j = i; j < voids.size() - 1; j++) {
                            if (canvas.shapes.get(canvas.shapes.size() - 1 - j).points.size() == shape_size){
                                if (!isPermutation(canvas.shapes.get(canvas.shapes.size() - 1 - j), voids.get(voids.size() - 1 - i).points)){
                                    return true;
                                }
                            } else {
                                break;
                            }
                        }
                        return false;
                    }
                }
            }
            return false;
        }

        public boolean futilityTest1(Canvas canvas, ArrayList<ArrayList<Point>> all_positions) {
        ArrayList<Shape> voids = convertPointsToShapesNoPermutations(findVoidSpaces(canvas, all_positions));
        if (!voids.isEmpty()) {
            int leftover_shape_count = canvas.shapes.size() - all_positions.size();
            if (leftover_shape_count >= voids.size()) {
                for (int i = 0; i < voids.size(); i++) { //ORIGINALLY voids.size() - 1
                    int void_size = voids.get(voids.size() - 1 - i).points.size();
                    int shape_size = canvas.shapes.get(canvas.shapes.size() - 1 - i).points.size();
                    if (void_size < shape_size) {
                        return true;
                    }
                }
            } else {
                return true;
            }
        }
        return false;
        }

        public boolean futilityTest2(Canvas canvas, ArrayList<ArrayList<Point>> all_positions) {
            ArrayList<Shape> voids = convertPointsToShapesNoPermutations(findVoidSpaces(canvas, all_positions));
            if (!voids.isEmpty()) {
                int leftover_shape_count = canvas.shapes.size() - all_positions.size();
                if (leftover_shape_count > voids.size()) {
                    System.out.println("SHAPES > VOIDS");
                    for (int i = 0; i < voids.size(); i++) {
                        System.out.println("SHAPES: " + canvas.shapes.size());
                        System.out.println("LEFTOVER SHAPES: " + leftover_shape_count);
                        System.out.println("VOIDS: " + voids.size());
                        System.out.println("CHECKING SHAPES @ " + (canvas.shapes.size() - 1 - i));
                        System.out.println("CHECKING VOIDS @ " + (voids.size() - 1 - i));
                        System.out.println("Void" + voids.get(voids.size() - 1 - i).points);
                        System.out.println("Shape" + canvas.shapes.get(canvas.shapes.size() - 1 - i).points);
                        int void_size = voids.get(voids.size() - 1 - i).points.size();
                        int shape_size = canvas.shapes.get(canvas.shapes.size() - 1 - i).points.size();
                        if (void_size < shape_size) {
                            System.out.println("FAIL");
                            return true;
                        }
                    }
                    System.out.println("PASS");
                } else if (leftover_shape_count == voids.size()){
                    System.out.println("SHAPES = VOIDS");
                    for (int i = 0; i < voids.size(); i++) {
                        System.out.println("SHAPES: " + canvas.shapes.size());
                        System.out.println("LEFTOVER SHAPES: " + leftover_shape_count);
                        System.out.println("VOIDS: " + voids.size());
                        System.out.println("CHECKING SHAPES @ " + (canvas.shapes.size() - 1 - i));
                        System.out.println("CHECKING VOIDS @ " + (voids.size() - 1 - i));
                        System.out.println("Void" + voids.get(voids.size() - 1 - i).points);
                        System.out.println("Shape" + canvas.shapes.get(canvas.shapes.size() - 1 - i).points);
                        if (canvas.shapes.get(canvas.shapes.size() - 1 - i).points.size() != voids.get(voids.size() - 1 - i).points.size()){
                            System.out.println("NOT A MATCH");
                            return true;
                        }
                        System.out.println("MATCH");
                    }
                } else {
                    return true;
                }
            }
            return false;
        }

    public boolean futilityTest(Canvas canvas, ArrayList<ArrayList<Point>> all_positions) {
        ArrayList<Shape> voids = convertPointsToShapesNoPermutations(findVoidSpaces(canvas, all_positions));
        if (!voids.isEmpty()) {
            int leftover_shape_count = canvas.shapes.size() - all_positions.size();
            if (leftover_shape_count > voids.size()) {
                for (int i = 0; i < voids.size(); i++) {
                    int void_size = voids.get(voids.size() - 1 - i).points.size();
                    int shape_size = canvas.shapes.get(canvas.shapes.size() - 1 - i).points.size();
                    if (void_size < shape_size) {
                        return true;
                    } else if (void_size == shape_size && (shape_size != 1 && shape_size !=2)){
                        System.out.println("Equal Case");
                        boolean check = false;
                        for (int voidJ = i; voidJ < voids.size(); voidJ++) {
                            if (voids.get(voids.size() - 1 - voidJ).points.size() == shape_size) {
                                voids.get(voids.size() - 1 - voidJ).points = voids.get(voids.size() - 1 - voidJ).shrink();
                                for (int shapeJ = i; shapeJ < voids.size(); shapeJ++) {
                                    if (canvas.shapes.get(canvas.shapes.size() - 1 - shapeJ).points.size() == shape_size) {
                                        System.out.println("COMPARING @ SHAPE SIZE: " + shape_size);
                                        System.out.println("SHAPE: " + canvas.shapes.get(canvas.shapes.size() - 1 - shapeJ).points);
                                        System.out.println("VOIDS: " + voids.get(voids.size() - 1 - voidJ).points);
                                        if (!isPermutation(canvas.shapes.get(canvas.shapes.size() - 1 - shapeJ), voids.get(voids.size() - 1 - voidJ).points)) {

                                        } else {
                                            System.out.println("COULD FIT");
                                            check = true;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                            if (check) {
                                return false;
                            } else {
                                return true;
                            }
                        }
                    }
                }
            } else if (leftover_shape_count == voids.size()){
                for (int i = 0; i < voids.size(); i++) {
                    if (canvas.shapes.get(canvas.shapes.size() - 1 - i).points.size() != voids.get(voids.size() - 1 - i).points.size()){
                        return true;
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean isPermutation(Shape shape, ArrayList<Point> points){
        for(Shape permutation: shape.permutations){
            if(permutation.points.toString().equals(points.toString())){
                return true;
            }
        }
        return false;
    }

    public boolean futilityTestBusted(Canvas canvas, ArrayList<ArrayList<Point>> all_positions) {
        System.out.println("NEW FUTILITY TEST");
        ArrayList<Shape> voids = convertPointsToShapesNoPermutations(findVoidSpaces(canvas, all_positions));
        if (!voids.isEmpty()) {
            int leftover_shape_count = canvas.shapes.size() - all_positions.size();
            if (leftover_shape_count >= voids.size()) { //CHANGE THIS CONDITION: IF == THEN WE NEED TO FIND A CORROSPONDING SHAPE FOR EACH VOID

            } else {
                return true;
            }
            for (int i = 0; i < voids.size() - 1; i++) {
                int void_size = voids.get(voids.size() - 1 - i).points.size();
                int shape_size = canvas.shapes.get(canvas.shapes.size() - 1 - i).points.size();
                if (void_size < shape_size) {
                    return true;
                } else if (void_size == shape_size && (shape_size != 1 && shape_size !=2)){
                    boolean check = false;
                    for (int voidJ = i; voidJ < voids.size() - 1; voidJ++) {
                        if (voids.get(voids.size() - 1 - voidJ).points.size() == shape_size){
                            voids.get(voids.size() - 1 - voidJ).points = voids.get(voids.size() - 1 - voidJ).shrink();
                            for (int shapeJ = i; shapeJ < voids.size() - 1; shapeJ++) {
                                if (canvas.shapes.get(canvas.shapes.size() - 1 - shapeJ).points.size() == shape_size){
                                    System.out.println("COMPARING @ SHAPE SIZE: " + shape_size);
                                    System.out.println("SHAPE: " + canvas.shapes.get(canvas.shapes.size() - 1 - shapeJ).points);
                                    System.out.println("VOIDS: " + voids.get(voids.size() - 1 - voidJ).points);
                                    if (!isPermutation(canvas.shapes.get(canvas.shapes.size() - 1 - shapeJ), voids.get(voids.size() - 1 - voidJ).points)){

                                    } else {
                                        System.out.println("COULD FIT");
                                        check = true;
                                    }
                                } else {
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                        if(check){
                            return false;
                        } else {
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }
}