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

import java.util.Date;

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


    @GetMapping("/")
    public String predict(@RequestParam("equip_id") Long equip_id, @RequestParam("days") Integer days,@RequestParam("version") Long version){
        EquipmentEnt equip = equipmentRepo.findById(equip_id).get();
        InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086", "admin", "admin");
        Pong responce = influxDB.ping();
        if (responce.getVersion().equalsIgnoreCase("unknown")){
            Exception exception= new Exception("cannot connect to influx db");
        }
        else {
            System.out.println("connected");
        }
        if (equip!=null){
            Double p0=p0Service.calculateP0(equip,version,influxDB);
            Double betta = equip.getEquipType().getBetta();
            Double alpha =alphaService.calcAlpha(equip,version,influxDB);
            for (int i=1;i<=days;i++){
                Date predDate= new Date(equip.getLastFixionDate().getTime()+24*60*60*1000*i);
                Double prob = p0*Math.exp(-alpha*24*i)*Math.exp(-betta*24*i);
                ProbabilityEnt probabilityEnt = new ProbabilityEnt(equip,predDate,prob);
                probabilityRepo.save(probabilityEnt);
            }
        }
        String status="ok";


        return status;

    }
}
