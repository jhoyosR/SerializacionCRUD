package org.example.interfaces;

import org.example.domain.Appointment;
import org.example.domain.Patient;

import java.util.List;

public interface PatientRepository {
    List<Patient> findAll();
    Patient findById(int id);
    void save(Patient patient);
    void update(Patient patient);
    void delete(int id);
}
