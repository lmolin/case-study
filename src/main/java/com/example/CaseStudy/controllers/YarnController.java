package com.example.CaseStudy.controllers;

import com.example.CaseStudy.models.Yarn;
import com.example.CaseStudy.services.YarnService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Log
@Controller
public class YarnController {

    @Autowired
    YarnService ys;

    @ModelAttribute("yarn")
    public Yarn initYarn(){return new Yarn();}

    //go to stash
    @GetMapping("/stash/yarn")
    public String yarnStash(Model model) {
        List<Yarn> yarnList = ys.getAllYarn();
        model.addAttribute("yarnList", yarnList);
        return "stash";
    }

    //go to new yarn page
    @GetMapping("/stash/newyarn")
    public String newYarn() {
        return "newyarn";
    }

    //create new yarn
    @PostMapping("/stash/createyarn")
    public String createYarn(@ModelAttribute("yarn") Yarn yarn, BindingResult result, Model model) {

        if (result.hasErrors()) {
            log.warning("Invalid input");
            return "newyarn";
        }

        model.addAttribute("yarn", yarn);
        ys.saveYarn(yarn);
        return "redirect:../stash/yarn";
    }
}
