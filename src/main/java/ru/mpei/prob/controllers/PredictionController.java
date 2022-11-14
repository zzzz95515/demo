package ru.mpei.prob.controllers;



import ru.mpei.prob.repositories.postgres.EquipTypeRepo;
import ru.mpei.prob.repositories.postgres.EquipmentRepo;
import ru.mpei.prob.repositories.postgres.ProbabilityRepo;
import ru.mpei.prob.services.CalculateAlphaService;
import ru.mpei.prob.services.CalculateP0Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.*;

@Controller
public class PredictionController {

    private final CalculateP0Service p0Service;

    private final EquipmentRepo equipmentRepo;

    private final EquipTypeRepo equipTypeRepo;


    public PredictionController(CalculateP0Service p0Service, EquipmentRepo equipmentRepo, EquipTypeRepo equipTypeRepo, ProbabilityRepo probabilityRepo, CalculateAlphaService alphaService) {
        this.p0Service = p0Service;
        this.equipmentRepo = equipmentRepo;
        this.equipTypeRepo = equipTypeRepo;
    }

    @GetMapping("/calcP0")
    //актуализировать на получение дельты
    public Map<String,Double> calculateP0(@RequestParam("id_Date_Map") Map<String, List<LocalDate>> idDateMap, @RequestParam("var") Integer var){
        Set<String> id_list = idDateMap.keySet();
        Map<String,Double> map = new HashMap<>();
        for (String id:id_list){
            Double p0= p0Service.calculateP0(id,idDateMap.get(id),var);
            map.put(id,p0);
        }
        return map;
    }

    @GetMapping("/calcPForReal")
    public String predict(@RequestParam("equip_id") List<String> equip_id, @RequestParam("date")LocalDate date){
        for (String i:equip_id){
            p0Service.calcPForEquipment(i,date);
        }
        String status="ok";
        return status;
    }

    @GetMapping("/predict/first")
    public Map<String,Map<LocalDate,Double>> predictP( @RequestParam("equip_id") List<String> equip_id,@RequestParam("date") LocalDate dateTime){

        Map<String,Map<LocalDate,Double>> resultMap = new HashMap<>();
        for (String id:equip_id){
            Map<LocalDate, Double> calculatedMap = p0Service.calculateP0ForPredicted(id,dateTime);
            resultMap.put(id,calculatedMap);
        }
        return resultMap;
    }

    @GetMapping("/predict/second")
    public Map<String,Map<LocalDate,Double>> predictPsecond( @RequestParam("map") Map<String,List<LocalDate>> equip_date_map,@RequestParam("var") Integer var,@RequestParam("lastDate") LocalDate dateTime){
        Map<String,Map<LocalDate,Double>> resultMap = new HashMap<>();
        Set<String> equip_id = equip_date_map.keySet();
        for (String id:equip_id){
            List<LocalDate> lastFixDate = equip_date_map.get(id);
            Map<LocalDate, Double> calculatedMap = p0Service.calculateP0ForPredictedSec(id,lastFixDate,dateTime,var);
            resultMap.put(id,calculatedMap);
        }
        return resultMap;
    }

//    @GetMapping("/testPforReal")
//    public void testP0(){
//        Long id =1l;
//        LocalDate localDate=LocalDate.parse("06/11/2017", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        Map<LocalDate,Double> result = p0Service.calculateP0ForPredicted(id,localDate);
//        List<Long> testList = new ArrayList<>();
//        testList.add(id);
//        predict(testList,localDate);
//    }

//    @GetMapping("/testP0")
//    public void testP0(){
//        Long id =1l;
//        LocalDate localDate=LocalDate.parse("17/11/2017", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        List<LocalDate> testList = new ArrayList<>();
//        testList.add(null);
//        testList.add(localDate);
//        Double result = p0Service.calculateP0(id,testList,1);
//        System.out.println(result);
//    }

//    @GetMapping("/testP0")
//    public void testPredictSecond(){
//        Long id =1l;
//        LocalDate localDate=LocalDate.parse("17/11/2017", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        LocalDate localDate1=LocalDate.parse("29/11/2017", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        List<LocalDate> testList = new ArrayList<>();
//        testList.add(localDate);
//        Map<LocalDate,Double> result = p0Service.calculateP0ForPredictedSec(id,testList,localDate1,1);
//        System.out.println(result);
//    }

}
