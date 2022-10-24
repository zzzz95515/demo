package com.example.demo;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date1 = new Date("10/12/1996");
        Date date2 = new Date("10/13/1996");

        System.out.println(date1);
        System.out.println(date2);

        System.out.println(date2.getTime()-date1.getTime());
    }
}
