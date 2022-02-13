package com.sda.javaee9spring.homework.car;

import org.springframework.stereotype.Component;

@Component
public record Car(Wheel wheel1, Wheel wheel2, Wheel wheel3, Wheel wheel4,
                  CarBody carBody, Engine engine) { }