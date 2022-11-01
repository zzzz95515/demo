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

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<Long,Double> calculateP0(@RequestParam("id_list") List<Long> id_list,  @RequestParam("date")LocalDateTime date, @RequestParam("var") Integer var){
        Map<Long,Double> map = new HashMap<>();
        for (Long id:id_list){
            Double p0= p0Service.calculateP0(id,date,var);
            map.put(id,p0);
        }
        return map;
    }

    @GetMapping("/calcPForReal")
    public String predict(@RequestParam("equip_id") List<Long> equip_id, @RequestParam("date")LocalDateTime date){
        for (Long i:equip_id){
            p0Service.calcPForEquipment(i,date);
        }
        String status="ok";
        return status;

    }
}
