package com.sda.javaee9spring.homework.car;

import org.springframework.stereotype.Component;

@Component
public record Engine(EngineHead engineHead, EngineBody engineBody) { }