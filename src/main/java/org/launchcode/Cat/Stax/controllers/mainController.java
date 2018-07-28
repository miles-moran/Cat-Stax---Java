package org.launchcode.Cat.Stax.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mainController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String prepare(Model model, @RequestParam String canvas_points){
        model.addAttribute("canvas_points", canvas_points);
        return "test";
    }
}
