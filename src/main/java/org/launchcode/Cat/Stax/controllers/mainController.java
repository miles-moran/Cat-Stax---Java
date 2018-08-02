package org.launchcode.Cat.Stax.controllers;


import org.launchcode.Cat.Stax.technical.PuzzleForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class mainController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(){
        return "ThymeLeaf12";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processIndex(@ModelAttribute PuzzleForm form,
                                     Errors errors, Model model) {
        return "test";
    }






}
