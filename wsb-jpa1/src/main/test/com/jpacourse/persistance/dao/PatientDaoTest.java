package com.jpacourse.persistence.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.repository.PatientRepository;
import com.jpacourse.persistence.repository.VisitRepository;

@DataJpaTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    /**
     * Test dodawania nowej wizyty do pacjenta.
     */
    @Test
    @Transactional
    public void testAddVisit() {
        // Przygotowanie danych
        Long patientId = 1L; // Założenie: PatientEntity o ID=1 istnieje w data.sql
        String doctorName = "Dr. Andrzej Nowicki";
        LocalDateTime visitDate = LocalDateTime.now();

        // Dodanie wizyty
        patientDao.addVisit(patientId, doctorName, visitDate, "Kontrola kardiologiczna");

        // Pobranie pacjenta i weryfikacja wizyty
        PatientEntity patient = patientRepository.findById(patientId).orElse(null);
        assertNotNull(patient, "Pacjent powinien istnieć.");
        List<VisitEntity> visits = patient.getVisits();
        assertEquals(1, visits.size(), "Pacjent powinien mieć jedną wizytę.");
        VisitEntity visit = visits.get(0);
        assertEquals(doctorName, visit.getDoctorName());
        assertEquals(visitDate, visit.getVisitDate());
    }

    /**
     * Test usuwania pacjenta i sprawdzenia kaskadowego usuwania wizyt.
     */
    @Test
    @Transactional
    public void testDeletePatientWithCascade() {
        // Przygotowanie danych
        Long patientId = 1L; // Założenie: PatientEntity o ID=1 istnieje w data.sql

        // Sprawdzenie początkowej liczby wizyt
        List<VisitEntity> visitsBefore = visitRepository.findAll();
        assertFalse(visitsBefore.isEmpty(), "Wizyty powinny istnieć przed usunięciem pacjenta.");

        // Usunięcie pacjenta
        patientRepository.deleteById(patientId);

        // Weryfikacja
        assertFalse(patientRepository.findById(patientId).isPresent(), "Pacjent powinien być usunięty.");
        List<VisitEntity> visitsAfter = visitRepository.findAll();
        assertTrue(visitsAfter.isEmpty(), "Wszystkie wizyty powiązane z pacjentem powinny zostać usunięte.");
    }

    /**
     * Test weryfikacji poprawności danych pacjenta, w tym dodatkowego pola `age`.
     */
    @Test
    @Transactional
    public void testRetrievePatientById() {
        // Przygotowanie danych
        Long patientId = 1L; // Założenie: PatientEntity o ID=1 istnieje w data.sql

        // Pobranie pacjenta
        PatientEntity patient = patientRepository.findById(patientId).orElse(null);
        assertNotNull(patient, "Pacjent powinien istnieć.");
        assertEquals("Jan", patient.getFirstName(), "Imię pacjenta powinno być 'Jan'.");
        assertEquals(43, patient.getAge(), "Wiek pacjenta powinien wynosić 43.");
        assertNotNull(patient.getVisits(), "Lista wizyt powinna być zainicjowana.");
    }
}
