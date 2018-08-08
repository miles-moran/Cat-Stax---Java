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
        ArrayList<Shape> shapes = solver.convertPointsToShapes(shape_points);
        Canvas canvas = solver.prepareCanvas(shapes);
        model.addAttribute("shapes", shapes);
        model.addAttribute("canvas", canvas);

        return "prepare";
    }


    @RequestMapping(value = "REMNAANT", method = RequestMethod.POST)
    public String processIndex2(@RequestParam String shape_count, String points, Model model){
        Solver solver = new Solver();
        ArrayList<ArrayList<Point>> shape_points = solver.convertRawString(points);
        ArrayList<Shape> shapes = solver.convertPointsToShapes(shape_points);
        Canvas canvas = solver.prepareCanvas(shapes);
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
