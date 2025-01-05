package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addVisit(Long patientId, String doctorName, LocalDateTime visitDate, String treatmentDescription) {
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        if (patient == null) {
            throw new IllegalArgumentException("Patient not found with ID: " + patientId);
        }

        VisitEntity visit = new VisitEntity();
        visit.setDoctorName(doctorName);
        visit.setVisitDate(visitDate);
        visit.setPatient(patient);
        // Dodanie prostego opisu wizyty (rozbudowa możliwa w encji Visit)
        // Można dodać logikę tworzenia treatmentów i dodawania ich do wizyty

        patient.getVisits().add(visit);
        entityManager.merge(patient);
    }

}
