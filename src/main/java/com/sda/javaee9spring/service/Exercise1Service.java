package com.sda.javaee9spring.service;

import org.springframework.stereotype.Service;

@Service
public class Exercise1Service {

    public Double metricsToImperialsHeight(Double height) {
        return height * 0.39d;
    }
    public Double metricsToImperialsWeight(Double weight) {
        return weight * 2.2d;
    }
}
