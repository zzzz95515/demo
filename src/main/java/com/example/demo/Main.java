package com.example.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {

        LocalDate date1 = LocalDate.parse("01/02/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        LocalDate date2 = LocalDate.parse("01/08/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        long integer =  ChronoUnit.DAYS.between(date1, date2);
        System.out.println(ChronoUnit.DAYS.between(date2, date1));


    }
}
