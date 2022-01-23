package com.sda.javaee9spring.controller;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
//@Value
public class FirstController {
//    The same as @Slf4j annotation above.
//    private static final Logger log = LoggerFactory.getLogger(FirstController.class);
    @GetMapping({"/my-first-page", "/"})
    public String firstPage() {
        log.info("firstPage() method called!!!");
//        looking for html page inside resources/templates
//        Spring please use page: resources/templates/home-page.html
        return "home-page";
    }
    @GetMapping("/my-second-page")
    public String secondPage() {
        log.info("secondPage() method called!");
        return "second-page";
    }

//    @GetMapping("/third-page")
    @GetMapping(value ={"/third-page", "third-too"})
    public String thirdPage() {
        log.info("thirdPage() method called!");
        return "pages/third-page";
    }

//    /my-name?name=richard&surname=tarassov
//    name param with value richard
//    surname param with value tarassov
    @GetMapping("/my-name")
    public String myName(@RequestParam(value = "name", defaultValue = "Richard") String myName,
                         @RequestParam(value = "surname", defaultValue = "Tarassov") String mySurname) {
        log.info("myName() called");
        log.info("my name is: [{}] and my surname is: [{}]", myName, mySurname);
//        log.info(String.format("my name is: [%s] and my surname is: [%s]", myName, mySurname));

        return "";
    }
}
