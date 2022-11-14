package ru.mpei.prob.repository;


import ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;
import ru.mpei.ltdb.model.Library.Tables.CapexOpex.*;

import java.util.Collection;
import java.util.List;

public interface IdimRepository {

    void persistObject(Object obj);

    Boolean isModelExist(String projectID);

    String saveCim(Collection<Object> model);

    String saveIdentifiedObjects(Collection<IdentifiedObject> model);

    Collection<IdentifiedObject> getInitialModel(String projectID);

    Collection<Object> getFullCimModel(String projectID, Integer synthesizedSchemeNumber);

    boolean deleteModel(Collection objects);

    Object getOneObject(String mRID, String projectID, Integer synthesizedSchemeNumber);

    List<Integer> getAllSynthesizedSchemeNumber(String projectID);

}
