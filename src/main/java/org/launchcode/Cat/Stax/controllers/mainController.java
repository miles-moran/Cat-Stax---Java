package org.launchcode.Cat.Stax.controllers;


import org.launchcode.Cat.Stax.technical.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class mainController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        return "Bug12";
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processIndex(@RequestParam String points, Model model){
        Solver solver = new Solver();
        ArrayList<ArrayList<Point>> shape_points = solver.convertRawString(points);
        Canvas canvas = new Canvas(shape_points.get(0));
        Integer dimensions = canvas.dimensionTest();
        ArrayList<Shape> shapes = solver.convertPointsToShapes(shape_points, dimensions);
        canvas = solver.prepareCanvas(shapes);

        model.addAttribute("shapes", shapes);
        model.addAttribute("canvas", canvas);
        model.addAttribute("points", points);

        return "prepare";
    }
    @RequestMapping(value = "solve", method = RequestMethod.GET)
    public String solve(@RequestParam String points, Model model){
        Solver solver = new Solver();
        ArrayList<ArrayList<Point>> shape_points = solver.convertRawString(points);
        Canvas canvas = new Canvas(shape_points.get(0));
        Integer dimensions = canvas.dimensionTest();
        ArrayList<Shape> shapes = solver.convertPointsToShapes(shape_points, dimensions);
        canvas = solver.prepareCanvas(shapes);
        solver.solve(canvas);
        ArrayList<Integer> canvasOutput= canvas.ownerOutput();

        model.addAttribute("canvas", canvasOutput);

        return "solve";
    }


    @RequestMapping(value = "REMNAANT", method = RequestMethod.POST)
    public String processIndex2(@RequestParam String shape_count, String points, Model model){
        Solver solver = new Solver();
        ArrayList<ArrayList<Point>> shape_points = solver.convertRawString(points);
        Canvas canvas = new Canvas(shape_points.get(0));
        Integer dimensions = canvas.dimensionTest();
        ArrayList<Shape> shapes = solver.convertPointsToShapes(shape_points, dimensions);
        canvas = solver.prepareCanvas(shapes);
        solver.solve(canvas);
        ArrayList<Integer> occupants = new ArrayList<>();
        for(Point point: canvas.points){
            occupants.add(point.getOccupant());
        }
        model.addAttribute("shape_count", occupants);
        model.addAttribute("points", shape_points);

        return "test";
    }



}
