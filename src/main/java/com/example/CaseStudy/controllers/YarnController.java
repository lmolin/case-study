package com.example.CaseStudy.controllers;

import com.example.CaseStudy.models.Yarn;
import com.example.CaseStudy.services.YarnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class YarnController {

    @Autowired
    YarnService ys;

    @ModelAttribute("yarn")
    public Yarn initYarn(){return new Yarn();}

    //go to stash
    @GetMapping("/stash/yarn")
    public String yarnStash() {
        return "stash";
    }

    //create new yarn
    @GetMapping("/stash/newyarn")
    public String newYarn() {
        return "newyarn";
    }
}
