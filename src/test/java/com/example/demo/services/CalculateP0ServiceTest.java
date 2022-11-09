package com.example.demo.services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@SpringBootTest
class CalculateP0ServiceTest {

    private final CalculateP0Service p0Service;

    CalculateP0ServiceTest(CalculateP0Service p0Service) {
        this.p0Service = p0Service;
    }



}