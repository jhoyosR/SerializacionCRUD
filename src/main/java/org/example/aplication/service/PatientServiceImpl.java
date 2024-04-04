package org.example.aplication.service;

import org.example.domain.Patient;
import org.example.interfaces.PatientRepository;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }


    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(int id) {
        return patientRepository.findById(id);
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void update(Patient patient) {
        patientRepository.update(patient);
    }

    @Override
    public void delete(int id) {
        patientRepository.delete(id);
    }
}
