package com.sda.javaee9spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class FirstController {
//    The same as @Slf4j annotation above.
//    private static final Logger log = LoggerFactory.getLogger(FirstController.class);
    @GetMapping("/my-first-page")
    public String firstPage() {
        log.info("firstPage() method called!!!");
//        looking for html page inside resources/templates
        return "home-page";
    }
}
