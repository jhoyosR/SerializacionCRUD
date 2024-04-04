package org.example.aplication.service;

import org.example.domain.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAll();
    Patient findById(int id);
    void save(Patient patient);
    void update(Patient patient);
    void delete(int id);
}
