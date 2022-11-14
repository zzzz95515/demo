package ru.mpei.prob.services;

import ru.mpei.prob.entity.postgres.EquipmentEnt;
import ru.mpei.prob.repositories.postgres.AlphaRepo;
import org.springframework.stereotype.Service;

@Service
public class CalculateAlphaService {
    private final AlphaRepo alphaRepo;

    private final ItsMeasurementServ itsService;


    public CalculateAlphaService(AlphaRepo alphaRepo, ItsMeasurementServ itsService) {
        this.alphaRepo = alphaRepo;
        this.itsService = itsService;
    }

    public Double calcAlpha(EquipmentEnt equipment, Long version){
//        LocalDateTime FixDate = equipment.getLastFixionDate();
//        AlphaParamsEnt params = alphaRepo.findByEquipment(equipment);
//        Double difIts= itsService.getDifferentialOfIts(equipment.getId(),equipment.getLastFixionDate());
//        Double lastIts=itsService.getLastIts(equipment.getId(),equipment.getLastFixionDate());
        Double alpha = 0.0005;
        return alpha;
    }


    public Double getAlpha(EquipmentEnt equipment) {
        return alphaRepo.findByEquipment(equipment).getAlpha();

    }
}
