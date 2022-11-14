package ru.mpei.prob.repositories.postgres;

import org.springframework.stereotype.Repository;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.ConductingEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ConductingEquipmentRepo extends JpaRepository<ConductingEquipment,String> {

}
