package ru.mpei.prob.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.*;
import ru.mpei.prob.model.CIMProfile.NTI.CimClassName;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository @Transactional @Slf4j
public class IdimRepositoryImpl implements IdimRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public Boolean isModelExist(String projectID) {
        Query query = em.createQuery("SELECT  o.projectID FROM IdentifiedObject o WHERE o.projectID = :projectid");
        query.setParameter("projectid",projectID)
                .setMaxResults(1);

        return (!query.getResultList().isEmpty());
    }

    @Override
    public String saveCim(Collection<Object> objects) {
        // do not use transactional operations. @Transactional will make it for you
        if (objects == null
                || objects.isEmpty()
                || em == null) {
            System.out.println();
        }
        objects.forEach(el -> em.persist(el));

        if (objects.isEmpty()) {
            log.error("Передаваемая коллекция объектов пустая");
            return "something";
        } else {
            log.info("CIM модель сохранена в БД");
            return null;
        }
    }

    @Override
    public void persistObject(Object obj) {
        em.persist(obj);
    }

    @Override
    public String saveIdentifiedObjects(Collection<IdentifiedObject> objects) {
        // do not use transactional operations. @Transactional will make it for you
        if (objects == null
                || objects.isEmpty()
                || em==null){
            System.out.println();
        }
        objects.forEach(el -> em.persist(el));
        if (objects.isEmpty()){
            log.error("Передаваемая коллекция объектов пустая");
            return "something";
        } else {
            log.info("CIM модель сохранена в БД");
            return null;
        }
    }

    @Override
    public Collection<IdentifiedObject> getInitialModel(String projectID) {
        Query query = em.createQuery("SELECT DISTINCT (o.className) FROM IdentifiedObject o " +
                "WHERE o.projectID = :projectid AND o.synthesizedSchemeNumber = 0 " +
                "AND o.schemaScenarioNumber = 0 ORDER BY o.className");
        query.setParameter("projectid",projectID);
        List<CimClassName> classNames = query.getResultList();
        Collection<IdentifiedObject> objects = new ArrayList<>();

        query.setParameter("projectid",projectID);
        for (CimClassName className: classNames){
            if (className == null){
                log.error("В таблице IdentifiedObject не все объекты имеют значение в столбце classname");
            }
            query = em.createQuery("SELECT o FROM " + className.toString() + " o WHERE o.projectID = :projectid" +
                    " AND o.synthesizedSchemeNumber = 0 AND o.schemaScenarioNumber = 0");
            query.setParameter("projectid",projectID);
            objects.addAll(query.getResultList());
        }
        return objects;
    }

    @Override
    public Collection<Object> getFullCimModel(String projectID, Integer synthesizedSchemeNumber) {
        Query query = em.createQuery("SELECT DISTINCT (o.className) FROM IdentifiedObject o" +
                " WHERE o.projectID = :projectID " +
                "AND o.synthesizedSchemeNumber = :synthesizedSchemeNumber " +
                "ORDER BY o.className")
                .setParameter("projectID",projectID)
                .setParameter("synthesizedSchemeNumber", synthesizedSchemeNumber);
        List<CimClassName> classNames = query.getResultList();
        Collection<Object> objects = new ArrayList<>();

        if (classNames.size() == 0) log.error("Could not find model with projectID = " + projectID + " " +
                "and synthesizedSchemeNumber = " + synthesizedSchemeNumber);

        for (CimClassName className: classNames){
            if (className == null){
                log.error("В таблице IdentifiedObject не все объекты имеют значение в столбце classname");
                continue;
            }
            query = em.createQuery("SELECT o FROM " + className.toString() + " o " +
                    "WHERE o.projectID = :projectid " +
                    "AND o.synthesizedSchemeNumber = :synthesizedSchemeNumber");
            query.setParameter("projectid",projectID);
            query.setParameter("synthesizedSchemeNumber", synthesizedSchemeNumber);
            objects.addAll(query.getResultList());
        }
        return objects;
    }

    @Override
    public boolean deleteModel(Collection objects) {
        boolean isRemoved = false;
        for (Object o: objects){
            em.remove(o);
            if (!isRemoved) isRemoved = true;
        }
        return isRemoved;
    }

    @Override
    public Object getOneObject(String mRID, String projectID, Integer synthesizedSchemeNumber) {
        Query query = em.createQuery("SELECT o.className FROM IdentifiedObject o " +
                "WHERE o.projectID = :projectID " +
                "AND o.mRID = :mRID " +
                "AND o.synthesizedSchemeNumber = :synthesizedSchemeNumber")
                .setParameter("projectID", projectID)
                .setParameter("mRID", mRID)
                .setParameter("synthesizedSchemeNumber", synthesizedSchemeNumber);

        query = em.createQuery("SELECT o FROM " + query.getResultList().get(0) + " o " +
                "WHERE o.projectID = :projectID " +
                "AND o.mRID = :mRID " +
                "AND o.synthesizedSchemeNumber = :synthesizedSchemeNumber")
                .setParameter("projectID",projectID)
                .setParameter("synthesizedSchemeNumber",synthesizedSchemeNumber)
                .setParameter("mRID",mRID);

        return query.getResultList().get(0);
    }

    @Override
    public List<Integer> getAllSynthesizedSchemeNumber(String projectID) {
        return em.createQuery("SELECT DISTINCT (io.synthesizedSchemeNumber) FROM IdentifiedObject io " +
                "WHERE io.projectID = :projectID")
                .setParameter("projectID", projectID)
                .getResultList();
    }
}
