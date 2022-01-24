package com.sda.javaee9spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/first")
public class FirstController {

    // the same as @Slf4j
    // private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    @GetMapping({"/my-first-page", "/"})
    public String firstPage() {
        log.info("firstPage() method called!!!");
        // looking for html page inside resources/templates
        // Spring please use page: resources/templates/home-page.html
        return "home-page";
    }

    @GetMapping("/my-second-page")
    public String secondPage() {
        log.info("secondPage() method called!!!");
        //looking for html page inside resources/templates
        return "second-page";
    }

    //    @GetMapping("/third-page")
//    @GetMapping(value = "/third-page")
//    @GetMapping(value = {"/third-page"}, params = {})
    @GetMapping(value = {"/third-page", "/third-too", "/abcd"})
    public String thirdPage() {
        log.info("thirdPage() method was called!!!");
        return "pages/third-page";
    }

    // /my-name?name=mariusz&surname=pastuszka
    // name param with value mariusz
    // surname param with value pastuszka
    @GetMapping("/my-name")
    public String myName(@RequestParam(value = "name", defaultValue = "Jan") String myFirstName,
                         @RequestParam(value = "surname", defaultValue = "Kowalski") String mySurname,
                         Model pageParameters) {
        log.info("myName() method was called!!!");
        log.info("my name is: [{}] and my surname is: [{}]", myFirstName, mySurname);
        log.info(String.format("my name is: [%s] and my surname is: [%s]", myFirstName, mySurname));

        pageParameters.addAttribute("myName", myFirstName);
        pageParameters.addAttribute("mySurname", mySurname);

        return "pages/name-and-surname";
    }

    @PostMapping("/my-first-post")
    public String myFirstOtherThanGetHttpMethod() {
        log.info("myFirstOtherThanGetHttpMethod() was called");
        return "pages/post-page";
    }
}