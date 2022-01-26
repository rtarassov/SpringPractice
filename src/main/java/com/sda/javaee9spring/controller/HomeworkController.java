package com.sda.javaee9spring.controller;

import com.sda.javaee9spring.service.Exercise1Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** Exercise 1 **/
//        Prepare a program that takes three parameters:
//        - first name
//        - height in cm
//        - weight in kilograms
//        The program will convert weight to pounds and height to inches and display them on a new page.

@Controller
@Slf4j
@RequestMapping("/homework1")
public class HomeworkController {

    Exercise1Service exercise1Service;

    public HomeworkController(Exercise1Service exercise1Service) {
        this.exercise1Service = exercise1Service;
    }

    @GetMapping("/exercise1")
    public String exercise1(@RequestParam(value = "name") String myName,
                            @RequestParam(value = "height") Double myHeight,
                            @RequestParam(value = "weight") Double myWeight,
                            Model pageParameters) {

        double myHeightConverted = exercise1Service.metricsToImperialsHeight(myHeight);
        double myWeightConverted = exercise1Service.metricsToImperialsWeight(myWeight);

        pageParameters.addAttribute("name", myName);
        pageParameters.addAttribute("height", myHeight);
        pageParameters.addAttribute("weight", myWeight);

        pageParameters.addAttribute("heightConverted", myHeightConverted);
        pageParameters.addAttribute("weightConverted", myWeightConverted);

        return "/homework/exercise1";
    }

}
