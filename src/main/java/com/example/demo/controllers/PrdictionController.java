package com.example.demo.controllers;


import com.example.demo.entity.postgres.EquipmentEnt;
import com.example.demo.entity.postgres.ProbabilityEnt;
import com.example.demo.repositories.postgres.EquipTypeRepo;
import com.example.demo.repositories.postgres.EquipmentRepo;
import com.example.demo.repositories.postgres.ProbabilityRepo;
import com.example.demo.services.CalculateAlphaService;
import com.example.demo.services.CalculateP0Service;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Pong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class PrdictionController {

    private final CalculateP0Service p0Service;

    private final EquipmentRepo equipmentRepo;

    private final EquipTypeRepo equipTypeRepo;

    private final ProbabilityRepo probabilityRepo;

    private final CalculateAlphaService alphaService;





    public PrdictionController(CalculateP0Service p0Service, EquipmentRepo equipmentRepo, EquipTypeRepo equipTypeRepo, ProbabilityRepo probabilityRepo, CalculateAlphaService alphaService) {
        this.p0Service = p0Service;
        this.equipmentRepo = equipmentRepo;
        this.equipTypeRepo = equipTypeRepo;
        this.probabilityRepo = probabilityRepo;
        this.alphaService = alphaService;
    }

    @GetMapping("/calcP0")
    public Map<Long,Double> calculateP0(@RequestParam("id_Date_Map") Map<Long, LocalDate> idDateMap, @RequestParam("var") Integer var){
        Set<Long> id_list = idDateMap.keySet();
        Map<Long,Double> map = new HashMap<>();
        for (Long id:id_list){
            Double p0= p0Service.calculateP0(id,idDateMap.get(id),var);
            map.put(id,p0);
        }
        return map;
    }

    @GetMapping("/calcPForReal")
    public String predict(@RequestParam("equip_id") List<Long> equip_id, @RequestParam("date")LocalDate date){
        for (Long i:equip_id){
            p0Service.calcPForEquipment(i,date);
        }
        String status="ok";
        return status;
    }

    @GetMapping("/predict/first")
    public Map<Long,Map<LocalDate,Double>> predictP( @RequestParam("equip_id") List<Long> equip_id,@RequestParam("date") LocalDate dateTime){

        Map<Long,Map<LocalDate,Double>> resultMap = new HashMap<>();
        for (Long id:equip_id){
            Map<LocalDate, Double> calculatedMap = p0Service.calculateP0ForPredicted(id,dateTime);
            resultMap.put(id,calculatedMap);
        }
        return resultMap;
    }

    @GetMapping("/predict/second")
    public Map<Long,Map<LocalDate,Double>> predictPsecond( @RequestParam("map") Map<Long,LocalDate> equip_date_map,@RequestParam("var") Long var){

        Map<Long,Map<LocalDate,Double>> resultMap = new HashMap<>();
//        for (Long id:equip_id){
//            Map<LocalDate, Double> calculatedMap = p0Service.calculateP0ForPredicted(id,dateTime);
//            resultMap.put(id,calculatedMap);
//        }
        return resultMap;
    }
}
