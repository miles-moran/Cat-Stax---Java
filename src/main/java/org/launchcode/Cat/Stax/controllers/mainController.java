package org.launchcode.Cat.Stax.controllers;


import org.aspectj.weaver.ArrayReferenceType;
import org.launchcode.Cat.Stax.technical.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class mainController {

    @Autowired
    private CatDao catDao;

    @Autowired
    private PointDao PointDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        Shape tempShape = new Shape();
        ArrayList<Cat> raw_cats = (ArrayList<Cat>) catDao.findAll();
        ArrayList<Shape> presets = new ArrayList<>();

        for(Cat cat: raw_cats){
            Shape add = new Shape();
            add = tempShape.catToShape(cat);
            add.shrink();
            presets.add(add);
        }

        model.addAttribute("presets", presets);
        return "Fourteen";
    }
    @RequestMapping(value = "prepare", method = RequestMethod.POST)
    public String processIndex(@RequestParam String points, String add, Model model){
        Solver solver = new Solver();
        Cat cat = new Cat();
        ArrayList<Point> temp = new ArrayList<>();
        temp.add(new Point(0,0,0));
        ArrayList<ArrayList<Point>> shape_points = solver.convertRawString(points);
        ArrayList<ArrayList<Point>> add_points = solver.convertRawStringADD(add);

        Canvas canvas = new Canvas(shape_points.get(0));
        Integer dimensions = canvas.dimensionTest();
        ArrayList<Shape> shapes = solver.convertPointsToShapes(shape_points, dimensions);
        ArrayList<Shape> addShapes = solver.convertPointsToShapes(add_points, 2);

        for(Shape newShape: addShapes){
            newShape.shrink();
            Cat addCat = cat.shapeToCat(newShape);
            catDao.save(addCat);
        }
        canvas = solver.prepareCanvas(shapes);
        double difficulty = solver.data(canvas);

        model.addAttribute("shapes", shapes);
        model.addAttribute("canvas", canvas);
        model.addAttribute("points", points);
        model.addAttribute("difficulty", difficulty);

        return "prepare";
    }



    @RequestMapping(value = "solveOG", method = RequestMethod.GET)
    public String solveOG(@RequestParam String points, Model model){
        Solver solver = new Solver();
        ArrayList<ArrayList<Point>> shape_points = solver.convertRawString(points);
        Canvas canvas = new Canvas(shape_points.get(0));
        Integer dimensions = canvas.dimensionTest();
        ArrayList<Shape> shapes = solver.convertPointsToShapes(shape_points, dimensions);
        canvas = solver.prepareCanvas(shapes);

        long startTime = System.currentTimeMillis();
        solver.solve4(canvas);
        long stopTime = System.currentTimeMillis();

        System.out.println("Elapsed time was " + (stopTime - startTime) + " miliseconds.");

        shapes = canvas.sortShapesByMass(shapes);
        model.addAttribute("raw", points);
        model.addAttribute("shapes", shapes);
        model.addAttribute("canvas", canvas);

        return "solve";
    }

    @RequestMapping(value = "solve", method = RequestMethod.GET)
    public String solve(@RequestParam String points, Model model){
        Solver solver = new Solver();
        ArrayList<ArrayList<Point>> shape_points = solver.convertRawString(points);
        Canvas canvas = new Canvas(shape_points.get(0));
        Integer dimensions = canvas.dimensionTest();
        ArrayList<Shape> shapes = solver.convertPointsToShapes(shape_points, dimensions);
        canvas = solver.prepareCanvas(shapes);

        long startTime = System.currentTimeMillis();
        solver.solve6DIAGNOSTIC(canvas);
        long stopTime = System.currentTimeMillis();

        long timeElapsed = (stopTime - startTime);

        System.out.println("SOLVING: Elapsed time was " +  timeElapsed + " miliseconds.");

        model.addAttribute("raw", points);
        model.addAttribute("canvas", canvas);
        model.addAttribute("elapsed",  timeElapsed);

        return "solve";
    }
}
